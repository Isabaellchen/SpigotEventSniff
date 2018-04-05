package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.server.TabCompleteEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class MiscEventListener implements Listener, CanOutputEvent {

	@EventHandler
	public void onPlayerLeashEntityEvent(PlayerLeashEntityEvent event) {
		String entityTypeName = event.getEntity().getType().name();

		output(event, entityTypeName);
	}

	@EventHandler
	public void onAsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {
		String playerName = event.getName();

		output(event, playerName);
	}

	@EventHandler
	public void onPlayerPreLoginEvent(PlayerPreLoginEvent event) {
		String playerName = event.getName();

		output(event, playerName);
	}

	@EventHandler
	public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {
		String itemMaterialName = event.getItem().getType().name();

		output(event, itemMaterialName);
	}

	@EventHandler
	public void onInventoryPickupItemEvent(InventoryPickupItemEvent event) {
		String itemMaterialName = event.getItem().getType().name();

		output(event, itemMaterialName);
	}

	@EventHandler
	public void onTabCompleteEvent(TabCompleteEvent event) {
		String senderName = event.getSender().getName();

		output(event, senderName);
	}
}
