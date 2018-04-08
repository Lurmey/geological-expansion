package com.gammas.geoex.init;

import java.util.ArrayList;
import java.util.List;

import com.gammas.geoex.blocks.BaseBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	// Blocks
	public static final Block BANDED_IRON_FORMATION = new BaseBlock("banded_iron_formation", Material.ROCK, ItemInit.BANDED_IRON_CHUNK, 2, 4, false);
	
}
