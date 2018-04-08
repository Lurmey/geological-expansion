package com.gammas.geoex.init;

import java.util.ArrayList;
import java.util.List;

import com.gammas.geoex.items.BaseItem;
import com.gammas.geoex.items.ItemMortarPestle;
import com.gammas.geoex.items.ItemWoodenGoldPan;
import com.gammas.geoex.utils.MaterialProperties;

import net.minecraft.item.Item;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Items
	public static final Item BANDED_IRON_CHUNK = new BaseItem("banded_iron_chunk").setHardness(MaterialProperties.BANDED_IRON_HARDNESS);
	public static final Item BANDED_IRON_CRUSHED = new BaseItem("banded_iron_crushed");
	public static final Item BANDED_IRON_SEPERATED = new BaseItem("banded_iron_seperated");
	
	public static final Item LIMESTONE_CHUNK = new BaseItem("limestone_chunk").setHardness(MaterialProperties.LIMESTONE_HARDNESS);
	public static final Item LIMESTONE_CRUSHED = new BaseItem("limestone_crushed");
	
	public static final Item CHARCOAL_CRUSHED = new BaseItem("charcoal_crushed");
	
	public static final Item CRUDE_IRON_POWDER = new BaseItem("crude_iron_powder");
	
	public static final Item CLAY_MORTAR_PESTLE = new BaseItem("clay_mortar_pestle");

	// Tools
	public static final Item WOODEN_GOLD_PAN = new ItemWoodenGoldPan("wooden_gold_pan");
	public static final Item FIRED_CLAY_MORTAR_PESTLE = new ItemMortarPestle("fired_clay_mortar_pestle", 32).setHardness(MaterialProperties.FIRED_CLAY_HARDNESS);
}
