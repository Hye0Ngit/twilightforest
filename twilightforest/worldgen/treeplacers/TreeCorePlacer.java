// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import java.util.function.BiFunction;
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

public class TreeCorePlacer extends TreeDecorator
{
    public static final Codec<TreeCorePlacer> CODEC;
    private final int corePos;
    private final BlockStateProvider core;
    
    public TreeCorePlacer(final int corePos, final BlockStateProvider core) {
        this.corePos = corePos;
        this.core = core;
    }
    
    protected TreeDecoratorType<TreeCorePlacer> func_230380_a_() {
        return TwilightFeatures.CORE_PLACER;
    }
    
    public void func_225576_a_(final ISeedReader world, final Random random, final List<BlockPos> trunkBlocks, final List<BlockPos> leafBlocks, final Set<BlockPos> decorations, final MutableBoundingBox mutableBoundingBox) {
        final BlockPos pos = trunkBlocks.get(0);
        final BlockPos position = pos.func_177982_a(0, this.corePos, 0);
        this.placeCore(world, random, position, decorations, 0.0, this.corePos, 0, mutableBoundingBox, this.core);
    }
    
    public void placeCore(final ISeedReader world, final Random random, final BlockPos pos, final Set<BlockPos> decorations, final double offset, final int iteration, final int length, final MutableBoundingBox mutableBoundingBox, final BlockStateProvider coreType) {
        final BlockPos position = pos.func_177982_a(0, this.corePos, 0);
        this.func_227423_a_((IWorldWriter)world, pos, coreType.func_225574_a_(random, position), (Set)decorations, mutableBoundingBox);
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 20).fieldOf("core_position").forGetter(o -> o.corePos), (App)BlockStateProvider.field_236796_a_.fieldOf("deco_provider").forGetter(o -> o.core)).apply((Applicative)instance, (BiFunction)TreeCorePlacer::new));
    }
}
