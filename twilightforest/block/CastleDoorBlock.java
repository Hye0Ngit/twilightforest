// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.AABB;
import net.minecraft.core.particles.ParticleOptions;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.material.PushReaction;
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

public class CastleDoorBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    public static final BooleanProperty VANISHED;
    private static final VoxelShape REAPPEARING_BB;
    
    public CastleDoorBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)CastleDoorBlock.ACTIVE, (Comparable)false)).m_61124_((Property)CastleDoorBlock.VANISHED, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)CastleDoorBlock.ACTIVE, (Property)CastleDoorBlock.VANISHED });
    }
    
    @Deprecated
    public VoxelShape m_5939_(final BlockState state, final BlockGetter world, final BlockPos pos, final CollisionContext context) {
        return state.m_61143_((Property)CastleDoorBlock.VANISHED) ? Shapes.m_83040_() : super.m_5939_(state, world, pos, context);
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter world, final BlockPos pos, final CollisionContext context) {
        return state.m_61143_((Property)CastleDoorBlock.VANISHED) ? CastleDoorBlock.REAPPEARING_BB : super.m_5940_(state, world, pos, context);
    }
    
    @Deprecated
    public InteractionResult m_6227_(final BlockState state, final Level world, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        return this.onActivation(world, pos, state);
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block block, final BlockPos fromPos, final boolean isMoving) {
        if (!(block instanceof CastleDoorBlock) && world.m_46753_(pos)) {
            this.onActivation(world, pos, state);
        }
    }
    
    public PushReaction m_5537_(final BlockState pState) {
        return PushReaction.BLOCK;
    }
    
    private InteractionResult onActivation(final Level world, final BlockPos pos, final BlockState state) {
        if ((boolean)state.m_61143_((Property)CastleDoorBlock.VANISHED) || (boolean)state.m_61143_((Property)CastleDoorBlock.ACTIVE)) {
            return InteractionResult.FAIL;
        }
        if (isBlockLocked(world, pos)) {
            world.m_5594_((Player)null, pos, TFSounds.DOOR_ACTIVATED, SoundSource.BLOCKS, 1.0f, 0.3f);
            return InteractionResult.PASS;
        }
        changeToActiveBlock(world, pos, state);
        return InteractionResult.SUCCESS;
    }
    
    private static void changeToActiveBlock(final Level world, final BlockPos pos, final BlockState originState) {
        if (originState.m_60734_() instanceof CastleDoorBlock) {
            world.m_46597_(pos, (BlockState)originState.m_61124_((Property)CastleDoorBlock.ACTIVE, (Comparable)true));
        }
        world.m_6219_().m_5945_(pos, (Object)originState.m_60734_(), 2 + world.f_46441_.nextInt(5));
    }
    
    private static boolean isBlockLocked(final Level world, final BlockPos pos) {
        if (!world.f_46443_) {
            WorldUtil.getChunkGenerator((LevelAccessor)world);
        }
        return false;
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        if (state.m_61143_((Property)CastleDoorBlock.VANISHED)) {
            if (state.m_61143_((Property)CastleDoorBlock.ACTIVE)) {
                world.m_46597_(pos, (BlockState)((BlockState)state.m_61124_((Property)CastleDoorBlock.VANISHED, (Comparable)false)).m_61124_((Property)CastleDoorBlock.ACTIVE, (Comparable)false));
            }
            else {
                changeToActiveBlock((Level)world, pos, state);
            }
            playReappearSound((Level)world, pos);
        }
        else if (state.m_61143_((Property)CastleDoorBlock.ACTIVE)) {
            world.m_46597_(pos, (BlockState)((BlockState)state.m_61124_((Property)CastleDoorBlock.VANISHED, (Comparable)true)).m_61124_((Property)CastleDoorBlock.ACTIVE, (Comparable)false));
            world.m_6219_().m_5945_(pos, (Object)this, 80);
            playVanishSound((Level)world, pos);
            vanishParticles((Level)world, pos);
            for (final Direction e : Direction.values()) {
                checkAndActivateCastleDoor((Level)world, pos.m_142300_(e));
            }
        }
    }
    
    private static void playVanishSound(final Level world, final BlockPos pos) {
        world.m_5594_((Player)null, pos, TFSounds.DOOR_VANISH, SoundSource.BLOCKS, 0.125f, world.f_46441_.nextFloat() * 0.25f + 1.75f);
    }
    
    private static void playReappearSound(final Level world, final BlockPos pos) {
        world.m_5594_((Player)null, pos, TFSounds.DOOR_REAPPEAR, SoundSource.BLOCKS, 0.125f, world.f_46441_.nextFloat() * 0.25f + 1.25f);
    }
    
    public static void checkAndActivateCastleDoor(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        if (state.m_60734_() instanceof CastleDoorBlock && !(boolean)state.m_61143_((Property)CastleDoorBlock.VANISHED) && !(boolean)state.m_61143_((Property)CastleDoorBlock.ACTIVE) && !isBlockLocked(world, pos)) {
            changeToActiveBlock(world, pos, state);
        }
    }
    
    private static void vanishParticles(final Level world, final BlockPos pos) {
        final Random rand = world.m_5822_();
        if (world instanceof final ServerLevel serverLevel) {
            for (int dx = 0; dx < 4; ++dx) {
                for (int dy = 0; dy < 4; ++dy) {
                    for (int dz = 0; dz < 4; ++dz) {
                        final double x = pos.m_123341_() + (dx + 0.5) / 4.0;
                        final double y = pos.m_123342_() + (dy + 0.5) / 4.0;
                        final double z = pos.m_123343_() + (dz + 0.5) / 4.0;
                        final double speed = rand.nextGaussian() * 0.2;
                        serverLevel.m_8767_((ParticleOptions)TFParticleType.ANNIHILATE.get(), x, y, z, 1, 0.0, 0.0, 0.0, speed);
                    }
                }
            }
        }
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
        VANISHED = BooleanProperty.m_61465_("vanish");
        REAPPEARING_BB = Shapes.m_83064_(new AABB(0.375, 0.375, 0.375, 0.625, 0.625, 0.625));
    }
}
