// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.chunk.ChunkPrimer;

public class DirectChunkPrimer extends ChunkPrimer
{
    private static final IBlockState DEFAULT_STATE;
    private final IBlockState[] states;
    
    public DirectChunkPrimer() {
        this.states = new IBlockState[65536];
    }
    
    public IBlockState func_177856_a(final int x, final int y, final int z) {
        final IBlockState state = this.states[getBlockIndex(x, y, z)];
        return (state == null) ? DirectChunkPrimer.DEFAULT_STATE : state;
    }
    
    public void func_177855_a(final int x, final int y, final int z, final IBlockState state) {
        this.states[getBlockIndex(x, y, z)] = state;
    }
    
    private static int getBlockIndex(final int x, final int y, final int z) {
        return x << 12 | z << 8 | y;
    }
    
    static {
        DEFAULT_STATE = Blocks.field_150350_a.func_176223_P();
    }
}
