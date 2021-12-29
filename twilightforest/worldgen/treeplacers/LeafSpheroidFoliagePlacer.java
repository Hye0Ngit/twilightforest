// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.util.math.MathHelper;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.BlockPos;
import java.util.Set;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import java.util.Random;
import net.minecraft.world.gen.IWorldGenerationReader;
import twilightforest.worldgen.TwilightFeatures;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.feature.FeatureSpread;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;

public class LeafSpheroidFoliagePlacer extends FoliagePlacer
{
    public static final Codec<LeafSpheroidFoliagePlacer> CODEC;
    private final float horizontalRadius;
    private final float verticalRadius;
    private final float verticalBias;
    private final int randomHorizontal;
    private final int randomVertical;
    private final int shag_factor;
    
    public LeafSpheroidFoliagePlacer(final float horizontalRadius, final float verticalRadius, final FeatureSpread yOffset, final int randomHorizontal, final int randomVertical, final float verticalBias, final int shag_factor) {
        super(FeatureSpread.func_242252_a((int)horizontalRadius), yOffset);
        this.horizontalRadius = horizontalRadius;
        this.verticalRadius = verticalRadius;
        this.randomHorizontal = randomHorizontal;
        this.randomVertical = randomVertical;
        this.verticalBias = verticalBias;
        this.shag_factor = shag_factor;
    }
    
    protected FoliagePlacerType<LeafSpheroidFoliagePlacer> func_230371_a_() {
        return TwilightFeatures.FOLIAGE_SPHEROID;
    }
    
    protected void func_230372_a_(final IWorldGenerationReader world, final Random random, final BaseTreeFeatureConfig baseTreeFeatureConfig, final int trunkHeight, final FoliagePlacer.Foliage foliage, final int foliageHeight, final int radius, final Set<BlockPos> leavesSet, final int offset, final MutableBoundingBox mutableBoundingBox) {
        final BlockPos center = foliage.func_236763_a_().func_177981_b(offset);
        FeatureUtil.makeLeafSpheroid(world, random, center, foliage.func_236764_b_() + this.horizontalRadius + random.nextInt(this.randomHorizontal + 1), foliage.func_236764_b_() + this.verticalRadius + random.nextInt(this.randomVertical + 1), this.verticalBias, baseTreeFeatureConfig.field_227369_n_, leavesSet);
        if (this.shag_factor > 0) {
            for (int i = 0; i < this.shag_factor; ++i) {
                final float TWO_PI = 6.2831855f;
                final float randomYaw = random.nextFloat() * TWO_PI;
                final float randomPitch = random.nextFloat() * 2.0f - 1.0f;
                final float yUnit = MathHelper.func_76129_c(1.0f - randomPitch * randomPitch);
                final float xCircleOffset = yUnit * MathHelper.func_76134_b(randomYaw) * (this.horizontalRadius - 1.0f);
                final float zCircleOffset = yUnit * MathHelper.func_76126_a(randomYaw) * (this.horizontalRadius - 1.0f);
                final BlockPos placement = center.func_177963_a((double)(xCircleOffset + ((int)xCircleOffset >> 31)), (double)(randomPitch * (this.verticalRadius + 0.25f) + this.verticalBias), (double)(zCircleOffset + ((int)zCircleOffset >> 31)));
                this.placeLeafCluster(world, random, placement.func_185334_h(), baseTreeFeatureConfig.field_227369_n_, leavesSet);
            }
        }
    }
    
    private void placeLeafCluster(final IWorldGenerationReader world, final Random random, final BlockPos pos, final BlockStateProvider state, final Set<BlockPos> leavesPos) {
        FeatureUtil.putLeafBlock(world, random, pos, state, leavesPos);
        FeatureUtil.putLeafBlock(world, random, pos.func_177974_f(), state, leavesPos);
        FeatureUtil.putLeafBlock(world, random, pos.func_177968_d(), state, leavesPos);
        FeatureUtil.putLeafBlock(world, random, pos.func_177982_a(1, 0, 1), state, leavesPos);
    }
    
    public int func_230374_a_(final Random random, final int i, final BaseTreeFeatureConfig baseTreeFeatureConfig) {
        return 0;
    }
    
    protected boolean func_230373_a_(final Random random, final int i, final int i1, final int i2, final int i3, final boolean b) {
        return false;
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.floatRange(0.0f, 16.0f).fieldOf("horizontal_radius").forGetter(o -> o.horizontalRadius), (App)Codec.floatRange(0.0f, 16.0f).fieldOf("vertical_radius").forGetter(o -> o.verticalRadius), (App)FeatureSpread.func_242254_a(0, 8, 8).fieldOf("offset").forGetter(obj -> obj.field_236750_g_), (App)Codec.intRange(0, 16).fieldOf("random_add_horizontal").orElse((Object)0).forGetter(o -> o.randomHorizontal), (App)Codec.intRange(0, 16).fieldOf("random_add_vertical").orElse((Object)0).forGetter(o -> o.randomVertical), (App)Codec.floatRange(-0.5f, 0.5f).fieldOf("vertical_filler_bias").orElse((Object)0.0f).forGetter(o -> o.verticalBias), (App)Codec.intRange(0, 256).fieldOf("shag_factor").orElse((Object)0).forGetter(o -> o.shag_factor)).apply((Applicative)instance, LeafSpheroidFoliagePlacer::new));
    }
}
