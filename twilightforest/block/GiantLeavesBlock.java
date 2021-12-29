// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GiantLeavesBlock extends GiantBlock
{
    public GiantLeavesBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public boolean canCreatureSpawn(final BlockState state, final BlockGetter world, final BlockPos pos, final SpawnPlacements.Type type, @Nullable final EntityType<?> entityType) {
        return false;
    }
}
