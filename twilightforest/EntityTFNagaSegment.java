// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class EntityTFNagaSegment extends md implements qe
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final xv world) {
        super(world);
        this.sDist = 1.5;
        this.aF = "/twilightforest/nagasegment.png";
        this.a(1.75f, 1.95f);
        this.X = 2.0f;
        this.aQ = 1000;
        this.af = true;
        this.attackStrength = 2;
    }
    
    public EntityTFNagaSegment(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public EntityTFNagaSegment(final xv world, final EntityTFNaga head, final int segment) {
        this(world);
        this.head = head;
        this.setSegment(segment);
        this.bG = head.getMoveSpeed() * 1.5f;
        this.aM = head.aM;
        this.aN = head.aN;
    }
    
    public void setSegment(final int i) {
        this.ag.b(16, (Object)new Byte((byte)i));
    }
    
    public int getSegment() {
        return this.ag.a(16);
    }
    
    protected void a() {
        super.a();
        this.ag.a(16, (Object)new Byte((byte)1));
    }
    
    public boolean M() {
        return true;
    }
    
    public void a(final lq entity, final int i, final double d, final double d1) {
    }
    
    protected void a(final float f) {
    }
    
    public boolean f_() {
        return false;
    }
    
    public boolean J() {
        return false;
    }
    
    public void j_() {
        this.despawnIfInvalid();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.aa.nextGaussian() * 0.02;
                    final double d2 = this.aa.nextGaussian() * 0.02;
                    final double d3 = this.aa.nextGaussian() * 0.02;
                    final String explosionType = this.aa.nextBoolean() ? "largeexplode" : "explode";
                    this.p.a(explosionType, this.t + this.aa.nextFloat() * this.N * 2.0f - this.N, this.u + this.aa.nextFloat() * this.O, this.v + this.aa.nextFloat() * this.N * 2.0f - this.N, d, d2, d3);
                }
                this.x();
            }
        }
        super.j_();
    }
    
    protected void bn() {
        if (this.head != null && this.head.aY <= 0) {
            final List allNearEntities = this.p.b((lq)this, this.D.b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final lq nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof md && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.aY = 10;
                    this.m(nearEntity);
                }
            }
        }
    }
    
    public boolean m(final lq entity) {
        if (entity instanceof ox) {
            return entity.a(lh.a((md)this), this.attackStrength * 3);
        }
        return entity.a(lh.a((md)this), this.attackStrength);
    }
    
    public boolean a(final lh damagesource, final int i) {
        if (damagesource == lh.k || damagesource == lh.a || damagesource == lh.b || damagesource == lh.c) {
            this.aU = 0;
            return false;
        }
        if (!this.p.J && this.deathCounter <= 0 && this.head != null) {
            final int n = 10;
            this.aV = n;
            this.aU = n;
            return this.head.a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (!this.p.J) {
            if (this.head == null || this.head.L) {
                this.x();
            }
            if (this.p.t == 0) {
                this.x();
            }
        }
    }
    
    public void pullTowards(final lq leader) {
        this.bG = this.head.getMoveSpeed() * 1.5f;
        final float angle = (float)Math.atan2(this.v - leader.v, this.t - leader.t);
        final double idealX = leader.t + ke.b(angle) * this.sDist;
        final double idealZ = leader.v + ke.a(angle) * this.sDist;
        final double dx = idealX - this.t;
        double dy = leader.u - this.u;
        final double dz = idealZ - this.v;
        final double dist = ke.a(dx * dx + dz * dz);
        if (dist > this.sDist * 4.0) {
            this.a(idealX, leader.u + 0.001, idealZ, 0.0f, (float)(angle * 180.0f / 3.141592653589793) - 90.0f);
            dy = 0.0;
            this.a(leader, 90.0f, 90.0f);
            this.bC = (float)(this.bG * dist * 5.0);
        }
        else if (dist > 0.0) {
            this.a(leader, 90.0f, 90.0f);
            this.bC = this.head.getMoveSpeed();
        }
        if (dy > 1.1) {
            this.bi();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.aV = n;
        this.aU = n;
        this.deathCounter = 30;
    }
    
    public int aT() {
        return 250;
    }
}
