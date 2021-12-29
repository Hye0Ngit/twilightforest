// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.template.PlacementSettings;

public abstract class TFStructureComponentTemplate extends TFStructureComponent
{
    protected PlacementSettings placeSettings;
    protected BlockPos templatePosition;
    protected BlockPos rotatedPosition;
    protected Template TEMPLATE;
    public Runnable LAZY_TEMPLATE_LOADER;
    
    public TFStructureComponentTemplate(final TemplateManager manager, final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.placeSettings = new PlacementSettings().func_215222_a((StructureProcessor)BlockIgnoreStructureProcessor.field_215204_a);
        this.templatePosition = new BlockPos(nbt.func_74762_e("TPX"), nbt.func_74762_e("TPY"), nbt.func_74762_e("TPZ"));
        this.placeSettings.func_186220_a(this.field_186169_c);
        this.LAZY_TEMPLATE_LOADER = (() -> this.setup(manager));
    }
    
    public TFStructureComponentTemplate(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(type, i);
        this.placeSettings = new PlacementSettings().func_215222_a((StructureProcessor)BlockIgnoreStructureProcessor.field_215204_a);
        this.feature = feature;
        this.field_186169_c = rotation;
        this.field_186168_b = Mirror.NONE;
        this.placeSettings.func_186220_a(rotation);
        this.templatePosition = new BlockPos(x, y, z);
        this.field_74887_e = new MutableBoundingBox(x, y, z, x, y, z);
    }
    
    public TFStructureComponentTemplate(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation, final Mirror mirror) {
        super(type, i);
        this.placeSettings = new PlacementSettings().func_215222_a((StructureProcessor)BlockIgnoreStructureProcessor.field_215204_a);
        this.feature = feature;
        this.field_186169_c = rotation;
        this.field_186168_b = mirror;
        this.placeSettings.func_186220_a(rotation);
        this.templatePosition = new BlockPos(x, y, z);
        this.field_74887_e = new MutableBoundingBox(x, y, z, x, y, z);
    }
    
    public final void setup(final TemplateManager templateManager) {
        this.loadTemplates(templateManager);
        this.setModifiedTemplatePositionFromRotation();
        this.setBoundingBoxFromTemplate(this.rotatedPosition);
    }
    
