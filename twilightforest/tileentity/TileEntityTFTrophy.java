// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntitySkull;

public class TileEntityTFTrophy extends TileEntitySkull
{
    public int ticksExisted;
    
    public void func_73660_a() {
        super.func_73660_a();
        ++this.ticksExisted;
    }
    
    public boolean shouldRefresh(final World world, final BlockPos pos, final IBlockState oldState, final IBlockState newState) {
        return oldState.func_177230_c() != newState.func_177230_c();
    }
}
