<h1 align="center">MLua</h1>
<h2 align="center">
MLua is a plugin for Spigot that adds the ability to write scripts for a minecraft server without having to compile them all the time.

<img src="https://img.shields.io/badge/Java Powered-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/Lua-2C2D72?style=for-the-badge&logo=lua&logoColor=white">

[Documentation](DOCS.md)
</h2>

![header](https://raw.githubusercontent.com/smokingplaya/mlua/main/hat.png)

## Download
You can download .jar file [here](https://github.com/smokingplaya/mlua/releases/tag/1.4)

## Example Script
```lua
hook.insert("PlayerMoveEvent", function(event)
  local player_name = event:getPlayer():getName()

  fetch("POST", "http://localhost/api/users/getData", function(body, c)
        print(body)
  end, {token = secret_key, username = player_name, key = "played_time"}) -- post http request example
end)
```

## Build
Build requires [gradle tool](https://gradle.org/) on your computer

Default method:
```bash
git clone https://github.com/smokingplaya/mlua
cd mlua
gradle shadowJar
```