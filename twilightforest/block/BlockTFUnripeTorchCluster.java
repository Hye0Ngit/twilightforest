// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import net.minecraft.world.World;

public class BlockTFUnripeTorchCluster extends BlockTFTrollRoot
{
    private static final int RIPEN_THRESHHOLD = 6;
    
    protected BlockTFUnripeTorchCluster() {
        this.func_149658_d("TwilightForest:unripe_torch_cluster");
    }
    
    @Override
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random rand) {
        super.func_149674_a(world, x, y, z, rand);
        if (world.func_72957_l(x, y, z) >= 6) {
            world.func_147449_b(x, y, z, TFBlocks.trollBer);
        }
    }
}
