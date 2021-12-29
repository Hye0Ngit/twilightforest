// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.item.EnumDyeColor;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockColored;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFIceExploder extends EntityTFIceMob
{
    public static final ResourceLocation LOOT_TABLE;
    private static final float EXPLOSION_RADIUS = 1.0f;
    
    public EntityTFIceExploder(final World world) {
        super(world);
        this.func_70105_a(0.8f, 1.8f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFIceExploder.LOOT_TABLE;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_DEATH;
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.6f;
    }
    
    protected void func_70609_aI() {
        ++this.field_70725_aQ;
        if (this.field_70725_aQ == 60) {
            if (!this.field_70170_p.field_72995_K) {
                final boolean mobGriefing = ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this);
                this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0f, mobGriefing);
                if (mobGriefing) {
                    this.transformBlocks();
                }
            }
            this.field_70725_aQ = 19;
            super.func_70609_aI();
            this.field_70725_aQ = 60;
        }
    }
    
    private void transformBlocks() {
        final int range = 4;
        final BlockPos pos = new BlockPos((Entity)this);
        for (int dx = -range; dx <= range; ++dx) {
            for (int dy = -range; dy <= range; ++dy) {
                for (int dz = -range; dz <= range; ++dz) {
                    final double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                    final float randRange = range + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 2.0f;
                    if (distance < randRange) {
                        this.transformBlock(pos.func_177982_a(dx, dy, dz));
                    }
                }
            }
        }
    }
    
    private void transformBlock(final BlockPos pos) {
        final IBlockState state = this.field_70170_p.func_180495_p(pos);
        final Block block = state.func_177230_c();
        if (block.func_149638_a((Entity)this) < 8.0f && state.func_185887_b(this.field_70170_p, pos) >= 0.0f) {
            final int blockColor = state.func_185909_g((IBlockAccess)this.field_70170_p, pos).field_76291_p;
            if (this.shouldTransformGlass(state, pos)) {
                this.field_70170_p.func_175656_a(pos, Blocks.field_150399_cn.func_176223_P().func_177226_a((IProperty)BlockStainedGlass.field_176547_a, (Comparable)this.getClosestDyeColor(blockColor)));
            }
            else if (this.shouldTransformClay(state, pos)) {
                this.field_70170_p.func_175656_a(pos, Blocks.field_150406_ce.func_176223_P().func_177226_a((IProperty)BlockColored.field_176581_a, (Comparable)this.getClosestDyeColor(blockColor)));
            }
        }
    }
    
    private boolean shouldTransformClay(final IBlockState state, final BlockPos pos) {
        return state.func_177230_c().isNormalCube(state, (IBlockAccess)this.field_70170_p, pos);
    }
    
    private boolean shouldTransformGlass(final IBlockState state, final BlockPos pos) {
        return state.func_177230_c() != Blocks.field_150350_a && this.isBlockNormalBounds(state, pos) && (!state.func_185904_a().func_76218_k() || state.func_177230_c().isLeaves(state, (IBlockAccess)this.field_70170_p, pos) || state.func_177230_c() == Blocks.field_150432_aD || state.func_177230_c() == TFBlocks.aurora_block);
    }
    
    private boolean isBlockNormalBounds(final IBlockState state, final BlockPos pos) {
        return Block.field_185505_j.equals((Object)state.func_185900_c((IBlockAccess)this.field_70170_p, pos));
    }
    
    private EnumDyeColor getClosestDyeColor(final int blockColor) {
        final int red = blockColor >> 16 & 0xFF;
        final int green = blockColor >> 8 & 0xFF;
        final int blue = blockColor & 0xFF;
        EnumDyeColor bestColor = EnumDyeColor.WHITE;
        int bestDifference = 1024;
        for (final EnumDyeColor color : EnumDyeColor.values()) {
            final float[] iColor = color.func_193349_f();
            final int iRed = (int)(iColor[0] * 255.0f);
            final int iGreen = (int)(iColor[1] * 255.0f);
            final int iBlue = (int)(iColor[2] * 255.0f);
            final int difference = Math.abs(red - iRed) + Math.abs(green - iGreen) + Math.abs(blue - iBlue);
            if (difference < bestDifference) {
                bestColor = color;
                bestDifference = difference;
            }
        }
        return bestColor;
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/ice_exploder");
    }
}
