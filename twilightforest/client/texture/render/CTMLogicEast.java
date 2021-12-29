// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.texture.render;

import net.minecraft.util.math.Vec3i;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import javax.annotation.ParametersAreNonnullByDefault;
import team.chisel.ctm.client.util.CTMLogic;

@ParametersAreNonnullByDefault
public class CTMLogicEast extends CTMLogic
{
    public static CTMLogicEast getInstance() {
        return new CTMLogicEast();
    }
    
    public boolean isConnected(final IBlockAccess world, final BlockPos current, final BlockPos connection, final EnumFacing dir, final IBlockState state) {
        final BlockPos difference = current.func_177973_b((Vec3i)connection);
        return super.isConnected(world, current, current.func_177971_a((Vec3i)new BlockPos(difference.func_177952_p(), -difference.func_177958_n(), difference.func_177956_o())), dir, state);
    }
}
