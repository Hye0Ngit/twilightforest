// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySlime;

public class EntityTFMazeSlime extends EntitySlime
{
    public static final ResourceLocation LOOT_TABLE;
    private static final AttributeModifier DOUBLE_HEALTH;
    
    public EntityTFMazeSlime(final World world) {
        super(world);
    }
    
    protected EntitySlime func_70802_j() {
        return new EntityTFMazeSlime(this.field_70170_p);
    }
    
    public void func_70799_a(final int size, final boolean resetHealth) {
        super.func_70799_a(size, resetHealth);
        this.field_70728_aV += 3;
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL && this.field_70170_p.func_72855_b(this.func_174813_aQ()) && this.field_70170_p.func_184144_a((Entity)this, this.func_174813_aQ()).isEmpty() && !this.field_70170_p.func_72953_d(this.func_174813_aQ()) && this.isValidLightLevel();
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(EntityTFMazeSlime.DOUBLE_HEALTH);
    }
    
    protected boolean func_70800_m() {
        return true;
    }
    
    protected int func_70805_n() {
        return super.func_70805_n() + 3;
    }
    
    protected boolean spawnCustomParticles() {
        for (int i = this.func_70809_q(), j = 0; j < i * 8; ++j) {
            final float f = this.field_70146_Z.nextFloat() * 6.2831855f;
            final float f2 = this.field_70146_Z.nextFloat() * 0.5f + 0.5f;
            final float f3 = MathHelper.func_76126_a(f) * i * 0.5f * f2;
            final float f4 = MathHelper.func_76134_b(f) * i * 0.5f * f2;
            final World world = this.field_70170_p;
            final double d0 = this.field_70165_t + f3;
            final double d2 = this.field_70161_v + f4;
            final IBlockState state = TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK);
            world.func_175688_a(EnumParticleTypes.BLOCK_CRACK, d0, this.func_174813_aQ().field_72338_b, d2, 0.0, 0.0, 0.0, new int[] { Block.func_176210_f(state) });
        }
        return true;
    }
    
    private boolean isValidLightLevel() {
        final BlockPos blockpos = new BlockPos(this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v);
        if (this.field_70170_p.func_175642_b(EnumSkyBlock.SKY, blockpos) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int i = this.field_70170_p.func_175671_l(blockpos);
        if (this.field_70170_p.func_72911_I()) {
            final int j = this.field_70170_p.func_175657_ab();
            this.field_70170_p.func_175692_b(10);
            i = this.field_70170_p.func_175671_l(blockpos);
            this.field_70170_p.func_175692_b(j);
        }
        return i <= this.field_70146_Z.nextInt(8);
    }
    
    protected float func_70599_aP() {
        return 0.1f * this.func_70809_q();
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFMazeSlime.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/maze_slime");
        DOUBLE_HEALTH = new AttributeModifier("Maze slime double health", 1.0, 1).func_111168_a(false);
    }
}
