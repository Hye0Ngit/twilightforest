// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFPinchBeetle;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFPinchBeetle extends ModelBase
{
    ModelRenderer thorax;
    ModelRenderer head;
    ModelRenderer connector2;
    ModelRenderer RearEnd;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer connector1;
    ModelRenderer jaw1a;
    ModelRenderer jaw1b;
    ModelRenderer jaw2a;
    ModelRenderer jaw2b;
    ModelRenderer antenna1;
    ModelRenderer antenna2;
    ModelRenderer eye1;
    ModelRenderer eye2;
    ModelRenderer tooth1a;
    ModelRenderer tooth1b;
    ModelRenderer tooth1c;
    ModelRenderer tooth2a;
    ModelRenderer tooth2b;
    ModelRenderer tooth2c;
    
    public ModelTFPinchBeetle() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.thorax = new ModelRenderer((ModelBase)this, 0, 22)).func_78789_a(-4.5f, -4.0f, 0.0f, 9, 8, 2);
        this.thorax.func_78793_a(0.0f, 18.0f, -4.5f);
        (this.connector1 = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(-3.0f, -3.0f, 0.0f, 6, 6, 1);
        this.connector1.func_78793_a(0.0f, 18.0f, -3.0f);
        (this.connector2 = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(-3.0f, -3.0f, -1.0f, 6, 6, 1);
        this.connector2.func_78793_a(0.0f, 18.0f, -4.0f);
        (this.RearEnd = new ModelRenderer((ModelBase)this, 28, 14)).func_78789_a(-5.0f, -9.0f, -4.0f, 10, 10, 8);
        this.RearEnd.func_78793_a(0.0f, 18.0f, 7.0f);
        this.setRotation(this.RearEnd, 1.570796f, 0.0f, 0.0f);
        (this.Leg6 = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg6.func_78793_a(4.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.3490659f);
        this.Leg5 = new ModelRenderer((ModelBase)this, 40, 0);
        this.Leg5.field_78809_i = true;
        this.Leg5.func_78789_a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg5.func_78793_a(-4.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.3490659f);
        (this.Leg4 = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg4.func_78793_a(4.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.3490659f);
        (this.Leg2 = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg2.func_78793_a(4.0f, 21.0f, 4.0f);
        this.setRotation(this.Leg2, 0.0f, -0.6981317f, 0.3490659f);
        this.Leg3 = new ModelRenderer((ModelBase)this, 40, 0);
        this.Leg3.field_78809_i = true;
        this.Leg3.func_78789_a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg3.func_78793_a(-4.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.3490659f);
        this.Leg1 = new ModelRenderer((ModelBase)this, 40, 0);
        this.Leg1.field_78809_i = true;
        this.Leg1.func_78789_a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg1.func_78793_a(-4.0f, 21.0f, 4.0f);
        this.Leg1.func_78787_b(64, 32);
        this.setRotation(this.Leg1, 0.0f, 0.6981317f, -0.3490659f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -4.0f, -6.0f, 8, 6, 6);
        this.head.func_78793_a(0.0f, 19.0f, -5.0f);
        (this.jaw1a = new ModelRenderer((ModelBase)this, 40, 6)).func_78789_a(-1.0f, -1.0f, -1.5f, 8, 2, 3);
        this.jaw1a.func_78793_a(-3.0f, 1.0f, -6.0f);
        this.setRotation(this.jaw1a, 0.0f, 2.635447f, 0.0f);
        (this.jaw1b = new ModelRenderer((ModelBase)this, 40, 10)).func_78789_a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.jaw1b.func_78793_a(7.0f, 0.0f, 0.0f);
        this.setRotation(this.jaw1b, 0.0f, -1.047197f, 0.0f);
        (this.jaw2a = new ModelRenderer((ModelBase)this, 40, 6)).func_78789_a(-1.0f, -1.0f, -1.5f, 8, 2, 3);
        this.jaw2a.func_78793_a(3.0f, 1.0f, -6.0f);
        this.setRotation(this.jaw2a, 0.0f, 0.541052f, 0.0f);
        (this.jaw2b = new ModelRenderer((ModelBase)this, 40, 10)).func_78789_a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.jaw2b.func_78793_a(7.0f, 0.0f, 0.0f);
        this.setRotation(this.jaw2b, 0.0f, 1.047197f, 0.0f);
        (this.antenna1 = new ModelRenderer((ModelBase)this, 42, 4)).func_78789_a(0.0f, -0.5f, -0.5f, 10, 1, 1);
        this.antenna1.func_78793_a(1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna1, 0.0f, 1.047198f, -0.296706f);
        (this.antenna2 = new ModelRenderer((ModelBase)this, 42, 4)).func_78789_a(0.0f, -0.5f, -0.5f, 10, 1, 1);
        this.antenna2.func_78793_a(-1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna2, 0.0f, 2.094395f, 0.296706f);
        (this.eye1 = new ModelRenderer((ModelBase)this, 15, 12)).func_78789_a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.eye1.func_78793_a(-3.0f, -2.0f, -5.0f);
        (this.eye2 = new ModelRenderer((ModelBase)this, 15, 12)).func_78789_a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.eye2.func_78793_a(3.0f, -2.0f, -5.0f);
        (this.tooth1a = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -0.5f, -0.0f, 2, 1, 1);
        this.tooth1a.func_78793_a(9.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth1a, 0.0f, -0.5235987f, 0.0f);
        (this.tooth1b = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.5f, -0.5f, -0.0f, 2, 1, 1);
        this.tooth1b.func_78793_a(6.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth1b, 0.0f, 1.5707963f, 0.0f);
        (this.tooth1c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.5f, -0.5f, -0.0f, 2, 1, 1);
        this.tooth1c.func_78793_a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth1c, 0.0f, 1.5707963f, 0.0f);
        (this.tooth2a = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -0.5f, -1.0f, 2, 1, 1);
        this.tooth2a.func_78793_a(9.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth2a, 0.0f, 0.5235987f, 0.0f);
        (this.tooth2b = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.5f, -0.5f, -1.0f, 2, 1, 1);
        this.tooth2b.func_78793_a(6.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth2b, 0.0f, -1.5707963f, 0.0f);
        (this.tooth2c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.5f, -0.5f, -1.0f, 2, 1, 1);
        this.tooth2c.func_78793_a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth2c, 0.0f, -1.5707963f, 0.0f);
        this.head.func_78792_a(this.jaw1a);
        this.jaw1a.func_78792_a(this.jaw1b);
        this.jaw1b.func_78792_a(this.tooth1a);
        this.jaw1b.func_78792_a(this.tooth1b);
        this.jaw1b.func_78792_a(this.tooth1c);
        this.jaw2b.func_78792_a(this.tooth2a);
        this.jaw2b.func_78792_a(this.tooth2b);
        this.jaw2b.func_78792_a(this.tooth2c);
        this.head.func_78792_a(this.jaw2a);
        this.jaw2a.func_78792_a(this.jaw2b);
        this.head.func_78792_a(this.antenna1);
        this.head.func_78792_a(this.antenna2);
        this.head.func_78792_a(this.eye1);
        this.head.func_78792_a(this.eye2);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.thorax.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.connector2.func_78785_a(f5);
        this.RearEnd.func_78785_a(f5);
        this.Leg6.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg5.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.connector1.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.head.field_78796_g = par4 / 57.295776f;
        this.head.field_78795_f = par5 / 57.295776f;
        final float legZ = 0.28559935f;
        this.Leg1.field_78808_h = -legZ;
        this.Leg2.field_78808_h = legZ;
        this.Leg3.field_78808_h = -legZ * 0.74f;
        this.Leg4.field_78808_h = legZ * 0.74f;
        this.Leg5.field_78808_h = -legZ;
        this.Leg6.field_78808_h = legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.Leg1.field_78796_g = var10 * 2.0f + var9;
        this.Leg2.field_78796_g = -var10 * 2.0f - var9;
        this.Leg3.field_78796_g = var10 * 1.0f + var9;
        this.Leg4.field_78796_g = -var10 * 1.0f - var9;
        this.Leg5.field_78796_g = -var10 * 2.0f + var9;
        this.Leg6.field_78796_g = var10 * 2.0f - var9;
        final float var11 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 0.0f) * 0.4f) * par2;
        final float var12 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * par2;
        final float var13 = -(MathHelper.func_76134_b(par1 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * par2;
        final float var14 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 0.0f) * 0.4f) * par2;
        final float var15 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 3.1415927f) * 0.4f) * par2;
        final float var16 = Math.abs(MathHelper.func_76126_a(par1 * 0.6662f + 4.712389f) * 0.4f) * par2;
        final ModelRenderer leg1 = this.Leg1;
        leg1.field_78796_g += var11;
        final ModelRenderer leg2 = this.Leg2;
        leg2.field_78796_g += -var11;
        final ModelRenderer leg3 = this.Leg3;
        leg3.field_78796_g += var12;
        final ModelRenderer leg4 = this.Leg4;
        leg4.field_78796_g += -var12;
        final ModelRenderer leg5 = this.Leg5;
        leg5.field_78796_g += var13;
        final ModelRenderer leg6 = this.Leg6;
        leg6.field_78796_g += -var13;
        final ModelRenderer leg7 = this.Leg1;
        leg7.field_78808_h += var14;
        final ModelRenderer leg8 = this.Leg2;
        leg8.field_78808_h += -var14;
        final ModelRenderer leg9 = this.Leg3;
        leg9.field_78808_h += var15;
        final ModelRenderer leg10 = this.Leg4;
        leg10.field_78808_h += -var15;
        final ModelRenderer leg11 = this.Leg5;
        leg11.field_78808_h += var16;
        final ModelRenderer leg12 = this.Leg6;
        leg12.field_78808_h += -var16;
    }
    
    public void func_78086_a(final EntityLiving par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFPinchBeetle beetle = (EntityTFPinchBeetle)par1EntityLiving;
        if (beetle.field_70153_n == null) {
            this.jaw1a.field_78796_g = 2.9670596f;
            this.jaw2a.field_78796_g = 0.34906584f;
        }
        else {
            this.jaw1a.field_78796_g = 2.3561945f;
            this.jaw2a.field_78796_g = 0.7853982f;
        }
    }
}
