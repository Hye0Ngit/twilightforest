// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import twilightforest.entity.EntityTFProtectionBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFProtectionBox extends ModelBase
{
    public ModelRenderer box;
    private int lastPixelsX;
    private int lastPixelsY;
    private int lastPixelsZ;
    
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
    }
    
    public ModelTFProtectionBox() {
        this.field_78090_t = 16;
        this.field_78089_u = 16;
        (this.box = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(0.0f, 0.0f, 0.0f, 16, 16, 16, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        final EntityTFProtectionBox boxEntity = (EntityTFProtectionBox)entity;
        final int pixelsX = boxEntity.sizeX * 16 + 2;
        final int pixelsY = boxEntity.sizeY * 16 + 2;
        final int pixelsZ = boxEntity.sizeZ * 16 + 2;
        if (pixelsX != this.lastPixelsX || pixelsY != this.lastPixelsY || pixelsZ != this.lastPixelsZ) {
            this.resizeBoxElement(pixelsX, pixelsY, pixelsZ);
        }
        this.box.func_78785_a(scale);
    }
    
    private void resizeBoxElement(final int pixelsX, final int pixelsY, final int pixelsZ) {
        (this.box = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, -1.0f, -1.0f, pixelsX, pixelsY, pixelsZ, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
        this.lastPixelsX = pixelsX;
        this.lastPixelsY = pixelsY;
        this.lastPixelsZ = pixelsZ;
    }
}
