// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.Random;

public class ComponentTFDarkTowerBeard extends StructureTFComponent
{
    int size;
    int height;
    
    public ComponentTFDarkTowerBeard(final int i, final ComponentTFTowerWing wing) {
        super(i);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = this.size / 2;
        this.e = new acg(wing.b().a, wing.b().b - this.height, wing.b().c, wing.b().d, wing.b().b, wing.b().f);
    }
    
    public boolean a(final xv world, final Random rand, final acg sbb) {
        this.makeDarkBeard(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        return true;
    }
    
    protected void makeDarkBeard(final xv world, final acg sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final int frameID = TFBlocks.towerWood.cm;
        final int frameMeta = 1;
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (x == minX || x == maxX || z == minZ || z == maxZ) {
                    int length = Math.min(Math.abs(x - this.height) - 1, Math.abs(z - this.height) - 1);
                    if (length == this.height - 1) {
                        ++length;
                    }
                    if (length == -1) {
                        length = 1;
                    }
                    for (int y = maxY; y >= this.height - length; --y) {
                        this.a(world, frameID, frameMeta, x, y, z, sbb);
                    }
                }
            }
        }
    }
}
