package rocks.isor.eventsniff.eventsniff;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import rocks.isor.eventsniff.eventsniff.listeners.BlockEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.EntityEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.HangingEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.InventoryEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.MiscEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.PlayerEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.ServerEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.VehicleEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.WeatherEventListener;
import rocks.isor.eventsniff.eventsniff.listeners.WorldEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventSniffPlugin extends JavaPlugin {

	private List<Listener> listeners = new ArrayList<>();

	@Override
	public void onEnable() {
		getLogger().info("Setting up EventSniff!");
		listeners.clear();


		getLogger().info("* Setting up Listener instances");
		//listeners.add(new BlockEventListener());
		listeners.add(new EntityEventListener());
		//listeners.add(new HangingEventListener());
		//listeners.add(new InventoryEventListener());
		//listeners.add(new MiscEventListener());
		//listeners.add(new PlayerEventListener());
		//listeners.add(new ServerEventListener());
		//listeners.add(new VehicleEventListener());
		//listeners.add(new WeatherEventListener());
		//listeners.add(new WorldEventListener());


		getLogger().info("* Registering listeners...");
		listeners.forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));

	}
	@Override
	public void onDisable() {
		getLogger().info("Shutting down EventSniff!");


		getLogger().info("* Deregistering listeners...");
		listeners.forEach(HandlerList::unregisterAll);
		listeners.clear();
	}

}
