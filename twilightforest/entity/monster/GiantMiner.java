// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.core.BlockPos;
import java.util.List;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class GiantMiner extends Monster
{
    public GiantMiner(final EntityType<? extends GiantMiner> type, final Level world) {
        super((EntityType)type, world);
        for (final EquipmentSlot slot : EquipmentSlot.values()) {
            this.m_21409_(slot, 0.0f);
        }
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(4, (Goal)new MeleeAttackGoal(this, 1.0, false) {
            protected double m_6639_(final LivingEntity attackTarget) {
                return this.f_25540_.m_20205_() * this.f_25540_.m_20206_();
            }
        });
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 80.0).m_22268_(Attributes.f_22279_, 0.23).m_22268_(Attributes.f_22281_, 2.0).m_22268_(Attributes.f_22277_, 40.0);
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable final SpawnGroupData spawnDataIn, @Nullable final CompoundTag dataTag) {
        final SpawnGroupData data = super.m_6518_(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.m_6851_(difficulty);
        this.m_6850_(difficulty);
        return data;
    }
    
    protected void m_6851_(final DifficultyInstance difficulty) {
        this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42427_));
    }
    
    protected void m_7908_(final float chance) {
    }
    
    protected void m_21380_(final float chance, final EquipmentSlot slot) {
    }
    
    public boolean m_7327_(final Entity entityIn) {
        entityIn.m_6469_(TFDamageSources.ant((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_));
        return super.m_7327_(entityIn);
    }
    
    public int m_5792_() {
        return 1;
    }
    
    public boolean m_5545_(final LevelAccessor worldIn, final MobSpawnType spawnReasonIn) {
        final List<GiantMiner> giantsNearby = worldIn.m_45976_((Class)GiantMiner.class, this.m_142469_().m_82377_(100.0, 10.0, 100.0));
        return giantsNearby.size() < 10;
    }
    
    public static boolean canSpawn(final EntityType<? extends GiantMiner> type, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random rand) {
        return Monster.m_33017_((EntityType)type, world, reason, pos, rand) || world.m_8055_(pos).m_60734_() == TFBlocks.WISPY_CLOUD.get() || world.m_8055_(pos).m_60734_() == TFBlocks.FLUFFY_CLOUD.get();
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
}
