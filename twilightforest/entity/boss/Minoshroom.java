// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import java.util.Iterator;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TFBlocks;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.DifficultyInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.ai.GroundAttackGoal;
import net.minecraft.world.entity.EquipmentSlot;
import java.util.ArrayList;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.monster.Minotaur;

public class Minoshroom extends Minotaur
{
    private static final EntityDataAccessor<Boolean> GROUND_ATTACK;
    private static final EntityDataAccessor<Integer> GROUND_CHARGE;
    private float prevClientSideChargeAnimation;
    private float clientSideChargeAnimation;
    private boolean groundSmashState;
    private final List<ServerPlayer> hurtBy;
    
    public Minoshroom(final EntityType<? extends Minoshroom> type, final Level world) {
        super(type, world);
        this.groundSmashState = false;
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.f_21364_ = 100;
        this.m_21409_(EquipmentSlot.MAINHAND, 1.1f);
    }
    
    @Override
    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.m_25352_(1, (Goal)new GroundAttackGoal(this));
    }
    
    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Minoshroom.GROUND_ATTACK, (Object)false);
        this.f_19804_.m_135372_((EntityDataAccessor)Minoshroom.GROUND_CHARGE, (Object)0);
    }
    
    public boolean isGroundAttackCharge() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Minoshroom.GROUND_ATTACK);
    }
    
    public void setGroundAttackCharge(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)Minoshroom.GROUND_ATTACK, (Object)flag);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Minotaur.registerAttributes().m_22268_(Attributes.f_22276_, 120.0);
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (this.f_19853_.f_46443_) {
            this.prevClientSideChargeAnimation = this.clientSideChargeAnimation;
            if (this.isGroundAttackCharge()) {
                this.clientSideChargeAnimation = Mth.m_14036_(this.clientSideChargeAnimation + 1.0f / (int)this.f_19804_.m_135370_((EntityDataAccessor)Minoshroom.GROUND_CHARGE) * 6.0f, 0.0f, 6.0f);
                this.groundSmashState = true;
            }
            else {
                this.clientSideChargeAnimation = Mth.m_14036_(this.clientSideChargeAnimation - 1.0f, 0.0f, 6.0f);
                if (this.groundSmashState) {
                    final BlockState block = this.f_19853_.m_8055_(this.m_142538_().m_7495_());
                    for (int i = 0; i < 80; ++i) {
                        final double cx = this.m_142538_().m_123341_() + this.f_19853_.f_46441_.nextFloat() * 10.0f - 5.0f;
                        final double cy = this.m_142469_().f_82289_ + 0.10000000149011612 + this.f_19853_.f_46441_.nextFloat() * 0.3f;
                        final double cz = this.m_142538_().m_123343_() + this.f_19853_.f_46441_.nextFloat() * 10.0f - 5.0f;
                        this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, block), cx, cy, cz, 0.0, 0.0, 0.0);
                    }
                    this.groundSmashState = false;
                }
            }
        }
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.MINOSHROOM_AMBIENT;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.MINOSHROOM_HURT;
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.MINOSHROOM_DEATH;
    }
    
    @Override
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.MINOSHROOM_STEP, 0.15f, 0.8f);
    }
    
    @Override
    public boolean m_7327_(final Entity entity) {
        final boolean success = super.m_7327_(entity);
        if (success && this.isCharging()) {
            entity.m_5997_(0.0, 0.4, 0.0);
            this.m_5496_(TFSounds.MINOSHROOM_ATTACK, 1.0f, 1.0f);
        }
        return success;
    }
    
    @OnlyIn(Dist.CLIENT)
    public float getChargeAnimationScale(final float p_189795_1_) {
        return (this.prevClientSideChargeAnimation + (this.clientSideChargeAnimation - this.prevClientSideChargeAnimation) * p_189795_1_) / 6.0f;
    }
    
    public void setMaxCharge(final int charge) {
        this.f_19804_.m_135381_((EntityDataAccessor)Minoshroom.GROUND_CHARGE, (Object)charge);
    }
    
    @Override
    protected void m_6851_(final DifficultyInstance difficulty) {
        super.m_6851_(difficulty);
        this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.DIAMOND_MINOTAUR_AXE.get()));
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        final Entity 7639_ = source.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        return super.m_6469_(source, amount);
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, new BlockPos((Vec3i)this.m_142538_()), TFFeature.LABYRINTH);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), ((TwilightChest)TFBlocks.MANGROVE_CHEST.get()).m_49966_(), new BlockPos(this.m_20182_()));
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    public boolean m_6785_(final double distance) {
        return false;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (this.m_21536_()) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.MINOSHROOM_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
        }
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static {
        GROUND_ATTACK = SynchedEntityData.m_135353_((Class)Minoshroom.class, EntityDataSerializers.f_135035_);
        GROUND_CHARGE = SynchedEntityData.m_135353_((Class)Minoshroom.class, EntityDataSerializers.f_135028_);
    }
}
