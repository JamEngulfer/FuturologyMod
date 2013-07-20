package Futurology;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import Futurology.FuturologyCore;

public class TungstenOre extends Block {
        public TungstenOre(int id, int texture, Material material) {
                super(id, material);
                
                setHardness(4.0F); 
                setStepSound(Block.soundStoneFootstep);
                //setBlockName("genericOre");
                setCreativeTab(CreativeTabs.tabBlock);
        }
        
        @Override
        public void registerIcons(IconRegister par1IconRegister)
        {
                 this.blockIcon = par1IconRegister.registerIcon("Futurology:tungstenOre");
        }
        
        public int idDropped(int par1, Random random, int par2) {
                return FuturologyCore.tungstenOre.blockID;
        }
}

