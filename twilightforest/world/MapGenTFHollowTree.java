// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.structures.StructureTFHollowTreeStart;

public class MapGenTFHollowTree extends aeo
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return false;
    }
    
    protected aeu b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowTreeStart(this.c, this.b, chunkX, chunkZ);
    }
}
