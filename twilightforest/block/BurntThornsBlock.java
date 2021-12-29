// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.pathfinding.PathNodeType;
import javax.annotation.Nullable;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class BurntThornsBlock extends ThornsBlock
{
    protected BurntThornsBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Nullable
    @Override
    public PathNodeType getAiPathNodeType(final BlockState state, final IBlockReader world, final BlockPos pos, @Nullable final MobEntity entity) {
        return null;
    }
    
    @Deprecated
    @Override
    public void func_196262_a(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        if (!world.field_72995_K && entity instanceof LivingEntity) {
            world.func_175655_b(pos, false);
        }
    }
    
    @Override
    public boolean removedByPlayer(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final boolean willHarvest, final FluidState fluid) {
        this.getBlock().func_176208_a(world, pos, state, player);
        return world.func_180501_a(pos, fluid.func_206883_i(), world.field_72995_K ? 11 : 3);
    }
}
