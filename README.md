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

## How to create your own script
1. Install plugin to your server
2. Open plugins/MLua/scripts
3. Create file *.lua (where * is name of script)
4. Type your code
5. Start/reload server

## Libs
There is 2 default libries:
* [hook.lua](https://github.com/smokingplaya/mlua/blob/main/src/main/resources/hook.lua)
* [util.lua](https://github.com/smokingplaya/mlua/blob/main/src/main/resources/util.lua)

## Build
*build anyway requires [gradle tool](https://gradle.org/) on your computer

Default method:
```bash
git clone https://github.com/smokingplaya/mlua
cd mlua
gradle shadowJar
```

By python script (for the script to work properly, you need to go into it and change lines 3 and 4 to suit your needs):

```bash
git clone https://github.com/smokingplaya/mlua
cd mlua
python build.py
```