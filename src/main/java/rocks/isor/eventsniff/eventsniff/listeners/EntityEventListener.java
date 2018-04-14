package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EnderDragonChangePhaseEvent;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerReplenishTradeEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;
import rocks.isor.eventsniff.eventsniff.Utils;

public class EntityEventListener implements Listener, CanOutputEvent {

	private void onEntityEvent(EntityEvent entityEvent) {
		this.onEntityEvent(entityEvent, null);
	}

	private void onEntityEvent(EntityEvent entityEvent, String details) {
		String message = entityEvent.getEntity().getName();

		if (details != null) {
			message += " - " + details;
		}

		output(entityEvent, message);
	}

	@EventHandler
	public void onAreaEffectCloudApplyEvent(AreaEffectCloudApplyEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onCreeperPowerEvent(CreeperPowerEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEnderDragonChangePhaseEvent(EnderDragonChangePhaseEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityAirChangeEvent(EntityAirChangeEvent event) {
		int entityId = event.getEntity().getEntityId();
		String entityTypeName = event.getEntity().getType().name();

		throttledOutput(event, String.valueOf(entityId),"Triggered on " + entityTypeName);
	}

	@EventHandler
	public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityBreedEvent(EntityBreedEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityChangeBlockEvent(EntityChangeBlockEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityCombustByBlockEvent(EntityCombustByBlockEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityCombustByEntityEvent(EntityCombustByEntityEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityCombustEvent(EntityCombustEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent event) {
		String details = Utils.generateJsonString(event);

		this.onEntityEvent(event, details);
	}

	@EventHandler
	public void onEntityDeathEvent(EntityDeathEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityInteractEvent(EntityInteractEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityPickupItemEvent(EntityPickupItemEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityPortalEvent(EntityPortalEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityPortalExitEvent(EntityPortalExitEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityResurrectEvent(EntityResurrectEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityShootBowEvent(EntityShootBowEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntitySpawnEvent(EntitySpawnEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityTameEvent(EntityTameEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityTargetEvent(EntityTargetEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityTargetLivingEntityEvent(EntityTargetLivingEntityEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityTeleportEvent(EntityTeleportEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityToggleGlideEvent(EntityToggleGlideEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onEntityUnleashEvent(EntityUnleashEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onExpBottleEvent(ExpBottleEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onExplosionPrimeEvent(ExplosionPrimeEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onFireworkExplodeEvent(FireworkExplodeEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onHorseJumpEvent(HorseJumpEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onItemDespawnEvent(ItemDespawnEvent event) {
		String details = Utils.generateJsonString(event);

		this.onEntityEvent(event, details);
	}

	@EventHandler
	public void onItemMergeEvent(ItemMergeEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onItemSpawnEvent(ItemSpawnEvent event) {
		String details = Utils.generateJsonString(event);

		this.onEntityEvent(event, details);
	}

	@EventHandler
	public void onLingeringPotionSplashEvent(LingeringPotionSplashEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onPigZapEvent(PigZapEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onPotionSplashEvent(PotionSplashEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onProjectileHitEvent(ProjectileHitEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onProjectileLaunchEvent(ProjectileLaunchEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onSheepDyeWoolEvent(SheepDyeWoolEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onSheepRegrowWoolEvent(SheepRegrowWoolEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onSlimeSplitEvent(SlimeSplitEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onSpawnerSpawnEvent(SpawnerSpawnEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onVillagerAcquireTradeEvent(VillagerAcquireTradeEvent event) {
		this.onEntityEvent(event);
	}

	@EventHandler
	public void onVillagerReplenishTradeEvent(VillagerReplenishTradeEvent event) {
		this.onEntityEvent(event);
	}
}
