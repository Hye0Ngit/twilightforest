// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;

public class EntityTFTowerGhast extends ti
{
    private static final int AGGRO_STATUS = 16;
    protected oe bq;
    protected boolean isAggressive;
    protected int br;
    protected int explosionPower;
    protected int aggroCounter;
    protected float aggroRange;
    protected float stareRange;
    protected float wanderFactor;
    protected int inTrapCounter;
    private t homePosition;
    private float maximumHomeDistance;
    
    public EntityTFTowerGhast(final abv par1World) {
        super(par1World);
        this.homePosition = new t(0, 0, 0);
        this.maximumHomeDistance = -1.0f;
        this.a(4.0f, 6.0f);
        this.aggroRange = 64.0f;
        this.stareRange = 32.0f;
        this.wanderFactor = 16.0f;
        this.inTrapCounter = 0;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(30.0);
    }
    
    protected float aZ() {
        return 0.5f;
    }
    
    public int o() {
        return 160;
    }
    
    public int bv() {
        return 8;
    }
    
    public void l_() {
        super.l_();
        final byte aggroStatus = this.ah.a(16);
    }
    
    public int getAttackStatus() {
        return this.ah.a(16);
    }
    
    public void c() {
        final float var1 = this.d(1.0f);
        if (var1 > 0.5f) {
            this.aV += 2;
        }
        if (this.ab.nextBoolean()) {
            this.q.a("reddust", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * this.P - 0.25, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.0, 0.0);
        }
        super.c();
    }
    
