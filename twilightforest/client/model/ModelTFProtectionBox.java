// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

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
    
    public void func_78086_a(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
    }
    
    public ModelTFProtectionBox() {
        this.field_78090_t = 16;
        this.field_78089_u = 16;
        (this.box = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(0.0f, 0.0f, 0.0f, 16, 16, 16, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final EntityTFProtectionBox boxEntity = (EntityTFProtectionBox)par1Entity;
        final int pixelsX = boxEntity.sizeX * 16 + 2;
        final int pixelsY = boxEntity.sizeY * 16 + 2;
        final int pixelsZ = boxEntity.sizeZ * 16 + 2;
        if (pixelsX != this.lastPixelsX || pixelsY != this.lastPixelsY || pixelsZ != this.lastPixelsZ) {
            this.resizeBoxElement(pixelsX, pixelsY, pixelsZ);
        }
        this.box.func_78785_a(par7);
    }
    
    private void resizeBoxElement(final int pixelsX, final int pixelsY, final int pixelsZ) {
        (this.box = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, -1.0f, -1.0f, pixelsX, pixelsY, pixelsZ, 0.0f);
        this.box.func_78793_a(0.0f, 0.0f, 0.0f);
        this.lastPixelsX = pixelsX;
        this.lastPixelsY = pixelsY;
        this.lastPixelsZ = pixelsZ;
    }
}
