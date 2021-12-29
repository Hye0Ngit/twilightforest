// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import twilightforest.structures.TFStructureComponentOld;
import twilightforest.loot.TFTreasure;
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

public class StrongholdTreasureCorridorComponent extends StructureTFStrongholdComponent
{
    public StrongholdTreasureCorridorComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSTC, nbt);
    }
    
    public StrongholdTreasureCorridorComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSTC, feature, i, facing, x, y, z);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 27, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 27);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 26, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 9, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 1, 1, 17, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 17, Rotation.COUNTERCLOCKWISE_90, sbb);
        final Rotation rotation = ((this.field_74887_e.field_78897_a ^ this.field_74887_e.field_78896_c) % 2 == 0) ? Rotation.NONE : Rotation.CLOCKWISE_180;
        this.placeTreasureRotated(world, 8, 2, 13, (rotation == Rotation.NONE) ? this.func_186165_e().func_176746_e() : this.func_186165_e().func_176735_f(), rotation, TFTreasure.stronghold_cache, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), 8, 3, 12, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, true), 8, 3, 13, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), 8, 3, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 8, 2, 12, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 8, 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH), 7, 1, 12, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.WEST), 7, 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), 7, 1, 14, rotation, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
}
