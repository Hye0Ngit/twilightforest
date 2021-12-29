// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;

@Deprecated
public abstract class TFStructureComponentTemplate extends TFStructureComponent
{
    protected StructurePlaceSettings placeSettings;
    protected BlockPos templatePosition;
    protected BlockPos rotatedPosition;
    protected StructureTemplate TEMPLATE;
    public Runnable LAZY_TEMPLATE_LOADER;
    
    public TFStructureComponentTemplate(final ServerLevel level, final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.placeSettings = new StructurePlaceSettings().m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
        this.templatePosition = new BlockPos(nbt.m_128451_("TPX"), nbt.m_128451_("TPY"), nbt.m_128451_("TPZ"));
        this.placeSettings.m_74379_(this.f_73379_);
        this.LAZY_TEMPLATE_LOADER = (() -> this.setup(level.m_8875_()));
    }
    
    public TFStructureComponentTemplate(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final BoundingBox boundingBox) {
        super(type, i, boundingBox);
        this.placeSettings = new StructurePlaceSettings().m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
        this.setFeature(feature);
        this.f_73378_ = Mirror.NONE;
        this.templatePosition = new BlockPos(x, y, z);
    }
    
    @Deprecated
    public TFStructureComponentTemplate(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(type, i, new BoundingBox(x, y, z, x, y, z));
        this.placeSettings = new StructurePlaceSettings().m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
        this.setFeature(feature);
        this.f_73379_ = rotation;
        this.f_73378_ = Mirror.NONE;
        this.placeSettings.m_74379_(rotation);
        this.templatePosition = new BlockPos(x, y, z);
    }
    
    @Deprecated
    public TFStructureComponentTemplate(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final Mirror mirror) {
        super(type, i, new BoundingBox(x, y, z, x, y, z));
        this.placeSettings = new StructurePlaceSettings().m_74383_((StructureProcessor)BlockIgnoreProcessor.f_74046_);
        this.setFeature(feature);
        this.f_73379_ = rotation;
        this.f_73378_ = mirror;
        this.placeSettings.m_74379_(rotation);
        this.templatePosition = new BlockPos(x, y, z);
    }
    
    public final void setup(final StructureManager templateManager) {
        this.loadTemplates(templateManager);
        this.setModifiedTemplatePositionFromRotation();
        this.setBoundingBoxFromTemplate(this.rotatedPosition);
    }
    
    protected abstract void loadTemplates(final StructureManager p0);
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("TPX", this.templatePosition.m_123341_());
        tagCompound.m_128405_("TPY", this.templatePosition.m_123342_());
        tagCompound.m_128405_("TPZ", this.templatePosition.m_123343_());
    }
    
    protected final void setModifiedTemplatePositionFromRotation() {
        final Rotation rotation = this.placeSettings.m_74404_();
        final Vec3i size = this.TEMPLATE.m_163808_(rotation);
        this.rotatedPosition = new BlockPos((Vec3i)this.templatePosition);
        if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) {
            this.rotatedPosition = this.rotatedPosition.m_142385_(size.m_123343_() - 1);
        }
        if (rotation == Rotation.CLOCKWISE_180 || rotation == Rotation.COUNTERCLOCKWISE_90) {
            this.rotatedPosition = this.rotatedPosition.m_142383_(size.m_123341_() - 1);
        }
    }
    
    protected final void setBoundingBoxFromTemplate(final BlockPos pos) {
        final Rotation rotation = this.placeSettings.m_74404_();
        final Vec3i size = this.TEMPLATE.m_163808_(rotation);
        final Mirror mirror = this.placeSettings.m_74401_();
        this.f_73383_ = new BoundingBox(0, 0, 0, size.m_123341_(), size.m_123342_() - 1, size.m_123343_());
        switch (rotation) {
            case CLOCKWISE_90: {
                this.f_73383_.m_162367_(-size.m_123341_(), 0, 0);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                this.f_73383_.m_162367_(0, 0, -size.m_123343_());
                break;
            }
            case CLOCKWISE_180: {
                this.f_73383_.m_162367_(-size.m_123341_(), 0, -size.m_123343_());
                break;
            }
        }
        switch (mirror) {
            case FRONT_BACK: {
                BlockPos blockpos2 = BlockPos.f_121853_;
                if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
                    if (rotation == Rotation.CLOCKWISE_180) {
                        blockpos2 = blockpos2.m_5484_(Direction.EAST, size.m_123341_());
                    }
                    else {
                        blockpos2 = blockpos2.m_5484_(Direction.WEST, size.m_123341_());
                    }
                }
                else {
                    blockpos2 = blockpos2.m_5484_(rotation.m_55954_(Direction.WEST), size.m_123343_());
                }
                this.f_73383_.m_162367_(blockpos2.m_123341_(), 0, blockpos2.m_123343_());
                break;
            }
            case LEFT_RIGHT: {
                BlockPos blockpos3 = BlockPos.f_121853_;
                if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
                    if (rotation == Rotation.CLOCKWISE_180) {
                        blockpos3 = blockpos3.m_5484_(Direction.SOUTH, size.m_123343_());
                    }
                    else {
                        blockpos3 = blockpos3.m_5484_(Direction.NORTH, size.m_123343_());
                    }
                }
                else {
                    blockpos3 = blockpos3.m_5484_(rotation.m_55954_(Direction.NORTH), size.m_123341_());
                }
                this.f_73383_.m_162367_(blockpos3.m_123341_(), 0, blockpos3.m_123343_());
                break;
            }
        }
        this.f_73383_.m_162367_(pos.m_123341_(), pos.m_123342_(), pos.m_123343_());
    }
    
    @Deprecated
    protected final void setTemplatePositionFromRotation() {
        final Rotation rotation = this.placeSettings.m_74404_();
        final Vec3i size = this.TEMPLATE.m_163808_(rotation);
        if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) {
            this.templatePosition = this.templatePosition.m_142385_(size.m_123343_() - 1);
        }
        if (rotation == Rotation.CLOCKWISE_180 || rotation == Rotation.COUNTERCLOCKWISE_90) {
            this.templatePosition = this.templatePosition.m_142383_(size.m_123341_() - 1);
        }
    }
}
