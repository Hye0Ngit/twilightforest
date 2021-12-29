// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import java.util.Random;
import net.minecraft.world.ISeedReader;
import twilightforest.worldgen.TwilightFeatures;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

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
    
    protected TreeDecoratorType<TrunkSideDecorator> func_230380_a_() {
        return TwilightFeatures.TRUNKSIDE_DECORATOR;
    }
    
    public void func_225576_a_(final ISeedReader world, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks, final Set<BlockPos> decorations, final MutableBoundingBox mutableBoundingBox) {
        final int blockCount = trunkBlocks.size();
        for (int attempt = 0; attempt < this.count; ++attempt) {
            if (random.nextFloat() < this.probability) {
                final Rotation rot = Rotation.func_222466_a(random);
                final BlockPos pos = trunkBlocks.get(random.nextInt(blockCount)).func_177972_a(rot.func_185831_a(Direction.NORTH));
                if (Feature.func_236297_b_((IWorldGenerationBaseReader)world, pos)) {
                    this.func_227423_a_((IWorldWriter)world, pos, this.decoration.func_225574_a_(random, pos).func_185907_a(rot), (Set)decorations, mutableBoundingBox);
                }
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 64).fieldOf("placement_count").forGetter(o -> o.count), (App)Codec.floatRange(0.0f, 1.0f).fieldOf("probability_of_placement").forGetter(o -> o.probability), (App)BlockStateProvider.field_236796_a_.fieldOf("deco_provider").forGetter(o -> o.decoration)).apply((Applicative)instance, TrunkSideDecorator::new));
    }
}
