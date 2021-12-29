// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.RavenEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

public class RavenLegacyModel extends SegmentedModel<RavenEntity>
{
    ModelRenderer head;
    ModelRenderer beak1;
    ModelRenderer beak2;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;
    ModelRenderer tail;
    
    public RavenLegacyModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-1.5f, -1.5f, -3.0f, 3.0f, 3.0f, 3.0f);
        this.head.func_78793_a(0.0f, 18.0f, 0.0f);
        this.head.func_78787_b(32, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak1 = new ModelRenderer((Model)this, 12, 0)).func_228300_a_(-0.5f, -1.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.beak1.func_78793_a(0.0f, 0.0f, -2.5f);
        this.beak1.field_78795_f = 0.2617994f;
        this.head.func_78792_a(this.beak1);
        (this.beak2 = new ModelRenderer((Model)this, 12, 0)).func_228300_a_(-0.5f, 0.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.beak2.func_78793_a(0.0f, 0.0f, -2.5f);
        this.beak2.field_78795_f = -0.2617994f;
        this.head.func_78792_a(this.beak2);
        (this.body = new ModelRenderer((Model)this, 0, 6)).func_228300_a_(-1.5f, 0.0f, -1.0f, 3.0f, 4.0f, 6.0f);
        this.body.func_78793_a(0.0f, 17.0f, 1.0f);
        this.body.func_78787_b(32, 32);
        this.setRotation(this.body, -0.5235988f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-1.0f, 0.0f, -1.5f, 1.0f, 3.0f, 6.0f);
        this.rightarm.func_78793_a(-1.5f, 18.0f, 1.0f);
        this.rightarm.func_78787_b(32, 32);
        (this.leftarm = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(0.0f, 0.0f, -1.5f, 1.0f, 3.0f, 6.0f);
        this.leftarm.func_78793_a(1.5f, 18.0f, 1.0f);
        this.leftarm.func_78787_b(32, 32);
        (this.rightleg = new ModelRenderer((Model)this, 14, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        this.rightleg.func_78793_a(-1.5f, 21.0f, 1.0f);
        this.rightleg.func_78787_b(32, 32);
        (this.rightfoot = new ModelRenderer((Model)this, 14, 20)).func_228300_a_(0.0f, -1.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.rightfoot.func_78793_a(0.0f, 2.0f, 1.0f);
        this.rightfoot.func_78787_b(32, 32);
        this.setRotation(this.rightfoot, 0.5235988f, 0.0f, 0.0f);
        this.rightleg.func_78792_a(this.rightfoot);
        (this.leftleg = new ModelRenderer((Model)this, 14, 16)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        this.leftleg.func_78793_a(0.5f, 21.0f, 1.0f);
        this.leftleg.func_78787_b(32, 32);
        (this.leftfoot = new ModelRenderer((Model)this, 14, 20)).func_228300_a_(0.0f, -1.0f, -2.0f, 1.0f, 1.0f, 2.0f);
        this.leftfoot.func_78793_a(0.0f, 2.0f, 1.0f);
        this.leftfoot.func_78787_b(32, 32);
        this.setRotation(this.leftfoot, 0.5235988f, 0.0f, 0.0f);
        this.leftleg.func_78792_a(this.leftfoot);
        (this.tail = new ModelRenderer((Model)this, 0, 25)).func_228300_a_(-1.5f, -0.5f, 0.0f, 3.0f, 1.0f, 3.0f);
        this.tail.func_78793_a(0.0f, 21.0f, 4.0f);
        this.tail.func_78787_b(32, 32);
        this.setRotation(this.tail, -0.5235988f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.rightarm, (Object)this.leftarm, (Object)this.rightleg, (Object)this.leftleg, (Object)this.tail);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final RavenEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.head.field_78808_h = ((netHeadYaw > 5.0f) ? -0.2617994f : 0.0f);
        this.rightleg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightarm.field_78808_h = ageInTicks;
        this.leftarm.field_78808_h = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightleg.field_78797_d = 21.0f;
            this.leftleg.field_78797_d = 21.0f;
        }
        else {
            this.rightleg.field_78797_d = 20.0f;
            this.leftleg.field_78797_d = 20.0f;
        }
    }
}
