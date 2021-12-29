// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.DeerEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class DeerLegacyModel extends QuadrupedModel<DeerEntity>
{
    public ModelRenderer neck;
    
    public DeerLegacyModel() {
        super(12, 0.0f, false, 4.0f, 4.0f, 2.0f, 2.0f, 10);
        (this.field_78150_a = new ModelRenderer((Model)this, 0, 5)).func_228301_a_(-2.0f, -8.0f, -6.0f, 4.0f, 6.0f, 6.0f, 0.0f);
        this.field_78150_a.func_78793_a(0.0f, 4.0f, -7.0f);
        (this.field_78148_b = new ModelRenderer((Model)this, 36, 6)).func_228301_a_(-4.0f, -10.0f, -7.0f, 6.0f, 18.0f, 8.0f, 0.0f);
        this.field_78148_b.func_78793_a(1.0f, 5.0f, 2.0f);
        this.field_78148_b.field_78795_f = 1.570796f;
        (this.field_78149_c = new ModelRenderer((Model)this, 0, 17)).func_228301_a_(-3.0f, 0.0f, -2.0f, 2.0f, 12.0f, 3.0f, 0.0f);
        this.field_78149_c.func_78793_a(0.0f, 12.0f, 9.0f);
        (this.field_78146_d = new ModelRenderer((Model)this, 0, 17)).func_228301_a_(-1.0f, 0.0f, -2.0f, 2.0f, 12.0f, 3.0f, 0.0f);
        this.field_78146_d.func_78793_a(2.0f, 12.0f, 9.0f);
        (this.field_78147_e = new ModelRenderer((Model)this, 0, 17)).func_228301_a_(-3.0f, 0.0f, -3.0f, 2.0f, 12.0f, 3.0f, 0.0f);
        this.field_78147_e.func_78793_a(0.0f, 12.0f, -5.0f);
        (this.field_78144_f = new ModelRenderer((Model)this, 0, 17)).func_228301_a_(-1.0f, 0.0f, -3.0f, 2.0f, 12.0f, 3.0f, 0.0f);
        this.field_78144_f.func_78793_a(2.0f, 12.0f, -5.0f);
        (this.neck = new ModelRenderer((Model)this, 10, 19)).func_228301_a_(-2.5f, -8.0f, -11.0f, 3.0f, 9.0f, 4.0f, 0.0f);
        this.neck.field_78795_f = 4.974188f;
        this.field_78148_b.func_78792_a(this.neck);
        this.field_78150_a.func_78784_a(52, 0).func_228301_a_(-1.5f, -5.0f, -9.0f, 3.0f, 3.0f, 3.0f, 0.0f);
        this.field_78150_a.func_78784_a(20, 0);
        this.field_78150_a.func_228301_a_(-3.0f, -10.0f, -2.0f, 2.0f, 2.0f, 2.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-3.0f, -10.0f, -2.0f, 2.0f, 2.0f, 2.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-4.0f, -10.0f, -1.0f, 1.0f, 1.0f, 3.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-5.0f, -11.0f, 1.0f, 1.0f, 1.0f, 5.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-5.0f, -14.0f, 2.0f, 1.0f, 4.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-6.0f, -17.0f, 3.0f, 1.0f, 4.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-6.0f, -13.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-6.0f, -14.0f, -3.0f, 1.0f, 1.0f, 4.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-7.0f, -15.0f, -6.0f, 1.0f, 1.0f, 4.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-6.0f, -16.0f, -9.0f, 1.0f, 1.0f, 4.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-7.0f, -18.0f, -1.0f, 1.0f, 5.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(-6.0f, -19.0f, -6.0f, 1.0f, 5.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(1.0f, -10.0f, -2.0f, 2.0f, 2.0f, 2.0f, 0.0f);
        this.field_78150_a.func_228301_a_(3.0f, -10.0f, -1.0f, 1.0f, 1.0f, 3.0f, 0.0f);
        this.field_78150_a.func_228301_a_(4.0f, -11.0f, 1.0f, 1.0f, 1.0f, 5.0f, 0.0f);
        this.field_78150_a.func_228301_a_(4.0f, -14.0f, 2.0f, 1.0f, 4.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(5.0f, -17.0f, 3.0f, 1.0f, 4.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(5.0f, -13.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f);
        this.field_78150_a.func_228301_a_(5.0f, -14.0f, -3.0f, 1.0f, 1.0f, 4.0f, 0.0f);
        this.field_78150_a.func_228301_a_(6.0f, -15.0f, -6.0f, 1.0f, 1.0f, 4.0f, 0.0f);
        this.field_78150_a.func_228301_a_(5.0f, -16.0f, -9.0f, 1.0f, 1.0f, 4.0f, 0.0f);
        this.field_78150_a.func_228301_a_(6.0f, -18.0f, -1.0f, 1.0f, 5.0f, 1.0f, 0.0f);
        this.field_78150_a.func_228301_a_(5.0f, -19.0f, -6.0f, 1.0f, 5.0f, 1.0f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.field_217114_e) {
            stack.func_227860_a_();
            stack.func_227862_a_(0.75f, 0.75f, 0.75f);
            stack.func_227861_a_(0.0, 0.949999988079071, 0.15000000596046448);
            this.func_225602_a_().forEach(modelRenderer -> modelRenderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
            stack.func_227860_a_();
            stack.func_227862_a_(0.5f, 0.5f, 0.5f);
            stack.func_227861_a_(0.0, 1.5, 0.0);
            this.func_225600_b_().forEach(modelRenderer -> modelRenderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
        }
        else {
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
}
