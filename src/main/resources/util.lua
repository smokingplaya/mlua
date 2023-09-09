local types = {"table", "string", "number", "function"}

for _, type_ in pairs(types) do
  _G["is" .. type_] = function(obj)
    return type(obj) == type_
  end
end

function add(name, data) _G[name] = data end

function PrintTable(t, i) -- todo tabulation (i)
  local i = i or 0
  for k, v in pairs(t) do
    if istable(v) then
      print(k .. ":")
      PrintTable(v, i+1)
    else
      print(k, v)
    end
  end
end

--if not luaprint then luaprint = print end

--function print(...)
--  for _, obj in pairs({...}) do
--    local method = istable(obj) and PrintTable or luaprint
--    method(obj)
--  end
--end