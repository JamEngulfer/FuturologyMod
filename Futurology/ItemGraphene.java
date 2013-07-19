package Futurology;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import AlagaesiaCraft.EnumModMaterial;
import AlagaesiaCraft.RiderSwords;

public class ItemGraphene extends Item{

	public ItemGraphene(int par1) {
		super(par1);
		setMaxStackSize(64);
		
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Futurology:graphene");
	}
}