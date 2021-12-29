// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerRoofSlab extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        final int slabMeta = 2;
        return this.makePyramidCap(world, slabMeta, sbb);
    }
    
    protected boolean makePyramidCap(final xv world, final int slabMeta, final acg sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.a(world, amj.bR.cm, slabMeta, x, y, z, sbb);
                    }
                    else {
                        this.a(world, amj.A.cm, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final xv world, final int slabMeta, final acg sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.a(world, amj.bR.cm, slabMeta, x, y, z, sbb);
                    }
                    else {
                        this.a(world, amj.A.cm, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
