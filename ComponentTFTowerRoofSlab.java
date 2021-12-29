import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofSlab extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.f = wing.f;
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final ry world, final Random rand, final nl sbb) {
        return this.makePyramidCap(world, sbb);
    }
    
    protected boolean makePyramidCap(final ry world, final nl sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.a(world, yy.ak.bM, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, yy.aj.bM, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final ry world, final nl sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.a(world, yy.ak.bM, 2, x, y, z, sbb);
                    }
                    else {
                        this.a(world, yy.aj.bM, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
