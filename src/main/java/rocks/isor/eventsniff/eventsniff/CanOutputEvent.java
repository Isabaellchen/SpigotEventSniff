package rocks.isor.eventsniff.eventsniff;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public interface CanOutputEvent {

	default void output(Event event, String specialTarget) {
		String eventName = event.getEventName();

		Bukkit.broadcastMessage(eventName + " on " + specialTarget);
	}

	/**
	 * Map of EventNames of Sets of uniqueIdentifiers
	 */
	Map<String, Set<String>> debounceCache = new HashMap<>();

	/**
	 * Scheduled executor to clean up the mess
	 */
	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	default void debouncedOutput(Event event, String uniqueIdentifier, long delay, TimeUnit timeUnit) {
		String eventName = event.getEventName();
		Set<String> cache = debounceCache.getOrDefault(eventName, new HashSet<>());

		if (!cache.contains(uniqueIdentifier)) {

			output(event, uniqueIdentifier);

			cache.add(uniqueIdentifier);
			debounceCache.put(eventName, cache);

			executor.schedule(() -> {
				cache.remove(uniqueIdentifier);
				if (cache.isEmpty()) {
					debounceCache.remove(eventName);
				}
			}, delay, timeUnit); // this record self-destructs after the set delay
		}

	}
}
