// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeCorridor extends StructureTFComponent
{
    public ComponentTFMazeCorridor(final int i, final int x, final int y, final int z, final int rotation) {
        super(i);
        this.g = rotation;
        this.f = new age(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.a(world, sbb, 1, 1, 2, 4, 4, 3, aqw.be.cF, 0, 0, 0, false);
        this.a(world, sbb, 2, 1, 2, 3, 3, 3);
        return true;
    }
}
