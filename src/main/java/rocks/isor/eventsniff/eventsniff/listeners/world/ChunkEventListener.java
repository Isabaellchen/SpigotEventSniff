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
	
	private boolean isVerbose;

	public ChunkEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onChunkEvent(ChunkEvent chunkEvent, boolean verbose) {
		this.onChunkEvent(chunkEvent, null, verbose);
	}

	private void onChunkEvent(ChunkEvent chunkEvent, String details, boolean verbose) {
		String worldName = chunkEvent.getWorld().getName();

		Chunk chunk = chunkEvent.getChunk();
		int x = chunk.getX();
		int z = chunk.getZ();
		String coordinates =  x + "x" + z;

		String message = worldName + " at " + coordinates;

		if (details != null) {
			message += " - " + details;
		}

		output(chunkEvent, message, isVerbose || verbose);
	}

	@EventHandler
	public void onChunkLoadEvent(ChunkLoadEvent event) {
		//this.onChunkEvent(event, false);
	}

	@EventHandler
	public void onChunkPopulateEvent(ChunkPopulateEvent event) {
		this.onChunkEvent(event, false);
	}

	@EventHandler
	public void onChunkUnloadEvent(ChunkUnloadEvent event) {
		//this.onChunkEvent(event, false);
	}
}
