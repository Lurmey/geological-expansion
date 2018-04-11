package com.gammas.geoc.api.item;

import net.minecraft.item.Item;

public interface IItemProperties {
	
	public float getQualityLevel();
	public void setQualityLevel(float qualityLevel);
	
	public float getHardness();
	public Item setHardness(float hardness);

}
