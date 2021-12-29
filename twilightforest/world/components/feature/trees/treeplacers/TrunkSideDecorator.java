// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Rotation;
import twilightforest.TwilightForestMod;
import java.util.List;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.function.BiConsumer;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.world.registration.TwilightFeatures;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

public class TrunkSideDecorator extends TreeDecorator
{
    public static final Codec<TrunkSideDecorator> CODEC;
    private final int count;
    private final float probability;
    private final BlockStateProvider decoration;
    
    public TrunkSideDecorator(final int count, final float probability, final BlockStateProvider decorator) {
        this.count = count;
        this.probability = probability;
        this.decoration = decorator;
    }
    
    protected TreeDecoratorType<TrunkSideDecorator> m_6663_() {
        return TwilightFeatures.TRUNKSIDE_DECORATOR;
    }
    
    public void m_142741_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks) {
        final int blockCount = trunkBlocks.size();
        if (blockCount <= 0) {
            TwilightForestMod.LOGGER.error("[TrunkSideDecorator] Trunk Blocks were empty! Why?");
            return;
        }
        for (int attempt = 0; attempt < this.count; ++attempt) {
            if (random.nextFloat() < this.probability) {
                final Rotation rot = Rotation.m_55956_(random);
                final BlockPos pos = trunkBlocks.get(random.nextInt(blockCount)).m_142300_(rot.m_55954_(Direction.NORTH));
                if (Feature.m_65810_(worldReader, pos)) {
                    worldPlacer.accept(pos, this.decoration.m_7112_(random, pos));
                }
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 64).fieldOf("placement_count").forGetter(o -> o.count), (App)Codec.floatRange(0.0f, 1.0f).fieldOf("probability_of_placement").forGetter(o -> o.probability), (App)BlockStateProvider.f_68747_.fieldOf("deco_provider").forGetter(o -> o.decoration)).apply((Applicative)instance, TrunkSideDecorator::new));
    }
}
