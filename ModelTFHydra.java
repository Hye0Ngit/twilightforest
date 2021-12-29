// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFHydra extends hl
{
    ql body;
    ql leg1;
    ql leg2;
    ql tail1;
    ql tail2;
    ql tail3;
    ql tail4;
    ql neck1a;
    ql neck1b;
    ql neck1c;
    ql neck1d;
    ql head1;
    ql jaw1;
    ql frill1;
    ql neck2a;
    ql neck2b;
    ql neck2c;
    ql neck2d;
    ql head2;
    ql jaw2;
    ql frill2;
    ql neck3a;
    ql neck3b;
    ql neck3c;
    ql neck3d;
    ql head3;
    ql jaw3;
    ql frill3;
    
    public ModelTFHydra() {
        this.l = 512;
        this.m = 256;
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
        (this.body = new ql((hl)this, "body")).a(0.0f, -12.0f, 0.0f);
        this.body.a("body", -48.0f, 0.0f, 0.0f, 96, 96, 40);
        this.setRotation(this.body, 1.22173f, 0.0f, 0.0f);
        (this.leg1 = new ql((hl)this, "leg")).a(48.0f, -24.0f, 0.0f);
        this.leg1.a("main", -16.0f, 0.0f, -16.0f, 32, 48, 32);
        this.leg1.a("toe", -20.0f, 40.0f, -20.0f, 8, 8, 8);
        this.leg1.a("toe", -4.0f, 40.0f, -22.0f, 8, 8, 8);
        this.leg1.a("toe", 12.0f, 40.0f, -20.0f, 8, 8, 8);
        (this.leg2 = new ql((hl)this, "leg")).a(-48.0f, -24.0f, 0.0f);
        this.leg2.i = true;
        this.leg2.a("main", -16.0f, 0.0f, -16.0f, 32, 48, 32);
        this.leg2.a("toe", -20.0f, 40.0f, -20.0f, 8, 8, 8);
        this.leg2.a("toe", -4.0f, 40.0f, -22.0f, 8, 8, 8);
        this.leg2.a("toe", 12.0f, 40.0f, -20.0f, 8, 8, 8);
        (this.tail1 = new ql((hl)this, "tail")).a(0.0f, 6.0f, 108.0f);
        this.tail1.a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail1.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        (this.tail2 = new ql((hl)this, "tail")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail2.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail2.a(0.0f, 7.0f, 142.0f);
        (this.tail3 = new ql((hl)this, "tail")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail3.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail3.a(0.0f, 8.0f, 176.0f);
        (this.tail4 = new ql((hl)this, "tail")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail4.a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail4.a(0.0f, 8.0f, 210.0f);
        (this.neck1a = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1a.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1a.a(0.0f, -48.0f, 16.0f);
        (this.neck1b = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1b.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1b.a(0.0f, -68.0f, 0.0f);
        (this.neck1c = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1c.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1c.a(0.0f, -93.0f, -14.0f);
        (this.neck1d = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1d.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1d.a(0.0f, -116.0f, -37.0f);
        (this.head1 = new ql((hl)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head1.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head1.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head1.a(0.0f, -128.0f, -53.0f);
        (this.jaw1 = new ql((hl)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw1.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw1, 0.0f, 0.0f, 0.0f);
        this.head1.a(this.jaw1);
        (this.frill1 = new ql((hl)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill1.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill1, -0.5235988f, 0.0f, 0.0f);
        this.head1.a(this.frill1);
        (this.neck2a = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2a.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2a.a(48.0f, -48.0f, 16.0f);
        (this.neck2b = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2b.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2b.a(71.0f, -68.0f, 0.0f);
        (this.neck2c = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2c.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2c.a(96.0f, -93.0f, -14.0f);
        (this.neck2d = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2d.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2d.a(108.0f, -116.0f, -37.0f);
        (this.head2 = new ql((hl)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head2.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head2.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head2.a(108.0f, -128.0f, -53.0f);
        (this.jaw2 = new ql((hl)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw2.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw2, 0.0f, 0.0f, 0.0f);
        this.head2.a(this.jaw2);
        (this.frill2 = new ql((hl)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill2.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill2, -0.5235988f, 0.0f, 0.0f);
        this.head2.a(this.frill2);
        (this.neck3a = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 31);
        this.neck3a.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3a.a(-48.0f, -48.0f, 16.0f);
        (this.neck3b = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3b.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3b.a(-71.0f, -43.0f, 0.0f);
        (this.neck3c = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3c.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3c.a(-96.0f, -33.0f, -14.0f);
        (this.neck3d = new ql((hl)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3d.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3d.a(-108.0f, -24.0f, -37.0f);
        (this.head3 = new ql((hl)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head3.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head3.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head3.a(-108.0f, -24.0f, -53.0f);
        (this.jaw3 = new ql((hl)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw3.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw3, 0.125f, 0.0f, 0.0f);
        this.head3.a(this.jaw3);
        (this.frill3 = new ql((hl)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill3.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill3, -0.5235988f, 0.0f, 0.0f);
        this.head3.a(this.frill3);
    }
    
    public void a(final nk entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        this.body.a(f5);
        this.leg1.a(f5);
        this.leg2.a(f5);
        this.tail1.a(f5);
        this.tail2.a(f5);
        this.tail3.a(f5);
        this.tail4.a(f5);
    }
    
    private void setRotation(final ql model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void setRotationAngles(final nk entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(f, f1, f2, f3, f4, f5);
        this.leg1.f = gh.b(f * 0.6662f) * 1.4f * f1;
        this.leg2.f = gh.b(f * 0.6662f + 3.141593f) * 1.4f * f1;
        this.leg1.g = 0.0f;
        this.leg2.g = 0.0f;
    }
    
    public void a(final acl entityliving, final float f, final float f1, final float time) {
        final EntityTFHydra hydra = (EntityTFHydra)entityliving;
        bm vec = bm.b(0.0, 0.0, -112.0);
        vec.a(1.0471976f);
        vec.b(0.0f);
        this.head1.a((float)vec.a, (float)vec.b - 48.0f, (float)vec.c);
        vec = bm.b(0.0, 0.0, -144.0);
        vec.a(0.78539824f);
        vec.b(-1.0471976f);
        this.head2.a((float)vec.a, (float)vec.b - 48.0f, (float)vec.c);
        vec = bm.b(0.0, 0.0, -144.0);
        vec.a(-0.17453295f);
        vec.b(1.0471976f);
        this.head3.a((float)vec.a, (float)vec.b - 48.0f, (float)vec.c);
        this.head1.g = this.getRotationY(hydra, hydra.head1, time);
        this.head1.f = this.getRotationX(hydra, hydra.head1, time);
        this.head2.g = this.getRotationY(hydra, hydra.head3, time);
        this.head2.f = this.getRotationX(hydra, hydra.head3, time);
        this.head3.g = this.getRotationY(hydra, hydra.head2, time);
        this.head3.f = this.getRotationX(hydra, hydra.head2, time) - 0.015f;
    }
    
    public float getRotationY(final EntityTFHydra hydra, final EntityTFHydraPart whichHead, final float time) {
        final float yawOffset = hydra.be + (hydra.bd - hydra.be) * time;
        final float yaw = whichHead.w + (whichHead.u - whichHead.w) * time;
        return (yaw - yawOffset) / 57.29578f;
    }
    
    public float getRotationX(final EntityTFHydra hydra, final EntityTFHydraPart whichHead, final float time) {
        return (whichHead.x + (whichHead.v - whichHead.x) * time) / 57.29578f;
    }
}
