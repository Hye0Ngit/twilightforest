// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import twilightforest.block.BlockTFNagastoneStairs;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.BlockDoubleStoneSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;
import twilightforest.structures.RandomizedTemplateProcessor;

public class CourtyardTerraceTemplateProcessor extends RandomizedTemplateProcessor
{
    public CourtyardTerraceTemplateProcessor(final BlockPos pos, final PlacementSettings settings) {
        super(pos, settings);
    }
    
    @Nullable
    public Template.BlockInfo func_189943_a(final World world, final BlockPos pos, final Template.BlockInfo blockInfo) {
        if (!this.shouldPlaceBlock()) {
            return null;
        }
        boolean shouldMakeNewBlockInfo = false;
        IBlockState state = blockInfo.field_186243_b;
        final IBlockState SMOOTHBRICK_SLAB_STATE = Blocks.field_150333_U.func_176223_P().func_177226_a((IProperty)BlockStoneSlab.field_176556_M, (Comparable)BlockStoneSlab.EnumType.SMOOTHBRICK);
        final IBlockState SMOOTHBRICK_STATE = Blocks.field_150417_aV.func_176223_P();
        if (state.func_177230_c() == Blocks.field_150334_T && state.func_177229_b((IProperty)BlockDoubleStoneSlab.field_176556_M) == BlockStoneSlab.EnumType.SAND) {
            final IBlockState stateCheck = world.func_180495_p(pos);
            if (stateCheck == SMOOTHBRICK_SLAB_STATE) {
                return new Template.BlockInfo(pos, SMOOTHBRICK_SLAB_STATE, (NBTTagCompound)null);
            }
            if (stateCheck.func_185904_a() == Material.field_151579_a) {
                return null;
            }
            state = SMOOTHBRICK_STATE;
            shouldMakeNewBlockInfo = true;
        }
        if (state.func_177230_c() == Blocks.field_150333_U && state.func_177229_b((IProperty)BlockStoneSlab.field_176556_M) == BlockStoneSlab.EnumType.SAND) {
            final IBlockState stateCheck = world.func_180495_p(pos);
            if (stateCheck.func_185904_a() == Material.field_151579_a) {
                return null;
            }
            return new Template.BlockInfo(pos, SMOOTHBRICK_SLAB_STATE, (NBTTagCompound)null);
        }
        else {
            final Block block = state.func_177230_c();
            if (block == Blocks.field_150417_aV && state != Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.CHISELED)) {
                return this.random.nextBoolean() ? (shouldMakeNewBlockInfo ? new Template.BlockInfo(blockInfo.field_186242_a, state, blockInfo.field_186244_c) : blockInfo) : new Template.BlockInfo(pos, state.func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.values()[this.random.nextInt(3)]), (NBTTagCompound)null);
            }
            if (state == Blocks.field_150333_U.func_176223_P().func_177226_a((IProperty)BlockStoneSlab.field_176556_M, (Comparable)BlockStoneSlab.EnumType.STONE)) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, state.func_177226_a((IProperty)BlockStoneSlab.field_176556_M, (Comparable)BlockStoneSlab.EnumType.COBBLESTONE), (NBTTagCompound)null);
            }
            if (block == TFBlocks.etched_nagastone) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, RandomizedTemplateProcessor.translateState(state, this.randomBlock(TFBlocks.etched_nagastone_mossy, TFBlocks.etched_nagastone_weathered), (net.minecraft.block.properties.IProperty<Comparable>)BlockDirectional.field_176387_N), (NBTTagCompound)null);
            }
            if (block == TFBlocks.nagastone_pillar) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, RandomizedTemplateProcessor.translateState(state, this.randomBlock(TFBlocks.nagastone_pillar_mossy, TFBlocks.nagastone_pillar_weathered), (net.minecraft.block.properties.IProperty<Comparable>)BlockRotatedPillar.field_176298_M), (NBTTagCompound)null);
            }
            if (block == TFBlocks.nagastone_stairs) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, RandomizedTemplateProcessor.translateState(state, this.randomBlock(TFBlocks.nagastone_stairs, TFBlocks.nagastone_stairs), BlockTFNagastoneStairs.DIRECTION, (IProperty)BlockTFNagastoneStairs.field_176309_a, (IProperty)BlockTFNagastoneStairs.field_176308_b, (IProperty)BlockTFNagastoneStairs.field_176310_M), (NBTTagCompound)null);
            }
            return blockInfo;
        }
    }
}
