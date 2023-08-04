package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import li.cil.oc.api.Machine;

@Mod(modid = OCRiskMod.MODID, name = OCRiskMod.NAME, version = OCRiskMod.VERSION, dependencies = "required-after:opencomputers@[1.8.0,)")
public class OCRiskMod
{
    public static final String MODID = "ocrisk";
    public static final String NAME = "ocrisk Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        Machine.add(OCRiskArchitecture.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //logger.info("{}", Machine);

        logger.info("{}", Machine.architectures());
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
