// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.TFTreasure;
import twilightforest.entity.TFCreatures;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdTreasureRoom extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public ComponentTFStrongholdTreasureRoom(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return age.a(x, y, z, -4, -1, 0, 9, 7, 18, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addDoor(4, 1, 0);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 17, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, 1, sbb);
        this.placeWallStatue(world, 1, 1, 13, 1, sbb);
        this.placeWallStatue(world, 7, 1, 4, 3, sbb);
        this.placeWallStatue(world, 7, 1, 13, 3, sbb);
        this.placeWallStatue(world, 4, 1, 16, 0, sbb);
        this.a(world, sbb, 1, 1, 8, 7, 5, 9, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 3, 1, 8, 5, 4, 9, aqw.bu.cF, 0, false);
        this.placeSpawnerAtCurrentPosition(world, rand, 4, 1, 4, TFCreatures.getSpawnerNameFor("Helmet Crab"), sbb);
        this.placeSpawnerAtCurrentPosition(world, rand, 4, 4, 15, TFCreatures.getSpawnerNameFor("Helmet Crab"), sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 2, 4, 13, TFTreasure.stronghold_room, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 6, 4, 13, TFTreasure.stronghold_room, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    @Override
    protected void placeDoorwayAt(final abv world, final Random rand, final int x, final int y, final int z, final age sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.a(world, sbb, x, y, z - 1, x, y + 3, z + 1, aqw.bu.cF, 0, 0, 0, false);
        }
        else {
            this.a(world, sbb, x - 1, y, z, x + 1, y + 3, z, aqw.bu.cF, 0, 0, 0, false);
        }
    }
}
