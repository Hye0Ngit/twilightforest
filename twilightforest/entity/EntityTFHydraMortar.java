// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class EntityTFHydraMortar extends sv
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public ng playerReflects;
    public int fuse;
    public boolean megaBlast;
    
    public EntityTFHydraMortar(final zv par1World) {
        super(par1World);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.a(0.75f, 0.75f);
    }
    
    public EntityTFHydraMortar(final zv par1World, final ng par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.a(0.75f, 0.75f);
    }
    
    public void l_() {
        super.l_();
        this.i(this.u, (this.E.b + this.E.e) / 2.0, this.w);
        if (this.F) {
            if (!this.q.I) {
                this.x *= 0.9;
                this.y *= 0.9;
                this.z *= 0.9;
            }
            if (this.fuse-- <= 0) {
                this.detonate();
            }
        }
    }
    
    public void setToBlasting() {
        this.megaBlast = true;
    }
    
    protected void a(final aqu mop) {
        if (mop.g == null && !this.megaBlast) {
            this.y = 0.0;
            this.F = true;
        }
        else {
            this.detonate();
        }
    }
    
    public float a(final zq par1Explosion, final zv par2World, final int par3, final int par4, final int par5, final aou par6Block) {
        float var6 = super.a(par1Explosion, par2World, par3, par4, par5, par6Block);
        if (this.megaBlast && par6Block != aou.D && par6Block != aou.bL && par6Block != aou.bM) {
            var6 = Math.min(0.8f, var6);
        }
        return var6;
    }
    
    protected void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        this.q.a((mp)this, this.u, this.v, this.w, explosionPower, true, true);
        if (!this.q.I) {
            final List nearbyList = new ArrayList(this.q.b((mp)this, this.E.b(1.0, 1.0, 1.0)));
            for (final mp nearby : nearbyList) {
                if (nearby.a(mg.a((so)null, (mp)this.h()), 18) && !nearby.E()) {
                    nearby.d(5);
                }
            }
        }
        this.w();
    }
    
    public boolean a(final mg damagesource, final int i) {
        this.J();
        if (damagesource.i() != null && !this.q.I) {
            final aqw vec3d = damagesource.i().Y();
            if (vec3d != null) {
                this.c(vec3d.c, vec3d.d + 1.0, vec3d.e, 1.5f, 0.1f);
                this.F = false;
                this.fuse += 20;
            }
            if (damagesource.i() instanceof ng) {
                this.playerReflects = (ng)damagesource.i();
            }
            return true;
        }
        return false;
    }
    
    public ng h() {
        if (this.playerReflects != null) {
            return this.playerReflects;
        }
        return super.h();
    }
    
    public boolean ae() {
        return true;
    }
    
    public boolean K() {
        return true;
    }
    
    public float X() {
        return 1.5f;
    }
    
    protected float g() {
        return 0.05f;
    }
    
    protected float c() {
        return 0.75f;
    }
    
    protected float d() {
        return -20.0f;
    }
}
