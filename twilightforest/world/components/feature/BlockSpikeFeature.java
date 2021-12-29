// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import twilightforest.IMCHandler;
import twilightforest.TwilightForestMod;
import twilightforest.TFConfig;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.WeighedRandom;
import net.minecraft.world.level.levelgen.Heightmap;
import twilightforest.util.FeatureLogic;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import java.util.List;
import twilightforest.world.components.feature.config.SpikeConfig;
import net.minecraft.world.level.levelgen.feature.Feature;

public class BlockSpikeFeature extends Feature<SpikeConfig>
{
    private static final List<StalactiteEntry> largeHillStalactites;
    private static final List<StalactiteEntry> mediumHillStalactites;
    private static final List<StalactiteEntry> smallHillStalactites;
    
    public BlockSpikeFeature(final Codec<SpikeConfig> codec) {
        super((Codec)codec);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<SpikeConfig> context) {
        final Random random = context.m_159776_();
        return startSpike(context.m_159774_(), context.m_159777_(), (SpikeConfig)context.m_159778_(), random);
    }
    
    public static boolean startSpike(final WorldGenLevel level, final BlockPos startPos, final SpikeConfig config, final Random random) {
        return startSpike(level, startPos, config.blockState, config.lengthBounds.m_142270_(random), config.lengthBounds.m_142739_(), config.tipClearance.m_142270_(random), config.hang, random);
    }
    
    public static boolean startSpike(final WorldGenLevel level, final BlockPos startPos, final BlockStateProvider blockState, final int length, final int lengthMinimum, final int clearance, final boolean hang, final Random random) {
        final BlockPos.MutableBlockPos movingPos = startPos.m_122032_();
        int clearedLength = 0;
        final int dY = hang ? -1 : 1;
        for (int i = 0; i < length; ++i) {
            clearedLength = i;
            if (FeatureLogic.isReplaceable(level.m_8055_((BlockPos)movingPos))) {
                break;
            }
            movingPos.m_122184_(0, dY, 0);
        }
        movingPos.m_122184_(0, dY, 0);
        final int remainingScanLength = length - clearedLength + clearance;
        int finalLength = clearedLength - clearance;
        for (int j = 0; j < remainingScanLength; ++j) {
            finalLength = clearedLength + j;
            if (!FeatureLogic.isReplaceable(level.m_8055_((BlockPos)movingPos))) {
                break;
            }
            movingPos.m_122184_(0, dY, 0);
        }
        finalLength = Math.min(length, finalLength);
        return finalLength >= lengthMinimum && makeSpike(level, startPos, blockState, finalLength, dY, random);
    }
    
