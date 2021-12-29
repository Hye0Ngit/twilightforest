// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import twilightforest.util.FeatureUtil;
import java.util.ArrayList;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import java.util.List;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.IWorldGenerationReader;
import twilightforest.worldgen.TwilightFeatures;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;

public class HollowTrunkPlacer extends AbstractTrunkPlacer
{
    public static final Codec<HollowTrunkPlacer> CODEC;
    private final float outerRadius;
    private final int randomAddRadius;
    private final BranchesConfig branchesConfig;
    private final BlockStateProvider ladder;
    
    public HollowTrunkPlacer(final int baseHeight, final int randomHeightA, final int randomHeightB, final float outerRadius, final int randomAddRadius, final BranchesConfig branchesConfig, final BlockStateProvider ladder) {
        super(baseHeight, randomHeightA, randomHeightB);
        this.outerRadius = outerRadius;
        this.randomAddRadius = randomAddRadius;
        this.branchesConfig = branchesConfig;
        this.ladder = ladder;
    }
    
    protected TrunkPlacerType<HollowTrunkPlacer> func_230381_a_() {
        return TwilightFeatures.HOLLOW_TRUNK;
    }
    
    public List<FoliagePlacer.Foliage> func_230382_a_(final IWorldGenerationReader world, final Random random, final int height, final BlockPos pos, final Set<BlockPos> trunkBlocks, final MutableBoundingBox mutableBoundingBox, final BaseTreeFeatureConfig baseTreeFeatureConfig) {
        final float additionalRadius = (float)random.nextInt(this.randomAddRadius + 1);
        final float outerRadius = this.outerRadius + additionalRadius;
        final float hollowRadius = outerRadius / 2.0f;
        final float outerRadiusSquared = outerRadius * outerRadius;
        final float hollowRadiusSquared = hollowRadius * hollowRadius;
        final ArrayList<FoliagePlacer.Foliage> leaves = new ArrayList<FoliagePlacer.Foliage>();
        this.buildTrunk(world, random, height, pos, trunkBlocks, mutableBoundingBox, baseTreeFeatureConfig, outerRadius, outerRadiusSquared, hollowRadiusSquared);
        this.buildFullCrown(world, random, pos, leaves, trunkBlocks, outerRadius, height, mutableBoundingBox, baseTreeFeatureConfig);
        return leaves;
    }
    
    private void buildTrunk(final IWorldGenerationReader world, final Random random, final int height, final BlockPos startPos, final Set<BlockPos> trunkBlocks, final MutableBoundingBox mutableBoundingBox, final BaseTreeFeatureConfig baseTreeFeatureConfig, final float outerRadius, final float outerRadiusSquared, final float hollowRadiusSquared) {
        boolean notHollow = false;
        for (int z = 0; z <= outerRadius; ++z) {
            for (int x = (int)outerRadius; x >= 0; --x) {
                final int dist = x * x + z * z;
                if (dist < outerRadiusSquared) {
                    final boolean trunkDelta = notHollow;
                    notHollow = (dist >= hollowRadiusSquared);
                    for (int y = 0; y <= height; ++y) {
                        final BlockPos dPos = startPos.func_177982_a(x, y, z);
                        if (trunkDelta && !notHollow) {
                            world.func_180501_a(dPos, this.ladder.func_225574_a_(random, dPos), 3);
                            final BlockPos opposite = startPos.func_177982_a(x, y, -z);
                            if (!dPos.equals((Object)opposite)) {
                                world.func_180501_a(opposite, this.ladder.func_225574_a_(random, opposite), 3);
                            }
                        }
                        if (notHollow) {
                            func_236911_a_(world, random, dPos, (Set)trunkBlocks, mutableBoundingBox, baseTreeFeatureConfig);
                            func_236911_a_(world, random, startPos.func_177982_a(-x, y, -z), (Set)trunkBlocks, mutableBoundingBox, baseTreeFeatureConfig);
                            func_236911_a_(world, random, startPos.func_177982_a(-z, y, x), (Set)trunkBlocks, mutableBoundingBox, baseTreeFeatureConfig);
                            func_236911_a_(world, random, startPos.func_177982_a(z, y, -x), (Set)trunkBlocks, mutableBoundingBox, baseTreeFeatureConfig);
                        }
                    }
                }
            }
        }
    }
    
