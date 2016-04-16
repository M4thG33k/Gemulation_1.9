package com.m4thg33k.gemulation.core.init;

import com.m4thg33k.gemulation.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.silentchaos512.gems.item.ModItems;
import net.silentchaos512.gems.lib.EnumGem;

public class ModRecipes {

    public static void createRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.gemChangerBlock,1,0),"www","coc","ooo",'w',new ItemStack(Blocks.wool,1, OreDictionary.WILDCARD_VALUE),'o',new ItemStack(Blocks.obsidian,1),'c',new ItemStack(ModItems.chaosOrb,1,1));

        //furnace upgrades
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(com.m4thg33k.lit.items.ModItems.itemFurnaceUpgrade,1,0),"grg","rcr","glg",'c',ModItems.craftingMaterial.getStack("ChaosCore"),'g',new ItemStack(ModItems.gem,1,OreDictionary.WILDCARD_VALUE),'r',"dustRedstone",'l',"gemLapis"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(com.m4thg33k.lit.items.ModItems.itemFurnaceUpgrade,2,1),"grg","rcr","glg",'c',ModItems.craftingMaterial.getStack("ChaosCore"),'g',new ItemStack(ModItems.gem,1,OreDictionary.WILDCARD_VALUE),'r',new ItemStack(Items.blaze_powder,1),'l',"gemLapis"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(com.m4thg33k.lit.items.ModItems.itemFurnaceUpgrade,2,2),"grg","rcr","glg",'c',ModItems.craftingMaterial.getStack("ChaosCore"),'g',new ItemStack(ModItems.gem,1,OreDictionary.WILDCARD_VALUE),'r',new ItemStack(com.m4thg33k.lit.blocks.ModBlocks.improvedFurnaceBlock,1),'l',"gemLapis"));

        //gem crafting tables
        for (EnumGem type : EnumGem.values())
        {
            //light gems
            if (type.ordinal()<16)
            {
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.gemCraftingTableBlock,1,type.ordinal()),new ItemStack(Blocks.crafting_table,1),type.getItemOreName()));
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.gemCraftingTableBlock,1,type.ordinal()),new ItemStack(com.m4thg33k.lit.blocks.ModBlocks.improvedCraftingTableBlock,1),type.getItemOreName()));
            }
            else
            {
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.darkGemCraftingTableBlock,1,type.ordinal()-16),new ItemStack(Blocks.crafting_table,1),type.getItemOreName()));
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.darkGemCraftingTableBlock,1,type.ordinal()-16),new ItemStack(com.m4thg33k.lit.blocks.ModBlocks.improvedCraftingTableBlock,1),type.getItemOreName()));
            }
        }

    }
}
