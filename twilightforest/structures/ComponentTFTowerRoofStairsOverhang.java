// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerRoofStairsOverhang extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairsOverhang(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(0);
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.f = new age(wing.b().a - 1, wing.b().e, wing.b().c - 1, wing.b().d + 1, wing.b().e + this.height - 1, wing.b().f + 1);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.a(world, aqw.bT.cF, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, aqw.cc.cF, 0, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.a(world, aqw.bT.cF, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, aqw.cc.cF, 1, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.a(world, aqw.cc.cF, 3, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.a(world, aqw.cc.cF, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, aqw.C.cF, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
