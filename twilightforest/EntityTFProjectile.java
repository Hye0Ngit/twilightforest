// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class EntityTFProjectile extends nn
{
    private boolean inGround;
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int ticksAlive;
    private int ticksFlying;
    public int shake;
    public acq owner;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    
    public EntityTFProjectile(final xd world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
    }
    
    public EntityTFProjectile(final xd world, final double d, final double d1, final double d2, final double d3, final double d4, final double d5) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.a(1.0f, 1.0f);
        this.c(d, d1, d2, this.u, this.v);
        this.d(d, d1, d2);
        final double d6 = gk.a(d3 * d3 + d4 * d4 + d5 * d5);
        this.accelerationX = d3 / d6 * 0.0600000000000001;
        this.accelerationY = d4 / d6 * 0.0600000000000001;
        this.accelerationZ = d5 / d6 * 0.0600000000000001;
    }
    
    public EntityTFProjectile(final xd world, final double d, final double d1, final double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.a(1.0f, 1.0f);
        this.c(d, d1, d2, this.u, this.v);
        this.d(d, d1, d2);
    }
    
    public EntityTFProjectile(final xd world, final acq sourceEntity, double d, double d1, double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.owner = sourceEntity;
        this.a(1.0f, 1.0f);
        this.c(sourceEntity.o, sourceEntity.p + sourceEntity.I(), sourceEntity.q, sourceEntity.u, sourceEntity.v);
        this.d(this.o, this.p, this.q);
        this.H = 0.0f;
        final double r = 0.0;
        this.t = r;
        this.s = r;
        this.r = r;
        d += this.U.nextGaussian() * 0.4;
        d1 += this.U.nextGaussian() * 0.4;
        d2 += this.U.nextGaussian() * 0.4;
        final double d3 = gk.a(d * d + d1 * d1 + d2 * d2);
        this.accelerationX = d / d3 * 0.0600000000000001;
        this.accelerationY = d1 / d3 * 0.0600000000000001;
        this.accelerationZ = d2 / d3 * 0.0600000000000001;
    }
    
    public boolean a(final double d) {
        double d2 = this.y.c() * 4.0;
        d2 *= 64.0;
        return d < d2 * d2;
    }
    
    public void J_() {
        super.B();
        if (this.shake > 0) {
            --this.shake;
        }
        if (this.inGround) {
            final int i = this.k.a(this.xTile, this.yTile, this.zTile);
            if (i == this.inTile) {
                ++this.ticksAlive;
                if (this.ticksAlive == 1200) {
                    this.A();
                }
                return;
            }
            this.inGround = false;
            this.r *= this.U.nextFloat() * 0.2f;
            this.s *= this.U.nextFloat() * 0.2f;
            this.t *= this.U.nextFloat() * 0.2f;
            this.ticksAlive = 0;
            this.ticksFlying = 0;
        }
        else {
            ++this.ticksFlying;
        }
        bo vec3d = bo.b(this.o, this.p, this.q);
        bo vec3d2 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
        pl movingobjectposition = this.k.a(vec3d, vec3d2);
        vec3d = bo.b(this.o, this.p, this.q);
        vec3d2 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
        if (movingobjectposition != null) {
            vec3d2 = bo.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }
        nn entity = null;
        final List list = this.k.b((nn)this, this.y.a(this.r, this.s, this.t).b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (int j = 0; j < list.size(); ++j) {
            final nn entity2 = list.get(j);
            if (entity2.l_()) {
                if (entity2 != this.owner || this.ticksFlying >= 25) {
                    final float f2 = 0.3f;
                    final wu axisalignedbb = entity2.y.b((double)f2, (double)f2, (double)f2);
                    final pl movingobjectposition2 = axisalignedbb.a(vec3d, vec3d2);
                    if (movingobjectposition2 != null) {
                        final double d2 = vec3d.d(movingobjectposition2.f);
                        if (d2 < d || d == 0.0) {
                            entity = entity2;
                            d = d2;
                        }
                    }
                }
            }
        }
        if (entity != null && this.shouldCollideWith(entity)) {
            movingobjectposition = new pl(entity);
        }
        if (movingobjectposition != null) {
            if (!this.k.F) {
                if (movingobjectposition.g != null) {
                    this.hitEntity(movingobjectposition.g);
                }
                this.explode();
            }
            this.A();
        }
        this.o += this.r;
        this.p += this.s;
        this.q += this.t;
        final float f3 = gk.a(this.r * this.r + this.t * this.t);
        this.u = (float)(Math.atan2(this.r, this.t) * 180.0 / 3.1415927410125732);
        this.v = (float)(Math.atan2(this.s, f3) * 180.0 / 3.1415927410125732);
        while (this.v - this.x < -180.0f) {
            this.x -= 360.0f;
        }
        while (this.v - this.x >= 180.0f) {
            this.x += 360.0f;
        }
        while (this.u - this.w < -180.0f) {
            this.w -= 360.0f;
        }
        while (this.u - this.w >= 180.0f) {
            this.w += 360.0f;
        }
        this.v = this.x + (this.v - this.x) * 0.2f;
        this.u = this.w + (this.u - this.w) * 0.2f;
        float f4 = 0.95f;
        if (this.H()) {
            for (int k = 0; k < 4; ++k) {
                final float f5 = 0.25f;
                this.k.a("bubble", this.o - this.r * f5, this.p - this.s * f5, this.q - this.t * f5, this.r, this.s, this.t);
            }
            f4 = 0.8f;
        }
        this.r += this.accelerationX;
        this.s += this.accelerationY;
        this.t += this.accelerationZ;
        this.r *= f4;
        this.s *= f4;
        this.t *= f4;
        this.makeTrail();
        this.d(this.o, this.p, this.q);
    }
    
    public void explode() {
    }
    
    public void hitEntity(final nn entityHit) {
    }
    
    public void makeTrail() {
        this.k.a("smoke", this.o, this.p + 0.5, this.q, 0.0, 0.0, 0.0);
    }
    
    protected void b() {
    }
    
    public void b(final ady nbttagcompound) {
        nbttagcompound.a("xTile", (short)this.xTile);
        nbttagcompound.a("yTile", (short)this.yTile);
        nbttagcompound.a("zTile", (short)this.zTile);
        nbttagcompound.a("inTile", (byte)this.inTile);
        nbttagcompound.a("shake", (byte)this.shake);
        nbttagcompound.a("inGround", (byte)(byte)(this.inGround ? 1 : 0));
    }
    
    public void a(final ady nbttagcompound) {
        this.xTile = nbttagcompound.e("xTile");
        this.yTile = nbttagcompound.e("yTile");
        this.zTile = nbttagcompound.e("zTile");
        this.inTile = (nbttagcompound.d("inTile") & 0xFF);
        this.shake = (nbttagcompound.d("shake") & 0xFF);
        this.inGround = (nbttagcompound.d("inGround") == 1);
    }
    
    public boolean l_() {
        return true;
    }
    
    public boolean shouldCollideWith(final nn entity) {
        return true;
    }
    
    public float j_() {
        return 1.0f;
    }
    
    public boolean attackEntityFrom(final nn entity, final int i) {
        this.K();
        if (entity != null) {
            final bo vec3d = entity.Q();
            if (vec3d != null) {
                this.r = vec3d.a;
                this.s = vec3d.b;
                this.t = vec3d.c;
                this.accelerationX = this.r * 0.1;
                this.accelerationY = this.s * 0.1;
                this.accelerationZ = this.t * 0.1;
            }
            return true;
        }
        return false;
    }
    
    public float h_() {
        return 0.0f;
    }
}
