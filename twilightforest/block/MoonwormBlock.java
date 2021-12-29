// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import twilightforest.block.entity.MoonwormBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MoonwormBlock extends CritterBlock
{
    protected MoonwormBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    public float getWidth() {
        return 0.25f;
    }
    
    @Nullable
    @Override
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new MoonwormBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.MOONWORM.get(), MoonwormBlockEntity::tick);
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack((ItemLike)Items.f_42540_, 1);
    }
}
