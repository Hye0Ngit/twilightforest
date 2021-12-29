// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFMazeRoomCollapse extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomCollapse(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        super.a(world, rand, sbb);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                int gravel = rand.nextInt(dist);
                final int root = rand.nextInt(dist);
                if (gravel > 0) {
                    ++gravel;
                    this.a(world, sbb, x, 1, z, x, gravel, z, aqw.K.cF, 0, false);
                    this.a(world, sbb, x, gravel, z, x, gravel + 5, z);
                }
                else if (root > 0) {
                    this.a(world, sbb, x, 5, z, x, 5 + root, z, aqw.A.cF, 0, true);
                    this.a(world, sbb, x, 5 - rand.nextInt(5), z, x, 5, z, TFBlocks.plant.cF, 14, 0, 0, false);
                }
                else if (rand.nextInt(dist + 1) > 0) {
                    this.a(world, sbb, x, 5, z, x, 5, z);
                }
            }
        }
        return true;
    }
}
