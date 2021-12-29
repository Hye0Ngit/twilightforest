// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeMushRoom extends ComponentTFMazeRoom
{
    public ComponentTFMazeMushRoom(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
        this.f = 0;
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        super.a(world, rand, sbb);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                if (rand.nextInt(dist + 1) > 0) {
                    this.a(world, amq.bB.cm, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(dist) > 0) {
                    this.a(world, rand.nextBoolean() ? amq.aj.cm : amq.ai.cm, 0, x, 1, z, sbb);
                }
            }
        }
        this.makeMediumMushroom(world, sbb, 5, 2, 9, amq.br.cm);
        this.makeMediumMushroom(world, sbb, 5, 3, 9, amq.br.cm);
        this.makeMediumMushroom(world, sbb, 9, 2, 5, amq.br.cm);
        this.makeMediumMushroom(world, sbb, 6, 3, 4, amq.bq.cm);
        this.makeMediumMushroom(world, sbb, 10, 1, 9, amq.bq.cm);
        this.a(world, amq.br.cm, 15, 1, 2, 1, sbb);
        this.a(world, amq.br.cm, 5, 1, 3, 1, sbb);
        this.a(world, amq.br.cm, 9, 2, 3, 1, sbb);
        this.a(world, amq.br.cm, 9, 1, 3, 2, sbb);
        this.a(world, amq.bq.cm, 15, 14, 3, 1, sbb);
        this.a(world, amq.bq.cm, 5, 14, 4, 1, sbb);
        this.a(world, amq.bq.cm, 7, 13, 4, 1, sbb);
        this.a(world, amq.bq.cm, 7, 14, 4, 2, sbb);
        this.a(world, amq.bq.cm, 15, 1, 1, 14, sbb);
        this.a(world, amq.bq.cm, 5, 1, 2, 14, sbb);
        this.a(world, amq.bq.cm, 3, 2, 2, 14, sbb);
        this.a(world, amq.bq.cm, 3, 1, 2, 13, sbb);
        this.a(world, amq.bq.cm, 5, 14, 1, 14, sbb);
        this.a(world, amq.bq.cm, 1, 13, 1, 14, sbb);
        this.a(world, amq.bq.cm, 1, 14, 1, 13, sbb);
        return true;
    }
    
    private void makeMediumMushroom(final yc world, final acn sbb, final int mx, final int my, final int mz, final int blockID) {
        this.a(world, blockID, 5, mx + 0, my, mz + 0, sbb);
        this.a(world, blockID, 6, mx + 1, my, mz + 0, sbb);
        this.a(world, blockID, 9, mx + 1, my, mz + 1, sbb);
        this.a(world, blockID, 8, mx + 0, my, mz + 1, sbb);
        this.a(world, blockID, 7, mx - 1, my, mz + 1, sbb);
        this.a(world, blockID, 4, mx - 1, my, mz + 0, sbb);
        this.a(world, blockID, 1, mx - 1, my, mz - 1, sbb);
        this.a(world, blockID, 2, mx + 0, my, mz - 1, sbb);
        this.a(world, blockID, 3, mx + 1, my, mz - 1, sbb);
        for (int y = 1; y < my; ++y) {
            this.a(world, blockID, 10, mx + 0, y, mz + 0, sbb);
        }
    }
}
