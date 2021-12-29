// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.Random;

public class ComponentTFMazeRoomFountain extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomFountain(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        super.a(world, rand, sbb);
        this.a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone.cm, 3, 0, 0, false);
        this.a(world, sbb, 6, 1, 6, 9, 1, 9, amj.D.cm, 0, false);
        return true;
    }
}
