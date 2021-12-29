// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelTFYetiAlphaTrophy extends GenericTrophyModel
{
    public final ModelRenderer main;
    
    public ModelTFYetiAlphaTrophy() {
        this.field_78090_t = 256;
        this.field_78089_u = 128;
        (this.main = new ModelRenderer((Model)this)).func_78793_a(0.0f, -6.0f, 0.0f);
        final ModelRenderer head = new ModelRenderer((Model)this);
        head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.main.func_78792_a(head);
        head.func_78784_a(80, 0).func_228303_a_(-24.0f, -24.0f, -18.0f, 48.0f, 54.0f, 36.0f, 0.0f, false);
        head.func_78784_a(64, 0).func_228303_a_(8.0f, -20.0f, -19.5f, 12.0f, 12.0f, 2.0f, 0.0f, false);
        head.func_78784_a(121, 50).func_228303_a_(-17.0f, -8.0f, -19.5f, 34.0f, 29.0f, 2.0f, 0.0f, false);
        head.func_78784_a(64, 0).func_228303_a_(-20.0f, -20.0f, -19.5f, 12.0f, 12.0f, 2.0f, 0.0f, false);
        final ModelRenderer lefthorn1 = new ModelRenderer((Model)this);
        lefthorn1.func_78793_a(22.0f, 6.0f, -1.0f);
        this.main.func_78792_a(lefthorn1);
        this.setRotationAngle(lefthorn1, 0.0f, 0.5236f, 0.0873f);
        lefthorn1.func_78784_a(0, 108).func_228303_a_(1.6981f, -10.9848f, -5.1743f, 10.0f, 10.0f, 10.0f, 0.0f, false);
        final ModelRenderer top_r1 = new ModelRenderer((Model)this);
        top_r1.func_78793_a(11.0f, -2.0f, 0.0f);
        lefthorn1.func_78792_a(top_r1);
        this.setRotationAngle(top_r1, 0.0f, 0.3491f, 0.0873f);
        top_r1.func_78784_a(40, 108).func_228303_a_(0.4505f, -7.9433f, -4.3855f, 18.0f, 8.0f, 8.0f, 0.0f, false);
        final ModelRenderer lefthorn2 = new ModelRenderer((Model)this);
        lefthorn2.func_78793_a(24.0f, -4.0f, -1.0f);
        this.main.func_78792_a(lefthorn2);
        this.setRotationAngle(lefthorn2, 0.0f, 0.5236f, -0.2618f);
        lefthorn2.func_78784_a(0, 108).func_228303_a_(0.8966f, -10.8637f, -4.4824f, 10.0f, 10.0f, 10.0f, 0.0f, false);
        final ModelRenderer top_r2 = new ModelRenderer((Model)this);
        top_r2.func_78793_a(9.0f, -1.0f, 0.0f);
        lefthorn2.func_78792_a(top_r2);
        this.setRotationAngle(top_r2, 0.0f, 0.3491f, -0.2618f);
        top_r2.func_78784_a(40, 108).func_228303_a_(2.5764f, -8.5f, -2.8753f, 18.0f, 8.0f, 8.0f, 0.0f, false);
        final ModelRenderer lefthorn3 = new ModelRenderer((Model)this);
        lefthorn3.func_78793_a(24.0f, -16.0f, -1.0f);
        this.main.func_78792_a(lefthorn3);
        this.setRotationAngle(lefthorn3, 0.0f, 0.5236f, -0.6109f);
        lefthorn3.func_78784_a(0, 108).func_228303_a_(1.9869f, -10.2766f, -3.8528f, 10.0f, 10.0f, 10.0f, 0.0f, false);
        final ModelRenderer top_r3 = new ModelRenderer((Model)this);
        top_r3.func_78793_a(8.0f, -2.0f, 0.0f);
        lefthorn3.func_78792_a(top_r3);
        this.setRotationAngle(top_r3, 0.0f, 0.3491f, -0.6109f);
        top_r3.func_78784_a(40, 108).func_228303_a_(4.9031f, -5.5443f, -1.7225f, 18.0f, 8.0f, 8.0f, 0.0f, false);
        final ModelRenderer righthorn1 = new ModelRenderer((Model)this);
        righthorn1.func_78793_a(-22.0f, 6.0f, -1.0f);
        this.main.func_78792_a(righthorn1);
        this.setRotationAngle(righthorn1, 0.0f, -0.5236f, -0.0873f);
        righthorn1.func_78784_a(0, 108).func_228303_a_(-11.6981f, -10.9848f, -5.1743f, 10.0f, 10.0f, 10.0f, 0.0f, true);
        final ModelRenderer top_r4 = new ModelRenderer((Model)this);
        top_r4.func_78793_a(-11.0f, -2.0f, 0.0f);
        righthorn1.func_78792_a(top_r4);
        this.setRotationAngle(top_r4, 0.0f, -0.3491f, -0.0873f);
        top_r4.func_78784_a(40, 108).func_228303_a_(-18.4505f, -7.9433f, -4.3855f, 18.0f, 8.0f, 8.0f, 0.0f, true);
        final ModelRenderer righthorn2 = new ModelRenderer((Model)this);
        righthorn2.func_78793_a(-24.0f, -4.0f, -1.0f);
        this.main.func_78792_a(righthorn2);
        this.setRotationAngle(righthorn2, 0.0f, -0.5236f, 0.2618f);
        righthorn2.func_78784_a(0, 108).func_228303_a_(-10.8966f, -10.8637f, -4.4824f, 10.0f, 10.0f, 10.0f, 0.0f, true);
        final ModelRenderer top_r5 = new ModelRenderer((Model)this);
        top_r5.func_78793_a(-9.0f, -1.0f, 0.0f);
        righthorn2.func_78792_a(top_r5);
        this.setRotationAngle(top_r5, 0.0f, -0.3491f, 0.2618f);
        top_r5.func_78784_a(40, 108).func_228303_a_(-20.5764f, -8.5f, -2.8753f, 18.0f, 8.0f, 8.0f, 0.0f, true);
        final ModelRenderer righthorn3 = new ModelRenderer((Model)this);
        righthorn3.func_78793_a(-24.0f, -16.0f, -1.0f);
        this.main.func_78792_a(righthorn3);
        this.setRotationAngle(righthorn3, 0.0f, -0.5236f, 0.6109f);
        righthorn3.func_78784_a(0, 108).func_228303_a_(-11.9869f, -10.2766f, -3.8528f, 10.0f, 10.0f, 10.0f, 0.0f, true);
        final ModelRenderer top_r6 = new ModelRenderer((Model)this);
        top_r6.func_78793_a(-8.0f, -2.0f, 0.0f);
        righthorn3.func_78792_a(top_r6);
        this.setRotationAngle(top_r6, 0.0f, -0.3491f, 0.6109f);
        top_r6.func_78784_a(40, 108).func_228303_a_(-22.9031f, -5.5443f, -1.7225f, 18.0f, 8.0f, 8.0f, 0.0f, true);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        super.setRotations(x, y, z);
        this.main.field_78796_g = y * 0.017453292f;
        this.main.field_78795_f = x * 0.017453292f;
    }
    
    @Override
    public void func_225598_a_(final MatrixStack matrixStack, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.main.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
    }
    
    public void setRotationAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
