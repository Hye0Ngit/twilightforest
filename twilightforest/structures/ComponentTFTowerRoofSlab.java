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
    public boolean a(final zv world, final Random rand, final aee sbb) {
        final int slabMeta = 2;
        return this.makePyramidCap(world, slabMeta, sbb);
    }
    
    protected boolean makePyramidCap(final zv world, final int slabMeta, final aee sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.a(world, aou.bS.cz, slabMeta, x, y, z, sbb);
                    }
                    else {
                        this.a(world, aou.B.cz, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final zv world, final int slabMeta, final aee sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.a(world, aou.bS.cz, slabMeta, x, y, z, sbb);
                    }
                    else {
                        this.a(world, aou.B.cz, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
