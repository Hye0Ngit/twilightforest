// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class FlammableBlock extends Block
{
    private final int flammability;
    private final int spreadSpeed;
    
    public FlammableBlock(final int flammability, final int spreadSpeed, final AbstractBlock.Properties props) {
        super(props);
        this.flammability = flammability;
        this.spreadSpeed = spreadSpeed;
    }
    
    public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return this.flammability;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return this.spreadSpeed;
    }
}
