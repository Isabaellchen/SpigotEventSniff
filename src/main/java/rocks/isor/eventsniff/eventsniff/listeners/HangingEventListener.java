package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class HangingEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public HangingEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onHangingEvent(HangingEvent hangingEvent, boolean verbose) {
		String hangingEntityName = hangingEvent.getEntity().getName();

		output(hangingEvent, hangingEntityName, isVerbose || verbose);
	}

	@EventHandler
	public void onHangingBreakEvent(HangingBreakEvent event) {
		this.onHangingEvent(event, false);
	}

	@EventHandler
	public void onHangingPlaceEvent(HangingPlaceEvent event) {
		this.onHangingEvent(event, false);
	}
}
