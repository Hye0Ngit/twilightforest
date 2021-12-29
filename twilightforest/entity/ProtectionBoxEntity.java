// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.IPacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.EntitySize;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.entity.Entity;

public class ProtectionBoxEntity extends Entity
{
    public int lifeTime;
    public final int sizeX;
    public final int sizeY;
    public final int sizeZ;
    private final MutableBoundingBox sbb;
    
    public ProtectionBoxEntity(final EntityType<?> type, final World world) {
        super((EntityType)type, world);
        final int sizeX = 0;
        this.sizeZ = sizeX;
        this.sizeY = sizeX;
        this.sizeX = sizeX;
        this.sbb = null;
    }
    
    public ProtectionBoxEntity(final World world, final MutableBoundingBox sbb) {
        super((EntityType)TFEntities.protection_box, world);
        this.sbb = new MutableBoundingBox(sbb);
        this.func_70012_b((double)sbb.field_78897_a, (double)sbb.field_78895_b, (double)sbb.field_78896_c, 0.0f, 0.0f);
        this.sizeX = sbb.func_78883_b();
        this.sizeY = sbb.func_78882_c();
        this.sizeZ = sbb.func_78880_d();
        this.field_213325_aI = EntitySize.func_220311_c((float)Math.max(this.sizeX, this.sizeZ), (float)this.sizeY);
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
    
    public boolean matches(final MutableBoundingBox sbb) {
        return this.sbb.field_78897_a == sbb.field_78897_a && this.sbb.field_78895_b == sbb.field_78895_b && this.sbb.field_78896_c == sbb.field_78896_c && this.sbb.field_78893_d == sbb.field_78893_d && this.sbb.field_78894_e == sbb.field_78894_e && this.sbb.field_78892_f == sbb.field_78892_f;
    }
    
    public void resetLifetime() {
        this.lifeTime = 60;
    }
    
    public float func_70013_c() {
        return 1.0f;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final CompoundNBT compound) {
    }
    
    protected void func_213281_b(final CompoundNBT compound) {
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public IPacket<?> func_213297_N() {
        throw new IllegalStateException("should never be spawned on server");
    }
}
