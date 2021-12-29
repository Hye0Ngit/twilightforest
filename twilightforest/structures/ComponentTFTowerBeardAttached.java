// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerBeardAttached extends ComponentTFTowerBeard
{
    public ComponentTFTowerBeardAttached(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.e = new aee(wing.b().a, wing.b().b - this.height - 1, wing.b().c, wing.b().d, wing.b().b - 1, wing.b().f);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        return this.makeAttachedBeard(world, rand, sbb);
    }
    
    private boolean makeAttachedBeard(final zv world, final Random rand, final aee sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y + 1;
            final int max = this.size - y;
            this.a(world, sbb, 0, this.height - y, min, max, this.height - y, max, false, rand, StructureTFComponent.getStrongholdStones());
        }
        return true;
    }
}
