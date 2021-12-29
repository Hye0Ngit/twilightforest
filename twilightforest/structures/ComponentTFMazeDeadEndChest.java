// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import twilightforest.TFTreasure;
import java.util.Random;

public class ComponentTFMazeDeadEndChest extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndChest(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        this.a(world, amj.A.cm, 0, 2, 1, 4, sbb);
        this.a(world, amj.A.cm, 0, 3, 1, 4, sbb);
        this.a(world, amj.aw.cm, this.getStairMeta(1), 2, 1, 3, sbb);
        this.a(world, amj.aw.cm, this.getStairMeta(1), 3, 1, 3, sbb);
        this.a(world, amj.ax.cm, 0, 2, 2, 4, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 4, TFTreasure.labyrinth_deadend, sbb);
        this.a(world, amj.at.cm, 0, 1, 3, 4, sbb);
        this.a(world, amj.at.cm, 0, 4, 3, 4, sbb);
        this.a(world, sbb, 1, 1, 0, 4, 3, 1, TFBlocks.mazestone.cm, 2, 0, 0, false);
        this.a(world, sbb, 1, 4, 0, 4, 4, 1, TFBlocks.mazestone.cm, 3, 0, 0, false);
        this.a(world, sbb, 2, 1, 0, 3, 3, 1, amj.bs.cm, 0, false);
        return true;
    }
}
