package Futurology;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/*
 * Is used to make tape, which when crafted with Coal/Charcoal, will make graphene!
 */
public class ItemGlue extends Item{

	public ItemGlue(int par1) {
		super(par1);
		setMaxStackSize(64);
		
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Futurology:glue");
	}
}