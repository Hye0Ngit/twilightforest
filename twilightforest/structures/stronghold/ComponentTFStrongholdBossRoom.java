// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.block.TFBlocks;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdBossRoom extends StructureTFStrongholdComponent
{
    boolean enterBottom;
    
    public ComponentTFStrongholdBossRoom(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 27, 7, 27, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addDoor(13, 1, 0);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 26, 6, 26, rand, this.deco.randomBlocks);
        this.a(world, sbb, 1, 1, 1, 3, 5, 25, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 23, 1, 1, 25, 5, 25, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 4, 1, 1, 22, 5, 3, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 4, 1, 23, 22, 5, 25, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 1, 1, 1, 2, 5, 25, aqw.au.cF, 0, aqw.au.cF, 0, false);
        this.a(world, sbb, 24, 1, 1, 25, 5, 25, aqw.au.cF, 0, aqw.au.cF, 0, false);
        this.a(world, sbb, 4, 1, 1, 22, 5, 2, aqw.au.cF, 0, aqw.au.cF, 0, false);
        this.a(world, sbb, 4, 1, 24, 22, 5, 25, aqw.au.cF, 0, aqw.au.cF, 0, false);
        this.a(world, sbb, 4, 1, 4, 4, 5, 7, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 5, 1, 4, 5, 5, 5, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 6, 1, 4, 7, 5, 4, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 4, 1, 19, 4, 5, 22, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 5, 1, 21, 5, 5, 22, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 6, 1, 22, 7, 5, 22, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 22, 1, 4, 22, 5, 7, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 21, 1, 4, 21, 5, 5, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 19, 1, 4, 20, 5, 4, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 22, 1, 19, 22, 5, 22, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 21, 1, 21, 21, 5, 22, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 19, 1, 22, 20, 5, 22, false, rand, this.deco.randomBlocks);
        this.placePillarDecorations(world, sbb, 0);
        this.placePillarDecorations(world, sbb, 1);
        this.placePillarDecorations(world, sbb, 2);
        this.placePillarDecorations(world, sbb, 3);
        this.placeSarcophagus(world, sbb, 8, 1, 8, 0);
        this.placeSarcophagus(world, sbb, 13, 1, 8, 0);
        this.placeSarcophagus(world, sbb, 18, 1, 8, 0);
        this.placeSarcophagus(world, sbb, 8, 1, 15, 0);
        this.placeSarcophagus(world, sbb, 13, 1, 15, 0);
        this.placeSarcophagus(world, sbb, 18, 1, 15, 0);
        this.a(world, sbb, 12, 1, 1, 14, 4, 2);
        this.a(world, sbb, 12, 1, 3, 14, 4, 3, aqw.bu.cF, aqw.bu.cF, false);
        this.a(world, TFBlocks.bossSpawner.cF, 4, 13, 2, 13, sbb);
        this.placeSignAtCurrentPosition(world, 13, 1, 5, "Boss Room", "Out of Order", sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void placeSignAtCurrentPosition(final abv world, final int x, final int y, final int z, final String string0, final String string1, final age sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != aqw.aI.cF) {
            world.f(dx, dy, dz, aqw.aI.cF, 0, 2);
            final asj teSign = (asj)world.r(dx, dy, dz);
            if (teSign != null) {
                teSign.a[1] = string0;
                teSign.a[2] = string1;
            }
            System.out.println("Making sign");
        }
    }
    
    private void placeSarcophagus(final abv world, final age sbb, final int x, final int y, final int z, final int rotation) {
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x + 1, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x - 1, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x + 1, y, z + 3, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x - 1, y, z + 3, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, x + 1, y + 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, x - 1, y + 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, x + 1, y + 1, z + 3, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, x - 1, y + 1, z + 3, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), x + 0, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), x + 0, y, z + 3, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), x + 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), x + 1, y, z + 2, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), x - 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), x - 1, y, z + 2, rotation, sbb);
        this.placeBlockRotated(world, aqw.ap.cF, 0, x + 0, y + 1, z + 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.ap.cF, 0, x + 0, y + 1, z + 2, rotation, sbb);
    }
    
    protected void placePillarDecorations(final abv world, final age sbb, final int rotation) {
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 4, 1, 8, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 8, 1, 4, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 4, 5, 8, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 8, 5, 4, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 5, 1, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 6, 1, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 6, 1, 5, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 5, 5, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 6, 5, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 6, 5, 5, rotation, sbb);
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
    
    @Override
    protected boolean isValidBreakInPoint(final int wx, final int wy, final int wz) {
        return false;
    }
}
