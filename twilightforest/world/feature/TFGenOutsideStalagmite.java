// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;

public class TFGenOutsideStalagmite extends TFGenCaveStalactite
{
    public TFGenOutsideStalagmite() {
        super(Blocks.field_150348_b, 1.0f, false);
    }
    
    @Override
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final int length = rand.nextInt(10) + 5;
        return TFGenerator.isAreaSuitable(world, rand, pos, 1, length, 1) && this.makeSpike(world, rand, pos.func_177977_b(), length);
    }
}
