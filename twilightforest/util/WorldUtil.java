// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.world.level.LevelAccessor;
import java.util.Random;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;

public final class WorldUtil
{
    private WorldUtil() {
    }
    
    public static Iterable<BlockPos> getAllAround(final BlockPos center, final int range) {
        return BlockPos.m_121940_(center.m_142082_(-range, -range, -range), center.m_142082_(range, range, range));
    }
    
    public static Iterable<BlockPos> getAllInBB(final AABB bb) {
        return BlockPos.m_121976_((int)bb.f_82288_, (int)bb.f_82289_, (int)bb.f_82290_, (int)bb.f_82291_, (int)bb.f_82292_, (int)bb.f_82293_);
    }
    
    public static BlockPos randomOffset(final Random random, final BlockPos pos, final int range) {
        return randomOffset(random, pos, range, range, range);
    }
    
    public static BlockPos randomOffset(final Random random, final BlockPos pos, final int rx, final int ry, final int rz) {
        final int dx = random.nextInt(rx * 2 + 1) - rx;
        final int dy = random.nextInt(ry * 2 + 1) - ry;
        final int dz = random.nextInt(rz * 2 + 1) - rz;
        return pos.m_142082_(dx, dy, dz);
    }
    
    @Nullable
    public static ChunkGeneratorTwilight getChunkGenerator(final LevelAccessor level) {
        if (level instanceof final ServerLevel serverLevel) {
            final ChunkGenerator f_8328_ = serverLevel.m_7726_().f_8328_;
            if (f_8328_ instanceof final ChunkGeneratorTwilight chunkGenerator) {
                return chunkGenerator;
            }
        }
        return null;
    }
    
    public static int getSeaLevel(final Level world) {
        return getSeaLevel(getChunkGenerator((LevelAccessor)world));
    }
    
    public static int getSeaLevel(final ChunkSource source) {
        int seaLevel;
        if (source instanceof final ServerChunkCache serverCache) {
            seaLevel = getSeaLevel(serverCache.f_8328_);
        }
        else {
            seaLevel = 0;
        }
        return seaLevel;
    }
    
    public static int getSeaLevel(final ChunkGenerator generator) {
        if (generator instanceof ChunkGeneratorTwilight) {
            return generator.m_6337_();
        }
        return 0;
    }
    
    public static int getBaseHeight(final LevelAccessor level, final int x, final int z, final Heightmap.Types type) {
        final ChunkSource 7726_ = level.m_7726_();
        if (7726_ instanceof final ServerChunkCache chunkSource) {
            return chunkSource.f_8328_.m_142647_(x, z, type, (LevelHeightAccessor)level);
        }
        return level.m_6924_(type, x, z);
    }
}
