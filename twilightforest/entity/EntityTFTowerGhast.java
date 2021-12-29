// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;

public class EntityTFTowerGhast extends rs
{
    protected ng targetedEntity;
    protected boolean isAggressive;
    protected int aggroCooldown;
    protected int explosionPower;
    protected int aggroCounter;
    protected float aggroRange;
    protected float stareRange;
    protected float wanderFactor;
    protected int inTrapCounter;
    
    public EntityTFTowerGhast(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/towerghast.png";
        this.a(4.0f, 6.0f);
        this.aggroRange = 64.0f;
        this.stareRange = 32.0f;
        this.wanderFactor = 16.0f;
        this.inTrapCounter = 0;
    }
    
    public int aW() {
        return 30;
    }
    
    protected float ba() {
        return 0.5f;
    }
    
    public int aQ() {
        return 160;
    }
    
    public int by() {
        return 8;
    }
    
    public void l_() {
        super.l_();
        final byte aggroStatus = this.ah.a(16);
        switch (aggroStatus) {
            default: {
                this.aH = "/mods/twilightforest/textures/model/towerghast.png";
                break;
            }
            case 1: {
                this.aH = "/mods/twilightforest/textures/model/towerghast_openeyes.png";
                break;
            }
            case 2: {
                this.aH = "/mods/twilightforest/textures/model/towerghast_fire.png";
                break;
            }
        }
    }
    
    public void c() {
        final float var1 = this.c(1.0f);
        if (var1 > 0.5f) {
            this.bC += 2;
        }
        if (this.ab.nextBoolean()) {
            this.q.a("reddust", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * this.P - 0.25, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.0, 0.0);
        }
        super.c();
    }
    
