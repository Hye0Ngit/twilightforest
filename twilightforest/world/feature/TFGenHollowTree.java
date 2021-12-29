// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.IWorldReader;
import net.minecraft.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.VineBlock;
import twilightforest.util.FeatureUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.Direction;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.IWorld;
import com.mojang.serialization.Codec;
import twilightforest.world.feature.config.TFTreeFeatureConfig;

public class TFGenHollowTree extends TFTreeGenerator<TFTreeFeatureConfig>
{
    private static final int LEAF_DUNGEON_CHANCE = 8;
    
    public TFGenHollowTree(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    public boolean generate(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final Set<BlockPos> branch, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int diameter = random.nextInt(3) + 2;
        final int height = random.nextInt(64) + diameter * 4;
        if (pos.func_177956_o() < 1 || pos.func_177956_o() + height + diameter > 256) {
            return false;
        }
        for (int crownRadius = diameter * 4 + 8, dx = -crownRadius; dx <= crownRadius; ++dx) {
            for (int dz = -crownRadius; dz <= crownRadius; ++dz) {
                for (int dy = height - crownRadius; dy <= height + crownRadius; ++dy) {
                    final Block whatsThere = world.func_180495_p(pos.func_177982_a(dx, dy, dz)).func_177230_c();
                    if (whatsThere != Blocks.field_150350_a && !(whatsThere instanceof LeavesBlock)) {
                        return false;
                    }
                }
            }
        }
        final BlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockReader)world, pos.func_177977_b(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.buildTrunk(world, random, pos, trunk, branch, root, diameter, height, mbb, config);
        for (int numFireflies = random.nextInt(6 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addFirefly(world, pos, diameter, fHeight, fAngle);
        }
        for (int numCicadas = random.nextInt(3 * diameter) + 5, j = 0; j <= numCicadas; ++j) {
            final int fHeight2 = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle2 = random.nextDouble();
            this.addCicada(world, pos, diameter, fHeight2, fAngle2);
        }
        this.buildFullCrown(world, random, pos, leaves, branch, diameter, height, mbb, config);
        for (int numBranches = random.nextInt(3) + 3, k = 0; k <= numBranches; ++k) {
            final int branchHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double branchRotation = random.nextDouble();
            this.makeSmallBranch(world, random, pos, leaves, branch, diameter, branchHeight, 4.0, branchRotation, 0.35, true, mbb, config);
        }
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, 3, 2, 6, 0.75, 3, 5, 3, false, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, 1, 2, 8, 0.9, 3, 5, 3, false, mbb, config);
        return true;
    }
    
    protected void buildFullCrown(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final int diameter, final int height, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int crownRadius = diameter * 4 + 4;
        final int bvar = diameter + 2;
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height - crownRadius, 0, crownRadius, 0.35, bvar, bvar + 2, 2, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height - crownRadius / 2, 0, crownRadius, 0.28, bvar, bvar + 2, 1, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height, 0, crownRadius, 0.15, 2, 4, 2, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height, 0, crownRadius / 2, 0.05, bvar, bvar + 2, 1, true, mbb, config);
    }
    
