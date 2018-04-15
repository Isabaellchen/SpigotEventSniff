package rocks.isor.eventsniff.eventsniff.listeners.player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PlayerChannelEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public PlayerChannelEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	@EventHandler
	public void onPlayerChannelEvent(PlayerChannelEvent playerChannelEvent, boolean verbose) {
		String playerName = playerChannelEvent.getPlayer().getName();

		output(playerChannelEvent, playerName, isVerbose || verbose);
	}

	@EventHandler
	public void onPlayerRegisterChannelEvent(PlayerRegisterChannelEvent event) {
		this.onPlayerChannelEvent(event, false);
	}

	@EventHandler
	public void onPlayerUnregisterChannelEvent(PlayerUnregisterChannelEvent event) {
		this.onPlayerChannelEvent(event, false);
	}
}
