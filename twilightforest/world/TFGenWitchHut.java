// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.entity.TFCreatures;
import java.util.Random;

public class TFGenWitchHut extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        return this.generateTinyHut(world, rand, x, y, z);
    }
    
    public boolean generateTinyHut(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 5, 7, 6)) {
            return false;
        }
        this.putBlock(world, x + 1, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 2, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 3, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 5, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 0, y + 0, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 1, y + 0, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 0, z + 2, this.randStone(rand, 1), true);
        this.putBlock(world, x + 0, y + 0, z + 3, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 0, z + 3, this.randStone(rand, 1), true);
        this.putBlock(world, x + 0, y + 0, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 1, y + 0, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 0, z + 4, this.randStone(rand, 1), true);
        this.putBlock(world, x + 1, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 2, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 3, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 5, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 1, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(world, x + 3, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(world, x + 5, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(world, x + 0, y + 1, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 1, y + 1, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 1, z + 2, this.randStone(rand, 2), true);
        this.putBlock(world, x + 0, y + 1, z + 3, aqw.aq.cF, true);
        this.putBlock(world, x + 0, y + 1, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 1, y + 1, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 1, z + 4, this.randStone(rand, 2), true);
        this.putBlock(world, x + 1, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(world, x + 3, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(world, x + 5, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(world, x + 1, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 2, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 3, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 4, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 5, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 2, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 1, y + 2, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 2, z + 2, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 2, z + 3, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 2, z + 3, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 2, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 1, y + 2, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 5, y + 2, z + 4, this.randStone(rand, 1), true);
        this.putBlock(world, x + 1, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 2, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 3, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 4, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 5, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 3, z + 2, aqw.aq.cF, true);
        this.putBlock(world, x + 0, y + 3, z + 3, aqw.aq.cF, true);
        this.putBlock(world, x + 0, y + 3, z + 4, aqw.aq.cF, true);
        this.putBlock(world, x + 2, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(world, x + 3, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(world, x + 4, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(world, x + 2, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(world, x + 3, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(world, x + 4, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(world, x + 0, y + 4, z + 3, aqw.aq.cF, true);
        this.putBlock(world, x + 3, y + 4, z + 1, this.randStone(rand, 5), true);
        this.putBlock(world, x + 3, y + 4, z + 5, this.randStone(rand, 5), true);
        this.putBlock(world, x + 0, y + 5, z + 3, aqw.aq.cF, true);
        this.putBlock(world, x + 0, y + 6, z + 3, aqw.aq.cF, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 2, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 3, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 4, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 2, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 4, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 2, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 3, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 4, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 4, z + 0, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 2, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 3, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 4, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 4, z + 6, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 4, z + 0, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 2, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 3, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 4, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 4, z + 6, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 0, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 1, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 0, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 1, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 2, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 3, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 4, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 5, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 6, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 5, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 6, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 0, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 1, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 2, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 4, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 5, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 6, aqw.ao.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 7, z + 0, aqw.ap.cF, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 7, z + 6, aqw.ap.cF, 2, true);
        this.putBlock(world, x + 1, y - 1, z + 3, aqw.bg.cF, true);
        this.putBlock(world, x + 1, y + 0, z + 3, aqw.aw.cF, true);
        world.f(x + 3, y + 1, z + 3, aqw.ax.cF, 0, 2);
        final asg ms = (asg)world.r(x + 3, y + 1, z + 3);
        ms.a().a(TFCreatures.getSpawnerNameFor("Skeleton Druid"));
        return true;
    }
}
