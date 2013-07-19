package Futurology;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;


/*
 * Basic Tile ENtity for the Machine, will need a LOT of work.
 */
public class TileEntityForge extends TileEntity {
	public int customField;

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setInteger("customField", customField);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.customField = par1.getInteger("customField");
	}

	private byte side = 0;

	public byte getSide() {
		return side;
	}

	public void setSide(byte side) {
		this.side = side;
	}
}
