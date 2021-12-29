// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import twilightforest.TFTreasure;
import twilightforest.entity.TFCreatures;
import java.util.Random;

public class ComponentTFMazeRoomSpawnerChests extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomSpawnerChests(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        super.a(world, rand, sbb);
        this.placePillarEnclosure(world, sbb, 3, 3);
        this.placePillarEnclosure(world, sbb, 10, 3);
        this.placePillarEnclosure(world, sbb, 3, 10);
        this.placePillarEnclosure(world, sbb, 10, 10);
        this.placeSpawnerAtCurrentPosition(world, rand, 4, 2, 4, TFCreatures.getSpawnerNameFor("Minotaur"), sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 4, 2, 11, TFTreasure.labyrinth_room, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 11, 2, 4, TFTreasure.labyrinth_room, sbb);
        this.a(world, amq.aP.cm, 0, 11, 1, 11, sbb);
        this.a(world, amq.ap.cm, 0, 10, 0, 11, sbb);
        this.a(world, amq.ap.cm, 0, 11, 0, 10, sbb);
        this.a(world, amq.ap.cm, 0, 11, 0, 12, sbb);
        this.a(world, amq.ap.cm, 0, 12, 0, 11, sbb);
        return true;
    }
    
    private void placePillarEnclosure(final yc world, final acn sbb, final int dx, final int dz) {
        for (int y = 1; y < 5; ++y) {
            this.a(world, TFBlocks.mazestone.cm, 2, dx + 0, y, dz + 0, sbb);
            this.a(world, TFBlocks.mazestone.cm, 2, dx + 2, y, dz + 0, sbb);
            this.a(world, TFBlocks.mazestone.cm, 2, dx + 0, y, dz + 2, sbb);
            this.a(world, TFBlocks.mazestone.cm, 2, dx + 2, y, dz + 2, sbb);
        }
        this.a(world, amq.A.cm, 0, dx + 1, 1, dz + 1, sbb);
        this.a(world, amq.A.cm, 0, dx + 1, 4, dz + 1, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(1), dx + 1, 1, dz + 0, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(0), dx + 0, 1, dz + 1, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(2), dx + 2, 1, dz + 1, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(3), dx + 1, 1, dz + 2, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(1) + 4, dx + 1, 4, dz + 0, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(0) + 4, dx + 0, 4, dz + 1, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(2) + 4, dx + 2, 4, dz + 1, sbb);
        this.a(world, amq.aw.cm, this.getStairMeta(3) + 4, dx + 1, 4, dz + 2, sbb);
        this.a(world, amq.bs.cm, 0, dx + 1, 2, dz + 0, sbb);
        this.a(world, amq.bs.cm, 0, dx + 0, 2, dz + 1, sbb);
        this.a(world, amq.bs.cm, 0, dx + 2, 2, dz + 1, sbb);
        this.a(world, amq.bs.cm, 0, dx + 1, 2, dz + 2, sbb);
        this.a(world, amq.bs.cm, 0, dx + 1, 3, dz + 0, sbb);
        this.a(world, amq.bs.cm, 0, dx + 0, 3, dz + 1, sbb);
        this.a(world, amq.bs.cm, 0, dx + 2, 3, dz + 1, sbb);
        this.a(world, amq.bs.cm, 0, dx + 1, 3, dz + 2, sbb);
    }
}
