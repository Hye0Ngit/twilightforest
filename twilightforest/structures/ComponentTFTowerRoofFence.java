// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerRoofFence extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofFence(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = 0;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        final int y = this.height + 1;
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.a(world, aou.bd.cz, 0, x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
