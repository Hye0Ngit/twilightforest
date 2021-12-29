// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PhantomArmorTrophyModel extends GenericTrophyModel
{
    public ModelRenderer head;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    
    public PhantomArmorTrophyModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.head.func_78793_a(0.0f, -4.0f, 0.0f);
        (this.righthorn1 = new ModelRenderer((Model)this, 24, 0)).func_228300_a_(-5.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f);
        this.righthorn1.func_78793_a(-4.0f, -6.5f, 0.0f);
        this.righthorn1.field_78796_g = -0.43633235f;
        this.righthorn1.field_78808_h = 0.7853982f;
        (this.righthorn2 = new ModelRenderer((Model)this, 54, 16)).func_228300_a_(-3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.righthorn2.func_78793_a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.field_78796_g = -0.2617994f;
        this.righthorn2.field_78808_h = 0.7853982f;
        this.head.func_78792_a(this.righthorn1);
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((Model)this, 24, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_228300_a_(0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f);
        this.lefthorn1.func_78793_a(4.0f, -6.5f, 0.0f);
        this.lefthorn1.field_78796_g = 0.43633235f;
        this.lefthorn1.field_78808_h = -0.7853982f;
        (this.lefthorn2 = new ModelRenderer((Model)this, 54, 16)).func_228300_a_(0.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f);
        this.lefthorn2.func_78793_a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78796_g = 0.2617994f;
        this.lefthorn2.field_78808_h = -0.7853982f;
        this.head.func_78792_a(this.lefthorn1);
        this.lefthorn1.func_78792_a(this.lefthorn2);
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
