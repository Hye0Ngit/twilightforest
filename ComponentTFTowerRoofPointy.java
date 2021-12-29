import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofPointy extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofPointy(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.h = wing.h;
        this.size = wing.size;
        this.height = this.size;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final fq world, final Random rand, final vw sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int slopeChange = this.slopeChangeForSize(this.size);
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            final int mid = min + (max - min) / 2;
            for (int x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.a(world, ud.al.bO, 2, x, y, z, sbb);
                    if ((x == min && (z == min || z == max)) || (x == max && (z == min || z == max))) {
                        this.a(world, ud.am.bO, 2, x, y + 1, z, sbb);
                    }
                    if ((((x == min || x == max) && z == mid && x % 2 == 0) || ((z == min || z == max) && x == mid && z % 2 == 0)) && mid != min + 1) {
                        this.a(world, ud.am.bO, 2, x, y + 1, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    public int slopeChangeForSize(final int pSize) {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
