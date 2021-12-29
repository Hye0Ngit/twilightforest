// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiConsumer;
import java.util.Set;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import com.google.common.collect.Iterables;
import net.minecraft.world.level.LevelSimulatedReader;
import java.util.Comparator;
import net.minecraft.core.Vec3i;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;

public abstract class TFTreeGenerator<T extends TFTreeFeatureConfig> extends Feature<T>
{
    public TFTreeGenerator(final Codec<T> configIn) {
        super((Codec)configIn);
    }
    
    public final boolean m_142674_(final FeaturePlaceContext<T> context) {
        final WorldGenLevel contextWorldGenLevel = context.m_159774_();
        final Random contextRandom = context.m_159776_();
        final BlockPos contextBlockPos = context.m_159777_();
        final T contextConfig = (T)context.m_159778_();
        final Set<BlockPos> trunkSet = Sets.newHashSet();
        final Set<BlockPos> leavesSet = Sets.newHashSet();
        final Set<BlockPos> decorationSet = Sets.newHashSet();
        final BiConsumer<BlockPos, BlockState> trunkPlacer = (pos, state) -> {
            trunkSet.add(pos.m_7949_());
            contextWorldGenLevel.m_7731_(pos, state, 19);
            return;
        };
        final BiConsumer<BlockPos, BlockState> leavesPlacer = (pos, state) -> {
            leavesSet.add(pos.m_7949_());
            contextWorldGenLevel.m_7731_(pos, state, 19);
            return;
        };
        final BiConsumer<BlockPos, BlockState> decorationPlacer = (pos, state) -> {
            decorationSet.add(pos.m_7949_());
            contextWorldGenLevel.m_7731_(pos, state, 19);
            return;
        };
        if (this.generate(contextWorldGenLevel, contextRandom, contextBlockPos, trunkPlacer, leavesPlacer, decorationPlacer, contextConfig) && (!trunkSet.isEmpty() || !leavesSet.isEmpty())) {
            if (!contextConfig.decorators.isEmpty()) {
                final List<BlockPos> trunkList = Lists.newArrayList((Iterable)trunkSet);
                final List<BlockPos> leavesList = Lists.newArrayList((Iterable)leavesSet);
                trunkList.sort(Comparator.comparingInt(Vec3i::m_123342_));
                leavesList.sort(Comparator.comparingInt(Vec3i::m_123342_));
                contextConfig.decorators.forEach(treeDecorator -> treeDecorator.m_142741_((LevelSimulatedReader)contextWorldGenLevel, decorationPlacer, contextRandom, trunkList, leavesList));
            }
            return BoundingBox.m_162378_(Iterables.concat((Iterable)trunkSet, (Iterable)leavesSet, (Iterable)decorationSet)).map(boundingBox -> {
                final DiscreteVoxelShape voxelShape = TreeFeature.m_67202_((LevelAccessor)contextWorldGenLevel, boundingBox, trunkSet, decorationSet);
                StructureTemplate.m_74510_((LevelAccessor)contextWorldGenLevel, 3, voxelShape, boundingBox.m_162395_(), boundingBox.m_162396_(), boundingBox.m_162398_());
                return true;
            }).orElse(false);
        }
        return false;
    }
    
    protected abstract boolean generate(final WorldGenLevel p0, final Random p1, final BlockPos p2, final BiConsumer<BlockPos, BlockState> p3, final BiConsumer<BlockPos, BlockState> p4, final BiConsumer<BlockPos, BlockState> p5, final T p6);
}
