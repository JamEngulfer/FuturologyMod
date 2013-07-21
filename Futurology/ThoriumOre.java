package Futurology;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import Futurology.FuturologyCore;

public class ThoriumOre extends Block {
        public ThoriumOre(int id, int texture, Material material) {
                super(id, material);
                
                setHardness(4.0F); 
                setStepSound(Block.soundStoneFootstep);
                
                setCreativeTab(CreativeTabs.tabBlock);
        }
        
        @Override
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("Futurology:thoriumOre");
        }
        
        public int idDropped(int par1, Random random, int par2) {
                return FuturologyCore.thoriumOre.blockID;
        }
}

