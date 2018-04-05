package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class WorldEventListener implements Listener, CanBroadcastEvent {

	private void onWorldEvent(WorldEvent worldEvent) {
		String worldName = worldEvent.getWorld().getName();

		broadcastEvent(worldEvent, worldName);
	}

	@EventHandler
	public void onChunkEvent(ChunkEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onPortalCreateEvent(PortalCreateEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onSpawnChangeEvent(SpawnChangeEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onStructureGrowEvent(StructureGrowEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onWorldInitEvent(WorldInitEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onWorldLoadEvent(WorldLoadEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onWorldSaveEvent(WorldSaveEvent event) {
		this.onWorldEvent(event);
	}

	@EventHandler
	public void onWorldUnloadEvent(WorldUnloadEvent event) {
		this.onWorldEvent(event);
	}
}
