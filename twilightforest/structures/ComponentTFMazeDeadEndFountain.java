// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFMazeDeadEndFountain extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndFountain(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        super.a(world, rand, sbb);
        this.a(world, sbb, 1, 1, 4, 4, 4, 4, TFBlocks.mazestone.cF, 1, 0, 0, false);
        this.a(world, aqw.F.cF, 0, 2, 3, 4, sbb);
        this.a(world, aqw.F.cF, 0, 3, 3, 4, sbb);
        this.a(world, 0, 0, 2, 0, 3, sbb);
        this.a(world, 0, 0, 3, 0, 3, sbb);
        return true;
    }
}
