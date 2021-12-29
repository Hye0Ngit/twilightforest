// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Iterator;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.WorldServer;
import net.minecraft.util.math.BlockPos;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import twilightforest.entity.ai.EntityAITFFindLoose;
import twilightforest.entity.ai.EntityAITFEatLoose;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityAnimal;

public class EntityTFQuestRam extends EntityAnimal
{
    public static final ResourceLocation LOOT_TABLE;
    public static final ResourceLocation REWARD_LOOT_TABLE;
    private static final DataParameter<Integer> DATA_COLOR;
    private static final DataParameter<Boolean> DATA_REWARDED;
    private int randomTickDivider;
    
    public EntityTFQuestRam(final World world) {
        super(world);
        this.func_70105_a(1.25f, 2.9f);
        this.randomTickDivider = 0;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.3799999952316284));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.0, Item.func_150898_a(Blocks.field_150325_L), false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFEatLoose(this, Item.func_150898_a(Blocks.field_150325_L)));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFFindLoose((EntityCreature)this, 1.0f, Item.func_150898_a(Blocks.field_150325_L)));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return null;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(70.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFQuestRam.DATA_COLOR, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFQuestRam.DATA_REWARDED, (Object)false);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFQuestRam.LOOT_TABLE;
    }
    
    protected void func_70619_bc() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.field_70146_Z.nextInt(50);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) / 16;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p);
            if (nearFeature != TFFeature.QUEST_GROVE) {
                this.func_110177_bN();
            }
            else {
                final BlockPos cc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v), this.field_70170_p);
                this.func_175449_a(cc, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.func_70619_bc();
    }
    
    private void rewardQuest() {
        final LootContext ctx = new LootContext.Builder((WorldServer)this.field_70170_p).func_186472_a((Entity)this).func_186471_a();
        for (final ItemStack s : this.field_70170_p.func_184146_ak().func_186521_a(EntityTFQuestRam.REWARD_LOOT_TABLE).func_186462_a(this.field_70170_p.field_73012_v, ctx)) {
            this.func_70099_a(s, 1.0f);
        }
        for (final EntityPlayerMP player : this.field_70170_p.func_72872_a((Class)EntityPlayerMP.class, this.func_174813_aQ().func_72314_b(16.0, 16.0, 16.0))) {
            TFAdvancements.QUEST_RAM_COMPLETED.trigger(player);
        }
    }
    
    public boolean func_184645_a(final EntityPlayer player, final EnumHand hand) {
        final ItemStack currentItem = player.func_184586_b(hand);
        if (!currentItem.func_190926_b() && currentItem.func_77973_b() == Item.func_150898_a(Blocks.field_150325_L) && !this.isColorPresent(EnumDyeColor.func_176764_b(currentItem.func_77952_i()))) {
            this.setColorPresent(EnumDyeColor.func_176764_b(currentItem.func_77952_i()));
            this.animateAddColor(EnumDyeColor.func_176764_b(currentItem.func_77952_i()), 50);
            if (!player.field_71075_bZ.field_75098_d) {
                currentItem.func_190918_g(1);
            }
            return true;
        }
        return super.func_184645_a(player, hand);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K && this.countColorsSet() > 15 && !this.getRewarded()) {
            this.animateAddColor(EnumDyeColor.func_176764_b(this.field_70146_Z.nextInt(16)), 5);
        }
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74768_a("ColorFlags", this.getColorFlags());
        compound.func_74757_a("Rewarded", this.getRewarded());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setColorFlags(compound.func_74762_e("ColorFlags"));
        this.setRewarded(compound.func_74767_n("Rewarded"));
    }
    
    public int getColorFlags() {
        return (int)this.field_70180_af.func_187225_a((DataParameter)EntityTFQuestRam.DATA_COLOR);
    }
    
    public void setColorFlags(final int flags) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFQuestRam.DATA_COLOR, (Object)flags);
    }
    
    public boolean isColorPresent(final EnumDyeColor color) {
        return (this.getColorFlags() & 1 << color.func_176765_a()) > 0;
    }
    
    public void setColorPresent(final EnumDyeColor color) {
        this.setColorFlags(this.getColorFlags() | 1 << color.func_176765_a());
    }
    
    public boolean getRewarded() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFQuestRam.DATA_REWARDED);
    }
    
    public void setRewarded(final boolean rewarded) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFQuestRam.DATA_REWARDED, (Object)rewarded);
    }
    
    public void animateAddColor(final EnumDyeColor color, final int iterations) {
        final float[] colorVal = color.func_193349_f();
        final int red = (int)(colorVal[0] * 255.0f);
        final int green = (int)(colorVal[1] * 255.0f);
        final int blue = (int)(colorVal[2] * 255.0f);
        for (int i = 0; i < iterations; ++i) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 1.5, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O * 1.5, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 1.5, (double)red, (double)green, (double)blue, new int[0]);
        }
        this.func_70642_aH();
    }
    
    public int countColorsSet() {
        return Integer.bitCount(this.getColorFlags());
    }
    
    protected float func_70599_aP() {
        return 5.0f;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187757_eG;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187761_eI;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187759_eH;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187765_eK, 0.15f, 1.0f);
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/quest_ram");
        REWARD_LOOT_TABLE = TwilightForestMod.prefix("entities/questing_ram_rewards");
        DATA_COLOR = EntityDataManager.func_187226_a((Class)EntityTFQuestRam.class, DataSerializers.field_187192_b);
        DATA_REWARDED = EntityDataManager.func_187226_a((Class)EntityTFQuestRam.class, DataSerializers.field_187198_h);
    }
}
