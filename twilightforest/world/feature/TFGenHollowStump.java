// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.IWorld;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import com.mojang.serialization.Codec;

public class TFGenHollowStump extends TFGenHollowTree
{
    public TFGenHollowStump(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    public boolean generate(final IWorld world, final Random rand, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final Set<BlockPos> branch, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int radius = rand.nextInt(2) + 2;
        if (!FeatureUtil.isAreaSuitable(world, pos.func_177982_a(-radius, 0, -radius), 2 * radius, 6, 2 * radius)) {
            return false;
        }
        this.buildTrunk(world, rand, pos, trunk, branch, root, radius, 6, mbb, config);
        this.buildBranchRing(world, rand, pos, leaves, branch, radius, 3, 2, 6, 0.75, 3, 5, 3, false, mbb, config);
        this.buildBranchRing(world, rand, pos, leaves, branch, radius, 1, 2, 8, 0.9, 3, 5, 3, false, mbb, config);
        return true;
    }
    
    @Override
    protected void buildTrunk(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> branch, final Set<BlockPos> root, final int diameter, final int maxHeight, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int hollow = diameter / 2;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        final BlockPos dPos = pos.func_177982_a(dx, dy, dz);
                        if (FeatureUtil.hasAirAround(world, dPos)) {
                            if (dist > hollow) {
                                this.setLogBlockState(world, random, dPos, trunk, mbb, config);
                            }
                            else {
                                this.setLogBlockState(world, random, dPos, branch, mbb, config);
                            }
                        }
                        else {
                            this.setRootsBlockState(world, random, dPos, root, mbb, config);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int height = 2 + random.nextInt(3) + random.nextInt(2), dy2 = 0; dy2 <= height; ++dy2) {
                    final int ax2 = Math.abs(dx);
                    final int az2 = Math.abs(dz);
                    final int dist2 = (int)(Math.max(ax2, az2) + Math.min(ax2, az2) * 0.5);
                    if (dist2 <= diameter && dist2 > hollow) {
                        this.setLogBlockState(world, random, pos.func_177982_a(dx, dy2, dz), trunk, mbb, config);
                    }
                }
            }
        }
    }
}
