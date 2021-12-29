// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class EntityTFLichMinion extends ajg
{
    EntityTFLich master;
    
    public EntityTFLichMinion(final xd par1World) {
        super(par1World);
        this.master = null;
    }
    
    public EntityTFLichMinion(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public EntityTFLichMinion(final xd par1World, final EntityTFLich entityTFLich) {
        super(par1World);
        this.master = entityTFLich;
    }
    
    public boolean a(final md par1DamageSource, final int par2) {
        final acq prevTarget = this.aT();
        if (super.a(par1DamageSource, par2)) {
            if (par1DamageSource.a() instanceof EntityTFLich) {
                this.c(prevTarget);
                this.a(prevTarget);
                this.b(new alg(aad.c.H, 200, 4));
                this.b(new alg(aad.g.H, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    public void e() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || this.master.G) {
            this.bx = 0;
        }
        super.e();
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.k.a((Class)EntityTFLich.class, wu.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.o, this.p + this.I(), this.q, this.master.o, this.master.p + this.master.I(), this.master.q);
                this.c(this.master.aT());
                break;
            }
        }
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
