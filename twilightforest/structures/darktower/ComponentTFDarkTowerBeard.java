// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.block.TFBlocks;
import java.util.Random;
import twilightforest.structures.ComponentTFTowerWing;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFDarkTowerBeard extends StructureTFComponent
{
    protected int size;
    protected int height;
    
    public ComponentTFDarkTowerBeard(final int i, final ComponentTFTowerWing wing) {
        super(i);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = this.size / 2;
        this.f = new age(wing.b().a, wing.b().b - this.height, wing.b().c, wing.b().d, wing.b().b, wing.b().f);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.makeDarkBeard(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        return true;
    }
    
    protected void makeDarkBeard(final abv world, final age sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final int frameID = TFBlocks.towerWood.cF;
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
