// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdTrainingRoom extends StructureTFStrongholdComponent
{
    public ComponentTFStrongholdTrainingRoom() {
    }
    
    public ComponentTFStrongholdTrainingRoom(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 18, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(13, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 18);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.func_189914_a(world, sbb, rand, 0.7f, 4, 0, 4, 8, 0, 8, Blocks.field_150354_m.func_176223_P(), Blocks.field_150354_m.func_176223_P(), false, 0);
        this.func_189914_a(world, sbb, rand, 0.7f, 9, 0, 4, 13, 0, 8, Blocks.field_150354_m.func_176223_P(), Blocks.field_150354_m.func_176223_P(), false, 0);
        this.func_189914_a(world, sbb, rand, 0.7f, 9, 0, 9, 13, 0, 13, Blocks.field_150354_m.func_176223_P(), Blocks.field_150354_m.func_176223_P(), false, 0);
        this.placeTrainingDummy(world, sbb, Rotation.NONE);
        this.placeTrainingDummy(world, sbb, Rotation.CLOCKWISE_90);
        this.placeTrainingDummy(world, sbb, Rotation.CLOCKWISE_180);
        this.func_175804_a(world, sbb, 5, 0, 10, 7, 0, 12, Blocks.field_150347_e.func_176223_P(), Blocks.field_150347_e.func_176223_P(), false);
        this.func_175811_a(world, this.deco.pillarState, 5, 1, 12, sbb);
        this.func_175811_a(world, this.deco.pillarState, 5, 2, 12, sbb);
        this.func_175811_a(world, this.deco.pillarState, 6, 1, 12, sbb);
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.EAST), 6, 2, 12, sbb);
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.EAST), 7, 1, 12, sbb);
        this.func_175811_a(world, this.deco.pillarState, 5, 1, 11, sbb);
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.NORTH), 5, 2, 11, sbb);
        this.func_175811_a(world, this.deco.stairState.func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)EnumFacing.NORTH), 5, 1, 10, sbb);
        this.func_175811_a(world, Blocks.field_150467_bQ.func_176223_P(), 6, 1, 11, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void placeTrainingDummy(final World world, final StructureBoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 5, 0, 5, 7, 0, 7, Blocks.field_150354_m.func_176223_P(), rotation);
        this.setBlockStateRotated(world, this.deco.fenceState, 6, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH), 6, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_180407_aO.func_176223_P(), 5, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_180407_aO.func_176223_P(), 7, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150423_aK.func_176223_P().func_177226_a((IProperty)BlockPumpkin.field_185512_D, (Comparable)this.getStructureRelativeRotation(rotation)), 6, 3, 6, rotation, sbb);
    }
}
