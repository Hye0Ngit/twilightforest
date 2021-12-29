// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFRaven extends axa
{
    ayf head;
    ayf beak1;
    ayf beak2;
    ayf body;
    ayf rightarm;
    ayf leftarm;
    ayf rightleg;
    ayf leftleg;
    ayf rightfoot;
    ayf leftfoot;
    ayf tail;
    
    public ModelTFRaven() {
        this.t = 32;
        this.u = 32;
        (this.head = new ayf((axa)this, 0, 0)).a(-1.5f, -1.5f, -3.0f, 3, 3, 3);
        this.head.a(0.0f, 18.0f, 0.0f);
        this.head.b(32, 32);
        this.head.i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak1 = new ayf((axa)this, 12, 0)).a(-0.5f, -1.0f, -2.0f, 1, 1, 2);
        this.beak1.a(0.0f, 0.0f, -2.5f);
        this.beak1.f = 0.2617994f;
        this.head.a(this.beak1);
        (this.beak2 = new ayf((axa)this, 12, 0)).a(-0.5f, 0.0f, -2.0f, 1, 1, 2);
        this.beak2.a(0.0f, 0.0f, -2.5f);
        this.beak2.f = -0.2617994f;
        this.head.a(this.beak2);
        (this.body = new ayf((axa)this, 0, 6)).a(-1.5f, 0.0f, -1.0f, 3, 4, 6);
        this.body.a(0.0f, 17.0f, 1.0f);
        this.body.b(32, 32);
        this.setRotation(this.body, -0.5235988f, 0.0f, 0.0f);
        (this.rightarm = new ayf((axa)this, 0, 16)).a(-1.0f, 0.0f, -1.5f, 1, 3, 6);
        this.rightarm.a(-1.5f, 18.0f, 1.0f);
        this.rightarm.b(32, 32);
        (this.leftarm = new ayf((axa)this, 0, 16)).a(0.0f, 0.0f, -1.5f, 1, 3, 6);
        this.leftarm.a(1.5f, 18.0f, 1.0f);
        this.leftarm.b(32, 32);
        (this.rightleg = new ayf((axa)this, 14, 16)).a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.rightleg.a(-1.5f, 21.0f, 1.0f);
        this.rightleg.b(32, 32);
        (this.rightfoot = new ayf((axa)this, 14, 20)).a(0.0f, -1.0f, -2.0f, 1, 1, 2);
        this.rightfoot.a(0.0f, 2.0f, 1.0f);
        this.rightfoot.b(32, 32);
        this.setRotation(this.rightfoot, 0.5235988f, 0.0f, 0.0f);
        this.rightleg.a(this.rightfoot);
        (this.leftleg = new ayf((axa)this, 14, 16)).a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.leftleg.a(0.5f, 21.0f, 1.0f);
        this.leftleg.b(32, 32);
        (this.leftfoot = new ayf((axa)this, 14, 20)).a(0.0f, -1.0f, -2.0f, 1, 1, 2);
        this.leftfoot.a(0.0f, 2.0f, 1.0f);
        this.leftfoot.b(32, 32);
        this.setRotation(this.leftfoot, 0.5235988f, 0.0f, 0.0f);
        this.leftleg.a(this.leftfoot);
        (this.tail = new ayf((axa)this, 0, 25)).a(-1.5f, -0.5f, 0.0f, 3, 1, 3);
        this.tail.a(0.0f, 21.0f, 4.0f);
        this.tail.b(32, 32);
        this.setRotation(this.tail, -0.5235988f, 0.0f, 0.0f);
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.head.a(f5);
        this.body.a(f5);
        this.rightarm.a(f5);
        this.leftarm.a(f5);
        this.rightleg.a(f5);
        this.leftleg.a(f5);
        this.tail.a(f5);
    }
    
    private void setRotation(final ayf model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.f = par5 / 57.295776f;
        this.head.g = par4 / 57.295776f;
        this.head.h = ((par4 > 5.0f) ? -0.2617994f : 0.0f);
        this.rightleg.f = ke.b(par1 * 0.6662f) * 1.4f * par2;
        this.leftleg.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.rightarm.h = par3;
        this.leftarm.h = -par3;
    }
}
