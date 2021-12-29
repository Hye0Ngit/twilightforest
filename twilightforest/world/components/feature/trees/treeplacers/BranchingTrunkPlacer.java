// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Iterator;
import twilightforest.util.VoxelBresenhamIterator;
import twilightforest.util.FeatureLogic;
import com.google.common.collect.Lists;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import java.util.List;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.function.BiConsumer;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.world.registration.TwilightFeatures;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

public class BranchingTrunkPlacer extends TrunkPlacer
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
    
    protected TrunkPlacerType<BranchingTrunkPlacer> m_7362_() {
        return TwilightFeatures.TRUNK_BRANCHING;
    }
    
    public List<FoliagePlacer.FoliageAttachment> m_142625_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, int height, final BlockPos startPos, final TreeConfiguration treeConfig) {
        final List<FoliagePlacer.FoliageAttachment> leafAttachments = Lists.newArrayList();
        for (int y = 0; y <= height; ++y) {
            if (!m_161893_(worldReader, (BiConsumer)worldPlacer, random, startPos.m_6630_(y), treeConfig)) {
                height = y;
                break;
            }
        }
        leafAttachments.add(new FoliagePlacer.FoliageAttachment(startPos.m_6630_(height), 0, false));
        final int numBranches = this.branchesConfig.branchCount + random.nextInt(this.branchesConfig.randomAddBranches + 1);
        final float offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            buildBranch(worldReader, worldPlacer, startPos, leafAttachments, height - this.branchDownwardOffset + b, this.branchesConfig.length, this.branchesConfig.spacingYaw * b + offset, this.branchesConfig.downwardsPitch, random, treeConfig, this.perpendicularBranches);
        }
        return leafAttachments;
    }
    
    private static void buildBranch(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final BlockPos pos, final List<FoliagePlacer.FoliageAttachment> leafBlocks, final int height, final double length, final double angle, final double tilt, final Random treeRNG, final TreeConfiguration treeConfig, final boolean perpendicularBranches) {
        final BlockPos src = pos.m_6630_(height);
        final BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        if (perpendicularBranches) {
            drawBresenhamBranch(worldReader, worldPlacer, treeRNG, src, new BlockPos(dest.m_123341_(), src.m_123342_(), dest.m_123343_()), treeConfig);
            for (int max = Math.max(src.m_123342_(), dest.m_123342_()), i = Math.min(src.m_123342_(), dest.m_123342_()); i < max + 1; ++i) {
                m_161893_(worldReader, (BiConsumer)worldPlacer, treeRNG, new BlockPos(dest.m_123341_(), i, dest.m_123343_()), treeConfig);
            }
        }
        else {
            drawBresenhamBranch(worldReader, worldPlacer, treeRNG, src, dest, treeConfig);
        }
        m_161893_(worldReader, (BiConsumer)worldPlacer, treeRNG, dest.m_142126_(), treeConfig);
        m_161893_(worldReader, (BiConsumer)worldPlacer, treeRNG, dest.m_142125_(), treeConfig);
        m_161893_(worldReader, (BiConsumer)worldPlacer, treeRNG, dest.m_142128_(), treeConfig);
        m_161893_(worldReader, (BiConsumer)worldPlacer, treeRNG, dest.m_142127_(), treeConfig);
        leafBlocks.add(new FoliagePlacer.FoliageAttachment(dest, 0, false));
    }
    
    private static void drawBresenhamBranch(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final BlockPos from, final BlockPos to, final TreeConfiguration config) {
        for (final BlockPos pixel : new VoxelBresenhamIterator(from, to)) {
            m_161893_(worldReader, (BiConsumer)worldPlacer, random, pixel, config);
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> m_70305_(instance).and(instance.group((App)Codec.intRange(0, 24).fieldOf("branch_start_offset_down").forGetter(o -> o.branchDownwardOffset), (App)BranchesConfig.CODEC.fieldOf("branch_config").forGetter(o -> o.branchesConfig), (App)Codec.BOOL.fieldOf("perpendicular_branches").forGetter(o -> o.perpendicularBranches))).apply((Applicative)instance, BranchingTrunkPlacer::new));
    }
}
