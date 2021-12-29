// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFWraith extends wk implements aey
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private ia targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    int attackStrength;
    
    public EntityTFWraith(final ry world) {
        super(world);
        this.aA = "/twilightforest/ghost-crown.png";
        this.bw = 0.5f;
        this.attackStrength = 5;
    }
    
    public int f_() {
        return 20;
    }
    
    public void c() {
        if (this.o.l()) {
            final float f = this.b(1.0f);
            if (f <= 0.5f || !this.o.l(me.c(this.s), me.c(this.t), me.c(this.u)) || this.Y.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.c();
    }
    
    public boolean d_() {
        return false;
    }
    
    protected void n() {
        if (!this.o.I && this.o.v == 0) {
            this.v();
        }
        this.al();
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - this.s;
        final double d2 = this.waypointY - this.t;
        final double d3 = this.waypointZ - this.u;
        final double d4 = me.a(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = this.s + (this.Y.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.t + (this.Y.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.u + (this.Y.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.Y.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.v += d / d4 * 0.1;
                this.w += d2 / d4 * 0.1;
                this.x += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.s;
                this.waypointY = this.t;
                this.waypointZ = this.u;
                this.targetedEntity = null;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.K) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.findPlayerToAttack();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        else {
            final float f1 = this.targetedEntity.c((ia)this);
            if (this.i(this.targetedEntity)) {
                this.attackEntity(this.targetedEntity, f1);
            }
            else {
                this.attackBlockedEntity(this.targetedEntity, f1);
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.d((ia)this) < d5 * d5) {
            final double d6 = this.targetedEntity.s - this.s;
            final double d7 = this.targetedEntity.C.b + this.targetedEntity.N / 2.0f - (this.t + this.N / 2.0f);
            final double d8 = this.targetedEntity.u - this.u;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            this.y = n;
            this.at = n;
            if (this.i(this.targetedEntity)) {
                if (this.attackCounter == 10) {}
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.waypointX = this.targetedEntity.s;
                    this.waypointY = this.targetedEntity.t - this.targetedEntity.N + 0.5;
                    this.waypointZ = this.targetedEntity.u;
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.v, this.x) * 180.0f / 3.141593f;
            this.y = n2;
            this.at = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }
    
    protected void attackEntity(final ia entity, final float f) {
        if (this.aT <= 0 && f < 2.0f && entity.C.e > this.C.b && entity.C.b < this.C.e) {
            this.aT = 20;
            entity.a(pm.a((nq)this), this.attackStrength);
        }
    }
    
    protected void attackBlockedEntity(final ia entity, final float f) {
    }
    
    public boolean a(final pm damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        final ia entity = damagesource.a();
        if (this.m == entity || this.n == entity) {
            return true;
        }
        if (entity != this) {
            this.targetedEntity = entity;
        }
        return true;
    }
    
    protected ia findPlayerToAttack() {
        final vi entityplayer = this.o.a((ia)this, 16.0);
        if (entityplayer != null && this.i((ia)entityplayer)) {
            return (ia)entityplayer;
        }
        return null;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.s) / d3;
        final double d5 = (this.waypointY - this.t) / d3;
        final double d6 = (this.waypointZ - this.u) / d3;
        final c axisalignedbb = this.C.d();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.d(d4, d5, d6);
            if (this.o.a((ia)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String e() {
        return "mob.zombie";
    }
    
    protected String f() {
        return "mob.zombiehurt";
    }
    
    protected String g() {
        return "mob.zombiedeath";
    }
    
    protected int k() {
        return acy.aS.bM;
    }
}
