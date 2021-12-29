// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.ServerLevelAccessor;
import java.util.Objects;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import twilightforest.TwilightForestMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public final class CentralTowerAttachment extends TwilightTemplateStructurePiece
{
    private final int width;
    private final int length = 2;
    
    public CentralTowerAttachment(final ServerLevel serverLevel, final CompoundTag compoundTag) {
        super(LichTowerRevampPieces.CENTRAL_TO_SIDE_TOWER, compoundTag, serverLevel, TwilightTemplateStructurePiece.readSettings(compoundTag));
        this.width = compoundTag.m_128451_("width");
    }
    
    private CentralTowerAttachment(final StructureManager structureManager, final Rotation rotation, final String name, final BlockPos startPosition, final int width) {
        this(structureManager, TwilightForestMod.prefix("lich_tower/attachments/central/" + name), TwilightTemplateStructurePiece.makeSettings(rotation), startPosition.m_5484_(rotation.m_55954_(Direction.EAST), -(width - 5 >> 1)), width);
    }
    
    private CentralTowerAttachment(final StructureManager structureManager, final ResourceLocation templateLocation, final StructurePlaceSettings placeSettings, final BlockPos startPosition, final int width) {
        super(LichTowerRevampPieces.CENTRAL_TO_SIDE_TOWER, 0, structureManager, templateLocation, placeSettings, startPosition);
        this.width = width;
    }
    
    public static CentralTowerAttachment startRandomAttachment(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition, final Random random) {
        final float weight = random.nextFloat() * random.nextFloat();
        if (weight < 0.33333334f) {
            return smallAttachment(structureManager, rotation, startPosition);
        }
        if (weight < 0.6666667f) {
            return mediumAttachment(structureManager, rotation, startPosition);
        }
        return largeAttachment(structureManager, rotation, startPosition);
    }
    
    public static CentralTowerAttachment smallAttachment(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition) {
        return new CentralTowerAttachment(structureManager, rotation, "central_to_small", startPosition, 5);
    }
    
    public static CentralTowerAttachment mediumAttachment(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition) {
        return new CentralTowerAttachment(structureManager, rotation, "central_to_medium", startPosition, 7);
    }
    
    public static CentralTowerAttachment largeAttachment(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition) {
        return new CentralTowerAttachment(structureManager, rotation, "central_to_large", startPosition, 9);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor structureStart, final Random random) {
        super.m_142537_(parent, structureStart, random);
        final Direction dir = this.f_73379_.m_55954_(Direction.SOUTH);
        final BlockPos f_73658_ = this.f_73658_;
        final int 122429_ = dir.m_122429_();
        Objects.requireNonNull(this);
        final int n = 122429_ * 2;
        final int n2 = 1;
        final int 122431_ = dir.m_122431_();
        Objects.requireNonNull(this);
        final BlockPos placement = f_73658_.m_142082_(n, n2, 122431_ * 2);
        switch (this.width) {
            case 9: {
                final SideTowerRoom largeRoom = SideTowerRoom.largeRoom(this.structureManager, this.f_73379_, placement, random);
                largeRoom.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)largeRoom);
                break;
            }
            case 7: {
                final SideTowerRoom mediumRoom = SideTowerRoom.mediumRoom(this.structureManager, this.f_73379_, placement, random);
                mediumRoom.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)mediumRoom);
                break;
            }
            case 5: {
                final SideTowerRoom smallRoom = SideTowerRoom.smallRoom(this.structureManager, this.f_73379_, placement, random);
                smallRoom.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)smallRoom);
                break;
            }
        }
    }
    
    protected void m_7756_(final String label, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag structureTag) {
        super.m_142347_(level, structureTag);
        structureTag.m_128405_("width", this.width);
    }
}
