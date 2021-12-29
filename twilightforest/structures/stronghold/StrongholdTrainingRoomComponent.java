// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class StrongholdTrainingRoomComponent extends StructureTFStrongholdComponent
{
    public StrongholdTrainingRoomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSTR, nbt);
    }
    
    public StrongholdTrainingRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSTR, feature, i, facing, x, y, z);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 18, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(13, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 18);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.func_189914_a(world, sbb, rand, 0.7f, 4, 0, 4, 8, 0, 8, Blocks.field_150354_m.func_176223_P(), Blocks.field_150354_m.func_176223_P(), false, false);
        this.func_189914_a(world, sbb, rand, 0.7f, 9, 0, 4, 13, 0, 8, Blocks.field_150354_m.func_176223_P(), Blocks.field_150354_m.func_176223_P(), false, false);
        this.func_189914_a(world, sbb, rand, 0.7f, 9, 0, 9, 13, 0, 13, Blocks.field_150354_m.func_176223_P(), Blocks.field_150354_m.func_176223_P(), false, false);
        this.placeTrainingDummy(world, sbb, Rotation.NONE);
        this.placeTrainingDummy(world, sbb, Rotation.CLOCKWISE_90);
        this.placeTrainingDummy(world, sbb, Rotation.CLOCKWISE_180);
        this.func_175804_a(world, sbb, 5, 0, 10, 7, 0, 12, Blocks.field_150347_e.func_176223_P(), Blocks.field_150347_e.func_176223_P(), false);
        this.func_175811_a(world, this.deco.pillarState, 5, 1, 12, sbb);
        this.func_175811_a(world, this.deco.pillarState, 5, 2, 12, sbb);
        this.func_175811_a(world, this.deco.pillarState, 6, 1, 12, sbb);
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.EAST), 6, 2, 12, sbb);
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.EAST), 7, 1, 12, sbb);
        this.func_175811_a(world, this.deco.pillarState, 5, 1, 11, sbb);
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.NORTH), 5, 2, 11, sbb);
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)CarvedPumpkinBlock.field_196359_a, (Comparable)Direction.NORTH), 5, 1, 10, sbb);
        this.func_175811_a(world, Blocks.field_150467_bQ.func_176223_P(), 6, 1, 11, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeTrainingDummy(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 5, 0, 5, 7, 0, 7, Blocks.field_150354_m.func_176223_P(), rotation);
        this.setBlockStateRotated(world, this.deco.fenceState, 6, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_196666_p.func_176223_P(), 6, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_180407_aO.func_176223_P(), 5, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_180407_aO.func_176223_P(), 7, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150423_aK.func_176223_P(), 6, 3, 6, rotation, sbb);
    }
}
