// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.boss.HydraPartEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.HydraHeadEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HydraHeadLegacyModel extends SegmentedModel<HydraHeadEntity>
{
    ModelRenderer head;
    ModelRenderer jaw;
    ModelRenderer frill;
    
    public HydraHeadLegacyModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        this.head = new ModelRenderer((Model)this);
        this.head.func_78784_a(272, 0).func_228300_a_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f);
        this.head.func_78784_a(272, 56).func_228300_a_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f);
        this.head.func_78784_a(272, 132).func_228300_a_(-15.0f, 10.0f, -20.0f, 30.0f, 8.0f, 16.0f);
        this.head.func_78784_a(128, 200).func_228300_a_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f);
        this.head.func_78784_a(272, 156).func_228300_a_(-12.0f, 10.0f, -49.0f, 2.0f, 5.0f, 2.0f);
        this.head.func_78784_a(272, 156).func_228300_a_(10.0f, 10.0f, -49.0f, 2.0f, 5.0f, 2.0f);
        this.head.func_78784_a(280, 156).func_228300_a_(-8.0f, 9.0f, -49.0f, 16.0f, 2.0f, 2.0f);
        this.head.func_78784_a(280, 160).func_228300_a_(-10.0f, 9.0f, -45.0f, 2.0f, 2.0f, 16.0f);
        this.head.func_78784_a(280, 160).func_228300_a_(8.0f, 9.0f, -45.0f, 2.0f, 2.0f, 16.0f);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((Model)this)).func_78793_a(0.0f, 10.0f, -20.0f);
        this.jaw.func_78784_a(272, 92).func_228300_a_(-15.0f, 0.0f, -32.0f, 30.0f, 8.0f, 32.0f);
        this.jaw.func_78784_a(272, 156).func_228300_a_(-10.0f, -5.0f, -29.0f, 2.0f, 5.0f, 2.0f);
        this.jaw.func_78784_a(272, 156).func_228300_a_(8.0f, -5.0f, -29.0f, 2.0f, 5.0f, 2.0f);
        this.jaw.func_78784_a(280, 156).func_228300_a_(-8.0f, -1.0f, -29.0f, 16.0f, 2.0f, 2.0f);
        this.jaw.func_78784_a(280, 160).func_228300_a_(-10.0f, -1.0f, -25.0f, 2.0f, 2.0f, 16.0f);
        this.jaw.func_78784_a(280, 160).func_228300_a_(8.0f, -1.0f, -25.0f, 2.0f, 2.0f, 16.0f);
        this.setRotation(this.jaw, 0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.jaw);
        (this.frill = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, -14.0f);
        this.frill.func_78784_a(272, 200).func_228300_a_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f);
        this.setRotation(this.frill, -0.5235988f, 0.0f, 0.0f);
        this.head.func_78792_a(this.frill);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head);
    }
    
    public void setRotationAngles(final HydraHeadEntity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void setLivingAnimations(final HydraHeadEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.head.field_78796_g = this.getRotationY(entity, partialTicks);
        this.head.field_78795_f = this.getRotationX(entity, partialTicks);
        final float mouthOpenLast = entity.getMouthOpenLast();
        final float mouthOpenReal = entity.getMouthOpen();
        final float mouthOpen = MathHelper.func_219799_g(partialTicks, mouthOpenLast, mouthOpenReal);
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
    
    public float getRotationY(final HydraPartEntity whichHead, final float time) {
        final float yaw = whichHead.field_70126_B + (whichHead.field_70177_z - whichHead.field_70126_B) * time;
        return yaw / 57.29578f;
    }
    
    public float getRotationX(final HydraPartEntity whichHead, final float time) {
        return (whichHead.field_70127_C + (whichHead.field_70125_A - whichHead.field_70127_C) * time) / 57.29578f;
    }
}
