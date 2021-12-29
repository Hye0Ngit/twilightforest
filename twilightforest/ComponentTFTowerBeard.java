// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class ComponentTFTowerBeard extends StructureTFComponent
{
    int size;
    int height;
    
    public ComponentTFTowerBeard(final int i, final ComponentTFTowerWing wing) {
        super(i);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size - 2;
        this.height = this.size / 2;
        this.g = new qg(wing.b().a + 1, wing.b().b - this.height - 1, wing.b().c + 1, wing.b().d - 1, wing.b().b - 1, wing.b().f - 1);
    }
    
    public boolean a(final xd world, final Random rand, final qg sbb) {
        return this.makePyramidBeard(world, rand, sbb);
    }
    
    private boolean makePyramidBeard(final xd world, final Random rand, final qg sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            final int max = this.size - y - 1;
            this.a(world, sbb, min, this.height - y, min, max, this.height - y, max, false, rand, StructureTFComponent.getStrongholdStones());
        }
        return true;
    }
}
