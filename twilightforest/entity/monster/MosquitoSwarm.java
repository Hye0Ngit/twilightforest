// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class MosquitoSwarm extends Monster
{
    public MosquitoSwarm(final EntityType<? extends MosquitoSwarm> type, final Level world) {
        super((EntityType)type, world);
        this.f_19793_ = 2.1f;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 12.0).m_22268_(Attributes.f_22279_, 0.23).m_22268_(Attributes.f_22281_, 3.0);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.MOSQUITO;
    }
    
    public boolean m_7327_(final Entity entity) {
        if (super.m_7327_(entity)) {
            if (entity instanceof LivingEntity) {
                int n = switch (this.f_19853_.m_46791_()) {
                    case EASY -> 7;
                    case HARD -> 30;
                    default -> 15;
                };
                final int duration = n;
                ((LivingEntity)entity).m_7292_(new MobEffectInstance(MobEffects.f_19612_, duration * 20, 0));
            }
            return true;
        }
        return false;
    }
    
    public static boolean canSpawn(final EntityType<? extends Monster> type, final LevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random rand) {
        return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_33023_((EntityType)type, world, reason, pos, rand);
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public int m_5792_() {
        return 1;
    }
}
