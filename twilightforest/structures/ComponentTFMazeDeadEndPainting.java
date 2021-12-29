// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeDeadEndPainting extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndPainting(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        super.a(world, rand, sbb);
        this.a(world, aqw.av.cF, 0, 1, 3, 3, sbb);
        this.a(world, aqw.av.cF, 0, 4, 3, 3, sbb);
        return true;
    }
}
