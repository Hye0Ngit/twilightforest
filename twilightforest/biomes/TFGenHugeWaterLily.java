// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.material.Material;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenHugeWaterLily extends WorldGenerator
{
    private Random rand;
    
    public TFGenHugeWaterLily() {
        this.rand = new Random();
    }
    
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        for (int i = 0; i < 4; ++i) {
            final int dx = x + random.nextInt(8) - random.nextInt(8);
            final int dy = y + random.nextInt(4) - random.nextInt(4);
            final int dz = z + random.nextInt(8) - random.nextInt(8);
            if (this.shouldPlacePadAt(world, dx, dy, dz)) {
                world.func_147449_b(dx, dy, dz, TFBlocks.hugeWaterLily);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final World world, final int dx, final int dy, final int dz) {
        return world.func_147437_c(dx, dy, dz) && world.func_147439_a(dx, dy - 1, dz).func_149688_o() == Material.field_151586_h;
    }
}
