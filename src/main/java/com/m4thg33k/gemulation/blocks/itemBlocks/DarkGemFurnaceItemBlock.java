package com.m4thg33k.gemulation.blocks.itemBlocks;

import com.m4thg33k.gemulation.Gemulation;
import com.m4thg33k.gemulation.core.util.StringHelper;
import com.m4thg33k.gemulation.lib.Constants;
import com.m4thg33k.gemulation.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.silentchaos512.gems.lib.EnumGem;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class DarkGemFurnaceItemBlock extends ItemBlock{

    public DarkGemFurnaceItemBlock(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(Gemulation.tabGemulation);

        this.setRegistryName(Gemulation.MODID, Names.DARK_GEM_FURNACE);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + stack.getItemDamage();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> list, boolean advanced) {
        boolean shifted = Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);

        if (shifted)
        {
            EnumGem type = EnumGem.values()[stack.getItemDamage()+16];

            list.add(TextFormatting.ITALIC + "Properties");
            list.add("----------------");
            list.add(TextFormatting.GOLD + "Time Reduction Multiplier: " + TextFormatting.RESET + StringHelper.limitToNCharacters(""+Constants.getCookFactor(type),4));
            list.add(TextFormatting.GOLD + "Fuel Bonus Multiplier: " + TextFormatting.RESET + StringHelper.limitToNCharacters(""+Constants.getFuelBoost(type),5));
            list.add(TextFormatting.GOLD + "Upgrade Slots: " + TextFormatting.RESET + StringHelper.limitToNCharacters(""+Constants.getUpgradeCount(type),1));
            list.add(TextFormatting.GOLD + "Fuel Capacity: " + TextFormatting.RESET + StringHelper.limitToNCharacters(""+Constants.getMaxStacksFuel(type),5));
        }
        else
        {
            list.add(TextFormatting.ITALIC + "<Press Shift>");
        }
    }
}
