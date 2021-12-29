// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFSquirrel;

public class ModelTFSquirrel extends bbx
{
    bdc body;
    bdc leg1;
    bdc leg2;
    bdc leg3;
    bdc leg4;
    bdc head;
    bdc tail;
    bdc fluff1;
    bdc fluff2;
    bdc fluff3;
    
    public ModelTFSquirrel() {
        this.t = 32;
        this.u = 32;
        this.a("head.head", 0, 0);
        this.a("head.ear2", 16, 0);
        this.a("head.ear1", 16, 0);
        this.a("tail.fluff1", 0, 20);
        this.a("tail.base", 0, 18);
        this.a("tail.fluff2", 0, 20);
        this.a("tail.fluff3", 0, 26);
        (this.body = new bdc((bbx)this, 0, 8)).a(-2.0f, -1.0f, -2.0f, 4, 3, 5);
        this.body.a(0.0f, 21.0f, 0.0f);
        this.body.b(32, 32);
        this.body.i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leg1 = new bdc((bbx)this, 0, 16)).a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg1.a(-2.0f, 23.0f, 2.0f);
        this.leg1.b(32, 32);
        this.leg1.i = true;
        this.setRotation(this.leg1, 0.0f, 0.0f, 0.0f);
        (this.leg2 = new bdc((bbx)this, 0, 16)).a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg2.a(1.0f, 23.0f, 2.0f);
        this.leg2.b(32, 32);
        this.leg2.i = true;
        this.setRotation(this.leg2, 0.0f, 0.0f, 0.0f);
        (this.leg3 = new bdc((bbx)this, 0, 16)).a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg3.a(-2.0f, 23.0f, -2.0f);
        this.leg3.b(32, 32);
        this.setRotation(this.leg3, 0.0f, 0.0f, 0.0f);
        (this.leg4 = new bdc((bbx)this, 0, 16)).a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.leg4.a(1.0f, 23.0f, -2.0f);
        this.leg4.b(32, 32);
        this.setRotation(this.leg4, 0.0f, 0.0f, 0.0f);
        (this.head = new bdc((bbx)this, "head")).a(0.0f, 22.0f, -2.0f);
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.head.a("head", -2.0f, -5.0f, -3.0f, 4, 4, 4);
        this.head.a("ear2", -2.0f, -6.0f, -0.5f, 1, 1, 1);
        this.head.a("ear1", 1.0f, -6.0f, -0.5f, 1, 1, 1);
        (this.tail = new bdc((bbx)this, "tail")).a(0.0f, 21.0f, 2.0f);
        this.tail.a("base", -0.5f, -1.5f, 0.5f, 1, 1, 1);
        (this.fluff1 = new bdc((bbx)this, 0, 20)).a(-1.5f, -4.0f, 1.0f, 3, 3, 3);
        this.tail.a(this.fluff1);
        (this.fluff2 = new bdc((bbx)this, 0, 20)).a(0.0f, -3.0f, -1.5f, 3, 3, 3);
        this.fluff2.a(-1.5f, -4.0f, 2.5f);
        this.fluff1.a(this.fluff2);
        (this.fluff3 = new bdc((bbx)this, 0, 26)).a(1.5f, -3.0f, -1.5f, 3, 3, 3);
        this.fluff3.a(-1.5f, -3.0f, 0.0f);
        this.fluff2.a(this.fluff3);
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.body.a(f5);
        this.leg1.a(f5);
        this.leg2.a(f5);
        this.leg3.a(f5);
        this.leg4.a(f5);
        this.head.a(f5);
        this.tail.a(f5);
    }
    
    private void setRotation(final bdc model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final ng par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFSquirrel squirrel = (EntityTFSquirrel)par1EntityLiving;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.f = par5 / 57.295776f;
        this.head.g = par4 / 57.295776f;
        this.leg1.f = kx.b(par1 * 0.6662f) * 1.4f * par2;
        this.leg2.f = kx.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg3.f = kx.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.leg4.f = kx.b(par1 * 0.6662f) * 1.4f * par2;
        if (par2 > 0.2) {
            final float wiggle = Math.min(par2, 0.6f);
            this.tail.f = (kx.b(par3 * 0.6662f) * 1.0f - 1.0471976f) * wiggle;
            this.fluff2.f = kx.b(par3 * 0.7774f) * 1.2f * wiggle;
            this.fluff3.f = kx.b(par3 * 0.8886f + 1.5707964f) * 1.4f * wiggle;
        }
        else {
            this.tail.f = 0.2f + kx.b(par3 * 0.3335f) * 0.15f;
            this.fluff2.f = 0.1f + kx.b(par3 * 0.4445f) * 0.2f;
            this.fluff3.f = 0.1f + kx.b(par3 * 0.5555f) * 0.25f;
        }
    }
}
