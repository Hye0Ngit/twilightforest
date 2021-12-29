// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.FireBeetleEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class FireBeetleLegacyModel extends SegmentedModel<FireBeetleEntity>
{
    ModelRenderer thorax;
    ModelRenderer head;
    ModelRenderer connector2;
    ModelRenderer RearEnd;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer connector1;
    ModelRenderer jaw1a;
    ModelRenderer jaw1b;
    ModelRenderer jaw2a;
    ModelRenderer jaw2b;
    ModelRenderer antenna1;
    ModelRenderer antenna2;
    ModelRenderer eye1;
    ModelRenderer eye2;
    
    public FireBeetleLegacyModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.thorax = new ModelRenderer((Model)this, 0, 22)).func_228300_a_(-4.5f, -4.0f, 0.0f, 9.0f, 8.0f, 2.0f);
        this.thorax.func_78793_a(0.0f, 18.0f, -4.5f);
        (this.connector1 = new ModelRenderer((Model)this, 0, 12)).func_228300_a_(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 1.0f);
        this.connector1.func_78793_a(0.0f, 18.0f, -3.0f);
        (this.connector2 = new ModelRenderer((Model)this, 0, 12)).func_228300_a_(-3.0f, -3.0f, -1.0f, 6.0f, 6.0f, 1.0f);
        this.connector2.func_78793_a(0.0f, 18.0f, -4.0f);
        (this.RearEnd = new ModelRenderer((Model)this, 22, 9)).func_228300_a_(-6.0f, -9.0f, -4.0f, 12.0f, 14.0f, 9.0f);
        this.RearEnd.func_78793_a(0.0f, 18.0f, 7.0f);
        this.setRotation(this.RearEnd, 1.570796f, 0.0f, 0.0f);
        (this.Leg6 = new ModelRenderer((Model)this, 40, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f);
        this.Leg6.func_78793_a(4.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.3490659f);
        this.Leg5 = new ModelRenderer((Model)this, 40, 0);
        this.Leg5.field_78809_i = true;
        this.Leg5.func_228300_a_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f);
        this.Leg5.func_78793_a(-4.0f, 21.0f, -4.0f);
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.3490659f);
        (this.Leg4 = new ModelRenderer((Model)this, 40, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f);
        this.Leg4.func_78793_a(4.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.3490659f);
        (this.Leg2 = new ModelRenderer((Model)this, 40, 0)).func_228300_a_(-1.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f);
        this.Leg2.func_78793_a(4.0f, 21.0f, 4.0f);
        this.setRotation(this.Leg2, 0.0f, -0.6981317f, 0.3490659f);
        this.Leg3 = new ModelRenderer((Model)this, 40, 0);
        this.Leg3.field_78809_i = true;
        this.Leg3.func_228300_a_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f);
        this.Leg3.func_78793_a(-4.0f, 21.0f, -1.0f);
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.3490659f);
        this.Leg1 = new ModelRenderer((Model)this, 40, 0);
        this.Leg1.field_78809_i = true;
        this.Leg1.func_228300_a_(-9.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f);
        this.Leg1.func_78793_a(-4.0f, 21.0f, 4.0f);
        this.Leg1.func_78787_b(64, 32);
        this.setRotation(this.Leg1, 0.0f, 0.6981317f, -0.3490659f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -4.0f, -6.0f, 8.0f, 6.0f, 6.0f);
        this.head.func_78793_a(0.0f, 19.0f, -5.0f);
        (this.jaw1a = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.jaw1a.func_78793_a(-3.0f, 0.0f, -6.0f);
        this.setRotation(this.jaw1a, 0.3490659f, 0.0f, 0.0f);
        (this.jaw1b = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 2.0f);
        this.jaw1b.func_78793_a(0.0f, 0.0f, -2.0f);
        this.setRotation(this.jaw1b, 0.0f, 1.570796f, 0.0f);
        (this.jaw2a = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-1.0f, 0.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.jaw2a.func_78793_a(3.0f, 0.0f, -6.0f);
        this.setRotation(this.jaw2a, 0.3490659f, 0.0f, 0.0f);
        (this.jaw2b = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(0.0f, 0.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.jaw2b.func_78793_a(0.0f, 0.0f, -2.0f);
        this.setRotation(this.jaw2b, 0.0f, 1.570796f, 0.0f);
        (this.antenna1 = new ModelRenderer((Model)this, 42, 4)).func_228300_a_(0.0f, -0.5f, -0.5f, 10.0f, 1.0f, 1.0f);
        this.antenna1.func_78793_a(1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna1, 0.0f, 1.047198f, -0.296706f);
        (this.antenna2 = new ModelRenderer((Model)this, 42, 4)).func_228300_a_(0.0f, -0.5f, -0.5f, 10.0f, 1.0f, 1.0f);
        this.antenna2.func_78793_a(-1.0f, -3.0f, -5.0f);
        this.setRotation(this.antenna2, 0.0f, 2.094395f, 0.296706f);
        (this.eye1 = new ModelRenderer((Model)this, 15, 12)).func_228300_a_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
        this.eye1.func_78793_a(-3.0f, -2.0f, -5.0f);
        (this.eye2 = new ModelRenderer((Model)this, 15, 12)).func_228300_a_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
        this.eye2.func_78793_a(3.0f, -2.0f, -5.0f);
        this.head.func_78792_a(this.jaw1a);
        this.jaw1a.func_78792_a(this.jaw1b);
        this.head.func_78792_a(this.jaw2a);
        this.jaw2a.func_78792_a(this.jaw2b);
        this.head.func_78792_a(this.antenna1);
        this.head.func_78792_a(this.antenna2);
        this.head.func_78792_a(this.eye1);
        this.head.func_78792_a(this.eye2);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.thorax, (Object)this.head, (Object)this.connector2, (Object)this.RearEnd, (Object)this.Leg6, (Object)this.Leg4, (Object)this.Leg2, (Object)this.Leg5, (Object)this.Leg3, (Object)this.Leg1, (Object)this.connector1);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final FireBeetleEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.head.field_78795_f = headPitch / 57.295776f;
        final float legZ = 0.28559935f;
        this.Leg1.field_78808_h = -legZ;
        this.Leg2.field_78808_h = legZ;
        this.Leg3.field_78808_h = -legZ * 0.74f;
        this.Leg4.field_78808_h = legZ * 0.74f;
        this.Leg5.field_78808_h = -legZ;
        this.Leg6.field_78808_h = legZ;
        final float var9 = -0.0f;
        final float var10 = 0.3926991f;
        this.Leg1.field_78796_g = var10 * 2.0f + var9;
        this.Leg2.field_78796_g = -var10 * 2.0f - var9;
        this.Leg3.field_78796_g = var10 + var9;
        this.Leg4.field_78796_g = -var10 - var9;
        this.Leg5.field_78796_g = -var10 * 2.0f + var9;
        this.Leg6.field_78796_g = var10 * 2.0f - var9;
        final float var11 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var12 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var13 = -(MathHelper.func_76134_b(limbSwing * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbSwingAmount;
        final float var14 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 0.0f) * 0.4f) * limbSwingAmount;
        final float var15 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 3.1415927f) * 0.4f) * limbSwingAmount;
        final float var16 = Math.abs(MathHelper.func_76126_a(limbSwing * 0.6662f + 4.712389f) * 0.4f) * limbSwingAmount;
        final ModelRenderer leg1 = this.Leg1;
        leg1.field_78796_g += var11;
        final ModelRenderer leg2 = this.Leg2;
        leg2.field_78796_g += -var11;
        final ModelRenderer leg3 = this.Leg3;
        leg3.field_78796_g += var12;
        final ModelRenderer leg4 = this.Leg4;
        leg4.field_78796_g += -var12;
        final ModelRenderer leg5 = this.Leg5;
        leg5.field_78796_g += var13;
        final ModelRenderer leg6 = this.Leg6;
        leg6.field_78796_g += -var13;
        final ModelRenderer leg7 = this.Leg1;
        leg7.field_78808_h += var14;
        final ModelRenderer leg8 = this.Leg2;
        leg8.field_78808_h += -var14;
        final ModelRenderer leg9 = this.Leg3;
        leg9.field_78808_h += var15;
        final ModelRenderer leg10 = this.Leg4;
        leg10.field_78808_h += -var15;
        final ModelRenderer leg11 = this.Leg5;
        leg11.field_78808_h += var16;
        final ModelRenderer leg12 = this.Leg6;
        leg12.field_78808_h += -var16;
    }
}
