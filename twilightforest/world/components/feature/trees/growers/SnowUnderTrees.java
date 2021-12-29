// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class SnowUnderTrees extends Feature<NoneFeatureConfiguration>
{
    public SnowUnderTrees(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final BlockPos pos = ctx.m_159777_();
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos.MutableBlockPos mPos = new BlockPos.MutableBlockPos();
        final BlockPos.MutableBlockPos mPosDown = new BlockPos.MutableBlockPos();
        for (int xi = 0; xi < 16; ++xi) {
            for (int zi = 0; zi < 16; ++zi) {
                final int x = pos.m_123341_() + xi;
                final int z = pos.m_123343_() + zi;
                mPos.m_122178_(x, world.m_6924_(Heightmap.Types.MOTION_BLOCKING, x, z) - 1, z);
                if (world.m_8055_((BlockPos)mPos).m_60734_() instanceof LeavesBlock) {
                    mPos.m_122178_(x, world.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
                    final BlockState state = world.m_8055_((BlockPos)mPos);
                    if (state.m_60795_()) {
                        mPosDown.m_122190_((Vec3i)mPos).m_122173_(Direction.DOWN);
                        final BlockState stateBelow = world.m_8055_((BlockPos)mPosDown);
                        if (stateBelow.m_60783_((BlockGetter)world, (BlockPos)mPosDown, Direction.UP)) {
                            world.m_7731_((BlockPos)mPos, Blocks.f_50125_.m_49966_(), 2);
                            if (stateBelow.m_61138_((Property)SnowyDirtBlock.f_56637_)) {
                                world.m_7731_((BlockPos)mPosDown, (BlockState)stateBelow.m_61124_((Property)SnowyDirtBlock.f_56637_, (Comparable)true), 2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
