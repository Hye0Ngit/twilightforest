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
    
    public boolean func_76484_a(final World world, final Random random, final int i, final int j, final int k) {
        final int l = random.nextInt(this.numberOfBlocks - 2) + 2;
        final int i2 = 1;
        for (int j2 = i - l; j2 <= i + l; ++j2) {
            for (int k2 = k - l; k2 <= k + l; ++k2) {
                final int l2 = j2 - i;
                final int i3 = k2 - k;
                if (l2 * l2 + i3 * i3 <= l * l) {
                    for (int j3 = j - i2; j3 <= j + i2; ++j3) {
                        final Block k3 = world.func_147439_a(j2, j3, k2);
                        if (k3 == Blocks.field_150346_d || k3 == Blocks.field_150349_c || k3 == Blocks.field_150348_b) {
                            world.func_147465_d(j2, j3, k2, this.myceliumBlockId, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
