// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.tileentity.TileEntityTFMoonworm;

public class ModelTFMoonworm extends bbx
{
    bdc Shape1;
    bdc Shape2;
    bdc Shape3;
    bdc head;
    
    public ModelTFMoonworm() {
        this.t = 32;
        this.u = 32;
        (this.Shape1 = new bdc((bbx)this, 0, 4)).a(-1.0f, -1.0f, -1.0f, 4, 2, 2);
        this.Shape1.a(-1.0f, 7.0f, 3.0f);
        (this.Shape2 = new bdc((bbx)this, 0, 8)).a(-1.0f, -1.0f, -1.0f, 2, 2, 4);
        this.Shape2.a(3.0f, 7.0f, 0.0f);
        (this.Shape3 = new bdc((bbx)this, 0, 14)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2);
        this.Shape3.a(2.0f, 7.0f, -2.0f);
        (this.head = new bdc((bbx)this, 0, 0)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2);
        this.head.a(-3.0f, 7.0f, 2.0f);
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.a(f5);
        this.Shape2.a(f5);
        this.Shape3.a(f5);
        this.head.a(f5);
    }
    
    public void render(final float f5) {
        this.Shape1.a(f5);
        this.Shape2.a(f5);
        this.Shape3.a(f5);
        this.head.a(f5);
    }
    
    private void setRotation(final bdc model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final mp entity) {
        super.a(f, f1, f2, f3, f4, f5, entity);
    }
    
    public void setLivingAnimations(final TileEntityTFMoonworm moonworm, final float partialTime) {
        this.head.d = 7.0f;
        this.Shape1.d = 7.0f;
        this.Shape2.d = 7.0f;
        this.Shape3.d = 7.0f;
        if (moonworm.yawDelay == 0) {
            final float time = moonworm.desiredYaw - moonworm.currentYaw - partialTime;
            final bdc head = this.head;
            head.d += Math.min(0.0f, kx.a(time / 2.0f));
            final bdc shape1 = this.Shape1;
            shape1.d += Math.min(0.0f, kx.a(time / 2.0f + 1.0f));
            final bdc shape2 = this.Shape2;
            shape2.d += Math.min(0.0f, kx.a(time / 2.0f + 2.0f));
            final bdc shape3 = this.Shape3;
            shape3.d += Math.min(0.0f, kx.a(time / 2.0f + 3.0f));
        }
    }
}
