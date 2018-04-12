package com.gammas.geoex.items;

import com.gammas.geoc.api.item.IItemProperties;
import com.gammas.geoex.Main;
import com.gammas.geoex.init.ItemInit;
import com.gammas.geoex.utils.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseItem extends Item implements IHasModel, IItemProperties{

	float hardness, quality;
	
	public BaseItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels(int meta, String variantName, String id) {
		Main.proxy.registerItemRenderer(this, meta, variantName, id);
	}

	@Override
	public float getQualityLevel() {
		return 0;
	}

	@Override
	public void setQualityLevel(float qualityLevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getHardness() {
		return hardness;
	}

	@Override
	public Item setHardness(float hardness) {
		this.hardness = hardness;
		return this;
	}
	
	
	
}
