// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFHydraPart;
import twilightforest.entity.EntityTFHydraHead;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFHydraHead extends ModelBase
{
    ModelRenderer head;
    ModelRenderer jaw;
    ModelRenderer frill;
    
    public ModelTFHydraHead() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        this.func_78085_a("head.box", 272, 0);
        this.func_78085_a("head.upperlip", 272, 56);
        this.func_78085_a("head.rearjaw", 272, 132);
        this.func_78085_a("head.fin", 128, 200);
        this.func_78085_a("head.fang1", 272, 156);
        this.func_78085_a("head.fang2", 272, 156);
        this.func_78085_a("head.teeth", 280, 156);
        this.func_78085_a("head.teeth2", 280, 160);
        this.func_78085_a("head.teeth3", 280, 160);
        this.func_78085_a("jaw.jaw", 272, 92);
        this.func_78085_a("jaw.fang1", 272, 156);
        this.func_78085_a("jaw.fang2", 272, 156);
        this.func_78085_a("jaw.teeth", 280, 156);
        this.func_78085_a("jaw.teeth2", 280, 160);
        this.func_78085_a("jaw.teeth3", 280, 160);
        this.func_78085_a("frill.frill", 272, 200);
        (this.head = new ModelRenderer((ModelBase)this, "head")).func_78786_a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head.func_78786_a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head.func_78786_a("rearjaw", -15.0f, 10.0f, -20.0f, 30, 8, 16);
        this.head.func_78786_a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head.func_78786_a("fang1", -12.0f, 10.0f, -49.0f, 2, 5, 2);
        this.head.func_78786_a("fang2", 10.0f, 10.0f, -49.0f, 2, 5, 2);
        this.head.func_78786_a("teeth", -8.0f, 9.0f, -49.0f, 16, 2, 2);
        this.head.func_78786_a("teeth2", -10.0f, 9.0f, -45.0f, 2, 2, 16);
        this.head.func_78786_a("teeth3", 8.0f, 9.0f, -45.0f, 2, 2, 16);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase)this, "jaw")).func_78793_a(0.0f, 10.0f, -20.0f);
        this.jaw.func_78786_a("jaw", -15.0f, 0.0f, -32.0f, 30, 8, 32);
        this.jaw.func_78786_a("fang1", -10.0f, -5.0f, -29.0f, 2, 5, 2);
        this.jaw.func_78786_a("fang2", 8.0f, -5.0f, -29.0f, 2, 5, 2);
        this.jaw.func_78786_a("teeth", -8.0f, -1.0f, -29.0f, 16, 2, 2);
        this.jaw.func_78786_a("teeth2", -10.0f, -1.0f, -25.0f, 2, 2, 16);
        this.jaw.func_78786_a("teeth3", 8.0f, -1.0f, -25.0f, 2, 2, 16);
        this.setRotation(this.jaw, 0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.jaw);
        (this.frill = new ModelRenderer((ModelBase)this, "frill")).func_78793_a(0.0f, 0.0f, -14.0f);
        this.frill.func_78786_a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill, -0.5235988f, 0.0f, 0.0f);
        this.head.func_78792_a(this.frill);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.head.func_78785_a(f5);
    }
    
    public void render(final float f5) {
        this.head.func_78785_a(f5);
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity par7Entity) {
    }
    
    public void func_78086_a(final EntityLiving entityliving, final float f, final float f1, final float time) {
        final EntityTFHydraHead whichHead = (EntityTFHydraHead)entityliving;
        this.head.field_78796_g = this.getRotationY(whichHead, time);
        this.head.field_78795_f = this.getRotationX(whichHead, time);
        final float mouthOpen = whichHead.getMouthOpen();
        final ModelRenderer head = this.head;
        head.field_78795_f -= (float)(mouthOpen * 0.2617993877991494);
        this.jaw.field_78795_f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public void openMouthForTrophy(final float mouthOpen) {
        this.head.field_78796_g = 0.0f;
        this.head.field_78795_f = 0.0f;
        final ModelRenderer head = this.head;
        head.field_78795_f -= (float)(mouthOpen * 0.2617993877991494);
        this.jaw.field_78795_f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public float getRotationY(final EntityTFHydraPart whichHead, final float time) {
        final float yaw = whichHead.field_70126_B + (whichHead.field_70177_z - whichHead.field_70126_B) * time;
        return yaw / 57.29578f;
    }
    
    public float getRotationX(final EntityTFHydraPart whichHead, final float time) {
        return (whichHead.field_70127_C + (whichHead.field_70125_A - whichHead.field_70127_C) * time) / 57.29578f;
    }
}
