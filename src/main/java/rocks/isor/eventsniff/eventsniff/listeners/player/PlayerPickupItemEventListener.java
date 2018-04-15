package rocks.isor.eventsniff.eventsniff.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PlayerPickupItemEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public PlayerPickupItemEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onPlayerPickupItemEvent(PlayerPickupItemEvent playerPickupItemEvent, boolean verbose) {
		String playerName = playerPickupItemEvent.getPlayer().getName();

		output(playerPickupItemEvent, playerName, isVerbose || verbose);
	}

	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
		this.onPlayerPickupItemEvent(event, false);
	}

	@EventHandler
	public void onPlayerPickupArrowEvent(PlayerPickupArrowEvent event) {
		this.onPlayerPickupItemEvent(event, false);
	}

}
