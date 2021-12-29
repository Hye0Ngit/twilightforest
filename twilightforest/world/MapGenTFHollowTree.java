// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.structures.StructureTFHollowTreeStart;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.MapGenStructure;

public class MapGenTFHollowTree extends MapGenStructure
{
    protected boolean func_75047_a(final int chunkX, final int chunkZ) {
        return false;
    }
    
    protected StructureStart func_75049_b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowTreeStart(this.field_75039_c, this.field_75038_b, chunkX, chunkZ);
    }
}
