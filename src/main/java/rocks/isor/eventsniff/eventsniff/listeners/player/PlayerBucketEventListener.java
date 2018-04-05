package rocks.isor.eventsniff.eventsniff.listeners.player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PlayerBucketEventListener implements Listener, CanOutputEvent {

	private void onPlayerBucketEvent(PlayerBucketEvent playerBucketEvent) {
		String playerName = playerBucketEvent.getPlayer().getName();

		output(playerBucketEvent, playerName);
	}

	@EventHandler
	public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event) {
		this.onPlayerBucketEvent(event);
	}

	@EventHandler
	public void onPlayerBucketFillEvent(PlayerBucketFillEvent event) {
		this.onPlayerBucketEvent(event);
	}
}
