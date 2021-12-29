// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import twilightforest.loot.TFTreasure;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
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

public class MazeRoomVaultComponent extends MazeRoomComponent
{
    public MazeRoomVaultComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRV, nbt);
    }
    
    public MazeRoomVaultComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRV, feature, i, rand, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 0, 1, 0, 15, 4, 15, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 0, 2, 0, 15, 3, 15, ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73535_(world, sbb, 6, 2, 6, 9, 3, 9);
        this.m_73441_(world, sbb, 6, 2, 5, 9, 2, 5, Blocks.f_50167_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 2, 10, 9, 2, 10, Blocks.f_50167_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 2, 6, 5, 2, 9, Blocks.f_50167_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 10, 2, 6, 10, 2, 9, Blocks.f_50167_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 4, 5, 9, 4, 5, Blocks.f_49992_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 4, 10, 9, 4, 10, Blocks.f_49992_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 4, 6, 5, 4, 9, Blocks.f_49992_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 10, 4, 6, 10, 4, 9, Blocks.f_49992_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 0, 5, 9, 0, 5, Blocks.f_50077_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 0, 10, 9, 0, 10, Blocks.f_50077_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 0, 6, 5, 0, 9, Blocks.f_50077_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.m_73441_(world, sbb, 10, 0, 6, 10, 0, 9, Blocks.f_50077_.m_49966_(), MazeRoomVaultComponent.AIR, false);
        this.setDoubleLootChest(world, 7, 2, 6, 8, 2, 6, Direction.SOUTH, TFTreasure.LABYRINTH_VAULT, sbb, false);
        this.setDoubleLootChest(world, 8, 2, 9, 7, 2, 9, Direction.NORTH, TFTreasure.LABYRINTH_VAULT, sbb, false);
        this.setDoubleLootChest(world, 6, 2, 8, 6, 2, 7, Direction.EAST, TFTreasure.LABYRINTH_VAULT, sbb, false);
        this.setDoubleLootChest(world, 9, 2, 7, 9, 2, 8, Direction.WEST, TFTreasure.LABYRINTH_VAULT, sbb, false);
        return true;
    }
}
