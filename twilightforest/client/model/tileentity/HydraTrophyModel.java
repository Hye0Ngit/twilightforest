// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HydraTrophyModel extends GenericTrophyModel
{
    public ModelRenderer head;
    public ModelRenderer plate;
    public ModelRenderer mouth;
    
    public HydraTrophyModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(260, 64).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(236, 128).func_228302_a_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(356, 70).func_228302_a_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f, 0.0f, 0.0f, 0.0f);
        (this.plate = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.plate.func_78784_a(388, 0).func_228302_a_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.plate.func_78784_a(220, 0).func_228302_a_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.plate, -0.7853982f, 0.0f, 0.0f);
        this.head.func_78792_a(this.plate);
        (this.mouth = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 10.0f, -14.0f);
        this.mouth.func_78784_a(240, 162).func_228302_a_(-15.0f, -2.0f, -24.0f, 30.0f, 8.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.mouth);
    }
    
    private void setRotateAngle(final ModelRenderer model, final float x, final float y, final float z) {
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
        this.mouth.field_78795_f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    @Override
    public void func_225598_a_(final MatrixStack matrix, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.func_228309_a_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
