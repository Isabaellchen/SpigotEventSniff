package rocks.isor.eventsniff.eventsniff.listeners.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class WorldEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public WorldEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onWorldEvent(WorldEvent worldEvent, boolean verbose) {
		String worldName = worldEvent.getWorld().getName();

		output(worldEvent, worldName, isVerbose || verbose);
	}

	@EventHandler
	public void onPortalCreateEvent(PortalCreateEvent event) {
		this.onWorldEvent(event, false);
	}

	@EventHandler
	public void onSpawnChangeEvent(SpawnChangeEvent event) {
		this.onWorldEvent(event, false);
	}

	@EventHandler
	public void onStructureGrowEvent(StructureGrowEvent event) {
		this.onWorldEvent(event, false);
	}

	@EventHandler
	public void onWorldInitEvent(WorldInitEvent event) {
		this.onWorldEvent(event, false);
	}

	@EventHandler
	public void onWorldLoadEvent(WorldLoadEvent event) {
		this.onWorldEvent(event, false);
	}

	@EventHandler
	public void onWorldSaveEvent(WorldSaveEvent event) {
		this.onWorldEvent(event, false);
	}

	@EventHandler
	public void onWorldUnloadEvent(WorldUnloadEvent event) {
		this.onWorldEvent(event, false);
	}
}
