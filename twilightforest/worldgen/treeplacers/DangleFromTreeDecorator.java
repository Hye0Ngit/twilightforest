// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.IWorldWriter;
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

public class DangleFromTreeDecorator extends TreeDecorator
{
    public static final Codec<DangleFromTreeDecorator> CODEC;
    private final int count;
    private final int randomAddCount;
    private final int minimumRequiredLength;
    private final int baseLength;
    private final int randomAddLength;
    private final BlockStateProvider rope;
    private final BlockStateProvider baggage;
    
    public DangleFromTreeDecorator(final int count, final int randomAddCount, final int minimumRequiredLength, final int baseLength, final int randomAddLength, final BlockStateProvider rope, final BlockStateProvider baggage) {
        this.count = count;
        this.randomAddCount = randomAddCount;
        this.minimumRequiredLength = minimumRequiredLength;
        this.baseLength = baseLength;
        this.randomAddLength = randomAddLength;
        this.rope = rope;
        this.baggage = baggage;
    }
    
    protected TreeDecoratorType<DangleFromTreeDecorator> func_230380_a_() {
        return TwilightFeatures.DANGLING_DECORATOR;
    }
    
    public void func_225576_a_(final ISeedReader world, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks, final Set<BlockPos> decorations, final MutableBoundingBox mutableBoundingBox) {
        if (leafBlocks.isEmpty()) {
            return;
        }
        int totalTries = this.count + random.nextInt(this.randomAddCount + 1);
        final int leafTotal = leafBlocks.size();
        totalTries = Math.min(totalTries, leafTotal);
        for (int attempt = 0; attempt < totalTries; ++attempt) {
            boolean clearedOfPossibleLeaves = false;
            BlockPos pos = leafBlocks.get(random.nextInt(leafTotal));
            int cordLength = this.baseLength + random.nextInt(this.randomAddLength + 1);
            for (int ropeUnrolling = 1; ropeUnrolling <= cordLength; ++ropeUnrolling) {
                final boolean isAir = world.func_175623_d(pos.func_177979_c(ropeUnrolling));
                if (!clearedOfPossibleLeaves && isAir) {
                    clearedOfPossibleLeaves = true;
                }
                if (clearedOfPossibleLeaves && !isAir) {
                    cordLength = ropeUnrolling;
                    break;
                }
            }
            if (cordLength > this.minimumRequiredLength) {
                for (int ropeUnrolling = 1; ropeUnrolling < cordLength; ++ropeUnrolling) {
                    pos = pos.func_177979_c(1);
                    this.func_227423_a_((IWorldWriter)world, pos, this.rope.func_225574_a_(random, pos), (Set)decorations, mutableBoundingBox);
                }
                pos = pos.func_177979_c(1);
                this.func_227423_a_((IWorldWriter)world, pos, this.baggage.func_225574_a_(random, pos), (Set)decorations, mutableBoundingBox);
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 32).fieldOf("attempts_minimum").forGetter(o -> o.count), (App)Codec.intRange(0, 32).fieldOf("random_add_attempts").orElse((Object)0).forGetter(o -> o.randomAddCount), (App)Codec.intRange(1, 24).fieldOf("minimum_required_length").forGetter(o -> o.minimumRequiredLength), (App)Codec.intRange(1, 24).fieldOf("base_length").forGetter(o -> o.baseLength), (App)Codec.intRange(0, 16).fieldOf("random_add_length").orElse((Object)0).forGetter(o -> o.randomAddLength), (App)BlockStateProvider.field_236796_a_.fieldOf("rope_provider").forGetter(o -> o.rope), (App)BlockStateProvider.field_236796_a_.fieldOf("baggage_provider").forGetter(o -> o.baggage)).apply((Applicative)instance, DangleFromTreeDecorator::new));
    }
}
