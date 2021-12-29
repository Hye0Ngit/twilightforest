// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeDeadEndTorches extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndTorches(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        super.a(world, rand, sbb);
        this.a(world, sbb, 2, 1, 4, 3, 4, 4, aou.au.cz, 0, 0, 0, false);
        this.a(world, sbb, 1, 1, 1, 1, 4, 4, aou.au.cz, 0, 0, 0, false);
        this.a(world, sbb, 4, 1, 1, 4, 4, 4, aou.au.cz, 0, 0, 0, false);
        return true;
    }
}
