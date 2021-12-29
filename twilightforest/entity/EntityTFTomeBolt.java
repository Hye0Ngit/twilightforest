// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFTomeBolt extends EntityThrowable
{
    public EntityTFTomeBolt(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFTomeBolt(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFTomeBolt(final World par1World) {
        super(par1World);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_72869_a("crit", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null && par1MovingObjectPosition.field_72308_g instanceof EntityLivingBase && par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 6.0f)) {
            final byte potionStrength = (byte)((this.field_70170_p.field_73013_u == 0) ? 3 : ((this.field_70170_p.field_73013_u == 2) ? 7 : 9));
            if (potionStrength > 0) {
                ((EntityLivingBase)par1MovingObjectPosition.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, potionStrength * 20, 1));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.field_70170_p.func_72869_a("iconcrack_" + Item.field_77811_bE.field_77779_bT, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}
