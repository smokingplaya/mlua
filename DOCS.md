<h2 align="center">MLua Documentation</h2>

MLua uses Lua, so you need to familiarize yourself with the documentation of Lua itself


[Lua Documentation](https://www.lua.org/docs.html)

MLua adds some libraries/functions to Lua to extend the functionality.

### bukkitapi
The library fully implimints the Bukkit Java class, so you can fully utilize its features. They are available in the [class documentation](https://helpch.at/docs/1.16.5/org/bukkit/Bukkit.html).

Example:
```lua
print(bukkitapi:getIp()) -- prints server ip
print(bukkitapi:getMotd()) -- prints server motd
```

### hooks
The library is needed to implement Java eventing.
You can find all the events on [this page](https://helpch.at/docs/1.16.5/) (org.bukkit.event.*)

Example:

```lua
-- hook.insert(EVENT_NAME, FN_ON_EVENT(EVENT), ID (optional))
hook.insert("AsyncPlayerChatEvent", function(event) -- event - userdata
    print(event:getMessage()) -- prints message
end)
```
### HTTP requests

To send HTTP requests to some server, there is a fetch function.

```lua
--fetch(METHOD, URL, FN_ON_RESPONSE(BODY, RESPONSE_CODE), POST_DATA_TABLE)

fetch("GET", "https://google.com", function(body, code)
    print(body) -- prints body
    print(code) -- prints http response code (200 = OK, etc)
end)
```