// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IBlockSettable
{
    void setBlockAndNotify(final World p0, final BlockPos p1, final IBlockState p2);
}