    protected void bq() {
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
        this.bn();
        this.checkForTowerHome();
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.targetedEntity = null;
            return;
        }
        this.f = this.g;
        if (this.targetedEntity != null && this.targetedEntity.M) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null) {
            this.targetedEntity = this.findPlayerInRange();
        }
        else if (!this.isAggressive && this.targetedEntity instanceof sk) {
            this.checkToIncreaseAggro((sk)this.targetedEntity);
        }
        final double offsetX = this.c - this.u;
        final double offsetY = this.d - this.v;
        final double offsetZ = this.e - this.w;
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if ((distanceDesired < 1.0 || distanceDesired > 3600.0) && this.wanderFactor > 0.0f) {
            this.c = this.u + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            this.d = this.v + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            this.e = this.w + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
        }
        if (this.targetedEntity == null && this.wanderFactor > 0.0f) {
            if (this.b-- <= 0) {
                this.b += this.ab.nextInt(20) + 20;
                distanceDesired = kx.a(distanceDesired);
                if (!this.d(kx.c(this.c), kx.c(this.d), kx.c(this.e))) {
                    final t cc = TFFeature.getNearestCenterXYZ(kx.c(this.u), kx.c(this.w), this.q);
                    aqw homeVector = this.q.T().a(cc.a - this.u, cc.b + 128 - this.v, cc.c - this.w);
                    homeVector = homeVector.a();
                    this.c = this.u + homeVector.c * 16.0 + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
                    this.d = this.v + homeVector.d * 16.0 + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
                    this.e = this.w + homeVector.e * 16.0 + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
                }
                if (this.isCourseTraversable(this.c, this.d, this.e, distanceDesired)) {
                    this.x += offsetX / distanceDesired * 0.1;
                    this.y += offsetY / distanceDesired * 0.1;
                    this.z += offsetZ / distanceDesired * 0.1;
                }
                else {
                    this.c = this.u;
                    this.d = this.v;
                    this.e = this.w;
                }
            }
        }
        else {
            this.x *= 0.75;
            this.y *= 0.75;
            this.z *= 0.75;
        }
        final double targetRange = (this.aggroCounter > 0 || this.isAggressive) ? this.aggroRange : ((double)this.stareRange);
        if (this.targetedEntity != null && this.targetedEntity.e((mp)this) < targetRange * targetRange && this.n((mp)this.targetedEntity)) {
            this.a((mp)this.targetedEntity, 10.0f, (float)this.bs());
            if (this.isAggressive) {
                if (this.g == 10) {
                    this.q.a((sk)null, 1007, (int)this.u, (int)this.v, (int)this.w, 0);
                }
                ++this.g;
                if (this.g == 20) {
                    this.spitFireball();
                    this.g = -40;
                }
            }
        }
        else {
            this.isAggressive = false;
            this.targetedEntity = null;
            final float n = -(float)Math.atan2(this.x, this.z) * 180.0f / 3.1415927f;
            this.A = n;
            this.ay = n;
            this.B = 0.0f;
        }
        if (this.g > 0 && !this.isAggressive) {
            --this.g;
        }
        final byte currentAggroStatus = this.ah.a(16);
        final byte newAggroStatus = (byte)((this.g > 10) ? 2 : ((this.aggroCounter > 0 || this.isAggressive) ? 1 : 0));
        if (currentAggroStatus != newAggroStatus) {
            this.ah.b(16, (Object)newAggroStatus);
        }
    }
    
    public int bs() {
        return 500;
    }
    
    protected void spitFireball() {
        final double offsetX = this.targetedEntity.u - this.u;
        final double offsetY = this.targetedEntity.E.b + this.targetedEntity.P / 2.0f - (this.v + this.P / 2.0f);
        final double offsetZ = this.targetedEntity.w - this.w;
        this.q.a((sk)null, 1008, (int)this.u, (int)this.v, (int)this.w, 0);
        final sr entityFireball = new sr(this.q, (ng)this, offsetX, offsetY, offsetZ);
        final double shotSpawnDistance = 0.5;
        final aqw lookVec = this.i(1.0f);
        entityFireball.u = this.u + lookVec.c * shotSpawnDistance;
        entityFireball.v = this.v + this.P / 2.0f + lookVec.d * shotSpawnDistance;
        entityFireball.w = this.w + lookVec.e * shotSpawnDistance;
        this.q.d((mp)entityFireball);
        if (this.ab.nextInt(6) == 0) {
            this.isAggressive = false;
        }
    }
    
    protected ng findPlayerInRange() {
        final sk closest = this.q.b((mp)this, (double)this.aggroRange);
        if (closest != null) {
            final float range = this.d((mp)closest);
            if (range < this.stareRange || this.shouldAttackPlayer(closest)) {
                return (ng)closest;
            }
        }
        return null;
    }
    
    protected void checkToIncreaseAggro(final sk par1EntityPlayer) {
        if (this.shouldAttackPlayer(par1EntityPlayer)) {
            if (this.aggroCounter == 0) {
                this.q.a((mp)this, "mob.ghast.moan", 1.0f, 1.0f);
            }
            if (this.aggroCounter++ >= 20) {
                this.aggroCounter = 0;
                this.isAggressive = true;
            }
        }
        else {
            this.aggroCounter = 0;
        }
    }
    
    protected boolean shouldAttackPlayer(final sk par1EntityPlayer) {
        final int dx = kx.c(par1EntityPlayer.u);
        final int dy = kx.c(par1EntityPlayer.v);
        final int dz = kx.c(par1EntityPlayer.w);
        return this.q.l(dx, dy, dz) && par1EntityPlayer.n((mp)this);
    }
    
    protected boolean isCourseTraversable(final double par1, final double par3, final double par5, final double par7) {
        final double var9 = (this.c - this.u) / par7;
        final double var10 = (this.d - this.v) / par7;
        final double var11 = (this.e - this.w) / par7;
        final aqr var12 = this.E.c();
        for (int var13 = 1; var13 < par7; ++var13) {
            var12.d(var9, var10, var11);
            if (!this.q.a((mp)this, var12).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean a(final mg par1DamageSource, final int par2) {
        final boolean wasAttacked = super.a(par1DamageSource, par2);
        if (wasAttacked && par1DamageSource.h() instanceof ng) {
            this.targetedEntity = (ng)par1DamageSource.h();
            return this.isAggressive = true;
        }
        return false;
    }
    
    public boolean bv() {
        return this.q.b(this.E) && this.q.a((mp)this, this.E).isEmpty() && !this.q.d(this.E) && this.q.r > 0 && this.isValidLightLevel();
    }
    
    protected boolean isValidLightLevel() {
        return true;
    }
    
    protected void checkForTowerHome() {
        if (!this.aP()) {
            final int chunkX = kx.c(this.u) >> 4;
            final int chunkZ = kx.c(this.w) >> 4;
            final TFFeature nearFeature = TFFeature.getNearestFeatureIncludeMore(chunkX, chunkZ, this.q);
            if (nearFeature != TFFeature.darkTower) {
                this.aO();
                this.bC += 5;
            }
            else {
                final t cc = TFFeature.getNearestCenterXYZ(kx.c(this.u), kx.c(this.w), this.q);
                this.b(cc.a, cc.b + 128, cc.c, 64);
            }
        }
    }
    
    public boolean d(final int x, final int y, final int z) {
        if (this.aN() == -1.0f) {
            return true;
        }
        final t home = this.aM();
        return y > 64 && y < 210 && home.e(x, home.b, z) < this.aN() * this.aN();
    }
    
    public void setInTrap() {
        this.inTrapCounter = 10;
    }
}
