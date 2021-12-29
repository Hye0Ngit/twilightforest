// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFTowerGolem extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    private int attackTimer;
    
    public EntityTFTowerGolem(final World world) {
        super(world);
        this.func_70105_a(1.4f, 2.9f);
        this.func_184644_a(PathNodeType.WATER, -1.0f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0, 0.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(9.0);
        this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(2.0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        this.attackTimer = 10;
        this.field_70170_p.func_72960_a((Entity)this, (byte)4);
        final boolean attackSuccess = super.func_70652_k(entity);
        if (attackSuccess) {
            entity.field_70181_x += 0.4000000059604645;
        }
        return attackSuccess;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187602_cF;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187599_cE;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187605_cG, 1.0f, 1.0f);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7 && this.field_70146_Z.nextInt(5) == 0) {
            final int i = MathHelper.func_76128_c(this.field_70165_t);
            final int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224);
            final int k = MathHelper.func_76128_c(this.field_70161_v);
            final IBlockState iblockstate = this.field_70170_p.func_180495_p(new BlockPos(i, j, k));
            if (iblockstate.func_185904_a() != Material.field_151579_a) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, this.func_174813_aQ().field_72338_b + 0.1, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, 4.0 * (this.field_70146_Z.nextFloat() - 0.5), 0.5, (this.field_70146_Z.nextFloat() - 0.5) * 4.0, new int[] { Block.func_176210_f(iblockstate) });
            }
        }
        if (this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.REDSTONE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 4) {
            this.attackTimer = 10;
            this.func_184185_a(SoundEvents.field_187596_cD, 1.0f, 1.0f);
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFTowerGolem.LOOT_TABLE;
    }
    
    public int func_70641_bl() {
        return 16;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/tower_golem");
    }
}
