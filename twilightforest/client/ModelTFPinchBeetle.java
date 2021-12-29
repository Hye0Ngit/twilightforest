// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.entity.EntityTFPinchBeetle;

public class ModelTFPinchBeetle extends axa
{
    ayf thorax;
    ayf head;
    ayf connector2;
    ayf RearEnd;
    ayf Leg6;
    ayf Leg4;
    ayf Leg2;
    ayf Leg5;
    ayf Leg3;
    ayf Leg1;
    ayf connector1;
    ayf jaw1a;
    ayf jaw1b;
    ayf jaw2a;
    ayf jaw2b;
    ayf antenna1;
    ayf antenna2;
    ayf eye1;
    ayf eye2;
    ayf tooth1a;
    ayf tooth1b;
    ayf tooth1c;
    ayf tooth2a;
    ayf tooth2b;
    ayf tooth2c;
    
    public ModelTFPinchBeetle() {
        this.t = 64;
        this.u = 32;
        (this.thorax = new ayf((axa)this, 0, 22)).a(-4.5f, -4.0f, 0.0f, 9, 8, 2);
        this.thorax.a(0.0f, 18.0f, -4.5f);
        (this.connector1 = new ayf((axa)this, 0, 12)).a(-3.0f, -3.0f, 0.0f, 6, 6, 1);
        this.connector1.a(0.0f, 18.0f, -3.0f);
        (this.connector2 = new ayf((axa)this, 0, 12)).a(-3.0f, -3.0f, -1.0f, 6, 6, 1);
        this.connector2.a(0.0f, 18.0f, -4.0f);
        (this.RearEnd = new ayf((axa)this, 28, 14)).a(-5.0f, -9.0f, -4.0f, 10, 10, 8);
        this.RearEnd.a(0.0f, 18.0f, 7.0f);
        this.setRotation(this.RearEnd, 1.570796f, 0.0f, 0.0f);
        (this.Leg6 = new ayf((axa)this, 40, 0)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg6.a(4.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.3490659f);
        this.Leg5 = new ayf((axa)this, 40, 0);
        this.Leg5.i = true;
        this.Leg5.a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg5.a(-4.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.3490659f);
        (this.Leg4 = new ayf((axa)this, 40, 0)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg4.a(4.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.3490659f);
        (this.Leg2 = new ayf((axa)this, 40, 0)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg2.a(4.0f, 21.0f, 4.0f);
        this.setRotation(this.Leg2, 0.0f, -0.6981317f, 0.3490659f);
        this.Leg3 = new ayf((axa)this, 40, 0);
        this.Leg3.i = true;
        this.Leg3.a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg3.a(-4.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.3490659f);
        this.Leg1 = new ayf((axa)this, 40, 0);
        this.Leg1.i = true;
        this.Leg1.a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg1.a(-4.0f, 21.0f, 4.0f);
        this.Leg1.b(64, 32);
        this.setRotation(this.Leg1, 0.0f, 0.6981317f, -0.3490659f);
        (this.head = new ayf((axa)this, 0, 0)).a(-4.0f, -4.0f, -6.0f, 8, 6, 6);
        this.head.a(0.0f, 19.0f, -5.0f);
        (this.jaw1a = new ayf((axa)this, 40, 6)).a(-1.0f, -1.0f, -1.5f, 8, 2, 3);
        this.jaw1a.a(-3.0f, 1.0f, -6.0f);
        this.setRotation(this.jaw1a, 0.0f, 2.635447f, 0.0f);
        (this.jaw1b = new ayf((axa)this, 40, 10)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.jaw1b.a(7.0f, 0.0f, 0.0f);
        this.setRotation(this.jaw1b, 0.0f, -1.047197f, 0.0f);
        (this.jaw2a = new ayf((axa)this, 40, 6)).a(-1.0f, -1.0f, -1.5f, 8, 2, 3);
        this.jaw2a.a(3.0f, 1.0f, -6.0f);
        this.setRotation(this.jaw2a, 0.0f, 0.541052f, 0.0f);
        (this.jaw2b = new ayf((axa)this, 40, 10)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.jaw2b.a(7.0f, 0.0f, 0.0f);
        this.setRotation(this.jaw2b, 0.0f, 1.047197f, 0.0f);
        (this.antenna1 = new ayf((axa)this, 42, 4)).a(0.0f, -0.5f, -0.5f, 10, 1, 1);
        this.antenna1.a(1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna1, 0.0f, 1.047198f, -0.296706f);
        (this.antenna2 = new ayf((axa)this, 42, 4)).a(0.0f, -0.5f, -0.5f, 10, 1, 1);
        this.antenna2.a(-1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna2, 0.0f, 2.094395f, 0.296706f);
        (this.eye1 = new ayf((axa)this, 15, 12)).a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.eye1.a(-3.0f, -2.0f, -5.0f);
        (this.eye2 = new ayf((axa)this, 15, 12)).a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.eye2.a(3.0f, -2.0f, -5.0f);
        (this.tooth1a = new ayf((axa)this, 0, 0)).a(0.0f, -0.5f, -0.0f, 2, 1, 1);
        this.tooth1a.a(9.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth1a, 0.0f, -0.5235987f, 0.0f);
        (this.tooth1b = new ayf((axa)this, 0, 0)).a(-2.5f, -0.5f, -0.0f, 2, 1, 1);
        this.tooth1b.a(6.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth1b, 0.0f, 1.5707963f, 0.0f);
        (this.tooth1c = new ayf((axa)this, 0, 0)).a(-2.5f, -0.5f, -0.0f, 2, 1, 1);
        this.tooth1c.a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth1c, 0.0f, 1.5707963f, 0.0f);
        (this.tooth2a = new ayf((axa)this, 0, 0)).a(0.0f, -0.5f, -1.0f, 2, 1, 1);
        this.tooth2a.a(9.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth2a, 0.0f, 0.5235987f, 0.0f);
        (this.tooth2b = new ayf((axa)this, 0, 0)).a(-2.5f, -0.5f, -1.0f, 2, 1, 1);
        this.tooth2b.a(6.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth2b, 0.0f, -1.5707963f, 0.0f);
        (this.tooth2c = new ayf((axa)this, 0, 0)).a(-2.5f, -0.5f, -1.0f, 2, 1, 1);
        this.tooth2c.a(3.0f, 0.0f, 0.0f);
        this.setRotation(this.tooth2c, 0.0f, -1.5707963f, 0.0f);
        this.head.a(this.jaw1a);
        this.jaw1a.a(this.jaw1b);
        this.jaw1b.a(this.tooth1a);
        this.jaw1b.a(this.tooth1b);
        this.jaw1b.a(this.tooth1c);
        this.jaw2b.a(this.tooth2a);
        this.jaw2b.a(this.tooth2b);
        this.jaw2b.a(this.tooth2c);
        this.head.a(this.jaw2a);
        this.jaw2a.a(this.jaw2b);
        this.head.a(this.antenna1);
        this.head.a(this.antenna2);
        this.head.a(this.eye1);
        this.head.a(this.eye2);
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.thorax.a(f5);
        this.head.a(f5);
        this.connector2.a(f5);
        this.RearEnd.a(f5);
        this.Leg6.a(f5);
        this.Leg4.a(f5);
        this.Leg2.a(f5);
        this.Leg5.a(f5);
        this.Leg3.a(f5);
        this.Leg1.a(f5);
        this.connector1.a(f5);
    }
    
    private void setRotation(final ayf model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final lq par7Entity) {
        this.head.g = par4 / 57.295776f;
        this.head.f = par5 / 57.295776f;
        final float legZ = 0.28559935f;
        this.Leg1.h = -legZ;
        this.Leg2.h = legZ;
        this.Leg3.h = -legZ * 0.74f;
        this.Leg4.h = legZ * 0.74f;
        this.Leg5.h = -legZ;
        this.Leg6.h = legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.Leg1.g = var10 * 2.0f + var9;
        this.Leg2.g = -var10 * 2.0f - var9;
        this.Leg3.g = var10 * 1.0f + var9;
        this.Leg4.g = -var10 * 1.0f - var9;
        this.Leg5.g = -var10 * 2.0f + var9;
        this.Leg6.g = var10 * 2.0f - var9;
        final float var11 = -(ke.b(par1 * 0.6662f * 2.0f + 0.0f) * 0.4f) * par2;
        final float var12 = -(ke.b(par1 * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * par2;
        final float var13 = -(ke.b(par1 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * par2;
        final float var14 = Math.abs(ke.a(par1 * 0.6662f + 0.0f) * 0.4f) * par2;
        final float var15 = Math.abs(ke.a(par1 * 0.6662f + 3.1415927f) * 0.4f) * par2;
        final float var16 = Math.abs(ke.a(par1 * 0.6662f + 4.712389f) * 0.4f) * par2;
        final ayf leg1 = this.Leg1;
        leg1.g += var11;
        final ayf leg2 = this.Leg2;
        leg2.g += -var11;
        final ayf leg3 = this.Leg3;
        leg3.g += var12;
        final ayf leg4 = this.Leg4;
        leg4.g += -var12;
        final ayf leg5 = this.Leg5;
        leg5.g += var13;
        final ayf leg6 = this.Leg6;
        leg6.g += -var13;
        final ayf leg7 = this.Leg1;
        leg7.h += var14;
        final ayf leg8 = this.Leg2;
        leg8.h += -var14;
        final ayf leg9 = this.Leg3;
        leg9.h += var15;
        final ayf leg10 = this.Leg4;
        leg10.h += -var15;
        final ayf leg11 = this.Leg5;
        leg11.h += var16;
        final ayf leg12 = this.Leg6;
        leg12.h += -var16;
    }
    
    public void a(final md par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFPinchBeetle beetle = (EntityTFPinchBeetle)par1EntityLiving;
        if (beetle.n == null) {
            this.jaw1a.g = 2.9670596f;
            this.jaw2a.g = 0.34906584f;
        }
        else {
            this.jaw1a.g = 2.3561945f;
            this.jaw2a.g = 0.7853982f;
        }
    }
}
