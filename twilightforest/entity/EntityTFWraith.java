// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;

public class EntityTFWraith extends ma implements qe
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private lq targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    int attackStrength;
    
    public EntityTFWraith(final yc world) {
        super(world);
        this.aG = "/twilightforest/ghost-crown.png";
        this.bH = 0.5f;
        this.attackStrength = 5;
    }
    
    public EntityTFWraith(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public int aT() {
        return 20;
    }
    
    public void c() {
        if (this.p.u()) {
            final float f = this.c(1.0f);
            if (f <= 0.5f || !this.p.k(ke.c(this.t), ke.c(this.u), ke.c(this.v)) || this.aa.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.c();
    }
    
    public boolean f_() {
        return false;
    }
    
    protected void bn() {
        if (!this.p.I && this.p.s == 0) {
            this.x();
        }
        this.bk();
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - this.t;
        final double d2 = this.waypointY - this.u;
        final double d3 = this.waypointZ - this.v;
        final double d4 = ke.a(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = this.t + (this.aa.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.u + (this.aa.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.v + (this.aa.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.aa.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.w += d / d4 * 0.1;
                this.x += d2 / d4 * 0.1;
                this.y += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.t;
                this.waypointY = this.u;
                this.waypointZ = this.v;
                this.targetedEntity = null;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.L) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.findPlayerToAttack();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        else {
            final float f1 = this.targetedEntity.d((lq)this);
            if (this.n(this.targetedEntity)) {
                this.attackEntity(this.targetedEntity, f1);
            }
            else {
                this.attackBlockedEntity(this.targetedEntity, f1);
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.e((lq)this) < d5 * d5) {
            final double d6 = this.targetedEntity.t - this.t;
            final double d7 = this.targetedEntity.D.b + this.targetedEntity.O / 2.0f - (this.u + this.O / 2.0f);
            final double d8 = this.targetedEntity.v - this.v;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            this.z = n;
            this.ax = n;
            if (this.n(this.targetedEntity)) {
                if (this.attackCounter == 10) {}
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.waypointX = this.targetedEntity.t;
                    this.waypointY = this.targetedEntity.u - this.targetedEntity.O + 0.5;
                    this.waypointZ = this.targetedEntity.v;
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.w, this.y) * 180.0f / 3.141593f;
            this.z = n2;
            this.ax = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }
    
    protected void attackEntity(final lq entity, final float f) {
        if (this.aZ <= 0 && f < 2.0f && entity.D.e > this.D.b && entity.D.b < this.D.e) {
            this.aZ = 20;
            entity.a(lh.a((md)this), this.attackStrength);
        }
    }
    
    protected void attackBlockedEntity(final lq entity, final float f) {
    }
    
    public boolean a(final lh damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        final lq entity = damagesource.g();
        if (this.n == entity || this.o == entity) {
            return true;
        }
        if (entity != this) {
            this.targetedEntity = entity;
        }
        return true;
    }
    
    protected lq findPlayerToAttack() {
        final qx entityplayer = this.p.b((lq)this, 16.0);
        if (entityplayer != null && this.n((lq)entityplayer)) {
            return (lq)entityplayer;
        }
        return null;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.t) / d3;
        final double d5 = (this.waypointY - this.u) / d3;
        final double d6 = (this.waypointZ - this.v) / d3;
        final aoe axisalignedbb = this.D.c();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.d(d4, d5, d6);
            if (this.p.a((lq)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String aY() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String aZ() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String ba() {
        return "mob.tf.wraith.wraith";
    }
    
    protected int bb() {
        return up.aT.cj;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
            final int chunkX = ke.c(this.t) >> 4;
            final int chunkZ = ke.c(this.v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hill3) {
                ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHill3);
            }
        }
    }
}
