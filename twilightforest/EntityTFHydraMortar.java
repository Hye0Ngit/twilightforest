// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class EntityTFHydraMortar extends rh
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public md playerReflects;
    public int fuse;
    public boolean megaBlast;
    
    public EntityTFHydraMortar(final xv par1World) {
        super(par1World);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.a(0.75f, 0.75f);
    }
    
    public EntityTFHydraMortar(final xv par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.a(0.75f, 0.75f);
    }
    
    public void j_() {
        super.j_();
        this.i(this.t, (this.D.b + this.D.e) / 2.0, this.v);
        if (this.E) {
            if (!this.p.J) {
                this.w *= 0.9;
                this.x *= 0.9;
                this.y *= 0.9;
            }
            if (this.fuse-- <= 0) {
                this.detonate();
            }
        }
    }
    
    public void setToBlasting() {
        this.megaBlast = true;
    }
    
    protected void a(final anz mop) {
        if (mop.g == null && !this.megaBlast) {
            this.x = 0.0;
            this.E = true;
        }
        else {
            this.detonate();
        }
    }
    
    public float a(final xq par1Explosion, final amj par2Block, final int par3, final int par4, final int par5) {
        float var6 = super.a(par1Explosion, par2Block, par3, par4, par5);
        if (this.megaBlast && par2Block != amj.C && par2Block != amj.bK && par2Block != amj.bL) {
            var6 = Math.min(0.8f, var6);
        }
        return var6;
    }
    
    protected void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        this.p.a((lq)this, this.t, this.u, this.v, explosionPower, true, true);
        if (!this.p.J) {
            final List nearbyList = new ArrayList(this.p.b((lq)this, this.D.b(1.0, 1.0, 1.0)));
            for (final lq nearby : nearbyList) {
                if (nearby.a(lh.a((rb)null, (lq)this.h()), 18) && !nearby.F()) {
                    nearby.c(5);
                }
            }
        }
        this.x();
    }
    
    public boolean a(final lh damagesource, final int i) {
        this.K();
        if (damagesource.g() != null && !this.p.J) {
            final aob vec3d = damagesource.g().Z();
            if (vec3d != null) {
                this.c(vec3d.c, vec3d.d + 1.0, vec3d.e, 1.5f, 0.1f);
                this.E = false;
                this.fuse += 20;
            }
            if (damagesource.g() instanceof md) {
                this.playerReflects = (md)damagesource.g();
            }
            return true;
        }
        return false;
    }
    
    public md h() {
        if (this.playerReflects != null) {
            return this.playerReflects;
        }
        return super.h();
    }
    
    public boolean af() {
        return true;
    }
    
    public boolean L() {
        return true;
    }
    
    public float Y() {
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
