// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import java.util.Random;

public class StructureTFQuestGroveStart extends pg
{
    public StructureTFQuestGroveStart(final xd world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        final ComponentTFQuestGrove questGrove = new ComponentTFQuestGrove(world, rand, 0, x, y, z);
        this.a.add(questGrove);
        questGrove.a((he)questGrove, (List)this.a, rand);
        this.c();
    }
}
