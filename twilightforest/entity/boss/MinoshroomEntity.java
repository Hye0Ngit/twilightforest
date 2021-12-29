// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.DifficultyInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.block.BlockState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.ai.GroundAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.MinotaurEntity;

public class MinoshroomEntity extends MinotaurEntity
{
    private static final DataParameter<Boolean> GROUND_ATTACK;
    private static final DataParameter<Integer> GROUND_CHARGE;
    private float prevClientSideChargeAnimation;
    private float clientSideChargeAnimation;
    private boolean groundSmashState;
    
    public MinoshroomEntity(final EntityType<? extends MinoshroomEntity> type, final World world) {
        super(type, world);
        this.groundSmashState = false;
        this.field_70728_aV = 100;
        this.func_184642_a(EquipmentSlotType.MAINHAND, 1.1f);
    }
    
    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(1, (Goal)new GroundAttackGoal(this));
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)MinoshroomEntity.GROUND_ATTACK, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)MinoshroomEntity.GROUND_CHARGE, (Object)0);
    }
    
    public boolean isGroundAttackCharge() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)MinoshroomEntity.GROUND_ATTACK);
    }
    
    public void setGroundAttackCharge(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)MinoshroomEntity.GROUND_ATTACK, (Object)flag);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MinotaurEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 120.0);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.prevClientSideChargeAnimation = this.clientSideChargeAnimation;
            if (this.isGroundAttackCharge()) {
                this.clientSideChargeAnimation = MathHelper.func_76131_a(this.clientSideChargeAnimation + 1.0f / (int)this.field_70180_af.func_187225_a((DataParameter)MinoshroomEntity.GROUND_CHARGE) * 6.0f, 0.0f, 6.0f);
                this.groundSmashState = true;
            }
            else {
                this.clientSideChargeAnimation = MathHelper.func_76131_a(this.clientSideChargeAnimation - 1.0f, 0.0f, 6.0f);
                if (this.groundSmashState) {
                    final BlockState block = this.field_70170_p.func_180495_p(this.func_233580_cy_().func_177977_b());
                    for (int i = 0; i < 80; ++i) {
                        final double cx = this.func_233580_cy_().func_177958_n() + this.field_70170_p.field_73012_v.nextFloat() * 10.0f - 5.0f;
                        final double cy = this.func_174813_aQ().field_72338_b + 0.10000000149011612 + this.field_70170_p.field_73012_v.nextFloat() * 0.3f;
                        final double cz = this.func_233580_cy_().func_177952_p() + this.field_70170_p.field_73012_v.nextFloat() * 10.0f - 5.0f;
                        this.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, block), cx, cy, cz, 0.0, 0.0, 0.0);
                    }
                    this.groundSmashState = false;
                }
            }
        }
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.MINOSHROOM_AMBIENT;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.MINOSHROOM_HURT;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.MINOSHROOM_DEATH;
    }
    
    @Override
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.MINOSHROOM_STEP, 0.15f, 0.8f);
    }
    
    @Override
    public boolean func_70652_k(final Entity entity) {
        final boolean success = super.func_70652_k(entity);
        if (success && this.isCharging()) {
            entity.func_70024_g(0.0, 0.4, 0.0);
            this.func_184185_a(TFSounds.MINOSHROOM_ATTACK, 1.0f, 1.0f);
        }
        return success;
    }
    
    @OnlyIn(Dist.CLIENT)
    public float getChargeAnimationScale(final float p_189795_1_) {
        return (this.prevClientSideChargeAnimation + (this.clientSideChargeAnimation - this.prevClientSideChargeAnimation) * p_189795_1_) / 6.0f;
    }
    
    public void setMaxCharge(final int charge) {
        this.field_70180_af.func_187227_b((DataParameter)MinoshroomEntity.GROUND_CHARGE, (Object)charge);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance difficulty) {
        super.func_180481_a(difficulty);
        this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.minotaur_axe.get()));
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFGenerationSettings.markStructureConquered(this.field_70170_p, new BlockPos((Vector3i)this.func_233580_cy_()), TFFeature.LABYRINTH);
        }
    }
    
    public boolean func_213397_c(final double distance) {
        return false;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (this.func_213394_dL()) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_minoshroom.get()).func_176223_P());
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        GROUND_ATTACK = EntityDataManager.func_187226_a((Class)MinoshroomEntity.class, DataSerializers.field_187198_h);
        GROUND_CHARGE = EntityDataManager.func_187226_a((Class)MinoshroomEntity.class, DataSerializers.field_187192_b);
    }
}
