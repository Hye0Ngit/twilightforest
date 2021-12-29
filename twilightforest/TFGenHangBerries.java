// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFGenHangBerries extends TFGenerator
{
    @Override
    public boolean a(final xd par1World, final Random par2Random, int x, int y, int z) {
        final int copyX = x;
        final int copyZ = z;
        while (y > 5) {
            if (par1World.i(x, y, z) && BlockTFPlant.canPlaceRootBelow(par1World, x, y + 1, z) && par2Random.nextInt(6) > 0) {
                par1World.b(x, y, z, TFBlocks.plant.bO, 13);
                break;
            }
            x = copyX + par2Random.nextInt(4) - par2Random.nextInt(4);
            z = copyZ + par2Random.nextInt(4) - par2Random.nextInt(4);
            --y;
        }
        return true;
    }
}
