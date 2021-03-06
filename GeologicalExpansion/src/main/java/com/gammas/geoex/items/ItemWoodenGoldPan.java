package com.gammas.geoex.items;

import java.util.List;

import com.gammas.geoc.api.RecipeHolder;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemWoodenGoldPan extends BaseItem {

	public ItemWoodenGoldPan(String name) {
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(32);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		ItemStack itemstack = playerIn.getHeldItemMainhand();

		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

		if (!worldIn.isRemote) {
			if (raytraceresult == null) {
				return new ActionResult(EnumActionResult.PASS, itemstack);
			} else {
				if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
					BlockPos blockpos = raytraceresult.getBlockPos();

					if (!worldIn.isBlockModifiable(playerIn, blockpos)
							|| !playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit,
									itemstack)) {
						return new ActionResult(EnumActionResult.PASS, itemstack);
					}

					if (worldIn.getBlockState(blockpos).getMaterial() == Material.WATER) {
						System.out.println("Used on water");
						if (RecipeHolder.getPanningRecipe(playerIn.getHeldItemOffhand()).get(0) != ItemStack.EMPTY) {
							System.out.println("Recipe found!");
							ItemStack offHand = playerIn.getHeldItemOffhand();
							List<ItemStack> recipe = RecipeHolder.getPanningRecipe(offHand);

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
								worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ,
										SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
								return new ActionResult(EnumActionResult.SUCCESS, itemstack);
							}
						}
					}
				}
			}
		}

		return new ActionResult(EnumActionResult.PASS, itemstack);
	}

}
