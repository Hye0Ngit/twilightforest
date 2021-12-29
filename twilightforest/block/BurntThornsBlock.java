// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BurntThornsBlock extends ThornsBlock
{
    protected BurntThornsBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Nullable
    @Override
    public BlockPathTypes getAiPathNodeType(final BlockState state, final BlockGetter world, final BlockPos pos, @Nullable final Mob entity) {
        return null;
    }
    
    @Deprecated
    @Override
    public void m_7892_(final BlockState state, final Level world, final BlockPos pos, final Entity entity) {
        if (!world.f_46443_ && (entity instanceof LivingEntity || entity instanceof Projectile)) {
            world.m_46961_(pos, false);
        }
    }
    
    @Override
    public boolean removedByPlayer(final BlockState state, final Level world, final BlockPos pos, final Player player, final boolean willHarvest, final FluidState fluid) {
        state.m_60734_().m_5707_(world, pos, state, player);
        return world.m_7731_(pos, fluid.m_76188_(), world.f_46443_ ? 11 : 3);
    }
}
