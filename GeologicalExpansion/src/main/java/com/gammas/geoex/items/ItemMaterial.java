package com.gammas.geoex.items;

import com.gammas.geoex.utils.handlers.EnumHandler.Materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class ItemMaterial extends BaseItem {

	public ItemMaterial(String name) {
		super(name);

		setHasSubtypes(true);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		for (int i = 0; i < Materials.values().length; i++) {
			items.add(new ItemStack(this, 1, i));
			if (Materials.values()[i].getOreDictionaryEntry() != "null")
				OreDictionary.registerOre(Materials.values()[i].getOreDictionaryEntry(), new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		for (int i = 0; i < Materials.values().length; i++) {
			if (stack.getMetadata() == i) {
				return getUnlocalizedName() + "." + Materials.values()[i].getName();
			}
		}
		return "invalid.item";
	}

	@Override
	public String getName(int meta) {
		return Materials.values()[meta].getName();
	}
}
