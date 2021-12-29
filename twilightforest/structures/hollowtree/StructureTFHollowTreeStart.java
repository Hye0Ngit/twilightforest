// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import twilightforest.structures.StructureTFComponent;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.world.TFWorld;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureTFHollowTreeStart extends StructureStart
{
    public StructureTFHollowTreeStart() {
    }
    
    public StructureTFHollowTreeStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        final StructureTFComponent trunk = new ComponentTFHollowTreeTrunk(world, rand, 0, x, y, z);
        this.field_75075_a.add(trunk);
        trunk.func_74861_a((StructureComponent)trunk, (List)this.field_75075_a, rand);
        this.func_75072_c();
    }
}
