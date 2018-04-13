package com.gammas.geoex.items;

import java.util.ArrayList;
import java.util.Map;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class ItemMultiple extends BaseItem {

	public TMap<Integer, ItemEntry> itemMap = new THashMap<>();
	public ArrayList<Integer> subItems = new ArrayList<>();
	private TMap<String, ItemStack> oreDictReg = new THashMap<>();

	public ItemMultiple(String name) {
		super(name);

		setHasSubtypes(true);
	}

	public ItemStack addItem(int meta, ItemEntry entry) {
		// If the current metadata value is already registered, don't add it again
		if (itemMap.containsKey(meta)) {
			return ItemStack.EMPTY;
		}

		// Add the new item to the map and list
		itemMap.put(meta, entry);
		subItems.add(meta);

		// Return a new ItemStack of this item with the given meta value
		return new ItemStack(this, 1, meta);
	}

	public ItemStack addItem(int meta, String name) {
		return addItem(meta, new ItemEntry(name));
	}

	public ItemStack addItem(int meta, String name, float hardness) {
		return addItem(meta, new ItemEntry(name, hardness));
	}

	public ItemStack addOreDictItem(int meta, String name, String oreName, float hardness) {
		ItemStack stack = addItem(meta, name, hardness);
		oreDictReg.put(oreName, stack);
		// OreDictionary.registerOre(oreName, stack);

		return stack;
	}

	public ItemStack addOreDictItem(int meta, String name, String oreName) {
		ItemStack stack = addItem(meta, name);
		oreDictReg.put(oreName, stack);
		// OreDictionary.registerOre(oreName, stack);

		return stack;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		for (int meta : subItems) {
			items.add(new ItemStack(this, 1, meta));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (!itemMap.containsKey(stack.getMetadata())) {
			return "item.invalid";
		}

		ItemEntry item = itemMap.get(stack.getMetadata());
		return getUnlocalizedName() + "." + item.name;
	}

	@Override
	public String getName(int meta) {
		if (!itemMap.containsKey(meta)) {
			return "item.invalid";
		}

		ItemEntry item = itemMap.get(meta);
		return item.name;
	}
	
	public void registerOreDictEntries() {
		for (TMap.Entry<String, ItemStack> entry : oreDictReg.entrySet()) {
			OreDictionary.registerOre(entry.getKey(), entry.getValue());
		}
	}

	public class ItemEntry {
		public String name;
		public float hardness;

		ItemEntry(String name, float hardness) {
			this.name = name;
			this.hardness = hardness;
		}

		ItemEntry(String name) {
			this(name, 0f);
		}
	}
}
