package com.gammas.geoex.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SubItemPropertyGetter implements IItemPropertyGetter{

	@Override
	public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
		return stack.getItemDamage();
	}

	
	
}
