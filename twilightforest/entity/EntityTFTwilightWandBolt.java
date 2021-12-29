// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFTwilightWandBolt extends EntityThrowable
{
    public EntityTFTwilightWandBolt(final World par1World) {
        super(par1World);
    }
    
    public EntityTFTwilightWandBolt(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTwilightWandBolt(final World par1World, final EntityLiving par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double s1 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.field_70170_p.func_72869_a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
    }
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g == null || !(par1MovingObjectPosition.field_72308_g instanceof EntityLiving) || par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76354_b((Entity)this, (Entity)this.func_85052_h()), 6)) {}
        for (int i = 0; i < 8; ++i) {
            this.field_70170_p.func_72869_a("iconcrack_" + Item.field_77730_bn.field_77779_bT, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}
