// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SnowQueenTrophyModel extends GenericTrophyModel
{
    public ModelRenderer head;
    public ModelRenderer crownFront;
    public ModelRenderer crownBack;
    public ModelRenderer crownRight;
    public ModelRenderer crownLeft;
    
    public SnowQueenTrophyModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_228302_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        (this.crownRight = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-4.0f, -6.0f, 0.0f);
        this.crownRight.func_78784_a(24, 4).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownRight, 0.3926991f, 1.5707964f, 0.0f);
        (this.crownBack = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -6.0f, 4.0f);
        this.crownBack.func_78784_a(44, 0).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownBack, -0.3926991f, 0.0f, 0.0f);
        (this.crownLeft = new ModelRenderer((Model)this, 0, 0)).func_78793_a(4.0f, -6.0f, 0.0f);
        this.crownLeft.func_78784_a(44, 4).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownLeft, -0.3926991f, 1.5707964f, 0.0f);
        (this.crownFront = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -6.0f, -4.0f);
        this.crownFront.func_78784_a(24, 0).func_228302_a_(-5.0f, -4.0f, 0.0f, 10.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.crownFront, 0.3926991f, 0.0f, 0.0f);
        this.head.func_78792_a(this.crownRight);
        this.head.func_78792_a(this.crownBack);
        this.head.func_78792_a(this.crownLeft);
        this.head.func_78792_a(this.crownFront);
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        super.setRotations(x, y, z);
        this.head.field_78796_g = y * 0.017453292f;
        this.head.field_78795_f = x * 0.017453292f;
    }
    
    @Override
    public void func_225598_a_(final MatrixStack matrix, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.func_228309_a_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
