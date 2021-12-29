// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.IWorldReader;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.IWorld;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenWoodRoots extends Feature<NoFeatureConfig>
{
    private BlockState rootBlock;
    private BlockState oreBlock;
    
    public TFGenWoodRoots(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
        this.rootBlock = ((Block)TFBlocks.root.get()).func_176223_P();
        this.oreBlock = ((Block)TFBlocks.liveroot_block.get()).func_176223_P();
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        if (world.func_180495_p(pos).func_177230_c() != Blocks.field_150348_b) {
            return false;
        }
        float length = rand.nextFloat() * 6.0f + rand.nextFloat() * 6.0f + 4.0f;
        if (length > pos.func_177956_o()) {
            length = (float)pos.func_177956_o();
        }
        final float tilt = 0.6f + rand.nextFloat() * 0.3f;
        return this.drawRoot((IWorld)world, rand, pos, length, rand.nextFloat(), tilt);
    }
    
    private boolean drawRoot(final IWorld world, final Random rand, final BlockPos pos, final float length, final float angle, final float tilt) {
        return this.drawRoot(world, rand, pos, pos, length, angle, tilt);
    }
    
    private boolean drawRoot(final IWorld world, final Random rand, final BlockPos oPos, final BlockPos pos, final float length, final float angle, final float tilt) {
        BlockPos dest = FeatureUtil.translate(pos, length, angle, tilt);
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
        final BlockPos[] bresenhamArrays;
        final BlockPos[] lineArray = bresenhamArrays = FeatureUtil.getBresenhamArrays(pos, dest);
        for (final BlockPos coord : bresenhamArrays) {
            this.placeRootBlock(world, coord, this.rootBlock);
        }
        if (length > 8.0f && rand.nextInt(3) > 0) {
            final BlockPos nextSrc = FeatureUtil.translate(pos, length / 2.0f, angle, tilt);
            final float nextAngle = (angle + 0.25f + rand.nextFloat() * 0.5f) % 1.0f;
            final float nextTilt = 0.6f + rand.nextFloat() * 0.3f;
            this.drawRoot(world, rand, oPos, nextSrc, length / 2.0f, nextAngle, nextTilt);
        }
        if (length > 6.0f && rand.nextInt(4) == 0) {
            final BlockPos ballSrc = FeatureUtil.translate(pos, length / 2.0f, angle, tilt);
            final BlockPos ballDest = FeatureUtil.translate(ballSrc, 1.5, (angle + 0.5f) % 1.0f, 0.75);
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
    
    protected void placeRootBlock(final IWorld world, final BlockPos pos, final BlockState state) {
        if (TFTreeGenerator.canRootGrowIn((IWorldReader)world, pos)) {
            world.func_180501_a(pos, state, 3);
        }
    }
}
