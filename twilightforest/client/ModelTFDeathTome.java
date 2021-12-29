// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class ModelTFDeathTome extends awp
{
    ayf everything;
    ayf book;
    ayf loosePage1;
    ayf loosePage2;
    ayf loosePage3;
    ayf loosePage4;
    
    public ModelTFDeathTome() {
        this.everything = new ayf((axa)this).a(0, 0).a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        (this.book = new ayf((axa)this).a(0, 0).a(0.0f, 0.0f, 0.0f, 0, 0, 0)).a(this.a);
        this.book.a(this.b);
        this.book.a(this.g);
        this.book.a(this.c);
        this.book.a(this.d);
        this.book.a(this.e);
        this.book.a(this.f);
        this.loosePage1 = new ayf((axa)this).a(24, 10).a(0.0f, -4.0f, -8.0f, 5, 8, 0);
        this.loosePage2 = new ayf((axa)this).a(24, 10).a(0.0f, -4.0f, 9.0f, 5, 8, 0);
        this.loosePage3 = new ayf((axa)this).a(24, 10).a(0.0f, -4.0f, 11.0f, 5, 8, 0);
        this.loosePage4 = new ayf((axa)this).a(24, 10).a(0.0f, -4.0f, 7.0f, 5, 8, 0);
        this.everything.a(this.book);
        this.everything.a(this.loosePage1);
        this.everything.a(this.loosePage2);
        this.everything.a(this.loosePage3);
        this.everything.a(this.loosePage4);
    }
    
    public void a(final lq par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float scale) {
        GL11.glEnable(2884);
        this.setRotationAngles((float)par1Entity.ab, 0.4f, 0.6f, 0.9f, par6, 0.0625f);
        this.everything.a(scale);
        GL11.glDisable(2884);
    }
    
    public void setRotationAngles(final float bounce, final float flipRight, final float flipLeft, final float open, final float rotate, final float scale) {
        this.book.h = -0.87266463f;
        this.everything.g = rotate / 57.295776f + 1.5707964f;
    }
    
    public void a(final md par1EntityLiving, final float par2, final float par3, final float partialTick) {
        final float bounce = par1EntityLiving.ab + partialTick;
        final float open = 0.9f;
        final float flipRight = 0.4f;
        final float flipLeft = 0.6f;
        this.book.a(0.0f, 4.0f + ke.a(bounce * 0.3f) * 2.0f, 0.0f);
        final float openAngle = (ke.a(bounce * 0.4f) * 0.3f + 1.25f) * open;
        this.a.g = 3.1415927f + openAngle;
        this.b.g = -openAngle;
        this.c.g = openAngle;
        this.d.g = -openAngle;
        this.e.g = openAngle - openAngle * 2.0f * flipRight;
        this.f.g = openAngle - openAngle * 2.0f * flipLeft;
        this.c.c = ke.a(openAngle);
        this.d.c = ke.a(openAngle);
        this.e.c = ke.a(openAngle);
        this.f.c = ke.a(openAngle);
        this.loosePage1.g = bounce / 4.0f;
        this.loosePage1.f = ke.a(bounce / 5.0f) / 3.0f;
        this.loosePage1.h = ke.b(bounce / 5.0f) / 5.0f;
        this.loosePage2.g = bounce / 3.0f;
        this.loosePage2.f = ke.a(bounce / 5.0f) / 3.0f;
        this.loosePage2.h = ke.b(bounce / 5.0f) / 4.0f + 2.0f;
        this.loosePage3.g = bounce / 4.0f;
        this.loosePage3.f = -ke.a(bounce / 5.0f) / 3.0f;
        this.loosePage3.h = ke.b(bounce / 5.0f) / 5.0f - 1.0f;
        this.loosePage4.g = bounce / 4.0f;
        this.loosePage4.f = -ke.a(bounce / 2.0f) / 4.0f;
        this.loosePage4.h = ke.b(bounce / 7.0f) / 5.0f;
    }
}
