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

	private static Set<String> excludedClasses = new HashSet<>(Arrays.asList(
			"Class", // Not interested in java itself
			"File" // Files are a tree of paths
	));

	private static Set<String> excludedMethods = new HashSet<>(Arrays.asList(
			"hashCode",
			"getRandom", // Causes StackOverflowException
			"getChunk", // Chunks are too big to marshal
			"getWorld", // Worlds are even bigger
			"getRegisteredListeners", // Lots of recursion
			"getHandlerLists",
			"getCraftWorld"
	));

	public static String generateJsonString(Object o) {
		return generateJsonString(o, 0);
	}

	public static String generateJsonString(Object o, int recursionDepth) {
		return recursiveObjectReader(o, new HashSet<>(), null, 0, recursionDepth);
	}

	private static String recursiveObjectReader(Object o, Set<String> parentObjects, Collection parentCollection, int depth, int recursionDepth) {

		if (o == null) {
			return "null";
		}

		char[] repeat = new char[depth * 2];
		Arrays.fill(repeat, '\t');
		String indent = new String(repeat);

		Class clazz = o.getClass();
		if (clazz.isPrimitive()) {
			return String.valueOf(o);
		} else if (clazz.equals(String.class)) {
			return "\"" + o + "\"";
		}

		String simpleName = clazz.getSimpleName();
		if (excludedClasses.contains(simpleName)) {
			Bukkit.getLogger().finer(indent + "Excluded class " + simpleName);
			return "{\"--EXCLUDED CLASS--\": \""+ simpleName +"\"}";
		}

		String objectId = o.hashCode() + o.toString();
		if (parentObjects.contains(objectId)) {
			Bukkit.getLogger().finer(indent + "Cyclic Recursion detected " + simpleName);
			return "{\"--CYCLIC RECURSION--\": \""+ objectId +"\"}";
		}
		Set<String> clonedHistory = new HashSet<>(parentObjects);
		clonedHistory.add(objectId);

		Bukkit.getLogger().finer(indent + "scanning " + simpleName);
		Method[] methods = clazz.getDeclaredMethods();
		StringBuilder json = new StringBuilder("{");



		try {
			for (Method method : methods) {
				String methodName = method.getName();
				if (excludedMethods.contains(methodName)) {
					Bukkit.getLogger().finer(indent + "Excluded method " + methodName);
					continue;
				}

				if (method.getParameterCount() > 0) {
					Bukkit.getLogger().finer(indent + "Has parameters " + methodName);
					continue;
				}

				int modifiers = method.getModifiers();
				if (Modifier.isPrivate(modifiers) || Modifier.isProtected(modifiers)) {
					Bukkit.getLogger().finer(indent + "Non-public method " + methodName);
					continue;
				}


				Matcher matcher = GETTER_METHODS.matcher(methodName);

				if (matcher.matches()) {

					json.append(" \"").append(methodName).append("\": ");

					Class<?> returnType = method.getReturnType();
					method.setAccessible(true);

					Bukkit.getLogger().finer(indent + "\tcalling " + methodName);
					if (returnType.isPrimitive()) {
						String result = String.valueOf(method.invoke(o));
						json.append(result);

					} else if (returnType.equals(String.class)) {
						json.append("\"").append(method.invoke(o)).append("\"");

					} else if (returnType.isArray() || Collection.class.isAssignableFrom(returnType)) {

						Collection collection;
						if (returnType.isArray()) {
							Bukkit.getLogger().finer(indent + "\t\tconverting array " + returnType.getSimpleName() + " to collection");

							Object reflectedArray = method.invoke(o);

							collection = objectToCollection(reflectedArray);
						} else {
							Bukkit.getLogger().finer(indent + "\t\tconverting " + returnType.getSimpleName() + " to collection");
							collection = (Collection) method.invoke(o);
						}

						json.append("[");

						Bukkit.getLogger().finer(indent + "\t\tlist " + (returnType.getComponentType() == null ? "null" : returnType.getComponentType().getSimpleName()));
						if (collection != null && !collection.isEmpty()) {
							if (!collection.equals(parentCollection)) {

								for (Object item : collection) {
									if (recursionDepth > 0) {
										json.append(recursiveObjectReader(item, clonedHistory, collection, depth + 1, recursionDepth - 1));
									} else {
										json.append(item.getClass().getSimpleName());
									}
									json.append(",");
								}

								if (json.charAt(json.length() - 1) == ',') {
									json.deleteCharAt(json.length() - 1);
								}
							} else {
								Bukkit.getLogger().finer(indent + "\t\tRecursive collection call " + methodName);
							}
						}

						json.append("]");
					} else {
						Bukkit.getLogger().finer(indent + "\t\tobject " + returnType.getSimpleName());
						if (recursionDepth > 0) {
							// There are validity checks that are failing on certain non legacy materials
							Object result;

							try {
								result = method.invoke(o);
							} catch (InvocationTargetException e) {
								if (e.getCause() instanceof IllegalArgumentException) {
									result = "Illegal method call, bad argument...";
								} else {
									throw e;
								}
							}

							json.append(recursiveObjectReader(result, clonedHistory, parentCollection, depth + 1, recursionDepth - 1));

						} else {
							json.append("{\"").append(returnType.getSimpleName()).append("\": \"--MAX DEPTH REACHED--\"}");

						}
					}

					json.append(",");
				} else {
					Bukkit.getLogger().finer(indent + "Not a getter method " + methodName);
				}
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
	 * 	Regex Search & Replace Pattern to generate ALL the methods from a table of words
	 *
	 * Search:

	 (\t+)(\w+)(\n)

	 *
	 * Replace:

	 @EventHandler public void on$2($2 event) {
	 this.onBlockEvent(event);
	 }

	 */
}
