package rocks.isor.eventsniff.eventsniff;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	private static Pattern GETTER_METHODS = Pattern.compile("^(get|has|is)\\w+");

	public static String generateJsonString(Object o) {
		return recursiveObjectReader(o, new HashSet<>(), null, 0);
	}

	private static String recursiveObjectReader(Object o, Set<String> parentObjects, Collection parentCollection, int depth) {

		if (o == null) {
			return "{ \"object-is-null\": true }";
		}

		Class clazz = o.getClass();

		char[] repeat = new char[depth * 2];
		Arrays.fill(repeat, '\t');
		String indent = new String(repeat);

		if (clazz.isPrimitive()) {
			return String.valueOf(o);
		} else if (clazz.equals(String.class)) {
			return "\"" + o + "\"";
		}

		String objectId = o.hashCode() + o.toString();

		if (parentObjects.contains(objectId)) {
			return "{ \"cyclic-recursion-detected\": true }";
		}

		Set<String> clonedHistory = new HashSet<>(parentObjects);
		clonedHistory.add(objectId);


		Set<String> excluded = new HashSet<>(Arrays.asList(
				"Class", // Not interested in java itself
				"File" // Files are a tree of paths, convoluting the json
		));

		String simpleName = clazz.getSimpleName();
		if (excluded.contains(simpleName)) {
			return "{ \"excluded-class-detected\": true }";
		}

		Bukkit.getLogger().finer(indent + "scanning " + simpleName);

		Method[] methods = clazz.getDeclaredMethods();
		StringBuilder json = new StringBuilder("{");

		Set<String> excludedMethods = new HashSet<>(Arrays.asList(
				"getRandom", // Causes StackOverflowException
				"getChunk", // Chunks are too big to marshal
				"getWorld", // Worlds are even bigger
				"getRegisteredListeners", // Lots of recursion
				"getHandlerLists" // 	"		"
		));

		try {
			for (Method method : methods) {
				if (method.getParameterCount() > 0) {
					continue;
				}

				int modifiers = method.getModifiers();
				if (Modifier.isPrivate(modifiers) || Modifier.isProtected(modifiers)) {
					continue;
				}

				String methodName = method.getName();
				json.append(" \"").append(methodName).append("\": ");

				Matcher matcher = GETTER_METHODS.matcher(methodName);

				if (matcher.matches()) {

					if (excludedMethods.contains(methodName)) {
						json.append("{ \"excluded-method-detected\": true }");
						continue;
					}

					Class<?> returnType = method.getReturnType();
					method.setAccessible(true);

					Bukkit.getLogger().finer(indent + "\tcalling " + methodName);
					if (returnType.isPrimitive()) {
						String result = String.valueOf(method.invoke(o));
						json.append(result);
					} else if (returnType.equals(String.class)) {
						json.append("\"").append(method.invoke(o)).append("\"");
					} else if (returnType.isArray() || Collection.class.isAssignableFrom(returnType)) {
						json.append("[");

						Collection collection;
						if (returnType.isArray()) {
							Bukkit.getLogger().finer(indent + "\t\tconverting array "+returnType.getSimpleName()+" to collection");

							Object reflectedArray = method.invoke(o);

							collection = objectToCollection(reflectedArray);
						} else {
							Bukkit.getLogger().finer(indent + "\t\tconverting "+returnType.getSimpleName()+" to collection");
							collection = (Collection) method.invoke(o);
						}

						Bukkit.getLogger().finer(indent + "\t\tlist " + (returnType.getComponentType() == null ? "null" : returnType.getComponentType().getSimpleName()));
						if (collection != null && !collection.isEmpty()) {

							if (collection.equals(parentCollection)) {
								return "{ \"cyclic-recursion-detected\": true }";
							}

							for (Object item : collection) {

								json.append(recursiveObjectReader(item, clonedHistory, collection, depth + 1));
								json.append(",");
							}
							if (json.charAt(json.length() - 1) == ',') {
								json.deleteCharAt(json.length() - 1);
							}
						}

						json.append("]");
					} else {
						Bukkit.getLogger().finer(indent + "\t\tobject " + returnType.getSimpleName());
						json.append(recursiveObjectReader(method.invoke(o), clonedHistory, parentCollection,depth + 1));
					}
				} else {
					json.append("\"no-getter\"");
				}
				json.append(",");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (StackOverflowError soe) {
			Bukkit.getLogger().warning("Unlimited recursion in " + simpleName + "\n" + soe.getMessage());
		}

		if (json.charAt(json.length() - 1) == ',') {
			json.deleteCharAt(json.length() - 1);
		}

		json.append("}");

		return json.toString();
	}

	private static Collection objectToCollection(Object o) {
		Object[] objects = new Object[Array.getLength(o)];

		for (int i = 0; i < objects.length; i++) {
			objects[i] = Array.get(o, i);
		}

		return Arrays.asList(objects);
	}


	public static String generateCoordinateString(Location location) {
		int blockX = location.getBlockX();
		int blockY = location.getBlockY();
		int blockZ = location.getBlockZ();

		return blockX + "x" + blockY + "x" + blockZ;
	}

	/**
	 * 	Regex Search & Replace Pattern to generate ALL the methods from a list of words
	 *
	 * Search:

	(\t+)(\w+)(\n)

	 *
	 * Replace:

	@EventHandler
	public void on$2($2 event) {
		this.onBlockEvent(event);
	}

	*/
}
