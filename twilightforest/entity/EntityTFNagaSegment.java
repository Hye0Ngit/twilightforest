// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.List;

public class EntityTFNagaSegment extends ng implements rq
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final zv world) {
        super(world);
        this.sDist = 1.5;
        this.aH = "/mods/twilightforest/textures/model/nagasegment.png";
        this.a(1.75f, 1.95f);
        this.Y = 2.0f;
        this.aS = 1000;
        this.ag = true;
        this.attackStrength = 2;
    }
    
    public EntityTFNagaSegment(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFNagaSegment(final zv world, final EntityTFNaga head, final int segment) {
        this(world);
        this.head = head;
        this.setSegment(segment);
        this.bI = head.getMoveSpeed() * 1.5f;
        this.aO = head.aO;
        this.aP = head.aP;
    }
    
    public void setSegment(final int i) {
        this.ah.b(16, (Object)new Byte((byte)i));
    }
    
    public int getSegment() {
        return this.ah.a(16);
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)new Byte((byte)1));
    }
    
    public boolean L() {
        return true;
    }
    
    public void a(final mp entity, final int i, final double d, final double d1) {
    }
    
    protected void a(final float f) {
    }
    
    public boolean f_() {
        return false;
    }
    
    public boolean I() {
        return false;
    }
    
    public void l_() {
        this.despawnIfInvalid();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.ab.nextGaussian() * 0.02;
                    final double d2 = this.ab.nextGaussian() * 0.02;
                    final double d3 = this.ab.nextGaussian() * 0.02;
                    final String explosionType = this.ab.nextBoolean() ? "largeexplode" : "explode";
                    this.q.a(explosionType, this.u + this.ab.nextFloat() * this.O * 2.0f - this.O, this.v + this.ab.nextFloat() * this.P, this.w + this.ab.nextFloat() * this.O * 2.0f - this.O, d, d2, d3);
                }
                this.w();
            }
        }
        super.l_();
    }
    
    protected void bq() {
        if (this.head != null && this.head.ba <= 0) {
            final List allNearEntities = this.q.b((mp)this, this.E.b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final mp nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof ng && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.ba = 10;
                    this.m(nearEntity);
                }
            }
        }
    }
    
    public boolean m(final mp entity) {
        if (entity instanceof qb) {
            return entity.a(mg.a((ng)this), this.attackStrength * 3);
        }
        return entity.a(mg.a((ng)this), this.attackStrength);
    }
    
    public boolean a(final mg damagesource, final int i) {
        if (damagesource.c() || damagesource.m()) {
            this.aW = 0;
            return false;
        }
        if (!this.q.I && this.deathCounter <= 0 && this.head != null) {
            final int n = 10;
            this.aX = n;
            this.aW = n;
            return this.head.a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (!this.q.I) {
            if (this.head == null || this.head.M) {
                this.w();
            }
            if (this.q.r == 0) {
                this.w();
            }
        }
    }
    
    public void pullTowards(final mp leader) {
        this.bI = this.head.getMoveSpeed() * 1.5f;
        final float angle = (float)Math.atan2(this.w - leader.w, this.u - leader.u);
        final double idealX = leader.u + kx.b(angle) * this.sDist;
        final double idealZ = leader.w + kx.a(angle) * this.sDist;
        final double dx = idealX - this.u;
        double dy = leader.v - this.v;
        final double dz = idealZ - this.w;
        final double dist = kx.a(dx * dx + dz * dz);
        if (dist > this.sDist * 4.0) {
            this.a(idealX, leader.v + 0.001, idealZ, 0.0f, (float)(angle * 180.0f / 3.141592653589793) - 90.0f);
            dy = 0.0;
            this.a(leader, 90.0f, 90.0f);
            this.bE = (float)(this.bI * dist * 5.0);
        }
        else if (dist > 0.0) {
            this.a(leader, 90.0f, 90.0f);
            this.bE = this.head.getMoveSpeed();
        }
        if (dy > 1.1) {
            this.bl();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.aX = n;
        this.aW = n;
        this.deathCounter = 30;
    }
    
    public int aW() {
        return 250;
    }
}
