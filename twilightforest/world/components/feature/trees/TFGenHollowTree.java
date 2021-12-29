// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import java.util.Iterator;
import twilightforest.util.VoxelBresenhamIterator;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.util.FeatureLogic;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.VineBlock;
import twilightforest.util.FeaturePlacers;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import com.mojang.serialization.Codec;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;

public class TFGenHollowTree extends TFTreeGenerator<TFTreeFeatureConfig>
{
    private static final int LEAF_DUNGEON_CHANCE = 8;
    
    public TFGenHollowTree(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    public boolean generate(final WorldGenLevel world, final Random random, final BlockPos pos, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final BiConsumer<BlockPos, BlockState> decorationPlacer, final TFTreeFeatureConfig config) {
        final int diameter = random.nextInt(3) + 2;
        final int height = random.nextInt(64) + diameter * 4;
        if (world.m_151562_(pos.m_123342_()) || world.m_151562_(pos.m_123342_() + height + diameter)) {
            return false;
        }
        for (int crownRadius = diameter * 4 + 8, dx = -crownRadius; dx <= crownRadius; ++dx) {
            for (int dz = -crownRadius; dz <= crownRadius; ++dz) {
                for (int dy = height - crownRadius; dy <= height + crownRadius; ++dy) {
                    final Block whatsThere = world.m_8055_(pos.m_142082_(dx, dy, dz)).m_60734_();
                    if (whatsThere != Blocks.f_50016_ && !(whatsThere instanceof LeavesBlock)) {
                        return false;
                    }
                }
            }
        }
        final BlockState state = world.m_8055_(pos.m_7495_());
        if (!state.m_60734_().canSustainPlant(state, (BlockGetter)world, pos.m_7495_(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.buildTrunk((LevelAccessor)world, trunkPlacer, decorationPlacer, random, pos, diameter, height, config);
        for (int numFireflies = random.nextInt(6 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addFirefly((LevelAccessor)world, pos, diameter, fHeight, fAngle);
        }
        for (int numCicadas = random.nextInt(3 * diameter) + 5, j = 0; j <= numCicadas; ++j) {
            final int fHeight2 = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle2 = random.nextDouble();
            this.addCicada((LevelAccessor)world, pos, diameter, fHeight2, fAngle2);
        }
        this.buildFullCrown(world, trunkPlacer, leavesPlacer, random, pos, diameter, height, config);
        for (int numBranches = random.nextInt(3) + 3, k = 0; k <= numBranches; ++k) {
            final int branchHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double branchRotation = random.nextDouble();
            this.makeSmallBranch((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos, diameter, branchHeight, 4.0, branchRotation, 0.35, true, config);
        }
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, 3, 2, 6, 0.75, 3, 5, 3, false, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, 1, 2, 8, 0.9, 3, 5, 3, false, config);
        return true;
    }
    
    protected void buildFullCrown(final WorldGenLevel world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int diameter, final int height, final TFTreeFeatureConfig config) {
        final int crownRadius = diameter * 4 + 3;
        final int bvar = diameter + 2;
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height - crownRadius, 0, crownRadius, 0.35, bvar, bvar + 2, 2, true, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height - crownRadius / 2, 0, crownRadius, 0.28, bvar, bvar + 2, 1, true, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height, 0, crownRadius, 0.15, 2, 4, 2, true, config);
        this.buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, diameter, height, 0, crownRadius / 2, 0.05, bvar, bvar + 2, 1, true, config);
    }
    
    protected void buildBranchRing(final WorldGenLevel world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final int heightVar, final int length, final double tilt, final int minBranches, final int maxBranches, final int size, final boolean leafy, final TFTreeFeatureConfig config) {
        final int numBranches = random.nextInt(maxBranches - minBranches) + minBranches;
        final double branchRotation = 1.0 / (numBranches + 1);
        final double branchOffset = random.nextDouble();
        for (int i = 0; i <= numBranches; ++i) {
            int dHeight;
            if (heightVar > 0) {
                dHeight = branchHeight - heightVar + random.nextInt(2 * heightVar);
            }
            else {
                dHeight = branchHeight;
            }
            if (size == 2) {
                this.makeLargeBranch(world, trunkPlacer, leavesPlacer, random, pos, diameter, dHeight, length - 2, i * branchRotation + branchOffset, tilt, leafy, config);
            }
            else if (size == 1) {
                this.makeMedBranch((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos, diameter, dHeight, length - 1, i * branchRotation + branchOffset, tilt, leafy, config);
            }
            else if (size == 3) {
                this.makeRoot((LevelAccessor)world, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, config);
            }
            else {
                this.makeSmallBranch((LevelAccessor)world, trunkPlacer, leavesPlacer, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy, config);
            }
        }
    }
    
    protected void buildTrunk(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> decoPlacer, final Random random, final BlockPos pos, final int diameter, final int height, final TFTreeFeatureConfig config) {
        final int hollow = diameter >> 1;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = Math.max(ax, az) + (Math.min(ax, az) >> 1);
                    if (dist <= diameter) {
                        final BlockPos dPos = pos.m_142082_(dx, dy, dz);
                        if (FeatureUtil.hasAirAround(world, dPos)) {
                            if (dist > hollow) {
                                FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, random, dPos, config.trunkProvider);
                            }
                            else {
                                FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, random, dPos, config.branchProvider);
                            }
                        }
                        else {
                            FeaturePlacers.placeIfValidRootPos(world, decoPlacer, random, dPos, config.rootsProvider);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = 0; dy <= height; ++dy) {
                    final BlockPos dPos2 = pos.m_142082_(dx, dy, dz);
                    final int ax2 = Math.abs(dx);
                    final int az2 = Math.abs(dz);
                    final int dist2 = (int)(Math.max(ax2, az2) + Math.min(ax2, az2) * 0.5);
                    if (dist2 <= diameter && dist2 > hollow) {
                        FeaturePlacers.placeIfValidTreePos(world, trunkPlacer, random, dPos2, config.trunkProvider);
                    }
                    if (dist2 <= hollow) {}
                    if (dist2 == hollow && dx == hollow) {
                        world.m_7731_(dPos2, (BlockState)Blocks.f_50191_.m_49966_().m_61124_((Property)VineBlock.f_57835_, (Comparable)true), 3);
                    }
                }
            }
        }
    }
    
    protected void makeMedBranch(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureLogic.translate(pos.m_6630_(branchHeight), diameter, angle, 0.5);
        this.makeMedBranch(world, trunkPlacer, leavesPlacer, random, src, length, angle, tilt, leafy, config);
    }
    
    protected void makeMedBranch(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos src, final double length, final double angle, final double tilt, final boolean leafy, final TFTreeFeatureConfig config) {
        final BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        FeaturePlacers.drawBresenhamBranch(world, trunkPlacer, random, src, dest, config.branchProvider);
        if (leafy) {
            FeaturePlacers.placeSpheroid((LevelSimulatedReader)world, leavesPlacer, FeaturePlacers.VALID_TREE_POS, random, dest, 2.5f, 2.5f, config.leavesProvider);
        }
        final int numShoots = random.nextInt(2) + 1;
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i <= numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = random.nextDouble() * 0.8 + 0.2;
            final double tiltVar = random.nextDouble() * 0.75 + 0.15;
            final BlockPos bsrc = FeatureLogic.translate(src, length * outVar, angle, tilt);
            final double slength = length * 0.4;
            this.makeSmallBranch(world, trunkPlacer, leavesPlacer, random, bsrc, slength, angle + angleVar, tilt * tiltVar, leafy, config);
        }
    }
    
