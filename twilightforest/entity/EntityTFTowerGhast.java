// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.DamageSource;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.Entity;
import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityGhast;

public class EntityTFTowerGhast extends EntityGhast
{
    protected EntityLiving targetedEntity;
    protected boolean isAggressive;
    protected int aggroCooldown;
    protected int explosionPower;
    protected int aggroCounter;
    protected float aggroRange;
    protected float stareRange;
    protected float wanderFactor;
    protected int inTrapCounter;
    
    public EntityTFTowerGhast(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/towerghast.png";
        this.func_70105_a(4.0f, 6.0f);
        this.aggroRange = 64.0f;
        this.stareRange = 32.0f;
        this.wanderFactor = 16.0f;
        this.inTrapCounter = 0;
    }
    
    public int func_70667_aM() {
        return 30;
    }
    
    protected float func_70599_aP() {
        return 0.5f;
    }
    
    public int func_70627_aG() {
        return 160;
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        final byte aggroStatus = this.field_70180_af.func_75683_a(16);
        switch (aggroStatus) {
            default: {
                this.field_70750_az = "/mods/twilightforest/textures/model/towerghast.png";
                break;
            }
            case 1: {
                this.field_70750_az = "/mods/twilightforest/textures/model/towerghast_openeyes.png";
                break;
            }
            case 2: {
                this.field_70750_az = "/mods/twilightforest/textures/model/towerghast_fire.png";
                break;
            }
        }
    }
    
    public void func_70636_d() {
        final float var1 = this.func_70013_c(1.0f);
        if (var1 > 0.5f) {
            this.field_70708_bq += 2;
        }
        if (this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_72869_a("reddust", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.0, 0.0);
        }
        super.func_70636_d();
    }
    
