// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFMazeDeadEndRoots extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndRoots(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(z + 2) > 0) {
                    final int length = rand.nextInt(6);
                    this.a(world, amq.y.cm, 0, x, 6, z, sbb);
                    for (int y = 6 - length; y < 6; ++y) {
                        this.a(world, TFBlocks.plant.cm, 14, x, y, z, sbb);
                    }
                    if (rand.nextInt(z + 1) > 1) {
                        this.a(world, amq.I.cm, 0, x, 1, z, sbb);
                        if (rand.nextInt(z + 1) > 1) {
                            this.a(world, amq.I.cm, 0, x, 2, z, sbb);
                        }
                    }
                }
            }
        }
        return true;
    }
}
