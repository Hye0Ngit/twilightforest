// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenMyceliumBlob extends WorldGenerator
{
    private final IBlockState myceliumState;
    private final int numberOfBlocks;
    
    public TFGenMyceliumBlob(final int i) {
        this((Block)Blocks.field_150391_bh, i);
    }
    
    public TFGenMyceliumBlob(final Block block, final int i) {
        this.myceliumState = block.func_176223_P();
        this.numberOfBlocks = i;
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        final int range = random.nextInt(this.numberOfBlocks - 2) + 2;
        final int yRange = 1;
        for (int dx = pos.func_177958_n() - range; dx <= pos.func_177958_n() + range; ++dx) {
            for (int dz = pos.func_177952_p() - range; dz <= pos.func_177952_p() + range; ++dz) {
                final int l1 = dx - pos.func_177958_n();
                final int i2 = dz - pos.func_177952_p();
                if (l1 * l1 + i2 * i2 <= range * range) {
                    for (int dy = pos.func_177956_o() - yRange; dy <= pos.func_177956_o() + yRange; ++dy) {
                        final BlockPos dPos = new BlockPos(dx, dy, dz);
                        final Block blockThere = world.func_180495_p(dPos).func_177230_c();
                        if (blockThere == Blocks.field_150346_d || blockThere == Blocks.field_150349_c || blockThere == Blocks.field_150348_b) {
                            world.func_180501_a(dPos, this.myceliumState, 18);
                        }
                    }
                }
            }
        }
        return true;
    }
}
