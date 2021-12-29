// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.DustParticleOptions;
import com.mojang.math.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import java.util.Set;
import java.util.Deque;
import net.minecraft.core.Direction;
import java.util.HashSet;
import java.util.ArrayDeque;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Block;

public class VanishingBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    public static final BooleanProperty VANISHED;
    private static final VoxelShape VANISHED_SHAPE;
    
    public VanishingBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)VanishingBlock.ACTIVE, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)VanishingBlock.ACTIVE });
    }
    
    private boolean isVanished(final BlockState state) {
        return state.m_61138_((Property)VanishingBlock.VANISHED) && (boolean)state.m_61143_((Property)VanishingBlock.VANISHED);
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter world, final BlockPos pos, final CollisionContext ctx) {
        return this.isVanished(state) ? VanishingBlock.VANISHED_SHAPE : super.m_5940_(state, world, pos, ctx);
    }
    
    public VoxelShape m_5939_(final BlockState state, final BlockGetter world, final BlockPos pos, final CollisionContext ctx) {
        return this.isVanished(state) ? Shapes.m_83040_() : super.m_5939_(state, world, pos, ctx);
    }
    
    @Deprecated
    public InteractionResult m_6227_(final BlockState state, final Level world, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        if (!this.isVanished(state) && !(boolean)state.m_61143_((Property)VanishingBlock.ACTIVE)) {
            if (areBlocksLocked((BlockGetter)world, pos)) {
                world.m_5594_((Player)null, pos, TFSounds.LOCKED_VANISHING_BLOCK, SoundSource.BLOCKS, 1.0f, 0.3f);
            }
            else {
                this.activate(world, pos);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    public float getExplosionResistance(final BlockState state, final BlockGetter world, final BlockPos pos, final Explosion explosion) {
        return state.m_61143_((Property)VanishingBlock.ACTIVE) ? super.getExplosionResistance(state, world, pos, explosion) : 6000.0f;
    }
    
    public boolean canEntityDestroy(final BlockState state, final BlockGetter world, final BlockPos pos, final Entity entity) {
        return state.m_61143_((Property)VanishingBlock.ACTIVE) ? super.canEntityDestroy(state, world, pos, entity) : (!areBlocksLocked(world, pos));
    }
    
    private static boolean areBlocksLocked(final BlockGetter world, final BlockPos start) {
        final int limit = 512;
        final Deque<BlockPos> queue = new ArrayDeque<BlockPos>();
        final Set<BlockPos> checked = new HashSet<BlockPos>();
        queue.offer(start);
        for (int iter = 0; !queue.isEmpty() && iter < limit; ++iter) {
            final BlockPos cur = queue.pop();
            final BlockState state = world.m_8055_(cur);
            if (state.m_60734_() == TFBlocks.LOCKED_VANISHING_BLOCK.get() && (boolean)state.m_61143_((Property)LockedVanishingBlock.LOCKED)) {
                return true;
            }
            checked.add(cur);
            if (state.m_60734_() instanceof VanishingBlock) {
                for (final Direction facing : Direction.values()) {
                    final BlockPos neighbor = cur.m_142300_(facing);
                    if (!checked.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return false;
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.f_46443_) {
            return;
        }
        if (!this.isVanished(state) && !(boolean)state.m_61143_((Property)VanishingBlock.ACTIVE) && world.m_46753_(pos) && !areBlocksLocked((BlockGetter)world, pos)) {
            this.activate(world, pos);
        }
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        if (world.f_46443_) {
            return;
        }
        if (this.isVanished(state)) {
            if (state.m_61143_((Property)VanishingBlock.ACTIVE)) {
                world.m_46597_(pos, (BlockState)((BlockState)state.m_61124_((Property)VanishingBlock.VANISHED, (Comparable)false)).m_61124_((Property)VanishingBlock.ACTIVE, (Comparable)false));
            }
            else {
                world.m_46597_(pos, (BlockState)state.m_61124_((Property)VanishingBlock.ACTIVE, (Comparable)true));
                world.m_6219_().m_5945_(pos, (Object)this, 15);
            }
            world.m_5594_((Player)null, pos, TFSounds.REAPPEAR_BLOCK, SoundSource.BLOCKS, 0.3f, 0.6f);
        }
        else if (state.m_61143_((Property)VanishingBlock.ACTIVE)) {
            if (state.m_61138_((Property)VanishingBlock.VANISHED)) {
                world.m_46597_(pos, (BlockState)((BlockState)state.m_61124_((Property)VanishingBlock.ACTIVE, (Comparable)false)).m_61124_((Property)VanishingBlock.VANISHED, (Comparable)true));
                world.m_6219_().m_5945_(pos, (Object)this, 80);
            }
            else {
                world.m_7471_(pos, false);
            }
            world.m_5594_((Player)null, pos, (state.m_60734_() == TFBlocks.REAPPEARING_BLOCK.get()) ? TFSounds.REAPPEAR_POOF : TFSounds.VANISHING_BLOCK, SoundSource.BLOCKS, 0.3f, 0.5f);
            for (final Direction e : Direction.values()) {
                this.activate((Level)world, pos.m_142300_(e));
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random random) {
        if (state.m_61143_((Property)VanishingBlock.ACTIVE)) {
            this.sparkle(world, pos);
        }
    }
    
    public void sparkle(final Level worldIn, final BlockPos pos) {
        final Random random = worldIn.f_46441_;
        final double d0 = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = pos.m_123341_() + random.nextFloat();
            double d3 = pos.m_123342_() + random.nextFloat();
            double d4 = pos.m_123343_() + random.nextFloat();
            if (i == 0 && !worldIn.m_8055_(pos.m_7494_()).m_60804_((BlockGetter)worldIn, pos)) {
                d3 = pos.m_123342_() + d0 + 1.0;
            }
            if (i == 1 && !worldIn.m_8055_(pos.m_7495_()).m_60804_((BlockGetter)worldIn, pos)) {
                d3 = pos.m_123342_() - d0;
            }
            if (i == 2 && !worldIn.m_8055_(pos.m_142128_()).m_60804_((BlockGetter)worldIn, pos)) {
                d4 = pos.m_123343_() + d0 + 1.0;
            }
            if (i == 3 && !worldIn.m_8055_(pos.m_142127_()).m_60804_((BlockGetter)worldIn, pos)) {
                d4 = pos.m_123343_() - d0;
            }
            if (i == 4 && !worldIn.m_8055_(pos.m_142126_()).m_60804_((BlockGetter)worldIn, pos)) {
                d2 = pos.m_123341_() + d0 + 1.0;
            }
            if (i == 5 && !worldIn.m_8055_(pos.m_142125_()).m_60804_((BlockGetter)worldIn, pos)) {
                d2 = pos.m_123341_() - d0;
            }
            final float f1 = 1.0f;
            final float f2 = Math.max(0.0f, 0.19999999f);
            final float f3 = Math.max(0.0f, -0.099999964f);
            if (d2 < pos.m_123341_() || d2 > pos.m_123341_() + 1 || d3 < 0.0 || d3 > pos.m_123342_() + 1 || d4 < pos.m_123343_() || d4 > pos.m_123343_() + 1) {
                worldIn.m_7106_((ParticleOptions)new DustParticleOptions(new Vector3f(f1, f2, f3), 1.0f), d2, d3, d4, 0.0, 0.0, 0.0);
            }
        }
    }
    
    private void activate(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        if (state.m_60734_() instanceof VanishingBlock && !this.isVanished(state) && !(boolean)state.m_61143_((Property)VanishingBlock.ACTIVE)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)VanishingBlock.ACTIVE, (Comparable)true));
            world.m_6219_().m_5945_(pos, (Object)state.m_60734_(), 2 + world.f_46441_.nextInt(5));
        }
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
        VANISHED = BooleanProperty.m_61465_("vanished");
        VANISHED_SHAPE = m_49796_(6.0, 6.0, 6.0, 10.0, 10.0, 10.0);
    }
}
