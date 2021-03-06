package com.m4thg33k.gemulation.blocks.itemBlocks;

import com.m4thg33k.gemulation.Gemulation;
import com.m4thg33k.gemulation.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class DarkGemChestItemBlock extends ItemBlock {

    public DarkGemChestItemBlock(Block block)
    {
        super(block);

        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        this.setRegistryName(Gemulation.MODID, Names.DARK_GEM_CHEST);
    }

    @Override
    public int getMetadata(int damage) {
        return damage<32?damage:0;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + stack.getItemDamage();
//        return "tile.gemulation:"+ EnumGem.values()[stack.getItemDamage()].getGemName() + "_chest";
    }
}
