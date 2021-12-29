// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import twilightforest.structures.TFStructureComponentOld;
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

public class StrongholdCrossingComponent extends StructureTFStrongholdComponent
{
    public StrongholdCrossingComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSCr, nbt);
    }
    
    public StrongholdCrossingComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSCr, feature, i, facing, x, y, z);
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
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 1, 4);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.fillBlocksRotated(world, sbb, 8, 1, 8, 9, 5, 9, this.deco.pillarState, Rotation.NONE);
        this.placeWallStatue(world, 8, 1, 7, Rotation.NONE, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 9, 1, 10, Rotation.CLOCKWISE_180, sbb);
        this.placeWallStatue(world, 10, 1, 8, Rotation.CLOCKWISE_90, sbb);
        this.placeTableAndChairs(world, sbb, Rotation.NONE);
        this.placeTableAndChairs(world, sbb, Rotation.CLOCKWISE_90);
        this.placeTableAndChairs(world, sbb, Rotation.CLOCKWISE_180);
        this.placeTableAndChairs(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeTableAndChairs(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        final BlockState oakStairs = Blocks.field_150476_ad.func_176223_P();
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.NONE.func_185831_a(Direction.WEST), true), 5, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 5, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST), true), 6, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 6, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.field_150485_bF.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST)), 5, 1, 2, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.field_150485_bF.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Rotation.NONE.func_185831_a(Direction.WEST)), 7, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.field_150485_bF.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST)), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.field_150485_bF.func_176223_P().func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST)), 4, 1, 4, rotation, sbb);
    }
}
