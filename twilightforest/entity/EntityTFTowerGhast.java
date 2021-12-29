// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.init.SoundEvents;
import net.minecraft.entity.ai.EntityMoveHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import java.util.Random;
import net.minecraft.util.math.Vec3i;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.ai.EntityAITFFindEntityNearestPlayer;
import twilightforest.entity.boss.EntityTFUrGhast;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.EntityGhast;

public class EntityTFTowerGhast extends EntityGhast
{
    private static final DataParameter<Byte> ATTACK_STATUS;
    private static final DataParameter<Byte> ATTACK_TIMER;
    private static final DataParameter<Byte> ATTACK_PREVTIMER;
    public static final ResourceLocation LOOT_TABLE;
    private AIAttack attackAI;
    protected float wanderFactor;
    private int inTrapCounter;
    private BlockPos homePosition;
    private float maximumHomeDistance;
    
    public EntityTFTowerGhast(final World world) {
        super(world);
        this.homePosition = BlockPos.field_177992_a;
        this.maximumHomeDistance = -1.0f;
        this.func_70105_a(4.0f, 6.0f);
        this.wanderFactor = 16.0f;
        this.inTrapCounter = 0;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFTowerGhast.ATTACK_STATUS, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFTowerGhast.ATTACK_TIMER, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFTowerGhast.ATTACK_PREVTIMER, (Object)0);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new AIHomedFly(this));
        if (!(this instanceof EntityTFUrGhast)) {
            this.field_70714_bg.func_75776_a(5, (EntityAIBase)new AIRandomFly(this));
        }
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityGhast.AILookAround((EntityGhast)this));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)(this.attackAI = new AIAttack(this)));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAITFFindEntityNearestPlayer((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(64.0);
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
    
    public void func_70636_d() {
        if (this.func_70013_c() > 0.5f) {
            this.field_70708_bq += 2;
        }
        if (this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.REDSTONE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
        }
        super.func_70636_d();
    }
    
    protected void func_70619_bc() {
        this.findHome();
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.func_70624_b((EntityLivingBase)null);
        }
        final int status = (this.func_70638_az() != null && this.shouldAttack(this.func_70638_az())) ? 1 : 0;
        this.field_70180_af.func_187227_b((DataParameter)EntityTFTowerGhast.ATTACK_STATUS, (Object)(byte)status);
        this.field_70180_af.func_187227_b((DataParameter)EntityTFTowerGhast.ATTACK_TIMER, (Object)(byte)this.attackAI.attackTimer);
        this.field_70180_af.func_187227_b((DataParameter)EntityTFTowerGhast.ATTACK_PREVTIMER, (Object)(byte)this.attackAI.prevAttackTimer);
    }
    
    public int getAttackStatus() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFTowerGhast.ATTACK_STATUS);
    }
    
    public int getAttackTimer() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFTowerGhast.ATTACK_TIMER);
    }
    
    public int getPrevAttackTimer() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFTowerGhast.ATTACK_PREVTIMER);
    }
    
    protected boolean shouldAttack(final EntityLivingBase living) {
        return true;
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    protected void spitFireball() {
        final Vec3d vec3d = this.func_70676_i(1.0f);
        final double d2 = this.func_70638_az().field_70165_t - (this.field_70165_t + vec3d.field_72450_a * 4.0);
        final double d3 = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().field_70131_O / 2.0f - (0.5 + this.field_70163_u + this.field_70131_O / 2.0f);
        final double d4 = this.func_70638_az().field_70161_v - (this.field_70161_v + vec3d.field_72449_c * 4.0);
        final EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.field_70170_p, (EntityLivingBase)this, d2, d3, d4);
        entitylargefireball.field_92057_e = this.func_175453_cd();
        entitylargefireball.field_70165_t = this.field_70165_t + vec3d.field_72450_a * 4.0;
        entitylargefireball.field_70163_u = this.field_70163_u + this.field_70131_O / 2.0f + 0.5;
        entitylargefireball.field_70161_v = this.field_70161_v + vec3d.field_72449_c * 4.0;
        this.field_70170_p.func_72838_d((Entity)entitylargefireball);
        if (this.field_70146_Z.nextInt(6) == 0) {
            this.func_70624_b((EntityLivingBase)null);
        }
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_72855_b(this.func_174813_aQ()) && this.field_70170_p.func_184144_a((Entity)this, this.func_174813_aQ()).isEmpty() && !this.field_70170_p.func_72953_d(this.func_174813_aQ()) && this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }
    
    protected boolean isValidLightLevel() {
        return true;
    }
    
    private void findHome() {
        if (!this.hasHome()) {
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            final TFFeature nearFeature = TFFeature.getFeatureForRegion(chunkX, chunkZ, this.field_70170_p);
            if (nearFeature != TFFeature.DARK_TOWER) {
                this.detachHome();
                this.field_70708_bq += 5;
            }
            else {
                final BlockPos cc = TFFeature.getNearestCenterXYZ(chunkX, chunkZ, this.field_70170_p);
                this.setHomePosAndDistance(cc.func_177981_b(128), 64);
            }
        }
    }
    
    public void setInTrap() {
        this.inTrapCounter = 10;
    }
    
    public boolean isWithinHomeDistanceCurrentPosition() {
        return this.isWithinHomeDistanceFromPosition(new BlockPos((Entity)this));
    }
    
    public boolean isWithinHomeDistanceFromPosition(final BlockPos pos) {
        return this.maximumHomeDistance == -1.0f || (pos.func_177956_o() > 64 && pos.func_177956_o() < 210 && this.homePosition.func_177951_i((Vec3i)pos) < this.maximumHomeDistance * this.maximumHomeDistance);
    }
    
    public void setHomePosAndDistance(final BlockPos pos, final int distance) {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }
    
    public BlockPos getHomePosition() {
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
    
    protected ResourceLocation func_184647_J() {
        return EntityTFTowerGhast.LOOT_TABLE;
    }
    
    static /* synthetic */ float access$300(final EntityTFTowerGhast x0) {
        return x0.func_70647_i();
    }
    
    static /* synthetic */ float access$400(final EntityTFTowerGhast x0) {
        return x0.func_70647_i();
    }
    
    static {
        ATTACK_STATUS = EntityDataManager.func_187226_a((Class)EntityTFTowerGhast.class, DataSerializers.field_187191_a);
        ATTACK_TIMER = EntityDataManager.func_187226_a((Class)EntityTFTowerGhast.class, DataSerializers.field_187191_a);
        ATTACK_PREVTIMER = EntityDataManager.func_187226_a((Class)EntityTFTowerGhast.class, DataSerializers.field_187191_a);
        LOOT_TABLE = TwilightForestMod.prefix("entities/tower_ghast");
    }
    
    public static class AIRandomFly extends EntityAIBase
    {
        private final EntityTFTowerGhast parentEntity;
        
        public AIRandomFly(final EntityTFTowerGhast ghast) {
            this.parentEntity = ghast;
            this.func_75248_a(1);
        }
        
        public boolean func_75250_a() {
            final EntityMoveHelper entitymovehelper = this.parentEntity.func_70605_aq();
            if (!entitymovehelper.func_75640_a()) {
                return this.parentEntity.func_70638_az() == null;
            }
            final double d0 = entitymovehelper.func_179917_d() - this.parentEntity.field_70165_t;
            final double d2 = entitymovehelper.func_179919_e() - this.parentEntity.field_70163_u;
            final double d3 = entitymovehelper.func_179918_f() - this.parentEntity.field_70161_v;
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return this.parentEntity.func_70638_az() == null && (d4 < 1.0 || d4 > 3600.0);
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final Random random = this.parentEntity.func_70681_au();
            final double d0 = this.parentEntity.field_70165_t + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d2 = this.parentEntity.field_70163_u + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d3 = this.parentEntity.field_70161_v + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            this.parentEntity.func_70605_aq().func_75642_a(d0, d2, d3, 1.0);
        }
    }
    
    public static class AIHomedFly extends EntityAIBase
    {
        private final EntityTFTowerGhast parentEntity;
        
        AIHomedFly(final EntityTFTowerGhast ghast) {
            this.parentEntity = ghast;
            this.func_75248_a(1);
        }
        
        public boolean func_75250_a() {
            final EntityMoveHelper entitymovehelper = this.parentEntity.func_70605_aq();
            if (!entitymovehelper.func_75640_a()) {
                return !this.parentEntity.isWithinHomeDistanceCurrentPosition();
            }
            final double d0 = entitymovehelper.func_179917_d() - this.parentEntity.field_70165_t;
            final double d2 = entitymovehelper.func_179919_e() - this.parentEntity.field_70163_u;
            final double d3 = entitymovehelper.func_179918_f() - this.parentEntity.field_70161_v;
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return (d4 < 1.0 || d4 > 3600.0) && !this.parentEntity.isWithinHomeDistanceCurrentPosition();
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final Random random = this.parentEntity.func_70681_au();
            final double d0 = this.parentEntity.field_70165_t + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d2 = this.parentEntity.field_70163_u + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d3 = this.parentEntity.field_70161_v + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            this.parentEntity.func_70605_aq().func_75642_a(d0, d2, d3, 1.0);
            if (this.parentEntity.func_174818_b(this.parentEntity.getHomePosition()) > 256.0) {
                final Vec3d vecToHome = new Vec3d((Vec3i)this.parentEntity.getHomePosition()).func_178788_d(this.parentEntity.func_174791_d()).func_72432_b();
                final double targetX = this.parentEntity.field_70165_t + vecToHome.field_72450_a * this.parentEntity.wanderFactor + (this.parentEntity.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                final double targetY = this.parentEntity.field_70163_u + vecToHome.field_72448_b * this.parentEntity.wanderFactor + (this.parentEntity.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                final double targetZ = this.parentEntity.field_70161_v + vecToHome.field_72449_c * this.parentEntity.wanderFactor + (this.parentEntity.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                this.parentEntity.func_70605_aq().func_75642_a(targetX, targetY, targetZ, 1.0);
            }
            else {
                this.parentEntity.func_70605_aq().func_75642_a(this.parentEntity.getHomePosition().func_177958_n() + 0.5, (double)this.parentEntity.getHomePosition().func_177956_o(), this.parentEntity.getHomePosition().func_177952_p() + 0.5, 1.0);
            }
        }
    }
    
    public static class AIAttack extends EntityAIBase
    {
        private final EntityTFTowerGhast parentEntity;
        public int attackTimer;
        public int prevAttackTimer;
        
        public AIAttack(final EntityTFTowerGhast ghast) {
            this.parentEntity = ghast;
        }
        
        public boolean func_75250_a() {
            return this.parentEntity.func_70638_az() != null && this.parentEntity.shouldAttack(this.parentEntity.func_70638_az());
        }
        
        public void func_75249_e() {
            final int n = 0;
            this.prevAttackTimer = n;
            this.attackTimer = n;
        }
        
        public void func_75251_c() {
            this.parentEntity.func_175454_a(false);
        }
        
        public void func_75246_d() {
            final EntityLivingBase entitylivingbase = this.parentEntity.func_70638_az();
            if (entitylivingbase.func_70068_e((Entity)this.parentEntity) < 4096.0 && this.parentEntity.func_70635_at().func_75522_a((Entity)entitylivingbase)) {
                final World world = this.parentEntity.field_70170_p;
                this.prevAttackTimer = this.attackTimer;
                ++this.attackTimer;
                this.parentEntity.func_70671_ap().func_75651_a((Entity)entitylivingbase, 10.0f, (float)this.parentEntity.func_70646_bf());
                if (this.attackTimer == 10) {
                    this.parentEntity.func_184185_a(SoundEvents.field_187559_bL, 10.0f, EntityTFTowerGhast.access$300(this.parentEntity));
                }
                if (this.attackTimer == 20) {
                    if (this.parentEntity.shouldAttack(entitylivingbase)) {
                        this.parentEntity.func_184185_a(SoundEvents.field_187557_bK, 10.0f, EntityTFTowerGhast.access$400(this.parentEntity));
                        this.parentEntity.spitFireball();
                        this.prevAttackTimer = this.attackTimer;
                    }
                    this.attackTimer = -40;
                }
            }
            else if (this.attackTimer > 0) {
                this.prevAttackTimer = this.attackTimer;
                --this.attackTimer;
            }
            this.parentEntity.func_175454_a(this.attackTimer > 10);
        }
    }
}