    protected void func_70626_be() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        this.checkForTowerHome();
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.targetedEntity = null;
            return;
        }
        this.field_70794_e = this.field_70791_f;
        if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null) {
            this.targetedEntity = this.findPlayerInRange();
        }
        else if (!this.isAggressive && this.targetedEntity instanceof EntityPlayer) {
            this.checkToIncreaseAggro((EntityPlayer)this.targetedEntity);
        }
        final double offsetX = this.field_70795_b - this.field_70165_t;
        final double offsetY = this.field_70796_c - this.field_70163_u;
        final double offsetZ = this.field_70793_d - this.field_70161_v;
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        if ((distanceDesired < 1.0 || distanceDesired > 3600.0) && this.wanderFactor > 0.0f) {
            this.field_70795_b = this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            this.field_70796_c = this.field_70163_u + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
            this.field_70793_d = this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.wanderFactor;
        }
        if (this.targetedEntity == null && this.wanderFactor > 0.0f) {
            if (this.field_70797_a-- <= 0) {
                this.field_70797_a += this.field_70146_Z.nextInt(20) + 20;
                distanceDesired = MathHelper.func_76133_a(distanceDesired);
                if (!this.func_70649_d(MathHelper.func_76128_c(this.field_70795_b), MathHelper.func_76128_c(this.field_70796_c), MathHelper.func_76128_c(this.field_70793_d))) {
                    final ChunkCoordinates cc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v), this.field_70170_p);
                    Vec3 homeVector = this.field_70170_p.func_82732_R().func_72345_a(cc.field_71574_a - this.field_70165_t, cc.field_71572_b + 128 - this.field_70163_u, cc.field_71573_c - this.field_70161_v);
                    homeVector = homeVector.func_72432_b();
                    this.field_70795_b = this.field_70165_t + homeVector.field_72450_a * 16.0 + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f;
                    this.field_70796_c = this.field_70163_u + homeVector.field_72448_b * 16.0 + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f;
                    this.field_70793_d = this.field_70161_v + homeVector.field_72449_c * 16.0 + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f;
                }
                if (this.isCourseTraversable(this.field_70795_b, this.field_70796_c, this.field_70793_d, distanceDesired)) {
                    this.field_70159_w += offsetX / distanceDesired * 0.1;
                    this.field_70181_x += offsetY / distanceDesired * 0.1;
                    this.field_70179_y += offsetZ / distanceDesired * 0.1;
                }
                else {
                    this.field_70795_b = this.field_70165_t;
                    this.field_70796_c = this.field_70163_u;
                    this.field_70793_d = this.field_70161_v;
                }
            }
        }
        else {
            this.field_70159_w *= 0.75;
            this.field_70181_x *= 0.75;
            this.field_70179_y *= 0.75;
        }
        final double targetRange = (this.aggroCounter > 0 || this.isAggressive) ? this.aggroRange : ((double)this.stareRange);
        if (this.targetedEntity != null && this.targetedEntity.func_70068_e((Entity)this) < targetRange * targetRange && this.func_70685_l((Entity)this.targetedEntity)) {
            this.func_70625_a((Entity)this.targetedEntity, 10.0f, (float)this.func_70646_bf());
            if (this.isAggressive) {
                if (this.field_70791_f == 10) {
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1007, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }
                ++this.field_70791_f;
                if (this.field_70791_f == 20) {
                    this.spitFireball();
                    this.field_70791_f = -40;
                }
            }
        }
        else {
            this.isAggressive = false;
            this.targetedEntity = null;
            final float n = -(float)Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0f / 3.1415927f;
            this.field_70177_z = n;
            this.field_70761_aq = n;
            this.field_70125_A = 0.0f;
        }
        if (this.field_70791_f > 0 && !this.isAggressive) {
            --this.field_70791_f;
        }
        final byte currentAggroStatus = this.field_70180_af.func_75683_a(16);
        final byte newAggroStatus = (byte)((this.field_70791_f > 10) ? 2 : ((this.aggroCounter > 0 || this.isAggressive) ? 1 : 0));
        if (currentAggroStatus != newAggroStatus) {
            this.field_70180_af.func_75692_b(16, (Object)newAggroStatus);
        }
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    protected void spitFireball() {
        final double offsetX = this.targetedEntity.field_70165_t - this.field_70165_t;
        final double offsetY = this.targetedEntity.field_70121_D.field_72338_b + this.targetedEntity.field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double offsetZ = this.targetedEntity.field_70161_v - this.field_70161_v;
        this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        final EntityLargeFireball entityFireball = new EntityLargeFireball(this.field_70170_p, (EntityLiving)this, offsetX, offsetY, offsetZ);
        final double shotSpawnDistance = 0.5;
        final Vec3 lookVec = this.func_70676_i(1.0f);
        entityFireball.field_70165_t = this.field_70165_t + lookVec.field_72450_a * shotSpawnDistance;
        entityFireball.field_70163_u = this.field_70163_u + this.field_70131_O / 2.0f + lookVec.field_72448_b * shotSpawnDistance;
        entityFireball.field_70161_v = this.field_70161_v + lookVec.field_72449_c * shotSpawnDistance;
        this.field_70170_p.func_72838_d((Entity)entityFireball);
        if (this.field_70146_Z.nextInt(6) == 0) {
            this.isAggressive = false;
        }
    }
    
    protected EntityLiving findPlayerInRange() {
        final EntityPlayer closest = this.field_70170_p.func_72856_b((Entity)this, (double)this.aggroRange);
        if (closest != null) {
            final float range = this.func_70032_d((Entity)closest);
            if (range < this.stareRange || this.shouldAttackPlayer(closest)) {
                return (EntityLiving)closest;
            }
        }
        return null;
    }
    
    protected void checkToIncreaseAggro(final EntityPlayer par1EntityPlayer) {
        if (this.shouldAttackPlayer(par1EntityPlayer)) {
            if (this.aggroCounter == 0) {
                this.field_70170_p.func_72956_a((Entity)this, "mob.ghast.moan", 1.0f, 1.0f);
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
    
    protected boolean shouldAttackPlayer(final EntityPlayer par1EntityPlayer) {
        final int dx = MathHelper.func_76128_c(par1EntityPlayer.field_70165_t);
        final int dy = MathHelper.func_76128_c(par1EntityPlayer.field_70163_u);
        final int dz = MathHelper.func_76128_c(par1EntityPlayer.field_70161_v);
        return this.field_70170_p.func_72937_j(dx, dy, dz) && par1EntityPlayer.func_70685_l((Entity)this);
    }
    
    protected boolean isCourseTraversable(final double par1, final double par3, final double par5, final double par7) {
        final double var9 = (this.field_70795_b - this.field_70165_t) / par7;
        final double var10 = (this.field_70796_c - this.field_70163_u) / par7;
        final double var11 = (this.field_70793_d - this.field_70161_v) / par7;
        final AxisAlignedBB var12 = this.field_70121_D.func_72329_c();
        for (int var13 = 1; var13 < par7; ++var13) {
            var12.func_72317_d(var9, var10, var11);
            if (!this.field_70170_p.func_72945_a((Entity)this, var12).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final int par2) {
        final boolean wasAttacked = super.func_70097_a(par1DamageSource, par2);
        if (wasAttacked && par1DamageSource.func_76364_f() instanceof EntityLiving) {
            this.targetedEntity = (EntityLiving)par1DamageSource.func_76364_f();
            return this.isAggressive = true;
        }
        return wasAttacked;
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D) && this.field_70170_p.field_73013_u > 0 && this.isValidLightLevel();
    }
    
    protected boolean isValidLightLevel() {
        return true;
    }
    
    protected void checkForTowerHome() {
        if (!this.func_70622_aF()) {
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            final TFFeature nearFeature = TFFeature.getNearestFeatureIncludeMore(chunkX, chunkZ, this.field_70170_p);
            if (nearFeature != TFFeature.darkTower) {
                this.func_70677_aE();
                this.field_70708_bq += 5;
            }
            else {
                final ChunkCoordinates cc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v), this.field_70170_p);
                this.func_70598_b(cc.field_71574_a, cc.field_71572_b + 128, cc.field_71573_c, 64);
            }
        }
    }
    
    public boolean func_70649_d(final int x, final int y, final int z) {
        if (this.func_70640_aD() == -1.0f) {
            return true;
        }
        final ChunkCoordinates home = this.func_70602_aC();
        return y > 64 && y < 210 && home.func_71569_e(x, home.field_71572_b, z) < this.func_70640_aD() * this.func_70640_aD();
    }
    
    public void setInTrap() {
        this.inTrapCounter = 10;
    }
}
