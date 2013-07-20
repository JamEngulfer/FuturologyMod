package Futurology;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.BlockProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*This Block is a very VERY WIP block. It will be the template for all of the other machines.
 * Things that need adding:
 * -GUI
 * -MultiSided Textures
 * -Rotation based on player's location
 * -Interaction with Buildcraft power infrastructure!
 * 
 */
public class BlockForge extends Block implements BlockProxy {
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	private Icon bottomIcon;
	private Icon frontIcon;
	private Icon backIcon;
	private Icon leftIcon;
	private Icon rightIcon;

	public BlockForge(int id, int texture, Material material) {
		super(id, material);

		setHardness(5.0F);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);

	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return par1 == 0 ? this.bottomIcon : (par1 == 1 ? this.topIcon
				: (par1 == 2 ? this.backIcon : (par1 == 3 ? this.frontIcon
						: (par1 == 4 ? this.leftIcon
								: (par1 == 5 ? this.rightIcon : null)))));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		/** Default Block Icon **/
		this.blockIcon = par1IconRegister
				.registerIcon("Futurology:defaultIcon");

		this.topIcon = par1IconRegister.registerIcon("Futurology:Icon");// Top
		this.bottomIcon = par1IconRegister.registerIcon("Futurology:Icon");// Bottom
		this.frontIcon = par1IconRegister.registerIcon("Futurology:frontIcon");// Front
		this.backIcon = par1IconRegister.registerIcon("Futurology:Icon");// Back
		this.leftIcon = par1IconRegister.registerIcon("Futurology:Icon");// Left
		this.rightIcon = par1IconRegister.registerIcon("Futurology:Icon");// Right
	}

	public int idDropped(int par1, Random random, int par2) {
		return FuturologyCore.tungstenIngot.itemID;
	}

}
