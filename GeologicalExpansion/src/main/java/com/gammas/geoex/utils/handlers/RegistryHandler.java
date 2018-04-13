package com.gammas.geoex.utils.handlers;

import com.gammas.geoex.init.BlockInit;
import com.gammas.geoex.init.ItemInit;
import com.gammas.geoex.items.ItemMultiple;
import com.gammas.geoex.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ItemInit.ITEMS) {
			if (item instanceof IHasModel) {
				if (!item.getHasSubtypes()) {
					((IHasModel) item).registerModels(0, "", "inventory");
				} else {
					NonNullList<ItemStack> subItems = NonNullList.create();
					item.getSubItems(CreativeTabs.SEARCH, subItems);

					for (int i = 0; i < subItems.size(); i++) {
						if (subItems.get(i).getItem() instanceof ItemMultiple) {
							ItemMultiple subItem = (ItemMultiple) subItems.get(i).getItem();
							subItem.registerModels(i, "", "material=" + subItem.getName(i));
						}
					}

				}
			}
		}

		for (Block block : BlockInit.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels(0, "", "inventory");
			}
		}
	}

	public static Block fromBlock = Blocks.DIRT;
	public static Block toBlock = BlockInit.BANDED_IRON_FORMATION;

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void onEvent(ChunkEvent.Load event) {

		Chunk theChunk = event.getChunk();

		// replace all blocks of a type with another block type

		for (int x = 0; x < 16; ++x) {
			for (int z = 0; z < 16; ++z) {
				for (int y = 0; y < theChunk.getHeightValue(x, z) + 1; ++y) {
					if (theChunk.getBlockState(x, y, z).getBlock() == fromBlock && theChunk
							.getBiome(new BlockPos(x, y, z), theChunk.getWorld().getBiomeProvider()) == Biomes.RIVER) {
						theChunk.setBlockState(new BlockPos(x, y, z), toBlock.getDefaultState());
					}
				}
			}
		}
		theChunk.markDirty();
	}

	public static void otherRegistries() {
		// GameRegistry.addShapedRecipe(new ResourceLocation("crudeiron"), new
		// ResourceLocation("geoex"), new ItemStack(ItemInit.POWDER_CRUDE_IRON), "XXX",
		// "XXX", "XXX", 'X', OreDictionary.);
		GameRegistry.addSmelting(ItemInit.MORTAR_PESTLE_CLAY, new ItemStack(ItemInit.MORTAR_PESTLE_FIRED_CLAY), 0.5f);
		GameRegistry.addSmelting(ItemInit.POWDER_CRUDE_IRON, new ItemStack(Items.IRON_INGOT), 1.0f);
	}
}
