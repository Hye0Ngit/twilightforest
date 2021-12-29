// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import java.util.Random;
import net.minecraft.nbt.CompoundTag;
import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.block.Blocks;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public class SmoothStoneVariants extends StructureProcessor
{
    public static final SmoothStoneVariants INSTANCE;
    public static final Codec<SmoothStoneVariants> CODEC;
    
    private SmoothStoneVariants() {
    }
    
    public StructureTemplate.StructureBlockInfo process(final LevelReader level, final BlockPos origin, final BlockPos centerBottom, final StructureTemplate.StructureBlockInfo originalBlockInfo, final StructureTemplate.StructureBlockInfo modifiedBlockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        final Random random = settings.m_74399_(modifiedBlockInfo.f_74675_);
        random.setSeed(random.nextLong() * 4L);
        if (modifiedBlockInfo.f_74676_.m_60734_() == Blocks.f_50405_ && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(modifiedBlockInfo.f_74676_, Blocks.f_50409_), (CompoundTag)null);
        }
        if (modifiedBlockInfo.f_74676_.m_60734_() == Blocks.f_50470_ && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, Blocks.f_50652_.m_49966_(), (CompoundTag)null);
        }
        return modifiedBlockInfo;
    }
    
    protected StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.SMOOTH_STONE_VARIANTS;
    }
    
    static {
        INSTANCE = new SmoothStoneVariants();
        CODEC = Codec.unit(() -> SmoothStoneVariants.INSTANCE);
    }
}
