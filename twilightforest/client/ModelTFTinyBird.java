// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class ModelTFTinyBird extends awt
{
    axx beak;
    axx head;
    axx body;
    axx rightarm;
    axx leftarm;
    axx rightleg;
    axx leftleg;
    axx tail;
    
    public ModelTFTinyBird() {
        this.t = 32;
        this.u = 32;
        (this.head = new axx((awt)this, 0, 0)).a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.head.a(0.0f, 20.5f, -0.5f);
        this.head.b(32, 32);
        this.head.i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak = new axx((awt)this, 12, 0)).a(-0.5f, -0.5f, -0.5f, 1, 1, 1);
        this.beak.a(0.0f, 0.5f, -2.0f);
        this.head.a(this.beak);
        (this.body = new axx((awt)this, 0, 6)).a(-1.5f, 0.0f, -1.0f, 3, 3, 3);
        this.body.a(0.0f, 20.0f, 0.0f);
        this.body.b(32, 32);
        this.body.i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new axx((awt)this, 12, 2)).a(-1.0f, 0.0f, -1.5f, 1, 2, 3);
        this.rightarm.a(-1.5f, 20.5f, 1.0f);
        this.rightarm.b(32, 32);
        this.rightarm.i = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new axx((awt)this, 12, 2)).a(0.0f, 0.0f, -1.5f, 1, 2, 3);
        this.leftarm.a(1.5f, 20.5f, 1.0f);
        this.leftarm.b(32, 32);
        this.leftarm.i = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new axx((awt)this, 0, 12)).a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.rightleg.a(-1.5f, 23.0f, 0.0f);
        this.rightleg.b(32, 32);
        this.rightleg.i = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new axx((awt)this, 0, 12)).a(0.5f, 0.0f, 0.0f, 1, 1, 1);
        this.leftleg.a(0.0f, 23.0f, 0.0f);
        this.leftleg.b(32, 32);
        this.leftleg.i = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.tail = new axx((awt)this, 0, 14)).a(-1.5f, -0.5f, 0.0f, 3, 1, 2);
        this.tail.a(0.0f, 22.0f, 2.0f);
        this.tail.b(32, 32);
        this.tail.i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }
    
    public void a(final lq par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7);
        if (this.s) {
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
            this.tail.a(par7);
        }
    }
    
    private void setRotation(final axx model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.f = par5 / 57.295776f;
        this.head.g = par4 / 57.295776f;
        this.rightleg.f = ke.b(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightarm.h = par3;
        this.leftarm.h = -par3;
    }
}
