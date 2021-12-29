// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.Difficulty;
import java.util.Objects;
import java.util.Optional;
import twilightforest.worldgen.biomes.BiomeKeys;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public class MosquitoSwarmEntity extends MonsterEntity
{
    public MosquitoSwarmEntity(final EntityType<? extends MosquitoSwarmEntity> type, final World world) {
        super((EntityType)type, world);
        this.field_70138_W = 2.1f;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 12.0).func_233815_a_(Attributes.field_233821_d_, 0.23).func_233815_a_(Attributes.field_233823_f_, 3.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.MOSQUITO;
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (super.func_70652_k(entity)) {
            if (entity instanceof LivingEntity) {
                int duration = 0;
                switch (this.field_70170_p.func_175659_aa()) {
                    case EASY: {
                        duration = 7;
                        break;
                    }
                    default: {
                        duration = 15;
                        break;
                    }
                    case HARD: {
                        duration = 30;
                        break;
                    }
                }
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76438_s, duration * 20, 0));
            }
            return true;
        }
        return false;
    }
    
    public static boolean canSpawn(final EntityType<? extends MonsterEntity> type, final IWorld world, final SpawnReason reason, final BlockPos pos, final Random rand) {
        final Optional<RegistryKey<Biome>> key = world.func_242406_i(pos);
        if (Objects.equals(key, Optional.of(BiomeKeys.SWAMP))) {
            return world.func_175659_aa() != Difficulty.PEACEFUL && MobEntity.func_223315_a((EntityType)type, world, reason, pos, rand);
        }
        return MonsterEntity.func_223324_d((EntityType)type, world, reason, pos, rand);
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public int func_70641_bl() {
        return 1;
    }
}
