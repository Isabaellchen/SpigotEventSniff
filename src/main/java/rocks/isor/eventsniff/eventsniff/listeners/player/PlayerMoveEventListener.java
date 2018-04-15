package rocks.isor.eventsniff.eventsniff.listeners.player;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;
import rocks.isor.eventsniff.eventsniff.Utils;

public class PlayerMoveEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public PlayerMoveEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onPlayerMoveEvent(PlayerMoveEvent playerMoveEvent, boolean verbose) {
		String playerName = playerMoveEvent.getPlayer().getName();
		Location to = playerMoveEvent.getTo();

		String toCoordinates = Utils.generateCoordinateString(to);

		throttledOutput(playerMoveEvent, playerName, playerName +" moving to " + toCoordinates, isVerbose || verbose);
	}

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		this.onPlayerMoveEvent(event, false);
	}

	@EventHandler
	public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
		this.onPlayerMoveEvent(event, false);
	}

}
