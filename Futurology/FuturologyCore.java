/*
 * (c) John Carveth a.k.a. DtrollMC a.k.a Dtr011
 * Feel free to add this mod to any mod pack you please, as long as you notify me, via Reddit or MinecraftForums!
 * Special thanks to Everybody on the #minecraftforge irc network, for helping when needed!
 */

package Futurology;

import java.util.concurrent.Callable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = FuturologyCore.modid, name = "Futurology", version = "0.1")
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

	public final static Item glue = new ItemGlue(12303).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("glue");

	public final static Item tape = new ItemTape(12304).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("tape");

	public final static Item graphene = new ItemGraphene(12305).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("graphene");

	public final static Block tungstenForge = new BlockForge(501, 1,
			Material.rock).setUnlocalizedName("forge");

	public final static Block thoriumOre = new ThoriumOre(502, 1, Material.rock)
			.setCreativeTab(CreativeTabs.tabBlock).setHardness(4)
			.setUnlocalizedName("thoriumOre");
	
	public final static Item uranium = new ItemUranium(12306).setCreativeTab(
			CreativeTabs.tabMaterials).setUnlocalizedName("uranium");
	
	public final static Block uraniumOreBlock = new UraniumOre(503, 1,
			Material.rock).setCreativeTab(CreativeTabs.tabBlock).setHardness(4)
			.setUnlocalizedName("uraniumOre");

	// Item Stacks for the crafting below!
	ItemStack tungtstenIngotStack = new ItemStack(tungstenIngot);
	ItemStack tungstenOreStack = new ItemStack(tungstenOre);
	ItemStack cellStack = new ItemStack(cell);
	ItemStack plasmaCellStack = new ItemStack(plasmaCell);
	ItemStack glueStack = new ItemStack(glue);
	ItemStack tapeStack = new ItemStack(tape);
	ItemStack forgeStack = new ItemStack(tungstenForge);
	ItemStack thoriumOreStack = new ItemStack(thoriumOre);
	ItemStack uraniumStack = new ItemStack(uranium);
	ItemStack uraniumOreStack = new ItemStack(uraniumOreBlock);

	// Will be used for config options, the in-game difficulty selection button!
	public static boolean HardMode;

	public static final String modid = "Futurology";
	EventManager em = new EventManager();
	
	
	@PreInit
	// May be used later
	@Init
	public void load(FMLInitializationEvent event) throws Exception {
		// Registering the Tungsten Ore Block
		LanguageRegistry.addName(tungstenOre, "Tungsten Ore");
		MinecraftForge.setBlockHarvestLevel(tungstenOre, "pickaxe", 2);
		GameRegistry.registerBlock(tungstenOre, "Tore");
		// Thorium Ore Block Registry
		LanguageRegistry.addName(thoriumOre, "Thorium Ore");
		MinecraftForge.setBlockHarvestLevel(thoriumOre, "pickaxe", 2);
		GameRegistry.registerBlock(thoriumOre, "Thore");

		// Uranium and Uranium Ore
		LanguageRegistry.addName(uranium, "Uranium");
		GameRegistry.registerItem(uranium, "Uranium");
		
		LanguageRegistry.addName(uraniumOreBlock, "Uranium Ore");
		GameRegistry.registerBlock(uraniumOreBlock, "Uranium Ore");
		MinecraftForge.setBlockHarvestLevel(uraniumOreBlock, "pickaxe", 2);
		
		// Registering the Ingot item
		LanguageRegistry.addName(tungstenIngot, "Tungsten Ingot");
		GameRegistry.registerItem(tungstenIngot, "Tungsten Ingot");
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
				"ForgeTileEntity");

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
		oreRegistration();
		addOreRecipes();
		
		LanguageRegistry.addName(plasmaCell, "Plasma Cell");
		GameRegistry.registerItem(plasmaCell, "plasmaCell");

		GameRegistry.registerWorldGenerator(em);

	}

	

	//Ore Dictionary, for the FUTURE(ology)
	private void oreRegistration() {
		OreDictionary.registerOre("oreUranium", uranium);
		OreDictionary.registerOre("ingotTungsten", tungstenIngot);
		
		
	}
	private void addOreRecipes() {
		// TODO Auto-generated method stub
		
	}
	
	

}
