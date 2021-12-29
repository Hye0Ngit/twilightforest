// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import java.util.Iterator;
import java.util.List;

public class EntityTFLichMinion extends sd
{
    EntityTFLich master;
    
    public EntityTFLichMinion(final zv par1World) {
        super(par1World);
        this.master = null;
    }
    
    public EntityTFLichMinion(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFLichMinion(final zv par1World, final EntityTFLich entityTFLich) {
        super(par1World);
        this.master = entityTFLich;
    }
    
    public boolean a(final mg par1DamageSource, final int par2) {
        final ng prevTarget = this.aJ();
        if (super.a(par1DamageSource, par2)) {
            if (par1DamageSource.i() instanceof EntityTFLich) {
                this.b(prevTarget);
                this.c(prevTarget);
                this.d(new ml(mk.c.H, 200, 4));
                this.d(new ml(mk.g.H, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    public void c() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || this.master.M) {
            this.aS = 0;
        }
        super.c();
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.q.a((Class)EntityTFLich.class, aqr.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.u, this.v + this.e(), this.w, this.master.u, this.master.v + this.master.e(), this.master.w);
                this.b(this.master.aJ());
                break;
            }
        }
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public void bJ() {
        this.bH();
        this.bI();
    }
    
    protected void bH() {
        final float[] equipChances = { 0.0f, 0.25f, 0.75f, 1.0f };
        if (this.ab.nextFloat() < equipChances[this.q.r]) {
            int var1 = this.ab.nextInt(2);
            final float var2 = (this.q.r == 3) ? 0.1f : 0.25f;
            if (this.ab.nextFloat() < 0.07f) {
                ++var1;
            }
            if (this.ab.nextFloat() < 0.07f) {
                ++var1;
            }
            if (this.ab.nextFloat() < 0.07f) {
                ++var1;
            }
            for (int var3 = 3; var3 >= 0; --var3) {
                final wg var4 = this.q(var3);
                if (var3 < 3 && this.ab.nextFloat() < var2) {
                    break;
                }
                if (var4 == null) {
                    final we var5 = a(var3 + 1, var1);
                    if (var5 != null) {
                        this.c(var3 + 1, new wg(var5));
                    }
                }
            }
        }
    }
}
