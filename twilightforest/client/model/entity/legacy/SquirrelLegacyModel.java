// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.SquirrelEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class SquirrelLegacyModel extends SegmentedModel<SquirrelEntity>
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer head;
    ModelRenderer tail;
    ModelRenderer fluff1;
    ModelRenderer fluff2;
    ModelRenderer fluff3;
    
    public SquirrelLegacyModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((Model)this, 0, 8)).func_228300_a_(-2.0f, -1.0f, -2.0f, 4.0f, 3.0f, 5.0f);
        this.body.func_78793_a(0.0f, 21.0f, 0.0f);
        this.body.func_78787_b(32, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.leg1.func_78793_a(-2.0f, 23.0f, 2.0f);
        this.leg1.func_78787_b(32, 32);
        this.leg1.field_78809_i = true;
        this.setRotation(this.leg1, 0.0f, 0.0f, 0.0f);
        (this.leg2 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.leg2.func_78793_a(1.0f, 23.0f, 2.0f);
        this.leg2.func_78787_b(32, 32);
        this.leg2.field_78809_i = true;
        this.setRotation(this.leg2, 0.0f, 0.0f, 0.0f);
        (this.leg3 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.leg3.func_78793_a(-2.0f, 23.0f, -2.0f);
        this.leg3.func_78787_b(32, 32);
        this.setRotation(this.leg3, 0.0f, 0.0f, 0.0f);
        (this.leg4 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.leg4.func_78793_a(1.0f, 23.0f, -2.0f);
        this.leg4.func_78787_b(32, 32);
        this.setRotation(this.leg4, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this)).func_78793_a(0.0f, 22.0f, -2.0f);
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(0, 0).func_228300_a_(-2.0f, -5.0f, -3.0f, 4.0f, 4.0f, 4.0f);
        this.head.func_78784_a(16, 0).func_228300_a_(-2.0f, -6.0f, -0.5f, 1.0f, 1.0f, 1.0f);
        this.head.func_78784_a(16, 0).func_228300_a_(1.0f, -6.0f, -0.5f, 1.0f, 1.0f, 1.0f);
        (this.tail = new ModelRenderer((Model)this)).func_78793_a(0.0f, 21.0f, 2.0f);
        this.tail.func_78784_a(0, 18).func_228300_a_(-0.5f, -1.5f, 0.5f, 1.0f, 1.0f, 1.0f);
        (this.fluff1 = new ModelRenderer((Model)this, 0, 20)).func_228300_a_(-1.5f, -4.0f, 1.0f, 3.0f, 3.0f, 3.0f);
        this.tail.func_78792_a(this.fluff1);
        (this.fluff2 = new ModelRenderer((Model)this, 0, 20)).func_228300_a_(0.0f, -3.0f, -1.5f, 3.0f, 3.0f, 3.0f);
        this.fluff2.func_78793_a(-1.5f, -4.0f, 2.5f);
        this.fluff1.func_78792_a(this.fluff2);
        (this.fluff3 = new ModelRenderer((Model)this, 0, 26)).func_228300_a_(1.5f, -3.0f, -1.5f, 3.0f, 3.0f, 3.0f);
        this.fluff3.func_78793_a(-1.5f, -3.0f, 0.0f);
        this.fluff2.func_78792_a(this.fluff3);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.leg1, (Object)this.leg2, (Object)this.leg3, (Object)this.leg4, (Object)this.head, (Object)this.tail);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setLivingAnimations(final SquirrelEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTickTime) {
    }
    
    public void setRotationAngles(final SquirrelEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.leg1.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg2.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg3.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg4.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        if (limbSwingAmount > 0.2) {
            final float wiggle = Math.min(limbSwingAmount, 0.6f);
            this.tail.field_78795_f = (MathHelper.func_76134_b(ageInTicks * 0.6662f) - 1.0471976f) * wiggle;
            this.fluff2.field_78795_f = MathHelper.func_76134_b(ageInTicks * 0.7774f) * 1.2f * wiggle;
            this.fluff3.field_78795_f = MathHelper.func_76134_b(ageInTicks * 0.8886f + 1.5707964f) * 1.4f * wiggle;
        }
        else {
            this.tail.field_78795_f = 0.2f + MathHelper.func_76134_b(ageInTicks * 0.3335f) * 0.15f;
            this.fluff2.field_78795_f = 0.1f + MathHelper.func_76134_b(ageInTicks * 0.4445f) * 0.2f;
            this.fluff3.field_78795_f = 0.1f + MathHelper.func_76134_b(ageInTicks * 0.5555f) * 0.25f;
        }
    }
}
