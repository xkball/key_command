package com.xkball.key_command.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xkball.key_command.KeyCommand;
import com.xkball.key_command.client.KeyBind;
import com.xkball.key_command.client.KeyManager;

import java.io.File;
import java.nio.file.Files;

public class ConfigReader {
    
    public static void readConfig(File file) throws IllegalArgumentException{
        try {
            JsonElement jsonExisted = new JsonParser().parse(new String(Files.readAllBytes(file.toPath())));
            if(jsonExisted.isJsonNull()) throw new IllegalArgumentException();
            
            JsonArray keyArray = jsonExisted.getAsJsonObject().getAsJsonArray("key_array");
            
            for (JsonElement element : keyArray) {
                JsonObject obj = element.getAsJsonObject();
                String command = obj.get("command").getAsString();
                int keyDefault = 0;
                if (obj.has("default_key")) {
                    keyDefault = obj.get("default_key").getAsInt();
                }
                boolean fakePlayer = true;
                if(obj.has("fake_player")){
                    fakePlayer = obj.get("fake_player").getAsBoolean();
                }
                KeyManager.keys.add(new KeyBind(command, keyDefault,fakePlayer));
                
            }
            KeyCommand.logger.info("read config successfully.");
            
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
