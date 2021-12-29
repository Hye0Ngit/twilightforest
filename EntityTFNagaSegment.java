import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNagaSegment extends nq implements aey
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final ry world) {
        super(world);
        this.sDist = 1.5;
        this.l = true;
    }
    
    public EntityTFNagaSegment(final ry world, final EntityTFNaga head, final int segment) {
        super(world);
        this.sDist = 1.5;
        this.l = false;
        this.head = head;
        this.setSegment(segment);
        this.aA = "/twilightforest/nagasegment.png";
        this.a(1.75f, 1.95f);
        this.bw = head.bw * 1.5f;
        this.V = 2.0f;
        this.aI = head.aI;
        this.aJ = head.aJ;
        this.aM = 1000;
        this.af = true;
        this.attackStrength = 3;
    }
    
    public void setSegment(final int i) {
        this.ag.b(16, (Object)new Byte((byte)i));
    }
    
    public int getSegment() {
        return this.ag.a(16);
    }
    
    protected void b() {
        super.b();
        this.ag.a(16, (Object)new Byte((byte)1));
    }
    
    public boolean H() {
        return true;
    }
    
    public void a(final ia entity, final int i, final double d, final double d1) {
    }
    
    protected void c(final float f) {
    }
    
    public boolean d_() {
        return false;
    }
    
    public boolean F() {
        return false;
    }
    
    public void a() {
        this.despawnIfInvalid();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.Y.nextGaussian() * 0.02;
                    final double d2 = this.Y.nextGaussian() * 0.02;
                    final double d3 = this.Y.nextGaussian() * 0.02;
                    final String explosionType = this.Y.nextBoolean() ? "largeexplode" : "explode";
                    this.o.a(explosionType, this.s + this.Y.nextFloat() * this.M * 2.0f - this.M, this.t + this.Y.nextFloat() * this.N, this.u + this.Y.nextFloat() * this.M * 2.0f - this.M, d, d2, d3);
                }
                this.v();
            }
        }
        super.a();
    }
    
    protected void n() {
        if (this.head != null && this.head.aT <= 0) {
            final List allNearEntities = this.o.b((ia)this, this.C.b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final ia nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof nq && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.aT = 10;
                    this.attackEntityAsMob(nearEntity);
                }
            }
        }
    }
    
    protected boolean attackEntityAsMob(final ia entity) {
        if (entity instanceof fx) {
            return entity.a(pm.a((nq)this), this.attackStrength * 3);
        }
        return entity.a(pm.a((nq)this), this.attackStrength);
    }
    
    public boolean a(final pm damagesource, final int i) {
        if (damagesource == pm.k || damagesource == pm.a || damagesource == pm.b || damagesource == pm.c) {
            this.aP = 0;
            System.out.println("Prevented damage from fire/explosion/lava.  DamageSource == " + damagesource.m);
            return false;
        }
        if (this.deathCounter == 0) {
            final int n = 10;
            this.aQ = n;
            this.aP = n;
            return this.head.a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (this.head == null || this.head.K) {
            this.v();
        }
        if (!this.o.I && this.o.v == 0) {
            this.v();
        }
    }
    
    public void pullTowards(final ia leader) {
        this.bw = this.head.bw * 1.5f;
        final float angle = (float)Math.atan2(this.u - leader.u, this.s - leader.s);
        final double idealX = leader.s + me.b(angle) * this.sDist;
        final double idealZ = leader.u + me.a(angle) * this.sDist;
        final double dx = idealX - this.s;
        double dy = leader.t - this.t;
        final double dz = idealZ - this.u;
        final double dist = me.a(dx * dx + dz * dz);
        if (dist > this.sDist * 4.0) {
            this.b(idealX, leader.t + 0.001, idealZ, 0.0f, (float)(angle * 180.0f / 3.141592653589793) - 90.0f);
            dy = 0.0;
            this.a(leader, 90.0f, 90.0f);
            this.bs = (float)(this.bw * dist * 5.0);
        }
        else if (dist > 0.0) {
            this.a(leader, 90.0f, 90.0f);
            this.bs = this.head.bw;
        }
        if (dy > 1.1) {
            this.ak();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.aQ = n;
        this.aP = n;
        this.deathCounter = 30;
    }
    
    public int f_() {
        return 250;
    }
}
