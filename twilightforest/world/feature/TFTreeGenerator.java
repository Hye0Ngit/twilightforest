// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.enums.HedgeVariant;
import twilightforest.block.BlockTFHedge;
import twilightforest.enums.WoodVariant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.IPlantable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class TFTreeGenerator extends WorldGenAbstractTree implements IBlockSettable
{
    protected IBlockState treeState;
    protected IBlockState branchState;
    protected IBlockState leafState;
    protected IBlockState rootState;
    protected IPlantable source;
    
    public TFTreeGenerator() {
        this(false);
    }
    
    public TFTreeGenerator(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.twilight_log.func_176223_P();
        this.branchState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE).func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
        this.leafState = TFBlocks.hedge.func_176223_P().func_177226_a((IProperty)BlockTFHedge.VARIANT, (Comparable)HedgeVariant.DARKWOOD_LEAVES);
        this.rootState = TFBlocks.root.func_176223_P();
        this.source = (IPlantable)TFBlocks.twilight_sapling;
    }
    
    public final void setBlockAndNotify(final World world, final BlockPos pos, final IBlockState state) {
        this.func_175903_a(world, pos, state);
    }
    
    protected boolean func_150523_a(final Block blockType) {
        return TFGenHollowTree.canGrowInto(blockType);
    }
    
    protected void buildRoot(final World world, final BlockPos pos, final double offset, final int b) {
        final BlockPos dest = TFGenerator.translate(pos.func_177979_c(b + 2), 5.0, 0.3 * b + offset, 0.8);
        final BlockPos[] bresehnamArrays;
        final BlockPos[] lineArray = bresehnamArrays = TFGenerator.getBresehnamArrays(pos.func_177977_b(), dest);
        for (final BlockPos coord : bresehnamArrays) {
            this.placeRootBlock(world, coord, this.rootState);
        }
    }
    
    protected void placeRootBlock(final World world, final BlockPos pos, final IBlockState state) {
        if (canRootGrowIn(world, pos)) {
            this.func_175903_a(world, pos, state);
        }
    }
    
    public static boolean canRootGrowIn(final World world, final BlockPos pos) {
        final IBlockState blockState = world.func_180495_p(pos);
        final Block blockID = blockState.func_177230_c();
        if (blockID.isAir(blockState, (IBlockAccess)world, pos)) {
            return TFGenerator.isNearSolid(world, pos);
        }
        return blockState.func_185887_b(world, pos) >= 0.0f && blockID != TFBlocks.stronghold_shield && blockID != TFBlocks.trophy_pedestal && blockID != TFBlocks.boss_spawner && (blockState.func_185904_a() == Material.field_151577_b || blockState.func_185904_a() == Material.field_151578_c || blockState.func_185904_a() == Material.field_151576_e);
    }
    
    protected void addFirefly(final World world, final BlockPos pos, final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.setIfEmpty(world, pos.func_177982_a(1, height, 0), TFBlocks.firefly.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.EAST));
        }
        else if (iAngle == 1) {
            this.setIfEmpty(world, pos.func_177982_a(-1, height, 0), TFBlocks.firefly.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.WEST));
        }
        else if (iAngle == 2) {
            this.setIfEmpty(world, pos.func_177982_a(0, height, 1), TFBlocks.firefly.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.SOUTH));
        }
        else if (iAngle == 3) {
            this.setIfEmpty(world, pos.func_177982_a(0, height, -1), TFBlocks.firefly.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.NORTH));
        }
    }
    
    private void setIfEmpty(final World world, final BlockPos pos, final IBlockState state) {
        if (world.func_175623_d(pos)) {
            this.func_175903_a(world, pos, state);
        }
    }
}
