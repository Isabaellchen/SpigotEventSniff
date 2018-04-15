package rocks.isor.eventsniff.eventsniff;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface CanOutputEvent {

	default void output(Event event, String message, boolean verbose) {
		String eventName = event.getEventName();

		if (verbose) {
			message += " - " + Utils.generateJsonString(event);
		}

		Bukkit.getLogger().info(eventName + " fired: " + message);
	}

	/**
	 * Map of EventNames of Sets of uniqueIdentifiers
	 */
	Map<String, Set<String>> throttleCache = new HashMap<>();

	/**
	 * Scheduled executor to clean up the mess
	 */
	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	default void throttledOutput(Event event, String uniqueIdentifier, String message, boolean verbose) {
		throttledOutput(event, uniqueIdentifier, message, verbose, 1, TimeUnit.MINUTES);
	}

	default void throttledOutput(Event event, String uniqueIdentifier, String message, boolean verbose, long delay, TimeUnit timeUnit) {
		String eventName = event.getEventName();
		Set<String> cache = throttleCache.getOrDefault(eventName, new HashSet<>());

		if (!cache.contains(uniqueIdentifier)) {

			output(event, message, verbose);

			cache.add(uniqueIdentifier);
			throttleCache.put(eventName, cache);

			executor.schedule(() -> {
				cache.remove(uniqueIdentifier);
				if (cache.isEmpty()) {
					throttleCache.remove(eventName);
				}
			}, delay, timeUnit); // this record self-destructs after the set delay
		}

	}
}
