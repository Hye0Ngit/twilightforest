// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.HydraEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class HydraModel extends SegmentedModel<HydraEntity>
{
    public ModelRenderer torso;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer neck;
    public ModelRenderer neck_1;
    public ModelRenderer neck_2;
    public ModelRenderer tail;
    public ModelRenderer neck_3;
    public ModelRenderer neck_4;
    public ModelRenderer head;
    public ModelRenderer mouth;
    public ModelRenderer plate;
    public ModelRenderer neck_5;
    public ModelRenderer neck_6;
    public ModelRenderer head_1;
    public ModelRenderer mouth_1;
    public ModelRenderer plate_1;
    public ModelRenderer neck_7;
    public ModelRenderer neck_8;
    public ModelRenderer head_2;
    public ModelRenderer mouth_2;
    public ModelRenderer plate_2;
    public ModelRenderer tail_1;
    public ModelRenderer tail_2;
    public ModelRenderer tail_3;
    
    public HydraModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        (this.tail = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 8.0f, 80.0f);
        this.tail.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.tail.func_78784_a(0, 0).func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.neck_5 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-8.0f, -24.0f, -16.0f);
        this.neck_5.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_5.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.tail_3 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 32.0f);
        this.tail_3.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.tail_3.func_78784_a(0, 0).func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.neck_2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(42.0f, -48.0f, 0.0f);
        this.neck_2.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_2.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.neck_4 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-16.0f, -24.0f, -16.0f);
        this.neck_4.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_4.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-42.0f, -48.0f, 0.0f);
        this.neck.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.neck_7 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(16.0f, -24.0f, -16.0f);
        this.neck_7.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_7.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-8.0f, -24.0f, -16.0f);
        this.head.func_78784_a(260, 64).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(236, 128).func_228302_a_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(356, 70).func_228302_a_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f, 0.0f, 0.0f, 0.0f);
        (this.neck_1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -58.0f, -16.0f);
        this.neck_1.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_1.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.plate_1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, -1.0f);
        this.plate_1.func_78784_a(388, 0).func_228302_a_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.plate_1.func_78784_a(220, 0).func_228302_a_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.plate_1, -0.7853982f, 0.0f, 0.0f);
        (this.mouth_1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 8.0f, -16.0f);
        this.mouth_1.func_78784_a(240, 162).func_228302_a_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        (this.tail_2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 32.0f);
        this.tail_2.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.tail_2.func_78784_a(0, 0).func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.torso = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -32.0f, 0.0f);
        this.torso.func_228302_a_(-45.0f, -12.0f, -20.0f, 90.0f, 96.0f, 40.0f, 0.0f, 0.0f, 0.0f);
        this.torso.func_78784_a(88, 136).func_228302_a_(-2.0f, 20.0f, 20.0f, 4.0f, 16.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        this.torso.func_78784_a(120, 136).func_228302_a_(-2.0f, 48.0f, 20.0f, 4.0f, 16.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.torso, 1.1170107f, 0.0f, 0.0f);
        (this.rightLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-40.0f, -20.0f, -12.0f);
        this.rightLeg.func_78784_a(0, 136).func_228302_a_(-14.0f, -8.0f, -16.0f, 28.0f, 52.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.rightLeg.func_78784_a(0, 220).func_228302_a_(-14.0f, 36.0f, -22.0f, 28.0f, 8.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        (this.tail_1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, 32.0f);
        this.tail_1.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.tail_1.func_78784_a(0, 0).func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.head_2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(8.0f, -24.0f, -16.0f);
        this.head_2.func_78784_a(260, 64).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.head_2.func_78784_a(236, 128).func_228302_a_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head_2.func_78784_a(356, 70).func_228302_a_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f, 0.0f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 8.0f, -16.0f);
        this.mouth.func_78784_a(240, 162).func_228302_a_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        (this.head_1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -32.0f, -16.0f);
        this.head_1.func_78784_a(260, 64).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.head_1.func_78784_a(236, 128).func_228302_a_(-16.0f, -2.0f, -40.0f, 32.0f, 10.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        this.head_1.func_78784_a(356, 70).func_228302_a_(-12.0f, 8.0f, -36.0f, 24.0f, 6.0f, 20.0f, 0.0f, 0.0f, 0.0f);
        (this.plate = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, -1.0f);
        this.plate.func_78784_a(388, 0).func_228302_a_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.plate.func_78784_a(220, 0).func_228302_a_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.plate, -0.7853982f, 0.0f, 0.0f);
        (this.neck_6 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(8.0f, -24.0f, -16.0f);
        this.neck_6.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_6.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.mouth_2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 8.0f, -16.0f);
        this.mouth_2.func_78784_a(240, 162).func_228302_a_(-15.0f, 0.0f, -24.0f, 30.0f, 8.0f, 24.0f, 0.0f, 0.0f, 0.0f);
        (this.neck_8 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(16.0f, -24.0f, -16.0f);
        this.neck_8.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_8.func_228302_a_(-2.0f, -24.0f, 0.0f, 4.0f, 8.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        (this.leftLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(40.0f, -20.0f, -12.0f);
        this.leftLeg.func_78784_a(120, 136).func_228302_a_(-14.0f, -8.0f, -16.0f, 28.0f, 52.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.leftLeg.func_78784_a(68, 220).func_228302_a_(-14.0f, 36.0f, -22.0f, 28.0f, 8.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        (this.plate_2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 0.0f, -1.0f);
        this.plate_2.func_78784_a(388, 0).func_228302_a_(-24.0f, -48.0f, 0.0f, 48.0f, 48.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.plate_2.func_78784_a(220, 0).func_228302_a_(-4.0f, -32.0f, -8.0f, 8.0f, 32.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.plate_2, -0.7853982f, 0.0f, 0.0f);
        (this.neck_3 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-16.0f, -24.0f, -16.0f);
        this.neck_3.func_78784_a(260, 0).func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.neck_3.func_228302_a_(-2.0f, -22.0f, 0.0f, 4.0f, 6.0f, 16.0f, 0.0f, 0.0f, 0.0f);
        this.neck_1.func_78792_a(this.neck_5);
        this.tail_2.func_78792_a(this.tail_3);
        this.neck_3.func_78792_a(this.neck_4);
        this.neck_2.func_78792_a(this.neck_7);
        this.neck_4.func_78792_a(this.head);
        this.head_1.func_78792_a(this.plate_1);
        this.head_1.func_78792_a(this.mouth_1);
        this.tail_1.func_78792_a(this.tail_2);
        this.tail.func_78792_a(this.tail_1);
        this.neck_8.func_78792_a(this.head_2);
        this.head.func_78792_a(this.mouth);
        this.neck_6.func_78792_a(this.head_1);
        this.head.func_78792_a(this.plate);
        this.neck_5.func_78792_a(this.neck_6);
        this.head_2.func_78792_a(this.mouth_2);
        this.neck_7.func_78792_a(this.neck_8);
        this.head_2.func_78792_a(this.plate_2);
        this.neck.func_78792_a(this.neck_3);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.torso, (Object)this.leftLeg, (Object)this.rightLeg, (Object)this.tail);
    }
    
    public void setRotationAngles(final HydraEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.leftLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.leftLeg.field_78796_g = 0.0f;
        this.rightLeg.field_78796_g = 0.0f;
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
