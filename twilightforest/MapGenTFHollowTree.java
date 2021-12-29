// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class MapGenTFHollowTree extends agt
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return false;
    }
    
    protected pg b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowTreeStart(this.d, this.c, chunkX, chunkZ);
    }
}
