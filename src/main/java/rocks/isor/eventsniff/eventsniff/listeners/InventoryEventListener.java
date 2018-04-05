package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class InventoryEventListener implements Listener, CanBroadcastEvent {

	private void onInventoryEvent(InventoryEvent inventoryEvent) {
		Location location = inventoryEvent.getInventory().getLocation();
		String coordinates = generateCoordinateString(location);

		broadcastEvent(inventoryEvent, coordinates);
	}

	@EventHandler
	public void onEnchantItemEvent(EnchantItemEvent event) {
		this.onInventoryEvent(event);
	}

	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent event) {
		this.onInventoryEvent(event);
	}

	@EventHandler
	public void onInventoryInteractEvent(InventoryInteractEvent event) {
		this.onInventoryEvent(event);
	}

	@EventHandler
	public void onInventoryOpenEvent(InventoryOpenEvent event) {
		this.onInventoryEvent(event);
	}

	@EventHandler
	public void onPrepareAnvilEvent(PrepareAnvilEvent event) {
		this.onInventoryEvent(event);
	}

	@EventHandler
	public void onPrepareItemCraftEvent(PrepareItemCraftEvent event) {
		this.onInventoryEvent(event);
	}

	@EventHandler
	public void onPrepareItemEnchantEvent(PrepareItemEnchantEvent event) {
		this.onInventoryEvent(event);
	}
}
