package Futurology;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/*
 * Basic Tile ENtity for the Machine, will need a LOT of work.
 */
public class TileEntityForge extends TileEntity {
	
	/*Stored Orientation of the front*/
	private int storedOrientation;
	
	/*Changed from TimeEntityForge(int par1) for compatibility reasons*/
	public void TileEntityForgeMethod(int par1){
		this.storedOrientation = par1;
	}
	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		

	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);

	}
	public int getForgeOrientation(){
		return this.storedOrientation;
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tileTag = new NBTTagCompound();
		this.writeToNBT(tileTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord,
				this.zCoord, 0, tileTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		this.readFromNBT(pkt.customParam1);
	}

	private byte side = 0;
	
	
	public byte getSide() {
		return side;
	}

	public void setSide(byte side) {
		this.side = side;
	}

	public int idDropped(int meta, Random rand, int i) {
		return 0;
	}

	public int quantityDropped(Random rand) {
		return 0;
	}

	public void breakBlock(World world, int x, int y, int z, int i, int j) {
		world.removeBlockTileEntity(x, y, z);
	}
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset){
		int blockID = FuturologyCore.tungstenForge.blockID;
		if(world.getBlockId(x,  y +1,  z) == 0){
			world.setBlockMetadataWithNotify(x, y + 1,  z,  blockID, (Integer) null);
			TileEntityForge teForge = (TileEntityForge) world.getBlockTileEntity(x,  y+1,  z);
			//teForge.addClick();
			return true;
		}
		return false;
	}

	

}
