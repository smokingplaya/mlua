package org.smokingplaya.mlua;

import java.io.OutputStream;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.VarArgFunction;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.LuajavaLib;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaFunction;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public final class MLua extends JavaPlugin implements Listener, CommandExecutor, TabCompleter {
    private Globals luaGlobals;

    @Override
    public void onEnable() {
        setEnabled(true);
        luaGlobals = JsePlatform.standardGlobals();

        loadLuaFile("util.lua");
        loadLuaFile("hook.lua");
        luaGlobals.get("add").call(LuaValue.valueOf("bukkitapi"), CoerceJavaToLua.coerce(getServer()));
        luaGlobals.get("add").call(LuaValue.valueOf("fetch"), CoerceJavaToLua.coerce(new FetchFunction()));

        getServer().getPluginManager().registerEvents(new MLuaListener(luaGlobals.get("hook").get("call")), this);

        checkFolders();

        // Регистрация команды /mlua
        getCommand("mlua").setExecutor(this);
        getCommand("mlua").setTabCompleter(this);
    }

    @Override
    public void onDisable() {
        setEnabled(false);
    }

    private void checkFolders() {
        if (!getDataFolder().exists()) getDataFolder().mkdir();

        File scriptsFolder = new File(getDataFolder(), "scripts");

        if (!scriptsFolder.exists()) scriptsFolder.mkdir();

        loadLuaScripts(scriptsFolder);
    }

    private void loadLuaFile(String path) {
        luaGlobals.loadfile(path).call();
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

    // commands

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mlua")) {
            if (args.length == 0) {
                sender.sendMessage("MLua Plugin v1.0"); // Замените на информацию о вашем плагине
            } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (sender instanceof Player) {
                    sender.sendMessage("Only console can reload MLua.");
                } else {
                    reloadPlugin();
                    sender.sendMessage("MLua Plugin reloaded.");
                }
            }
            return true;
        }
        return false;
    }

    private void reloadPlugin() {
        checkFolders();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("mlua")) {
            if (args.length == 1) {
                completions.add("reload");
            }
        }
        return completions;
    }

    // http 

    private class FetchFunction extends VarArgFunction {
        @Override
        public Varargs invoke(Varargs args) {
            final String methodStr = args.arg(1).tojstring();
            final String urlStr = args.arg(2).tojstring();
            final LuaFunction successCallback = args.arg(3).checkfunction();

            Bukkit.getScheduler().runTaskAsynchronously(MLua.this, () -> {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(urlStr).openConnection();
                    connection.setRequestMethod(methodStr);

                    if (methodStr.equalsIgnoreCase("POST")) {
                        connection.setRequestProperty("Content-Type", "application/json");
                        connection.setRequestProperty("Accept", "text/html");
                        connection.setDoOutput(true);

                        LuaTable table = args.arg(4).checktable();
                        JsonObject jsonData = new JsonObject();

                        LuaValue[] keys = table.keys();
                        for (LuaValue key : keys) {
                            String keyStr = key.tojstring();
                            LuaValue value = table.get(key);
                            jsonData.addProperty(keyStr, value.tojstring());
                        }

                        OutputStream os = connection.getOutputStream();
                        os.write(jsonData.toString().getBytes("UTF-8"));
                        os.close();

                    }

                    // read
                    int responseCode = connection.getResponseCode();
                    InputStream inputStream;
                    if (200 <= responseCode && responseCode <= 299) {
                        inputStream = connection.getInputStream();
                    } else {
                        inputStream = connection.getErrorStream();
                    }

                    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));


                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null) 
                        response.append(currentLine);

                    in.close();

                    //

                    final String finalResponseBody = response.toString();

                    Bukkit.getScheduler().runTask(MLua.this, () -> {
                        successCallback.invoke(LuaValue.valueOf(finalResponseBody), LuaValue.valueOf(responseCode));
                    });
                    //
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return LuaValue.NIL;
        }
    }
}
