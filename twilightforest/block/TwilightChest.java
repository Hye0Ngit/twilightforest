// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.block.entity.TwilightChestEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import java.util.function.Supplier;
import java.util.Objects;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.ChestBlock;

public class TwilightChest extends ChestBlock
{
    public TwilightChest(final BlockBehaviour.Properties properties) {
        final RegistryObject<BlockEntityType<TwilightChestEntity>> tf_CHEST = TFBlockEntities.TF_CHEST;
        Objects.requireNonNull(tf_CHEST);
        super(properties, (Supplier)tf_CHEST::get);
    }
    
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return (BlockEntity)new TwilightChestEntity(pos, state);
    }
}