    private static boolean makeSpike(final WorldGenLevel level, final BlockPos startPos, final BlockStateProvider blockState, final int length, final int dY, final Random random) {
        for (int diameter = (int)(length / 4.5f), dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int absx = Math.abs(dx);
                final int absz = Math.abs(dz);
                final int dist = (int)(Math.max(absx, absz) + Math.min(absx, absz) * 0.5f);
                int spikeLength;
                if (dist <= 0) {
                    spikeLength = length;
                }
                else {
                    spikeLength = random.nextInt((int)(length / (dist + 0.25f)));
                }
                for (int i = 0; i < spikeLength; ++i) {
                    final BlockPos placement = startPos.m_142082_(dx, i * dY, dz);
                    if (FeatureLogic.isReplaceable(level.m_8055_(placement)) && (dY > 0 || placement.m_123342_() < level.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, placement.m_123341_(), placement.m_123343_()) - 1)) {
                        level.m_7731_(placement, blockState.m_7112_(random, placement), 3);
                    }
                }
            }
        }
        return true;
    }
    
    public static SpikeConfig makeRandomOreStalactite(final Random rand, final int hillSize) {
        if (hillSize >= 3 || (hillSize >= 2 && rand.nextInt(5) == 0)) {
            return WeighedRandom.m_145034_(rand, (List)BlockSpikeFeature.largeHillStalactites).get().stalactite;
        }
        if (hillSize >= 2 || (hillSize >= 1 && rand.nextInt(5) == 0)) {
            return WeighedRandom.m_145034_(rand, (List)BlockSpikeFeature.mediumHillStalactites).get().stalactite;
        }
        return WeighedRandom.m_145034_(rand, (List)BlockSpikeFeature.smallHillStalactites).get().stalactite;
    }
    
    public static void registerStalactite(final int hillSize, final BlockState blockState, final float size, final int maxLength, final int minHeight, final int itemWeight) {
        if (itemWeight > 0) {
            registerStalactite(hillSize, new StalactiteEntry(blockState, size, maxLength, itemWeight));
        }
    }
    
    private static void registerStalactite(final int hillSize, final StalactiteEntry entry) {
        if (hillSize <= 1) {
            BlockSpikeFeature.smallHillStalactites.add(entry);
        }
        if (hillSize <= 2) {
            BlockSpikeFeature.mediumHillStalactites.add(entry);
        }
        BlockSpikeFeature.largeHillStalactites.add(entry);
    }
    
    private static void addDefaultStalactites() {
        registerStalactite(3, Blocks.f_50089_.m_49966_(), 0.5f, 4, 16, 30);
        registerStalactite(3, Blocks.f_50059_.m_49966_(), 0.8f, 8, 1, 30);
        registerStalactite(3, Blocks.f_50264_.m_49966_(), 0.5f, 3, 12, 15);
        registerStalactite(2, Blocks.f_49995_.m_49966_(), 0.6f, 6, 1, 20);
        registerStalactite(2, Blocks.f_50173_.m_49966_(), 0.8f, 8, 1, 40);
        registerStalactite(1, Blocks.f_49996_.m_49966_(), 0.7f, 8, 1, 24);
        registerStalactite(1, Blocks.f_49997_.m_49966_(), 0.8f, 12, 1, 24);
        registerStalactite(1, Blocks.f_152505_.m_49966_(), 0.6f, 12, 1, 12);
        registerStalactite(1, Blocks.f_50141_.m_49966_(), 0.5f, 8, 1, 12);
    }
    
    public static void loadStalactites() {
        BlockSpikeFeature.smallHillStalactites.clear();
        BlockSpikeFeature.mediumHillStalactites.clear();
        BlockSpikeFeature.largeHillStalactites.clear();
        TFConfig.COMMON_CONFIG.DIMENSION.hollowHillStalactites.load();
        if (TFConfig.COMMON_CONFIG.DIMENSION.hollowHillStalactites.useConfigOnly.get()) {
            if (BlockSpikeFeature.smallHillStalactites.isEmpty()) {
                TwilightForestMod.LOGGER.info("Not all hollow hills are populated with the config, adding fallback");
                registerStalactite(1, Blocks.f_50069_.m_49966_(), 0.7f, 8, 1, 1);
            }
            return;
        }
        addDefaultStalactites();
        IMCHandler.getStalactites().forEach((BiConsumer)BlockSpikeFeature::registerStalactite);
    }
    
    static {
        largeHillStalactites = new ArrayList<StalactiteEntry>();
        mediumHillStalactites = new ArrayList<StalactiteEntry>();
        smallHillStalactites = new ArrayList<StalactiteEntry>();
    }
    
    public static class StalactiteEntry extends WeighedRandom.WeighedRandomItem
    {
        final SpikeConfig stalactite;
        
        StalactiteEntry(final SpikeConfig stalactite, final int itemWeight) {
            super(itemWeight);
            this.stalactite = stalactite;
        }
        
        public StalactiteEntry(final BlockState blockState, final float size, final int maxLength, final int itemWeight) {
            this(new SpikeConfig((BlockStateProvider)new SimpleStateProvider(blockState), (IntProvider)UniformInt.m_146622_((int)(maxLength * size), maxLength), (IntProvider)ConstantInt.m_146483_(4), true), itemWeight);
        }
    }
}
