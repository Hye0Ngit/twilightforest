// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
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

public class MazeRoomBossComponent extends MazeRoomComponent
{
    public MazeRoomBossComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRB, nbt);
    }
    
    public MazeRoomBossComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRB, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.m_73398_((BlockGetter)world, 7, 1, 0, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.f_50132_.m_49966_(), MazeRoomBossComponent.AIR, false);
        }
        if (this.m_73398_((BlockGetter)world, 7, 1, 15, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.f_50132_.m_49966_(), MazeRoomBossComponent.AIR, false);
        }
        if (this.m_73398_((BlockGetter)world, 0, 1, 7, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.f_50132_.m_49966_(), MazeRoomBossComponent.AIR, false);
        }
        if (this.m_73398_((BlockGetter)world, 15, 1, 7, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.f_50132_.m_49966_(), MazeRoomBossComponent.AIR, false);
        }
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                final boolean mycelium = rand.nextInt(dist + 1) > 0;
                final boolean mushroom = rand.nextInt(dist) > 0;
                final boolean mushRed = rand.nextBoolean();
                if (mycelium) {
                    this.m_73434_(world, Blocks.f_50195_.m_49966_(), x, 0, z, sbb);
                }
                if (mushroom) {
                    this.m_73434_(world, (mushRed ? Blocks.f_50073_ : Blocks.f_50072_).m_49966_(), x, 1, z, sbb);
                }
            }
        }
        final BlockState redMushroom = Blocks.f_50181_.m_49966_();
        final BlockState brownMushroom = Blocks.f_50180_.m_49966_();
        this.m_73441_(world, sbb, 1, 1, 1, 3, 1, 3, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 2, 1, 1, 3, 4, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 2, 2, 1, 4, 3, 1, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 4, 1, 3, 4, 3, redMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 3, 2, 3, TFTreasure.LABYRINTH_ROOM, sbb);
        this.m_73441_(world, sbb, 12, 1, 12, 14, 1, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 14, 2, 11, 14, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 11, 2, 14, 14, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 12, 4, 12, 14, 4, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 12, 2, 12, TFTreasure.LABYRINTH_ROOM, sbb);
        this.m_73441_(world, sbb, 1, 1, 12, 3, 1, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 2, 11, 1, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 2, 2, 14, 4, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 4, 12, 3, 4, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 3, 2, 12, TFTreasure.LABYRINTH_ROOM, sbb);
        this.m_73441_(world, sbb, 12, 1, 1, 14, 1, 3, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 11, 2, 1, 14, 3, 1, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 14, 2, 2, 14, 3, 4, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 12, 4, 1, 14, 4, 3, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 12, 2, 3, TFTreasure.LABYRINTH_ROOM, sbb);
        this.m_73441_(world, sbb, 5, 4, 5, 7, 5, 7, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.m_73441_(world, sbb, 8, 4, 8, 10, 5, 10, redMushroom, MazeRoomBossComponent.AIR, false);
        final BlockState taurSpawner = ((Block)TFBlocks.MINOSHROOM_BOSS_SPAWNER.get()).m_49966_();
        this.setBlockStateRotated(world, taurSpawner, 7, 2, 7, Rotation.NONE, sbb);
        return true;
    }
}
