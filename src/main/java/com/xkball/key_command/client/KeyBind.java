package com.xkball.key_command.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyBind {
    
    final String command;
    final int keyDefault;
    final boolean fakePlayer;
    
    @SideOnly(Side.CLIENT)
    KeyBinding real_key;
    
    public KeyBind(String command, int keyDefault,boolean fakePlayer) {
        this.command = command;
        this.keyDefault = keyDefault;
        this.fakePlayer = fakePlayer;
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
    
    public boolean useFakePlayer() {
        return fakePlayer;
    }
    
}
