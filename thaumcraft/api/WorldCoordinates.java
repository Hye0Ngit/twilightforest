// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class WorldCoordinates implements Comparable
{
    public int x;
    public int y;
    public int z;
    public int dim;
    
    public WorldCoordinates() {
    }
    
    public WorldCoordinates(final int par1, final int par2, final int par3, final int d) {
        this.x = par1;
        this.y = par2;
        this.z = par3;
        this.dim = d;
    }
    
    public WorldCoordinates(final TileEntity tile) {
        this.x = tile.field_145851_c;
        this.y = tile.field_145848_d;
        this.z = tile.field_145849_e;
        this.dim = tile.func_145831_w().field_73011_w.field_76574_g;
    }
    
    public WorldCoordinates(final WorldCoordinates par1ChunkCoordinates) {
        this.x = par1ChunkCoordinates.x;
        this.y = par1ChunkCoordinates.y;
        this.z = par1ChunkCoordinates.z;
        this.dim = par1ChunkCoordinates.dim;
    }
    
    @Override
    public boolean equals(final Object par1Obj) {
        if (!(par1Obj instanceof WorldCoordinates)) {
            return false;
        }
        final WorldCoordinates coordinates = (WorldCoordinates)par1Obj;
        return this.x == coordinates.x && this.y == coordinates.y && this.z == coordinates.z && this.dim == coordinates.dim;
    }
    
    @Override
    public int hashCode() {
        return this.x + this.y << 8 + this.z << 16 + this.dim << 24;
    }
    
    public int compareWorldCoordinate(final WorldCoordinates par1) {
        return (this.dim == par1.dim) ? ((this.y == par1.y) ? ((this.z == par1.z) ? (this.x - par1.x) : (this.z - par1.z)) : (this.y - par1.y)) : -1;
    }
    
    public void set(final int par1, final int par2, final int par3, final int d) {
        this.x = par1;
        this.y = par2;
        this.z = par3;
        this.dim = d;
    }
    
    public float getDistanceSquared(final int par1, final int par2, final int par3) {
        final float f = (float)(this.x - par1);
        final float f2 = (float)(this.y - par2);
        final float f3 = (float)(this.z - par3);
        return f * f + f2 * f2 + f3 * f3;
    }
    
    public float getDistanceSquaredToWorldCoordinates(final WorldCoordinates par1ChunkCoordinates) {
        return this.getDistanceSquared(par1ChunkCoordinates.x, par1ChunkCoordinates.y, par1ChunkCoordinates.z);
    }
    
    @Override
    public int compareTo(final Object par1Obj) {
        return this.compareWorldCoordinate((WorldCoordinates)par1Obj);
    }
    
    public void readNBT(final NBTTagCompound nbt) {
        this.x = nbt.func_74762_e("w_x");
        this.y = nbt.func_74762_e("w_y");
        this.z = nbt.func_74762_e("w_z");
        this.dim = nbt.func_74762_e("w_d");
    }
    
    public void writeNBT(final NBTTagCompound nbt) {
        nbt.func_74768_a("w_x", this.x);
        nbt.func_74768_a("w_y", this.y);
        nbt.func_74768_a("w_z", this.z);
        nbt.func_74768_a("w_d", this.dim);
    }
}
