// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenMyceliumBlob extends abm
{
    private int myceliumBlockId;
    private int numberOfBlocks;
    
    public TFGenMyceliumBlob(final int i) {
        this.myceliumBlockId = amq.bB.cm;
        this.numberOfBlocks = i;
    }
    
    public boolean a(final yc world, final Random random, final int i, final int j, final int k) {
        final int l = random.nextInt(this.numberOfBlocks - 2) + 2;
        final int i2 = 1;
        for (int j2 = i - l; j2 <= i + l; ++j2) {
            for (int k2 = k - l; k2 <= k + l; ++k2) {
                final int l2 = j2 - i;
                final int i3 = k2 - k;
                if (l2 * l2 + i3 * i3 <= l * l) {
                    for (int j3 = j - i2; j3 <= j + i2; ++j3) {
                        final int k3 = world.a(j2, j3, k2);
                        if (k3 == amq.y.cm || k3 == amq.x.cm) {
                            world.b(j2, j3, k2, this.myceliumBlockId);
                        }
                    }
                }
            }
        }
        return true;
    }
}
