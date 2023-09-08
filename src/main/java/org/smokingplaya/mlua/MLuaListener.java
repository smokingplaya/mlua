package org.smokingplaya.mlua;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

public class MLuaListener implements Listener {
  private LuaValue hook_call;

  public MLuaListener(LuaValue hookCallFunc) {
    hook_call = hookCallFunc;
  }
  
  public void eventHander(Event e) {hook_call.call(LuaValue.valueOf(e.getEventName()), CoerceJavaToLua.coerce(e));}

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
}
