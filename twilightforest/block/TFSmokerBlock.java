// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import twilightforest.block.entity.TFSmokerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.BaseEntityBlock;

public class TFSmokerBlock extends BaseEntityBlock
{
    protected TFSmokerBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new TFSmokerBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.SMOKER.get(), TFSmokerBlockEntity::tick);
    }
}
