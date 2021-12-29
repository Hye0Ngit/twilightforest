// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;

public class TFSignBlockEntity extends SignBlockEntity
{
    public TFSignBlockEntity(final BlockPos p_155700_, final BlockState p_155701_) {
        super(p_155700_, p_155701_);
    }
    
    public BlockEntityType<?> m_58903_() {
        return (BlockEntityType<?>)TFBlockEntities.TF_SIGN.get();
    }
}
