// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeDeadEndShrooms extends ComponentTFMazeDeadEndRoots
{
    public ComponentTFMazeDeadEndShrooms(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(z + 2) > 0) {
                    this.a(world, amq.bB.cm, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(z + 2) > 0) {
                    this.a(world, rand.nextBoolean() ? amq.aj.cm : amq.ai.cm, 0, x, 1, z, sbb);
                }
            }
        }
        int mushType = rand.nextBoolean() ? amq.br.cm : amq.bq.cm;
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(3) + 1;
        this.a(world, mushType, 15, 1, mushY - 1, mushZ, sbb);
        this.a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType, 10, 0, 0, false);
        this.a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        mushType = ((mushType == amq.bq.cm) ? amq.br.cm : amq.bq.cm);
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(3) + 1;
        this.a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType, 10, 0, 0, false);
        this.a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        mushType = (rand.nextBoolean() ? amq.br.cm : amq.bq.cm);
        mushY = rand.nextInt(4) + 1;
        final int mushX = rand.nextInt(3) + 2;
        this.a(world, sbb, mushX, 1, 4, mushX, mushY, 4, mushType, 10, 0, 0, false);
        this.a(world, sbb, mushX - 1, mushY, 3, mushX + 1, mushY, 4, mushType, 14, 0, 0, false);
        return true;
    }
}
