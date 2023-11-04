package org.smokingplaya.mlua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.BiConsumer;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.Varargs;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

public class MLuaHTTPLib {
    public void Fetch(Varargs args) {
        String method = args.checkjstring(1);
        String url = args.checkjstring(2);
        LuaFunction callback = args.checkfunction(3);
        String postData = null;

        if (method.equals("POST")) {
            LuaValue data = args.arg(4);
            if (data.istable()) {
                LuaTable postTable = (LuaTable) data;
                StringBuilder postDataBuilder = new StringBuilder();
                for (LuaValue key : postTable.keys()) {
                    postDataBuilder.append(key.tojstring()).append("=").append(postTable.get(key).tojstring()).append("&");
                }
                postData = postDataBuilder.toString();
                if (postData.length() > 0) {
                    postData = postData.substring(0, postData.length() - 1); // Удаляем последний "&"
                }
            }
        }

        try {
            URL connectionUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) connectionUrl.openConnection();
            connection.setRequestMethod(method);

            if (method.equals("POST") && postData != null) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] postDataBytes = postData.getBytes("UTF-8");
                    os.write(postDataBytes);
                }
            }

            int responseCode = connection.getResponseCode();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                callback.invoke(LuaValue.varargsOf(new LuaValue[] {LuaValue.valueOf(response.toString()), LuaValue.valueOf(responseCode)}));
            }
        } catch (IOException e) {
            // Обработка ошибок
            callback.invoke(LuaValue.varargsOf(new LuaValue[] {LuaValue.NIL, LuaValue.valueOf(-1)})); // Передаем nil и -1 в случае ошибки
        }
    }
}

