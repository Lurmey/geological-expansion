package com.gammas.geoex.init;

import java.util.ArrayList;
import java.util.List;

import com.gammas.geoex.blocks.BaseBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	// Blocks
	public static final Block BANDED_IRON_FORMATION = new BaseBlock("banded_iron_formation", Material.ROCK, ItemInit.MATERIALS.CHUNK_BANDED_IRON, 2, 4, false);
	public static final Block LIMESTONE = new BaseBlock("limestone", Material.ROCK, new ItemStack(ItemInit.CHUNK_LIMESTONE), 2, 4, false);
	
}
