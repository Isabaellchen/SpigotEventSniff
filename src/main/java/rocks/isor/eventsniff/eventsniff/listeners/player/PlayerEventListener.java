package rocks.isor.eventsniff.eventsniff.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PlayerEventListener implements Listener, CanOutputEvent {
	
	private boolean isVerbose;

	public PlayerEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onPlayerEvent(PlayerEvent playerEvent, boolean verbose) {
		String playerName = playerEvent.getPlayer().getName();

		output(playerEvent, playerName, isVerbose || verbose);
	}

	@EventHandler
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerAchievementAwardedEvent(PlayerAchievementAwardedEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerAdvancementDoneEvent(PlayerAdvancementDoneEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerAnimationEvent(PlayerAnimationEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerBedEnterEvent(PlayerBedEnterEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerChangedMainHandEvent(PlayerChangedMainHandEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerChatEvent(PlayerChatEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerChatTabCompleteEvent(PlayerChatTabCompleteEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerEditBookEvent(PlayerEditBookEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerEggThrowEvent(PlayerEggThrowEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerExpChangeEvent(PlayerExpChangeEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerFishEvent(PlayerFishEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerItemBreakEvent(PlayerItemBreakEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerItemDamageEvent(PlayerItemDamageEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerItemMendEvent(PlayerItemMendEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerKickEvent(PlayerKickEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerLocaleChangeEvent(PlayerLocaleChangeEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerResourcePackStatusEvent(PlayerResourcePackStatusEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerShearEntityEvent(PlayerShearEntityEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerSpawnLocationEvent(PlayerSpawnLocationEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerStatisticIncrementEvent(PlayerStatisticIncrementEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent event) {
		this.onPlayerEvent(event, false);
	}

	@EventHandler
	public void onPlayerVelocityEvent(PlayerVelocityEvent event) {
		this.onPlayerEvent(event, false);
	}
}
