package com.gammas.geoex.items;

import com.gammas.geoex.utils.MaterialProperties;

import net.minecraft.item.ItemStack;

public class ItemMaterial extends ItemMultiple{

	// ITEMS \\
	public static ItemStack CALCITE;
	public static ItemStack SODA_ASH;
	public static ItemStack SILICA;
	public static ItemStack SULPHUR;
	public static ItemStack GANGUE;
	public static ItemStack COAL_COKE;
	public static ItemStack POWDER_CHARCOAL;
	public static ItemStack POWDER_COAL_COKE;
	
	// ROCKS \\
	public static ItemStack CHUNK_BANDED_IRON;
	public static ItemStack CHUNK_CHALK;
	public static ItemStack CHUNK_DOLOSTONE;
	public static ItemStack CHUNK_LIMESTONE;
	public static ItemStack CHUNK_SANDSTONE;
	public static ItemStack CHUNK_SHALE;
	public static ItemStack CHUNK_ANDESITE;
	public static ItemStack CHUNK_BASALT;
	public static ItemStack CHUNK_DIORITE;
	public static ItemStack CHUNK_GABBRO;
	public static ItemStack CHUNK_GRANITE;
	public static ItemStack CHUNK_KIMBERLITE;
	public static ItemStack CHUNK_OBSIDIAN;
	public static ItemStack CHUNK_RHYOLITE;
	public static ItemStack CHUNK_GNEISS;
	public static ItemStack CHUNK_MARBLE;
	public static ItemStack CHUNK_QUARTZITE;
	public static ItemStack CHUNK_SCHIST;
	public static ItemStack CHUNK_SKARN;
	public static ItemStack CHUNK_SLATE;
	
	
	// IRON \\
	public static ItemStack POWDER_BANDED_IRON;
	public static ItemStack SEPARATED_BANDED_IRON;
	public static ItemStack POWDER_MAGNETITE;
	public static ItemStack POWDER_HEMATITE;
	public static ItemStack GRIT_IRON_CRUDE;
	public static ItemStack GRIT_IRON_MEDIOCRE;
	public static ItemStack GRIT_IRON_HIGH;
	public static ItemStack THERMITE_IRON_ALUMINIUM;
	public static ItemStack POWDER_IRON;
	
	// COPPER \\
	public static ItemStack GRAVEL_CHALOCITE;
	public static ItemStack GRAVEL_CHALCOPYRITE;
	public static ItemStack GRAVEL_COVELLITE;
	public static ItemStack GRAVEL_CUPRITE;
	public static ItemStack GRIT_COPPER_CRUDE;
	public static ItemStack GRIT_COPPER_MEDOOCRE;
	public static ItemStack FROTH_COPPER;
	public static ItemStack PULP_COPPER;
	public static ItemStack POWDER_COPPER;
	
	// TIN \\
	public static ItemStack GRAVEL_CASSITERITE;
	public static ItemStack GRAVEL_CASSITERITE_ROASTED;
	public static ItemStack GRIT_TIN_CRUDE;
	public static ItemStack GRIT_TIN_MEDIOCRE;
	public static ItemStack PULP_TIN;
	public static ItemStack POWDER_TIN;
	
	// LEAD \\
	
	// SILVER \\
	
	
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
