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
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.NagastoneVariants;
import net.minecraft.world.level.block.Rotation;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public class CourtyardPathPiece extends TwilightTemplateStructurePiece
{
    public CourtyardPathPiece(final ServerLevel level, final CompoundTag nbt) {
        super(NagaCourtyardPieces.TFNCPa, nbt, level, TwilightTemplateStructurePiece.readSettings(nbt));
    }
    
    public CourtyardPathPiece(final int i, final int x, final int y, final int z, final StructureManager structureManager) {
        super(NagaCourtyardPieces.TFNCPa, i, structureManager, TwilightForestMod.prefix("courtyard/pathway"), TwilightTemplateStructurePiece.makeSettings(Rotation.NONE).m_74383_((StructureProcessor)NagastoneVariants.INSTANCE), new BlockPos(x, y + 1, z));
    }
    
    public boolean m_7832_(final WorldGenLevel level, final StructureFeatureManager structureFeatureManager, final ChunkGenerator chunkGenerator, final Random random, final BoundingBox boundingBox, final ChunkPos chunkPos, final BlockPos pos) {
        return this.placePieceAdjusted(level, structureFeatureManager, chunkGenerator, random, boundingBox, chunkPos, pos, -1);
    }
    
    protected void m_7756_(final String label, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
