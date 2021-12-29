// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.passive.EntityTFBird;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFTinyBird extends ModelBase
{
    ModelRenderer beak;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer tail;
    
    public ModelTFTinyBird() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.head.func_78793_a(0.0f, 20.5f, -0.5f);
        this.head.func_78787_b(32, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-0.5f, -0.5f, -0.5f, 1, 1, 1);
        this.beak.func_78793_a(0.0f, 0.5f, -2.0f);
        this.head.func_78792_a(this.beak);
        (this.body = new ModelRenderer((ModelBase)this, 0, 6)).func_78789_a(-1.5f, 0.0f, -1.0f, 3, 3, 3);
        this.body.func_78793_a(0.0f, 20.0f, 0.0f);
        this.body.func_78787_b(32, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 12, 2)).func_78789_a(-1.0f, 0.0f, -1.5f, 1, 2, 3);
        this.rightarm.func_78793_a(-1.5f, 20.5f, 1.0f);
        this.rightarm.func_78787_b(32, 32);
        this.rightarm.field_78809_i = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 12, 2)).func_78789_a(0.0f, 0.0f, -1.5f, 1, 2, 3);
        this.leftarm.func_78793_a(1.5f, 20.5f, 1.0f);
        this.leftarm.func_78787_b(32, 32);
        this.leftarm.field_78809_i = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.rightleg.func_78793_a(-1.5f, 23.0f, 0.0f);
        this.rightleg.func_78787_b(32, 32);
        this.rightleg.field_78809_i = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(0.5f, 0.0f, 0.0f, 1, 1, 1);
        this.leftleg.func_78793_a(0.0f, 23.0f, 0.0f);
        this.leftleg.func_78787_b(32, 32);
        this.leftleg.field_78809_i = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase)this, 0, 14)).func_78789_a(-1.5f, -0.5f, 0.0f, 3, 1, 2);
        this.tail.func_78793_a(0.0f, 22.0f, 2.0f);
        this.tail.func_78787_b(32, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.field_78091_s) {
            final float f = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 5.0f * par7, 0.75f * par7);
            this.head.func_78785_a(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f, 1.0f / f, 1.0f / f);
            GL11.glTranslatef(0.0f, 24.0f * par7, 0.0f);
            this.body.func_78785_a(par7);
            this.rightleg.func_78785_a(par7);
            this.leftleg.func_78785_a(par7);
            this.rightarm.func_78785_a(par7);
            this.leftarm.func_78785_a(par7);
            GL11.glPopMatrix();
        }
        else {
            this.head.func_78785_a(par7);
            this.body.func_78785_a(par7);
            this.rightleg.func_78785_a(par7);
            this.leftleg.func_78785_a(par7);
            this.rightarm.func_78785_a(par7);
            this.leftarm.func_78785_a(par7);
            this.tail.func_78785_a(par7);
        }
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.head.field_78795_f = par5 / 57.295776f;
        this.head.field_78796_g = par4 / 57.295776f;
        this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightarm.field_78808_h = par3;
        this.leftarm.field_78808_h = -par3;
        if (((EntityTFBird)par7Entity).isBirdLanded()) {
            this.rightleg.field_78797_d = 23.0f;
            this.leftleg.field_78797_d = 23.0f;
        }
        else {
            this.rightleg.field_78797_d = 22.5f;
            this.leftleg.field_78797_d = 22.5f;
        }
    }
}
