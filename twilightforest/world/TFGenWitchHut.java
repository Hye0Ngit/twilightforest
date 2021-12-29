// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFCreatures;
import java.util.Random;

public class TFGenWitchHut extends TFGenerator
{
    @Override
    public boolean a(final xv world, final Random rand, final int x, final int y, final int z) {
        return this.generateTinyHut(world, rand, x, y, z);
    }
    
    public boolean generateTinyHut(final xv world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 5, 7, 6)) {
            return false;
        }
        this.putBlock(x + 1, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 2, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 3, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 5, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 0, y + 0, z + 2, amj.ao.cm, true);
        this.putBlock(x + 1, y + 0, z + 2, amj.ao.cm, true);
        this.putBlock(x + 5, y + 0, z + 2, this.randStone(rand, 1), true);
        this.putBlock(x + 0, y + 0, z + 3, amj.ao.cm, true);
        this.putBlock(x + 5, y + 0, z + 3, this.randStone(rand, 1), true);
        this.putBlock(x + 0, y + 0, z + 4, amj.ao.cm, true);
        this.putBlock(x + 1, y + 0, z + 4, amj.ao.cm, true);
        this.putBlock(x + 5, y + 0, z + 4, this.randStone(rand, 1), true);
        this.putBlock(x + 1, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 2, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 3, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 5, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 1, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(x + 3, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(x + 5, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(x + 0, y + 1, z + 2, amj.ao.cm, true);
        this.putBlock(x + 1, y + 1, z + 2, amj.ao.cm, true);
        this.putBlock(x + 5, y + 1, z + 2, this.randStone(rand, 2), true);
        this.putBlock(x + 0, y + 1, z + 3, amj.ao.cm, true);
        this.putBlock(x + 0, y + 1, z + 4, amj.ao.cm, true);
        this.putBlock(x + 1, y + 1, z + 4, amj.ao.cm, true);
        this.putBlock(x + 5, y + 1, z + 4, this.randStone(rand, 2), true);
        this.putBlock(x + 1, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(x + 3, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(x + 5, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(x + 1, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 2, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 3, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 4, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 5, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 2, z + 2, amj.ao.cm, true);
        this.putBlock(x + 1, y + 2, z + 2, amj.ao.cm, true);
        this.putBlock(x + 5, y + 2, z + 2, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 2, z + 3, amj.ao.cm, true);
        this.putBlock(x + 5, y + 2, z + 3, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 2, z + 4, amj.ao.cm, true);
        this.putBlock(x + 1, y + 2, z + 4, amj.ao.cm, true);
        this.putBlock(x + 5, y + 2, z + 4, this.randStone(rand, 1), true);
        this.putBlock(x + 1, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 2, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 3, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 4, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 5, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 3, z + 2, amj.ao.cm, true);
        this.putBlock(x + 0, y + 3, z + 3, amj.ao.cm, true);
        this.putBlock(x + 0, y + 3, z + 4, amj.ao.cm, true);
        this.putBlock(x + 2, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(x + 3, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(x + 4, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(x + 2, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(x + 3, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(x + 4, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(x + 0, y + 4, z + 3, amj.ao.cm, true);
        this.putBlock(x + 3, y + 4, z + 1, this.randStone(rand, 5), true);
        this.putBlock(x + 3, y + 4, z + 5, this.randStone(rand, 5), true);
        this.putBlock(x + 0, y + 5, z + 3, amj.ao.cm, true);
        this.putBlock(x + 0, y + 6, z + 3, amj.ao.cm, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 2, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 3, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 4, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 2, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 4, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 2, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 3, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 4, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 4, z + 0, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 2, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 3, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 4, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 1, y + 4, z + 6, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 4, z + 0, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 2, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 3, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 4, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 5, y + 4, z + 6, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 0, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 1, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 0, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 1, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 2, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 3, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 4, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 5, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 6, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 5, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 6, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 0, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 1, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 2, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 4, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 5, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 6, amj.am.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 7, z + 0, amj.an.cm, 2, true);
        this.putBlockAndMetadata(x + 3, y + 7, z + 6, amj.an.cm, 2, true);
        this.putBlock(x + 1, y - 1, z + 3, amj.be.cm, true);
        this.putBlock(x + 1, y + 0, z + 3, amj.au.cm, true);
        this.worldObj.e(x + 3, y + 1, z + 3, amj.av.cm);
        final anl ms = (anl)world.q(x + 3, y + 1, z + 3);
        ms.a(TFCreatures.getSpawnerNameFor("Skeleton Druid"));
        return true;
    }
}
