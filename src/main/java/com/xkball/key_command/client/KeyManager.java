package com.xkball.key_command.client;

import com.xkball.key_command.network.GCNetworkManager;
import com.xkball.key_command.network.packets.KeyEventToServerPacket;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class KeyManager {
    public static List<KeyBind> keys = new ArrayList<>();
    
    public static void init(){
        if(FMLCommonHandler.instance().getSide() == Side.CLIENT){
            for(KeyBind key : keys){
                if(key.keyDefault != 0){
                    KeyBinding real_key = new KeyBinding("key.command."+key.command,
                            KeyConflictContext.IN_GAME,
                            KeyModifier.NONE,
                            key.keyDefault,
                            "key.category.key_command");
                    key.setReal_key(real_key);
                    ClientRegistry.registerKeyBinding(real_key);
                    
                }
                
            }
        }
        
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onKeyPressed(InputEvent.KeyInputEvent event) {
        for(KeyBind key : keys){
            if(key.getReal_key().isPressed()){
                //发包
                GCNetworkManager.INSTANCE.sendPacketToServer(new KeyEventToServerPacket(key.command));
                return;
            }
        }
    }
    
}
