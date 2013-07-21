package Futurology;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


public class ItemUranium extends Item{

	public ItemUranium(int par1) {
		super(par1);
		setMaxStackSize(64);
		
	}
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Futurology:uranium");
	}
}