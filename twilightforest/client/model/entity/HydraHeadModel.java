// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.boss.HydraPartEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.HydraHeadEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HydraHeadModel extends SegmentedModel<HydraHeadEntity>
{
    ModelRenderer head;
    ModelRenderer mouth;
    ModelRenderer plate;
    
    public HydraHeadModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(260, 64).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(236, 128).func_228302_a_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(356, 70).func_228302_a_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f, 0.0f, 0.0f, 0.0f);
        (this.plate = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.plate.func_78784_a(388, 0).func_228302_a_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.plate.func_78784_a(220, 0).func_228302_a_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.plate, -0.7853982f, 0.0f, 0.0f);
        this.head.func_78792_a(this.plate);
        (this.mouth = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 10.0f, -14.0f);
        this.mouth.func_78784_a(240, 162).func_228302_a_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.mouth);
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
        this.mouth.field_78795_f = (float)(mouthOpen * 1.0471975511965976);
    }
    
    public float getRotationY(final HydraPartEntity whichHead, final float time) {
        final float yaw = whichHead.field_70126_B + (whichHead.field_70177_z - whichHead.field_70126_B) * time;
        return yaw / 57.29578f;
    }
    
    public float getRotationX(final HydraPartEntity whichHead, final float time) {
        return (whichHead.field_70127_C + (whichHead.field_70125_A - whichHead.field_70127_C) * time) / 57.29578f;
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
