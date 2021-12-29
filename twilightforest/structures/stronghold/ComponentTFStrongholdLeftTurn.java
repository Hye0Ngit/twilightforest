// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdLeftTurn extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdLeftTurn(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 9, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, 3, 9, 1, 4);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 1, 1, 1, 7, 5, 7);
        this.placeCornerStatue(world, 2, 1, 6, 1, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
