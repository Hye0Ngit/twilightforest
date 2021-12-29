// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import java.util.Iterator;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.server.level.ServerPlayer;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import javax.annotation.Nullable;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import twilightforest.entity.ai.FindLooseGoal;
import twilightforest.entity.ai.EatLooseGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.animal.Animal;

public class QuestRam extends Animal
{
    private static final EntityDataAccessor<Integer> DATA_COLOR;
    private static final EntityDataAccessor<Boolean> DATA_REWARDED;
    private int randomTickDivider;
    
    public QuestRam(final EntityType<? extends QuestRam> type, final Level world) {
        super((EntityType)type, world);
        this.randomTickDivider = 0;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 1.3799999952316284));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.0, Ingredient.m_43911_((Tag)ItemTags.f_13167_), false));
        this.f_21345_.m_25352_(3, (Goal)new EatLooseGoal(this));
        this.f_21345_.m_25352_(4, (Goal)new FindLooseGoal((PathfinderMob)this, 1.0, Ingredient.m_43911_((Tag)ItemTags.f_13167_)));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    @Nullable
    public Animal getBreedOffspring(final ServerLevel world, final AgeableMob mate) {
        return null;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 70.0).m_22268_(Attributes.f_22279_, 0.23);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)QuestRam.DATA_COLOR, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)QuestRam.DATA_REWARDED, (Object)false);
    }
    
    protected void m_8024_() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.f_19796_.nextInt(50);
            final int chunkX = Mth.m_14107_(this.m_20185_()) / 16;
            final int chunkZ = Mth.m_14107_(this.m_20189_()) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, (WorldGenLevel)this.f_19853_);
            if (nearFeature != TFFeature.QUEST_GROVE) {
                this.m_21536_();
            }
            else {
                final BlockPos cc = TFFeature.getNearestCenterXYZ(Mth.m_14107_(this.m_20185_()), Mth.m_14107_(this.m_20189_()));
                this.m_21446_(cc, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.m_8024_();
    }
    
    private void rewardQuest() {
        final LootContext ctx = new LootContext.Builder((ServerLevel)this.f_19853_).m_78972_(LootContextParams.f_81455_, (Object)this).m_78975_(LootContextParamSets.f_81417_);
        this.f_19853_.m_142572_().m_129898_().m_79217_(TFTreasure.QUESTING_RAM_REWARDS).m_79148_(ctx, s -> this.m_5552_(s, 1.0f));
        for (final ServerPlayer player : this.f_19853_.m_45976_((Class)ServerPlayer.class, this.m_142469_().m_82377_(16.0, 16.0, 16.0))) {
            TFAdvancements.QUEST_RAM_COMPLETED.trigger(player);
        }
    }
    
    public InteractionResult m_7111_(final Player player, final Vec3 vec, final InteractionHand hand) {
        final ItemStack currentItem = player.m_21120_(hand);
        if (this.tryAccept(currentItem)) {
            if (!player.m_150110_().f_35937_) {
                currentItem.m_41774_(1);
            }
            return InteractionResult.SUCCESS;
        }
        return super.m_7111_(player, vec, hand);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.f_19853_.f_46443_ && this.countColorsSet() > 15 && !this.getRewarded()) {
            this.animateAddColor(DyeColor.m_41053_(this.f_19796_.nextInt(16)), 5);
        }
    }
    
    public boolean tryAccept(final ItemStack stack) {
        if (stack.m_150922_((Tag)ItemTags.f_13167_)) {
            final DyeColor color = guessColor(stack);
            if (color != null && !this.isColorPresent(color)) {
                this.setColorPresent(color);
                this.animateAddColor(color, 50);
                return true;
            }
        }
        return false;
    }
    
    @Nullable
    public static DyeColor guessColor(final ItemStack stack) {
        final List<Item> wools = (List<Item>)ImmutableList.of((Object)Blocks.f_50041_.m_5456_(), (Object)Blocks.f_50042_.m_5456_(), (Object)Blocks.f_50096_.m_5456_(), (Object)Blocks.f_50097_.m_5456_(), (Object)Blocks.f_50098_.m_5456_(), (Object)Blocks.f_50099_.m_5456_(), (Object)Blocks.f_50100_.m_5456_(), (Object)Blocks.f_50101_.m_5456_(), (Object)Blocks.f_50102_.m_5456_(), (Object)Blocks.f_50103_.m_5456_(), (Object)Blocks.f_50104_.m_5456_(), (Object)Blocks.f_50105_.m_5456_(), (Object[])new Item[] { Blocks.f_50106_.m_5456_(), Blocks.f_50107_.m_5456_(), Blocks.f_50108_.m_5456_(), Blocks.f_50109_.m_5456_() });
        final int i = wools.indexOf(stack.m_41720_());
        if (i < 0) {
            return null;
        }
        return DyeColor.m_41053_(i);
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128405_("ColorFlags", this.getColorFlags());
        compound.m_128379_("Rewarded", this.getRewarded());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setColorFlags(compound.m_128451_("ColorFlags"));
        this.setRewarded(compound.m_128471_("Rewarded"));
    }
    
    private int getColorFlags() {
        return (int)this.f_19804_.m_135370_((EntityDataAccessor)QuestRam.DATA_COLOR);
    }
    
    private void setColorFlags(final int flags) {
        this.f_19804_.m_135381_((EntityDataAccessor)QuestRam.DATA_COLOR, (Object)flags);
    }
    
    public boolean isColorPresent(final DyeColor color) {
        return (this.getColorFlags() & 1 << color.m_41060_()) > 0;
    }
    
    public void setColorPresent(final DyeColor color) {
        this.setColorFlags(this.getColorFlags() | 1 << color.m_41060_());
    }
    
    public boolean getRewarded() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)QuestRam.DATA_REWARDED);
    }
    
    public void setRewarded(final boolean rewarded) {
        this.f_19804_.m_135381_((EntityDataAccessor)QuestRam.DATA_REWARDED, (Object)rewarded);
    }
    
    private void animateAddColor(final DyeColor color, final int iterations) {
        final float[] colorVal = color.m_41068_();
        final float red = colorVal[0];
        final float green = colorVal[1];
        final float blue = colorVal[2];
        for (int i = 0; i < iterations; ++i) {
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123811_, this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 1.5, this.m_20186_() + this.f_19796_.nextDouble() * this.m_20206_() * 1.5, this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 1.5, (double)red, (double)green, (double)blue);
        }
        this.m_8032_();
    }
    
    public int countColorsSet() {
        return Integer.bitCount(this.getColorFlags());
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    protected float m_6121_() {
        return 1.0f;
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.QUEST_RAM_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.QUEST_RAM_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.QUEST_RAM_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.QUEST_RAM_STEP, 0.15f, 1.0f);
    }
    
    static {
        DATA_COLOR = SynchedEntityData.m_135353_((Class)QuestRam.class, EntityDataSerializers.f_135028_);
        DATA_REWARDED = SynchedEntityData.m_135353_((Class)QuestRam.class, EntityDataSerializers.f_135035_);
    }
}
