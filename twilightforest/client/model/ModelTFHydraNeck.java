// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFHydraNeck extends bbx
{
    bdc neck;
    
    public ModelTFHydraNeck() {
        this.t = 512;
        this.u = 256;
        this.a("neck.box", 128, 136);
        this.a("neck.fin", 128, 200);
        (this.neck = new bdc((bbx)this, "neck")).a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck.a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck.a(0.0f, 0.0f, 0.0f);
    }
    
    private void setRotation(final bdc model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.neck.a(f5);
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final mp entity) {
        this.neck.g = f3 / 57.29578f;
        this.neck.f = f4 / 57.29578f;
    }
}
