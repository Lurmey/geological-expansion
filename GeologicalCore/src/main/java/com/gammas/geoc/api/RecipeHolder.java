package com.gammas.geoc.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;

public class RecipeHolder {

	private static final Map<ItemStack, List<ItemStack>> crushingRecipes = new HashMap<ItemStack, List<ItemStack>>();
	private static final Map<ItemStack, List<ItemStack>> panningRecipes = new HashMap<ItemStack, List<ItemStack>>();
	
	public static List<ItemStack> getCrushingRecipe(ItemStack input) {
		List<ItemStack> recipe = new ArrayList<ItemStack>();
		
		System.out.println("Recipe count: " + crushingRecipes.size());
		
		for (ItemStack itemStack : crushingRecipes.keySet()) {
			if (input.isItemEqual(itemStack)) {
				recipe.add(itemStack);
				recipe.addAll(crushingRecipes.get(itemStack));
				return recipe;
			}
		}
		
		System.out.println("Recipe Not Found!");
		
		recipe.add(ItemStack.EMPTY);
		return recipe;
	}
	
	public static List<ItemStack> getPanningRecipe(ItemStack input) {
		List<ItemStack> recipe = new ArrayList<ItemStack>();
		
		System.out.println("Recipe count: " + panningRecipes.size());
		
		for (ItemStack itemStack : panningRecipes.keySet()) {
			if (input.isItemEqual(itemStack)) {
				recipe.add(itemStack);
				recipe.addAll(panningRecipes.get(itemStack));
				return recipe;
			}
		}
		
		System.out.println("Recipe Not Found!");
		
		recipe.add(ItemStack.EMPTY);
		return recipe;
	}
	
	public static void addCrushingRecipe(ItemStack input, ItemStack... outputs) {
		if (!crushingRecipes.containsKey(input))
			crushingRecipes.put(input, Arrays.asList(outputs));
	}
	
	public static void addPanningRecipe(ItemStack input, ItemStack... outputs) {
		if (!panningRecipes.containsKey(input))
			panningRecipes.put(input, Arrays.asList(outputs));
	}
	
	public static boolean hasCrushingRecipe(ItemStack input) {
		for (ItemStack itemStack : crushingRecipes.keySet()) {
			if (input.isItemEqual(itemStack)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean hasPanningRecipe(ItemStack input) {
		for (ItemStack itemStack : panningRecipes.keySet()) {
			if (input.isItemEqual(itemStack)) {
				return true;
			}
		}
		
		return false;
	}

}
