// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity.legacy;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.client.model.tileentity.GenericTrophyModel;

public class HydraTrophyLegacyModel extends GenericTrophyModel
{
    public ModelRenderer head;
    public ModelRenderer jaw;
    public ModelRenderer frill;
    
    public HydraTrophyLegacyModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        this.head = new ModelRenderer((Model)this);
        this.head.func_78784_a(272, 0).func_228300_a_(-16.0f, -14.0f, -16.0f, 32.0f, 24.0f, 32.0f);
        this.head.func_78784_a(272, 56).func_228300_a_(-15.0f, -2.0f, -40.0f, 30.0f, 12.0f, 24.0f);
        this.head.func_78784_a(272, 132).func_228300_a_(-15.0f, 10.0f, -4.0f, 30.0f, 8.0f, 16.0f);
        this.head.func_78784_a(128, 200).func_228300_a_(-2.0f, -30.0f, 4.0f, 4.0f, 24.0f, 24.0f);
        this.head.func_78784_a(272, 156).func_228300_a_(-12.0f, 10.0f, -33.0f, 2.0f, 5.0f, 2.0f);
        this.head.func_78784_a(272, 156).func_228300_a_(10.0f, 10.0f, -33.0f, 2.0f, 5.0f, 2.0f);
        this.head.func_78784_a(280, 156).func_228300_a_(-8.0f, 9.0f, -33.0f, 16.0f, 2.0f, 2.0f);
        this.head.func_78784_a(280, 160).func_228300_a_(-10.0f, 9.0f, -29.0f, 2.0f, 2.0f, 16.0f);
        this.head.func_78784_a(280, 160).func_228300_a_(8.0f, 9.0f, -29.0f, 2.0f, 2.0f, 16.0f);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((Model)this)).func_78793_a(0.0f, 10.0f, -20.0f);
        this.jaw.func_78784_a(272, 92).func_228300_a_(-15.0f, 0.0f, -16.0f, 30.0f, 8.0f, 32.0f);
        this.jaw.func_78784_a(272, 156).func_228300_a_(-10.0f, -5.0f, -13.0f, 2.0f, 5.0f, 2.0f);
        this.jaw.func_78784_a(272, 156).func_228300_a_(8.0f, -5.0f, -13.0f, 2.0f, 5.0f, 2.0f);
        this.jaw.func_78784_a(280, 156).func_228300_a_(-8.0f, -1.0f, -13.0f, 16.0f, 2.0f, 2.0f);
        this.jaw.func_78784_a(280, 160).func_228300_a_(-10.0f, -1.0f, -9.0f, 2.0f, 2.0f, 16.0f);
        this.jaw.func_78784_a(280, 160).func_228300_a_(8.0f, -1.0f, -9.0f, 2.0f, 2.0f, 16.0f);
        this.setRotation(this.jaw, 0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.jaw);
        (this.frill = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, -14.0f);
        this.frill.func_78784_a(272, 200).func_228300_a_(-24.0f, -48.0f, 12.0f, 48.0f, 48.0f, 4.0f);
        this.setRotation(this.frill, -0.5235988f, 0.0f, 0.0f);
        this.head.func_78792_a(this.frill);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        super.setRotations(x, y, z);
        this.head.field_78796_g = y * 0.017453292f;
        this.head.field_78795_f = x * 0.017453292f;
    }
    
    public void openMouthForTrophy(final float mouthOpen) {
        this.head.field_78796_g = 0.0f;
        this.head.field_78795_f = 0.0f;
        final ModelRenderer head = this.head;
        head.field_78795_f -= (float)(mouthOpen * 0.2617993877991494);
        this.jaw.field_78795_f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    @Override
    public void func_225598_a_(final MatrixStack matrix, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.func_228309_a_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
