// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFSlimeBeetle extends awt
{
    axx head;
    axx RearEnd;
    axx Leg6;
    axx Leg4;
    axx Leg2;
    axx Leg5;
    axx Leg3;
    axx Leg1;
    axx connector1;
    axx antenna1;
    axx antenna2;
    axx eye1;
    axx eye2;
    axx slimeCube;
    axx tail1;
    axx tail2;
    axx mouth;
    axx slimeCenter;
    boolean renderPassModel;
    
    public ModelTFSlimeBeetle() {
        this(false);
    }
    
    public ModelTFSlimeBeetle(final boolean renderpass) {
        this.renderPassModel = false;
        this.renderPassModel = renderpass;
        this.t = 64;
        this.u = 64;
        (this.connector1 = new axx((awt)this, 0, 12)).a(-3.0f, -3.0f, -1.0f, 6, 6, 1);
        this.connector1.a(0.0f, 19.0f, -4.0f);
        (this.RearEnd = new axx((awt)this, 31, 6)).a(-4.0f, -11.0f, -4.0f, 8, 10, 8);
        this.RearEnd.a(0.0f, 18.0f, 7.0f);
        this.setRotation(this.RearEnd, 1.570796f, 0.0f, 0.0f);
        (this.Leg6 = new axx((awt)this, 40, 0)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg6.a(2.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.3490659f);
        this.Leg5 = new axx((awt)this, 40, 0);
        this.Leg5.i = true;
        this.Leg5.a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg5.a(-2.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.3490659f);
        (this.Leg4 = new axx((awt)this, 40, 0)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg4.a(2.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.3490659f);
        (this.Leg2 = new axx((awt)this, 40, 0)).a(-1.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg2.a(2.0f, 21.0f, 4.0f);
        this.setRotation(this.Leg2, 0.0f, -0.6981317f, 0.3490659f);
        this.Leg3 = new axx((awt)this, 40, 0);
        this.Leg3.i = true;
        this.Leg3.a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg3.a(-2.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.3490659f);
        this.Leg1 = new axx((awt)this, 40, 0);
        this.Leg1.i = true;
        this.Leg1.a(-9.0f, -1.0f, -1.0f, 10, 2, 2);
        this.Leg1.a(-2.0f, 21.0f, 4.0f);
        this.Leg1.b(64, 32);
        this.setRotation(this.Leg1, 0.0f, 0.6981317f, -0.3490659f);
        (this.head = new axx((awt)this, 0, 0)).a(-4.0f, -4.0f, -6.0f, 8, 6, 6);
        this.head.a(0.0f, 19.0f, -5.0f);
        (this.antenna1 = new axx((awt)this, 38, 4)).a(0.0f, -0.5f, -0.5f, 12, 1, 1);
        this.antenna1.a(1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna1, 0.0f, 1.047198f, -0.296706f);
        (this.antenna2 = new axx((awt)this, 38, 4)).a(0.0f, -0.5f, -0.5f, 12, 1, 1);
        this.antenna2.a(-1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna2, 0.0f, 2.094395f, 0.296706f);
        (this.eye1 = new axx((awt)this, 15, 12)).a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.eye1.a(-3.0f, -2.0f, -5.0f);
        (this.eye2 = new axx((awt)this, 15, 12)).a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.eye2.a(3.0f, -2.0f, -5.0f);
        (this.mouth = new axx((awt)this, 17, 12)).a(-1.0f, -1.0f, -1.0f, 2, 2, 1);
        this.mouth.a(0.0f, 1.0f, -6.0f);
        this.head.a(this.antenna1);
        this.head.a(this.antenna2);
        this.head.a(this.eye1);
        this.head.a(this.eye2);
        this.head.a(this.mouth);
        (this.tail1 = new axx((awt)this, 0, 20)).a(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        this.tail1.a(0.0f, 19.0f, 9.0f);
        (this.tail2 = new axx((awt)this, 0, 20)).a(-3.0f, -6.0f, -3.0f, 6, 6, 6);
        this.tail2.a(0.0f, -3.0f, 2.0f);
        (this.slimeCube = new axx((awt)this, 0, 40)).a(-6.0f, -12.0f, -9.0f, 12, 12, 12);
        this.slimeCube.a(0.0f, -6.0f, 0.0f);
        (this.slimeCenter = new axx((awt)this, 32, 24)).a(-4.0f, -10.0f, -7.0f, 8, 8, 8);
        this.slimeCenter.a(0.0f, -6.0f, 0.0f);
        this.tail1.a(this.tail2);
        if (this.renderPassModel) {
            this.tail2.a(this.slimeCube);
        }
        else {
            this.tail2.a(this.slimeCenter);
        }
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.tail1.a(f5);
        if (!this.renderPassModel) {
            this.head.a(f5);
            this.RearEnd.a(f5);
            this.Leg6.a(f5);
            this.Leg4.a(f5);
            this.Leg2.a(f5);
            this.Leg5.a(f5);
            this.Leg3.a(f5);
            this.Leg1.a(f5);
            this.connector1.a(f5);
        }
    }
    
    private void setRotation(final axx model, final float x, final float y, final float z) {
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
        final axx leg1 = this.Leg1;
        leg1.g += var11;
        final axx leg2 = this.Leg2;
        leg2.g += -var11;
        final axx leg3 = this.Leg3;
        leg3.g += var12;
        final axx leg4 = this.Leg4;
        leg4.g += -var12;
        final axx leg5 = this.Leg5;
        leg5.g += var13;
        final axx leg6 = this.Leg6;
        leg6.g += -var13;
        final axx leg7 = this.Leg1;
        leg7.h += var14;
        final axx leg8 = this.Leg2;
        leg8.h += -var14;
        final axx leg9 = this.Leg3;
        leg9.h += var15;
        final axx leg10 = this.Leg4;
        leg10.h += -var15;
        final axx leg11 = this.Leg5;
        leg11.h += var16;
        final axx leg12 = this.Leg6;
        leg12.h += -var16;
        this.tail1.f = ke.b(par3 * 0.3335f) * 0.15f;
        this.tail2.f = ke.b(par3 * 0.4445f) * 0.2f;
        this.slimeCube.f = ke.b(par3 * 0.5555f) * 0.25f;
        this.slimeCenter.f = ke.b(par3 * 0.5555f + 0.25f) * 0.25f;
    }
}
