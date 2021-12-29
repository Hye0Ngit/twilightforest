// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import java.util.Iterator;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import java.util.function.BiFunction;

public final class FeaturePlacers
{
    public static final BiFunction<LevelSimulatedReader, BlockPos, Boolean> VALID_TREE_POS;
    
    public static <T extends Mob> void placeEntity(final EntityType<T> entityType, final BlockPos pos, final ServerLevelAccessor levelAccessor) {
        final Mob mob = (Mob)entityType.m_20615_((Level)levelAccessor.m_6018_());
        if (mob == null) {
            return;
        }
        mob.m_21530_();
        mob.m_20035_(pos, 0.0f, 0.0f);
        mob.m_6518_(levelAccessor, levelAccessor.m_6436_(pos), MobSpawnType.STRUCTURE, (SpawnGroupData)null, (CompoundTag)null);
        levelAccessor.m_47205_((Entity)mob);
        levelAccessor.m_7731_(pos, Blocks.f_50016_.m_49966_(), 2);
    }
    
    public static void drawBresenhamBranch(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final Random random, final BlockPos start, final BlockPos end, final BlockStateProvider config) {
        for (final BlockPos pixel : new VoxelBresenhamIterator(start, end)) {
            placeIfValidTreePos(world, trunkPlacer, random, pixel, config);
        }
    }
    
    public static void buildRoot(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> placer, final Random rand, final BlockPos start, final double offset, final int b, final BlockStateProvider config) {
        final BlockPos dest = FeatureLogic.translate(start.m_6625_(b + 2), 5.0, 0.3 * b + offset, 0.8);
        for (final BlockPos coord : new VoxelBresenhamIterator(start.m_7495_(), dest)) {
            if (!placeIfValidRootPos(world, placer, rand, coord, config)) {
                return;
            }
        }
    }
    
    public static void drawBresenhamTree(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> placer, final BiFunction<LevelSimulatedReader, BlockPos, Boolean> predicate, final BlockPos from, final BlockPos to, final BlockStateProvider config, final Random random) {
        for (final BlockPos pixel : new VoxelBresenhamIterator(from, to)) {
            placeProvidedBlock(world, placer, predicate, pixel, config, random);
        }
    }
    
    public static void placeProvidedBlock(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> worldPlacer, final BiFunction<LevelSimulatedReader, BlockPos, Boolean> predicate, final BlockPos pos, final BlockStateProvider config, final Random random) {
        if (predicate.apply(world, pos)) {
            worldPlacer.accept(pos, config.m_7112_(random, pos));
        }
    }
    
