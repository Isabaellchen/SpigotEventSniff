package rocks.isor.eventsniff.eventsniff;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import rocks.isor.eventsniff.eventsniff.listeners.EntityEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.HangingEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.InventoryEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.MiscEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.block.BlockEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.block.BlockPistonEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.player.PlayerBucketEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.player.PlayerChannelEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.player.PlayerEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.player.PlayerInteractEntityEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.player.PlayerMoveEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.player.PlayerPickupItemEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.server.PluginEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.server.ServerCommandEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.server.ServerEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.vehicle.VehicleCollisionEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.vehicle.VehicleEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.WeatherEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.world.ChunkEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.world.WorldEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.server.ServiceEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventSniffPlugin extends JavaPlugin {

	private List<Listener> listeners = new ArrayList<>();

	@Override
	public void onEnable() {
		getLogger().info("Setting up EventSniff!");
		listeners.clear();


		getLogger().info("* Setting up Listener instances");
		listeners.add(new BlockEventListener(false));
		listeners.add(new BlockPistonEventListener(false));
		listeners.add(new EntityEventListener(false));
		listeners.add(new HangingEventListener(false));
		listeners.add(new InventoryEventListener(false));
		listeners.add(new MiscEventListener(false));
		listeners.add(new PlayerEventListener(false));
		listeners.add(new PlayerChannelEventListener(false));
		listeners.add(new PlayerBucketEventListener(false));
		listeners.add(new PlayerInteractEntityEventListener(false));
		listeners.add(new PlayerMoveEventListener(false));
		listeners.add(new PlayerPickupItemEventListener(false));
		listeners.add(new ServerEventListener(false));
		listeners.add(new PluginEventListener(false));
		listeners.add(new ServerCommandEventListener(false));
		listeners.add(new ServiceEventListener(false));
		listeners.add(new VehicleEventListener(false));
		listeners.add(new VehicleCollisionEventListener(false));
		listeners.add(new WeatherEventListener(false));
		listeners.add(new WorldEventListener(false));
		listeners.add(new ChunkEventListener(false));


		getLogger().info("* Registering listeners...");
		listeners.forEach(listener -> {
			getLogger().info("-" + listener.getClass().getSimpleName());
			getServer().getPluginManager().registerEvents(listener, this);
		});

	}
	@Override
	public void onDisable() {
		getLogger().info("Shutting down EventSniff!");


		getLogger().info("* Deregistering listeners...");
		listeners.forEach(HandlerList::unregisterAll);
		listeners.clear();
	}

}
