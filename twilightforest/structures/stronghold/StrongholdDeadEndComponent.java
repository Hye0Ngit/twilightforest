// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.util.Rotation;
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

public class StrongholdDeadEndComponent extends StructureTFStrongholdComponent
{
    private boolean chestTrapped;
    
    public StrongholdDeadEndComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSDE, nbt);
        this.chestTrapped = nbt.func_74767_n("chestTrapped");
    }
    
    public StrongholdDeadEndComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSDE, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("chestTrapped", this.chestTrapped);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 6, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 4, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 4, 1, 7, Rotation.NONE, sbb);
        this.placeDoors(world, sbb);
        this.manualTreaurePlacement(world, 4, 1, 3, Direction.SOUTH, TFTreasure.stronghold_cache, this.chestTrapped, sbb);
        if (this.chestTrapped) {
            this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 4, 0, 3, sbb);
        }
        for (int z = 2; z < 5; ++z) {
            this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.WEST), 3, 1, z, sbb);
            this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.EAST), 5, 1, z, sbb);
        }
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), 4, 1, 2, sbb);
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH), 4, 1, 4, sbb);
        this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), 4, 2, 3, sbb);
        return true;
    }
}
