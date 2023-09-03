hook = {}
local hook_table = {}

function hook.insert(n, f, id)
  id = id or #hook_table+1 -- короче если нет айди, то эта хуйня причислит численный айди

  if not hook_table[n] then
    hook_table[n] = {}
  end

  hook_table[n][id] = f

  return id
end

function hook.call(n, ...)
  local tab = hook_table[n]
  if not tab then return end

  for k, v in pairs(tab) do
    v(...)
  end
end

function hook.getTable()
  return hook_table
end

function hook.remove(n, id)
  hook_table[n][id] = nil
end