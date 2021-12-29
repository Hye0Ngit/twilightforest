// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenHollowStump extends TFGenHollowTree
{
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final int radius = rand.nextInt(2) + 2;
        if (!this.isAreaClear(world, rand, x - radius, y, z - radius, 2 * radius, 6, 2 * radius)) {
            return false;
        }
        this.buildTrunk(world, rand, x, y, z, radius, 6);
        this.buildBranchRing(world, rand, x, y, z, radius, 3, 2, 6, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(world, rand, x, y, z, radius, 1, 2, 8, 0, 0.9, 0.0, 3, 5, 3, false);
        return true;
    }
    
    @Override
    protected void buildTrunk(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int maxHeight) {
        final int hollow = diameter / 2;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        if (TFGenerator.hasAirAround((IBlockAccess)world, dx + x, dy + y, dz + z)) {
                            this.setBlockAndMetadata(world, dx + x, dy + y, dz + z, this.treeBlock, (dist > hollow) ? this.treeMeta : this.branchMeta);
                        }
                        else {
                            this.setBlockAndMetadata(world, dx + x, dy + y, dz + z, this.rootBlock, this.rootMeta);
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
                        this.setBlockAndMetadata(world, dx + x, dy2 + y, dz + z, this.treeBlock, this.treeMeta);
                    }
                }
            }
        }
    }
}
