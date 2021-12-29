// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFMazeRoomExit extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomExit(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        super.a(world, rand, sbb);
        this.a(world, sbb, 5, -5, 5, 10, 0, 10, TFBlocks.mazestone.cz, 1, 0, 0, false);
        this.a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone.cz, 3, 0, 0, false);
        this.a(world, sbb, 5, 2, 5, 10, 3, 10, aou.bt.cz, 0, 0, 0, false);
        this.a(world, sbb, 5, 4, 5, 10, 4, 10, TFBlocks.mazestone.cz, 3, 0, 0, false);
        this.a(world, sbb, 6, -5, 6, 9, 4, 9);
        return true;
    }
}
