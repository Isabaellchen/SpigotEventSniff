package rocks.isor.eventsniff.eventsniff.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PlayerPickupItemEventListener implements Listener, CanOutputEvent {

	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent playerPickupItemEvent) {
		String playerName = playerPickupItemEvent.getPlayer().getName();

		output(playerPickupItemEvent, playerName);
	}

	@EventHandler
	public void onPlayerPickupArrowEvent(PlayerPickupArrowEvent event) {
		this.onPlayerPickupItemEvent(event);
	}

}
