// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import java.util.List;
import java.util.Iterator;
import net.minecraft.nbt.Tag;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.nbt.ListTag;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.resources.ResourceLocation;
import twilightforest.TwilightForestMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.BoxCuttingProcessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public final class CentralTowerSegment extends TwilightTemplateStructurePiece
{
    static final int SIDE_LENGTH = 30;
    static final int HEIGHT = 4;
    static final int ATTACHMENT_POINT_START = 6;
    static final int ATTACHMENT_POINT_RANGE = 13;
    
    public CentralTowerSegment(final ServerLevel serverLevel, final CompoundTag compoundTag) {
        super(LichTowerRevampPieces.CENTRAL_TOWER, compoundTag, serverLevel, TwilightTemplateStructurePiece.readSettings(compoundTag).m_74383_((StructureProcessor)BoxCuttingProcessor.fromNBT(compoundTag.m_128437_("cutouts", 10))));
    }
    
    public CentralTowerSegment(final StructureManager structureManager, final Rotation rotation, final BoxCuttingProcessor sideTowerStarts, final BlockPos startPosition) {
        this(structureManager, TwilightForestMod.prefix("lich_tower/central_tower"), TwilightTemplateStructurePiece.makeSettings(rotation).m_74383_((StructureProcessor)sideTowerStarts), startPosition);
    }
    
    private CentralTowerSegment(final StructureManager structureManager, final ResourceLocation templateLocation, final StructurePlaceSettings placeSettings, final BlockPos startPosition) {
        super(LichTowerRevampPieces.CENTRAL_TOWER, 0, structureManager, templateLocation, placeSettings, startPosition);
    }
    
    protected void m_7756_(final String label, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag structureTag) {
        super.m_142347_(level, structureTag);
        BoxCuttingProcessor cuttingProcessor = null;
        for (final StructureProcessor structureProcessor : this.f_73657_.m_74411_()) {
            final StructureProcessor processor = structureProcessor;
            if (structureProcessor instanceof final BoxCuttingProcessor boxCuttingProcessor) {
                final BoxCuttingProcessor first = cuttingProcessor = boxCuttingProcessor;
                break;
            }
        }
        if (cuttingProcessor == null) {
            return;
        }
        final List<BoundingBox> filtering = new ArrayList<BoundingBox>(cuttingProcessor.cutouts);
        filtering.removeIf(bb -> bb.m_162399_() < this.f_73658_.m_123342_() || bb.m_162396_() > this.f_73658_.m_123342_() + 4);
        final ListTag boxTagList = new ListTag();
        for (final BoundingBox box : filtering) {
            boxTagList.add((Object)BoundingBoxUtils.boundingBoxToNBT(box));
        }
        structureTag.m_128365_("cutouts", (Tag)boxTagList);
    }
}
