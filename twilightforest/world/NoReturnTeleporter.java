// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class NoReturnTeleporter extends TFTeleporter
{
    public NoReturnTeleporter() {
        super(false);
    }
    
    @Override
    protected BlockPos makePortalAt(final Level world, final BlockPos pos) {
        return pos;
    }
}
