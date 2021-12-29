// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.TFStructureComponentOld;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Rotation;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class StrongholdBossRoomComponent extends StructureTFStrongholdComponent
{
    public StrongholdBossRoomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSBR, nbt);
    }
    
    public StrongholdBossRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSBR, feature, i, facing, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 27, 7, 27, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(13, 1, 0);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 26, 6, 26, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 1, 3, 5, 25, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 23, 1, 1, 25, 5, 25, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 4, 1, 1, 22, 5, 3, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 4, 1, 23, 22, 5, 25, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 1, 1, 1, 2, 5, 25, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_175804_a(world, sbb, 24, 1, 1, 25, 5, 25, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 1, 1, 22, 5, 2, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_175804_a(world, sbb, 4, 1, 24, 22, 5, 25, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_74882_a(world, sbb, 4, 1, 4, 4, 5, 7, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 5, 1, 4, 5, 5, 5, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 6, 1, 4, 7, 5, 4, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 4, 1, 19, 4, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 5, 1, 21, 5, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 6, 1, 22, 7, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 22, 1, 4, 22, 5, 7, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 21, 1, 4, 21, 5, 5, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 19, 1, 4, 20, 5, 4, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 22, 1, 19, 22, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 21, 1, 21, 21, 5, 22, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 19, 1, 22, 20, 5, 22, false, rand, this.deco.randomBlocks);
        this.placePillarDecorations(world, sbb, Rotation.NONE);
        this.placePillarDecorations(world, sbb, Rotation.CLOCKWISE_90);
        this.placePillarDecorations(world, sbb, Rotation.CLOCKWISE_180);
        this.placePillarDecorations(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.placeSarcophagus(world, sbb, 8, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 13, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 18, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 8, 1, 15, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 13, 1, 15, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 18, 1, 15, Rotation.NONE);
        this.func_74878_a(world, sbb, 12, 1, 1, 14, 4, 2);
        this.func_175804_a(world, sbb, 12, 1, 3, 14, 4, 3, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
        this.func_175811_a(world, ((Block)TFBlocks.boss_spawner_knight_phantom.get()).func_176223_P(), 13, 2, 13, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeSarcophagus(final ISeedReader world, final MutableBoundingBox sbb, final int x, final int y, final int z, final Rotation rotation) {
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z + 3, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z + 3, rotation, sbb);
        if (world.func_201674_k().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x + 1, y + 1, z, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x + 1, y + 1, z, rotation, sbb);
        }
        if (world.func_201674_k().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x - 1, y + 1, z, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x - 1, y + 1, z, rotation, sbb);
        }
        if (world.func_201674_k().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x + 1, y + 1, z + 3, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x + 1, y + 1, z + 3, rotation, sbb);
        }
        if (world.func_201674_k().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.field_150478_aa.func_176223_P(), x - 1, y + 1, z + 3, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x - 1, y + 1, z + 3, rotation, sbb);
        }
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST), false), x, y, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), x, y, z + 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), x + 1, y, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), false), x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), false), x - 1, y, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150333_U.func_176223_P(), x, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150333_U.func_176223_P(), x, y + 1, z + 2, rotation, sbb);
    }
    
    protected void placePillarDecorations(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), 4, 1, 8, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), 8, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 4, 5, 8, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 8, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), 5, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), 6, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 5, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 6, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 6, 5, 5, rotation, sbb);
    }
    
    @Override
    protected void placeDoorwayAt(final ISeedReader world, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.func_175804_a(world, sbb, x, y, z - 1, x, y + 3, z + 1, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        }
        else {
            this.func_175804_a(world, sbb, x - 1, y, z, x + 1, y + 3, z, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        }
    }
    
    @Override
    protected boolean isValidBreakInPoint(final int wx, final int wy, final int wz) {
        return false;
    }
}
