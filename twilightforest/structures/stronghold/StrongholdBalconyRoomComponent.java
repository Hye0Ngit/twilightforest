// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

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

public class StrongholdBalconyRoomComponent extends StructureTFStrongholdComponent
{
    boolean enterBottom;
    
    public StrongholdBalconyRoomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSBalR, nbt);
        this.enterBottom = nbt.func_74767_n("enterBottom");
    }
    
    public StrongholdBalconyRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSBalR, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("enterBottom", this.enterBottom);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.enterBottom = false;
        }
        else if (y < 11) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 18, 14, 27, facing);
        }
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -8, 0, 18, 14, 27, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewComponent(parent, list, random, Rotation.NONE, 13, 1, 27);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 18, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 27);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 8, 4);
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 8, 22);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 26, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 6, 1, 16, 7, 25, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 4, 8, 4, 13, 8, 22, this.deco.fenceState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_74878_a(world, sbb, 5, 6, 5, 12, 8, 21);
        this.placeStairsAndPillars(world, sbb, Rotation.NONE);
        this.placeStairsAndPillars(world, sbb, Rotation.CLOCKWISE_180);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeStairsAndPillars(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 4, 1, 4, 4, 12, 4, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), 4, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), false), 5, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 4, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 5, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 4, 12, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(Direction.WEST), true), 5, 12, 4, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 13, 1, 4, 13, 12, 4, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), 13, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), false), 12, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 13, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), true), 12, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 13, 12, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), true), 12, 12, 4, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 13, 1, 8, 13, 12, 8, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), false), 13, 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST), false), 13, 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), false), 12, 1, 8, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 13, 5, 9, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST), true), 13, 5, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(Direction.WEST), true), 13, 12, 9, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.func_185831_a(Direction.WEST), true), 13, 12, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), true), 12, 12, 8, rotation, sbb);
        for (int y = 1; y < 8; ++y) {
            for (int z = 5; z < 8; ++z) {
                this.setBlockStateRotated(world, StrongholdBalconyRoomComponent.AIR, y + 6, y + 1, z, rotation, sbb);
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.func_185831_a(Direction.WEST), false), y + 6, y, z, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, y + 6, y - 1, z, rotation, sbb);
            }
        }
    }
}
