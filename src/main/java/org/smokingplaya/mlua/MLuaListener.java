package org.smokingplaya.mlua;

import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.BrewingStandFuelEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.inventory.TradeSelectEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.RaidEvent;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.raid.RaidSpawnWaveEvent;
import org.bukkit.event.raid.RaidStopEvent;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.RemoteServerCommandEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.server.ServiceEvent;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.event.server.ServiceUnregisterEvent;
import org.bukkit.event.server.TabCompleteEvent;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.event.world.TimeSkipEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

public class MLuaListener implements Listener {

  private LuaValue hook_call;
  public MLuaListener(LuaValue hookCallFunc) { hook_call = hookCallFunc; }
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
  @EventHandler
  public void onEntityDeath (EntityDeathEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityDropItem (EntityDropItemEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityEnterBlock (EntityEnterBlockEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityExplode (EntityExplodeEvent e) {eventHander(e);}
  @EventHandler
  public void onEntityInteract (EntityInteractEvent e) {eventHander(e);}
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

  // hanging

  @EventHandler
  public void onHangingBreakByEntity (HangingBreakByEntityEvent e) {eventHander(e);}
  @EventHandler
  public void onHangingBreak (HangingBreakEvent e) {eventHander(e);}
  @EventHandler
  public void onHangingPlace (HangingPlaceEvent e) {eventHander(e);}

  // inventory

  @EventHandler
  public void onBrew (BrewEvent e) {eventHander(e);}
  @EventHandler
  public void onBrewingStandFuel (BrewingStandFuelEvent e) {eventHander(e);}
  @EventHandler
  public void onCraftItem (CraftItemEvent e) {eventHander(e);}
  @EventHandler
  public void onFurnaceBurn (FurnaceBurnEvent e) {eventHander(e);}
  @EventHandler
  public void onFurnaceExtract (FurnaceExtractEvent e) {eventHander(e);}
  @EventHandler
  public void onFurnaceSmelt (FurnaceSmeltEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryClick (InventoryClickEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryClose (InventoryCloseEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryCreative (InventoryCreativeEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryDrag (InventoryDragEvent e) {eventHander(e);}
  @EventHandler
  public void onInventory (InventoryEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryInteract (InventoryInteractEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryMoveItem (InventoryMoveItemEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryOpen (InventoryOpenEvent e) {eventHander(e);}
  @EventHandler
  public void onInventoryPickupItem (InventoryPickupItemEvent e) {eventHander(e);}
  @EventHandler
  public void onPrepareAnvil (PrepareAnvilEvent e) {eventHander(e);}
  @EventHandler
  public void onPrepareItemCraft (PrepareItemCraftEvent e) {eventHander(e);}
  @EventHandler
  public void onPrepareSmithing (PrepareSmithingEvent e) {eventHander(e);}
  @EventHandler
  public void onSmithItem (SmithItemEvent e) {eventHander(e);}
  @EventHandler
  public void onTradeSelect (TradeSelectEvent e) {eventHander(e);}

  // raid

  @EventHandler
  public void onRaidFinish (RaidFinishEvent e) {eventHander(e);}
  @EventHandler
  public void onRaidSpawnWave (RaidSpawnWaveEvent e) {eventHander(e);}
  @EventHandler
  public void onRaidStop (RaidStopEvent e) {eventHander(e);}
  @EventHandler
  public void onRaidTrigger (RaidTriggerEvent e) {eventHander(e);}

  // server

  @EventHandler
  public void onBroadcastMessage (BroadcastMessageEvent e) {eventHander(e);}
  @EventHandler
  public void onMapInitialize (MapInitializeEvent e) {eventHander(e);}
  @EventHandler
  public void onPluginDisable (PluginDisableEvent e) {eventHander(e);}
  @EventHandler
  public void onPluginEnable (PluginEnableEvent e) {eventHander(e);}
  @EventHandler
  public void onRemoteServerCommand (RemoteServerCommandEvent e) {eventHander(e);}
  @EventHandler
  public void onServerCommand (ServerCommandEvent e) {eventHander(e);}
  @EventHandler
  public void onServerListPing (ServerListPingEvent e) {eventHander(e);}
  @EventHandler
  public void onServerLoad (ServerLoadEvent e) {eventHander(e);}
  @EventHandler
  public void onServiceRegister (ServiceRegisterEvent e) {eventHander(e);}
  @EventHandler
  public void onServiceUnregister (ServiceUnregisterEvent e) {eventHander(e);}
  @EventHandler
  public void onTabComplete (TabCompleteEvent e) {eventHander(e);}

  // vehicle
  @EventHandler
  public void onVehicleCreate (VehicleCreateEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleDamage (VehicleDamageEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleDestroy (VehicleDestroyEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleEnter (VehicleEnterEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleEntityCollision (VehicleEntityCollisionEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleExit (VehicleExitEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleMove (VehicleMoveEvent e) {eventHander(e);}
  @EventHandler
  public void onVehicleUpdate (VehicleUpdateEvent e) {eventHander(e);}

  // weather

  @EventHandler
  public void onLightningStrike (LightningStrikeEvent e) {eventHander(e);}
  @EventHandler
  public void onThunderChange (ThunderChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onWeatherChange (WeatherChangeEvent e) {eventHander(e);}

  // world

  @EventHandler
  public void onChunkLoad (ChunkLoadEvent e) {eventHander(e);}
  @EventHandler
  public void onChunkPopulate (ChunkPopulateEvent e) {eventHander(e);}
  @EventHandler
  public void onChunkUnload (ChunkUnloadEvent e) {eventHander(e);}
  @EventHandler
  public void onLootGenerate (LootGenerateEvent e) {eventHander(e);}
  @EventHandler
  public void onPortalCreate (PortalCreateEvent e) {eventHander(e);}
  @EventHandler
  public void onSpawnChange (SpawnChangeEvent e) {eventHander(e);}
  @EventHandler
  public void onStructureGrow (StructureGrowEvent e) {eventHander(e);}
  @EventHandler
  public void onTimeSkip (TimeSkipEvent e) {eventHander(e);}
  @EventHandler
  public void onWorldInit (WorldInitEvent e) {eventHander(e);}
  @EventHandler
  public void onWorldLoad (WorldLoadEvent e) {eventHander(e);}
  @EventHandler
  public void onWorldSave (WorldSaveEvent e) {eventHander(e);}
  @EventHandler
  public void onWorldUnload (WorldUnloadEvent e) {eventHander(e);}
}