    protected void bk() {
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
        this.bo();
        this.checkForTowerHome();
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.bq = null;
            return;
        }
        this.bo = this.bp;
        if (this.bq != null && this.bq.M) {
            this.bq = null;
        }
        if (this.bq == null) {
            this.bq = this.findPlayerInRange();
        }
        else if (!this.isAggressive && this.bq instanceof ue) {
            this.checkToIncreaseAggro((ue)this.bq);
        }
        final double offsetX = this.i - this.u;
        final double offsetY = this.j - this.v;
        final double offsetZ = this.bn - this.w;
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if ((distanceDesired < 1.0 || distanceDesired > 3600.0) && this.wanderFactor > 0.0f) {
            this.i = this.u + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            this.j = this.v + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            this.bn = this.w + (this.ab.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
        }
        if (this.bq == null && this.wanderFactor > 0.0f) {
            if (this.h-- <= 0) {
                this.h += this.ab.nextInt(20) + 20;
                distanceDesired = lr.a(distanceDesired);
                if (!this.isWithinHomeDistance(lr.c(this.i), lr.c(this.j), lr.c(this.bn))) {
                    final t cc = TFFeature.getNearestCenterXYZ(lr.c(this.u), lr.c(this.w), this.q);
                    asz homeVector = this.q.V().a(cc.a - this.u, cc.b + 128 - this.v, cc.c - this.w);
                    homeVector = homeVector.a();
                    this.i = this.u + homeVector.c * 16.0 + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
                    this.j = this.v + homeVector.d * 16.0 + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
                    this.bn = this.w + homeVector.e * 16.0 + (this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f;
                }
                if (this.a(this.i, this.j, this.bn, distanceDesired)) {
                    this.x += offsetX / distanceDesired * 0.1;
                    this.y += offsetY / distanceDesired * 0.1;
                    this.z += offsetZ / distanceDesired * 0.1;
                }
                else {
                    this.i = this.u;
                    this.j = this.v;
                    this.bn = this.w;
                }
            }
        }
        else {
            this.x *= 0.75;
            this.y *= 0.75;
            this.z *= 0.75;
        }
        final double targetRange = (this.aggroCounter > 0 || this.isAggressive) ? this.aggroRange : ((double)this.stareRange);
        if (this.bq != null && this.bq.e((nm)this) < targetRange * targetRange && this.o((nm)this.bq)) {
            this.a((nm)this.bq, 10.0f, (float)this.bp());
            if (this.isAggressive) {
                if (this.bp == 10) {
                    this.q.a((ue)null, 1007, (int)this.u, (int)this.v, (int)this.w, 0);
                }
                ++this.bp;
                if (this.bp == 20) {
                    this.spitFireball();
                    this.bp = -40;
                }
            }
        }
        else {
            this.isAggressive = false;
            this.bq = null;
            final float n = -(float)Math.atan2(this.x, this.z) * 180.0f / 3.1415927f;
            this.A = n;
            this.aN = n;
            this.B = 0.0f;
        }
        if (this.bp > 0 && !this.isAggressive) {
            --this.bp;
        }
        final byte currentAggroStatus = this.ah.a(16);
        final byte newAggroStatus = (byte)((this.bp > 10) ? 2 : ((this.aggroCounter > 0 || this.isAggressive) ? 1 : 0));
        if (currentAggroStatus != newAggroStatus) {
            this.ah.b(16, (Object)newAggroStatus);
        }
    }
    
    public int bp() {
        return 500;
    }
    
    protected void spitFireball() {
        final double offsetX = this.bq.u - this.u;
        final double offsetY = this.bq.E.b + this.bq.P / 2.0f - (this.v + this.P / 2.0f);
        final double offsetZ = this.bq.w - this.w;
        this.q.a((ue)null, 1008, (int)this.u, (int)this.v, (int)this.w, 0);
        final ul entityFireball = new ul(this.q, (oe)this, offsetX, offsetY, offsetZ);
        final double shotSpawnDistance = 0.5;
        final asz lookVec = this.j(1.0f);
        entityFireball.u = this.u + lookVec.c * shotSpawnDistance;
        entityFireball.v = this.v + this.P / 2.0f + lookVec.d * shotSpawnDistance;
        entityFireball.w = this.w + lookVec.e * shotSpawnDistance;
        this.q.d((nm)entityFireball);
        if (this.ab.nextInt(6) == 0) {
            this.isAggressive = false;
        }
    }
    
    protected oe findPlayerInRange() {
        final ue closest = this.q.b((nm)this, (double)this.aggroRange);
        if (closest != null) {
            final float range = this.d((nm)closest);
            if (range < this.stareRange || this.shouldAttackPlayer(closest)) {
                return (oe)closest;
            }
        }
        return null;
    }
    
    protected void checkToIncreaseAggro(final ue par1EntityPlayer) {
        if (this.shouldAttackPlayer(par1EntityPlayer)) {
            if (this.aggroCounter == 0) {
                this.q.a((nm)this, "mob.ghast.moan", 1.0f, 1.0f);
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
    
    protected boolean shouldAttackPlayer(final ue par1EntityPlayer) {
        final int dx = lr.c(par1EntityPlayer.u);
        final int dy = lr.c(par1EntityPlayer.v);
        final int dz = lr.c(par1EntityPlayer.w);
        return this.q.l(dx, dy, dz) && par1EntityPlayer.o((nm)this);
    }
    
    protected boolean a(final double par1, final double par3, final double par5, final double par7) {
        final double var9 = (this.i - this.u) / par7;
        final double var10 = (this.j - this.v) / par7;
        final double var11 = (this.bn - this.w) / par7;
        final asu var12 = this.E.c();
        for (int var13 = 1; var13 < par7; ++var13) {
            var12.d(var9, var10, var11);
            if (!this.q.a((nm)this, var12).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean a(final na par1DamageSource, final float par2) {
        final boolean wasAttacked = super.a(par1DamageSource, par2);
        if (wasAttacked && par1DamageSource.h() instanceof oe) {
            this.bq = (oe)par1DamageSource.h();
            return this.isAggressive = true;
        }
        return wasAttacked;
    }
    
    public boolean bs() {
        return this.q.b(this.E) && this.q.a((nm)this, this.E).isEmpty() && !this.q.d(this.E) && this.q.r > 0 && this.isValidLightLevel();
    }
    
    protected boolean isValidLightLevel() {
        return true;
    }
    
    protected void checkForTowerHome() {
        if (!this.hasHome()) {
            final int chunkX = lr.c(this.u) >> 4;
            final int chunkZ = lr.c(this.w) >> 4;
            final TFFeature nearFeature = TFFeature.getNearestFeatureIncludeMore(chunkX, chunkZ, this.q);
            if (nearFeature != TFFeature.darkTower) {
                this.detachHome();
                this.aV += 5;
            }
            else {
                final t cc = TFFeature.getNearestCenterXYZ(lr.c(this.u), lr.c(this.w), this.q);
                this.setHomeArea(cc.a, cc.b + 128, cc.c, 64);
            }
        }
    }
    
    public boolean isWithinHomeDistance(final int x, final int y, final int z) {
        if (this.getMaximumHomeDistance() == -1.0f) {
            return true;
        }
        final t home = this.getHomePosition();
        return y > 64 && y < 210 && home.e(x, home.b, z) < this.getMaximumHomeDistance() * this.getMaximumHomeDistance();
    }
    
    public void setInTrap() {
        this.inTrapCounter = 10;
    }
    
    public void setHomeArea(final int par1, final int par2, final int par3, final int par4) {
        this.homePosition.b(par1, par2, par3);
        this.maximumHomeDistance = (float)par4;
    }
    
    public t getHomePosition() {
        return this.homePosition;
    }
    
    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }
    
    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
}
