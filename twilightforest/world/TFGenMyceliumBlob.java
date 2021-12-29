// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenMyceliumBlob extends add
{
    private int myceliumBlockId;
    private int numberOfBlocks;
    
    public TFGenMyceliumBlob(final int i) {
        this.myceliumBlockId = aou.bC.cz;
        this.numberOfBlocks = i;
    }
    
    public boolean a(final zv world, final Random random, final int i, final int j, final int k) {
        final int l = random.nextInt(this.numberOfBlocks - 2) + 2;
        final int i2 = 1;
        for (int j2 = i - l; j2 <= i + l; ++j2) {
            for (int k2 = k - l; k2 <= k + l; ++k2) {
                final int l2 = j2 - i;
                final int i3 = k2 - k;
                if (l2 * l2 + i3 * i3 <= l * l) {
                    for (int j3 = j - i2; j3 <= j + i2; ++j3) {
                        final int k3 = world.a(j2, j3, k2);
                        if (k3 == aou.z.cz || k3 == aou.y.cz) {
                            world.f(j2, j3, k2, this.myceliumBlockId, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
