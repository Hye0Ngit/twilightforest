// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFHydraPart;
import twilightforest.entity.EntityTFHydra;

public class ModelTFHydra extends bbx
{
    bdc body;
    bdc leg1;
    bdc leg2;
    bdc tail1;
    bdc tail2;
    bdc tail3;
    bdc tail4;
    bdc neck1a;
    bdc neck1b;
    bdc neck1c;
    bdc neck1d;
    bdc head1;
    bdc jaw1;
    bdc frill1;
    bdc neck2a;
    bdc neck2b;
    bdc neck2c;
    bdc neck2d;
    bdc head2;
    bdc jaw2;
    bdc frill2;
    bdc neck3a;
    bdc neck3b;
    bdc neck3c;
    bdc neck3d;
    bdc head3;
    bdc jaw3;
    bdc frill3;
    
    public ModelTFHydra() {
        this.t = 512;
        this.u = 256;
        this.a("body.body", 0, 0);
        this.a("leg.main", 0, 136);
        this.a("leg.toe", 184, 200);
        this.a("tail.box", 128, 136);
        this.a("tail.fin", 128, 200);
        this.a("neck.box", 128, 136);
        this.a("neck.fin", 128, 200);
        this.a("head.box", 272, 0);
        this.a("head.upperlip", 272, 56);
        this.a("head.fin", 128, 200);
        this.a("jaw.jaw", 272, 92);
        this.a("frill.frill", 272, 200);
        (this.body = new bdc((bbx)this, "body")).a(0.0f, -12.0f, 0.0f);
        this.body.a("body", -48.0f, 0.0f, 0.0f, 96, 96, 40);
        this.setRotation(this.body, 1.22173f, 0.0f, 0.0f);
        (this.leg1 = new bdc((bbx)this, "leg")).a(48.0f, -24.0f, 0.0f);
        this.leg1.a("main", -16.0f, 0.0f, -16.0f, 32, 48, 32);
        this.leg1.a("toe", -20.0f, 40.0f, -20.0f, 8, 8, 8);
        this.leg1.a("toe", -4.0f, 40.0f, -22.0f, 8, 8, 8);
        this.leg1.a("toe", 12.0f, 40.0f, -20.0f, 8, 8, 8);
        (this.leg2 = new bdc((bbx)this, "leg")).a(-48.0f, -24.0f, 0.0f);
        this.leg2.i = true;
        this.leg2.a("main", -16.0f, 0.0f, -16.0f, 32, 48, 32);
        this.leg2.a("toe", -20.0f, 40.0f, -20.0f, 8, 8, 8);
        this.leg2.a("toe", -4.0f, 40.0f, -22.0f, 8, 8, 8);
        this.leg2.a("toe", 12.0f, 40.0f, -20.0f, 8, 8, 8);
        (this.tail1 = new bdc((bbx)this, "tail")).a(0.0f, 6.0f, 108.0f);
        this.tail1.a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail1.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        (this.tail2 = new bdc((bbx)this, "tail")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail2.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail2.a(0.0f, 7.0f, 142.0f);
        (this.tail3 = new bdc((bbx)this, "tail")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail3.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail3.a(0.0f, 8.0f, 176.0f);
        (this.tail4 = new bdc((bbx)this, "tail")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail4.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail4.a(0.0f, 8.0f, 210.0f);
        (this.neck1a = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1a.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1a.a(0.0f, -48.0f, 16.0f);
        (this.neck1b = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1b.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1b.a(0.0f, -68.0f, 0.0f);
        (this.neck1c = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1c.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1c.a(0.0f, -93.0f, -14.0f);
        (this.neck1d = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1d.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1d.a(0.0f, -116.0f, -37.0f);
        (this.head1 = new bdc((bbx)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head1.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head1.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head1.a(0.0f, -128.0f, -53.0f);
        (this.jaw1 = new bdc((bbx)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw1.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw1, 0.0f, 0.0f, 0.0f);
        this.head1.a(this.jaw1);
        (this.frill1 = new bdc((bbx)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill1.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill1, -0.5235988f, 0.0f, 0.0f);
        this.head1.a(this.frill1);
        (this.neck2a = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2a.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2a.a(48.0f, -48.0f, 16.0f);
        (this.neck2b = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2b.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2b.a(71.0f, -68.0f, 0.0f);
        (this.neck2c = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2c.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2c.a(96.0f, -93.0f, -14.0f);
        (this.neck2d = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2d.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2d.a(108.0f, -116.0f, -37.0f);
        (this.head2 = new bdc((bbx)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head2.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head2.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head2.a(108.0f, -128.0f, -53.0f);
        (this.jaw2 = new bdc((bbx)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw2.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw2, 0.0f, 0.0f, 0.0f);
        this.head2.a(this.jaw2);
        (this.frill2 = new bdc((bbx)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill2.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill2, -0.5235988f, 0.0f, 0.0f);
        this.head2.a(this.frill2);
        (this.neck3a = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 31);
        this.neck3a.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3a.a(-48.0f, -48.0f, 16.0f);
        (this.neck3b = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3b.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3b.a(-71.0f, -43.0f, 0.0f);
        (this.neck3c = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3c.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3c.a(-96.0f, -33.0f, -14.0f);
        (this.neck3d = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3d.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3d.a(-108.0f, -24.0f, -37.0f);
        (this.head3 = new bdc((bbx)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head3.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head3.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head3.a(-108.0f, -24.0f, -53.0f);
        (this.jaw3 = new bdc((bbx)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw3.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw3, 0.125f, 0.0f, 0.0f);
        this.head3.a(this.jaw3);
        (this.frill3 = new bdc((bbx)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill3.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill3, -0.5235988f, 0.0f, 0.0f);
        this.head3.a(this.frill3);
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.body.a(f5);
        this.leg1.a(f5);
        this.leg2.a(f5);
        this.tail1.a(f5);
        this.tail2.a(f5);
        this.tail3.a(f5);
        this.tail4.a(f5);
    }
    
    private void setRotation(final bdc model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final mp entity) {
        super.a(f, f1, f2, f3, f4, f5, entity);
        this.leg1.f = kx.b(f * 0.6662f) * 1.4f * f1;
        this.leg2.f = kx.b(f * 0.6662f + 3.141593f) * 1.4f * f1;
        this.leg1.g = 0.0f;
        this.leg2.g = 0.0f;
    }
    
    public float getRotationY(final EntityTFHydra hydra, final EntityTFHydraPart whichHead, final float time) {
        final float yawOffset = hydra.az + (hydra.ay - hydra.az) * time;
        final float yaw = whichHead.C + (whichHead.A - whichHead.C) * time;
        return (yaw - yawOffset) / 57.29578f;
    }
    
    public float getRotationX(final EntityTFHydra hydra, final EntityTFHydraPart whichHead, final float time) {
        return (whichHead.D + (whichHead.B - whichHead.D) * time) / 57.29578f;
    }
}
