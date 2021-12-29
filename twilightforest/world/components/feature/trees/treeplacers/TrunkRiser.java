// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import java.util.function.BiFunction;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

public class TrunkRiser extends TrunkPlacer
{
    public static final Codec<TrunkRiser> CODEC;
    private final int offset;
    private final TrunkPlacer placer;
    
    public TrunkRiser(final int baseHeight, final TrunkPlacer placer) {
        super(placer.f_70263_, placer.f_70264_, placer.f_70265_);
        this.offset = baseHeight;
        this.placer = placer;
    }
    
    protected TrunkPlacerType<TrunkRiser> m_7362_() {
        return TwilightFeatures.TRUNK_RISER;
    }
    
    public List<FoliagePlacer.FoliageAttachment> m_142625_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final int height, final BlockPos startPos, final TreeConfiguration treeConfig) {
        return this.placer.m_142625_(worldReader, (BiConsumer)worldPlacer, random, height, startPos.m_6630_(this.offset), treeConfig);
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 16).fieldOf("offset_up").forGetter(o -> o.offset), (App)TrunkPlacer.f_70262_.fieldOf("trunk_placer").forGetter(o -> o.placer)).apply((Applicative)instance, (BiFunction)TrunkRiser::new));
    }
}
