// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdUpperCorridor extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdUpperCorridor(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return age.a(x, y, z, -2, -1, 0, 5, 5, 9, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 0, 2, 1, 9);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        if (this.a(world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 4, 8, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 2, 2, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 2, 2, 1, 8, sbb);
        return true;
    }
}
