// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;

public class ComponentTFStrongholdAccessChamber extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdAccessChamber(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return age.a(x, y, z, -4, 1, 0, 8, 5, 8, facing);
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random random) {
        super.a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 0, 4, 1, 9);
        this.addNewUpperComponent(parent, list, random, 1, -1, 1, 4);
        this.addNewUpperComponent(parent, list, random, 2, 4, 1, -1);
        this.addNewUpperComponent(parent, list, random, 3, 9, 1, 4);
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        this.a(world, sbb, 0, 0, 0, 8, 4, 8, true, rand, StructureTFComponent.getStrongholdStones());
        this.placeSmallDoorwayAt(world, rand, 0, 4, 1, 8, sbb);
        this.placeSmallDoorwayAt(world, rand, 1, 0, 1, 4, sbb);
        this.placeSmallDoorwayAt(world, rand, 2, 4, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 3, 8, 1, 4, sbb);
        this.a(world, sbb, 2, -2, 2, 6, 0, 6, aqw.br.cF, 1, 0, 0, false);
        this.a(world, sbb, 3, -2, 3, 5, 2, 5);
        this.a(world, sbb, 2, 0, 3, 2, 0, 6, this.deco.stairID, this.getStairMeta(2), 0, 0, false);
        this.a(world, sbb, 6, 0, 2, 6, 0, 6, this.deco.stairID, this.getStairMeta(0), 0, 0, false);
        this.a(world, sbb, 3, 0, 2, 5, 0, 2, this.deco.stairID, this.getStairMeta(3), 0, 0, false);
        this.a(world, sbb, 3, 0, 6, 5, 0, 6, this.deco.stairID, this.getStairMeta(1), 0, 0, false);
        this.a(world, this.deco.pillarID, this.deco.pillarMeta, 2, 0, 2, sbb);
        this.a(world, TFBlocks.trophyPedestal.cF, 15, 2, 1, 2, sbb);
        this.a(world, sbb, 2, -1, 2, 6, -1, 6, TFBlocks.shield.cF, 15, 0, 0, false);
        return true;
    }
}
