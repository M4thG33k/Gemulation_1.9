package com.m4thg33k.gemulation.core.proxies;

import com.m4thg33k.gemulation.Gemulation;
import com.m4thg33k.gemulation.blocks.ModBlocks;
import com.m4thg33k.gemulation.blocks.itemBlocks.ModItemBlocks;
import com.m4thg33k.gemulation.core.init.MiscInits;
import com.m4thg33k.gemulation.core.init.ModRecipes;
import com.m4thg33k.gemulation.gui.GemulationGuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e)
    {
//        GemulationPackets.init();
//        ModItems.createItems();
        ModBlocks.createBlocks();
        ModItemBlocks.create();
        MiscInits.addFurnaceTypes();
        MiscInits.addChestTypes();
    }

    public void init(FMLInitializationEvent e)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Gemulation.instance,new GemulationGuiHandler());
////        this.registerRenderInformation();
//        ModTiles.init();
        ModRecipes.createRecipes();
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }

//    public void handleNBTPacket(PacketNBT message)
//    {
//
//    }
//
//    public void registerRenderInformation()
//    {
//
//    }
//
//    public <T extends TileGemChest> void registerTileEntitySpecialRenderer(Class<T> type)
//    {
//
//    }
}
