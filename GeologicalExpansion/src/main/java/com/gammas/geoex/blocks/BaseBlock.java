package com.gammas.geoex.blocks;

import java.util.Random;

import com.gammas.geoex.Main;
import com.gammas.geoex.init.BlockInit;
import com.gammas.geoex.init.ItemInit;
import com.gammas.geoex.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BaseBlock extends Block implements IHasModel{

	Item dropItem;
	int minDropAmount, maxDropAmount;
	boolean isTransparent;

	public BaseBlock(String name, Material material) {
		this(name, material, null, 1, 1, false);
	}

	public BaseBlock(String name, Material material, boolean isTransparent) {
		this(name, material, null, 1, 1, isTransparent);
	}

	public BaseBlock(String name, Material material, Item dropItem){
		this(name, material, dropItem, 1, 1, false);
	}

	public BaseBlock(String name, Material material, Item dropItem, int dropAmount){
		this(name, material, dropItem, dropAmount, dropAmount, false);
	}

	public BaseBlock(String name, Material material, Item dropItem, int minDropAmount, int maxDropAmount, boolean isTransparent){
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		BlockInit.BLOCKS.add(this);

		Item itemBlock = new ItemBlock(this).setRegistryName(this.getRegistryName());
		ItemInit.ITEMS.add(itemBlock);

		this.dropItem = dropItem;
		this.minDropAmount = minDropAmount;
		this.maxDropAmount = maxDropAmount;
		this.isTransparent = isTransparent;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return (dropItem == null) ? Item.getItemFromBlock(this) : dropItem;
	}

	@Override
	public int quantityDropped(Random random) {
		return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount + 1);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return !isTransparent;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
