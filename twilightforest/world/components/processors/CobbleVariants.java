// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;
import twilightforest.util.FeaturePlacers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Blocks;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public final class CobbleVariants extends StructureProcessor
{
    public static final CobbleVariants INSTANCE;
    public static final Codec<CobbleVariants> CODEC;
    
    private CobbleVariants() {
    }
    
    public StructureTemplate.StructureBlockInfo process(final LevelReader worldReaderIn, final BlockPos pos, final BlockPos piecepos, final StructureTemplate.StructureBlockInfo p_215194_3_, final StructureTemplate.StructureBlockInfo modifiedBlockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        final Random random = settings.m_74399_(modifiedBlockInfo.f_74675_);
        random.setSeed(random.nextLong() * 2L);
        final BlockState state = modifiedBlockInfo.f_74676_;
        final Block block = state.m_60734_();
        if (block == Blocks.f_50652_ && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, Blocks.f_50079_.m_49966_(), (CompoundTag)null);
        }
        if (block == Blocks.f_50157_ && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, Blocks.f_50633_), (CompoundTag)null);
        }
        if (block == Blocks.f_50409_ && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, Blocks.f_50647_), (CompoundTag)null);
        }
        if (block == Blocks.f_50274_ && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, Blocks.f_50275_), (CompoundTag)null);
        }
        return modifiedBlockInfo;
    }
    
    protected StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.COBBLE_VARIANTS;
    }
    
    static {
        INSTANCE = new CobbleVariants();
        CODEC = Codec.unit(() -> CobbleVariants.INSTANCE);
    }
}
