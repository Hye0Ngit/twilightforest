// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdUpperAscender extends StructureTFStrongholdComponent
{
    boolean exitTop;
    
    public ComponentTFStrongholdUpperAscender(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y < 36) {
            this.exitTop = true;
            return age.a(x, y, z, -2, -1, 0, 5, 10, 10, facing);
        }
        this.exitTop = false;
        return age.a(x, y, z, -2, -6, 0, 5, 10, 10, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 0, 2, this.exitTop ? 6 : 1, 10);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        if (this.a(world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 9, 9, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 2, 2, this.exitTop ? 1 : 6, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 0, 2, this.exitTop ? 6 : 1, 9, sbb);
        if (this.exitTop) {
            this.makeStairsAt(world, 1, 3, 1, sbb);
            this.makeStairsAt(world, 2, 4, 1, sbb);
            this.makeStairsAt(world, 3, 5, 1, sbb);
            this.makeStairsAt(world, 4, 6, 1, sbb);
            this.makeStairsAt(world, 5, 7, 1, sbb);
            this.makePlatformAt(world, 5, 8, sbb);
        }
        else {
            this.makeStairsAt(world, 1, 6, 3, sbb);
            this.makeStairsAt(world, 2, 5, 3, sbb);
            this.makeStairsAt(world, 3, 4, 3, sbb);
            this.makeStairsAt(world, 4, 3, 3, sbb);
            this.makeStairsAt(world, 5, 2, 3, sbb);
            this.makePlatformAt(world, 5, 1, sbb);
        }
        return true;
    }
    
    private void makeStairsAt(final abv world, final int y, final int z, final int facing, final age sbb) {
        if (this.a(world, 0, y, z, sbb) != 0 || this.a(world, 4, y, z, sbb) != 0) {
            for (int x = 1; x < 4; ++x) {
                this.a(world, aqw.bC.cF, this.getStairMeta(facing), x, y, z, sbb);
            }
        }
    }
    
    private void makePlatformAt(final abv world, final int y, final int z, final age sbb) {
        if (this.a(world, 0, y, z, sbb) != 0 || this.a(world, 4, y, z, sbb) != 0) {
            for (int x = 1; x < 4; ++x) {
                this.a(world, aqw.br.cF, 0, x, y, z, sbb);
            }
        }
    }
}
