// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import java.util.function.BiFunction;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

public class TrunkRiser extends AbstractTrunkPlacer
{
    public static final Codec<TrunkRiser> CODEC;
    private final int offset;
    private final AbstractTrunkPlacer placer;
    
    public TrunkRiser(final int baseHeight, final AbstractTrunkPlacer placer) {
        super(placer.field_236906_d_, placer.field_236907_e_, placer.field_236908_f_);
        this.offset = baseHeight;
        this.placer = placer;
    }
    
    protected TrunkPlacerType<TrunkRiser> func_230381_a_() {
        return TwilightFeatures.TRUNK_RISER;
    }
    
    public List<FoliagePlacer.Foliage> func_230382_a_(final IWorldGenerationReader iWorldGenerationReader, final Random random, final int i, final BlockPos blockPos, final Set<BlockPos> set, final MutableBoundingBox mutableBoundingBox, final BaseTreeFeatureConfig baseTreeFeatureConfig) {
        return this.placer.func_230382_a_(iWorldGenerationReader, random, i, blockPos.func_177981_b(this.offset), (Set)set, mutableBoundingBox, baseTreeFeatureConfig);
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 16).fieldOf("offset_up").forGetter(o -> o.offset), (App)AbstractTrunkPlacer.field_236905_c_.fieldOf("trunk_placer").forGetter(o -> o.placer)).apply((Applicative)instance, (BiFunction)TrunkRiser::new));
    }
}
