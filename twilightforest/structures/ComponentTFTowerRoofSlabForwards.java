// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerRoofSlabForwards extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofSlabForwards(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max - 1; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max - 1 || z == min || z == max) {
                        this.a(world, aou.bS.cz, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, aou.bR.cz, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
