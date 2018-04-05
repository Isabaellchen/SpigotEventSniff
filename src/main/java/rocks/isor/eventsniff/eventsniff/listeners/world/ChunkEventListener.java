package rocks.isor.eventsniff.eventsniff.listeners.world;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ChunkEventListener implements Listener, CanOutputEvent {

	private void onChunkEvent(ChunkEvent chunkEvent) {
		String worldName = chunkEvent.getWorld().getName();

		Chunk chunk = chunkEvent.getChunk();
		int x = chunk.getX();
		int z = chunk.getZ();
		String coordinates =  x + "x" + z;

		output(chunkEvent, worldName + " at " + coordinates);
	}

	@EventHandler
	public void onChunkLoadEvent(ChunkLoadEvent event) {
		this.onChunkEvent(event);
	}

	@EventHandler
	public void onChunkPopulateEvent(ChunkPopulateEvent event) {
		this.onChunkEvent(event);
	}

	@EventHandler
	public void onChunkUnloadEvent(ChunkUnloadEvent event) {
		this.onChunkEvent(event);
	}
}