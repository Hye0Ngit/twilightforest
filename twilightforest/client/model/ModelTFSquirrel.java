// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import twilightforest.entity.passive.EntityTFSquirrel;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFSquirrel extends ModelBase
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer head;
    ModelRenderer tail;
    ModelRenderer fluff1;
    ModelRenderer fluff2;
    ModelRenderer fluff3;
    
    public ModelTFSquirrel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.func_78085_a("head.head", 0, 0);
        this.func_78085_a("head.ear2", 16, 0);
        this.func_78085_a("head.ear1", 16, 0);
        this.func_78085_a("tail.fluff1", 0, 20);
        this.func_78085_a("tail.base", 0, 18);
        this.func_78085_a("tail.fluff2", 0, 20);
        this.func_78085_a("tail.fluff3", 0, 26);
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
        this.setRotation(this.leg3, 0.0f, 0.0f, 0.0f);
        (this.leg4 = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg4.func_78793_a(1.0f, 23.0f, -2.0f);
        this.leg4.func_78787_b(32, 32);
        this.setRotation(this.leg4, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, "head")).func_78793_a(0.0f, 22.0f, -2.0f);
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.head.func_78786_a("head", -2.0f, -5.0f, -3.0f, 4, 4, 4);
        this.head.func_78786_a("ear2", -2.0f, -6.0f, -0.5f, 1, 1, 1);
        this.head.func_78786_a("ear1", 1.0f, -6.0f, -0.5f, 1, 1, 1);
        (this.tail = new ModelRenderer((ModelBase)this, "tail")).func_78793_a(0.0f, 21.0f, 2.0f);
        this.tail.func_78786_a("base", -0.5f, -1.5f, 0.5f, 1, 1, 1);
        (this.fluff1 = new ModelRenderer((ModelBase)this, 0, 20)).func_78789_a(-1.5f, -4.0f, 1.0f, 3, 3, 3);
        this.tail.func_78792_a(this.fluff1);
        (this.fluff2 = new ModelRenderer((ModelBase)this, 0, 20)).func_78789_a(0.0f, -3.0f, -1.5f, 3, 3, 3);
        this.fluff2.func_78793_a(-1.5f, -4.0f, 2.5f);
        this.fluff1.func_78792_a(this.fluff2);
        (this.fluff3 = new ModelRenderer((ModelBase)this, 0, 26)).func_78789_a(1.5f, -3.0f, -1.5f, 3, 3, 3);
        this.fluff3.func_78793_a(-1.5f, -3.0f, 0.0f);
        this.fluff2.func_78792_a(this.fluff3);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.body.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.tail.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78086_a(final EntityLiving par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFSquirrel squirrel = (EntityTFSquirrel)par1EntityLiving;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.field_78795_f = par5 / 57.295776f;
        this.head.field_78796_g = par4 / 57.295776f;
        this.leg1.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.leg2.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg3.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg4.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        if (par2 > 0.2) {
            final float wiggle = Math.min(par2, 0.6f);
            this.tail.field_78795_f = (MathHelper.func_76134_b(par3 * 0.6662f) * 1.0f - 1.0471976f) * wiggle;
            this.fluff2.field_78795_f = MathHelper.func_76134_b(par3 * 0.7774f) * 1.2f * wiggle;
            this.fluff3.field_78795_f = MathHelper.func_76134_b(par3 * 0.8886f + 1.5707964f) * 1.4f * wiggle;
        }
        else {
            this.tail.field_78795_f = 0.2f + MathHelper.func_76134_b(par3 * 0.3335f) * 0.15f;
            this.fluff2.field_78795_f = 0.1f + MathHelper.func_76134_b(par3 * 0.4445f) * 0.2f;
            this.fluff3.field_78795_f = 0.1f + MathHelper.func_76134_b(par3 * 0.5555f) * 0.25f;
        }
    }
}
