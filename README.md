# MLua
###### Powered by luaj

![header](https://raw.githubusercontent.com/smokingplaya/mlua/main/hat.png)

A plugin that adds lua scripts support to Spigot.

## Example Script
```lua
hook.insert("PlayerMoveEvent", function(event)
  print("Player => ", event:getPlayer())
end)
```

## How to create yourown script
1. Install plugin to your server
2. Open plugins/MLua/scripts
3. Create file *.lua (where * is name of script)
4. Type your code
5. Start/reload server

## Build
```bash
gradle shadowJar
```
