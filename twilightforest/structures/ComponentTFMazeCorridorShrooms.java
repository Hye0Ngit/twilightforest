// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeCorridorShrooms extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorShrooms(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(2) > 0) {
                    this.a(world, aqw.bD.cF, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(2) > 0) {
                    this.a(world, rand.nextBoolean() ? aqw.al.cF : aqw.ak.cF, 0, x, 1, z, sbb);
                }
            }
        }
        int mushType = rand.nextBoolean() ? aqw.bt.cF : aqw.bs.cF;
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(4) + 1;
        this.a(world, mushType, 15, 1, mushY - 1, mushZ, sbb);
        this.a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType, 10, 0, 0, false);
        this.a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        mushType = ((mushType == aqw.bs.cF) ? aqw.bt.cF : aqw.bs.cF);
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(4) + 1;
        this.a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType, 10, 0, 0, false);
        this.a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        return true;
    }
}
