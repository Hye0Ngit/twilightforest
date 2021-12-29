// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFTrollRoot;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenTrollRoots extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random random, BlockPos pos) {
        final int copyX = pos.func_177958_n();
        final int copyZ = pos.func_177952_p();
        while (pos.func_177956_o() > 5) {
            if (world.func_175623_d(pos) && BlockTFTrollRoot.canPlaceRootBelow(world, pos.func_177984_a()) && random.nextInt(6) > 0) {
                if (random.nextInt(10) == 0) {
                    world.func_180501_a(pos, TFBlocks.unripe_trollber.func_176223_P(), 18);
                }
                else {
                    world.func_180501_a(pos, TFBlocks.trollvidr.func_176223_P(), 18);
                }
            }
            else {
                pos = new BlockPos(copyX + random.nextInt(4) - random.nextInt(4), pos.func_177956_o(), copyZ + random.nextInt(4) - random.nextInt(4));
            }
            pos = pos.func_177977_b();
        }
        return true;
    }
}
