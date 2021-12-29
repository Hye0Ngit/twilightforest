// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class TowerBroodling extends SwarmSpider
{
    public TowerBroodling(final EntityType<? extends TowerBroodling> type, final Level world) {
        this(type, world, true);
    }
    
    public TowerBroodling(final EntityType<? extends TowerBroodling> type, final Level world, final boolean spawnMore) {
        super(type, world, spawnMore);
        this.f_21364_ = 3;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return SwarmSpider.registerAttributes().m_22268_(Attributes.f_22276_, 7.0).m_22268_(Attributes.f_22281_, 4.0);
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.BROODLING_AMBIENT;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.BROODLING_HURT;
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.BROODLING_DEATH;
    }
    
    @Override
    protected void m_7355_(final BlockPos pos, final BlockState blockIn) {
        this.m_5496_(TFSounds.BROODLING_STEP, 0.15f, 1.0f);
    }
    
    @Override
    protected boolean spawnAnother() {
        final SwarmSpider another = new TowerBroodling(TFEntities.CARMINITE_BROODLING, this.f_19853_, false);
        final double sx = this.m_20185_() + (this.f_19796_.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.m_20186_();
        final double sz = this.m_20189_() + (this.f_19796_.nextBoolean() ? 0.9 : -0.9);
        another.m_7678_(sx, sy, sz, this.f_19796_.nextFloat() * 360.0f, 0.0f);
        if (!another.m_5545_((LevelAccessor)this.f_19853_, MobSpawnType.MOB_SUMMONED)) {
            another.m_146870_();
            return false;
        }
        this.f_19853_.m_7967_((Entity)another);
        another.m_21373_();
        return true;
    }
    
    @Nullable
    @Override
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable final SpawnGroupData livingData, @Nullable final CompoundTag dataTag) {
        return livingData;
    }
}
