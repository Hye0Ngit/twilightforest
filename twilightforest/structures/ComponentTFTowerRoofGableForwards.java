// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerRoofGableForwards extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofGableForwards(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        final int slabMeta = 2;
        final int slopeChange = this.slopeChangeForSize(this.size);
        for (int y = 0; y <= this.height; ++y) {
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
            for (int x = 0; x <= this.size - 2; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (z == min || z == max) {
                        this.a(world, aou.B.cz, slabMeta, x, y, z, sbb);
                    }
                    else if (x < this.size - 2) {
                        this.a(world, aou.B.cz, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        final int top = this.size + 1 - slopeChange;
        final int zMid = this.size / 2;
        this.a(world, aou.bS.cz, slabMeta | 0xA, this.size - 1, top - 1, zMid, sbb);
        this.a(world, aou.bS.cz, slabMeta, 0, top, zMid, sbb);
        this.a(world, aou.bS.cz, slabMeta, this.size - 3, top, zMid, sbb);
        this.a(world, aou.B.cz, slabMeta, this.size - 2, top, zMid, sbb);
        this.a(world, aou.B.cz, slabMeta, this.size - 1, top, zMid, sbb);
        this.a(world, aou.B.cz, slabMeta, this.size - 1, top + 1, zMid, sbb);
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
