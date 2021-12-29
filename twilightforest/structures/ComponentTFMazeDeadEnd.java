// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeDeadEnd extends StructureTFComponent
{
    public ComponentTFMazeDeadEnd(final int i, final int x, final int y, final int z, final int rotation) {
        super(i);
        this.f = rotation;
        this.e = new acn(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean a(final yc world, final Random rand, final acn sbb) {
        this.a(world, sbb, 1, 1, 0, 4, 4, 0, amq.bc.cm, 0, 0, 0, false);
        this.a(world, sbb, 2, 1, 0, 3, 3, 0);
        return true;
    }
}
