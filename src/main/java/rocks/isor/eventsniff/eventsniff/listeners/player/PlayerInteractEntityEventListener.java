package rocks.isor.eventsniff.eventsniff.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PlayerInteractEntityEventListener implements Listener, CanOutputEvent {

	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent playerInteractEntityEvent) {
		String playerName = playerInteractEntityEvent.getPlayer().getName();

		output(playerInteractEntityEvent, playerName);
	}

	@EventHandler
	public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
		this.onPlayerInteractEntityEvent(event);
	}

	@EventHandler
	public void onPlayerInteractAtEntityEvent(PlayerInteractAtEntityEvent event) {
		this.onPlayerInteractEntityEvent(event);
	}
}
