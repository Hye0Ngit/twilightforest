// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.BunnyEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class BunnyModel extends SegmentedModel<BunnyEntity>
{
    ModelRenderer tail;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer head;
    
    public BunnyModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.tail = new ModelRenderer((Model)this, 0, 18)).func_228300_a_(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 2.0f);
        this.tail.func_78793_a(0.0f, 20.0f, 3.0f);
        this.tail.func_78787_b(32, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
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
        this.leg3.field_78809_i = true;
        this.setRotation(this.leg3, 0.0f, 0.0f, 0.0f);
        (this.leg4 = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.leg4.func_78793_a(1.0f, 23.0f, -2.0f);
        this.leg4.func_78787_b(32, 32);
        this.leg4.field_78809_i = true;
        this.setRotation(this.leg4, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this)).func_78793_a(0.0f, 22.0f, -1.0f);
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        this.head.field_78809_i = true;
        this.head.func_78784_a(0, 0).func_228300_a_(-2.0f, -4.0f, -3.0f, 4.0f, 4.0f, 4.0f);
        this.head.func_78784_a(16, 0).func_228300_a_(-2.5f, -8.0f, -0.5f, 2.0f, 4.0f, 1.0f);
        this.head.func_78784_a(16, 0).func_228300_a_(0.5f, -8.0f, -0.5f, 2.0f, 4.0f, 1.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.tail, (Object)this.body, (Object)this.leg1, (Object)this.leg2, (Object)this.leg3, (Object)this.leg4, (Object)this.head);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final BunnyEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.leg1.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg2.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg3.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leg4.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
