// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.passive.EntityTFBird;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFRaven extends ModelBase
{
    ModelRenderer head;
    ModelRenderer beak1;
    ModelRenderer beak2;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;
    ModelRenderer tail;
    
    public ModelTFRaven() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.head.func_78793_a(0.0f, 18.0f, 0.0f);
        this.head.func_78787_b(32, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak1 = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-0.5f, -1.0f, -2.0f, 1, 1, 2);
        this.beak1.func_78793_a(0.0f, 0.0f, -2.5f);
        this.beak1.field_78795_f = 0.2617994f;
        this.head.func_78792_a(this.beak1);
        (this.beak2 = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-0.5f, 0.0f, -2.0f, 1, 1, 2);
        this.beak2.func_78793_a(0.0f, 0.0f, -2.5f);
        this.beak2.field_78795_f = -0.2617994f;
        this.head.func_78792_a(this.beak2);
        (this.body = new ModelRenderer((ModelBase)this, 0, 6)).func_78789_a(-1.5f, 0.0f, -1.0f, 3, 4, 6);
        this.body.func_78793_a(0.0f, 17.0f, 1.0f);
        this.body.func_78787_b(32, 32);
        this.setRotation(this.body, -0.5235988f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -1.5f, 1, 3, 6);
        this.rightarm.func_78793_a(-1.5f, 18.0f, 1.0f);
        this.rightarm.func_78787_b(32, 32);
        (this.leftarm = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(0.0f, 0.0f, -1.5f, 1, 3, 6);
        this.leftarm.func_78793_a(1.5f, 18.0f, 1.0f);
        this.leftarm.func_78787_b(32, 32);
        (this.rightleg = new ModelRenderer((ModelBase)this, 14, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.rightleg.func_78793_a(-1.5f, 21.0f, 1.0f);
        this.rightleg.func_78787_b(32, 32);
        (this.rightfoot = new ModelRenderer((ModelBase)this, 14, 20)).func_78789_a(0.0f, -1.0f, -2.0f, 1, 1, 2);
        this.rightfoot.func_78793_a(0.0f, 2.0f, 1.0f);
        this.rightfoot.func_78787_b(32, 32);
        this.setRotation(this.rightfoot, 0.5235988f, 0.0f, 0.0f);
        this.rightleg.func_78792_a(this.rightfoot);
        (this.leftleg = new ModelRenderer((ModelBase)this, 14, 16)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.leftleg.func_78793_a(0.5f, 21.0f, 1.0f);
        this.leftleg.func_78787_b(32, 32);
        (this.leftfoot = new ModelRenderer((ModelBase)this, 14, 20)).func_78789_a(0.0f, -1.0f, -2.0f, 1, 1, 2);
        this.leftfoot.func_78793_a(0.0f, 2.0f, 1.0f);
        this.leftfoot.func_78787_b(32, 32);
        this.setRotation(this.leftfoot, 0.5235988f, 0.0f, 0.0f);
        this.leftleg.func_78792_a(this.leftfoot);
        (this.tail = new ModelRenderer((ModelBase)this, 0, 25)).func_78789_a(-1.5f, -0.5f, 0.0f, 3, 1, 3);
        this.tail.func_78793_a(0.0f, 21.0f, 4.0f);
        this.tail.func_78787_b(32, 32);
        this.setRotation(this.tail, -0.5235988f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.rightarm.func_78785_a(f5);
        this.leftarm.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
        this.tail.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.head.field_78795_f = par5 / 57.295776f;
        this.head.field_78796_g = par4 / 57.295776f;
        this.head.field_78808_h = ((par4 > 5.0f) ? -0.2617994f : 0.0f);
        this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightarm.field_78808_h = par3;
        this.leftarm.field_78808_h = -par3;
        if (((EntityTFBird)par7Entity).isBirdLanded()) {
            this.rightleg.field_78797_d = 21.0f;
            this.leftleg.field_78797_d = 21.0f;
        }
        else {
            this.rightleg.field_78797_d = 20.0f;
            this.leftleg.field_78797_d = 20.0f;
        }
    }
}
