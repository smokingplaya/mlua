package org.smokingplaya.mlua;

import java.io.File;

import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

public final class MLua extends JavaPlugin implements Listener {
    private Globals lua_globals;
    private LuaValue hook_call;

    @Override
    public void onEnable() {
        lua_globals = JsePlatform.standardGlobals();
        
        getServer().getPluginManager().registerEvents(this, this);

        loadLuaFile("hook.lua");
        loadLuaFile("util.lua");

        hook_call = lua_globals.get("hook").get("call");

        checkFolders();
        setupHooks();
    }

    private void loadLuaFile(String path) {
        LuaValue chunk = lua_globals.loadfile(path);
        chunk.call();
    }

    private void checkFolders() {
        if (!getDataFolder().exists()) getDataFolder().mkdir();
        File scriptsFolder = new File(getDataFolder(), "scripts");
        if (!scriptsFolder.exists()) scriptsFolder.mkdir();
        
        loadLuaScripts(scriptsFolder);
    }

    private void loadLuaScripts(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                loadLuaScripts(fileEntry);
            } else {
                loadLuaFile(folder.getPath() + "/" + fileEntry.getName());
            }
        }
    }

    private void onEvent(Event event) {
        hook_call.call(LuaValue.valueOf(event.getEventName()), CoerceJavaToLua.coerce(event));
    }

    private void setupHooks() {
        RegisteredListener registeredListener = new RegisteredListener(this, (listener, event) -> onEvent(event), EventPriority.NORMAL, this, false);
        for (HandlerList handler : HandlerList.getHandlerLists())
            handler.register(registeredListener);
    }
}