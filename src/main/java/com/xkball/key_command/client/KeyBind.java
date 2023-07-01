package com.xkball.key_command.client;

import net.minecraft.client.settings.KeyBinding;

public class KeyBind {
    
    final String command;
    final int keyDefault;
    
    KeyBinding real_key;
    
    public KeyBind(String command, int keyDefault) {
        this.command = command;
        this.keyDefault = keyDefault;
    }
    
    public KeyBinding getReal_key() {
        return real_key;
    }
    
    public void setReal_key(KeyBinding real_key) {
        this.real_key = real_key;
    }
    
    public String getCommand() {
        return command;
    }
}
