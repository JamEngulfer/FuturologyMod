package Futurology;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCell extends Item {
/*
 * Later on Cells will have MetaData, with different liquids and such, will be added soon!
 * Liquids/Gases we will need:
 * -Plasma
 * -Thorium
 * -Steam(from RailCraft, API needed)
 * -Radioactive Waste(will cause damage to the player over time)
 * 
 */
	public ItemCell(int par1) {
		super(par1);
		setMaxStackSize(16);

	}

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Futurology:cell");
	}

	public Icon getIconFromDamage(int par1) {
		return icons[par1];
	}

	public static final String[] names = new String[] { "plasma", "empty" };

	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + names[i];
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int x = 0; x < 2; x++) {
			par3List.add(new ItemStack(this, 1, x));
		}
	}
}