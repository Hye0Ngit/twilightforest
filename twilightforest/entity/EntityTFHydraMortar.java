// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class EntityTFHydraMortar extends up
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public oe playerReflects;
    public int fuse;
    public boolean megaBlast;
    
    public EntityTFHydraMortar(final abv par1World) {
        super(par1World);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.a(0.75f, 0.75f);
    }
    
    public EntityTFHydraMortar(final abv par1World, final oe par2EntityLiving) {
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
    
    protected void a(final asx mop) {
        if (mop.g == null && !this.megaBlast) {
            this.y = 0.0;
            this.F = true;
        }
        else {
            this.detonate();
        }
    }
    
    public float a(final abq par1Explosion, final abv par2World, final int par3, final int par4, final int par5, final aqw par6Block) {
        float var6 = super.a(par1Explosion, par2World, par3, par4, par5, par6Block);
        if (this.megaBlast && par6Block != aqw.E && par6Block != aqw.bM && par6Block != aqw.bN) {
            var6 = Math.min(0.8f, var6);
        }
        return var6;
    }
    
    protected void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        this.q.a((nm)this, this.u, this.v, this.w, explosionPower, true, true);
        if (!this.q.I) {
            final List<nm> nearbyList = new ArrayList<nm>(this.q.b((nm)this, this.E.b(1.0, 1.0, 1.0)));
            for (final nm nearby : nearbyList) {
                if (nearby.a(na.a((ui)null, (nm)this.h()), 18.0f) && !nearby.E()) {
                    nearby.d(5);
                }
            }
        }
        this.w();
    }
    
    public boolean a(final na damagesource, final float i) {
        this.J();
        if (damagesource.i() != null && !this.q.I) {
            final asz vec3d = damagesource.i().Z();
            if (vec3d != null) {
                this.c(vec3d.c, vec3d.d + 1.0, vec3d.e, 1.5f, 0.1f);
                this.F = false;
                this.fuse += 20;
            }
            if (damagesource.i() instanceof oe) {
                this.playerReflects = (oe)damagesource.i();
            }
            return true;
        }
        return false;
    }
    
    public oe h() {
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
    
    public float Y() {
        return 1.5f;
    }
    
    protected float e() {
        return 0.05f;
    }
    
    protected float c() {
        return 0.75f;
    }
    
    protected float d() {
        return -20.0f;
    }
}
