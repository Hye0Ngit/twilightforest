// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFPlant;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenPlantRoots extends TFGenerator
{
    @Override
    public boolean func_76484_a(final World par1World, final Random par2Random, int x, int y, int z) {
        final int copyX = x;
        final int copyZ = z;
        while (y > 5) {
            if (par1World.func_72799_c(x, y, z) && BlockTFPlant.canPlaceRootBelow(par1World, x, y + 1, z) && par2Random.nextInt(6) > 0) {
                par1World.func_72832_d(x, y, z, TFBlocks.plant.field_71990_ca, 14, 2);
            }
            else {
                x = copyX + par2Random.nextInt(4) - par2Random.nextInt(4);
                z = copyZ + par2Random.nextInt(4) - par2Random.nextInt(4);
            }
            --y;
        }
        return true;
    }
}
