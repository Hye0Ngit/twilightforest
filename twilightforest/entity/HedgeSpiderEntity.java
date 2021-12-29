// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.SpawnReason;
import net.minecraft.block.BlockState;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SpiderEntity;

public class HedgeSpiderEntity extends SpiderEntity
{
    public HedgeSpiderEntity(final EntityType<? extends HedgeSpiderEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.field_220892_d.removeIf(t -> t.func_220772_j() instanceof MeleeAttackGoal);
        this.field_70714_bg.func_75776_a(4, (Goal)new MeleeAttackGoal(this, 1.0, true) {
            protected double func_179512_a(final LivingEntity attackTarget) {
                return 4.0f + attackTarget.func_213311_cf();
            }
        });
        this.field_70715_bh.field_220892_d.removeIf(t -> t.func_220770_h() == 2 && t.func_220772_j() instanceof NearestAttackableTargetGoal);
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static boolean isValidLightLevel(final IServerWorld world, final BlockPos pos, final Random random) {
        final int chunkX = MathHelper.func_76141_d((float)pos.func_177958_n()) >> 4;
        final int chunkZ = MathHelper.func_76141_d((float)pos.func_177952_p()) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, (ISeedReader)world) == TFFeature.HEDGE_MAZE || MonsterEntity.func_223323_a(world, pos, random);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.HEDGE_SPIDER_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.HEDGE_SPIDER_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.HEDGE_SPIDER_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState blockIn) {
        this.func_184185_a(TFSounds.HEDGE_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    public static boolean canSpawn(final EntityType<HedgeSpiderEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random);
    }
}
