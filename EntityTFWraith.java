// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFWraith extends yx implements gg
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private tv targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    int attackStrength;
    
    public EntityTFWraith(final ge world) {
        super(world);
        this.ae = "/twilightforest/ghost-crown.png";
        this.bb = 0.5f;
        this.attackStrength = 5;
    }
    
    public EntityTFWraith(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public int d() {
        return 20;
    }
    
    public void e() {
        if (this.bi.e()) {
            final float f = this.b(1.0f);
            if (f <= 0.5f || !this.bi.l(kb.b(this.bm), kb.b(this.bn), kb.b(this.bo)) || this.bS.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.e();
    }
    
    public boolean g_() {
        return false;
    }
    
    protected void d_() {
        if (!this.bi.F && this.bi.q == 0) {
            this.X();
        }
        this.aG();
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - this.bm;
        final double d2 = this.waypointY - this.bn;
        final double d3 = this.waypointZ - this.bo;
        final double d4 = kb.a(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = this.bm + (this.bS.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.bn + (this.bS.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.bo + (this.bS.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.bS.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.bp += d / d4 * 0.1;
                this.bq += d2 / d4 * 0.1;
                this.br += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.bm;
                this.waypointY = this.bn;
                this.waypointZ = this.bo;
                this.targetedEntity = null;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.bE) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.findPlayerToAttack();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        else {
            final float f1 = this.targetedEntity.i((tv)this);
            if (this.h(this.targetedEntity)) {
                this.attackEntity(this.targetedEntity, f1);
            }
            else {
                this.attackBlockedEntity(this.targetedEntity, f1);
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.j((tv)this) < d5 * d5) {
            final double d6 = this.targetedEntity.bm - this.bm;
            final double d7 = this.targetedEntity.bw.b + this.targetedEntity.bH / 2.0f - (this.bn + this.bH / 2.0f);
            final double d8 = this.targetedEntity.bo - this.bo;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            this.bs = n;
            this.V = n;
            if (this.h(this.targetedEntity)) {
                if (this.attackCounter == 10) {}
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.waypointX = this.targetedEntity.bm;
                    this.waypointY = this.targetedEntity.bn - this.targetedEntity.bH + 0.5;
                    this.waypointZ = this.targetedEntity.bo;
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.bp, this.br) * 180.0f / 3.141593f;
            this.bs = n2;
            this.V = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }
    
    protected void attackEntity(final tv entity, final float f) {
        if (this.aw <= 0 && f < 2.0f && entity.bw.e > this.bw.b && entity.bw.b < this.bw.e) {
            this.aw = 20;
            entity.a(rq.a((ne)this), this.attackStrength);
        }
    }
    
    protected void attackBlockedEntity(final tv entity, final float f) {
    }
    
    public boolean a(final rq damagesource, final int i) {
        if (!super.a(damagesource, i)) {
            return false;
        }
        final tv entity = damagesource.a();
        if (this.bg == entity || this.bh == entity) {
            return true;
        }
        if (entity != this) {
            this.targetedEntity = entity;
        }
        return true;
    }
    
    protected tv findPlayerToAttack() {
        final ih entityplayer = this.bi.b((tv)this, 16.0);
        if (entityplayer != null && this.h((tv)entityplayer)) {
            return (tv)entityplayer;
        }
        return null;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.bm) / d3;
        final double d5 = (this.waypointY - this.bn) / d3;
        final double d6 = (this.waypointZ - this.bo) / d3;
        final fp axisalignedbb = this.bw.b();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.d(d4, d5, d6);
            if (this.bi.a((tv)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String i() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String j() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String k() {
        return "mob.tf.wraith.wraith";
    }
    
    protected int f() {
        return id.aS.bP;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
            final int chunkX = kb.b(this.bm) >> 4;
            final int chunkZ = kb.b(this.bo) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.bi) == TFFeature.hill3) {
                ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHill3);
            }
        }
    }
}
