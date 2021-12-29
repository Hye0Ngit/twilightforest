// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.util.Mth;
import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.function.BiConsumer;
import net.minecraft.world.level.LevelSimulatedReader;
import twilightforest.world.registration.TwilightFeatures;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

public class LeafSpheroidFoliagePlacer extends FoliagePlacer
{
    public static final Codec<LeafSpheroidFoliagePlacer> CODEC;
    private final float horizontalRadius;
    private final float verticalRadius;
    private final float verticalBias;
    private final int randomHorizontal;
    private final int randomVertical;
    private final int shag_factor;
    
    public LeafSpheroidFoliagePlacer(final float horizontalRadius, final float verticalRadius, final IntProvider yOffset, final int randomHorizontal, final int randomVertical, final float verticalBias, final int shag_factor) {
        super((IntProvider)ConstantInt.m_146483_((int)horizontalRadius), yOffset);
        this.horizontalRadius = horizontalRadius;
        this.verticalRadius = verticalRadius;
        this.randomHorizontal = randomHorizontal;
        this.randomVertical = randomVertical;
        this.verticalBias = verticalBias;
        this.shag_factor = shag_factor;
    }
    
    protected FoliagePlacerType<LeafSpheroidFoliagePlacer> m_5897_() {
        return TwilightFeatures.FOLIAGE_SPHEROID;
    }
    
    protected void m_142539_(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final TreeConfiguration baseTreeFeatureConfig, final int trunkHeight, final FoliagePlacer.FoliageAttachment foliage, final int foliageHeight, final int radius, final int offset) {
        final BlockPos center = foliage.m_161451_().m_6630_(offset);
        FeaturePlacers.placeSpheroid(worldReader, worldPlacer, FeaturePlacers.VALID_TREE_POS, random, center, foliage.m_68589_() + this.horizontalRadius + random.nextInt(this.randomHorizontal + 1), foliage.m_68589_() + this.verticalRadius + random.nextInt(this.randomVertical + 1), this.verticalBias, baseTreeFeatureConfig.f_161213_);
        if (this.shag_factor > 0) {
            for (int i = 0; i < this.shag_factor; ++i) {
                final float randomYaw = random.nextFloat() * 6.2831855f;
                final float randomPitch = random.nextFloat() * 2.0f - 1.0f;
                final float yUnit = Mth.m_14116_(1.0f - randomPitch * randomPitch);
                final float xCircleOffset = yUnit * Mth.m_14089_(randomYaw) * (this.horizontalRadius - 1.0f);
                final float zCircleOffset = yUnit * Mth.m_14031_(randomYaw) * (this.horizontalRadius - 1.0f);
                final BlockPos placement = center.m_142022_((double)(xCircleOffset + ((int)xCircleOffset >> 31)), (double)(randomPitch * (this.verticalRadius + 0.25f) + this.verticalBias), (double)(zCircleOffset + ((int)zCircleOffset >> 31)));
                placeLeafCluster(worldReader, worldPlacer, random, placement.m_7949_(), baseTreeFeatureConfig.f_161213_);
            }
        }
    }
    
    private static void placeLeafCluster(final LevelSimulatedReader worldReader, final BiConsumer<BlockPos, BlockState> worldPlacer, final Random random, final BlockPos pos, final BlockStateProvider state) {
        FeaturePlacers.placeProvidedBlock(worldReader, worldPlacer, FeaturePlacers.VALID_TREE_POS, pos, state, random);
        FeaturePlacers.placeProvidedBlock(worldReader, worldPlacer, FeaturePlacers.VALID_TREE_POS, pos.m_142126_(), state, random);
        FeaturePlacers.placeProvidedBlock(worldReader, worldPlacer, FeaturePlacers.VALID_TREE_POS, pos.m_142128_(), state, random);
        FeaturePlacers.placeProvidedBlock(worldReader, worldPlacer, FeaturePlacers.VALID_TREE_POS, pos.m_142082_(1, 0, 1), state, random);
    }
    
    public int m_5969_(final Random random, final int i, final TreeConfiguration baseTreeFeatureConfig) {
        return 0;
    }
    
    protected boolean m_7394_(final Random random, final int i, final int i1, final int i2, final int i3, final boolean b) {
        return false;
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.floatRange(0.0f, 16.0f).fieldOf("horizontal_radius").forGetter(o -> o.horizontalRadius), (App)Codec.floatRange(0.0f, 16.0f).fieldOf("vertical_radius").forGetter(o -> o.verticalRadius), (App)IntProvider.m_146545_(0, 8).fieldOf("offset").forGetter(obj -> obj.f_68521_), (App)Codec.intRange(0, 16).fieldOf("random_add_horizontal").orElse((Object)0).forGetter(o -> o.randomHorizontal), (App)Codec.intRange(0, 16).fieldOf("random_add_vertical").orElse((Object)0).forGetter(o -> o.randomVertical), (App)Codec.floatRange(-0.5f, 0.5f).fieldOf("vertical_filler_bias").orElse((Object)0.0f).forGetter(o -> o.verticalBias), (App)Codec.intRange(0, 256).fieldOf("shag_factor").orElse((Object)0).forGetter(o -> o.shag_factor)).apply((Applicative)instance, LeafSpheroidFoliagePlacer::new));
    }
}
