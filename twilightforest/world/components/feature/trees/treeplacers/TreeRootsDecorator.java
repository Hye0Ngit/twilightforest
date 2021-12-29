// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import net.minecraft.world.level.block.Blocks;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Iterator;
import java.util.function.Predicate;
import twilightforest.util.VoxelBresenhamIterator;
import twilightforest.util.FeatureLogic;
import java.util.List;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.function.BiConsumer;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.world.registration.TwilightFeatures;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import java.util.Optional;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

public class TreeRootsDecorator extends TreeDecorator
{
    private static final SimpleStateProvider EMPTY;
    public static final Codec<TreeRootsDecorator> CODEC;
    private final int strands;
    private final int addExtraStrands;
    private final int length;
    private final BlockStateProvider surfaceBlock;
    private final BlockStateProvider rootBlock;
    private final boolean hasSurfaceRoots;
    
    private TreeRootsDecorator(final int count, final int addExtraStrands, final int length, final Optional<BlockStateProvider> surfaceBlock, final BlockStateProvider rootBlock) {
        this.strands = count;
        this.addExtraStrands = addExtraStrands;
        this.length = length;
        this.rootBlock = rootBlock;
        final boolean present = surfaceBlock.isPresent();
        this.hasSurfaceRoots = present;
        if (present) {
            this.surfaceBlock = surfaceBlock.get();
        }
        else {
            this.surfaceBlock = (BlockStateProvider)TreeRootsDecorator.EMPTY;
        }
    }
    
    public TreeRootsDecorator(final int count, final int addExtraStrands, final int length, final BlockStateProvider rootBlock) {
        this.strands = count;
        this.addExtraStrands = addExtraStrands;
        this.length = length;
        this.rootBlock = rootBlock;
        this.hasSurfaceRoots = false;
        this.surfaceBlock = (BlockStateProvider)TreeRootsDecorator.EMPTY;
    }
    
    public TreeRootsDecorator(final int count, final int addExtraStrands, final int length, final BlockStateProvider surfaceBlock, final BlockStateProvider rootBlock) {
        this.strands = count;
        this.addExtraStrands = addExtraStrands;
        this.length = length;
        this.rootBlock = rootBlock;
        this.hasSurfaceRoots = true;
        this.surfaceBlock = surfaceBlock;
    }
    
    protected TreeDecoratorType<TreeRootsDecorator> m_6663_() {
        return TwilightFeatures.TREE_ROOTS;
    }
    
    public void m_142741_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks) {
        if (trunkBlocks.isEmpty()) {
            return;
        }
        final int numBranches = this.strands + random.nextInt(this.addExtraStrands + 1);
        final float offset = random.nextFloat();
        final BlockPos startPos = trunkBlocks.get(0);
        if (this.hasSurfaceRoots) {
            for (int i = 0; i < numBranches; ++i) {
                this.buildRootExposed(worldReader, worldPlacer, random, startPos, offset, i, this.length, this.surfaceBlock, this.rootBlock);
            }
        }
        else {
            for (int i = 0; i < numBranches; ++i) {
                this.buildRoot(worldReader, worldPlacer, random, startPos, offset, i, this.length, this.rootBlock);
            }
        }
    }
    
    protected void buildRootExposed(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final BlockPos pos, final double offset, final int iteration, final int length, final BlockStateProvider airRoot, final BlockStateProvider dirtRoot) {
        final BlockPos dest = FeatureLogic.translate(pos.m_6625_(iteration + 2), length, 0.3 * iteration + offset, 0.8);
        boolean stillAboveGround = true;
        for (final BlockPos coord : new VoxelBresenhamIterator(pos.m_7495_(), dest)) {
            if (stillAboveGround && FeatureLogic.hasEmptyNeighbor(worldReader, coord)) {
                if (worldReader.m_7433_(coord, (Predicate)FeatureLogic::isReplaceable)) {
                    worldPlacer.accept(coord, airRoot.m_7112_(random, coord));
                }
                else {
                    if (!worldReader.m_7433_(coord, (Predicate)FeatureLogic.SHOULD_SKIP)) {
                        break;
                    }
                    continue;
                }
            }
            else {
                stillAboveGround = false;
                if (FeatureLogic.canRootGrowIn(worldReader, coord)) {
                    worldPlacer.accept(coord, dirtRoot.m_7112_(random, coord));
                }
                else {
                    if (!worldReader.m_7433_(coord, (Predicate)FeatureLogic.SHOULD_SKIP)) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    protected void buildRoot(final LevelSimulatedReader world, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final BlockPos pos, final double offset, final int iteration, final int length, final BlockStateProvider dirtRoot) {
        final BlockPos dest = FeatureLogic.translate(pos.m_6625_(iteration + 2), length, 0.3 * iteration + offset, 0.8);
        for (final BlockPos coord : new VoxelBresenhamIterator(pos.m_7495_(), dest)) {
            if (FeatureLogic.canRootGrowIn(world, coord)) {
                worldPlacer.accept(coord, dirtRoot.m_7112_(random, coord));
            }
            else {
                if (!world.m_7433_(coord, (Predicate)FeatureLogic.SHOULD_SKIP)) {
                    break;
                }
                continue;
            }
        }
    }
    
    static {
        EMPTY = new SimpleStateProvider(Blocks.f_50016_.m_49966_());
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 16).fieldOf("base_strand_count").forGetter(o -> o.strands), (App)Codec.intRange(0, 16).fieldOf("additional_random_strands").forGetter(o -> o.addExtraStrands), (App)Codec.intRange(0, 32).fieldOf("root_length").forGetter(o -> o.length), (App)BlockStateProvider.f_68747_.optionalFieldOf("exposed_roots_provider").forGetter(o -> Optional.ofNullable((o.surfaceBlock != TreeRootsDecorator.EMPTY) ? o.surfaceBlock : null)), (App)BlockStateProvider.f_68747_.fieldOf("ground_roots_provider").forGetter(o -> o.rootBlock)).apply((Applicative)instance, TreeRootsDecorator::new));
    }
}
