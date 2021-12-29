// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;

public class HedgeSpider extends Spider
{
    public HedgeSpider(final EntityType<? extends HedgeSpider> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.f_25345_.removeIf(t -> t.m_26015_() instanceof MeleeAttackGoal);
        this.f_21345_.m_25352_(4, (Goal)new MeleeAttackGoal(this, 1.0, true) {
            protected double m_6639_(final LivingEntity attackTarget) {
                return 4.0f + attackTarget.m_20205_();
            }
        });
        this.f_21346_.f_25345_.removeIf(t -> t.m_26012_() == 2 && t.m_26015_() instanceof NearestAttackableTargetGoal);
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static boolean isValidLightLevel(final ServerLevelAccessor world, final BlockPos pos, final Random random) {
        final int chunkX = Mth.m_14143_((float)pos.m_123341_()) >> 4;
        final int chunkZ = Mth.m_14143_((float)pos.m_123343_()) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, (WorldGenLevel)world) == TFFeature.HEDGE_MAZE || Monster.m_33008_(world, pos, random);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.HEDGE_SPIDER_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.HEDGE_SPIDER_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.HEDGE_SPIDER_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState blockIn) {
        this.m_5496_(TFSounds.HEDGE_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    public static boolean canSpawn(final EntityType<HedgeSpider> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random);
    }
}
