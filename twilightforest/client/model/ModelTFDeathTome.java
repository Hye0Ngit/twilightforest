// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import org.lwjgl.opengl.GL11;

public class ModelTFDeathTome extends baz
{
    bcr everything;
    bcr book;
    bcr loosePage1;
    bcr loosePage2;
    bcr loosePage3;
    bcr loosePage4;
    
    public ModelTFDeathTome() {
        this.everything = new bcr((bbl)this).a(0, 0).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        (this.book = new bcr((bbl)this).a(0, 0).a(0.0f, 0.0f, 0.0f, 0, 0, 0)).a(this.a);
        this.book.a(this.b);
        this.book.a(this.g);
        this.book.a(this.c);
        this.book.a(this.d);
        this.book.a(this.e);
        this.book.a(this.f);
        this.loosePage1 = new bcr((bbl)this).a(24, 10).a(0.0f, -4.0f, -8.0f, 5, 8, 0);
        this.loosePage2 = new bcr((bbl)this).a(24, 10).a(0.0f, -4.0f, 9.0f, 5, 8, 0);
        this.loosePage3 = new bcr((bbl)this).a(24, 10).a(0.0f, -4.0f, 11.0f, 5, 8, 0);
        this.loosePage4 = new bcr((bbl)this).a(24, 10).a(0.0f, -4.0f, 7.0f, 5, 8, 0);
        this.everything.a(this.book);
        this.everything.a(this.loosePage1);
        this.everything.a(this.loosePage2);
        this.everything.a(this.loosePage3);
        this.everything.a(this.loosePage4);
    }
    
    public void a(final nm par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float scale) {
        GL11.glEnable(2884);
        this.setRotationAngles((float)par1Entity.ac, 0.4f, 0.6f, 0.9f, par6, 0.0625f);
        this.everything.a(scale);
        GL11.glDisable(2884);
    }
    
    public void setRotationAngles(final float bounce, final float flipRight, final float flipLeft, final float open, final float rotate, final float scale) {
        this.book.h = -0.87266463f;
        this.everything.g = rotate / 57.295776f + 1.5707964f;
    }
    
    public void a(final oe par1EntityLiving, final float par2, final float par3, final float partialTick) {
        final float bounce = par1EntityLiving.ac + partialTick;
        final float open = 0.9f;
        final float flipRight = 0.4f;
        final float flipLeft = 0.6f;
        this.book.a(0.0f, 4.0f + lr.a(bounce * 0.3f) * 2.0f, 0.0f);
        final float openAngle = (lr.a(bounce * 0.4f) * 0.3f + 1.25f) * open;
        this.a.g = 3.1415927f + openAngle;
        this.b.g = -openAngle;
        this.c.g = openAngle;
        this.d.g = -openAngle;
        this.e.g = openAngle - openAngle * 2.0f * flipRight;
        this.f.g = openAngle - openAngle * 2.0f * flipLeft;
        this.c.c = lr.a(openAngle);
        this.d.c = lr.a(openAngle);
        this.e.c = lr.a(openAngle);
        this.f.c = lr.a(openAngle);
        this.loosePage1.g = bounce / 4.0f;
        this.loosePage1.f = lr.a(bounce / 5.0f) / 3.0f;
        this.loosePage1.h = lr.b(bounce / 5.0f) / 5.0f;
        this.loosePage2.g = bounce / 3.0f;
        this.loosePage2.f = lr.a(bounce / 5.0f) / 3.0f;
        this.loosePage2.h = lr.b(bounce / 5.0f) / 4.0f + 2.0f;
        this.loosePage3.g = bounce / 4.0f;
        this.loosePage3.f = -lr.a(bounce / 5.0f) / 3.0f;
        this.loosePage3.h = lr.b(bounce / 5.0f) / 5.0f - 1.0f;
        this.loosePage4.g = bounce / 4.0f;
        this.loosePage4.f = -lr.a(bounce / 2.0f) / 4.0f;
        this.loosePage4.h = lr.b(bounce / 7.0f) / 5.0f;
    }
}