    public static void placeCircleOdd(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> placer, final BiFunction<LevelSimulatedReader, BlockPos, Boolean> predicate, final Random random, final BlockPos centerPos, final float radius, final BlockStateProvider config) {
        final float radiusSquared = radius * radius;
        placeProvidedBlock(world, placer, predicate, centerPos, config, random);
        for (int x = 0; x <= radius; ++x) {
            for (int z = 1; z <= radius; ++z) {
                if (x * x + z * z <= radiusSquared) {
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, 0, z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, 0, -z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, 0, x), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, 0, -x), config, random);
                }
            }
        }
    }
    
    public static void placeCircleEven(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> placer, final BiFunction<LevelSimulatedReader, BlockPos, Boolean> predicate, final Random random, final BlockPos centerPos, final float radius, final BlockStateProvider config) {
        final float radiusSquared = radius * radius;
        placeProvidedBlock(world, placer, predicate, centerPos, config, random);
        for (int x = 0; x <= radius; ++x) {
            for (int z = 0; z <= radius; ++z) {
                if (x * x + z * z <= radiusSquared) {
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(1 + x, 0, 1 + z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, 0, -z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, 0, 1 + z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(1 + x, 0, -z), config, random);
                }
            }
        }
    }
    
    public static void placeSpheroid(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> placer, final BiFunction<LevelSimulatedReader, BlockPos, Boolean> predicate, final Random random, final BlockPos centerPos, final float xzRadius, final float yRadius, final float verticalBias, final BlockStateProvider config) {
        final float xzRadiusSquared = xzRadius * xzRadius;
        final float yRadiusSquared = yRadius * yRadius;
        final float superRadiusSquared = xzRadiusSquared * yRadiusSquared;
        placeProvidedBlock(world, placer, predicate, centerPos, config, random);
        for (int y = 0; y <= yRadius; ++y) {
            if (y <= yRadius) {
                placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(0, y, 0), config, random);
                placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(0, -y, 0), config, random);
            }
        }
        for (int x = 0; x <= xzRadius; ++x) {
            for (int z = 1; z <= xzRadius; ++z) {
                if (x * x + z * z <= xzRadiusSquared) {
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, 0, z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, 0, -z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, 0, x), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, 0, -x), config, random);
                    for (int y2 = 1; y2 <= yRadius; ++y2) {
                        final float xzSquare = (x * x + z * z) * yRadiusSquared;
                        if (xzSquare + (y2 - verticalBias) * (y2 - verticalBias) * xzRadiusSquared <= superRadiusSquared) {
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, y2, z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, y2, -z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, y2, x), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, y2, -x), config, random);
                        }
                        if (xzSquare + (y2 + verticalBias) * (y2 + verticalBias) * xzRadiusSquared <= superRadiusSquared) {
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, -y2, z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, -y2, -z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, -y2, x), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, -y2, -x), config, random);
                        }
                    }
                }
            }
        }
    }
    
    public static void placeSpheroid(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> placer, final BiFunction<LevelSimulatedReader, BlockPos, Boolean> predicate, final Random random, final BlockPos centerPos, final float xzRadius, final float yRadius, final BlockStateProvider config) {
        final float xzRadiusSquared = xzRadius * xzRadius;
        final float yRadiusSquared = yRadius * yRadius;
        final float superRadiusSquared = xzRadiusSquared * yRadiusSquared;
        placeProvidedBlock(world, placer, predicate, centerPos, config, random);
        for (int y = 0; y <= yRadius; ++y) {
            if (y <= yRadius) {
                placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(0, y, 0), config, random);
                placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(0, -y, 0), config, random);
            }
        }
        for (int x = 0; x <= xzRadius; ++x) {
            for (int z = 1; z <= xzRadius; ++z) {
                if (x * x + z * z <= xzRadiusSquared) {
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, 0, z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, 0, -z), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, 0, x), config, random);
                    placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, 0, -x), config, random);
                    for (int y2 = 1; y2 <= yRadius; ++y2) {
                        final float xzSquare = (x * x + z * z) * yRadiusSquared;
                        if (xzSquare + y2 * y2 * xzRadiusSquared <= superRadiusSquared) {
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, y2, z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, y2, -z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, y2, x), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, y2, -x), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(x, -y2, z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-x, -y2, -z), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(-z, -y2, x), config, random);
                            placeProvidedBlock(world, placer, predicate, centerPos.m_142082_(z, -y2, -x), config, random);
                        }
                    }
                }
            }
        }
    }
    
    public static boolean placeIfValidTreePos(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> placer, final Random random, final BlockPos pos, final BlockStateProvider config) {
        if (TreeFeature.m_67272_((LevelSimulatedReader)world, pos)) {
            placer.accept(pos, config.m_7112_(random, pos));
            return true;
        }
        return false;
    }
    
    public static boolean placeIfValidRootPos(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> placer, final Random random, final BlockPos pos, final BlockStateProvider config) {
        if (FeatureLogic.canRootGrowIn((LevelSimulatedReader)world, pos)) {
            placer.accept(pos, config.m_7112_(random, pos));
            return true;
        }
        return false;
    }
    
    public static void addFirefly(final LevelAccessor world, final BlockPos pos, final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            setIfEmpty(world, pos.m_142082_(1, height, 0), (BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.EAST));
        }
        else if (iAngle == 1) {
            setIfEmpty(world, pos.m_142082_(-1, height, 0), (BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.WEST));
        }
        else if (iAngle == 2) {
            setIfEmpty(world, pos.m_142082_(0, height, 1), (BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.SOUTH));
        }
        else if (iAngle == 3) {
            setIfEmpty(world, pos.m_142082_(0, height, -1), (BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.NORTH));
        }
    }
    
    private static void setIfEmpty(final LevelAccessor world, final BlockPos pos, final BlockState state) {
        if (world.m_46859_(pos)) {
            world.m_7731_(pos, state, 3);
        }
    }
    
    public static BlockState transferAllStateKeys(final BlockState stateIn, final Block blockOut) {
        return transferAllStateKeys(stateIn, blockOut.m_49966_());
    }
    
    public static BlockState transferAllStateKeys(final BlockState stateIn, BlockState stateOut) {
        for (final Property<?> property : stateOut.m_61147_()) {
            stateOut = transferStateKey(stateIn, stateOut, property);
        }
        return stateOut;
    }
    
    public static <T extends Comparable<T>> BlockState transferStateKey(final BlockState stateIn, final BlockState stateOut, final Property<T> property) {
        return (BlockState)stateOut.m_61124_((Property)property, stateIn.m_61143_((Property)property));
    }
    
    static {
        VALID_TREE_POS = TreeFeature::m_67272_;
    }
}
