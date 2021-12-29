// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.MinotaurEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

@OnlyIn(Dist.CLIENT)
public class MinotaurModel extends BipedModel<MinotaurEntity>
{
    public MinotaurModel() {
        super(0.0f, 0.0f, 64, 64);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.5f, 12.0f, 0.0f);
        this.field_178721_j.func_78784_a(0, 26).func_228302_a_(-2.5f, 0.0f, -2.5f, 5.0f, 12.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-7.5f, -4.0f, 0.0f);
        this.field_178723_h.func_78784_a(20, 26).func_228302_a_(-3.0f, -4.0f, -2.5f, 4.0f, 14.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.field_78115_e.func_78784_a(34, 0).func_228302_a_(-5.0f, -2.0f, -2.5f, 10.0f, 14.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.field_78116_c.func_228302_a_(-4.0f, -10.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(25, 1).func_228302_a_(-3.0f, -5.0f, -5.0f, 6.0f, 3.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(0, 16).func_228302_a_(-8.0f, -9.0f, -1.0f, 4.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(0, 20).func_228302_a_(-8.0f, -11.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(12, 16).func_228302_a_(4.0f, -9.0f, -1.0f, 4.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.field_78116_c.func_78784_a(12, 20).func_228302_a_(6.0f, -11.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178722_k = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.5f, 12.0f, 0.0f);
        this.field_178722_k.func_78784_a(0, 43).func_228302_a_(-2.5f, 0.0f, -2.5f, 5.0f, 12.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.field_178724_i = new ModelRenderer((Model)this, 0, 0)).func_78793_a(7.5f, -4.0f, 0.0f);
        this.field_178724_i.func_78784_a(20, 45).func_228302_a_(0.0f, -4.0f, -2.5f, 4.0f, 14.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.field_178720_f = new ModelRenderer((Model)this, 0, 0);
    }
    
    public void func_225598_a_(final MatrixStack matrixStackIn, final IVertexBuilder bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, 0.5, 0.0);
        }
        super.func_225598_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
