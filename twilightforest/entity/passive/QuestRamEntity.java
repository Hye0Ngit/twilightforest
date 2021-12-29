// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.block.BlockState;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.Entity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.item.Item;
import net.minecraft.block.Blocks;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.player.PlayerEntity;
import java.util.Iterator;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.ServerPlayerEntity;
import twilightforest.loot.TFTreasure;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import javax.annotation.Nullable;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import twilightforest.entity.ai.FindLooseGoal;
import twilightforest.entity.ai.EatLooseGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.tags.ITag;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.passive.AnimalEntity;

public class QuestRamEntity extends AnimalEntity
{
    private static final DataParameter<Integer> DATA_COLOR;
    private static final DataParameter<Boolean> DATA_REWARDED;
    private int randomTickDivider;
    
    public QuestRamEntity(final EntityType<? extends QuestRamEntity> type, final World world) {
        super((EntityType)type, world);
        this.randomTickDivider = 0;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 1.3799999952316284));
        this.field_70714_bg.func_75776_a(2, (Goal)new TemptGoal((CreatureEntity)this, 1.0, Ingredient.func_199805_a((ITag)ItemTags.field_199904_a), false));
        this.field_70714_bg.func_75776_a(3, (Goal)new EatLooseGoal(this));
        this.field_70714_bg.func_75776_a(4, (Goal)new FindLooseGoal((CreatureEntity)this, 1.0, Ingredient.func_199805_a((ITag)ItemTags.field_199904_a)));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    @Nullable
    public AnimalEntity createChild(final ServerWorld world, final AgeableEntity mate) {
        return null;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 70.0).func_233815_a_(Attributes.field_233821_d_, 0.23);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)QuestRamEntity.DATA_COLOR, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)QuestRamEntity.DATA_REWARDED, (Object)false);
    }
    
    protected void func_70619_bc() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.field_70146_Z.nextInt(50);
            final int chunkX = MathHelper.func_76128_c(this.func_226277_ct_()) / 16;
            final int chunkZ = MathHelper.func_76128_c(this.func_226281_cx_()) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, (ISeedReader)this.field_70170_p);
            if (nearFeature != TFFeature.QUEST_GROVE) {
                this.func_213394_dL();
            }
            else {
                final BlockPos cc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(this.func_226277_ct_()), MathHelper.func_76128_c(this.func_226281_cx_()));
                this.func_213390_a(cc, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.func_70619_bc();
    }
    
    private void rewardQuest() {
        final LootContext ctx = new LootContext.Builder((ServerWorld)this.field_70170_p).func_216015_a(LootParameters.field_216281_a, (Object)this).func_216022_a(LootParameterSets.field_237453_h_);
        this.field_70170_p.func_73046_m().func_200249_aQ().func_186521_a(TFTreasure.QUESTING_RAM_REWARDS).func_216120_b(ctx, s -> this.func_70099_a(s, 1.0f));
        for (final ServerPlayerEntity player : this.field_70170_p.func_217357_a((Class)ServerPlayerEntity.class, this.func_174813_aQ().func_72314_b(16.0, 16.0, 16.0))) {
            TFAdvancements.QUEST_RAM_COMPLETED.trigger(player);
        }
    }
    
    public ActionResultType func_184199_a(final PlayerEntity player, final Vector3d vec, final Hand hand) {
        final ItemStack currentItem = player.func_184586_b(hand);
        if (this.tryAccept(currentItem)) {
            if (!player.field_71075_bZ.field_75098_d) {
                currentItem.func_190918_g(1);
            }
            return ActionResultType.SUCCESS;
        }
        return super.func_184199_a(player, vec, hand);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K && this.countColorsSet() > 15 && !this.getRewarded()) {
            this.animateAddColor(DyeColor.func_196056_a(this.field_70146_Z.nextInt(16)), 5);
        }
    }
    
    public boolean tryAccept(final ItemStack stack) {
        if (stack.func_77973_b().func_206844_a((ITag)ItemTags.field_199904_a)) {
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
        final List<Item> wools = (List<Item>)ImmutableList.of((Object)Blocks.field_196556_aL.func_199767_j(), (Object)Blocks.field_196557_aM.func_199767_j(), (Object)Blocks.field_196558_aN.func_199767_j(), (Object)Blocks.field_196559_aO.func_199767_j(), (Object)Blocks.field_196560_aP.func_199767_j(), (Object)Blocks.field_196561_aQ.func_199767_j(), (Object)Blocks.field_196562_aR.func_199767_j(), (Object)Blocks.field_196563_aS.func_199767_j(), (Object)Blocks.field_196564_aT.func_199767_j(), (Object)Blocks.field_196565_aU.func_199767_j(), (Object)Blocks.field_196566_aV.func_199767_j(), (Object)Blocks.field_196567_aW.func_199767_j(), (Object[])new Item[] { Blocks.field_196568_aX.func_199767_j(), Blocks.field_196569_aY.func_199767_j(), Blocks.field_196570_aZ.func_199767_j(), Blocks.field_196602_ba.func_199767_j() });
        final int i = wools.indexOf(stack.func_77973_b());
        if (i < 0) {
            return null;
        }
        return DyeColor.func_196056_a(i);
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74768_a("ColorFlags", this.getColorFlags());
        compound.func_74757_a("Rewarded", this.getRewarded());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setColorFlags(compound.func_74762_e("ColorFlags"));
        this.setRewarded(compound.func_74767_n("Rewarded"));
    }
    
    private int getColorFlags() {
        return (int)this.field_70180_af.func_187225_a((DataParameter)QuestRamEntity.DATA_COLOR);
    }
    
    private void setColorFlags(final int flags) {
        this.field_70180_af.func_187227_b((DataParameter)QuestRamEntity.DATA_COLOR, (Object)flags);
    }
    
    public boolean isColorPresent(final DyeColor color) {
        return (this.getColorFlags() & 1 << color.func_196059_a()) > 0;
    }
    
    public void setColorPresent(final DyeColor color) {
        this.setColorFlags(this.getColorFlags() | 1 << color.func_196059_a());
    }
    
    public boolean getRewarded() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)QuestRamEntity.DATA_REWARDED);
    }
    
    public void setRewarded(final boolean rewarded) {
        this.field_70180_af.func_187227_b((DataParameter)QuestRamEntity.DATA_REWARDED, (Object)rewarded);
    }
    
    private void animateAddColor(final DyeColor color, final int iterations) {
        final float[] colorVal = color.func_193349_f();
        final float red = colorVal[0];
        final float green = colorVal[1];
        final float blue = colorVal[2];
        for (int i = 0; i < iterations; ++i) {
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197625_r, this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 1.5, this.func_226278_cu_() + this.field_70146_Z.nextDouble() * this.func_213302_cg() * 1.5, this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 1.5, (double)red, (double)green, (double)blue);
        }
        this.func_70642_aH();
    }
    
    public int countColorsSet() {
        return Integer.bitCount(this.getColorFlags());
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    protected float func_70599_aP() {
        return 1.0f;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.QUEST_RAM_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.QUEST_RAM_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.QUEST_RAM_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.QUEST_RAM_STEP, 0.15f, 1.0f);
    }
    
    static {
        DATA_COLOR = EntityDataManager.func_187226_a((Class)QuestRamEntity.class, DataSerializers.field_187192_b);
        DATA_REWARDED = EntityDataManager.func_187226_a((Class)QuestRamEntity.class, DataSerializers.field_187198_h);
    }
}