    protected void buildBranchRing(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final int diameter, final int branchHeight, final int heightVar, final int length, final double tilt, final int minBranches, final int maxBranches, final int size, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
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
                this.makeLargeBranch(world, random, pos, leaves, branch, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy, mbb, config);
            }
            else if (size == 1) {
                this.makeMedBranch(world, random, pos, leaves, branch, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy, mbb, config);
            }
            else if (size == 3) {
                this.makeRoot(world, random, pos, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, config);
            }
            else {
                this.makeSmallBranch(world, random, pos, leaves, branch, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy, mbb, config);
            }
        }
    }
    
    protected void buildTrunk(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> branch, final Set<BlockPos> root, final int diameter, final int height, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int hollow = diameter / 2;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        final BlockPos dPos = pos.func_177982_a(dx, dy, dz);
                        if (FeatureUtil.hasAirAround(world, dPos)) {
                            if (dist > hollow) {
                                this.setLogBlockState(world, random, dPos, trunk, mbb, config);
                            }
                            else {
                                this.setBranchBlockState(world, random, dPos, branch, mbb, config);
                            }
                        }
                        else {
                            this.setRootsBlockState(world, random, dPos, root, mbb, config);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = 0; dy <= height; ++dy) {
                    final BlockPos dPos2 = pos.func_177982_a(dx, dy, dz);
                    final int ax2 = Math.abs(dx);
                    final int az2 = Math.abs(dz);
                    final int dist2 = (int)(Math.max(ax2, az2) + Math.min(ax2, az2) * 0.5);
                    if (dist2 <= diameter && dist2 > hollow) {
                        this.setLogBlockState(world, random, dPos2, trunk, mbb, config);
                    }
                    if (dist2 <= hollow) {}
                    if (dist2 == hollow && dx == hollow) {
                        world.func_180501_a(dPos2, (BlockState)Blocks.field_150395_bd.func_176223_P().func_206870_a((Property)VineBlock.field_176278_M, (Comparable)true), 3);
                    }
                }
            }
        }
    }
    
    protected void makeMedBranch(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeMedBranch(world, random, src, leaves, branch, length, angle, tilt, leafy, mbb, config);
    }
    
    protected void makeMedBranch(final IWorld world, final Random random, final BlockPos src, final Set<BlockPos> leaves, final Set<BlockPos> branch, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        FeatureUtil.drawBresenhamBranch(this, world, random, src, dest, branch, mbb, config);
        if (leafy) {
            FeatureUtil.drawLeafBlob(world, dest, 2, config.leavesProvider.func_225574_a_(random, dest), leaves);
        }
        final int numShoots = random.nextInt(2) + 1;
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i <= numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = random.nextDouble() * 0.8 + 0.2;
            final double tiltVar = random.nextDouble() * 0.75 + 0.15;
            final BlockPos bsrc = FeatureUtil.translate(src, length * outVar, angle, tilt);
            final double slength = length * 0.4;
            this.makeSmallBranch(world, random, bsrc, leaves, branch, slength, angle + angleVar, tilt * tiltVar, leafy, mbb, config);
        }
    }
    
    protected void makeSmallBranch(final IWorld world, final Random random, final BlockPos src, final Set<BlockPos> leaves, final Set<BlockPos> branch, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        FeatureUtil.drawBresenhamBranch(this, world, random, src, dest, branch, mbb, config);
        if (leafy) {
            final byte leafRad = (byte)(random.nextInt(2) + 1);
            FeatureUtil.drawLeafBlob(world, dest, leafRad, config.leavesProvider.func_225574_a_(random, dest), leaves);
        }
    }
    
    protected void makeSmallBranch(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeSmallBranch(world, random, src, leaves, branch, length, angle, tilt, leafy, mbb, config);
    }
    
    protected void makeRoot(final IWorld world, final Random random, final BlockPos pos, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        final BlockPos[] lineArray = FeatureUtil.getBresenhamArrays(src, dest);
        boolean stillAboveGround = true;
        for (final BlockPos coord : lineArray) {
            if (stillAboveGround && FeatureUtil.hasAirAround(world, coord)) {
                world.func_180501_a(coord, config.branchProvider.func_225574_a_(random, coord), 3);
                world.func_180501_a(coord.func_177977_b(), config.branchProvider.func_225574_a_(random, coord.func_177977_b()), 3);
            }
            else {
                world.func_180501_a(coord, config.rootsProvider.func_225574_a_(random, coord), 3);
                world.func_180501_a(coord.func_177977_b(), config.rootsProvider.func_225574_a_(random, coord.func_177977_b()), 3);
                stillAboveGround = false;
            }
        }
    }
    
    protected void makeLargeBranch(final IWorld world, final Random random, final BlockPos src, final Set<BlockPos> leaves, final Set<BlockPos> branch, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        FeatureUtil.drawBresenhamBranch(this, world, random, src, dest, branch, mbb, config);
        for (int reinforcements = random.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            FeatureUtil.drawBresenhamBranch(this, world, random, src.func_177982_a(vx, vy, vz), dest, branch, mbb, config);
        }
        if (leafy) {
            FeatureUtil.drawLeafBlob(world, dest.func_177984_a(), 3, config.leavesProvider.func_225574_a_(random, dest.func_177984_a()), leaves);
        }
        for (int numMedBranches = random.nextInt((int)(length / 6.0)) + random.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
            final double outVar = random.nextDouble() * 0.3 + 0.3;
            final double angleVar = random.nextDouble() * 0.225 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc = FeatureUtil.translate(src, length * outVar, angle, tilt);
            this.makeMedBranch(world, random, bsrc, leaves, branch, length * 0.6, angle + angleVar, tilt, leafy, mbb, config);
        }
        for (int numSmallBranches = random.nextInt(2) + 1, k = 0; k <= numSmallBranches; ++k) {
            final double outVar2 = random.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = random.nextDouble() * 0.25 * (((k & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc2 = FeatureUtil.translate(src, length * outVar2, angle, tilt);
            this.makeSmallBranch(world, random, bsrc2, leaves, branch, Math.max(length * 0.3, 2.0), angle + angleVar2, tilt, leafy, mbb, config);
        }
        if (random.nextInt(8) == 0) {
            this.makeLeafDungeon(world, random, dest.func_177984_a(), leaves, config);
        }
    }
    
    private void makeLeafDungeon(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final TFTreeFeatureConfig config) {
        FeatureUtil.drawLeafBlob(world, pos, 4, config.leavesProvider.func_225574_a_(random, pos), leaves);
        FeatureUtil.drawBlob(world, pos, 3, config.branchProvider.func_225574_a_(random, pos));
        FeatureUtil.drawBlob(world, pos, 2, Blocks.field_150350_a.func_176223_P());
        world.func_180501_a(pos.func_177984_a(), Blocks.field_150474_ac.func_176223_P(), 18);
        final MobSpawnerTileEntity ms = (MobSpawnerTileEntity)world.func_175625_s(pos.func_177984_a());
        if (ms != null) {
            ms.func_145881_a().func_200876_a((EntityType)TFEntities.swarm_spider);
        }
        this.makeLeafDungeonChest(world, random, pos);
    }
    
    private void makeLeafDungeonChest(final IWorld world, final Random random, BlockPos pos) {
        pos = pos.func_177972_a(Direction.Plane.HORIZONTAL.func_179518_a(random));
        TFTreasure.tree_cache.generateChest(world, pos.func_177977_b(), Direction.NORTH, false);
    }
    
    protected void makeLargeBranch(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeLargeBranch(world, random, src, leaves, branch, length, angle, tilt, leafy, mbb, config);
    }
    
    protected void addFirefly(final IWorld world, final BlockPos pos, final int diameter, final int fHeight, double fAngle) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(fHeight), diameter + 1, fAngle, 0.5);
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
        if (((BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)facing)).func_196955_c((IWorldReader)world, src)) {
            world.func_180501_a(src, (BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)facing), 3);
        }
    }
    
    protected void addCicada(final IWorld world, final BlockPos pos, final int diameter, final int fHeight, double fAngle) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(fHeight), diameter + 1, fAngle, 0.5);
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
        if (((BlockState)((Block)TFBlocks.cicada.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)facing)).func_196955_c((IWorldReader)world, src)) {
            world.func_180501_a(src, (BlockState)((Block)TFBlocks.cicada.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)facing), 3);
        }
    }
}
