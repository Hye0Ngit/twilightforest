// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.Blocks;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import java.util.HashSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public final class CourtyardTerraceTemplateProcessor extends StructureProcessor
{
    public static final CourtyardTerraceTemplateProcessor INSTANCE;
    public static final Codec<CourtyardTerraceTemplateProcessor> CODEC;
    private static final HashSet<BlockState> BLOCKS_REPLACE_TO_SLAB;
    
    private CourtyardTerraceTemplateProcessor() {
    }
    
    @Nullable
    public StructureTemplate.StructureBlockInfo process(final LevelReader world, final BlockPos pos, final BlockPos piecepos, final StructureTemplate.StructureBlockInfo oldinfo, final StructureTemplate.StructureBlockInfo newInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        final BlockState newState = newInfo.f_74676_;
        if (newState.m_60734_() != Blocks.f_50406_) {
            return newInfo;
        }
        final BlockState stateAt = world.m_8055_(newInfo.f_74675_);
        if (newState == Blocks.f_50406_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.DOUBLE)) {
            if (CourtyardTerraceTemplateProcessor.BLOCKS_REPLACE_TO_SLAB.contains(stateAt)) {
                return new StructureTemplate.StructureBlockInfo(newInfo.f_74675_, Blocks.f_50411_.m_49966_(), (CompoundTag)null);
            }
            if (stateAt.m_60795_()) {
                return null;
            }
            return new StructureTemplate.StructureBlockInfo(newInfo.f_74675_, Blocks.f_50222_.m_49966_(), (CompoundTag)null);
        }
        else {
            if (stateAt.m_60795_()) {
                return null;
            }
            return new StructureTemplate.StructureBlockInfo(newInfo.f_74675_, Blocks.f_50411_.m_49966_(), (CompoundTag)null);
        }
    }
    
    public StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.COURTYARD_TERRACE;
    }
    
    static {
        INSTANCE = new CourtyardTerraceTemplateProcessor();
        CODEC = Codec.unit(() -> CourtyardTerraceTemplateProcessor.INSTANCE);
        (BLOCKS_REPLACE_TO_SLAB = new HashSet<BlockState>()).add(Blocks.f_50222_.m_49966_());
        CourtyardTerraceTemplateProcessor.BLOCKS_REPLACE_TO_SLAB.add(Blocks.f_50223_.m_49966_());
        CourtyardTerraceTemplateProcessor.BLOCKS_REPLACE_TO_SLAB.add(Blocks.f_50224_.m_49966_());
        CourtyardTerraceTemplateProcessor.BLOCKS_REPLACE_TO_SLAB.add(Blocks.f_50411_.m_49966_());
        CourtyardTerraceTemplateProcessor.BLOCKS_REPLACE_TO_SLAB.add(Blocks.f_50645_.m_49966_());
    }
}
