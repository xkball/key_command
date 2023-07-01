package com.xkball.key_command;

import com.xkball.key_command.client.KeyManager;
import com.xkball.key_command.config.ConfigReader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

@Mod(modid = KeyCommand.MODID, name = KeyCommand.NAME, version = KeyCommand.VERSION)
public class KeyCommand
{
    public static final String MODID = "key_command";
    public static final String NAME = "Key Command";
    public static final String VERSION = "1.0";
    
    public static File configDir = Loader.instance().getConfigDir();

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        File config = new File(configDir,MODID+"/config.json");
        if(config.isDirectory()){
            //noinspection ResultOfMethodCallIgnored
            config.delete();
        }
        if(!config.exists()){
            logger.info("Key Command cannot find config file.This mod will have no effect to game.");
            //noinspection ResultOfMethodCallIgnored
            config.getParentFile().mkdirs();
            try {
                //noinspection ResultOfMethodCallIgnored
                config.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                ConfigReader.readConfig(config);
            } catch (Exception e){
                logger.info("Key Command cannot read config file.This mod will have no effect to game." +
                        "Please check your config file."+config.getAbsolutePath());
            }
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        KeyManager.init();
    }
}
