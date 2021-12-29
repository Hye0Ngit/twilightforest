import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFNagaSegment extends acl implements xb
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final wz world) {
        super(world);
        this.sDist = 1.5;
        this.bm = "/twilightforest/nagasegment.png";
        this.a(1.75f, 1.95f);
        this.R = 2.0f;
        this.bx = 1000;
        this.ab = true;
        this.attackStrength = 3;
        this.h = true;
    }
    
    public EntityTFNagaSegment(final wz world, final EntityTFNaga head, final int segment) {
        this(world);
        this.h = false;
        this.head = head;
        this.setSegment(segment);
        this.cj = head.cj * 1.5f;
        this.bt = head.bt;
        this.bu = head.bu;
    }
    
    public void setSegment(final int i) {
        this.ac.b(16, (Object)new Byte((byte)i));
    }
    
    public int getSegment() {
        return this.ac.a(16);
    }
    
    protected void b() {
        super.b();
        this.ac.a(16, (Object)new Byte((byte)1));
    }
    
    public boolean e_() {
        return true;
    }
    
    public void a(final nk entity, final int i, final double d, final double d1) {
    }
    
    protected void e(final float f) {
    }
    
    public boolean f_() {
        return false;
    }
    
    public boolean I() {
        return false;
    }
    
    public void I_() {
        this.despawnIfInvalid();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.U.nextGaussian() * 0.02;
                    final double d2 = this.U.nextGaussian() * 0.02;
                    final double d3 = this.U.nextGaussian() * 0.02;
                    final String explosionType = this.U.nextBoolean() ? "largeexplode" : "explode";
                    this.k.a(explosionType, this.o + this.U.nextFloat() * this.I * 2.0f - this.I, this.p + this.U.nextFloat() * this.J, this.q + this.U.nextFloat() * this.I * 2.0f - this.I, d, d2, d3);
                }
                this.z();
            }
        }
        super.I_();
    }
    
    protected void x_() {
        if (this.head != null && this.head.bE <= 0) {
            final List allNearEntities = this.k.b((nk)this, this.y.b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final nk nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof acl && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.bE = 10;
                    this.c(nearEntity);
                }
            }
        }
    }
    
    public boolean c(final nk entity) {
        if (entity instanceof bb) {
            return entity.a(ma.a((acl)this), this.attackStrength * 3);
        }
        return entity.a(ma.a((acl)this), this.attackStrength);
    }
    
    public boolean a(final ma damagesource, final int i) {
        if (damagesource == ma.l || damagesource == ma.b || damagesource == ma.c || damagesource == ma.d) {
            this.bA = 0;
            return false;
        }
        if (!this.k.F && this.deathCounter <= 0) {
            final int n = 10;
            this.bB = n;
            this.bA = n;
            return this.head.a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (!this.k.F) {
            if (this.head == null || this.head.G) {
                this.z();
            }
            if (this.k.q == 0) {
                this.z();
            }
        }
    }
    
    public void pullTowards(final nk leader) {
        this.cj = this.head.cj * 1.5f;
        final float angle = (float)Math.atan2(this.q - leader.q, this.o - leader.o);
        final double idealX = leader.o + gh.b(angle) * this.sDist;
        final double idealZ = leader.q + gh.a(angle) * this.sDist;
        final double dx = idealX - this.o;
        double dy = leader.p - this.p;
        final double dz = idealZ - this.q;
        final double dist = gh.a(dx * dx + dz * dz);
        if (dist > this.sDist * 4.0) {
            this.b(idealX, leader.p + 0.001, idealZ, 0.0f, (float)(angle * 180.0f / 3.141592653589793) - 90.0f);
            dy = 0.0;
            this.a(leader, 90.0f, 90.0f);
            this.cf = (float)(this.cj * dist * 5.0);
        }
        else if (dist > 0.0) {
            this.a(leader, 90.0f, 90.0f);
            this.cf = this.head.cj;
        }
        if (dy > 1.1) {
            this.aD();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.bB = n;
        this.bA = n;
        this.deathCounter = 30;
    }
    
    public int d() {
        return 250;
    }
}
