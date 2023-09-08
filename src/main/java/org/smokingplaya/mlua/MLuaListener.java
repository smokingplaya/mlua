package org.smokingplaya.mlua;

import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.*;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.ArrowBodyCountChangeEvent;
import org.bukkit.event.entity.BatToggleSleepEvent;
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
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntityEnterLoveModeEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.EntityExhaustionEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityPoseChangeEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntitySpellCastEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.entity.EntityTransformEvent;
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
import org.bukkit.event.entity.PigZombieAngerEvent;
import org.bukkit.event.entity.PiglinBarterEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.entity.StriderTemperatureChangeEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.entity.VillagerReplenishTradeEvent;
import org.bukkit.event.player.*;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

public class MLuaListener implements Listener {
  private LuaValue hook_call;

  public MLuaListener(LuaValue hookCallFunc) {
    hook_call = hookCallFunc;
  }
  
  public void eventHander(Event e) {hook_call.call(LuaValue.valueOf(e.getEventName()), CoerceJavaToLua.coerce(e));}

  // player

  @EventHandler
  public void onAsyncPlayerChat (AsyncPlayerChatEvent e) {eventHander(e);}
  @EventHandler
  public void onAsyncPlayerPreLogin (AsyncPlayerPreLoginEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerAdvancementDone (PlayerAdvancementDoneEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerAnimation (PlayerAnimationEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerArmorStandManipulate (PlayerArmorStandManipulateEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerBedEnter (PlayerBedEnterEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerBedLeave (PlayerBedLeaveEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerBucketEmpty (PlayerBucketEmptyEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerBucketEntity (PlayerBucketEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerBucketFill (PlayerBucketFillEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerChangedMainHand (PlayerChangedMainHandEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerChangedWorld (PlayerChangedWorldEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerChannel (PlayerChannelEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerCommandPreprocess (PlayerCommandPreprocessEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerCommandSend (PlayerCommandSendEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerDropItem (PlayerDropItemEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerEditBook (PlayerEditBookEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerEggThrow (PlayerEggThrowEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerExpChange (PlayerExpChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerFish (PlayerFishEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerGameModeChange (PlayerGameModeChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerHarvestBlock (PlayerHarvestBlockEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerInteractAtEntity (PlayerInteractAtEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerInteractEntity (PlayerInteractEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerInteract (PlayerInteractEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerItemBreak (PlayerItemBreakEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerItemConsume (PlayerItemConsumeEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerItemDamage (PlayerItemDamageEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerItemHeld (PlayerItemHeldEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerItemMend (PlayerItemMendEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerJoin (PlayerJoinEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerKick (PlayerKickEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerLevelChange (PlayerLevelChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerLocaleChange (PlayerLocaleChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerLogin (PlayerLoginEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerMove (PlayerMoveEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerPickupArrow (PlayerPickupArrowEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerPortal (PlayerPortalEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerQuit (PlayerQuitEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerRecipeDiscover (PlayerRecipeDiscoverEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerRegisterChannel (PlayerRegisterChannelEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerResourcePackStatus (PlayerResourcePackStatusEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerRespawn (PlayerRespawnEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerRiptide (PlayerRiptideEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerShearEntity (PlayerShearEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerStatisticIncrement (PlayerStatisticIncrementEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerSwapHandItems (PlayerSwapHandItemsEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerTakeLecternBook (PlayerTakeLecternBookEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerTeleport (PlayerTeleportEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerToggleFlight (PlayerToggleFlightEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerToggleSneak (PlayerToggleSneakEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerToggleSprint (PlayerToggleSprintEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerUnleashEntity (PlayerUnleashEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerUnregisterChannel (PlayerUnregisterChannelEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerVelocity (PlayerVelocityEvent e) {eventHander(e);}

  // block

  @EventHandler
  public void onBlockBreak (BlockBreakEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockBurn (BlockBurnEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockCanBuild (BlockCanBuildEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockCook (BlockCookEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockDamage (BlockDamageEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockDispenseArmor (BlockDispenseArmorEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockDispense (BlockDispenseEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockDropItem (BlockDropItemEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockExp (BlockExpEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockExplode (BlockExplodeEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockFade (BlockFadeEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockFertilize (BlockFertilizeEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockForm (BlockFormEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockFromTo (BlockFromToEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockGrow (BlockGrowEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockIgnite (BlockIgniteEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockMultiPlace (BlockMultiPlaceEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockPhysics (BlockPhysicsEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockPlace (BlockPlaceEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockRedstone (BlockRedstoneEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockShearEntity (BlockShearEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onBlockSpread (BlockSpreadEvent e) {eventHander(e);}
  @EventHandler
  public void onCauldronLevelChange (CauldronLevelChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityBlockForm (EntityBlockFormEvent e) {eventHander(e);}
  @EventHandler
  public void onFluidLevelChange (FluidLevelChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onLeavesDecay (LeavesDecayEvent e) {eventHander(e);}
  @EventHandler
  public void onMoistureChange (MoistureChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onNotePlay (NotePlayEvent e) {eventHander(e);}
  @EventHandler
  public void onSignChange (SignChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onSpongeAbsorb (SpongeAbsorbEvent e) {eventHander(e);}

  // enchantment

  @EventHandler
  public void onPrepareItemEnchant (PrepareItemEnchantEvent e) {eventHander(e);}
  @EventHandler
  public void onEnchantItem (EnchantItemEvent e) {eventHander(e);}

  // entity

  @EventHandler
  public void onAreaEffectCloudApply (AreaEffectCloudApplyEvent e) {eventHander(e);}
  @EventHandler
  public void onArrowBodyCountChange (ArrowBodyCountChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onBatToggleSleep (BatToggleSleepEvent e) {eventHander(e);}
  @EventHandler
  public void onCreatureSpawn (CreatureSpawnEvent e) {eventHander(e);}
  @EventHandler
  public void onCreeperPower (CreeperPowerEvent e) {eventHander(e);}
  @EventHandler
  public void onEnderDragonChangePhase (EnderDragonChangePhaseEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityAirChange (EntityAirChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityBreakDoor (EntityBreakDoorEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityBreed (EntityBreedEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityChangeBlock (EntityChangeBlockEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityCombustByBlock (EntityCombustByBlockEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityCombustByEntity (EntityCombustByEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityCombust (EntityCombustEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityDamageByBlock (EntityDamageByBlockEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityDamageByEntity (EntityDamageByEntityEvent e) {eventHander(e);}
  //
  @EventHandler
  public void onEntityDamage (EntityDamageEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityDeath (EntityDeathEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityDropItem (EntityDropItemEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityEnterBlock (EntityEnterBlockEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityEnterLoveMode (EntityEnterLoveModeEvent e) {eventHander(e);}
  //
  @EventHandler
  public void onEntity (EntityEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityExplode (EntityExplodeEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityInteract (EntityInteractEvent e) {eventHander(e);}
  //
  @EventHandler
  public void onEntityPickupItem (EntityPickupItemEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityPlace (EntityPlaceEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityPortalEnter (EntityPortalEnterEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityPortal (EntityPortalEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityPortalExit (EntityPortalExitEvent e) {eventHander(e);}
  
  @EventHandler
  public void onEntityPoseChange (EntityPoseChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityPotionEffect (EntityPotionEffectEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityRegainHealth (EntityRegainHealthEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityResurrect (EntityResurrectEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityShootBow (EntityShootBowEvent e) {eventHander(e);}
  @EventHandler
  public void onEntitySpawn (EntitySpawnEvent e) {eventHander(e);}
  @EventHandler
  public void onEntitySpellCast (EntitySpellCastEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityTame (EntityTameEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityTarget (EntityTargetEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityTargetLivingEntity (EntityTargetLivingEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityTeleport (EntityTeleportEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityToggleGlide (EntityToggleGlideEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityToggleSwim (EntityToggleSwimEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityTransform (EntityTransformEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityUnleash (EntityUnleashEvent e) {eventHander(e);}
  @EventHandler
  public void onExpBottle (ExpBottleEvent e) {eventHander(e);}
  @EventHandler
  public void onExplosionPrime (ExplosionPrimeEvent e) {eventHander(e);}
  @EventHandler
  public void onFireworkExplode (FireworkExplodeEvent e) {eventHander(e);}
  @EventHandler
  public void onFoodLevelChange (FoodLevelChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onHorseJump (HorseJumpEvent e) {eventHander(e);}
  @EventHandler
  public void onItemDespawn (ItemDespawnEvent e) {eventHander(e);}
  @EventHandler
  public void onItemMerge (ItemMergeEvent e) {eventHander(e);}
  @EventHandler
  public void onItemSpawn (ItemSpawnEvent e) {eventHander(e);}
  @EventHandler
  public void onLingeringPotionSplash (LingeringPotionSplashEvent e) {eventHander(e);}
  @EventHandler
  public void onPiglinBarter (PiglinBarterEvent e) {eventHander(e);}
  @EventHandler
  public void onPigZap (PigZapEvent e) {eventHander(e);}
  @EventHandler
  public void onPigZombieAnger (PigZombieAngerEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerDeath (PlayerDeathEvent e) {eventHander(e);}
  @EventHandler
  public void onPlayerLeashEntity (PlayerLeashEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onPotionSplash (PotionSplashEvent e) {eventHander(e);}
  @EventHandler
  public void onProjectileHit (ProjectileHitEvent e) {eventHander(e);}
  @EventHandler
  public void onProjectileLaunch (ProjectileLaunchEvent e) {eventHander(e);}
  @EventHandler
  public void onSheepDyeWool (SheepDyeWoolEvent e) {eventHander(e);}
  @EventHandler
  public void onSheepRegrowWool (SheepRegrowWoolEvent e) {eventHander(e);}
  @EventHandler
  public void onSlimeSplit (SlimeSplitEvent e) {eventHander(e);}
  @EventHandler
  public void onSpawnerSpawn (SpawnerSpawnEvent e) {eventHander(e);}
  @EventHandler
  public void onStriderTemperatureChange (StriderTemperatureChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onVillagerAcquireTrade (VillagerAcquireTradeEvent e) {eventHander(e);}
  @EventHandler
  public void onVillagerCareerChange (VillagerCareerChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onVillagerReplenishTrade (VillagerReplenishTradeEvent e) {eventHander(e);}
}
