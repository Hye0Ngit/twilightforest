// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.IWorldReader;
import twilightforest.world.feature.TFTreeGenerator;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import java.util.Random;
import net.minecraft.world.ISeedReader;
import twilightforest.worldgen.TwilightFeatures;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import java.util.Optional;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

public class TreeRootsDecorator extends TreeDecorator
{
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
            this.surfaceBlock = null;
        }
    }
    
    public TreeRootsDecorator(final int count, final int addExtraStrands, final int length, final BlockStateProvider rootBlock) {
        this.strands = count;
        this.addExtraStrands = addExtraStrands;
        this.length = length;
        this.rootBlock = rootBlock;
        this.hasSurfaceRoots = false;
        this.surfaceBlock = null;
    }
    
    public TreeRootsDecorator(final int count, final int addExtraStrands, final int length, final BlockStateProvider surfaceBlock, final BlockStateProvider rootBlock) {
        this.strands = count;
        this.addExtraStrands = addExtraStrands;
        this.length = length;
        this.rootBlock = rootBlock;
        this.hasSurfaceRoots = true;
        this.surfaceBlock = surfaceBlock;
    }
    
    protected TreeDecoratorType<TreeRootsDecorator> func_230380_a_() {
        return TwilightFeatures.TREE_ROOTS;
    }
    
    public void func_225576_a_(final ISeedReader world, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks, final Set<BlockPos> decorations, final MutableBoundingBox mutableBoundingBox) {
        if (trunkBlocks.isEmpty()) {
            return;
        }
        final int numBranches = this.strands + random.nextInt(this.addExtraStrands + 1);
        final float offset = random.nextFloat();
        final BlockPos startPos = trunkBlocks.get(0);
        if (this.hasSurfaceRoots) {
            for (int i = 0; i < numBranches; ++i) {
                this.buildRootWithAir(world, random, startPos, decorations, offset, i, this.length, mutableBoundingBox, this.surfaceBlock, this.rootBlock);
            }
        }
        else {
            for (int i = 0; i < numBranches; ++i) {
                this.buildRoot(world, random, startPos, decorations, offset, i, this.length, mutableBoundingBox, this.rootBlock);
            }
        }
    }
    
    protected void buildRootWithAir(final ISeedReader world, final Random random, final BlockPos pos, final Set<BlockPos> decorations, final double offset, final int iteration, final int length, final MutableBoundingBox mutableBoundingBox, final BlockStateProvider airRoot, final BlockStateProvider dirtRoot) {
        final BlockPos dest = FeatureUtil.translate(pos.func_177979_c(iteration + 2), length, 0.3 * iteration + offset, 0.8);
        final BlockPos[] lineArray = FeatureUtil.getBresenhamArrays(pos.func_177977_b(), dest);
        boolean stillAboveGround = true;
        for (final BlockPos coord : lineArray) {
            if (stillAboveGround && FeatureUtil.hasAirAround((IWorld)world, coord)) {
                this.func_227423_a_((IWorldWriter)world, coord, airRoot.func_225574_a_(random, coord), (Set)decorations, mutableBoundingBox);
            }
            else {
                stillAboveGround = false;
                if (TFTreeGenerator.canRootGrowIn((IWorldReader)world, coord)) {
                    this.func_227423_a_((IWorldWriter)world, coord, dirtRoot.func_225574_a_(random, coord), (Set)decorations, mutableBoundingBox);
                }
            }
        }
    }
    
    protected void buildRoot(final ISeedReader world, final Random random, final BlockPos pos, final Set<BlockPos> decorations, final double offset, final int iteration, final int length, final MutableBoundingBox mutableBoundingBox, final BlockStateProvider dirtRoot) {
        final BlockPos dest = FeatureUtil.translate(pos.func_177979_c(iteration + 2), length, 0.3 * iteration + offset, 0.8);
        final BlockPos[] bresenhamArrays;
        final BlockPos[] lineArray = bresenhamArrays = FeatureUtil.getBresenhamArrays(pos.func_177977_b(), dest);
        for (final BlockPos coord : bresenhamArrays) {
            if (TFTreeGenerator.canRootGrowIn((IWorldReader)world, coord)) {
                this.func_227423_a_((IWorldWriter)world, coord, dirtRoot.func_225574_a_(random, coord), (Set)decorations, mutableBoundingBox);
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 16).fieldOf("base_strand_count").forGetter(o -> o.strands), (App)Codec.intRange(0, 16).fieldOf("additional_random_strands").forGetter(o -> o.addExtraStrands), (App)Codec.intRange(0, 32).fieldOf("root_length").forGetter(o -> o.length), (App)BlockStateProvider.field_236796_a_.optionalFieldOf("air_roots_provider").forGetter(o -> Optional.ofNullable(o.surfaceBlock)), (App)BlockStateProvider.field_236796_a_.fieldOf("ground_roots_provider").forGetter(o -> o.rootBlock)).apply((Applicative)instance, TreeRootsDecorator::new));
    }
}
