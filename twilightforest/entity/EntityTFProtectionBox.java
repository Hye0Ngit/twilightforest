// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EntityTFProtectionBox extends Entity
{
    public int lifeTime;
    public int sizeX;
    public int sizeY;
    public int sizeZ;
    
    public EntityTFProtectionBox(final World worldObj, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        super(worldObj);
        this.func_70012_b((double)minX, (double)minY, (double)minZ, 0.0f, 0.0f);
        this.sizeX = Math.abs(maxX - minX) + 1;
        this.sizeY = Math.abs(maxY - minY) + 1;
        this.sizeZ = Math.abs(maxZ - minZ) + 1;
        this.func_70105_a((float)Math.max(this.sizeX, this.sizeZ), (float)this.sizeY);
        this.lifeTime = 60;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.lifeTime <= 1) {
            this.func_70106_y();
        }
        else {
            --this.lifeTime;
        }
    }
    
    public float func_70013_c(final float par1) {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b(final float par1) {
        return 15728880;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final NBTTagCompound var1) {
    }
    
    protected void func_70014_b(final NBTTagCompound var1) {
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }
}
