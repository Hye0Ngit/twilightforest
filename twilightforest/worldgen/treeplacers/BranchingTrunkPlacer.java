// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import twilightforest.util.FeatureUtil;
import com.google.common.collect.Lists;
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
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;

public class BranchingTrunkPlacer extends AbstractTrunkPlacer
{
    public static final Codec<BranchingTrunkPlacer> CODEC;
    private final int branchDownwardOffset;
    private final BranchesConfig branchesConfig;
    private final boolean perpendicularBranches;
    
    public BranchingTrunkPlacer(final int baseHeight, final int randomHeightA, final int randomHeightB, final int branchDownwardOffset, final BranchesConfig branchesConfig, final boolean perpendicularBranches) {
        super(baseHeight, randomHeightA, randomHeightB);
        this.branchDownwardOffset = branchDownwardOffset;
        this.branchesConfig = branchesConfig;
        this.perpendicularBranches = perpendicularBranches;
    }
    
    protected TrunkPlacerType<BranchingTrunkPlacer> func_230381_a_() {
        return TwilightFeatures.TRUNK_BRANCHING;
    }
    
    public List<FoliagePlacer.Foliage> func_230382_a_(final IWorldGenerationReader world, final Random random, int height, final BlockPos startPos, final Set<BlockPos> trunkBlocks, final MutableBoundingBox mutableBoundingBox, final BaseTreeFeatureConfig baseTreeFeatureConfig) {
        final List<FoliagePlacer.Foliage> leafBlocks = Lists.newArrayList();
        for (int y = 0; y <= height; ++y) {
            if (!func_236911_a_(world, random, startPos.func_177981_b(y), (Set)trunkBlocks, mutableBoundingBox, baseTreeFeatureConfig)) {
                height = y;
                break;
            }
        }
        leafBlocks.add(new FoliagePlacer.Foliage(startPos.func_177981_b(height), 0, false));
        final int numBranches = this.branchesConfig.branchCount + random.nextInt(this.branchesConfig.randomAddBranches + 1);
        final float offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            buildBranch(world, startPos, trunkBlocks, leafBlocks, height - this.branchDownwardOffset + b, this.branchesConfig.length, this.branchesConfig.spacingYaw * b + offset, this.branchesConfig.downwardsPitch, random, mutableBoundingBox, baseTreeFeatureConfig, this.perpendicularBranches);
        }
        return leafBlocks;
    }
    
    private static void buildBranch(final IWorldGenerationReader world, final BlockPos pos, final Set<BlockPos> trunkBlocks, final List<FoliagePlacer.Foliage> leafBlocks, final int height, final double length, final double angle, final double tilt, final Random treeRNG, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config, final boolean perpendicularBranches) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = FeatureUtil.translate(src, length, angle, tilt);
        if (perpendicularBranches) {
            drawBresenhamBranch(world, treeRNG, src, new BlockPos(dest.func_177958_n(), src.func_177956_o(), dest.func_177952_p()), trunkBlocks, mbb, config);
            for (int max = Math.max(src.func_177956_o(), dest.func_177956_o()), i = Math.min(src.func_177956_o(), dest.func_177956_o()); i < max + 1; ++i) {
                func_236911_a_(world, treeRNG, new BlockPos(dest.func_177958_n(), i, dest.func_177952_p()), (Set)trunkBlocks, mbb, config);
            }
        }
        else {
            drawBresenhamBranch(world, treeRNG, src, dest, trunkBlocks, mbb, config);
        }
        func_236911_a_(world, treeRNG, dest.func_177974_f(), (Set)trunkBlocks, mbb, config);
        func_236911_a_(world, treeRNG, dest.func_177976_e(), (Set)trunkBlocks, mbb, config);
        func_236911_a_(world, treeRNG, dest.func_177968_d(), (Set)trunkBlocks, mbb, config);
        func_236911_a_(world, treeRNG, dest.func_177978_c(), (Set)trunkBlocks, mbb, config);
        leafBlocks.add(new FoliagePlacer.Foliage(dest, 0, false));
    }
    
    private static void drawBresenhamBranch(final IWorldGenerationReader world, final Random random, final BlockPos from, final BlockPos to, final Set<BlockPos> state, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        for (final BlockPos pixel : FeatureUtil.getBresenhamArrays(from, to)) {
            func_236911_a_(world, random, pixel, (Set)state, mbb, config);
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> func_236915_a_(instance).and(instance.group((App)Codec.intRange(0, 24).fieldOf("branch_start_offset_down").forGetter(o -> o.branchDownwardOffset), (App)BranchesConfig.CODEC.fieldOf("branch_config").forGetter(o -> o.branchesConfig), (App)Codec.BOOL.fieldOf("perpendicular_branches").forGetter(o -> o.perpendicularBranches))).apply((Applicative)instance, BranchingTrunkPlacer::new));
    }
}
