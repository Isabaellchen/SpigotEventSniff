package rocks.isor.eventsniff.eventsniff.listeners;

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
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class BlockEventListener implements Listener, CanBroadcastEvent {

	/**
	 * Generic Block Event processing
	 * @param blockEvent the event to be processed
	 */
	private void onBlockEvent(BlockEvent blockEvent) {
		String materialName = blockEvent.getBlock().getType().name();

		broadcastEvent(blockEvent, materialName);
	}

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockBurnEvent(BlockBurnEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockCanBuildEvent(BlockCanBuildEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockDispenseEvent(BlockDispenseEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockExpEvent(BlockExpEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockExplodeEvent(BlockExplodeEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockFadeEvent(BlockFadeEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockFormEvent(BlockFormEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockGrowEvent(BlockGrowEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockIgniteEvent(BlockIgniteEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockMultiPlaceEvent(BlockMultiPlaceEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockPistonEvent(BlockPistonEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockPistonExtendEvent(BlockPistonExtendEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockPistonRetractEvent(BlockPistonRetractEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onBlockSpreadEvent(BlockSpreadEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onCauldronLevelChangeEvent(CauldronLevelChangeEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onEntityBlockFormEvent(EntityBlockFormEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onLeavesDecayEvent(LeavesDecayEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onNotePlayEvent(NotePlayEvent event) {
		this.onBlockEvent(event);
	}

	@EventHandler
	public void onSignChangeEvent(SignChangeEvent event) {
		this.onBlockEvent(event);
	}
}
