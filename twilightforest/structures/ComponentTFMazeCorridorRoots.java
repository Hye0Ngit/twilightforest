// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.Random;

public class ComponentTFMazeCorridorRoots extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorRoots(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                final int freq = x;
                if (rand.nextInt(freq + 2) > 0) {
                    final int length = rand.nextInt(6);
                    this.a(world, amj.y.cm, 0, x, 6, z, sbb);
                    for (int y = 6 - length; y < 6; ++y) {
                        this.a(world, TFBlocks.plant.cm, 14, x, y, z, sbb);
                    }
                    if (rand.nextInt(freq + 1) > 1) {
                        this.a(world, amj.I.cm, 0, x, 1, z, sbb);
                        if (rand.nextInt(freq + 1) > 1) {
                            this.a(world, amj.I.cm, 0, x, 2, z, sbb);
                        }
                    }
                }
            }
        }
        return true;
    }
}
