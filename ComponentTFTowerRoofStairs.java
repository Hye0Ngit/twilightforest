import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofStairs extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairs(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.h = 0;
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final ge world, final Random rand, final xv sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.a(world, vz.ak.bO, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, vz.at.bO, 0, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.a(world, vz.ak.bO, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, vz.at.bO, 1, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.a(world, vz.at.bO, 3, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.a(world, vz.at.bO, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, vz.aj.bO, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
