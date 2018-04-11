package com.gammas.geoex.utils.handlers;

import com.gammas.geoex.init.BlockInit;
import com.gammas.geoex.init.ItemInit;
import com.gammas.geoex.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
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
				((IHasModel) item).registerModels();
			}
		}

		for (Block block : BlockInit.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}
	}

	public static void otherRegistries() {
		// GameRegistry.addShapedRecipe(new ResourceLocation("crudeiron"), new
		// ResourceLocation("geoex"), new ItemStack(ItemInit.POWDER_CRUDE_IRON), "XXX",
		// "XXX", "XXX", 'X', OreDictionary.);
		GameRegistry.addSmelting(ItemInit.MORTAR_PESTLE_CLAY, new ItemStack(ItemInit.MORTAR_PESTLE_FIRED_CLAY), 0.5f);
		GameRegistry.addSmelting(ItemInit.POWDER_CRUDE_IRON, new ItemStack(Items.IRON_INGOT), 1.0f);
	}
}
