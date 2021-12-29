// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import twilightforest.block.entity.TFSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;

public class TFWallSignBlock extends WallSignBlock
{
    public TFWallSignBlock(final BlockBehaviour.Properties properties, final WoodType type) {
        super(properties, type);
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return (BlockEntity)new TFSignBlockEntity(pos, state);
    }
}
