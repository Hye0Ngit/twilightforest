// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.TFTreasure;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdDeadEnd extends StructureTFStrongholdComponent
{
    private boolean chestTrapped;
    
    public ComponentTFStrongholdDeadEnd(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 6, 9, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, 1, sbb);
        this.placeWallStatue(world, 7, 1, 4, 3, sbb);
        this.placeWallStatue(world, 4, 1, 7, 0, sbb);
        this.placeDoors(world, rand, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 4, 1, 3, TFTreasure.stronghold_cache, this.chestTrapped, sbb);
        if (this.chestTrapped) {
            this.a(world, aqw.ar.cF, 0, 4, 0, 3, sbb);
        }
        for (int z = 2; z < 5; ++z) {
            this.a(world, this.deco.stairID, this.getStairMeta(0), 3, 1, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2), 5, 1, z, sbb);
        }
        this.a(world, this.deco.stairID, this.getStairMeta(1), 4, 1, 2, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(3), 4, 1, 4, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(1), 4, 2, 3, sbb);
        return true;
    }
}
