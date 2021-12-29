// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFWraith extends akn implements xf
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private nn targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    int attackStrength;
    
    public EntityTFWraith(final xd world) {
        super(world);
        this.bm = "/twilightforest/ghost-crown.png";
        this.cj = 0.5f;
        this.attackStrength = 5;
    }
    
    public EntityTFWraith(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public int d() {
        return 20;
    }
    
    public void e() {
        if (this.k.m()) {
            final float f = this.a(1.0f);
            if (f <= 0.5f || !this.k.m(gk.c(this.o), gk.c(this.p), gk.c(this.q)) || this.U.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.e();
    }
    
    public boolean e_() {
        return false;
    }
    
    protected void y_() {
        if (!this.k.F && this.k.q == 0) {
            this.A();
        }
        this.w();
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - this.o;
        final double d2 = this.waypointY - this.p;
        final double d3 = this.waypointZ - this.q;
        final double d4 = gk.a(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = this.o + (this.U.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.p + (this.U.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.q + (this.U.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.U.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.r += d / d4 * 0.1;
                this.s += d2 / d4 * 0.1;
                this.t += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.o;
                this.waypointY = this.p;
                this.waypointZ = this.q;
                this.targetedEntity = null;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.G) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.findPlayerToAttack();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        else {
            final float f1 = this.targetedEntity.e((nn)this);
            if (this.m(this.targetedEntity)) {
                this.attackEntity(this.targetedEntity, f1);
            }
            else {
                this.attackBlockedEntity(this.targetedEntity, f1);
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.f((nn)this) < d5 * d5) {
            final double d6 = this.targetedEntity.o - this.o;
            final double d7 = this.targetedEntity.y.b + this.targetedEntity.J / 2.0f - (this.p + this.J / 2.0f);
            final double d8 = this.targetedEntity.q - this.q;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            this.u = n;
            this.bd = n;
            if (this.m(this.targetedEntity)) {
                if (this.attackCounter == 10) {}
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.waypointX = this.targetedEntity.o;
                    this.waypointY = this.targetedEntity.p - this.targetedEntity.J + 0.5;
                    this.waypointZ = this.targetedEntity.q;
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.r, this.t) * 180.0f / 3.141593f;
            this.u = n2;
            this.bd = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }
    
    protected void attackEntity(final nn entity, final float f) {
        if (this.bE <= 0 && f < 2.0f && entity.y.e > this.y.b && entity.y.b < this.y.e) {
            this.bE = 20;
            entity.a(md.a((acq)this), this.attackStrength);
        }
    }
    
    protected void attackBlockedEntity(final nn entity, final float f) {
    }
    
    public boolean a(final md damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        final nn entity = damagesource.a();
        if (this.i == entity || this.j == entity) {
            return true;
        }
        if (entity != this) {
            this.targetedEntity = entity;
        }
        return true;
    }
    
    protected nn findPlayerToAttack() {
        final yw entityplayer = this.k.b((nn)this, 16.0);
        if (entityplayer != null && this.m((nn)entityplayer)) {
            return (nn)entityplayer;
        }
        return null;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.o) / d3;
        final double d5 = (this.waypointY - this.p) / d3;
        final double d6 = (this.waypointZ - this.q) / d3;
        final wu axisalignedbb = this.y.d();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.d(d4, d5, d6);
            if (this.k.a((nn)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String m() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String n() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String o() {
        return "mob.tf.wraith.wraith";
    }
    
    protected int f() {
        return yr.aT.bQ;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
            final int chunkX = gk.c(this.o) >> 4;
            final int chunkZ = gk.c(this.q) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.k) == TFFeature.hill3) {
                ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHill3);
            }
        }
    }
}
