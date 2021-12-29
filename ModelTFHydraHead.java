// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFHydraHead extends hl
{
    ql head;
    ql jaw;
    ql frill;
    
    public ModelTFHydraHead() {
        this.l = 512;
        this.m = 256;
        this.a("head.box", 272, 0);
        this.a("head.upperlip", 272, 56);
        this.a("head.fin", 128, 200);
        this.a("jaw.jaw", 272, 92);
        this.a("frill.frill", 272, 200);
        (this.head = new ql((hl)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head.a(0.0f, 0.0f, 0.0f);
        (this.jaw = new ql((hl)this, "jaw")).a(0.0f, 10.0f, -4.0f);
        this.jaw.a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw, 0.0f, 0.0f, 0.0f);
        this.head.a(this.jaw);
        (this.frill = new ql((hl)this, "frill")).a(0.0f, 0.0f, -10.0f);
        this.frill.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill, -0.5235988f, 0.0f, 0.0f);
        this.head.a(this.frill);
    }
    
    private void setRotation(final ql model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final nk entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5);
        this.head.a(f5);
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.head.g = f3 / 57.29578f;
        this.head.f = f4 / 57.29578f;
    }
}
