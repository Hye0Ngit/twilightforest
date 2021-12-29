// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.state.BlockState;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.core.Direction;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeRoomSpawnerChestsComponent extends MazeRoomComponent
{
    public MazeRoomSpawnerChestsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRSC, nbt);
    }
    
    public MazeRoomSpawnerChestsComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRSC, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.placePillarEnclosure(world, sbb, 3, 3);
        this.placePillarEnclosure(world, sbb, 10, 3);
        this.placePillarEnclosure(world, sbb, 3, 10);
        this.placePillarEnclosure(world, sbb, 10, 10);
        this.setSpawner(world, 4, 2, 4, sbb, TFEntities.MINOTAUR);
        this.placeTreasureAtCurrentPosition(world, 4, 2, 11, TFTreasure.LABYRINTH_ROOM, sbb);
        this.placeTreasureAtCurrentPosition(world, 11, 2, 4, TFTreasure.LABYRINTH_ROOM, sbb);
        this.m_73434_(world, Blocks.f_50167_.m_49966_(), 11, 1, 11, sbb);
        this.m_73434_(world, Blocks.f_50077_.m_49966_(), 10, 0, 11, sbb);
        this.m_73434_(world, Blocks.f_50077_.m_49966_(), 11, 0, 10, sbb);
        this.m_73434_(world, Blocks.f_50077_.m_49966_(), 11, 0, 12, sbb);
        this.m_73434_(world, Blocks.f_50077_.m_49966_(), 12, 0, 11, sbb);
        return true;
    }
    
    private void placePillarEnclosure(final WorldGenLevel world, final BoundingBox sbb, final int dx, final int dz) {
        for (int y = 1; y < 5; ++y) {
            final BlockState chiselledMazeBlock = ((Block)TFBlocks.CUT_MAZESTONE.get()).m_49966_();
            this.m_73434_(world, chiselledMazeBlock, dx, y, dz, sbb);
            this.m_73434_(world, chiselledMazeBlock, dx + 2, y, dz, sbb);
            this.m_73434_(world, chiselledMazeBlock, dx, y, dz + 2, sbb);
            this.m_73434_(world, chiselledMazeBlock, dx + 2, y, dz + 2, sbb);
        }
        this.m_73434_(world, Blocks.f_50705_.m_49966_(), dx + 1, 1, dz + 1, sbb);
        this.m_73434_(world, Blocks.f_50705_.m_49966_(), dx + 1, 4, dz + 1, sbb);
        final BlockState defaultState = Blocks.f_50086_.m_49966_();
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.NORTH, false), dx + 1, 1, dz, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.WEST, false), dx, 1, dz + 1, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.EAST, false), dx + 2, 1, dz + 1, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.SOUTH, false), dx + 1, 1, dz + 2, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.NORTH, true), dx + 1, 4, dz, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.WEST, true), dx, 4, dz + 1, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.EAST, true), dx + 2, 4, dz + 1, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(defaultState, Direction.SOUTH, true), dx + 1, 4, dz + 2, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx + 1, 2, dz, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx, 2, dz + 1, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx + 2, 2, dz + 1, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx + 1, 2, dz + 2, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx + 1, 3, dz, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx, 3, dz + 1, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx + 2, 3, dz + 1, sbb);
        this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx + 1, 3, dz + 2, sbb);
    }
}
