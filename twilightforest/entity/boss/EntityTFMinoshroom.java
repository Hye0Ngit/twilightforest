// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.EnumDifficulty;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.DifficultyInstance;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFGroundAttack;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFMinotaur;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> GROUND_ATTACK;
    private static final DataParameter<Integer> GROUND_CHARGE;
    private float prevClientSideChargeAnimation;
    private float clientSideChargeAnimation;
    private boolean groundSmashState;
    
    public EntityTFMinoshroom(final World world) {
        super(world);
        this.groundSmashState = false;
        this.func_70105_a(1.49f, 2.9f);
        this.field_70728_aV = 100;
        this.func_184642_a(EntityEquipmentSlot.MAINHAND, 1.1f);
    }
    
    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFGroundAttack(this));
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFMinoshroom.GROUND_ATTACK, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFMinoshroom.GROUND_CHARGE, (Object)0);
    }
    
    public boolean isGroundAttackCharge() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFMinoshroom.GROUND_ATTACK);
    }
    
    public void setGroundAttackCharge(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFMinoshroom.GROUND_ATTACK, (Object)flag);
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(120.0);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.prevClientSideChargeAnimation = this.clientSideChargeAnimation;
            if (this.isGroundAttackCharge()) {
                this.clientSideChargeAnimation = MathHelper.func_76131_a(this.clientSideChargeAnimation + 1.0f / (int)this.field_70180_af.func_187225_a((DataParameter)EntityTFMinoshroom.GROUND_CHARGE) * 6.0f, 0.0f, 6.0f);
                this.groundSmashState = true;
            }
            else {
                this.clientSideChargeAnimation = MathHelper.func_76131_a(this.clientSideChargeAnimation - 1.0f, 0.0f, 6.0f);
                if (this.groundSmashState) {
                    final IBlockState block = this.field_70170_p.func_180495_p(this.func_180425_c().func_177977_b());
                    final int stateId = Block.func_176210_f(block);
                    for (int i = 0; i < 80; ++i) {
                        final double cx = this.func_180425_c().func_177958_n() + this.field_70170_p.field_73012_v.nextFloat() * 10.0f - 5.0f;
                        final double cy = this.func_174813_aQ().field_72338_b + 0.10000000149011612 + this.field_70170_p.field_73012_v.nextFloat() * 0.3f;
                        final double cz = this.func_180425_c().func_177952_p() + this.field_70170_p.field_73012_v.nextFloat() * 10.0f - 5.0f;
                        this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, cx, cy, cz, 0.0, 0.0, 0.0, new int[] { stateId });
                    }
                    this.groundSmashState = false;
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public float getChargeAnimationScale(final float p_189795_1_) {
        return (this.prevClientSideChargeAnimation + (this.clientSideChargeAnimation - this.prevClientSideChargeAnimation) * p_189795_1_) / 6.0f;
    }
    
    public void setMaxCharge(final int charge) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFMinoshroom.GROUND_CHARGE, (Object)charge);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance difficulty) {
        super.func_180481_a(difficulty);
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.minotaur_axe));
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFWorld.markStructureConquered(this.field_70170_p, new BlockPos((Entity)this), TFFeature.LABYRINTH);
        }
    }
    
    @Override
    public ResourceLocation func_184647_J() {
        return EntityTFMinoshroom.LOOT_TABLE;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            if (this.func_110175_bO()) {
                this.field_70170_p.func_175656_a(this.func_180486_cf(), TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.MINOSHROOM));
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/minoshroom");
        GROUND_ATTACK = EntityDataManager.func_187226_a((Class)EntityTFMinoshroom.class, DataSerializers.field_187198_h);
        GROUND_CHARGE = EntityDataManager.func_187226_a((Class)EntityTFMinoshroom.class, DataSerializers.field_187192_b);
    }
}