    protected void makeSmallBranch(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos src, final double length, final double angle, final double tilt, final boolean leafy, final TFTreeFeatureConfig config) {
        final BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        FeaturePlacers.drawBresenhamBranch(world, trunkPlacer, random, src, dest, config.branchProvider);
        if (leafy) {
            final float leafRad = random.nextInt(2) + 1.5f;
            FeaturePlacers.placeSpheroid((LevelSimulatedReader)world, leavesPlacer, FeaturePlacers.VALID_TREE_POS, random, dest, leafRad, leafRad, config.leavesProvider);
        }
    }
    
    protected void makeSmallBranch(final LevelAccessor world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureLogic.translate(pos.m_6630_(branchHeight), diameter, angle, 0.5);
        this.makeSmallBranch(world, trunkPlacer, leavesPlacer, random, src, length, angle, tilt, leafy, config);
    }
    
    protected void makeRoot(final LevelAccessor world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureLogic.translate(pos.m_6630_(branchHeight), diameter, angle, 0.5);
        final BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        boolean stillAboveGround = true;
        for (final BlockPos coord : new VoxelBresenhamIterator(src, dest)) {
            if (stillAboveGround && FeatureUtil.hasAirAround(world, coord)) {
                world.m_7731_(coord, config.branchProvider.m_7112_(random, coord), 3);
                world.m_7731_(coord.m_7495_(), config.branchProvider.m_7112_(random, coord.m_7495_()), 3);
            }
            else {
                world.m_7731_(coord, config.rootsProvider.m_7112_(random, coord), 3);
                world.m_7731_(coord.m_7495_(), config.rootsProvider.m_7112_(random, coord.m_7495_()), 3);
                stillAboveGround = false;
            }
        }
    }
    
