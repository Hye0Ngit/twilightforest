// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;

public class EntityTFWraith extends oa implements tg
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private nm targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    
    public EntityTFWraith(final abv world) {
        super(world);
    }
    
    public EntityTFWraith(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(20.0);
        this.a(to.d).a(0.5);
        this.a(to.e).a(5.0);
    }
    
    public void c() {
        if (this.q.v()) {
            final float f = this.d(1.0f);
            if (f <= 0.5f || !this.q.l(lr.c(this.u), lr.c(this.v), lr.c(this.w)) || this.ab.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.c();
    }
    
    public boolean e_() {
        return false;
    }
    
    protected void bk() {
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
        this.bo();
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - this.u;
        final double d2 = this.waypointY - this.v;
        final double d3 = this.waypointZ - this.w;
        final double d4 = lr.a(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = this.u + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.v + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.w + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.ab.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.x += d / d4 * 0.1;
                this.y += d2 / d4 * 0.1;
                this.z += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.u;
                this.waypointY = this.v;
                this.waypointZ = this.w;
                this.targetedEntity = null;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.M) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.findPlayerToAttack();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        else {
            final float f1 = this.targetedEntity.d((nm)this);
            if (this.o(this.targetedEntity)) {
                this.attackEntity(this.targetedEntity, f1);
            }
            else {
                this.attackBlockedEntity(this.targetedEntity, f1);
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.e((nm)this) < d5 * d5) {
            final double d6 = this.targetedEntity.u - this.u;
            final double d7 = this.targetedEntity.E.b + this.targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
            final double d8 = this.targetedEntity.w - this.w;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            this.A = n;
            this.aN = n;
            if (this.o(this.targetedEntity)) {
                if (this.attackCounter == 10) {}
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.waypointX = this.targetedEntity.u;
                    this.waypointY = this.targetedEntity.v - this.targetedEntity.P + 0.5;
                    this.waypointZ = this.targetedEntity.w;
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.x, this.z) * 180.0f / 3.141593f;
            this.A = n2;
            this.aN = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }
    
    protected void attackEntity(final nm entity, final float f) {
        if (this.aC <= 0 && f < 2.0f && entity.E.e > this.E.b && entity.E.b < this.E.e) {
            this.aC = 20;
            final float damage = (float)this.a(to.e).e();
            entity.a(na.a((oe)this), damage);
        }
    }
    
    protected void attackBlockedEntity(final nm entity, final float f) {
    }
    
    public boolean a(final na damagesource, final float i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        final nm entity = damagesource.i();
        if (this.n == entity || this.o == entity) {
            return true;
        }
        if (entity != this) {
            this.targetedEntity = entity;
        }
        return true;
    }
    
    protected nm findPlayerToAttack() {
        final ue entityplayer = this.q.b((nm)this, 16.0);
        if (entityplayer != null && this.o((nm)entityplayer)) {
            return (nm)entityplayer;
        }
        return null;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.u) / d3;
        final double d5 = (this.waypointY - this.v) / d3;
        final double d6 = (this.waypointZ - this.w) / d3;
        final asu axisalignedbb = this.E.c();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.d(d4, d5, d6);
            if (this.q.a((nm)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String r() {
        return "TwilightForest:mob.wraith.wraith";
    }
    
    protected String aN() {
        return "TwilightForest:mob.wraith.wraith";
    }
    
    protected String aO() {
        return "TwilightForest:mob.wraith.wraith";
    }
    
    protected int s() {
        return yb.aV.cv;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            final int chunkX = lr.c(this.u) >> 4;
            final int chunkZ = lr.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hill3) {
                ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHill3);
            }
        }
    }
}
