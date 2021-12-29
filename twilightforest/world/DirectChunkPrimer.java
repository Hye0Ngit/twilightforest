// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.palette.UpgradeData;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.chunk.ChunkPrimer;

public class DirectChunkPrimer extends ChunkPrimer
{
    private static final BlockState DEFAULT_STATE;
    private final BlockState[] states;
    
    public DirectChunkPrimer(final ChunkPos pos) {
        super(pos, UpgradeData.field_196994_a);
        this.states = new BlockState[65536];
    }
    
    public BlockState func_180495_p(final BlockPos pos) {
        final BlockState state = this.states[getBlockIndex(pos)];
        return (state == null) ? DirectChunkPrimer.DEFAULT_STATE : state;
    }
    
    public BlockState func_177436_a(final BlockPos pos, final BlockState state, final boolean isMoving) {
        return this.states[getBlockIndex(pos)] = state;
    }
    
    private static int getBlockIndex(final BlockPos pos) {
        return pos.func_177958_n() << 12 | pos.func_177952_p() << 8 | pos.func_177956_o();
    }
    
    static {
        DEFAULT_STATE = Blocks.field_150350_a.func_176223_P();
    }
}
