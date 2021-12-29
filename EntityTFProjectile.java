import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFProjectile extends tv
{
    private boolean inGround;
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int ticksAlive;
    private int ticksFlying;
    public int shake;
    public ne owner;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    
    public EntityTFProjectile(final ge world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
    }
    
    public EntityTFProjectile(final ge world, final double d, final double d1, final double d2, final double d3, final double d4, final double d5) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.b(1.0f, 1.0f);
        this.c(d, d1, d2, this.bs, this.bt);
        this.c(d, d1, d2);
        final double d6 = kb.a(d3 * d3 + d4 * d4 + d5 * d5);
        this.accelerationX = d3 / d6 * 0.0600000000000001;
        this.accelerationY = d4 / d6 * 0.0600000000000001;
        this.accelerationZ = d5 / d6 * 0.0600000000000001;
    }
    
    public EntityTFProjectile(final ge world, final double d, final double d1, final double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.b(1.0f, 1.0f);
        this.c(d, d1, d2, this.bs, this.bt);
        this.c(d, d1, d2);
    }
    
    public EntityTFProjectile(final ge world, final ne sourceEntity, double d, double d1, double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.shake = 0;
        this.ticksFlying = 0;
        this.owner = sourceEntity;
        this.b(1.0f, 1.0f);
        this.c(sourceEntity.bm, sourceEntity.bn + sourceEntity.B(), sourceEntity.bo, sourceEntity.bs, sourceEntity.bt);
        this.c(this.bm, this.bn, this.bo);
        this.bF = 0.0f;
        final double bp = 0.0;
        this.br = bp;
        this.bq = bp;
        this.bp = bp;
        d += this.bS.nextGaussian() * 0.4;
        d1 += this.bS.nextGaussian() * 0.4;
        d2 += this.bS.nextGaussian() * 0.4;
        final double d3 = kb.a(d * d + d1 * d1 + d2 * d2);
        this.accelerationX = d / d3 * 0.0600000000000001;
        this.accelerationY = d1 / d3 * 0.0600000000000001;
        this.accelerationZ = d2 / d3 * 0.0600000000000001;
    }
    
    public void F_() {
        super.aA();
        if (this.shake > 0) {
            --this.shake;
        }
        if (this.inGround) {
            final int i = this.bi.a(this.xTile, this.yTile, this.zTile);
            if (i == this.inTile) {
                ++this.ticksAlive;
                if (this.ticksAlive == 1200) {
                    this.X();
                }
                return;
            }
            this.inGround = false;
            this.bp *= this.bS.nextFloat() * 0.2f;
            this.bq *= this.bS.nextFloat() * 0.2f;
            this.br *= this.bS.nextFloat() * 0.2f;
            this.ticksAlive = 0;
            this.ticksFlying = 0;
        }
        else {
            ++this.ticksFlying;
        }
        cj vec3d = cj.b(this.bm, this.bn, this.bo);
        cj vec3d2 = cj.b(this.bm + this.bp, this.bn + this.bq, this.bo + this.br);
        wu movingobjectposition = this.bi.a(vec3d, vec3d2);
        vec3d = cj.b(this.bm, this.bn, this.bo);
        vec3d2 = cj.b(this.bm + this.bp, this.bn + this.bq, this.bo + this.br);
        if (movingobjectposition != null) {
            vec3d2 = cj.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }
        tv entity = null;
        final List list = this.bi.b((tv)this, this.bw.a(this.bp, this.bq, this.br).b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (int j = 0; j < list.size(); ++j) {
            final tv entity2 = list.get(j);
            if (entity2.o_()) {
                if (entity2 != this.owner || this.ticksFlying >= 25) {
                    final float f2 = 0.3f;
                    final fp axisalignedbb = entity2.bw.b((double)f2, (double)f2, (double)f2);
                    final wu movingobjectposition2 = axisalignedbb.a(vec3d, vec3d2);
                    if (movingobjectposition2 != null) {
                        final double d2 = vec3d.b(movingobjectposition2.f);
                        if (d2 < d || d == 0.0) {
                            entity = entity2;
                            d = d2;
                        }
                    }
                }
            }
        }
        if (entity != null && this.shouldCollideWith(entity)) {
            movingobjectposition = new wu(entity);
        }
        if (movingobjectposition != null) {
            if (!this.bi.F) {
                if (movingobjectposition.g != null) {
                    this.hitEntity(movingobjectposition.g);
                }
                this.explode();
            }
            this.X();
        }
        this.bm += this.bp;
        this.bn += this.bq;
        this.bo += this.br;
        final float f3 = kb.a(this.bp * this.bp + this.br * this.br);
        this.bs = (float)(Math.atan2(this.bp, this.br) * 180.0 / 3.1415927410125732);
        this.bt = (float)(Math.atan2(this.bq, f3) * 180.0 / 3.1415927410125732);
        while (this.bt - this.bv < -180.0f) {
            this.bv -= 360.0f;
        }
        while (this.bt - this.bv >= 180.0f) {
            this.bv += 360.0f;
        }
        while (this.bs - this.bu < -180.0f) {
            this.bu -= 360.0f;
        }
        while (this.bs - this.bu >= 180.0f) {
            this.bu += 360.0f;
        }
        this.bt = this.bv + (this.bt - this.bv) * 0.2f;
        this.bs = this.bu + (this.bs - this.bu) * 0.2f;
        float f4 = 0.95f;
        if (this.aU()) {
            for (int k = 0; k < 4; ++k) {
                final float f5 = 0.25f;
                this.bi.a("bubble", this.bm - this.bp * f5, this.bn - this.bq * f5, this.bo - this.br * f5, this.bp, this.bq, this.br);
            }
            f4 = 0.8f;
        }
        this.bp += this.accelerationX;
        this.bq += this.accelerationY;
        this.br += this.accelerationZ;
        this.bp *= f4;
        this.bq *= f4;
        this.br *= f4;
        this.makeTrail();
        this.c(this.bm, this.bn, this.bo);
    }
    
    public void explode() {
    }
    
    public void hitEntity(final tv entityHit) {
    }
    
    public void makeTrail() {
        this.bi.a("smoke", this.bm, this.bn + 0.5, this.bo, 0.0, 0.0, 0.0);
    }
    
    protected void b() {
    }
    
    public void b(final ph nbttagcompound) {
        nbttagcompound.a("xTile", (short)this.xTile);
        nbttagcompound.a("yTile", (short)this.yTile);
        nbttagcompound.a("zTile", (short)this.zTile);
        nbttagcompound.a("inTile", (byte)this.inTile);
        nbttagcompound.a("shake", (byte)this.shake);
        nbttagcompound.a("inGround", (byte)(byte)(this.inGround ? 1 : 0));
    }
    
    public void a(final ph nbttagcompound) {
        this.xTile = nbttagcompound.e("xTile");
        this.yTile = nbttagcompound.e("yTile");
        this.zTile = nbttagcompound.e("zTile");
        this.inTile = (nbttagcompound.d("inTile") & 0xFF);
        this.shake = (nbttagcompound.d("shake") & 0xFF);
        this.inGround = (nbttagcompound.d("inGround") == 1);
    }
    
    public boolean o_() {
        return true;
    }
    
    public boolean shouldCollideWith(final tv entity) {
        return true;
    }
    
    public float j_() {
        return 1.0f;
    }
    
    public boolean attackEntityFrom(final tv entity, final int i) {
        this.aW();
        if (entity != null) {
            final cj vec3d = entity.aJ();
            if (vec3d != null) {
                this.bp = vec3d.a;
                this.bq = vec3d.b;
                this.br = vec3d.c;
                this.accelerationX = this.bp * 0.1;
                this.accelerationY = this.bq * 0.1;
                this.accelerationZ = this.br * 0.1;
            }
            return true;
        }
        return false;
    }
    
    public float getShadowSize() {
        return 0.0f;
    }
}
