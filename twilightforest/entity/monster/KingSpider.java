// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.Entity;
import twilightforest.entity.TFEntities;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;

public class KingSpider extends Spider
{
    public KingSpider(final EntityType<? extends KingSpider> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        super.m_8099_();
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Spider.m_33815_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22279_, 0.35).m_22268_(Attributes.f_22281_, 6.0);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.KING_SPIDER_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.KING_SPIDER_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.KING_SPIDER_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState blockIn) {
        this.m_5496_(TFSounds.KING_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    public boolean m_6147_() {
        return false;
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable final CompoundTag dataTag) {
        livingData = super.m_6518_(worldIn, difficulty, reason, livingData, dataTag);
        final SkeletonDruid druid = (SkeletonDruid)TFEntities.SKELETON_DRUID.m_20615_(this.f_19853_);
        druid.m_7678_(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_146908_(), 0.0f);
        druid.m_6518_(worldIn, difficulty, MobSpawnType.JOCKEY, (SpawnGroupData)null, (CompoundTag)null);
        Entity lastRider;
        for (lastRider = (Entity)this; !lastRider.m_20197_().isEmpty(); lastRider = lastRider.m_20197_().get(0)) {}
        druid.m_20329_(lastRider);
        return livingData;
    }
    
    public double m_6048_() {
        return this.m_20206_() * 0.75;
    }
}
