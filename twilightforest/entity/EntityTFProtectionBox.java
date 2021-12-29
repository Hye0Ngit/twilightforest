// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.entity.Entity;

public class EntityTFProtectionBox extends Entity
{
    public int lifeTime;
    public final int sizeX;
    public final int sizeY;
    public final int sizeZ;
    private final StructureBoundingBox sbb;
    
    public EntityTFProtectionBox(final World world, final StructureBoundingBox sbb) {
        super(world);
        this.lifeTime = 60;
        this.sbb = new StructureBoundingBox(sbb);
        this.func_70012_b((double)sbb.field_78897_a, (double)sbb.field_78895_b, (double)sbb.field_78896_c, 0.0f, 0.0f);
        this.sizeX = sbb.func_78883_b();
        this.sizeY = sbb.func_78882_c();
        this.sizeZ = sbb.func_78880_d();
        this.func_70105_a((float)Math.max(this.sizeX, this.sizeZ), (float)this.sizeY);
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
    
    public boolean matches(final StructureBoundingBox sbb) {
        return this.sbb.field_78897_a == sbb.field_78897_a && this.sbb.field_78895_b == sbb.field_78895_b && this.sbb.field_78896_c == sbb.field_78896_c && this.sbb.field_78893_d == sbb.field_78893_d && this.sbb.field_78894_e == sbb.field_78894_e && this.sbb.field_78892_f == sbb.field_78892_f;
    }
    
    public void resetLifetime() {
        this.lifeTime = 60;
    }
    
    public float func_70013_c() {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b() {
        return 15728880;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final NBTTagCompound compound) {
    }
    
    protected void func_70014_b(final NBTTagCompound compound) {
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }
}
