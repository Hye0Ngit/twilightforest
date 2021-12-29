// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class ComponentTFTowerRoofStairs extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairs(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(0);
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final xd world, final Random rand, final qg sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.a(world, pb.ak.bO, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, pb.at.bO, 0, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.a(world, pb.ak.bO, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, pb.at.bO, 1, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.a(world, pb.at.bO, 3, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.a(world, pb.at.bO, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, pb.aj.bO, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
