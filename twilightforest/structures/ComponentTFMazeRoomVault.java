// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFTreasure;
import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFMazeRoomVault extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomVault(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.a(world, sbb, 0, 1, 0, 15, 4, 15, TFBlocks.mazestone.cF, 3, 0, 0, false);
        this.a(world, sbb, 0, 2, 0, 15, 3, 15, TFBlocks.mazestone.cF, 1, 0, 0, false);
        this.a(world, sbb, 6, 2, 6, 9, 3, 9);
        this.a(world, sbb, 6, 2, 5, 9, 2, 5, aqw.aR.cF, 0, 0, 0, false);
        this.a(world, sbb, 6, 2, 10, 9, 2, 10, aqw.aR.cF, 0, 0, 0, false);
        this.a(world, sbb, 5, 2, 6, 5, 2, 9, aqw.aR.cF, 0, 0, 0, false);
        this.a(world, sbb, 10, 2, 6, 10, 2, 9, aqw.aR.cF, 0, 0, 0, false);
        this.a(world, sbb, 6, 4, 5, 9, 4, 5, aqw.J.cF, 0, 0, 0, false);
        this.a(world, sbb, 6, 4, 10, 9, 4, 10, aqw.J.cF, 0, 0, 0, false);
        this.a(world, sbb, 5, 4, 6, 5, 4, 9, aqw.J.cF, 0, 0, 0, false);
        this.a(world, sbb, 10, 4, 6, 10, 4, 9, aqw.J.cF, 0, 0, 0, false);
        this.a(world, sbb, 6, 0, 5, 9, 0, 5, aqw.ar.cF, 0, 0, 0, false);
        this.a(world, sbb, 6, 0, 10, 9, 0, 10, aqw.ar.cF, 0, 0, 0, false);
        this.a(world, sbb, 5, 0, 6, 5, 0, 9, aqw.ar.cF, 0, 0, 0, false);
        this.a(world, sbb, 10, 0, 6, 10, 0, 9, aqw.ar.cF, 0, 0, 0, false);
        this.a(world, aqw.az.cF, 0, 7, 2, 6, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 8, 2, 6, TFTreasure.labyrinth_vault, sbb);
        this.a(world, aqw.az.cF, 0, 8, 2, 9, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 7, 2, 9, TFTreasure.labyrinth_vault, sbb);
        this.a(world, aqw.az.cF, 0, 6, 2, 7, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 6, 2, 8, TFTreasure.labyrinth_vault, sbb);
        this.a(world, aqw.az.cF, 0, 9, 2, 8, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 9, 2, 7, TFTreasure.labyrinth_vault, sbb);
        return true;
    }
}
