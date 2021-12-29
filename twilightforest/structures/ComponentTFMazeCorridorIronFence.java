// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFMazeCorridorIronFence extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorIronFence(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.a(world, sbb, 1, 4, 2, 4, 4, 3, TFBlocks.mazestone.cF, 3, 0, 0, false);
        this.a(world, sbb, 1, 1, 2, 4, 3, 3, TFBlocks.mazestone.cF, 2, 0, 0, false);
        this.a(world, sbb, 2, 1, 2, 3, 3, 3, aqw.bu.cF, 0, false);
        return true;
    }
}
