// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenMyceliumBlob extends WorldGenerator
{
    private int myceliumBlockId;
    private int numberOfBlocks;
    
    public TFGenMyceliumBlob(final int i) {
        this.myceliumBlockId = Block.field_71994_by.field_71990_ca;
        this.numberOfBlocks = i;
    }
    
    public boolean func_76484_a(final World world, final Random random, final int i, final int j, final int k) {
        final int l = random.nextInt(this.numberOfBlocks - 2) + 2;
        final int i2 = 1;
        for (int j2 = i - l; j2 <= i + l; ++j2) {
            for (int k2 = k - l; k2 <= k + l; ++k2) {
                final int l2 = j2 - i;
                final int i3 = k2 - k;
                if (l2 * l2 + i3 * i3 <= l * l) {
                    for (int j3 = j - i2; j3 <= j + i2; ++j3) {
                        final int k3 = world.func_72798_a(j2, j3, k2);
                        if (k3 == Block.field_71979_v.field_71990_ca || k3 == Block.field_71980_u.field_71990_ca) {
                            world.func_72832_d(j2, j3, k2, this.myceliumBlockId, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
