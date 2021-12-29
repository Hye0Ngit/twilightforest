// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.BlockState;
import twilightforest.structures.TFStructureComponentOld;
import net.minecraft.util.Direction;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeRoomSpawnerChestsComponent extends MazeRoomComponent
{
    public MazeRoomSpawnerChestsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMRSC, nbt);
    }
    
    public MazeRoomSpawnerChestsComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRSC, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.placePillarEnclosure(world, sbb, 3, 3);
        this.placePillarEnclosure(world, sbb, 10, 3);
        this.placePillarEnclosure(world, sbb, 3, 10);
        this.placePillarEnclosure(world, sbb, 10, 10);
        this.setSpawner(world, 4, 2, 4, sbb, TFEntities.minotaur);
        this.placeTreasureAtCurrentPosition(world, 4, 2, 11, TFTreasure.labyrinth_room, sbb);
        this.placeTreasureAtCurrentPosition(world, 11, 2, 4, TFTreasure.labyrinth_room, sbb);
        this.func_175811_a(world, Blocks.field_196663_cq.func_176223_P(), 11, 1, 11, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 10, 0, 11, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 11, 0, 10, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 11, 0, 12, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 12, 0, 11, sbb);
        return true;
    }
    
    private void placePillarEnclosure(final ISeedReader world, final MutableBoundingBox sbb, final int dx, final int dz) {
        for (int y = 1; y < 5; ++y) {
            final BlockState chiselledMazeBlock = ((Block)TFBlocks.maze_stone_chiseled.get()).func_176223_P();
            this.func_175811_a(world, chiselledMazeBlock, dx, y, dz, sbb);
            this.func_175811_a(world, chiselledMazeBlock, dx + 2, y, dz, sbb);
            this.func_175811_a(world, chiselledMazeBlock, dx, y, dz + 2, sbb);
            this.func_175811_a(world, chiselledMazeBlock, dx + 2, y, dz + 2, sbb);
        }
        this.func_175811_a(world, Blocks.field_196662_n.func_176223_P(), dx + 1, 1, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_196662_n.func_176223_P(), dx + 1, 4, dz + 1, sbb);
        final BlockState defaultState = Blocks.field_150476_ad.func_176223_P();
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.NORTH, false), dx + 1, 1, dz, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.WEST, false), dx, 1, dz + 1, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.EAST, false), dx + 2, 1, dz + 1, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.SOUTH, false), dx + 1, 1, dz + 2, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.NORTH, true), dx + 1, 4, dz, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.WEST, true), dx, 4, dz + 1, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.EAST, true), dx + 2, 4, dz + 1, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(defaultState, Direction.SOUTH, true), dx + 1, 4, dz + 2, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 2, dz, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx, 2, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 2, 2, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 2, dz + 2, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 3, dz, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx, 3, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 2, 3, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 3, dz + 2, sbb);
    }
}
