// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.DustParticleOptions;
import com.mojang.math.Vector3f;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.Direction;
import java.util.Objects;
import twilightforest.block.entity.CarminiteBuilderBlockEntity;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import twilightforest.enums.TowerDeviceVariant;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public class BuilderBlock extends BaseEntityBlock
{
    public static final EnumProperty<TowerDeviceVariant> STATE;
    
    public BuilderBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)BuilderBlock.STATE });
    }
    
    @Deprecated
    public void m_6807_(final BlockState state, final Level world, final BlockPos pos, final BlockState oldState, final boolean isMoving) {
        if (!world.f_46443_ && state.m_61143_((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_INACTIVE && world.m_46753_(pos)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE));
            world.m_5594_((Player)null, pos, TFSounds.BUILDER_ON, SoundSource.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.f_46443_) {
            return;
        }
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.m_61143_((Property)BuilderBlock.STATE);
        if (variant == TowerDeviceVariant.BUILDER_INACTIVE && world.m_46753_(pos)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE));
            world.m_5594_((Player)null, pos, TFSounds.BUILDER_ON, SoundSource.BLOCKS, 0.3f, 0.6f);
            world.m_6219_().m_5945_(pos, (Object)this, 4);
        }
        if (variant == TowerDeviceVariant.BUILDER_ACTIVE && !world.m_46753_(pos)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
            world.m_5594_((Player)null, pos, TFSounds.BUILDER_OFF, SoundSource.BLOCKS, 0.3f, 0.6f);
            world.m_6219_().m_5945_(pos, (Object)this, 4);
        }
        if (variant == TowerDeviceVariant.BUILDER_TIMEOUT && !world.m_46753_(pos)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
        }
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.m_61143_((Property)BuilderBlock.STATE);
        if (variant == TowerDeviceVariant.BUILDER_ACTIVE && world.m_46753_(pos)) {
            this.letsBuild((Level)world, pos);
        }
        if (variant == TowerDeviceVariant.BUILDER_INACTIVE || variant == TowerDeviceVariant.BUILDER_TIMEOUT) {
            Objects.requireNonNull(world.m_7702_(pos)).resetStats();
            for (final Direction e : Direction.values()) {
                activateBuiltBlocks((Level)world, pos.m_142300_(e));
            }
        }
    }
    
    private void letsBuild(final Level world, final BlockPos pos) {
        final CarminiteBuilderBlockEntity tileEntity = (CarminiteBuilderBlockEntity)world.m_7702_(pos);
        if (tileEntity != null && !tileEntity.makingBlocks) {
            tileEntity.startBuilding();
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random random) {
        if (state.m_61143_((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_ACTIVE) {
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
    
    public static void activateBuiltBlocks(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        if (state.m_60734_() == TFBlocks.BUILT_BLOCK.get() && !(boolean)state.m_61143_((Property)TranslucentBuiltBlock.ACTIVE)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)true));
            world.m_5594_((Player)null, pos, TFSounds.BUILDER_REPLACE, SoundSource.BLOCKS, 0.3f, 0.6f);
            world.m_6219_().m_5945_(pos, (Object)state.m_60734_(), 10);
        }
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new CarminiteBuilderBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)((state.m_61143_((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_ACTIVE) ? m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.TOWER_BUILDER.get(), CarminiteBuilderBlockEntity::tick) : null);
    }
    
    static {
        STATE = EnumProperty.m_61587_("state", (Class)TowerDeviceVariant.class);
    }
}
