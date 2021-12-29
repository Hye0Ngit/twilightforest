// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenNoTree extends TFTreeGenerator
{
    public TFGenNoTree() {
    }
    
    public TFGenNoTree(final boolean notify) {
        super(notify);
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        return false;
    }
}
