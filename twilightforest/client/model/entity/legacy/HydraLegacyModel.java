// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import twilightforest.entity.boss.HydraPartEntity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.HydraEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class HydraLegacyModel extends SegmentedModel<HydraEntity>
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer neck1a;
    ModelRenderer neck1b;
    ModelRenderer neck1c;
    ModelRenderer neck1d;
    ModelRenderer head1;
    ModelRenderer jaw1;
    ModelRenderer frill1;
    ModelRenderer neck2a;
    ModelRenderer neck2b;
    ModelRenderer neck2c;
    ModelRenderer neck2d;
    ModelRenderer head2;
    ModelRenderer jaw2;
    ModelRenderer frill2;
    ModelRenderer neck3a;
    ModelRenderer neck3b;
    ModelRenderer neck3c;
    ModelRenderer neck3d;
    ModelRenderer head3;
    ModelRenderer jaw3;
    ModelRenderer frill3;
    
    public HydraLegacyModel() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        (this.body = new ModelRenderer((Model)this)).func_78793_a(0.0f, -12.0f, 0.0f);
        this.body.func_78784_a(0, 0).func_228300_a_(-48.0f, 0.0f, 0.0f, 96.0f, 96.0f, 40.0f);
        this.setRotation(this.body, 1.22173f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((Model)this)).func_78793_a(48.0f, -24.0f, 0.0f);
        this.leg1.func_78784_a(0, 136).func_228300_a_(-16.0f, 0.0f, -16.0f, 32.0f, 48.0f, 32.0f);
        this.leg1.func_78784_a(184, 200).func_228300_a_(-20.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f);
        this.leg1.func_78784_a(184, 200).func_228300_a_(-4.0f, 40.0f, -22.0f, 8.0f, 8.0f, 8.0f);
        this.leg1.func_78784_a(184, 200).func_228300_a_(12.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f);
        (this.leg2 = new ModelRenderer((Model)this)).func_78793_a(-48.0f, -24.0f, 0.0f);
        this.leg2.field_78809_i = true;
        this.leg2.func_78784_a(0, 136).func_228300_a_(-16.0f, 0.0f, -16.0f, 32.0f, 48.0f, 32.0f);
        this.leg2.func_78784_a(184, 200).func_228300_a_(-20.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f);
        this.leg2.func_78784_a(184, 200).func_228300_a_(-4.0f, 40.0f, -22.0f, 8.0f, 8.0f, 8.0f);
        this.leg2.func_78784_a(184, 200).func_228300_a_(12.0f, 40.0f, -20.0f, 8.0f, 8.0f, 8.0f);
        (this.tail1 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 6.0f, 108.0f);
        this.tail1.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.tail1.func_78784_a(128, 200).func_228300_a_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f);
        this.tail2 = new ModelRenderer((Model)this);
        this.tail2.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.tail2.func_78784_a(128, 200).func_228300_a_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f);
        this.tail2.func_78793_a(0.0f, 7.0f, 142.0f);
        this.tail3 = new ModelRenderer((Model)this);
        this.tail3.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.tail3.func_78784_a(128, 200).func_228300_a_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f);
        this.tail3.func_78793_a(0.0f, 8.0f, 176.0f);
        this.tail4 = new ModelRenderer((Model)this);
        this.tail4.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.tail4.func_78784_a(128, 200).func_228300_a_(-2.0f, -28.0f, -11.0f, 4.0f, 24.0f, 24.0f);
        this.tail4.func_78793_a(0.0f, 8.0f, 210.0f);
        this.neck1a = new ModelRenderer((Model)this);
        this.neck1a.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck1a.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck1a.func_78793_a(0.0f, -48.0f, 16.0f);
        this.neck1b = new ModelRenderer((Model)this);
        this.neck1b.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck1b.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck1b.func_78793_a(0.0f, -68.0f, 0.0f);
        this.neck1c = new ModelRenderer((Model)this);
        this.neck1c.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck1c.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck1c.func_78793_a(0.0f, -93.0f, -14.0f);
        this.neck1d = new ModelRenderer((Model)this);
        this.neck1d.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck1d.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck1d.func_78793_a(0.0f, -116.0f, -37.0f);
        this.head1 = new ModelRenderer((Model)this);
        this.head1.func_78784_a(272, 0).func_228300_a_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f);
        this.head1.func_78784_a(272, 56).func_228300_a_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f);
        this.head1.func_78784_a(128, 200).func_228300_a_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f);
        this.head1.func_78793_a(0.0f, -128.0f, -53.0f);
        (this.jaw1 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 10.0f, -4.0f);
        this.jaw1.func_78784_a(272, 92).func_228300_a_(-15.0f, 0.0f, -48.0f, 30.0f, 8.0f, 48.0f);
        this.setRotation(this.jaw1, 0.0f, 0.0f, 0.0f);
        this.head1.func_78792_a(this.jaw1);
        (this.frill1 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, -10.0f);
        this.frill1.func_78784_a(272, 200).func_228300_a_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f);
        this.setRotation(this.frill1, -0.5235988f, 0.0f, 0.0f);
        this.head1.func_78792_a(this.frill1);
        this.neck2a = new ModelRenderer((Model)this);
        this.neck2a.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck2a.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck2a.func_78793_a(48.0f, -48.0f, 16.0f);
        this.neck2b = new ModelRenderer((Model)this);
        this.neck2b.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck2b.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck2b.func_78793_a(71.0f, -68.0f, 0.0f);
        this.neck2c = new ModelRenderer((Model)this);
        this.neck2c.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck2c.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck2c.func_78793_a(96.0f, -93.0f, -14.0f);
        this.neck2d = new ModelRenderer((Model)this);
        this.neck2d.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck2d.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck2d.func_78793_a(108.0f, -116.0f, -37.0f);
        this.head2 = new ModelRenderer((Model)this);
        this.head2.func_78784_a(272, 0).func_228300_a_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f);
        this.head2.func_78784_a(272, 56).func_228300_a_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f);
        this.head2.func_78784_a(128, 200).func_228300_a_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f);
        this.head2.func_78793_a(108.0f, -128.0f, -53.0f);
        (this.jaw2 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 10.0f, -4.0f);
        this.jaw2.func_78784_a(272, 92).func_228300_a_(-15.0f, 0.0f, -48.0f, 30.0f, 8.0f, 48.0f);
        this.setRotation(this.jaw2, 0.0f, 0.0f, 0.0f);
        this.head2.func_78792_a(this.jaw2);
        (this.frill2 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, -10.0f);
        this.frill2.func_78784_a(272, 200).func_228300_a_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f);
        this.setRotation(this.frill2, -0.5235988f, 0.0f, 0.0f);
        this.head2.func_78792_a(this.frill2);
        this.neck3a = new ModelRenderer((Model)this);
        this.neck3a.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 31.0f);
        this.neck3a.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck3a.func_78793_a(-48.0f, -48.0f, 16.0f);
        this.neck3b = new ModelRenderer((Model)this);
        this.neck3b.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck3b.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck3b.func_78793_a(-71.0f, -43.0f, 0.0f);
        this.neck3c = new ModelRenderer((Model)this);
        this.neck3c.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck3c.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck3c.func_78793_a(-96.0f, -33.0f, -14.0f);
        this.neck3d = new ModelRenderer((Model)this);
        this.neck3d.func_78784_a(128, 136).func_228300_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f);
        this.neck3d.func_78784_a(128, 200).func_228300_a_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f);
        this.neck3d.func_78793_a(-108.0f, -24.0f, -37.0f);
        this.head3 = new ModelRenderer((Model)this);
        this.head3.func_78784_a(272, 0).func_228300_a_(-16.0f, -14.0f, -32.0f, 32.0f, 24.0f, 32.0f);
        this.head3.func_78784_a(272, 56).func_228300_a_(-15.0f, -2.0f, -56.0f, 30.0f, 12.0f, 24.0f);
        this.head3.func_78784_a(128, 200).func_228300_a_(-2.0f, -30.0f, -12.0f, 4.0f, 24.0f, 24.0f);
        this.head3.func_78793_a(-108.0f, -24.0f, -53.0f);
        (this.jaw3 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 10.0f, -4.0f);
        this.jaw3.func_78784_a(272, 92).func_228300_a_(-15.0f, 0.0f, -48.0f, 30.0f, 8.0f, 48.0f);
        this.setRotation(this.jaw3, 0.125f, 0.0f, 0.0f);
        this.head3.func_78792_a(this.jaw3);
        (this.frill3 = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, -10.0f);
        this.frill3.func_78784_a(272, 200).func_228300_a_(-24.0f, -40.0f, 0.0f, 48.0f, 48.0f, 4.0f);
        this.setRotation(this.frill3, -0.5235988f, 0.0f, 0.0f);
        this.head3.func_78792_a(this.frill3);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.leg1, (Object)this.leg2, (Object)this.tail1, (Object)this.tail2, (Object)this.tail3, (Object)this.tail4);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final HydraEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.leg1.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg2.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.leg1.field_78796_g = 0.0f;
        this.leg2.field_78796_g = 0.0f;
    }
    
    public float getRotationY(final HydraEntity hydra, final HydraPartEntity whichHead, final float time) {
        final float yawOffset = hydra.field_70760_ar + (hydra.field_70761_aq - hydra.field_70760_ar) * time;
        final float yaw = whichHead.field_70126_B + (whichHead.field_70177_z - whichHead.field_70126_B) * time;
        return (yaw - yawOffset) / 57.29578f;
    }
    
    public float getRotationX(final HydraEntity hydra, final HydraPartEntity whichHead, final float time) {
        return (whichHead.field_70127_C + (whichHead.field_70125_A - whichHead.field_70127_C) * time) / 57.29578f;
    }
}
