// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.TinyBirdEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;

public class TinyBirdLegacyModel extends AgeableModel<TinyBirdEntity>
{
    ModelRenderer beak;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer tail;
    
    public TinyBirdLegacyModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
        this.head.func_78793_a(0.0f, 20.5f, -0.5f);
        this.head.func_78787_b(32, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak = new ModelRenderer((Model)this, 12, 0)).func_228300_a_(-0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 1.0f);
        this.beak.func_78793_a(0.0f, 0.5f, -2.0f);
        this.head.func_78792_a(this.beak);
        (this.body = new ModelRenderer((Model)this, 0, 6)).func_228300_a_(-1.5f, 0.0f, -1.0f, 3.0f, 3.0f, 3.0f);
        this.body.func_78793_a(0.0f, 20.0f, 0.0f);
        this.body.func_78787_b(32, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((Model)this, 12, 2)).func_228300_a_(-1.0f, 0.0f, -1.5f, 1.0f, 2.0f, 3.0f);
        this.rightarm.func_78793_a(-1.5f, 20.5f, 1.0f);
        this.rightarm.func_78787_b(32, 32);
        this.rightarm.field_78809_i = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((Model)this, 12, 2)).func_228300_a_(0.0f, 0.0f, -1.5f, 1.0f, 2.0f, 3.0f);
        this.leftarm.func_78793_a(1.5f, 20.5f, 1.0f);
        this.leftarm.func_78787_b(32, 32);
        this.leftarm.field_78809_i = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((Model)this, 0, 12)).func_228300_a_(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.rightleg.func_78793_a(-1.5f, 23.0f, 0.0f);
        this.rightleg.func_78787_b(32, 32);
        this.rightleg.field_78809_i = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((Model)this, 0, 12)).func_228300_a_(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.leftleg.func_78793_a(0.0f, 23.0f, 0.0f);
        this.leftleg.func_78787_b(32, 32);
        this.leftleg.field_78809_i = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((Model)this, 0, 14)).func_228300_a_(-1.5f, -0.5f, 0.0f, 3.0f, 1.0f, 2.0f);
        this.tail.func_78793_a(0.0f, 22.0f, 2.0f);
        this.tail.func_78787_b(32, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.rightleg, (Object)this.leftleg, (Object)this.rightarm, (Object)this.leftarm, (Object)this.tail);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.field_217114_e) {
            final float f = 2.0f;
            stack.func_227860_a_();
            stack.func_227861_a_(0.0, (double)(5.0f * scale), (double)(0.75f * scale));
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
            stack.func_227860_a_();
            stack.func_227862_a_(1.0f / f, 1.0f / f, 1.0f / f);
            stack.func_227861_a_(0.0, (double)(24.0f * scale), 0.0);
            this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
        }
        else {
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final TinyBirdEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.rightleg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightarm.field_78808_h = ageInTicks;
        this.leftarm.field_78808_h = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightleg.field_78797_d = 23.0f;
            this.leftleg.field_78797_d = 23.0f;
        }
        else {
            this.rightleg.field_78797_d = 22.5f;
            this.leftleg.field_78797_d = 22.5f;
        }
    }
}
