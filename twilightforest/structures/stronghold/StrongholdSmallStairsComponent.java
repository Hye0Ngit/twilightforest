// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.loot.TFTreasure;
import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
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

public class StrongholdSmallStairsComponent extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    public boolean hasTreasure;
    public boolean chestTrapped;
    
    public StrongholdSmallStairsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSSS, nbt);
        this.enterBottom = nbt.func_74767_n("enterBottom");
        this.hasTreasure = nbt.func_74767_n("hasTreasure");
        this.chestTrapped = nbt.func_74767_n("chestTrapped");
    }
    
    public StrongholdSmallStairsComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSSS, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("enterBottom", this.enterBottom);
        tagCompound.func_74757_a("hasTreasure", this.hasTreasure);
        tagCompound.func_74757_a("chestTrapped", this.chestTrapped);
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
            return MutableBoundingBox.func_175897_a(x, y, z, -4, -1, 0, 9, 14, 9, facing);
        }
        return MutableBoundingBox.func_175897_a(x, y, z, -4, -8, 0, 9, 14, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 9);
        }
        else {
            this.addDoor(4, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 9);
        }
        this.hasTreasure = random.nextBoolean();
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 13, 8, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 1, 7, 1, 7, 7, 7, this.deco.platformState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_74878_a(world, sbb, 2, 7, 2, 6, 7, 6);
        final Rotation rotation = this.enterBottom ? Rotation.NONE : Rotation.CLOCKWISE_180;
        for (int y = 1; y < 8; ++y) {
            for (int x = 3; x < 6; ++x) {
                this.setBlockStateRotated(world, Blocks.field_150350_a.func_176223_P(), x, y + 1, y, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), x, y, y, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, x, y - 1, y, rotation, sbb);
            }
        }
        if (this.hasTreasure) {
            this.placeTreasureRotated(world, 4, 1, 6, this.func_186165_e().func_176734_d(), rotation, TFTreasure.stronghold_cache, this.chestTrapped, sbb);
            if (this.chestTrapped) {
                this.setBlockStateRotated(world, Blocks.field_150335_W.func_176223_P(), 4, 0, 6, rotation, sbb);
            }
            for (int z = 5; z < 8; ++z) {
                this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.WEST), 3, 1, z, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.EAST), 5, 1, z, rotation, sbb);
            }
            this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), 4, 1, 5, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH), 4, 1, 7, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), 4, 2, 6, rotation, sbb);
        }
        if (this.enterBottom) {
            this.placeWallStatue(world, 4, 8, 1, Rotation.CLOCKWISE_180, sbb);
        }
        else {
            this.placeWallStatue(world, 4, 8, 7, Rotation.NONE, sbb);
        }
        this.placeDoors(world, sbb);
        return true;
    }
}
