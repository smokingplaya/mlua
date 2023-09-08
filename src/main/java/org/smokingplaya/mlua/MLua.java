package org.smokingplaya.mlua;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.event.Listener;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public final class MLua extends JavaPlugin implements Listener {
    private Globals lua_globals;
    private LuaValue hook_call;

    @Override
    public void onEnable() {
        setEnabled(true);
        lua_globals = JsePlatform.standardGlobals();

        loadLuaFile("hook.lua");
        loadLuaFile("util.lua");

        hook_call = lua_globals.get("hook").get("call");
        getServer().getPluginManager().registerEvents(new MLuaListener(hook_call), this);

        checkFolders();
    }

    @Override
    public void onDisable() {setEnabled(false);}

    private void loadLuaFile(String path) {lua_globals.loadfile(path).call();}

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
}