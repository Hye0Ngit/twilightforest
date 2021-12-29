// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeDeadEndFountainLava extends ComponentTFMazeDeadEndFountain
{
    public ComponentTFMazeDeadEndFountainLava(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        super.a(world, rand, sbb);
        this.a(world, 0, 0, 2, 3, 4, sbb);
        this.a(world, 0, 0, 3, 3, 4, sbb);
        this.a(world, aou.G.cz, 0, 2, 3, 4, sbb);
        this.a(world, aou.G.cz, 0, 3, 3, 4, sbb);
        return true;
    }
}
