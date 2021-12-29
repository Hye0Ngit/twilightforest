// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdSmallHallway extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdSmallHallway(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 18, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, 0, 4, 1, 18);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 17, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 9, 1, sbb);
        this.placeWallStatue(world, 7, 1, 9, 3, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
