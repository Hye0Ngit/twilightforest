// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.phys.BlockHitResult;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.phys.HitResult;
import twilightforest.util.EntityUtil;
import net.minecraft.world.phys.AABB;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Block;

public class HedgeBlock extends Block
{
    private static final VoxelShape HEDGE_BB;
    private static final int DAMAGE = 3;
    
    protected HedgeBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape m_5939_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return HedgeBlock.HEDGE_BB;
    }
    
    @Nullable
    public BlockPathTypes getAiPathNodeType(final BlockState state, final BlockGetter world, final BlockPos pos, @Nullable final Mob entity) {
        return (entity != null && this.shouldDamage((Entity)entity)) ? BlockPathTypes.DANGER_CACTUS : null;
    }
    
    @Deprecated
    public void m_7892_(final BlockState state, final Level worldIn, final BlockPos pos, final Entity entity) {
        if (this.shouldDamage(entity)) {
            entity.m_6469_(DamageSource.f_19314_, 3.0f);
        }
    }
    
    public void m_141947_(final Level world, final BlockPos pos, final BlockState state, final Entity entity) {
        if (this.shouldDamage(entity)) {
            entity.m_6469_(DamageSource.f_19314_, 3.0f);
        }
    }
    
    public void m_6256_(final BlockState state, final Level world, final BlockPos pos, final Player player) {
        if (!world.f_46443_) {
            world.m_6219_().m_5945_(pos, (Object)this, 10);
        }
    }
    
    public void m_6240_(final Level world, final Player player, final BlockPos pos, final BlockState state, @Nullable final BlockEntity te, final ItemStack stack) {
        super.m_6240_(world, player, pos, state, te, stack);
        player.m_6469_(DamageSource.f_19314_, 3.0f);
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        final List<Player> nearbyPlayers = world.m_45976_((Class)Player.class, new AABB(pos).m_82400_(8.0));
        for (final Player player : nearbyPlayers) {
            if (player.f_20911_) {
                final BlockHitResult ray = EntityUtil.rayTrace(player);
                if (ray.m_6662_() != HitResult.Type.BLOCK || !pos.equals((Object)ray.m_82425_())) {
                    continue;
                }
                player.m_6469_(DamageSource.f_19314_, 3.0f);
                world.m_6219_().m_5945_(pos, (Object)this, 10);
            }
        }
    }
    
    private boolean shouldDamage(final Entity entity) {
        return !(entity instanceof Spider) && !(entity instanceof ItemEntity) && !entity.m_6090_();
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 0;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 0;
    }
    
    static {
        HEDGE_BB = Shapes.m_83064_(new AABB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0));
    }
}
