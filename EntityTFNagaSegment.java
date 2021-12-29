import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNagaSegment extends lx implements fr
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final fq world) {
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
    
    public EntityTFNagaSegment(final fq world, final EntityTFNaga head, final int segment) {
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
    
    public boolean f_() {
        return true;
    }
    
    public void a(final se entity, final int i, final double d, final double d1) {
    }
    
    protected void b(final float f) {
    }
    
    public boolean g_() {
        return false;
    }
    
    public boolean aL() {
        return false;
    }
    
    public void y_() {
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
                this.T();
            }
        }
        super.y_();
    }
    
    protected void m_() {
        if (this.head != null && this.head.aw <= 0) {
            final List allNearEntities = this.bi.b((se)this, this.bw.b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final se nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof lx && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.aw = 10;
                    this.attackEntityAsMob(nearEntity);
                }
            }
        }
    }
    
    protected boolean attackEntityAsMob(final se entity) {
        if (entity instanceof bm) {
            return entity.a(qc.a((lx)this), this.attackStrength * 3);
        }
        return entity.a(qc.a((lx)this), this.attackStrength);
    }
    
    public boolean a(final qc damagesource, final int i) {
        if (damagesource == qc.l || damagesource == qc.b || damagesource == qc.c || damagesource == qc.d) {
            this.as = 0;
            System.out.println("Prevented damage from fire/explosion/lava.  DamageSource == " + damagesource.n);
            return false;
        }
        if (this.deathCounter == 0) {
            final int n = 10;
            this.at = n;
            this.as = n;
            return this.head.a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (this.head == null || this.head.bE) {
            this.T();
        }
        if (!this.bi.I && this.bi.v == 0) {
            this.T();
        }
    }
    
    public void pullTowards(final se leader) {
        this.bb = this.head.bb * 1.5f;
        final float angle = (float)Math.atan2(this.bo - leader.bo, this.bm - leader.bm);
        final double idealX = leader.bm + iy.b(angle) * this.sDist;
        final double idealZ = leader.bo + iy.a(angle) * this.sDist;
        final double dx = idealX - this.bm;
        double dy = leader.bn - this.bn;
        final double dz = idealZ - this.bo;
        final double dist = iy.a(dx * dx + dz * dz);
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
            this.o_();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.at = n;
        this.as = n;
        this.deathCounter = 30;
    }
    
    public int c() {
        return 250;
    }
}
