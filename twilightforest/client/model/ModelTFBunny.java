// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFBunny extends ModelBase
{
    ModelRenderer tail;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer head;
    
    public ModelTFBunny() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.func_78085_a("head.head", 0, 0);
        this.func_78085_a("head.ear2", 16, 0);
        this.func_78085_a("head.ear1", 16, 0);
        (this.tail = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 2);
        this.tail.func_78793_a(0.0f, 20.0f, 3.0f);
        this.tail.func_78787_b(32, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 0, 8)).func_78789_a(-2.0f, -1.0f, -2.0f, 4, 3, 5);
        this.body.func_78793_a(0.0f, 21.0f, 0.0f);
        this.body.func_78787_b(32, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg1.func_78793_a(-2.0f, 23.0f, 2.0f);
        this.leg1.func_78787_b(32, 32);
        this.leg1.field_78809_i = true;
        this.setRotation(this.leg1, 0.0f, 0.0f, 0.0f);
        (this.leg2 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg2.func_78793_a(1.0f, 23.0f, 2.0f);
        this.leg2.func_78787_b(32, 32);
        this.leg2.field_78809_i = true;
        this.setRotation(this.leg2, 0.0f, 0.0f, 0.0f);
        (this.leg3 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg3.func_78793_a(-2.0f, 23.0f, -2.0f);
        this.leg3.func_78787_b(32, 32);
        this.leg3.field_78809_i = true;
        this.setRotation(this.leg3, 0.0f, 0.0f, 0.0f);
        (this.leg4 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg4.func_78793_a(1.0f, 23.0f, -2.0f);
        this.leg4.func_78787_b(32, 32);
        this.leg4.field_78809_i = true;
        this.setRotation(this.leg4, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, "head")).func_78793_a(0.0f, 22.0f, -1.0f);
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.head.field_78809_i = true;
        this.head.func_78786_a("head", -2.0f, -4.0f, -3.0f, 4, 4, 4);
        this.head.func_78786_a("ear2", -2.5f, -8.0f, -0.5f, 2, 4, 1);
        this.head.func_78786_a("ear1", 0.5f, -8.0f, -0.5f, 2, 4, 1);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.tail.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.field_78795_f = par5 / 57.295776f;
        this.head.field_78796_g = par4 / 57.295776f;
        this.leg1.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.leg2.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg3.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg4.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
    }
}
