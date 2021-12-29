// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class FlammableBlock extends Block
{
    private final int flammability;
    private final int spreadSpeed;
    
    public FlammableBlock(final int flammability, final int spreadSpeed, final BlockBehaviour.Properties props) {
        super(props);
        this.flammability = flammability;
        this.spreadSpeed = spreadSpeed;
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return this.flammability;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return this.spreadSpeed;
    }
}
