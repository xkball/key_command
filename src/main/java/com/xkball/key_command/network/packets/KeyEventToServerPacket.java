package com.xkball.key_command.network.packets;

import com.xkball.key_command.client.KeyBind;
import com.xkball.key_command.client.KeyManager;
import com.xkball.key_command.network.GCPacket;
import io.netty.buffer.ByteBuf;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class KeyEventToServerPacket implements GCPacket {
    final String command;
    
    public KeyEventToServerPacket(String command) {
        this.command = command;
    }
    
    @SuppressWarnings("unused")
    public KeyEventToServerPacket(ByteBuf byteBuf){
        command = ByteBufUtils.readUTF8String(byteBuf);
    }
    
    @Override
    public void writeData(ByteBuf out) {
        ByteBufUtils.writeUTF8String(out,command);
    }
    
    @Override
    public void onServer(EntityPlayer player) {
        for(KeyBind key : KeyManager.keys){
            if(key.getCommand().equals(command)){
                MinecraftServer server = player.getServer();
                if(server != null){
                    server.commandManager.executeCommand(new ICommandSender() {
                        @Override
                        public String getName() {
                            return player.getDisplayNameString();
                        }
                        
                        @Override
                        public boolean canUseCommand(int permLevel, String commandName) {
                            return true;
                        }
                        
                        @Override
                        public World getEntityWorld() {
                            return player.getEntityWorld();
                        }
                        
                        @Override
                        public MinecraftServer getServer() {
                            return server;
                        }
                    },command);
                }
            }
        }
    }
}
