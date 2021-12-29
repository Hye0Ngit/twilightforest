// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import twilightforest.entity.ProtectionBoxEntity;

public class ProtectionBoxModel<T extends ProtectionBoxEntity> extends SegmentedModel<T>
{
    private T entity;
    public ModelRenderer box;
    private int lastPixelsX;
    private int lastPixelsY;
    private int lastPixelsZ;
    
    public ProtectionBoxModel() {
        this.field_78090_t = 16;
        this.field_78089_u = 16;
        (this.box = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.box);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        final ProtectionBoxEntity boxEntity = this.entity;
        final int pixelsX = boxEntity.sizeX * 16 + 2;
        final int pixelsY = boxEntity.sizeY * 16 + 2;
        final int pixelsZ = boxEntity.sizeZ * 16 + 2;
        if (pixelsX != this.lastPixelsX || pixelsY != this.lastPixelsY || pixelsZ != this.lastPixelsZ) {
            this.resizeBoxElement(pixelsX, pixelsY, pixelsZ);
        }
        super.func_225598_a_(stack, builder, light, overlay, red, green, blue, scale);
    }
    
    public void setRotationAngles(final T entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void setLivingAnimations(final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.entity = entity;
    }
    
    private void resizeBoxElement(final int pixelsX, final int pixelsY, final int pixelsZ) {
        (this.box = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-1.0f, -1.0f, -1.0f, (float)pixelsX, (float)pixelsY, (float)pixelsZ, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
        this.lastPixelsX = pixelsX;
        this.lastPixelsY = pixelsY;
        this.lastPixelsZ = pixelsZ;
    }
}
