// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import javax.annotation.Nullable;
import java.util.Random;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.level.BlockGetter;
import twilightforest.block.entity.GhastTrapBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import java.util.Iterator;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.world.phys.AABB;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public class GhastTrapBlock extends BaseEntityBlock
{
    public static final int ACTIVATE_EVENT = 0;
    public static final int DEACTIVATE_EVENT = 1;
    public static final BooleanProperty ACTIVE;
    
    public GhastTrapBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)GhastTrapBlock.ACTIVE, (Comparable)false));
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)GhastTrapBlock.ACTIVE });
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.f_46443_) {
            return;
        }
        if (!(boolean)state.m_61143_((Property)GhastTrapBlock.ACTIVE) && this.isInactiveTrapCharged(world, pos) && world.m_46753_(pos)) {
            for (final ServerPlayer player : world.m_45976_((Class)ServerPlayer.class, new AABB(pos).m_82400_(6.0))) {
                TFAdvancements.ACTIVATED_GHAST_TRAP.trigger(player);
            }
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)GhastTrapBlock.ACTIVE, (Comparable)true));
            world.m_5594_((Player)null, pos, TFSounds.JET_START, SoundSource.BLOCKS, 0.3f, 0.6f);
            world.m_7696_(pos, (Block)this, 0, 0);
        }
    }
    
    public boolean m_8133_(final BlockState state, final Level world, final BlockPos pos, final int event, final int payload) {
        final BlockEntity te = world.m_7702_(pos);
        return te != null && te.m_7531_(event, payload);
    }
    
    private boolean isInactiveTrapCharged(final Level world, final BlockPos pos) {
        final BlockEntity tileEntity = world.m_7702_(pos);
        return tileEntity instanceof GhastTrapBlockEntity && ((GhastTrapBlockEntity)tileEntity).isCharged();
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
            if (d2 < pos.m_123341_() || d2 > pos.m_123341_() + 1 || d3 < 0.0 || d3 > pos.m_123342_() + 1 || d4 < pos.m_123343_() || d4 > pos.m_123343_() + 1) {
                worldIn.m_7106_((ParticleOptions)DustParticleOptions.f_123656_, d2, d3, d4, 0.0, 0.0, 0.0);
            }
        }
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new GhastTrapBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.GHAST_TRAP.get(), GhastTrapBlockEntity::tick);
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
    }
}
