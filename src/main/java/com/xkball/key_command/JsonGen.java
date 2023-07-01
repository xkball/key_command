package com.xkball.key_command;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonGen {
    public static void main(String[] args) {
        JsonObject key = new JsonObject();
        key.addProperty("command","kill @s");
        key.addProperty("default_key",0x2F);
        JsonArray array = new JsonArray();
        array.add(key);
        
        JsonObject out = new JsonObject();
        out.add("key_array",array);
        
        System.out.println(KeyCommand.jsonToString(out));
    }
}
