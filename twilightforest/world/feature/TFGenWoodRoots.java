// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.RootVariant;
import twilightforest.block.BlockTFRoots;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;

public class TFGenWoodRoots extends TFGenerator
{
    private IBlockState rootBlock;
    private IBlockState oreBlock;
    
    public TFGenWoodRoots() {
        this.rootBlock = TFBlocks.root.func_176223_P();
        this.oreBlock = TFBlocks.root.func_176223_P().func_177226_a((IProperty)BlockTFRoots.VARIANT, (Comparable)RootVariant.LIVEROOT);
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        if (world.func_180495_p(pos).func_177230_c() != Blocks.field_150348_b) {
            return false;
        }
        float length = rand.nextFloat() * 6.0f + rand.nextFloat() * 6.0f + 4.0f;
        if (length > pos.func_177956_o()) {
            length = (float)pos.func_177956_o();
        }
        final float tilt = 0.6f + rand.nextFloat() * 0.3f;
        return this.drawRoot(world, rand, pos, length, rand.nextFloat(), tilt);
    }
    
    private boolean drawRoot(final World world, final Random rand, final BlockPos pos, final float length, final float angle, final float tilt) {
        return this.drawRoot(world, rand, pos, pos, length, angle, tilt);
    }
    
    private boolean drawRoot(final World world, final Random rand, final BlockPos oPos, final BlockPos pos, final float length, final float angle, final float tilt) {
        BlockPos dest = TFGenerator.translate(pos, length, angle, tilt);
        final int limit = 6;
        if (oPos.func_177958_n() + limit < dest.func_177958_n()) {
            dest = new BlockPos(oPos.func_177958_n() + limit, dest.func_177956_o(), dest.func_177952_p());
        }
        if (oPos.func_177958_n() - limit > dest.func_177958_n()) {
            dest = new BlockPos(oPos.func_177958_n() - limit, dest.func_177956_o(), dest.func_177952_p());
        }
        if (oPos.func_177952_p() + limit < dest.func_177952_p()) {
            dest = new BlockPos(dest.func_177958_n(), dest.func_177956_o(), oPos.func_177952_p() + limit);
        }
        if (oPos.func_177952_p() - limit > dest.func_177952_p()) {
            dest = new BlockPos(dest.func_177958_n(), dest.func_177956_o(), oPos.func_177952_p() - limit);
        }
        if (world.func_180495_p(dest).func_177230_c() != Blocks.field_150348_b) {
            return false;
        }
        final BlockPos[] bresehnamArrays;
        final BlockPos[] lineArray = bresehnamArrays = TFGenerator.getBresehnamArrays(pos, dest);
        for (final BlockPos coord : bresehnamArrays) {
            this.placeRootBlock(world, coord, this.rootBlock);
        }
        if (length > 8.0f && rand.nextInt(3) > 0) {
            final BlockPos nextSrc = TFGenerator.translate(pos, length / 2.0f, angle, tilt);
            final float nextAngle = (angle + 0.25f + rand.nextFloat() * 0.5f) % 1.0f;
            final float nextTilt = 0.6f + rand.nextFloat() * 0.3f;
            this.drawRoot(world, rand, oPos, nextSrc, length / 2.0f, nextAngle, nextTilt);
        }
        if (length > 6.0f && rand.nextInt(4) == 0) {
            final BlockPos ballSrc = TFGenerator.translate(pos, length / 2.0f, angle, tilt);
            final BlockPos ballDest = TFGenerator.translate(ballSrc, 1.5, (angle + 0.5f) % 1.0f, 0.75);
            this.placeRootBlock(world, ballSrc, this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.func_177958_n(), ballSrc.func_177956_o(), ballDest.func_177952_p()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballDest.func_177958_n(), ballSrc.func_177956_o(), ballSrc.func_177952_p()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.func_177958_n(), ballSrc.func_177956_o(), ballDest.func_177952_p()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.func_177958_n(), ballDest.func_177956_o(), ballSrc.func_177952_p()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.func_177958_n(), ballDest.func_177956_o(), ballDest.func_177952_p()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballDest.func_177958_n(), ballDest.func_177956_o(), ballSrc.func_177952_p()), this.oreBlock);
            this.placeRootBlock(world, ballDest, this.oreBlock);
        }
        return true;
    }
    
    protected void placeRootBlock(final World world, final BlockPos pos, final IBlockState state) {
        if (TFTreeGenerator.canRootGrowIn(world, pos)) {
            this.func_175903_a(world, pos, state);
        }
    }
}
