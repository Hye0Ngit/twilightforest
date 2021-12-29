// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.List;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.function.BiConsumer;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.world.registration.TwilightFeatures;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

public class DangleFromTreeDecorator extends TreeDecorator
{
    public static final Codec<DangleFromTreeDecorator> CODEC;
    private final int count;
    private final int randomAddCount;
    private final int minimumRequiredLength;
    private final int baseLength;
    private final int randomAddLength;
    private final WeightedStateProvider rope;
    private final WeightedStateProvider baggage;
    
    public DangleFromTreeDecorator(final int count, final int randomAddCount, final int minimumRequiredLength, final int baseLength, final int randomAddLength, final WeightedStateProvider rope, final WeightedStateProvider baggage) {
        this.count = count;
        this.randomAddCount = randomAddCount;
        this.minimumRequiredLength = minimumRequiredLength;
        this.baseLength = baseLength;
        this.randomAddLength = randomAddLength;
        this.rope = rope;
        this.baggage = baggage;
    }
    
    protected TreeDecoratorType<DangleFromTreeDecorator> m_6663_() {
        return TwilightFeatures.DANGLING_DECORATOR;
    }
    
    public void m_142741_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks) {
        if (leafBlocks.isEmpty()) {
            return;
        }
        int totalTries = this.count + random.nextInt(this.randomAddCount + 1);
        final int leafTotal = leafBlocks.size();
        totalTries = Math.min(totalTries, leafTotal);
        for (int attempt = 0; attempt < totalTries; ++attempt) {
            boolean clearedOfPossibleLeaves = false;
            BlockPos pos = leafBlocks.get(random.nextInt(leafTotal));
            if (pos.m_123341_() == trunkBlocks.get(0).m_123342_() && pos.m_123343_() == trunkBlocks.get(0).m_123343_()) {
                return;
            }
            int cordLength = this.baseLength + random.nextInt(this.randomAddLength + 1);
            for (int ropeUnrolling = 1; ropeUnrolling <= cordLength; ++ropeUnrolling) {
                final boolean isAir = worldReader.m_7433_(pos.m_6625_(ropeUnrolling), BlockBehaviour.BlockStateBase::m_60795_);
                if (!clearedOfPossibleLeaves && isAir) {
                    clearedOfPossibleLeaves = true;
                }
                if (clearedOfPossibleLeaves && !isAir) {
                    cordLength = ropeUnrolling;
                    break;
                }
            }
            if (cordLength > this.minimumRequiredLength) {
                final BlockState rope = this.rope.m_7112_(random, pos);
                for (int ropeUnrolling2 = 1; ropeUnrolling2 < cordLength; ++ropeUnrolling2) {
                    pos = pos.m_6625_(1);
                    if (worldReader.m_7433_(pos, BlockBehaviour.BlockStateBase::m_60795_)) {
                        worldPlacer.accept(pos, rope);
                    }
                }
                pos = pos.m_6625_(1);
                if (worldReader.m_7433_(pos, BlockBehaviour.BlockStateBase::m_60795_)) {
                    worldPlacer.accept(pos, this.baggage.m_7112_(random, pos));
                }
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 32).fieldOf("attempts_minimum").forGetter(o -> o.count), (App)Codec.intRange(0, 32).fieldOf("random_add_attempts").orElse((Object)0).forGetter(o -> o.randomAddCount), (App)Codec.intRange(1, 24).fieldOf("minimum_required_length").forGetter(o -> o.minimumRequiredLength), (App)Codec.intRange(1, 24).fieldOf("base_length").forGetter(o -> o.baseLength), (App)Codec.intRange(0, 16).fieldOf("random_add_length").orElse((Object)0).forGetter(o -> o.randomAddLength), (App)WeightedStateProvider.f_68808_.fieldOf("rope_provider").forGetter(o -> o.rope), (App)WeightedStateProvider.f_68808_.fieldOf("baggage_provider").forGetter(o -> o.baggage)).apply((Applicative)instance, DangleFromTreeDecorator::new));
    }
}
