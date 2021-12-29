// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public abstract class TileEntityTFCritter extends kw
{
    int facing;
    
    public TileEntityTFCritter() {
        this.facing = -1;
    }
    
    public int getFacing() {
        return this.facing;
    }
    
    public void setFacing(final int facing) {
        this.facing = facing;
    }
    
    public void a(final ady par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.facing = par1NBTTagCompound.f("tfFacing");
    }
    
    public void b(final ady par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("tfFacing", this.facing);
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void n_() {
        if (this.facing < 1) {
            this.fixFacing();
        }
    }
    
    private void fixFacing() {
        if (TFBlocks.critter.e(this.i, this.j - 1, this.k, this.l)) {
            this.setFacing(1);
        }
        else if (TFBlocks.critter.e(this.i, this.j + 1, this.k, this.l)) {
            this.setFacing(2);
        }
        else if (TFBlocks.critter.e(this.i, this.j, this.k, this.l - 1)) {
            this.setFacing(3);
        }
        else if (TFBlocks.critter.e(this.i, this.j, this.k, this.l + 1)) {
            this.setFacing(4);
        }
        else if (TFBlocks.critter.e(this.i, this.j, this.k - 1, this.l)) {
            this.setFacing(5);
        }
        else if (TFBlocks.critter.e(this.i, this.j, this.k + 1, this.l)) {
            this.setFacing(6);
        }
    }
    
    public void onDataPacket(final lg net, final ait pkt) {
        this.setFacing(pkt.e);
    }
}
