import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofStairsOverhang extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairsOverhang(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.h = 0;
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.g = new qc(wing.g.a - 1, wing.g.e, wing.g.c - 1, wing.g.d + 1, wing.g.e + this.height - 1, wing.g.f + 1);
    }
    
    @Override
    public boolean a(final wz world, final Random rand, final qc sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.a(world, ox.ak.bO, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, ox.at.bO, 0, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.a(world, ox.ak.bO, 2, x, y, z, sbb);
                        }
                        else {
                            this.a(world, ox.at.bO, 1, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.a(world, ox.at.bO, 3, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.a(world, ox.at.bO, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, ox.aj.bO, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