    protected abstract void loadTemplates(final TemplateManager p0);
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("TPX", this.templatePosition.func_177958_n());
        tagCompound.func_74768_a("TPY", this.templatePosition.func_177956_o());
        tagCompound.func_74768_a("TPZ", this.templatePosition.func_177952_p());
    }
    
    protected final void setModifiedTemplatePositionFromRotation() {
        final Rotation rotation = this.placeSettings.func_186215_c();
        final BlockPos size = this.TEMPLATE.func_186257_a(rotation);
        this.rotatedPosition = new BlockPos((Vector3i)this.templatePosition);
        if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) {
            this.rotatedPosition = this.rotatedPosition.func_177965_g(size.func_177952_p() - 1);
        }
        if (rotation == Rotation.CLOCKWISE_180 || rotation == Rotation.COUNTERCLOCKWISE_90) {
            this.rotatedPosition = this.rotatedPosition.func_177970_e(size.func_177958_n() - 1);
        }
    }
    
    protected final void setBoundingBoxFromTemplate(final BlockPos pos) {
        final Rotation rotation = this.placeSettings.func_186215_c();
        final BlockPos size = this.TEMPLATE.func_186257_a(rotation);
        final Mirror mirror = this.placeSettings.func_186212_b();
        this.field_74887_e = new MutableBoundingBox(0, 0, 0, size.func_177958_n(), size.func_177956_o() - 1, size.func_177952_p());
        switch (rotation) {
            case CLOCKWISE_90: {
                this.field_74887_e.func_78886_a(-size.func_177958_n(), 0, 0);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                this.field_74887_e.func_78886_a(0, 0, -size.func_177952_p());
                break;
            }
            case CLOCKWISE_180: {
                this.field_74887_e.func_78886_a(-size.func_177958_n(), 0, -size.func_177952_p());
                break;
            }
        }
        switch (mirror) {
            case FRONT_BACK: {
                BlockPos blockpos2 = BlockPos.field_177992_a;
                if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
                    if (rotation == Rotation.CLOCKWISE_180) {
                        blockpos2 = blockpos2.func_177967_a(Direction.EAST, size.func_177958_n());
                    }
                    else {
                        blockpos2 = blockpos2.func_177967_a(Direction.WEST, size.func_177958_n());
                    }
                }
                else {
                    blockpos2 = blockpos2.func_177967_a(rotation.func_185831_a(Direction.WEST), size.func_177952_p());
                }
                this.field_74887_e.func_78886_a(blockpos2.func_177958_n(), 0, blockpos2.func_177952_p());
                break;
            }
            case LEFT_RIGHT: {
                BlockPos blockpos3 = BlockPos.field_177992_a;
                if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
                    if (rotation == Rotation.CLOCKWISE_180) {
                        blockpos3 = blockpos3.func_177967_a(Direction.SOUTH, size.func_177952_p());
                    }
                    else {
                        blockpos3 = blockpos3.func_177967_a(Direction.NORTH, size.func_177952_p());
                    }
                }
                else {
                    blockpos3 = blockpos3.func_177967_a(rotation.func_185831_a(Direction.NORTH), size.func_177958_n());
                }
                this.field_74887_e.func_78886_a(blockpos3.func_177958_n(), 0, blockpos3.func_177952_p());
                break;
            }
        }
        this.field_74887_e.func_78886_a(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
    }
    
    @Deprecated
    protected final void setTemplatePositionFromRotation() {
        final Rotation rotation = this.placeSettings.func_186215_c();
        final BlockPos size = this.TEMPLATE.func_186257_a(rotation);
        if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.CLOCKWISE_180) {
            this.templatePosition = this.templatePosition.func_177965_g(size.func_177952_p() - 1);
        }
        if (rotation == Rotation.CLOCKWISE_180 || rotation == Rotation.COUNTERCLOCKWISE_90) {
            this.templatePosition = this.templatePosition.func_177970_e(size.func_177958_n() - 1);
        }
    }
    
    @Deprecated
    protected final void setBoundingBoxFromTemplate() {
        final Rotation rotation = this.placeSettings.func_186215_c();
        final BlockPos size = this.TEMPLATE.func_186257_a(rotation);
        final Mirror mirror = this.placeSettings.func_186212_b();
        this.field_74887_e = new MutableBoundingBox(0, 0, 0, size.func_177958_n(), size.func_177956_o() - 1, size.func_177952_p());
        switch (rotation) {
            case CLOCKWISE_90: {
                this.field_74887_e.func_78886_a(-size.func_177958_n(), 0, 0);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                this.field_74887_e.func_78886_a(0, 0, -size.func_177952_p());
                break;
            }
            case CLOCKWISE_180: {
                this.field_74887_e.func_78886_a(-size.func_177958_n(), 0, -size.func_177952_p());
                break;
            }
        }
        switch (mirror) {
            case FRONT_BACK: {
                BlockPos blockpos2 = BlockPos.field_177992_a;
                if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
                    if (rotation == Rotation.CLOCKWISE_180) {
                        blockpos2 = blockpos2.func_177967_a(Direction.EAST, size.func_177958_n());
                    }
                    else {
                        blockpos2 = blockpos2.func_177967_a(Direction.WEST, size.func_177958_n());
                    }
                }
                else {
                    blockpos2 = blockpos2.func_177967_a(rotation.func_185831_a(Direction.WEST), size.func_177952_p());
                }
                this.field_74887_e.func_78886_a(blockpos2.func_177958_n(), 0, blockpos2.func_177952_p());
                break;
            }
            case LEFT_RIGHT: {
                BlockPos blockpos3 = BlockPos.field_177992_a;
                if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
                    if (rotation == Rotation.CLOCKWISE_180) {
                        blockpos3 = blockpos3.func_177967_a(Direction.SOUTH, size.func_177952_p());
                    }
                    else {
                        blockpos3 = blockpos3.func_177967_a(Direction.NORTH, size.func_177952_p());
                    }
                }
                else {
                    blockpos3 = blockpos3.func_177967_a(rotation.func_185831_a(Direction.NORTH), size.func_177958_n());
                }
                this.field_74887_e.func_78886_a(blockpos3.func_177958_n(), 0, blockpos3.func_177952_p());
                break;
            }
        }
        this.field_74887_e.func_78886_a(this.templatePosition.func_177958_n(), this.templatePosition.func_177956_o(), this.templatePosition.func_177952_p());
    }
}
