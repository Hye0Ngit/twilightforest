// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public class ChunkBitArray
{
    private static final int CHUNK_SIZE = 65536;
    private static final int BITS_PER_WORD = 6;
    private final long[] words;
    
    public ChunkBitArray() {
        this.words = new long[8192];
    }
    
    public void set(final int index) {
        final long[] words = this.words;
        final int n = index >> 6;
        words[n] |= 1L << index;
    }
    
    public void set(final int index, final boolean value) {
        if (value) {
            this.set(index);
        }
        else {
            this.clear(index);
        }
    }
    
    public void clear(final int index) {
        final long[] words = this.words;
        final int n = index >> 6;
        words[n] &= ~(1L << index);
    }
    
    public boolean get(final int index) {
        return (this.words[index >> 6] & 1L << index) != 0x0L;
    }
}
