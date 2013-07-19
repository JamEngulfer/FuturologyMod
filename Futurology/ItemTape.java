package Futurology;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


public class ItemTape extends Item{

	public ItemTape(int par1) {
		super(par1);
		setMaxStackSize(64);
		
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Futurology:tape");
	}
}