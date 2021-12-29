// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFStrongholdTrainingRoom extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdTrainingRoom(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 18, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(13, 1, 0);
        this.addNewComponent(parent, list, random, 0, 4, 1, 18);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.func_74880_a(world, sbb, rand, 0.7f, 4, 0, 4, 8, 0, 8, Block.field_71939_E.field_71990_ca, Block.field_71939_E.field_71990_ca, false);
        this.func_74880_a(world, sbb, rand, 0.7f, 9, 0, 4, 13, 0, 8, Block.field_71939_E.field_71990_ca, Block.field_71939_E.field_71990_ca, false);
        this.func_74880_a(world, sbb, rand, 0.7f, 9, 0, 9, 13, 0, 13, Block.field_71939_E.field_71990_ca, Block.field_71939_E.field_71990_ca, false);
        this.placeTrainingDummy(world, sbb, 0);
        this.placeTrainingDummy(world, sbb, 1);
        this.placeTrainingDummy(world, sbb, 2);
        this.func_74884_a(world, sbb, 5, 0, 10, 7, 0, 12, Block.field_71978_w.field_71990_ca, 0, false);
        this.func_74864_a(world, this.deco.pillarID, this.deco.pillarMeta, 5, 1, 12, sbb);
        this.func_74864_a(world, this.deco.pillarID, this.deco.pillarMeta, 5, 2, 12, sbb);
        this.func_74864_a(world, this.deco.pillarID, this.deco.pillarMeta, 6, 1, 12, sbb);
        this.func_74864_a(world, this.deco.stairID, this.getStairMeta(2), 6, 2, 12, sbb);
        this.func_74864_a(world, this.deco.stairID, this.getStairMeta(2), 7, 1, 12, sbb);
        this.func_74864_a(world, this.deco.pillarID, this.deco.pillarMeta, 5, 1, 11, sbb);
        this.func_74864_a(world, this.deco.stairID, this.getStairMeta(1), 5, 2, 11, sbb);
        this.func_74864_a(world, this.deco.stairID, this.getStairMeta(1), 5, 1, 10, sbb);
        this.func_74864_a(world, Block.field_82510_ck.field_71990_ca, 0, 6, 1, 11, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void placeTrainingDummy(final World world, final StructureBoundingBox sbb, final int rotation) {
        this.fillBlocksRotated(world, sbb, 5, 0, 5, 7, 0, 7, Block.field_71939_E.field_71990_ca, 0, rotation);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 6, 1, 6, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71988_x.field_71990_ca, 2, 6, 2, 6, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72031_aZ.field_71990_ca, 0, 5, 2, 6, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72031_aZ.field_71990_ca, 0, 7, 2, 6, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72061_ba.field_71990_ca, this.getStairMeta(0 + rotation), 6, 3, 6, rotation, sbb);
    }
}
