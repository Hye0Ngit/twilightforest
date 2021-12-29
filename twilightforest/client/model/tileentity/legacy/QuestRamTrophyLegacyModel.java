// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity.legacy;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.client.model.tileentity.GenericTrophyModel;

public class QuestRamTrophyLegacyModel extends GenericTrophyModel
{
    public ModelRenderer neck;
    public ModelRenderer nose;
    public ModelRenderer head;
    
    public QuestRamTrophyLegacyModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.neck = new ModelRenderer((Model)this, 66, 37)).func_228300_a_(-5.5f, -8.0f, 0.0f, 11.0f, 14.0f, 12.0f);
        this.neck.func_78793_a(0.0f, -8.0f, -7.0f);
        this.setRotation(this.neck, 0.2617994f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this)).func_78793_a(0.0f, -4.0f, -0.0f);
        this.head.func_78784_a(0, 70).func_228300_a_(-6.0f, -4.5f, -7.0f, 12.0f, 9.0f, 15.0f);
        this.head.func_78784_a(0, 94).func_228300_a_(5.0f, -9.0f, 1.0f, 4.0f, 4.0f, 6.0f);
        this.head.func_78784_a(20, 96).func_228300_a_(7.0f, -8.0f, 6.0f, 3.0f, 4.0f, 4.0f);
        this.head.func_78784_a(34, 95).func_228300_a_(8.0f, -6.0f, 8.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(46, 98).func_228300_a_(9.5f, -2.0f, 6.0f, 3.0f, 3.0f, 3.0f);
        this.head.func_78784_a(58, 95).func_228300_a_(11.0f, 0.0f, 1.0f, 3.0f, 3.0f, 6.0f);
        this.head.func_78784_a(76, 95).func_228300_a_(12.0f, -4.0f, -1.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(88, 97).func_228300_a_(13.0f, -6.0f, 1.0f, 3.0f, 3.0f, 4.0f);
        this.head.func_78784_a(0, 94).func_228300_a_(-9.0f, -9.0f, 1.0f, 4.0f, 4.0f, 6.0f);
        this.head.func_78784_a(20, 96).func_228300_a_(-10.0f, -8.0f, 6.0f, 3.0f, 4.0f, 4.0f);
        this.head.func_78784_a(34, 95).func_228300_a_(-11.0f, -6.0f, 8.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(46, 98).func_228300_a_(-12.5f, -2.0f, 6.0f, 3.0f, 3.0f, 3.0f);
        this.head.func_78784_a(58, 95).func_228300_a_(-14.0f, 0.0f, 1.0f, 3.0f, 3.0f, 6.0f);
        this.head.func_78784_a(76, 95).func_228300_a_(-15.0f, -4.0f, -1.0f, 3.0f, 6.0f, 3.0f);
        this.head.func_78784_a(88, 97).func_228300_a_(-16.0f, -6.0f, 1.0f, 3.0f, 3.0f, 4.0f);
        (this.nose = new ModelRenderer((Model)this, 54, 73)).func_228300_a_(-5.5f, -1.0f, -6.0f, 11.0f, 9.0f, 12.0f);
        this.nose.func_78793_a(0.0f, -7.0f, -1.0f);
        this.nose.func_78787_b(128, 128);
        this.setRotation(this.nose, 0.5235988f, 0.0f, 0.0f);
        this.head.func_78792_a(this.nose);
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
    
    @Override
    public void func_225598_a_(final MatrixStack matrix, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.func_228309_a_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
