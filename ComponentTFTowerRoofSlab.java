import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofSlab extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.h = wing.h;
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final wz world, final Random rand, final qc sbb) {
        return this.makePyramidCap(world, sbb);
    }
    
    protected boolean makePyramidCap(final wz world, final qc sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.a(world, ox.ak.bO, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, ox.aj.bO, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final wz world, final qc sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.a(world, ox.ak.bO, 2, x, y, z, sbb);
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
