package Futurology;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.BlockProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*This Block is a very VERY WIP block. It will be the template for all of the other machines.
 * Things that need adding:
 * -GUI
 * -MultiSided Textures
 * -Rotation based on player's location
 * -Interaction with Buildcraft power infrastructure!
 * Some of this code was made by Domochevsky, thanks bud!
 */
public class BlockForge extends BlockContainer implements BlockProxy {

	public BlockForge(int id, int texture, Material material) {
		super(id, material);

		setHardness(5.0F);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);

	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	@SideOnly(Side.CLIENT)
	private Icon backIcon;
	
	
	@SideOnly(Side.CLIENT)
	private Icon frontIcon;
	@SideOnly(Side.CLIENT)
	private Icon offIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister var) {
		topIcon = var.registerIcon("Futurology:Icon");
		bottomIcon = var.registerIcon("Futurology:Icon");
		sideIcon = var.registerIcon("Futurology:Icon");
		backIcon = var.registerIcon("Futurology:frontIcon");

		frontIcon = var.registerIcon("Futurology:frontIcon");
		offIcon = var.registerIcon("Futurology:offIcon");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) { // Comes in with the side and meta
												// as the front face
		if (side == 0) {
			return bottomIcon;
		}
		if (side == 1) {
			return topIcon;
		}
		if (side == 2) {
			if (meta == 2 || meta == 10) {
				return frontIcon;
			} // If north is checked and the front is north, return front icon
			if (meta == 3) {
				return backIcon;
			} // If north is checked and the front is south, return back icon
			if (meta == 11) {
				return backIcon;
			} // The block is on, so show the "on" backside
			if (meta == 4 || meta == 12) {
				return sideIcon;
			} // If north is checked and the front is west, return side icon
			if (meta == 5 || meta == 13) {
				return sideIcon;
			} // If north is checked and the front is east, return side icon
			else {
				return offIcon; // Just in case, I still got 0, 1, 14 and 15
								// left unused as metadata.
			}
		}
		if (side == 3) {
			if (meta == 2) {
				return backIcon;
			} // If south is checked and the front is north, return back icon
			if (meta == 10) {
				return backIcon;
			} // The block is on, so show the "on" backside
			if (meta == 3 || meta == 11) {
				return frontIcon;
			} // If south is checked and the front is south, return front icon
			if (meta == 4 || meta == 12) {
				return sideIcon;
			} // If south is checked and the front is west, return side icon
			if (meta == 5 || meta == 13) {
				return sideIcon;
			} // If south is checked and the front is east, return side icon
			else {
				return offIcon; // Just in case, I still got 0, 1, 14 and 15
								// left unused as metadata.
			}
		}
		if (side == 4) {
			if (meta == 2 || meta == 10) {
				return sideIcon;
			} // If west is checked and the front is north, return side icon
			if (meta == 3 || meta == 11) {
				return sideIcon;
			} // If west is checked and the front is south, return side icon
			if (meta == 4 || meta == 12) {
				return frontIcon;
			} // If west is checked and the front is west, return front icon
			if (meta == 5) {
				return backIcon;
			} // If west is checked and the front is east, return back icon
			if (meta == 13) {
				return backIcon;
			} // The block is on, so show the "on" backside
			else {
				return offIcon; // Just in case, I still got 0, 1, 14 and 15
								// left unused as metadata.
			}
		}
		if (side == 5) {
			if (meta == 2 || meta == 10) {
				return sideIcon;
			} // If east is checked and the front is north, return side icon
			if (meta == 3 || meta == 11) {
				return sideIcon;
			} // If east is checked and the front is south, return side icon
			if (meta == 4) {
				return backIcon;
			} // If east is checked and the front is west, return back icon
			if (meta == 12) {
				return backIcon;
			} // The block is on, so show the "on" backside
			if (meta == 5 || meta == 13) {
				return frontIcon;
			} // If east is checked and the front is east, return front icon
			else {
				return offIcon; // Just in case, I still got 0, 1, 14 and 15
								// left unused as metadata.
			}
		} else {
			return offIcon; // Just in case, I still got 0, 1, 14 and 15 left
							// unused as metadata.
		}
	}

	public int idDropped(int par1, Random random, int par2) {
		return FuturologyCore.tungstenIngot.itemID;
	}

	 public int onBlockPlacedby(World world, int x, int y, int z,
             EntityLiving entityLiving, ItemStack itemStack) {
     int angle = MathHelper
                     .floor_double((entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
     int change = 3;

     switch (angle) {
     case 0:
             change = 2;
             break;
     case 1:
             change = 5;
             break;
     case 2:
             change = 3;
             break;
     case 3:
             change = 4;
             break;
     }
     world.setBlockMetadataWithNotify(x, y, z, change, 3);
     return 1;
}

	public static boolean rotateBlock(World worldObj, int x, int y, int z,
			ForgeDirection axis, int mask) {
		int rotMeta = worldObj.getBlockMetadata(x, y, z);
		int masked = rotMeta & ~mask;
		ForgeDirection orientation = ForgeDirection.getOrientation(rotMeta
				& mask);
		ForgeDirection rotated = orientation.getRotation(axis);
		worldObj.setBlockMetadataWithNotify(x, y, z, rotated.ordinal() & mask
				| masked, 3);
		return true;
	}

	public TileEntity createNewTileEntity(World world) {
		
		return new TileEntityForge();
	}

}
