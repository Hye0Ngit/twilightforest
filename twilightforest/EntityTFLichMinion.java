// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class EntityTFLichMinion extends qr
{
    EntityTFLich master;
    
    public EntityTFLichMinion(final xv par1World) {
        super(par1World);
        this.master = null;
    }
    
    public EntityTFLichMinion(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFLichMinion(final xv par1World, final EntityTFLich entityTFLich) {
        super(par1World);
        this.master = entityTFLich;
    }
    
    public boolean a(final lh par1DamageSource, final int par2) {
        final md prevTarget = this.aG();
        if (super.a(par1DamageSource, par2)) {
            if (par1DamageSource.g() instanceof EntityTFLich) {
                this.b(prevTarget);
                this.c(prevTarget);
                this.d(new lm(ll.c.H, 200, 4));
                this.d(new lm(ll.g.H, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    public void c() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || this.master.L) {
            this.aQ = 0;
        }
        super.c();
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.p.a((Class)EntityTFLich.class, anw.a().a(this.t, this.u, this.v, this.t + 1.0, this.u + 1.0, this.v + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.t, this.u + this.e(), this.v, this.master.t, this.master.u + this.master.e(), this.master.v);
                this.b(this.master.aG());
                break;
            }
        }
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public void bG() {
        this.bE();
        this.bF();
    }
    
    protected void bE() {
        final float[] equipChances = { 0.0f, 0.25f, 0.75f, 1.0f };
        if (this.aa.nextFloat() < equipChances[this.p.t]) {
            int var1 = this.aa.nextInt(2);
            final float var2 = (this.p.t == 3) ? 0.1f : 0.25f;
            if (this.aa.nextFloat() < 0.07f) {
                ++var1;
            }
            if (this.aa.nextFloat() < 0.07f) {
                ++var1;
            }
            if (this.aa.nextFloat() < 0.07f) {
                ++var1;
            }
            for (int var3 = 3; var3 >= 0; --var3) {
                final um var4 = this.q(var3);
                if (var3 < 3 && this.aa.nextFloat() < var2) {
                    break;
                }
                if (var4 == null) {
                    final uk var5 = a(var3 + 1, var1);
                    if (var5 != null) {
                        this.b(var3 + 1, new um(var5));
                    }
                }
            }
        }
    }
}
