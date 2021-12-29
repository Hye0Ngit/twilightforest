// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdUpperRightTurn extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdUpperRightTurn(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return age.a(x, y, z, -2, -1, 0, 5, 5, 5, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 1, -1, 1, 2);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        if (this.a(world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 4, 4, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 2, 2, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 1, 0, 1, 2, sbb);
        return true;
    }
}