    protected void buildFullCrown(final IWorldGenerationReader world, final Random random, final BlockPos pos, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final float diameter, final int height, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final int crownRadius = (int)(diameter * 4.0f + 4.0f);
        final int bvar = (int)(diameter + 2.0f);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height - crownRadius, 0, (float)crownRadius, 0.35, bvar, bvar + 2, 2, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height - (crownRadius >> 1), 0, (float)crownRadius, 0.28, bvar, bvar + 2, 1, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height, 0, (float)crownRadius, 0.15, 2, 4, 2, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height, 0, (float)(crownRadius >> 1), 0.05, bvar, bvar + 2, 1, true, mbb, config);
    }
    
    protected void buildBranchRing(final IWorldGenerationReader world, final Random random, final BlockPos pos, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final float diameter, final int branchHeight, final int heightVar, final float length, final double tilt, final int minBranches, final int maxBranches, final int size, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
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
    
    protected void makeLargeBranch(final IWorldGenerationReader world, final Random random, final BlockPos pos, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final float diameter, final int branchHeight, final float length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeLargeBranch(world, random, src, leaves, branch, length, angle, tilt, leafy, mbb, config);
    }
    
    protected void makeLargeBranch(final IWorldGenerationReader world, final Random random, final BlockPos src, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final float length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        FeatureUtil.drawBresenhamBranch(world, random, src, dest, branch, mbb, config);
        for (int reinforcements = random.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            FeatureUtil.drawBresenhamBranch(world, random, src.func_177982_a(vx, vy, vz), dest, branch, mbb, config);
        }
        if (leafy) {
            leaves.add(new FoliagePlacer.Foliage(dest.func_177984_a(), 3, false));
        }
        for (int numMedBranches = random.nextInt((int)(length / 6.0f)) + random.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
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
    }
    
    protected void makeMedBranch(final IWorldGenerationReader world, final Random random, final BlockPos pos, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final float diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeMedBranch(world, random, src, leaves, branch, length, angle, tilt, leafy, mbb, config);
    }
    
    protected void makeMedBranch(final IWorldGenerationReader world, final Random random, final BlockPos src, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        FeatureUtil.drawBresenhamBranch(world, random, src, dest, branch, mbb, config);
        if (leafy) {
            leaves.add(new FoliagePlacer.Foliage(dest, 2, false));
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
    
    protected void makeSmallBranch(final IWorldGenerationReader world, final Random random, final BlockPos src, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        FeatureUtil.drawBresenhamBranch(world, random, src, dest, branch, mbb, config);
        if (leafy) {
            leaves.add(new FoliagePlacer.Foliage(dest, random.nextInt(2) + 1, false));
        }
    }
    
    protected void makeSmallBranch(final IWorldGenerationReader world, final Random random, final BlockPos pos, final List<FoliagePlacer.Foliage> leaves, final Set<BlockPos> branch, final float diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        this.makeSmallBranch(world, random, src, leaves, branch, length, angle, tilt, leafy, mbb, config);
    }
    
    protected void makeRoot(final IWorldGenerationReader world, final Random random, final BlockPos pos, final float diameter, final int branchHeight, final double length, final double angle, final double tilt, final BaseTreeFeatureConfig config) {
        final BlockPos src = FeatureUtil.translate(pos.func_177981_b(branchHeight), diameter, angle, 0.5);
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        final BlockPos[] lineArray = FeatureUtil.getBresenhamArrays(src, dest);
        boolean stillAboveGround = true;
        for (final BlockPos coord : lineArray) {
            if (stillAboveGround && FeatureUtil.hasAirAround(world, coord)) {
                world.func_180501_a(coord, config.field_227368_m_.func_225574_a_(random, coord), 3);
                world.func_180501_a(coord.func_177977_b(), config.field_227368_m_.func_225574_a_(random, coord.func_177977_b()), 3);
            }
            else {
                world.func_180501_a(coord, config.field_227368_m_.func_225574_a_(random, coord), 3);
                world.func_180501_a(coord.func_177977_b(), config.field_227368_m_.func_225574_a_(random, coord.func_177977_b()), 3);
                stillAboveGround = false;
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> func_236915_a_(instance).and(instance.group((App)Codec.floatRange(1.0f, 16.0f).fieldOf("outside_radius").forGetter(o -> o.outerRadius), (App)Codec.intRange(0, 8).fieldOf("random_add_radius").forGetter(o -> o.randomAddRadius), (App)BranchesConfig.CODEC.fieldOf("branch_config").forGetter(o -> o.branchesConfig), (App)BlockStateProvider.field_236796_a_.fieldOf("eastside_ladder").forGetter(o -> o.ladder))).apply((Applicative)instance, HollowTrunkPlacer::new));
    }
}
