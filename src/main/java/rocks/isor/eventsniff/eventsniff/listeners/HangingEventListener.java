package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class HangingEventListener implements Listener, CanBroadcastEvent {

	private void onHangingEvent(HangingEvent hangingEvent) {
		String hangingEntityName = hangingEvent.getEntity().getName();

		broadcastEvent(hangingEvent, hangingEntityName);
	}

	@EventHandler
	public void onHangingBreakEvent(HangingBreakEvent event) {
		this.onHangingEvent(event);
	}

	@EventHandler
	public void onHangingPlaceEvent(HangingPlaceEvent event) {
		this.onHangingEvent(event);
	}
}
