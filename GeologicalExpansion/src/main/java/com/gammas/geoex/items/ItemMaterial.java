package com.gammas.geoex.items;

import com.gammas.geoex.utils.MaterialProperties;

import net.minecraft.item.ItemStack;

public class ItemMaterial extends ItemMultiple{

	// ITEMS
	public static ItemStack CHUNK_BANDED_IRON;
	public static ItemStack POWDER_BANDED_IRON;
	public static ItemStack SEPARATED_BANDED_IRON;
	
	
	public ItemMaterial(String name) {
		super(name);
		
		initItems();
	}
	
	private void initItems() {
		CHUNK_BANDED_IRON = addOreDictItem(0, "chunk_bandedIron", "chunkBandedIron", MaterialProperties.BANDED_IRON_HARDNESS);
		POWDER_BANDED_IRON = addOreDictItem(1, "powder_bandedIron", "powderBandedIron");
		SEPARATED_BANDED_IRON = addOreDictItem(2, "separated_bandedIron", "dustCrudeIronOre");
	}
	
	

}
