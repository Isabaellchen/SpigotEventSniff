package rocks.isor.eventsniff.eventsniff.listeners.block;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;
import rocks.isor.eventsniff.eventsniff.Utils;

public class BlockPistonEventListener implements Listener, CanOutputEvent{

	private void onBlockPistonEvent(BlockPistonEvent blockPistonEvent) {
		Location location = blockPistonEvent.getBlock().getLocation();

		String coordinateString = Utils.generateCoordinateString(location);

		output(blockPistonEvent, coordinateString);
	}

	@EventHandler
	public void onBlockPistonExtendEvent(BlockPistonExtendEvent event) {
		this.onBlockPistonEvent(event);
	}

	@EventHandler
	public void onBlockPistonRetractEvent(BlockPistonRetractEvent event) {
		this.onBlockPistonEvent(event);
	}
}

