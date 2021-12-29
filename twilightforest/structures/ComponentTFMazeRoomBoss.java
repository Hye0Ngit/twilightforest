// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.entity.EntityTFMinoshroom;
import twilightforest.TFTreasure;
import java.util.Random;

public class ComponentTFMazeRoomBoss extends ComponentTFMazeRoom
{
    private boolean taurPlaced;
    
    public ComponentTFMazeRoomBoss(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
        this.taurPlaced = false;
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        if (this.a(world, 7, 1, 0, sbb) == 0) {
            this.a(world, sbb, 6, 1, 0, 9, 4, 0, aqw.be.cF, 0, false);
        }
        if (this.a(world, 7, 1, 15, sbb) == 0) {
            this.a(world, sbb, 6, 1, 15, 9, 4, 15, aqw.be.cF, 0, false);
        }
        if (this.a(world, 0, 1, 7, sbb) == 0) {
            this.a(world, sbb, 0, 1, 6, 0, 4, 9, aqw.be.cF, 0, false);
        }
        if (this.a(world, 15, 1, 7, sbb) == 0) {
            this.a(world, sbb, 15, 1, 6, 15, 4, 9, aqw.be.cF, 0, false);
        }
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                final boolean mycelium = rand.nextInt(dist + 1) > 0;
                final boolean mushroom = rand.nextInt(dist) > 0;
                final boolean mushRed = rand.nextBoolean();
                if (mycelium) {
                    this.a(world, aqw.bD.cF, 0, x, 0, z, sbb);
                }
                if (mushroom) {
                    this.a(world, mushRed ? aqw.al.cF : aqw.ak.cF, 0, x, 1, z, sbb);
                }
            }
        }
        this.a(world, sbb, 1, 1, 1, 3, 1, 3, aqw.bt.cF, 14, 0, 0, false);
        this.a(world, sbb, 1, 2, 1, 1, 3, 4, aqw.bt.cF, 14, 0, 0, false);
        this.a(world, sbb, 2, 2, 1, 4, 3, 1, aqw.bt.cF, 14, 0, 0, false);
        this.a(world, sbb, 1, 4, 1, 3, 4, 3, aqw.bt.cF, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.a(world, sbb, 12, 1, 12, 14, 1, 14, aqw.bt.cF, 14, 0, 0, false);
        this.a(world, sbb, 14, 2, 11, 14, 3, 14, aqw.bt.cF, 14, 0, 0, false);
        this.a(world, sbb, 11, 2, 14, 14, 3, 14, aqw.bt.cF, 14, 0, 0, false);
        this.a(world, sbb, 12, 4, 12, 14, 4, 14, aqw.bt.cF, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 12, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.a(world, sbb, 1, 1, 12, 3, 1, 14, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 1, 2, 11, 1, 3, 14, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 2, 2, 14, 4, 3, 14, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 1, 4, 12, 3, 4, 14, aqw.bs.cF, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.a(world, sbb, 12, 1, 1, 14, 1, 3, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 11, 2, 1, 14, 3, 1, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 14, 2, 2, 14, 3, 4, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 12, 4, 1, 14, 4, 3, aqw.bs.cF, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 12, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.a(world, sbb, 5, 4, 5, 7, 5, 7, aqw.bs.cF, 14, 0, 0, false);
        this.a(world, sbb, 8, 4, 8, 10, 5, 10, aqw.bt.cF, 14, 0, 0, false);
        if (!this.taurPlaced) {
            final int bx = this.a(7, 7);
            final int by = this.a(1);
            final int bz = this.b(7, 7);
            if (sbb.b(bx, by, bz)) {
                this.taurPlaced = true;
                final EntityTFMinoshroom taur = new EntityTFMinoshroom(world);
                taur.b((double)bx, (double)by, (double)bz);
                taur.b(bx, by, bz, 7);
                world.d((nm)taur);
            }
        }
        return true;
    }
}
