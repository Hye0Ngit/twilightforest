// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenMyceliumBlob extends WorldGenerator
{
    private Block myceliumBlockId;
    private int numberOfBlocks;
    
    public TFGenMyceliumBlob(final int i) {
        this.myceliumBlockId = (Block)Blocks.field_150391_bh;
        this.numberOfBlocks = i;
    }
    
    public TFGenMyceliumBlob(final Block block, final int i) {
        this.myceliumBlockId = block;
        this.numberOfBlocks = i;
    }
    
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        final int range = random.nextInt(this.numberOfBlocks - 2) + 2;
        final int yRange = 1;
        for (int dx = x - range; dx <= x + range; ++dx) {
            for (int dz = z - range; dz <= z + range; ++dz) {
                final int l1 = dx - x;
                final int i2 = dz - z;
                if (l1 * l1 + i2 * i2 <= range * range) {
                    for (int dy = y - yRange; dy <= y + yRange; ++dy) {
                        final Block blockThere = world.func_147439_a(dx, dy, dz);
                        if (blockThere == Blocks.field_150346_d || blockThere == Blocks.field_150349_c || blockThere == Blocks.field_150348_b) {
                            world.func_147465_d(dx, dy, dz, this.myceliumBlockId, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
