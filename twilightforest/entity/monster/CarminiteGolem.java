// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.DustParticleOptions;
import com.mojang.math.Vector3f;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.material.Material;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class CarminiteGolem extends Monster
{
    private int attackTimer;
    
    public CarminiteGolem(final EntityType<? extends CarminiteGolem> type, final Level world) {
        super((EntityType)type, world);
        this.m_21441_(BlockPathTypes.WATER, -1.0f);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(2, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0, 0.0f));
        this.f_21345_.m_25352_(3, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 40.0).m_22268_(Attributes.f_22279_, 0.25).m_22268_(Attributes.f_22281_, 9.0).m_22268_(Attributes.f_22284_, 2.0);
    }
    
    public boolean m_7327_(final Entity entity) {
        this.attackTimer = 10;
        this.f_19853_.m_7605_((Entity)this, (byte)4);
        final boolean attackSuccess = super.m_7327_(entity);
        if (attackSuccess) {
            entity.m_5997_(0.0, 0.4, 0.0);
        }
        return attackSuccess;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.CARMINITE_GOLEM_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.CARMINITE_GOLEM_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.CARMINITE_GOLEM_STEP, 1.0f, 1.0f);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.m_20184_().m_7096_() * this.m_20184_().m_7096_() + this.m_20184_().m_7094_() * this.m_20184_().m_7094_() > 2.500000277905201E-7 && this.f_19796_.nextInt(5) == 0) {
            final int i = Mth.m_14107_(this.m_20185_());
            final int j = Mth.m_14107_(this.m_20186_() - 0.20000000298023224);
            final int k = Mth.m_14107_(this.m_20189_());
            final BlockState iblockstate = this.f_19853_.m_8055_(new BlockPos(i, j, k));
            if (iblockstate.m_60767_() != Material.f_76296_) {
                this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, iblockstate), this.m_20185_() + (this.f_19796_.nextFloat() - 0.5) * this.m_20205_(), this.m_142469_().f_82289_ + 0.1, this.m_20189_() + (this.f_19796_.nextFloat() - 0.5) * this.m_20205_(), 4.0 * (this.f_19796_.nextFloat() - 0.5), 0.5, (this.f_19796_.nextFloat() - 0.5) * 4.0);
            }
        }
        if (this.f_19796_.nextBoolean()) {
            this.f_19853_.m_7106_((ParticleOptions)new DustParticleOptions(new Vector3f(1.0f, 0.0f, 0.0f), 1.0f), this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_(), this.m_20186_() + this.f_19796_.nextDouble() * this.m_20206_() - 0.25, this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_(), 0.0, 0.0, 0.0);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 4) {
            this.attackTimer = 10;
            this.m_5496_(TFSounds.CARMINITE_GOLEM_ATTACK, 1.0f, 1.0f);
        }
        else {
            super.m_7822_(id);
        }
    }
    
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    public int m_5792_() {
        return 16;
    }
}
