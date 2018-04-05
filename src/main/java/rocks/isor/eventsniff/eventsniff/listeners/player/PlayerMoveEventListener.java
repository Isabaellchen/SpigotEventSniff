package rocks.isor.eventsniff.eventsniff.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

import java.util.concurrent.TimeUnit;

public class PlayerMoveEventListener implements Listener, CanOutputEvent {

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent playerMoveEvent) {
		String playerName = playerMoveEvent.getPlayer().getName();

		debouncedOutput(playerMoveEvent, playerName, 15, TimeUnit.SECONDS);
	}

	@EventHandler
	public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
		this.onPlayerMoveEvent(event);
	}

}
