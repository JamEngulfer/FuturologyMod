package Futurology;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


public class TungstenIngot extends Item{

	public TungstenIngot(int par1) {
		super(par1);
		setMaxStackSize(64);
		
	}
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Futurology:tungstenIngot");
	}
}