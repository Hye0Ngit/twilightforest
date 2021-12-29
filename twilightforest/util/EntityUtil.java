// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import java.util.function.DoubleUnaryOperator;
import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityUtil
{
    public static boolean canDestroyBlock(final World world, final BlockPos pos, final Entity entity) {
        return canDestroyBlock(world, pos, world.func_180495_p(pos), entity);
    }
    
    public static boolean canDestroyBlock(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        final float hardness = state.func_185887_b(world, pos);
        return hardness >= 0.0f && hardness < 50.0f && !state.func_177230_c().isAir(state, (IBlockAccess)world, pos) && state.func_177230_c().canEntityDestroy(state, (IBlockAccess)world, pos, entity) && (!(entity instanceof EntityLivingBase) || ForgeEventFactory.onEntityDestroyBlock((EntityLivingBase)entity, pos, state));
    }
    
    @Nullable
    public static RayTraceResult rayTrace(final Entity entity, final double range) {
        final Vec3d position = entity.func_174824_e(1.0f);
        final Vec3d look = entity.func_70676_i(1.0f);
        final Vec3d dest = position.func_72441_c(look.field_72450_a * range, look.field_72448_b * range, look.field_72449_c * range);
        return entity.field_70170_p.func_72933_a(position, dest);
    }
    
    @Nullable
    public static RayTraceResult rayTrace(final EntityPlayer player) {
        return rayTrace(player, null);
    }
    
    @Nullable
    public static RayTraceResult rayTrace(final EntityPlayer player, @Nullable final DoubleUnaryOperator modifier) {
        final double range = player.func_110148_a(EntityPlayer.REACH_DISTANCE).func_111126_e();
        return rayTrace((Entity)player, (modifier == null) ? range : modifier.applyAsDouble(range));
    }
}
