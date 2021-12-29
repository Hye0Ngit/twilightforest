// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.List;
import java.util.Random;

public class ComponentTFHydraLair extends ComponentTFHollowHill
{
    public ComponentTFHydraLair(final xv world, final Random rand, final int i, final int x, final int y, final int z) {
        super(world, rand, i, 2, x, y + 2, z);
    }
    
    @Override
    public void a(final aes structurecomponent, final List list, final Random random) {
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        final int stalacts = 64;
        final int stalags = 8;
        for (int i = 0; i < stalacts; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateOreStalactite(world, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < stalacts; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateStoneStalactite(world, 1.0, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < stalags; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateStoneStalactite(world, 0.9, false, dest[0], 1, dest[1], sbb);
        }
        this.a(world, TFBlocks.bossSpawner.cm, 2, 27, 3, 27, sbb);
        return true;
    }
}
