// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import twilightforest.entity.EntityTFThrowable;

public class EntityTFLichBolt extends EntityTFThrowable
{
    public EntityTFLichBolt(final World world) {
        super(world);
    }
    
    public EntityTFLichBolt(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double s1 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, dx, dy, dz, s1, s2, s3, new int[0]);
        }
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float amount) {
        super.func_70097_a(damagesource, amount);
        if (!this.field_70170_p.field_72995_K && damagesource.func_76346_g() != null) {
            final Vec3d vec3d = damagesource.func_76346_g().func_70040_Z();
            this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 1.5f, 0.1f);
            if (damagesource.func_76364_f() instanceof EntityLivingBase) {
                this.field_70192_c = (EntityLivingBase)damagesource.func_76364_f();
            }
            return true;
        }
        return false;
    }
    
    protected float func_70185_h() {
        return 0.001f;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final int itemId = Item.func_150891_b(Items.field_151079_bi);
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.ITEM_CRACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05, new int[] { itemId });
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70184_a(final RayTraceResult result) {
        if (result.field_72308_g instanceof EntityTFLichBolt || result.field_72308_g instanceof EntityTFLichBomb || (result.field_72308_g instanceof EntityTFLich && ((EntityTFLich)result.field_72308_g).isShadowClone())) {
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g instanceof EntityLivingBase) {
                result.field_72308_g.func_70097_a(DamageSource.func_76354_b((Entity)this, (Entity)this.func_85052_h()), 6.0f);
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
}
