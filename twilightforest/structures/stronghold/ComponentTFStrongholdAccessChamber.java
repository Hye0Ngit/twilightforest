// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFStrongholdAccessChamber extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdAccessChamber(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureBoundingBox.func_78889_a(x, y, z, -4, 1, 0, 8, 5, 8, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 0, 4, 1, 9);
        this.addNewUpperComponent(parent, list, random, 1, -1, 1, 4);
        this.addNewUpperComponent(parent, list, random, 2, 4, 1, -1);
        this.addNewUpperComponent(parent, list, random, 3, 9, 1, 4);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, 8, 4, 8, true, rand, StructureTFComponent.getStrongholdStones());
        this.placeSmallDoorwayAt(world, rand, 0, 4, 1, 8, sbb);
        this.placeSmallDoorwayAt(world, rand, 1, 0, 1, 4, sbb);
        this.placeSmallDoorwayAt(world, rand, 2, 4, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 3, 8, 1, 4, sbb);
        this.func_74872_a(world, sbb, 2, -2, 2, 6, 0, 6, Block.field_72007_bm.field_71990_ca, 1, 0, 0, false);
        this.func_74878_a(world, sbb, 3, -2, 3, 5, 2, 5);
        this.func_74872_a(world, sbb, 2, 0, 3, 2, 0, 6, this.deco.stairID, this.getStairMeta(2), 0, 0, false);
        this.func_74872_a(world, sbb, 6, 0, 2, 6, 0, 6, this.deco.stairID, this.getStairMeta(0), 0, 0, false);
        this.func_74872_a(world, sbb, 3, 0, 2, 5, 0, 2, this.deco.stairID, this.getStairMeta(3), 0, 0, false);
        this.func_74872_a(world, sbb, 3, 0, 6, 5, 0, 6, this.deco.stairID, this.getStairMeta(1), 0, 0, false);
        this.func_74864_a(world, this.deco.pillarID, this.deco.pillarMeta, 2, 0, 2, sbb);
        this.func_74864_a(world, TFBlocks.trophyPedestal.field_71990_ca, 15, 2, 1, 2, sbb);
        this.func_74872_a(world, sbb, 2, -1, 2, 6, -1, 6, TFBlocks.shield.field_71990_ca, 15, 0, 0, false);
        return true;
    }
}
