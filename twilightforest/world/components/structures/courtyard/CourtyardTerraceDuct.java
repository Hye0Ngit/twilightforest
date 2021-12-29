// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.processors.StoneBricksVariants;
import twilightforest.world.components.processors.NagastoneVariants;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public class CourtyardTerraceDuct extends TwilightTemplateStructurePiece
{
    public CourtyardTerraceDuct(final ServerLevel level, final CompoundTag nbt) {
        super(NagaCourtyardPieces.TFNCDu, nbt, level, TwilightTemplateStructurePiece.readSettings(nbt).m_74383_((StructureProcessor)CourtyardTerraceTemplateProcessor.INSTANCE).m_74383_((StructureProcessor)NagastoneVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE));
    }
    
    public CourtyardTerraceDuct(final int i, final int x, final int y, final int z, final Rotation rotation, final StructureManager structureManager) {
        super(NagaCourtyardPieces.TFNCDu, i, structureManager, TwilightForestMod.prefix("courtyard/terrace_duct"), TwilightTemplateStructurePiece.makeSettings(rotation).m_74383_((StructureProcessor)CourtyardTerraceTemplateProcessor.INSTANCE).m_74383_((StructureProcessor)NagastoneVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE), new BlockPos(x, y + 3, z));
    }
    
    public boolean m_7832_(final WorldGenLevel level, final StructureFeatureManager structureFeatureManager, final ChunkGenerator chunkGenerator, final Random random, final BoundingBox boundingBox, final ChunkPos chunkPos, final BlockPos pos) {
        return this.placePieceAdjusted(level, structureFeatureManager, chunkGenerator, random, boundingBox, chunkPos, pos, -3);
    }
    
    protected void m_7756_(final String label, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.NONE;
    }
}
