package rocks.isor.eventsniff.eventsniff.listeners.block;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;
import rocks.isor.eventsniff.eventsniff.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BlockEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public BlockEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	/**
	 * Generic Block Event processing
	 * @param blockEvent the event to be processed
	 */
	private void onBlockEvent(BlockEvent blockEvent, boolean verbose) {
		onBlockEvent(blockEvent, verbose, 1);
	}

	private void onBlockEvent(BlockEvent blockEvent, boolean verbose, int recursionDepth) {
		Location location = blockEvent.getBlock().getLocation();
		String coordinateString = Utils.generateCoordinateString(location);
		String blockType = blockEvent.getBlock().getType().name();

		output(blockEvent, blockType + " at " + coordinateString, isVerbose || verbose, recursionDepth);
	}

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockBurnEvent(BlockBurnEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockDispenseEvent(BlockDispenseEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockExpEvent(BlockExpEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockExplodeEvent(BlockExplodeEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockFadeEvent(BlockFadeEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockFormEvent(BlockFormEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {
		this.onBlockEvent(event, true, 4);
	}

	@EventHandler
	public void onBlockGrowEvent(BlockGrowEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockIgniteEvent(BlockIgniteEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockMultiPlaceEvent(BlockMultiPlaceEvent event) {
		this.onBlockEvent(event, false);
	}

	private Set<String> ignoredEventSourceTypes = new HashSet<>(Arrays.asList("GRASS", "DIRT"));
	private Set<String> filterEventTargetTypes = new HashSet<>(Arrays.asList("STONE_BUTTON", "LEVER"));

	@EventHandler
	public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
		String eventSourceType = event.getChangedType().name();

		if (ignoredEventSourceTypes.contains(eventSourceType)) {
			return;
		}

		String targetBlockType = event.getBlock().getType().name();
		Location location = event.getBlock().getLocation();
		String coordinateString = Utils.generateCoordinateString(location);

		if (filterEventTargetTypes.contains(targetBlockType)) {
			throttledOutput(event, coordinateString, " Triggered by " + eventSourceType + ", affects " + targetBlockType + " at " + coordinateString, isVerbose || true);
		}
	}

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onBlockSpreadEvent(BlockSpreadEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onCauldronLevelChangeEvent(CauldronLevelChangeEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onEntityBlockFormEvent(EntityBlockFormEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onLeavesDecayEvent(LeavesDecayEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onNotePlayEvent(NotePlayEvent event) {
		this.onBlockEvent(event, false);
	}

	@EventHandler
	public void onSignChangeEvent(SignChangeEvent event) {
		this.onBlockEvent(event, false);
	}
}
