// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.loot.TFTreasure;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.block.Blocks;
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

public class StrongholdTreasureRoomComponent extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public StrongholdTreasureRoomComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFTreaR, nbt);
        this.enterBottom = nbt.func_74767_n("enterBottom");
    }
    
    public StrongholdTreasureRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFTreaR, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("enterBottom", this.enterBottom);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return MutableBoundingBox.func_175897_a(x, y, z, -4, -1, 0, 9, 7, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addDoor(4, 1, 0);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 17, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 1, 1, 13, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 4, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 13, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 4, 1, 16, Rotation.NONE, sbb);
        this.func_74882_a(world, sbb, 1, 1, 8, 7, 5, 9, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 3, 1, 8, 5, 4, 9, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
        this.setSpawner(world, 4, 1, 4, sbb, TFEntities.helmet_crab);
        this.setSpawner(world, 4, 4, 15, sbb, TFEntities.helmet_crab);
        this.manualTreaurePlacement(world, 2, 4, 13, Direction.WEST, TFTreasure.stronghold_room, false, sbb);
        this.manualTreaurePlacement(world, 6, 4, 13, Direction.EAST, TFTreasure.stronghold_room, false, sbb);
        this.placeDoors(world, sbb);
        return true;
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
}
