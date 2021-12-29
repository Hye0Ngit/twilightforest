// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.core.BlockPos;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.processors.CobbleVariants;
import twilightforest.world.components.processors.StoneBricksVariants;
import twilightforest.world.components.processors.NagastoneVariants;
import twilightforest.world.components.processors.SmoothStoneVariants;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TwilightDoubleTemplateStructurePiece;

public class CourtyardWallCornerOuter extends TwilightDoubleTemplateStructurePiece
{
    public CourtyardWallCornerOuter(final ServerLevel level, final CompoundTag nbt) {
        super(NagaCourtyardPieces.TFNCWC, nbt, level, TwilightTemplateStructurePiece.readSettings(nbt).m_74383_((StructureProcessor)CourtyardMain.WALL_INTEGRITY_PROCESSOR).m_74383_((StructureProcessor)SmoothStoneVariants.INSTANCE).m_74383_((StructureProcessor)NagastoneVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE).m_74383_((StructureProcessor)CobbleVariants.INSTANCE), TwilightTemplateStructurePiece.readSettings(nbt).m_74383_((StructureProcessor)CourtyardMain.WALL_DECAY_PROCESSOR).m_74383_((StructureProcessor)CobbleVariants.INSTANCE));
    }
    
    public CourtyardWallCornerOuter(final int i, final int x, final int y, final int z, final Rotation rotation, final StructureManager structureManager) {
        super(NagaCourtyardPieces.TFNCWC, i, structureManager, TwilightForestMod.prefix("courtyard/courtyard_wall_corner"), TwilightTemplateStructurePiece.makeSettings(rotation).m_74383_((StructureProcessor)CourtyardMain.WALL_INTEGRITY_PROCESSOR).m_74383_((StructureProcessor)SmoothStoneVariants.INSTANCE).m_74383_((StructureProcessor)NagastoneVariants.INSTANCE).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE).m_74383_((StructureProcessor)CobbleVariants.INSTANCE), TwilightForestMod.prefix("courtyard/courtyard_wall_corner_decayed"), TwilightTemplateStructurePiece.makeSettings(rotation).m_74383_((StructureProcessor)CourtyardMain.WALL_DECAY_PROCESSOR).m_74383_((StructureProcessor)CobbleVariants.INSTANCE), new BlockPos(x, y, z));
    }
    
    protected void m_7756_(final String label, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
