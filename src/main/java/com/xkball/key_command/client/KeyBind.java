package com.xkball.key_command.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyBind {
    
    final String command;
    final int keyDefault;
    
    @SideOnly(Side.CLIENT)
    KeyBinding real_key;
    
    public KeyBind(String command, int keyDefault) {
        this.command = command;
        this.keyDefault = keyDefault;
    }
    
    @SideOnly(Side.CLIENT)
    public KeyBinding getReal_key() {
        return real_key;
    }
    
    @SideOnly(Side.CLIENT)
    public void setReal_key(KeyBinding real_key) {
        this.real_key = real_key;
    }
    
    public String getCommand() {
        return command;
    }
}
