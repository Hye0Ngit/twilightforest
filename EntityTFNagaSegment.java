import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNagaSegment extends ne implements gg
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final ge world) {
        super(world);
        this.sDist = 1.5;
        this.ae = "/twilightforest/nagasegment.png";
        this.b(1.75f, 1.95f);
        this.bP = 2.0f;
        this.ap = 1000;
        this.bX = true;
        this.attackStrength = 3;
        this.bf = true;
    }
    
    public EntityTFNagaSegment(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public EntityTFNagaSegment(final ge world, final EntityTFNaga head, final int segment) {
        this(world);
        this.bf = false;
        this.head = head;
        this.setSegment(segment);
        this.bb = head.bb * 1.5f;
        this.al = head.al;
        this.am = head.am;
    }
    
    public void setSegment(final int i) {
        this.bY.b(16, (Object)new Byte((byte)i));
    }
    
    public int getSegment() {
        return this.bY.a(16);
    }
    
    protected void b() {
        super.b();
        this.bY.a(16, (Object)new Byte((byte)1));
    }
    
    public boolean e_() {
        return true;
    }
    
    public void a(final tv entity, final int i, final double d, final double d1) {
    }
    
    protected void a(final float f) {
    }
    
    public boolean g_() {
        return false;
    }
    
    public boolean aV() {
        return false;
    }
    
    public void F_() {
        this.despawnIfInvalid();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.bS.nextGaussian() * 0.02;
                    final double d2 = this.bS.nextGaussian() * 0.02;
                    final double d3 = this.bS.nextGaussian() * 0.02;
                    final String explosionType = this.bS.nextBoolean() ? "largeexplode" : "explode";
                    this.bi.a(explosionType, this.bm + this.bS.nextFloat() * this.bG * 2.0f - this.bG, this.bn + this.bS.nextFloat() * this.bH, this.bo + this.bS.nextFloat() * this.bG * 2.0f - this.bG, d, d2, d3);
                }
                this.X();
            }
        }
        super.F_();
    }
    
    protected void d_() {
        if (this.head != null && this.head.aw <= 0) {
            final List allNearEntities = this.bi.b((tv)this, this.bw.b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final tv nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof ne && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.aw = 10;
                    this.a(nearEntity);
                }
            }
        }
    }
    
    public boolean a(final tv entity) {
        if (entity instanceof br) {
            return entity.a(rq.a((ne)this), this.attackStrength * 3);
        }
        return entity.a(rq.a((ne)this), this.attackStrength);
    }
    
    public boolean a(final rq damagesource, final int i) {
        if (damagesource == rq.l || damagesource == rq.b || damagesource == rq.c || damagesource == rq.d) {
            this.as = 0;
            return false;
        }
        if (!this.bi.F && this.deathCounter <= 0) {
            final int n = 10;
            this.at = n;
            this.as = n;
            return this.head.a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (!this.bi.F) {
            if (this.head == null || this.head.bE) {
                this.X();
            }
            if (this.bi.q == 0) {
                this.X();
            }
        }
    }
    
    public void pullTowards(final tv leader) {
        this.bb = this.head.bb * 1.5f;
        final float angle = (float)Math.atan2(this.bo - leader.bo, this.bm - leader.bm);
        final double idealX = leader.bm + kb.b(angle) * this.sDist;
        final double idealZ = leader.bo + kb.a(angle) * this.sDist;
        final double dx = idealX - this.bm;
        double dy = leader.bn - this.bn;
        final double dz = idealZ - this.bo;
        final double dist = kb.a(dx * dx + dz * dz);
        if (dist > this.sDist * 4.0) {
            this.b(idealX, leader.bn + 0.001, idealZ, 0.0f, (float)(angle * 180.0f / 3.141592653589793) - 90.0f);
            dy = 0.0;
            this.a(leader, 90.0f, 90.0f);
            this.aX = (float)(this.bb * dist * 5.0);
        }
        else if (dist > 0.0) {
            this.a(leader, 90.0f, 90.0f);
            this.aX = this.head.bb;
        }
        if (dy > 1.1) {
            this.ac();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.at = n;
        this.as = n;
        this.deathCounter = 30;
    }
    
    public int d() {
        return 250;
    }
}
