// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import twilightforest.TFConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class GiantLeavesBlock extends GiantBlock
{
    public GiantLeavesBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return (int)TFConfig.COMMON_CONFIG.PERFORMANCE.leavesLightOpacity.get();
    }
    
    public boolean canCreatureSpawn(final BlockState state, final IBlockReader world, final BlockPos pos, final EntitySpawnPlacementRegistry.PlacementType type, @Nullable final EntityType<?> entityType) {
        return false;
    }
}
