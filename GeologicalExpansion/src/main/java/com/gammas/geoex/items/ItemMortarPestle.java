package com.gammas.geoex.items;

import java.util.List;

import com.gammas.geoc.api.RecipeHolder;
import com.gammas.geoc.api.item.IItemProperties;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemMortarPestle extends BaseItem{
	
	public ItemMortarPestle(String name, int durability) {
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
		ItemStack offHand = playerIn.getHeldItemOffhand();
		
		if (!worldIn.isRemote) {
			if (RecipeHolder.getCrushingRecipe(offHand).get(0) != ItemStack.EMPTY) {
				if (((BaseItem) offHand.getItem()).getHardness() < getHardness()) {
					List<ItemStack> recipe = RecipeHolder.getCrushingRecipe(offHand);

					// The player has enough of the dust in their hand
					if (offHand.getCount() >= recipe.get(0).getCount()) {
						System.out.println("Recipe input confirmed!");
						offHand.shrink(recipe.get(0).getCount());

						for (int i = 1; i < recipe.size(); i++) {
							worldIn.spawnEntity(
									new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ,
											new ItemStack(recipe.get(i).getItem(), recipe.get(i).getCount())));
						}

						itemstack.damageItem(1, playerIn);
						return new ActionResult(EnumActionResult.SUCCESS, itemstack);
					}
				}
			}
		}
		
		return new ActionResult(EnumActionResult.PASS, itemstack);
	}

}
