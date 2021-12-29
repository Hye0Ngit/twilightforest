// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import java.util.function.BiFunction;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

public class TreeCorePlacer extends TreeDecorator
{
    public static final Codec<TreeCorePlacer> CODEC;
    private final int corePos;
    private final BlockStateProvider core;
    
    public TreeCorePlacer(final int corePos, final BlockStateProvider core) {
        this.corePos = corePos;
        this.core = core;
    }
    
    protected TreeDecoratorType<TreeCorePlacer> m_6663_() {
        return TwilightFeatures.CORE_PLACER;
    }
    
    public void m_142741_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks) {
        final BlockPos pos = trunkBlocks.get(0).m_142082_(0, this.corePos, 0);
        worldPlacer.accept(pos, this.core.m_7112_(random, pos));
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 20).fieldOf("core_position").forGetter(o -> o.corePos), (App)BlockStateProvider.f_68747_.fieldOf("deco_provider").forGetter(o -> o.core)).apply((Applicative)instance, (BiFunction)TreeCorePlacer::new));
    }
}
