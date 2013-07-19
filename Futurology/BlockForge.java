package Futurology;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
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
public class BlockForge extends Block {
        public BlockForge(int id, int texture, Material material) {
                super(id, material);
                
                setHardness(5.0F); 
                setStepSound(Block.soundStoneFootstep);
                setCreativeTab(CreativeTabs.tabBlock);
        }
        private final Icon[] textures = new Icon[2];
        
        @Override
    	@SideOnly(Side.CLIENT)
    	public Icon getIcon(int side, int metadata) {
    		if (side == 0){
    			return this.textures[metadata];
    		}else{
    			return this.textures[metadata + 1];
    		}
    	}
    	
    	/**
    	 * registers the icons
    	 * 
    	 * @param the IconRegister
    	 * 
    	 * @return void
    	 */
    	@Override
    	@SideOnly(Side.CLIENT)
    	public void registerIcons(IconRegister register){
    		this.textures[0] = register.registerIcon("Futurology/blocks/forgeFront.png");
    		
    		this.textures[1] = register.registerIcon("Futurology/blocks/forgeSides.png");
    		
    	}
    	public TileEntity createTileEntity(World world, int metadata)
    	{
    	   return new TileEntityForge();
    	}
    	
    	/**
    	 * Called when a block gets placed in the world
    	 * Used to determine witch side the barrel was placed on
    	 * 
    	 * @param the world the block was placed in
    	 * @param the x coordinate the block was placed at
    	 * @param the y coordinate the block was placed at
    	 * @param the z coordinate the block was placed at
    	 * @param the entity who placed the block
    	 * @param the block placed
    	 * 
    	 * @return void
    	 */
    	@Override
    	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving player, ItemStack item) {
    		TileEntityForge tile;
    		{
    			TileEntity entity = world.getBlockTileEntity(x, y, z);
    			if (entity == null || !(entity instanceof TileEntityForge)) return;
    			tile = (TileEntityForge) entity;
    		}
    		tile.setSide((byte) (Math.round(player.rotationYaw / 90) & 3));
    	}
        
        public int idDropped(int par1, Random random, int par2) {
                return FuturologyCore.tungstenForge.blockID;
        }
        
}

