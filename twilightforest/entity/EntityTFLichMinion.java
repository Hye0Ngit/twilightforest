// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import java.util.Iterator;
import java.util.List;

public class EntityTFLichMinion extends tv
{
    EntityTFLich master;
    
    public EntityTFLichMinion(final abv par1World) {
        super(par1World);
        this.master = null;
    }
    
    public EntityTFLichMinion(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFLichMinion(final abv par1World, final EntityTFLich entityTFLich) {
        super(par1World);
        this.master = entityTFLich;
    }
    
    public boolean a(final na par1DamageSource, final float par2) {
        final oe prevTarget = this.m();
        if (super.a(par1DamageSource, par2)) {
            if (par1DamageSource.i() instanceof EntityTFLich) {
                this.d(prevTarget);
                this.b(prevTarget);
                this.c(new ni(nh.c.H, 200, 4));
                this.c(new ni(nh.g.H, 200, 1));
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
            this.g(0.0f);
        }
        super.c();
    }
    
    private void findNewMaster() {
        final List<EntityTFLich> nearbyLiches = this.q.a((Class)EntityTFLich.class, asu.a().a(this.u, this.v, this.w, this.u + 1.0, this.v + 1.0, this.w + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.u, this.v + this.f(), this.w, this.master.u, this.master.v + this.master.f(), this.master.w);
                this.d(this.master.m());
                break;
            }
        }
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    protected void bw() {
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
                final yd var4 = this.o(var3);
                if (var3 < 3 && this.ab.nextFloat() < var2) {
                    break;
                }
                if (var4 == null) {
                    final yb var5 = a(var3 + 1, var1);
                    if (var5 != null) {
                        this.c(var3 + 1, new yd(var5));
                    }
                }
            }
        }
    }
}
