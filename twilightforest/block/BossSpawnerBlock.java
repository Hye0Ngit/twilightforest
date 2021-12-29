// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import twilightforest.enums.BossVariant;
import net.minecraft.block.Block;

public class BossSpawnerBlock extends Block
{
    private final BossVariant boss;
    
    protected BossSpawnerBlock(final AbstractBlock.Properties props, final BossVariant variant) {
        super(props);
        this.boss = variant;
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return this.boss.hasSpawner();
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader reader) {
        return this.boss.getSpawner();
    }
    
    public boolean canEntityDestroy(final BlockState state, final IBlockReader world, final BlockPos pos, final Entity entity) {
        return state.func_185887_b(world, pos) >= 0.0f;
    }
}
