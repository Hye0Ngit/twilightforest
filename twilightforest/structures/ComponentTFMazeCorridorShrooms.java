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
    public boolean a(final zv world, final Random rand, final aee sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(2) > 0) {
                    this.a(world, aou.bC.cz, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(2) > 0) {
                    this.a(world, rand.nextBoolean() ? aou.ak.cz : aou.aj.cz, 0, x, 1, z, sbb);
                }
            }
        }
        int mushType = rand.nextBoolean() ? aou.bs.cz : aou.br.cz;
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(4) + 1;
        this.a(world, mushType, 15, 1, mushY - 1, mushZ, sbb);
        this.a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType, 10, 0, 0, false);
        this.a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        mushType = ((mushType == aou.br.cz) ? aou.bs.cz : aou.br.cz);
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(4) + 1;
        this.a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType, 10, 0, 0, false);
        this.a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        return true;
    }
}
