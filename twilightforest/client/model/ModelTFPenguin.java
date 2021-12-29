// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFPenguin extends ModelBase
{
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head;
    ModelRenderer beak;
    
    public ModelTFPenguin() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 9, 8);
        this.body.func_78793_a(0.0f, 14.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 34, 18)).func_78789_a(-1.0f, -1.0f, -2.0f, 1, 8, 4);
        this.rightarm.func_78793_a(-4.0f, 15.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 24, 18)).func_78789_a(0.0f, -1.0f, -2.0f, 1, 8, 4);
        this.leftarm.func_78793_a(4.0f, 15.0f, 0.0f);
        this.leftarm.field_78809_i = true;
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-2.0f, 0.0f, -5.0f, 4, 1, 8);
        this.rightleg.func_78793_a(-2.0f, 23.0f, 0.0f);
        this.rightleg.func_78787_b(64, 32);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-2.0f, 0.0f, -5.0f, 4, 1, 8);
        this.leftleg.func_78793_a(2.0f, 23.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-3.5f, -4.0f, -3.5f, 7, 5, 7);
        this.head.func_78793_a(0.0f, 13.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase)this, 0, 13)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.beak.func_78793_a(0.0f, -1.0f, -4.0f);
        this.head.func_78792_a(this.beak);
    }
    
    public void func_78088_a(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7);
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
        }
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.field_78795_f = par5 / 57.295776f;
        this.head.field_78796_g = par4 / 57.295776f;
        this.rightleg.field_78795_f = MathHelper.func_76134_b(par1) * 0.7f * par2;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 + 3.1415927f) * 0.7f * par2;
        this.rightarm.field_78808_h = par3;
        this.leftarm.field_78808_h = -par3;
    }
}
