// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.model.SheepModel;
import twilightforest.entity.passive.BighornEntity;

@OnlyIn(Dist.CLIENT)
public class BighornModel<T extends BighornEntity> extends SheepModel<T>
{
    public ModelRenderer rightHorn;
    public ModelRenderer leftHorn;
    
    public BighornModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.field_78147_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(3.0f, 12.0f, -3.0f);
        this.field_78147_e.func_78784_a(16, 32).func_228302_a_(-2.0f, 0.0f, -4.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78149_c = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-3.5f, 12.0f, 9.0f);
        this.field_78149_c.func_78784_a(0, 48).func_228302_a_(-1.5f, 0.0f, -4.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78148_b = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 10.0f, 6.0f);
        this.field_78148_b.func_78784_a(34, 13).func_228302_a_(-4.5f, -14.0f, -3.0f, 9.0f, 16.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.field_78148_b, 1.5707964f, 0.0f, 0.0f);
        (this.field_78146_d = new ModelRenderer((Model)this, 0, 0)).func_78793_a(3.5f, 12.0f, 9.0f);
        this.field_78146_d.func_78784_a(16, 48).func_228302_a_(-2.5f, 0.0f, -4.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.field_78147_e = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-3.0f, 12.0f, -3.0f);
        this.field_78147_e.func_78784_a(0, 32).func_228302_a_(-2.0f, 0.0f, -4.0f, 4.0f, 12.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.leftHorn = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, -3.0f, -1.0f);
        this.leftHorn.func_78784_a(16, 0).func_228302_a_(0.0f, -1.0f, -7.0f, 3.0f, 3.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.leftHorn.func_78784_a(16, 8).func_228302_a_(1.0f, 2.0f, -9.0f, 3.0f, 2.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.leftHorn.func_78784_a(20, 15).func_228302_a_(2.0f, 0.0f, -11.0f, 2.0f, 3.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftHorn, 0.0f, -0.3926991f, -0.21816616f);
        (this.field_78150_a = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 5.0f, -8.0f);
        this.field_78150_a.func_78784_a(38, 0).func_228302_a_(-3.0f, -4.0f, -6.0f, 6.0f, 6.0f, 7.0f, 0.0f, 0.0f, 0.0f);
        (this.rightHorn = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, -3.0f, -1.0f);
        this.rightHorn.func_228302_a_(-3.0f, -1.0f, -7.0f, 3.0f, 3.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.rightHorn.func_78784_a(0, 8).func_228302_a_(-4.0f, 2.0f, -9.0f, 3.0f, 2.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.rightHorn.func_78784_a(4, 15).func_228302_a_(-4.0f, 0.0f, -11.0f, 2.0f, 3.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightHorn, 0.0f, 0.3926991f, 0.21816616f);
        this.field_78150_a.func_78792_a(this.leftHorn);
        this.field_78150_a.func_78792_a(this.rightHorn);
    }
    
    public void func_225598_a_(final MatrixStack matrixStackIn, final IVertexBuilder bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.field_217114_e) {
            matrixStackIn.func_227860_a_();
            matrixStackIn.func_227861_a_(0.0, 0.5, 0.25);
            ImmutableList.of((Object)this.field_78150_a).forEach(modelRenderer -> modelRenderer.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha));
            matrixStackIn.func_227865_b_();
            matrixStackIn.func_227860_a_();
            matrixStackIn.func_227862_a_(0.5f, 0.5f, 0.5f);
            matrixStackIn.func_227861_a_(0.0, 1.5, 0.0);
            ImmutableList.of((Object)this.field_78146_d, (Object)this.field_78149_c, (Object)this.field_78148_b, (Object)this.field_78144_f, (Object)this.field_78147_e).forEach(modelRenderer -> modelRenderer.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha));
            matrixStackIn.func_227865_b_();
        }
        else {
            ImmutableList.of((Object)this.field_78146_d, (Object)this.field_78149_c, (Object)this.field_78148_b, (Object)this.field_78144_f, (Object)this.field_78147_e, (Object)this.field_78150_a).forEach(modelRenderer -> modelRenderer.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha));
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
