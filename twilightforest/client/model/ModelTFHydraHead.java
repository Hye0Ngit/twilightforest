// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFHydraPart;
import twilightforest.entity.EntityTFHydraHead;

public class ModelTFHydraHead extends bbx
{
    bdc head;
    bdc jaw;
    bdc frill;
    
    public ModelTFHydraHead() {
        this.t = 512;
        this.u = 256;
        this.a("head.box", 272, 0);
        this.a("head.upperlip", 272, 56);
        this.a("head.rearjaw", 272, 132);
        this.a("head.fin", 128, 200);
        this.a("head.fang1", 272, 156);
        this.a("head.fang2", 272, 156);
        this.a("head.teeth", 280, 156);
        this.a("head.teeth2", 280, 160);
        this.a("head.teeth3", 280, 160);
        this.a("jaw.jaw", 272, 92);
        this.a("jaw.fang1", 272, 156);
        this.a("jaw.fang2", 272, 156);
        this.a("jaw.teeth", 280, 156);
        this.a("jaw.teeth2", 280, 160);
        this.a("jaw.teeth3", 280, 160);
        this.a("frill.frill", 272, 200);
        (this.head = new bdc((bbx)this, "head")).a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head.a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head.a("rearjaw", -15.0f, 10.0f, -20.0f, 30, 8, 16);
        this.head.a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head.a("fang1", -12.0f, 10.0f, -49.0f, 2, 5, 2);
        this.head.a("fang2", 10.0f, 10.0f, -49.0f, 2, 5, 2);
        this.head.a("teeth", -8.0f, 9.0f, -49.0f, 16, 2, 2);
        this.head.a("teeth2", -10.0f, 9.0f, -45.0f, 2, 2, 16);
        this.head.a("teeth3", 8.0f, 9.0f, -45.0f, 2, 2, 16);
        this.head.a(0.0f, 0.0f, 0.0f);
        (this.jaw = new bdc((bbx)this, "jaw")).a(0.0f, 10.0f, -20.0f);
        this.jaw.a("jaw", -15.0f, 0.0f, -32.0f, 30, 8, 32);
        this.jaw.a("fang1", -10.0f, -5.0f, -29.0f, 2, 5, 2);
        this.jaw.a("fang2", 8.0f, -5.0f, -29.0f, 2, 5, 2);
        this.jaw.a("teeth", -8.0f, -1.0f, -29.0f, 16, 2, 2);
        this.jaw.a("teeth2", -10.0f, -1.0f, -25.0f, 2, 2, 16);
        this.jaw.a("teeth3", 8.0f, -1.0f, -25.0f, 2, 2, 16);
        this.setRotation(this.jaw, 0.0f, 0.0f, 0.0f);
        this.head.a(this.jaw);
        (this.frill = new bdc((bbx)this, "frill")).a(0.0f, 0.0f, -14.0f);
        this.frill.a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill, -0.5235988f, 0.0f, 0.0f);
        this.head.a(this.frill);
    }
    
    private void setRotation(final bdc model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.head.a(f5);
    }
    
    public void render(final float f5) {
        this.head.a(f5);
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final mp par7Entity) {
    }
    
    public void a(final ng entityliving, final float f, final float f1, final float time) {
        final EntityTFHydraHead whichHead = (EntityTFHydraHead)entityliving;
        this.head.g = this.getRotationY(whichHead, time);
        this.head.f = this.getRotationX(whichHead, time);
        final float mouthOpen = whichHead.getMouthOpen();
        final bdc head = this.head;
        head.f -= (float)(mouthOpen * 0.2617993877991494);
        this.jaw.f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public void openMouthForTrophy(final float mouthOpen) {
        this.head.g = 0.0f;
        this.head.f = 0.0f;
        final bdc head = this.head;
        head.f -= (float)(mouthOpen * 0.2617993877991494);
        this.jaw.f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public float getRotationY(final EntityTFHydraPart whichHead, final float time) {
        final float yaw = whichHead.C + (whichHead.A - whichHead.C) * time;
        return yaw / 57.29578f;
    }
    
    public float getRotationX(final EntityTFHydraPart whichHead, final float time) {
        return (whichHead.D + (whichHead.B - whichHead.D) * time) / 57.29578f;
    }
}
