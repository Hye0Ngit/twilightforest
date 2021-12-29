// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdFoundry extends StructureTFStrongholdComponent
{
    int entranceLevel;
    
    public ComponentTFStrongholdFoundry(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.entranceLevel = 3;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -20, 0, 18, 25, 18, facing);
        }
        if (y < 11) {
            this.entranceLevel = 1;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -6, 0, 18, 25, 18, facing);
        }
        this.entranceLevel = 2;
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -13, 0, 18, 25, 18, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        switch (this.entranceLevel) {
            case 1: {
                this.addDoor(4, 6, 0);
                this.addNewComponent(parent, list, random, 1, -1, 13, 13);
                this.addNewComponent(parent, list, random, 3, 18, 13, 4);
                this.addNewComponent(parent, list, random, 0, 13, 20, 18);
                break;
            }
            case 2: {
                this.addDoor(4, 13, 0);
                this.addNewComponent(parent, list, random, 1, -1, 6, 13);
                this.addNewComponent(parent, list, random, 3, 18, 20, 4);
                this.addNewComponent(parent, list, random, 0, 13, 13, 18);
                break;
            }
            case 3: {
                this.addDoor(4, 20, 0);
                this.addNewComponent(parent, list, random, 0, 13, 6, 18);
                this.addNewComponent(parent, list, random, 1, -1, 13, 13);
                this.addNewComponent(parent, list, random, 3, 18, 13, 4);
                break;
            }
        }
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 25, 17, rand, this.deco.randomBlocks);
        this.a(world, sbb, 1, 0, 1, 16, 4, 16, aqw.I.cF, 0, false);
        this.a(world, sbb, 1, 19, 1, 16, 19, 16, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 2, 19, 2, 15, 19, 15);
        this.a(world, sbb, 1, 12, 1, 16, 12, 16, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 2, 12, 2, 15, 12, 15);
        this.a(world, sbb, 1, 5, 1, 16, 5, 16, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 2, 5, 2, 15, 5, 15);
        this.a(world, sbb, 1, 1, 1, 1, 24, 2, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 2, 1, 1, 2, 24, 1, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 16, 1, 1, 16, 24, 2, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 15, 1, 1, 15, 24, 1, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 1, 1, 15, 1, 24, 16, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 2, 1, 16, 2, 24, 16, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 16, 1, 15, 16, 24, 16, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 15, 1, 16, 15, 24, 16, false, rand, StructureTFComponent.getStrongholdStones());
        final Random massRandom = new Random(rand.nextLong());
        for (int x = 4; x < 14; ++x) {
            for (int z = 4; z < 14; ++z) {
                for (int y = 8; y < 23; ++y) {
                    final float c = Math.abs(x - 8.5f) + Math.abs(z - 8.5f) + Math.abs(y - 18.0f);
                    final float r = 5.5f + (massRandom.nextFloat() - massRandom.nextFloat()) * 3.5f;
                    if (c < r) {
                        this.a(world, aqw.y.cF, 0, x, y, z, sbb);
                    }
                }
            }
        }
        for (int i = 0; i < 400; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.a(world, dx, dy, dz, sbb) > 0) {
                for (int y2 = 0; y2 < 3; ++y2) {
                    this.a(world, aqw.y.cF, 0, dx, dy - y2, dz, sbb);
                }
            }
        }
        for (int i = 0; i < 8; ++i) {
            final int blockID = aqw.aS.cF;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 8; ++i) {
            final int blockID = aqw.M.cF;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 6; ++i) {
            final int blockID = aqw.L.cF;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 2; ++i) {
            final int blockID = aqw.bi.cF;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 2; ++i) {
            final int blockID = aqw.bW.cF;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 4; ++i) {
            final int blockID = aqw.aB.cF;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void addOreToMass(final abv world, final age sbb, final Random massRandom, final int blockID, final int blockMeta) {
        for (int i = 0; i < 10; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.a(world, dx, dy, dz, sbb) > 0) {
                this.a(world, blockID, blockMeta, dx, dy, dz, sbb);
                break;
            }
        }
    }
}
