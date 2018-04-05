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
		listeners.add(new BlockEventListener());
		listeners.add(new BlockPistonEventListener());
		listeners.add(new EntityEventListener());
		listeners.add(new HangingEventListener());
		listeners.add(new InventoryEventListener());
		listeners.add(new MiscEventListener());
		listeners.add(new PlayerEventListener());
		listeners.add(new PlayerChannelEventListener());
		listeners.add(new PlayerBucketEventListener());
		listeners.add(new PlayerInteractEntityEventListener());
		listeners.add(new PlayerMoveEventListener());
		listeners.add(new PlayerPickupItemEventListener());
		listeners.add(new ServerEventListener());
		listeners.add(new PluginEventListener());
		listeners.add(new ServerCommandEventListener());
		listeners.add(new ServiceEventListener());
		listeners.add(new VehicleEventListener());
		listeners.add(new VehicleCollisionEventListener());
		listeners.add(new WeatherEventListener());
		listeners.add(new WorldEventListener());
		listeners.add(new ChunkEventListener());


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
