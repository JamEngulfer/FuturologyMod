//(c) John Carveth, 2013
//I am awesome! Really really awesome! I bet you're not as awesome as I am!

package Futurology;

import java.util.concurrent.Callable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Futurology", name = "Futurology", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FuturologyCore {

	// Blocks and Items
	public final static Block tungstenOre = new TungstenOre(500, 1,
			Material.rock);
	public static TungstenOre instance;
	public final static Item tungstenIngot = new TungstenIngot(12300)
			.setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName(
					"tungstenIngot");
	public final static Item cell = new ItemCell(12301).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("Cell");
	public final static Item plasmaCell = new ItemCell(12302).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("plasmaCell");
	public final static Item glue = new ItemCell(12303).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("glue");
	public final static Item tape = new ItemTape(12304).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("tape");
	public final static Item graphene = new ItemGraphene(12305).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("graphene");
	public final static Block tungstenForge = new BlockForge(501, 1,
			Material.rock).setUnlocalizedName("forgeFront");
	// Item Stacks for the crafting below!
	ItemStack tungtstenIngotStack = new ItemStack(tungstenIngot);
	ItemStack tungstenOreStack = new ItemStack(tungstenOre);
	ItemStack cellStack = new ItemStack(cell);
	ItemStack plasmaCellStack = new ItemStack(plasmaCell);
	ItemStack glueStack = new ItemStack(glue);
	ItemStack tapeStack = new ItemStack(tape);
	ItemStack forgeStack = new ItemStack(tungstenForge);
	
	
	//Will be used for config options, the in-game difficulty selection button!
	public static boolean HardMode;

	@PreInit
	public void HateGreg() throws Exception {
		if (Loader.isModLoaded("GregTech_Addon")) {
			throw new Exception(
					"GregTech doesn't work with this mod, pick a side please, thanks! This mod was made to offer a replacement for the arrogant nerfing of Gregorius, and as such, our mods won't coincide! Vote DtrollMC for President!");

		}
	}

	@Init
	public void load(FMLInitializationEvent event) throws Exception {
		// Registering the Tungsten Ore Block
		LanguageRegistry.addName(tungstenOre, "Tungsten Ore");
		MinecraftForge.setBlockHarvestLevel(tungstenOre, "pickaxe", 3);
		GameRegistry.registerBlock(tungstenOre, "Tore");

		// Registering the Ingot item
		LanguageRegistry.addName(tungstenIngot, "§8Tungsten Ingot");

		// Registering Cell and Plasma Cell
		LanguageRegistry.addName(cell, "Empty Cell");
		GameRegistry.registerItem(cell, "Cell");

		// Glue And Tape Registry
		LanguageRegistry.addName(glue, "Glue");
		GameRegistry.registerItem(glue, "Glue");

		// Graphene Stuff Registries
		LanguageRegistry.addName(graphene, "Graphene");
		GameRegistry.registerItem(graphene, "Graphene");

		// Tape
		LanguageRegistry.addName(tape, "Sticky-Tape");
		GameRegistry.registerItem(tape, "Sticky-Tape");

		// MACHINES!
		LanguageRegistry.addName(tungstenForge, "Tungsten Forge");
		GameRegistry.registerBlock(tungstenForge, "forge");

		GameRegistry.registerTileEntity(Futurology.TileEntityForge.class,
				"13989");

		// If hardmode is off, which it is unless changed, these are the
		// recipes.
		if (!HardMode) {
			GameRegistry.addRecipe(tapeStack, new Object[] { "ppp", "ggg",
					"   ", 'p', Item.paper, 'g', FuturologyCore.glue });
			GameRegistry.addRecipe(cellStack, new Object[] { " x ", "x x",
					" x ", 'x', FuturologyCore.tungstenIngot });
			GameRegistry.addSmelting(FuturologyCore.tungstenOre.blockID,
					new ItemStack(FuturologyCore.tungstenIngot), 1.0F);
			GameRegistry.addRecipe(forgeStack, new Object[] { "fff", "f f",
					"fff", 'f', FuturologyCore.tungstenIngot });
		} else if (HardMode) {
			// nothing here yet! Add Complex Recipes Once Machines are added.
		}

		LanguageRegistry.addName(plasmaCell, "Plasma Cell");
		GameRegistry.registerItem(plasmaCell, "plasmaCell");

		// What an awesome method yes?
		HateGreg();
	}

}
