package com.gammas.geoex.utils.handlers;

import com.gammas.geoex.init.ItemInit;

import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	public static void register() {
		OreDictionary.registerOre("crushedCarbon", ItemInit.CRUSHED_CHARCOAL);
		OreDictionary.registerOre("crushedCalcium", ItemInit.CRUSHED_LIMESTONE);
	}

}
