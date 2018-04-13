package com.gammas.geoex.utils.handlers;

import com.gammas.geoc.api.RecipeHolder;
import com.gammas.geoex.init.ItemInit;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeHandler {
	
	private static final RecipeHandler INSTANCE = new RecipeHandler();
	
	public static RecipeHandler getInstance() {
		return INSTANCE;
	}
	
	public static void addRecipes() {
		
		RecipeHolder.addCrushingRecipe(ItemInit.MATERIALS.CHUNK_BANDED_IRON, ItemInit.MATERIALS.POWDER_BANDED_IRON);
		RecipeHolder.addCrushingRecipe(new ItemStack(ItemInit.CHUNK_LIMESTONE, 1), new ItemStack(ItemInit.CRUSHED_LIMESTONE, 1));
		RecipeHolder.addCrushingRecipe(new ItemStack(Items.COAL, 1, 1), new ItemStack(ItemInit.CRUSHED_CHARCOAL));
		
		RecipeHolder.addPanningRecipe(new ItemStack(ItemInit.MATERIALS, 4, 1), new ItemStack(ItemInit.MATERIALS, 2, 2));
		
	}

}
