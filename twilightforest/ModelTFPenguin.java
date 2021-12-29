// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import org.lwjgl.opengl.GL11;

public class ModelTFPenguin extends ho
{
    qp body;
    qp rightarm;
    qp leftarm;
    qp rightleg;
    qp leftleg;
    qp head;
    qp beak;
    
    public ModelTFPenguin() {
        this.l = 64;
        this.m = 32;
        (this.body = new qp((ho)this, 32, 0)).a(-4.0f, 0.0f, -4.0f, 8, 9, 8);
        this.body.a(0.0f, 14.0f, 0.0f);
        (this.rightarm = new qp((ho)this, 34, 18)).a(-1.0f, -1.0f, -2.0f, 1, 8, 4);
        this.rightarm.a(-4.0f, 15.0f, 0.0f);
        (this.leftarm = new qp((ho)this, 24, 18)).a(0.0f, -1.0f, -2.0f, 1, 8, 4);
        this.leftarm.a(4.0f, 15.0f, 0.0f);
        this.leftarm.i = true;
        (this.rightleg = new qp((ho)this, 0, 16)).a(-2.0f, 0.0f, -5.0f, 4, 1, 8);
        this.rightleg.a(-2.0f, 23.0f, 0.0f);
        this.rightleg.b(64, 32);
        (this.leftleg = new qp((ho)this, 0, 16)).a(-2.0f, 0.0f, -5.0f, 4, 1, 8);
        this.leftleg.a(2.0f, 23.0f, 0.0f);
        (this.head = new qp((ho)this, 0, 0)).a(-3.5f, -4.0f, -3.5f, 7, 5, 7);
        this.head.a(0.0f, 13.0f, 0.0f);
        (this.beak = new qp((ho)this, 0, 13)).a(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.beak.a(0.0f, -1.0f, -4.0f);
        this.head.a(this.beak);
    }
    
    public void a(final nn par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.a(par2, par3, par4, par5, par6, par7);
        if (this.k) {
            final float f = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 5.0f * par7, 0.75f * par7);
            this.head.a(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f, 1.0f / f, 1.0f / f);
            GL11.glTranslatef(0.0f, 24.0f * par7, 0.0f);
            this.body.a(par7);
            this.rightleg.a(par7);
            this.leftleg.a(par7);
            this.rightarm.a(par7);
            this.leftarm.a(par7);
            GL11.glPopMatrix();
        }
        else {
            this.head.a(par7);
            this.body.a(par7);
            this.rightleg.a(par7);
            this.leftleg.a(par7);
            this.rightarm.a(par7);
            this.leftarm.a(par7);
        }
    }
    
    private void setRotation(final qp model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.f = par5 / 57.295776f;
        this.head.g = par4 / 57.295776f;
        this.rightleg.f = gk.b(par1) * 0.7f * par2;
        this.leftleg.f = gk.b(par1 + 3.1415927f) * 0.7f * par2;
        this.rightarm.h = par3;
        this.leftarm.h = -par3;
    }
}
