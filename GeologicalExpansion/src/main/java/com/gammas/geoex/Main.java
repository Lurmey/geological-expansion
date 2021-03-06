package com.gammas.geoex;

import org.apache.logging.log4j.Logger;

import com.gammas.geoex.init.ItemInit;
import com.gammas.geoex.proxy.CommonProxy;
import com.gammas.geoex.utils.References;
import com.gammas.geoex.utils.handlers.OreDictionaryHandler;
import com.gammas.geoex.utils.handlers.RecipeHandler;
import com.gammas.geoex.utils.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION)
public class Main {
	private static Logger logger;

	@Instance
	public static Main instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		OreDictionaryHandler.register();
		ItemInit.MATERIALS.registerOreDictEntries();
		RecipeHandler.addRecipes();
		RegistryHandler.otherRegistries();
	}
}
