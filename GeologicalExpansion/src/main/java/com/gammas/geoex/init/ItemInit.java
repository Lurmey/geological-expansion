package com.gammas.geoex.init;

import java.util.ArrayList;
import java.util.List;

import com.gammas.geoex.items.BaseItem;
import com.gammas.geoex.items.ItemMaterial;
import com.gammas.geoex.items.ItemMortarPestle;
import com.gammas.geoex.items.ItemWoodenGoldPan;
import com.gammas.geoex.utils.MaterialProperties;

import net.minecraft.item.Item;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Items
	public static final Item CHUNK_BANDED_IRON = new BaseItem("chunk_banded_iron").setHardness(MaterialProperties.BANDED_IRON_HARDNESS);
	public static final Item CRUSHED_BANDED_IRON = new BaseItem("crushed_banded_iron");
	public static final Item SEPARATED_BANDED_IRON = new BaseItem("separated_banded_iron");
	
	public static final Item TEST_MATERIAL = new ItemMaterial("test_material");
	
	public static final Item CHUNK_LIMESTONE = new BaseItem("chunk_limestone").setHardness(MaterialProperties.LIMESTONE_HARDNESS);
	public static final Item CRUSHED_LIMESTONE = new BaseItem("crushed_limestone");
	
	public static final Item CRUSHED_CHARCOAL = new BaseItem("crushed_charcoal");
	
	public static final Item POWDER_CRUDE_IRON = new BaseItem("powder_crude_iron");
	
	public static final Item MORTAR_PESTLE_CLAY = new BaseItem("mortar_pestle_clay").setMaxStackSize(1);

	// Tools
	public static final Item GOLD_PAN_WOOD = new ItemWoodenGoldPan("gold_pan_wood");
	public static final Item MORTAR_PESTLE_FIRED_CLAY = new ItemMortarPestle("mortar_pestle_fied_clay", 32).setHardness(MaterialProperties.FIRED_CLAY_HARDNESS);
}
