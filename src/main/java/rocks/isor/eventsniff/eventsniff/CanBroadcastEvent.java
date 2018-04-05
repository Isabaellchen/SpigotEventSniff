package rocks.isor.eventsniff.eventsniff;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;

public interface CanBroadcastEvent {

	default void broadcastEvent(Event event, String specialTarget) {
		String eventName = event.getEventName();

		Bukkit.broadcastMessage(eventName + " on " + specialTarget);
	}

	default String generateCoordinateString(Location location) {
		int blockX = location.getBlockX();
		int blockY = location.getBlockY();
		int blockZ = location.getBlockZ();

		return blockX + "x" + blockY + "x" + blockZ;
	}
	/*
	Regex Search & Replace Pattern to generate all the methods from a list of words

	(\t+)(\w+)(\n)

	@EventHandler
	public void on$2($2 event) {
		this.onBlockEvent(event);
	}

	*/
}
