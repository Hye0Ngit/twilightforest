// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraftforge.common.ForgeMod;
import net.minecraft.entity.ai.attributes.Attribute;
import javax.annotation.Nullable;
import java.util.function.DoubleUnaryOperator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityUtil
{
    public static boolean canDestroyBlock(final World world, final BlockPos pos, final Entity entity) {
        return canDestroyBlock(world, pos, world.func_180495_p(pos), entity);
    }
    
    public static boolean canDestroyBlock(final World world, final BlockPos pos, final BlockState state, final Entity entity) {
        final float hardness = state.func_185887_b((IBlockReader)world, pos);
        return hardness >= 0.0f && hardness < 50.0f && !state.func_177230_c().isAir(state, (IBlockReader)world, pos) && state.func_177230_c().canEntityDestroy(state, (IBlockReader)world, pos, entity) && (!(entity instanceof LivingEntity) || ForgeEventFactory.onEntityDestroyBlock((LivingEntity)entity, pos, state));
    }
    
    public static BlockRayTraceResult rayTrace(final Entity entity, final double range) {
        final Vector3d position = entity.func_174824_e(1.0f);
        final Vector3d look = entity.func_70676_i(1.0f);
        final Vector3d dest = position.func_72441_c(look.field_72450_a * range, look.field_72448_b * range, look.field_72449_c * range);
        return entity.field_70170_p.func_217299_a(new RayTraceContext(position, dest, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity));
    }
    
    public static BlockRayTraceResult rayTrace(final PlayerEntity player) {
        return rayTrace(player, null);
    }
    
    public static BlockRayTraceResult rayTrace(final PlayerEntity player, @Nullable final DoubleUnaryOperator modifier) {
        final double range = player.func_110148_a((Attribute)ForgeMod.REACH_DISTANCE.get()).func_111126_e();
        return rayTrace((Entity)player, (modifier == null) ? range : modifier.applyAsDouble(range));
    }
}
