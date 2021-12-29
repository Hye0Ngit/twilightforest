// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.world.TFGenSmallRainboak;
import twilightforest.world.TFGenSmallTwilightOak;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdAtrium extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public ComponentTFStrongholdAtrium(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.enterBottom = false;
        }
        else if (y < 11) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 18, 14, 18, facing);
        }
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -8, 0, 18, 14, 18, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, 2, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, 2, 4, 1, -1);
        }
        this.addNewComponent(parent, list, random, 0, 13, 1, 18);
        this.addNewComponent(parent, list, random, 0, 4, 8, 18);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 17, rand, this.deco.randomBlocks);
        this.a(world, sbb, 1, 6, 1, 16, 7, 16, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 5, 8, 5, 12, 8, 12, this.deco.fenceID, this.deco.fenceMeta, false);
        this.a(world, sbb, 6, 6, 6, 11, 8, 11);
        this.placeBalconyPillar(world, sbb, 0);
        this.placeBalconyPillar(world, sbb, 1);
        this.placeBalconyPillar(world, sbb, 2);
        this.placeBalconyPillar(world, sbb, 3);
        this.a(world, sbb, 1, 1, 1, 1, 12, 2, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 2, 1, 1, 2, 12, 1, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 16, 1, 1, 16, 12, 2, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 15, 1, 1, 15, 12, 1, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 1, 1, 15, 1, 12, 16, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 2, 1, 16, 2, 12, 16, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 16, 1, 15, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, 15, 1, 16, 15, 12, 16, false, rand, this.deco.randomBlocks);
        this.a(world, sbb, rand, 0.5f, 6, 0, 6, 11, 0, 11, aqw.z.cF, aqw.z.cF, false);
        this.a(world, sbb, 7, 0, 7, 10, 0, 10, aqw.z.cF, 0, false);
        this.spawnATree(world, rand.nextInt(5), 8, 1, 8, sbb);
        this.placeCornerStatue(world, 2, 8, 2, 0, sbb);
        this.placeCornerStatue(world, 2, 1, 15, 1, sbb);
        this.placeCornerStatue(world, 15, 1, 2, 2, sbb);
        this.placeCornerStatue(world, 15, 8, 15, 3, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void spawnATree(final abv world, final int treeNum, final int x, final int y, final int z, final age sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz)) {
            final int minHeight = 8;
            afd treeGen = null;
            switch (treeNum) {
                default: {
                    treeGen = (afd)new afz(true, minHeight, 0, 0, false);
                    break;
                }
                case 1: {
                    treeGen = (afd)new afz(true, minHeight, 3, 3, false);
                    break;
                }
                case 2: {
                    treeGen = (afd)new afz(true, minHeight, 2, 2, false);
                    break;
                }
                case 3: {
                    treeGen = new TFGenSmallTwilightOak(false, minHeight);
                    break;
                }
                case 4: {
                    treeGen = new TFGenSmallRainboak(false);
                    break;
                }
            }
            for (int i = 0; i < 100; ++i) {
                if (treeGen.a(world, world.s, dx, dy, dz)) {
                    break;
                }
                if (i == 99) {}
            }
        }
    }
    
    private void placeBalconyPillar(final abv world, final age sbb, final int rotation) {
        this.fillBlocksRotated(world, sbb, 5, 1, 5, 5, 12, 5, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 5, 1, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 6, 1, 5, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 5, 5, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 6, 5, 5, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 5, 12, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 6, 12, 5, rotation, sbb);
    }
}
