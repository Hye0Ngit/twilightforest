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
    public boolean a(final yc world, final Random rand, final acn sbb) {
        this.a(world, sbb, 1, 4, 2, 4, 4, 3, TFBlocks.mazestone.cm, 3, 0, 0, false);
        this.a(world, sbb, 1, 1, 2, 4, 3, 3, TFBlocks.mazestone.cm, 2, 0, 0, false);
        this.a(world, sbb, 2, 1, 2, 3, 3, 3, amq.bs.cm, 0, false);
        return true;
    }
}
