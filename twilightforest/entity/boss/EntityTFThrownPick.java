// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFThrownPick extends EntityThrowable
{
    private static final float PROJECTILE_DAMAGE = 3.0f;
    
    public EntityTFThrownPick(final World par1World, final EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        this.func_70105_a(0.5f, 0.5f);
    }
    
    public EntityTFThrownPick(final World par1World) {
        super(par1World);
        this.func_70105_a(0.5f, 0.5f);
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        boolean passThru = false;
        if (par1MovingObjectPosition.field_72308_g != null) {
            if (par1MovingObjectPosition.field_72308_g instanceof EntityTFKnightPhantom) {
                passThru = true;
            }
            if (!passThru) {
                par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 3.0f);
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
        }
        if (!passThru && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    protected float func_70182_d() {
        return 1.0f;
    }
    
    protected float func_70185_h() {
        return 0.015f;
    }
}
