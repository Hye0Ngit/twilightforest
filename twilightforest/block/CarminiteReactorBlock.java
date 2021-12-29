// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import javax.annotation.Nullable;
import twilightforest.block.entity.CarminiteReactorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import java.util.Arrays;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public class CarminiteReactorBlock extends BaseEntityBlock
{
    public static final BooleanProperty ACTIVE;
    
    public CarminiteReactorBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)CarminiteReactorBlock.ACTIVE, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)CarminiteReactorBlock.ACTIVE });
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.f_46443_) {
            return;
        }
        if (!(boolean)state.m_61143_((Property)CarminiteReactorBlock.ACTIVE) && this.isReactorReady(world, pos)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)CarminiteReactorBlock.ACTIVE, (Comparable)true));
        }
    }
    
    private boolean isReactorReady(final Level world, final BlockPos pos) {
        return Arrays.stream(Direction.values()).allMatch(e -> world.m_8055_(pos.m_142300_(e)).m_60734_() == Blocks.f_50330_);
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new CarminiteReactorBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.CARMINITE_REACTOR.get(), CarminiteReactorBlockEntity::tick);
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
    }
}
