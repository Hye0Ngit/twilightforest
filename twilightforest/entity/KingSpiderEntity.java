// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SpiderEntity;

public class KingSpiderEntity extends SpiderEntity
{
    public KingSpiderEntity(final EntityType<? extends KingSpiderEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return SpiderEntity.func_234305_eI_().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233821_d_, 0.35).func_233815_a_(Attributes.field_233823_f_, 6.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.KING_SPIDER_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.KING_SPIDER_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.KING_SPIDER_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState blockIn) {
        this.func_184185_a(TFSounds.KING_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    public boolean func_70617_f_() {
        return false;
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable final CompoundNBT dataTag) {
        livingData = super.func_213386_a(worldIn, difficulty, reason, livingData, dataTag);
        final SkeletonDruidEntity druid = (SkeletonDruidEntity)TFEntities.skeleton_druid.func_200721_a(this.field_70170_p);
        druid.func_70012_b(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70177_z, 0.0f);
        druid.func_213386_a(worldIn, difficulty, SpawnReason.JOCKEY, (ILivingEntityData)null, (CompoundNBT)null);
        Entity lastRider;
        for (lastRider = (Entity)this; !lastRider.func_184188_bt().isEmpty(); lastRider = lastRider.func_184188_bt().get(0)) {}
        druid.func_184220_m(lastRider);
        return livingData;
    }
    
    public double func_70042_X() {
        return this.func_213302_cg() * 0.75;
    }
}