    protected void makeLargeBranch(final WorldGenLevel world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos src, final double length, final double angle, final double tilt, final boolean leafy, final TFTreeFeatureConfig config) {
        final BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        FeaturePlacers.drawBresenhamBranch((LevelAccessor)world, trunkPlacer, random, src, dest, config.branchProvider);
        for (int reinforcements = random.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            FeaturePlacers.drawBresenhamBranch((LevelAccessor)world, trunkPlacer, random, src.m_142082_(vx, vy, vz), dest, config.branchProvider);
        }
        if (leafy) {
            FeaturePlacers.placeSpheroid((LevelSimulatedReader)world, leavesPlacer, FeaturePlacers.VALID_TREE_POS, random, dest.m_7494_(), 3.5f, 3.5f, config.leavesProvider);
        }
        for (int numMedBranches = random.nextInt((int)(length / 6.0)) + random.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
            final double outVar = random.nextDouble() * 0.3 + 0.3;
            final double angleVar = random.nextDouble() * 0.225 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc = FeatureLogic.translate(src, length * outVar, angle, tilt);
            this.makeMedBranch((LevelAccessor)world, trunkPlacer, leavesPlacer, random, bsrc, length * 0.6, angle + angleVar, tilt, leafy, config);
        }
        for (int numSmallBranches = random.nextInt(2) + 1, k = 0; k <= numSmallBranches; ++k) {
            final double outVar2 = random.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = random.nextDouble() * 0.25 * (((k & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc2 = FeatureLogic.translate(src, length * outVar2, angle, tilt);
            this.makeSmallBranch((LevelAccessor)world, trunkPlacer, leavesPlacer, random, bsrc2, Math.max(length * 0.3, 2.0), angle + angleVar2, tilt, leafy, config);
        }
        if (random.nextInt(8) == 0) {
            this.makeLeafDungeon(world, leavesPlacer, random, dest.m_7494_(), config);
        }
    }
    
    private void makeLeafDungeon(final WorldGenLevel world, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final TFTreeFeatureConfig config) {
        FeaturePlacers.placeSpheroid((LevelSimulatedReader)world, leavesPlacer, FeaturePlacers.VALID_TREE_POS, random, pos, 4.5f, 4.5f, config.leavesProvider);
        FeatureUtil.drawBlob((LevelAccessor)world, pos, 3, config.branchProvider.m_7112_(random, pos));
        FeatureUtil.drawBlob((LevelAccessor)world, pos, 2, Blocks.f_50016_.m_49966_());
        world.m_7731_(pos.m_7494_(), Blocks.f_50085_.m_49966_(), 18);
        final SpawnerBlockEntity ms = (SpawnerBlockEntity)world.m_7702_(pos.m_7494_());
        if (ms != null) {
            ms.m_59801_().m_45462_((EntityType)TFEntities.SWARM_SPIDER);
        }
        this.makeLeafDungeonChest(world, random, pos);
    }
    
    private void makeLeafDungeonChest(final WorldGenLevel world, final Random random, BlockPos pos) {
        final Direction chestDir = Direction.Plane.HORIZONTAL.m_122560_(random);
        pos = pos.m_5484_(chestDir, 2);
        TFTreasure.TREE_CACHE.generateChest(world, pos.m_7495_(), chestDir.m_122424_(), false);
    }
    
    protected void makeLargeBranch(final WorldGenLevel world, final BiConsumer<BlockPos, BlockState> trunkPlacer, final BiConsumer<BlockPos, BlockState> leavesPlacer, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureLogic.translate(pos.m_6630_(branchHeight), diameter, angle, 0.5);
        this.makeLargeBranch(world, trunkPlacer, leavesPlacer, random, src, length, angle, tilt, leafy, config);
    }
    
    protected void addFirefly(final LevelAccessor world, final BlockPos pos, final int diameter, final int fHeight, double fAngle) {
        final BlockPos src = FeatureLogic.translate(pos.m_6630_(fHeight), diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        Direction facing = Direction.EAST;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            facing = Direction.SOUTH;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            facing = Direction.EAST;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            facing = Direction.NORTH;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            facing = Direction.WEST;
        }
        if (((BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)facing)).m_60710_((LevelReader)world, src)) {
            world.m_7731_(src, (BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)facing), 3);
        }
    }
    
    protected void addCicada(final LevelAccessor world, final BlockPos pos, final int diameter, final int fHeight, double fAngle) {
        final BlockPos src = FeatureLogic.translate(pos.m_6630_(fHeight), diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        Direction facing = Direction.EAST;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            facing = Direction.SOUTH;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            facing = Direction.EAST;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            facing = Direction.NORTH;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            facing = Direction.WEST;
        }
        if (((BlockState)((Block)TFBlocks.CICADA.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)facing)).m_60710_((LevelReader)world, src)) {
            world.m_7731_(src, (BlockState)((Block)TFBlocks.CICADA.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)facing), 3);
        }
    }
}
