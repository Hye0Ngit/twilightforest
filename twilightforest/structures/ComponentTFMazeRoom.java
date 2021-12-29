// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.List;
import java.util.Random;

public class ComponentTFMazeRoom extends StructureTFComponent
{
    public ComponentTFMazeRoom(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.f = rand.nextInt(4);
        this.e = new acn(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void a(final aez structurecomponent, final List list, final Random random) {
    }
    
    public boolean a(final yc world, final Random rand, final acn sbb) {
        this.a(world, sbb, 1, 0, 1, 14, 0, 14, TFBlocks.mazestone.cm, 7, 0, 0, true);
        this.a(world, sbb, 2, 0, 2, 13, 0, 13, TFBlocks.mazestone.cm, 6, 0, 0, true);
        if (this.a(world, 7, 1, 0, sbb) == 0) {
            this.a(world, sbb, 6, 1, 0, 9, 4, 0, amq.bc.cm, 0, false);
            this.a(world, sbb, 7, 1, 0, 8, 3, 0);
        }
        if (this.a(world, 7, 1, 15, sbb) == 0) {
            this.a(world, sbb, 6, 1, 15, 9, 4, 15, amq.bc.cm, 0, false);
            this.a(world, sbb, 7, 1, 15, 8, 3, 15);
        }
        if (this.a(world, 0, 1, 7, sbb) == 0) {
            this.a(world, sbb, 0, 1, 6, 0, 4, 9, amq.bc.cm, 0, false);
            this.a(world, sbb, 0, 1, 7, 0, 3, 8);
        }
        if (this.a(world, 15, 1, 7, sbb) == 0) {
            this.a(world, sbb, 15, 1, 6, 15, 4, 9, amq.bc.cm, 0, false);
            this.a(world, sbb, 15, 1, 7, 15, 3, 8);
        }
        return true;
    }
}
