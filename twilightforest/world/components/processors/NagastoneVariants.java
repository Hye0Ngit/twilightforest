// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;
import net.minecraft.nbt.CompoundTag;
import twilightforest.util.FeaturePlacers;
import net.minecraft.world.level.block.Block;
import twilightforest.block.TFBlocks;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public final class NagastoneVariants extends StructureProcessor
{
    public static final NagastoneVariants INSTANCE;
    public static final Codec<NagastoneVariants> CODEC;
    
    private NagastoneVariants() {
    }
    
    public StructureTemplate.StructureBlockInfo process(final LevelReader worldIn, final BlockPos pos, final BlockPos piecepos, final StructureTemplate.StructureBlockInfo oldInfo, final StructureTemplate.StructureBlockInfo modifiedBlockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        final Random random = settings.m_74399_(modifiedBlockInfo.f_74675_);
        random.setSeed(random.nextLong() * 5L);
        final BlockState state = modifiedBlockInfo.f_74676_;
        final Block block = state.m_60734_();
        if (block == TFBlocks.ETCHED_NAGASTONE.get() && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, random.nextBoolean() ? ((Block)TFBlocks.MOSSY_ETCHED_NAGASTONE.get()) : ((Block)TFBlocks.CRACKED_ETCHED_NAGASTONE.get())), (CompoundTag)null);
        }
        if (block == TFBlocks.NAGASTONE_PILLAR.get() && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, random.nextBoolean() ? ((Block)TFBlocks.MOSSY_NAGASTONE_PILLAR.get()) : ((Block)TFBlocks.CRACKED_NAGASTONE_PILLAR.get())), (CompoundTag)null);
        }
        if (block == TFBlocks.NAGASTONE_STAIRS_LEFT.get() && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, random.nextBoolean() ? ((Block)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get()) : ((Block)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get())), (CompoundTag)null);
        }
        if (block == TFBlocks.NAGASTONE_STAIRS_RIGHT.get() && random.nextBoolean()) {
            return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, FeaturePlacers.transferAllStateKeys(state, random.nextBoolean() ? ((Block)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get()) : ((Block)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get())), (CompoundTag)null);
        }
        return modifiedBlockInfo;
    }
    
    public StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.NAGASTONE_VARIANTS;
    }
    
    static {
        INSTANCE = new NagastoneVariants();
        CODEC = Codec.unit(() -> NagastoneVariants.INSTANCE);
    }
}
