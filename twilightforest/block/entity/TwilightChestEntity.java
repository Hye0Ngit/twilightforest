// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

public class TwilightChestEntity extends ChestBlockEntity
{
    public TwilightChestEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.TF_CHEST.get(), pos, state);
    }
}
