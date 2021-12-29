import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFProjectile extends ia
{
    private boolean inGround;
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int ticksAlive;
    private int ticksFlying;
    public int shake;
    public nq shootingEntity;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    
    public EntityTFProjectile(final ry world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
    }
    
    public EntityTFProjectile(final ry world, final double d, final double d1, final double d2, final double d3, final double d4, final double d5) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.a(1.0f, 1.0f);
        this.c(d, d1, d2, this.y, this.z);
        this.d(d, d1, d2);
        final double d6 = me.a(d3 * d3 + d4 * d4 + d5 * d5);
        this.accelerationX = d3 / d6 * 0.1;
        this.accelerationY = d4 / d6 * 0.1;
        this.accelerationZ = d5 / d6 * 0.1;
    }
    
    public EntityTFProjectile(final ry world, final nq sourceEntity, double d, double d1, double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.shootingEntity = sourceEntity;
        this.a(1.0f, 1.0f);
        this.c(sourceEntity.s, sourceEntity.t + sourceEntity.E(), sourceEntity.u, sourceEntity.y, sourceEntity.z);
        this.d(this.s, this.t, this.u);
        this.L = 0.0f;
        final double v = 0.0;
        this.x = v;
        this.w = v;
        this.v = v;
        d += this.Y.nextGaussian() * 0.4;
        d1 += this.Y.nextGaussian() * 0.4;
        d2 += this.Y.nextGaussian() * 0.4;
        final double d3 = me.a(d * d + d1 * d1 + d2 * d2);
        this.accelerationX = d / d3 * 0.1;
        this.accelerationY = d1 / d3 * 0.1;
        this.accelerationZ = d2 / d3 * 0.1;
    }
    
    public boolean a(final double d) {
        double d2 = this.C.c() * 4.0;
        d2 *= 64.0;
        return d < d2 * d2;
    }
    
    public void a() {
        super.w();
        if (this.shake > 0) {
            --this.shake;
        }
        if (this.inGround) {
            final int i = this.o.a(this.xTile, this.yTile, this.zTile);
            if (i == this.inTile) {
                ++this.ticksAlive;
                if (this.ticksAlive == 1200) {
                    this.v();
                }
                return;
            }
            this.inGround = false;
            this.v *= this.Y.nextFloat() * 0.2f;
            this.w *= this.Y.nextFloat() * 0.2f;
            this.x *= this.Y.nextFloat() * 0.2f;
            this.ticksAlive = 0;
            this.ticksFlying = 0;
        }
        else {
            ++this.ticksFlying;
        }
        fb vec3d = fb.b(this.s, this.t, this.u);
        fb vec3d2 = fb.b(this.s + this.v, this.t + this.w, this.u + this.x);
        gv movingobjectposition = this.o.a(vec3d, vec3d2);
        vec3d = fb.b(this.s, this.t, this.u);
        vec3d2 = fb.b(this.s + this.v, this.t + this.w, this.u + this.x);
        if (movingobjectposition != null) {
            vec3d2 = fb.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }
        ia entity = null;
        final List list = this.o.b((ia)this, this.C.a(this.v, this.w, this.x).b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (int j = 0; j < list.size(); ++j) {
            final ia entity2 = list.get(j);
            if (entity2.e_()) {
                if (entity2 != this.shootingEntity || this.ticksFlying >= 25) {
                    final float f2 = 0.3f;
                    final c axisalignedbb = entity2.C.b((double)f2, (double)f2, (double)f2);
                    final gv movingobjectposition2 = axisalignedbb.a(vec3d, vec3d2);
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
        if (entity != null) {
            movingobjectposition = new gv(entity);
        }
        if (movingobjectposition != null) {
            if (!this.o.I) {
                if (movingobjectposition.g != null) {
                    this.hitEntity(movingobjectposition.g);
                }
                this.explode();
            }
            this.v();
        }
        this.s += this.v;
        this.t += this.w;
        this.u += this.x;
        final float f3 = me.a(this.v * this.v + this.x * this.x);
        this.y = (float)(Math.atan2(this.v, this.x) * 180.0 / 3.1415927410125732);
        this.z = (float)(Math.atan2(this.w, f3) * 180.0 / 3.1415927410125732);
        while (this.z - this.B < -180.0f) {
            this.B -= 360.0f;
        }
        while (this.z - this.B >= 180.0f) {
            this.B += 360.0f;
        }
        while (this.y - this.A < -180.0f) {
            this.A -= 360.0f;
        }
        while (this.y - this.A >= 180.0f) {
            this.A += 360.0f;
        }
        this.z = this.B + (this.z - this.B) * 0.2f;
        this.y = this.A + (this.y - this.A) * 0.2f;
        float f4 = 0.95f;
        if (this.D()) {
            for (int k = 0; k < 4; ++k) {
                final float f5 = 0.25f;
                this.o.a("bubble", this.s - this.v * f5, this.t - this.w * f5, this.u - this.x * f5, this.v, this.w, this.x);
            }
            f4 = 0.8f;
        }
        this.v += this.accelerationX;
        this.w += this.accelerationY;
        this.x += this.accelerationZ;
        this.v *= f4;
        this.w *= f4;
        this.x *= f4;
        this.makeTrail();
        this.d(this.s, this.t, this.u);
    }
    
    public void explode() {
    }
    
    public void hitEntity(final ia entityHit) {
    }
    
    public void makeTrail() {
        this.o.a("smoke", this.s, this.t + 0.5, this.u, 0.0, 0.0, 0.0);
    }
    
    protected void b() {
    }
    
    public void a(final ik nbttagcompound) {
        nbttagcompound.a("xTile", (short)this.xTile);
        nbttagcompound.a("yTile", (short)this.yTile);
        nbttagcompound.a("zTile", (short)this.zTile);
        nbttagcompound.a("inTile", (byte)this.inTile);
        nbttagcompound.a("shake", (byte)this.shake);
        nbttagcompound.a("inGround", (byte)(byte)(this.inGround ? 1 : 0));
    }
    
    public void b(final ik nbttagcompound) {
        this.xTile = nbttagcompound.d("xTile");
        this.yTile = nbttagcompound.d("yTile");
        this.zTile = nbttagcompound.d("zTile");
        this.inTile = (nbttagcompound.c("inTile") & 0xFF);
        this.shake = (nbttagcompound.c("shake") & 0xFF);
        this.inGround = (nbttagcompound.c("inGround") == 1);
    }
    
    public boolean e_() {
        return true;
    }
    
    public float Q() {
        return 1.0f;
    }
    
    public boolean attackEntityFrom(final ia entity, final int i) {
        this.G();
        if (entity != null) {
            final fb vec3d = entity.R();
            if (vec3d != null) {
                this.v = vec3d.a;
                this.w = vec3d.b;
                this.x = vec3d.c;
                this.accelerationX = this.v * 0.1;
                this.accelerationY = this.w * 0.1;
                this.accelerationZ = this.x * 0.1;
            }
            return true;
        }
        return false;
    }
    
    public float i_() {
        return 0.0f;
    }
}
