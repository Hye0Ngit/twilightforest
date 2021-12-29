// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.world.level.LevelSimulatedReader;
import java.util.Iterator;
import twilightforest.util.VoxelBresenhamIterator;
import twilightforest.util.FeatureLogic;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenWoodRoots extends Feature<NoneFeatureConfiguration>
{
    private final BlockState rootBlock;
    private final BlockState oreBlock;
    
    public TFGenWoodRoots(final Codec<NoneFeatureConfiguration> configIn) {
        super((Codec)configIn);
        this.rootBlock = ((Block)TFBlocks.ROOT_BLOCK.get()).m_49966_();
        this.oreBlock = ((Block)TFBlocks.LIVEROOT_BLOCK.get()).m_49966_();
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        if (world.m_8055_(pos).m_60734_() != Blocks.f_50069_) {
            return false;
        }
        float length = rand.nextFloat() * 6.0f + rand.nextFloat() * 6.0f + 4.0f;
        if (length > pos.m_123342_()) {
            length = (float)pos.m_123342_();
        }
        final float tilt = 0.6f + rand.nextFloat() * 0.3f;
        return this.drawRoot((LevelAccessor)world, rand, pos, length, rand.nextFloat(), tilt);
    }
    
    private boolean drawRoot(final LevelAccessor world, final Random rand, final BlockPos pos, final float length, final float angle, final float tilt) {
        return this.drawRoot(world, rand, pos, pos, length, angle, tilt);
    }
    
    private boolean drawRoot(final LevelAccessor world, final Random rand, final BlockPos oPos, final BlockPos pos, final float length, final float angle, final float tilt) {
        BlockPos dest = FeatureLogic.translate(pos, length, angle, tilt);
        final int limit = 6;
        if (oPos.m_123341_() + limit < dest.m_123341_()) {
            dest = new BlockPos(oPos.m_123341_() + limit, dest.m_123342_(), dest.m_123343_());
        }
        if (oPos.m_123341_() - limit > dest.m_123341_()) {
            dest = new BlockPos(oPos.m_123341_() - limit, dest.m_123342_(), dest.m_123343_());
        }
        if (oPos.m_123343_() + limit < dest.m_123343_()) {
            dest = new BlockPos(dest.m_123341_(), dest.m_123342_(), oPos.m_123343_() + limit);
        }
        if (oPos.m_123343_() - limit > dest.m_123343_()) {
            dest = new BlockPos(dest.m_123341_(), dest.m_123342_(), oPos.m_123343_() - limit);
        }
        if (world.m_8055_(dest).m_60734_() != Blocks.f_50069_) {
            return false;
        }
        for (final BlockPos coord : new VoxelBresenhamIterator(pos, dest)) {
            this.placeRootBlock(world, coord, this.rootBlock);
        }
        if (length > 8.0f && rand.nextInt(3) > 0) {
            final BlockPos nextSrc = FeatureLogic.translate(pos, length / 2.0f, angle, tilt);
            final float nextAngle = (angle + 0.25f + rand.nextFloat() * 0.5f) % 1.0f;
            final float nextTilt = 0.6f + rand.nextFloat() * 0.3f;
            this.drawRoot(world, rand, oPos, nextSrc, length / 2.0f, nextAngle, nextTilt);
        }
        if (length > 6.0f && rand.nextInt(4) == 0) {
            final BlockPos ballSrc = FeatureLogic.translate(pos, length / 2.0f, angle, tilt);
            final BlockPos ballDest = FeatureLogic.translate(ballSrc, 1.5, (angle + 0.5f) % 1.0f, 0.75);
            this.placeRootBlock(world, ballSrc, this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.m_123341_(), ballSrc.m_123342_(), ballDest.m_123343_()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballDest.m_123341_(), ballSrc.m_123342_(), ballSrc.m_123343_()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.m_123341_(), ballSrc.m_123342_(), ballDest.m_123343_()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.m_123341_(), ballDest.m_123342_(), ballSrc.m_123343_()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballSrc.m_123341_(), ballDest.m_123342_(), ballDest.m_123343_()), this.oreBlock);
            this.placeRootBlock(world, new BlockPos(ballDest.m_123341_(), ballDest.m_123342_(), ballSrc.m_123343_()), this.oreBlock);
            this.placeRootBlock(world, ballDest, this.oreBlock);
        }
        return true;
    }
    
    protected void placeRootBlock(final LevelAccessor world, final BlockPos pos, final BlockState state) {
        if (FeatureLogic.canRootGrowIn((LevelSimulatedReader)world, pos)) {
            world.m_7731_(pos, state, 3);
        }
    }
}
