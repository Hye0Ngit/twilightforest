// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLeaves;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class TFGenSmallTwilightOak extends WorldGenTrees implements IBlockSettable
{
    public TFGenSmallTwilightOak(final boolean notify) {
        this(notify, 4);
    }
    
    public TFGenSmallTwilightOak(final boolean notify, final int minHeight) {
        this(notify, minHeight, TFBlocks.twilight_log.func_176223_P(), TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
    }
    
    protected TFGenSmallTwilightOak(final boolean notify, final int minHeight, final IBlockState trunk, final IBlockState leaves) {
        super(notify, minHeight, trunk, leaves, false);
    }
    
    public final void setBlockAndNotify(final World world, final BlockPos pos, final IBlockState state) {
        this.func_175903_a(world, pos, state);
    }
}
