package org.smokingplaya.mlua;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public final class MLua extends JavaPlugin {
    Globals lua_globals;

    @Override
    public void onEnable() {
        lua_globals = JsePlatform.standardGlobals();

        checkFolders();
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
                LuaValue chunk = lua_globals.loadfile(folder.getPath() + "/" + fileEntry.getName());
                chunk.call();
            }
        }
    }
}
