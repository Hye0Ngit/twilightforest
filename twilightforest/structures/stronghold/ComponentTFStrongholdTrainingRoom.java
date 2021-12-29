// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdTrainingRoom extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdTrainingRoom(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 18, 7, 18, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addDoor(13, 1, 0);
        this.addNewComponent(parent, list, random, 0, 4, 1, 18);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.a(world, sbb, rand, 0.7f, 4, 0, 4, 8, 0, 8, aqw.J.cF, aqw.J.cF, false);
        this.a(world, sbb, rand, 0.7f, 9, 0, 4, 13, 0, 8, aqw.J.cF, aqw.J.cF, false);
        this.a(world, sbb, rand, 0.7f, 9, 0, 9, 13, 0, 13, aqw.J.cF, aqw.J.cF, false);
        this.placeTrainingDummy(world, sbb, 0);
        this.placeTrainingDummy(world, sbb, 1);
        this.placeTrainingDummy(world, sbb, 2);
        this.a(world, sbb, 5, 0, 10, 7, 0, 12, aqw.B.cF, 0, false);
        this.a(world, this.deco.pillarID, this.deco.pillarMeta, 5, 1, 12, sbb);
        this.a(world, this.deco.pillarID, this.deco.pillarMeta, 5, 2, 12, sbb);
        this.a(world, this.deco.pillarID, this.deco.pillarMeta, 6, 1, 12, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(2), 6, 2, 12, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(2), 7, 1, 12, sbb);
        this.a(world, this.deco.pillarID, this.deco.pillarMeta, 5, 1, 11, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(1), 5, 2, 11, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(1), 5, 1, 10, sbb);
        this.a(world, aqw.cm.cF, 0, 6, 1, 11, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void placeTrainingDummy(final abv world, final age sbb, final int rotation) {
        this.fillBlocksRotated(world, sbb, 5, 0, 5, 7, 0, 7, aqw.J.cF, 0, rotation);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 6, 1, 6, rotation, sbb);
        this.placeBlockRotated(world, aqw.C.cF, 2, 6, 2, 6, rotation, sbb);
        this.placeBlockRotated(world, aqw.be.cF, 0, 5, 2, 6, rotation, sbb);
        this.placeBlockRotated(world, aqw.be.cF, 0, 7, 2, 6, rotation, sbb);
        this.placeBlockRotated(world, aqw.bf.cF, this.getStairMeta(0 + rotation), 6, 3, 6, rotation, sbb);
    }
}
