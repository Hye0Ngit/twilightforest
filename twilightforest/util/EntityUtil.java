// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraftforge.common.ForgeMod;
import net.minecraft.world.entity.ai.attributes.Attribute;
import javax.annotation.Nullable;
import java.util.function.DoubleUnaryOperator;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class EntityUtil
{
    public static boolean canDestroyBlock(final Level world, final BlockPos pos, final Entity entity) {
        return canDestroyBlock(world, pos, world.m_8055_(pos), entity);
    }
    
    public static boolean canDestroyBlock(final Level world, final BlockPos pos, final BlockState state, final Entity entity) {
        final float hardness = state.m_60800_((BlockGetter)world, pos);
        return hardness >= 0.0f && hardness < 50.0f && !state.m_60795_() && state.m_60734_().canEntityDestroy(state, (BlockGetter)world, pos, entity) && (!(entity instanceof LivingEntity) || ForgeEventFactory.onEntityDestroyBlock((LivingEntity)entity, pos, state));
    }
    
    public static BlockHitResult rayTrace(final Entity entity, final double range) {
        final Vec3 position = entity.m_20299_(1.0f);
        final Vec3 look = entity.m_20252_(1.0f);
        final Vec3 dest = position.m_82520_(look.f_82479_ * range, look.f_82480_ * range, look.f_82481_ * range);
        return entity.f_19853_.m_45547_(new ClipContext(position, dest, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity));
    }
    
    public static BlockHitResult rayTrace(final Player player) {
        return rayTrace(player, null);
    }
    
    public static BlockHitResult rayTrace(final Player player, @Nullable final DoubleUnaryOperator modifier) {
        final double range = player.m_21051_((Attribute)ForgeMod.REACH_DISTANCE.get()).m_22135_();
        return rayTrace((Entity)player, (modifier == null) ? range : modifier.applyAsDouble(range));
    }
}
