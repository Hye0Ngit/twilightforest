// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.nbt.CompoundTag;
import twilightforest.util.RotationUtil;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public class SmartGrassProcessor extends StructureProcessor
{
    public static final SmartGrassProcessor INSTANCE;
    public static Codec<SmartGrassProcessor> CODEC;
    
    private SmartGrassProcessor() {
    }
    
    @Nullable
    public StructureTemplate.StructureBlockInfo process(final LevelReader level, final BlockPos origin, final BlockPos centerBottom, final StructureTemplate.StructureBlockInfo originalBlockInfo, final StructureTemplate.StructureBlockInfo modifiedBlockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        if (originalBlockInfo.f_74676_.m_60734_() != Blocks.f_50440_) {
            return modifiedBlockInfo;
        }
        if (level.m_8055_(modifiedBlockInfo.f_74675_).m_60620_((Tag)BlockTags.f_144274_) || !level.m_46859_(modifiedBlockInfo.f_74675_.m_7494_())) {
            return null;
        }
        for (final Direction direction : RotationUtil.CARDINALS) {
            final BlockState stateAt = level.m_8055_(modifiedBlockInfo.f_74675_.m_142300_(direction));
            if (stateAt.m_60734_() == Blocks.f_50599_) {
                return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, Blocks.f_50599_.m_49966_(), (CompoundTag)null);
            }
            if (stateAt.m_60734_() == Blocks.f_50440_) {
                return modifiedBlockInfo;
            }
            if (stateAt.m_60734_() == Blocks.f_50195_) {
                return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, Blocks.f_50195_.m_49966_(), (CompoundTag)null);
            }
            if (stateAt.m_60734_() == Blocks.f_152481_) {
                return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, Blocks.f_152481_.m_49966_(), (CompoundTag)null);
            }
            if (stateAt.m_60734_() == Blocks.f_50546_) {
                return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, Blocks.f_50546_.m_49966_(), (CompoundTag)null);
            }
            if (stateAt.m_60734_() == TFBlocks.UBEROUS_SOIL.get()) {
                return new StructureTemplate.StructureBlockInfo(modifiedBlockInfo.f_74675_, ((Block)TFBlocks.UBEROUS_SOIL.get()).m_49966_(), (CompoundTag)null);
            }
        }
        return modifiedBlockInfo;
    }
    
    protected StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.SMART_GRASS;
    }
    
    static {
        INSTANCE = new SmartGrassProcessor();
        SmartGrassProcessor.CODEC = (Codec<SmartGrassProcessor>)Codec.unit(() -> SmartGrassProcessor.INSTANCE);
    }
}
