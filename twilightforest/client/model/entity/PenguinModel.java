// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;

public class PenguinModel extends AgeableModel<PenguinEntity>
{
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head;
    ModelRenderer beak;
    
    public PenguinModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((Model)this, 32, 0)).func_228300_a_(-4.0f, 0.0f, -4.0f, 8.0f, 9.0f, 8.0f);
        this.body.func_78793_a(0.0f, 14.0f, 0.0f);
        (this.rightarm = new ModelRenderer((Model)this, 34, 18)).func_228300_a_(-1.0f, -1.0f, -2.0f, 1.0f, 8.0f, 4.0f);
        this.rightarm.func_78793_a(-4.0f, 15.0f, 0.0f);
        (this.leftarm = new ModelRenderer((Model)this, 24, 18)).func_228300_a_(0.0f, -1.0f, -2.0f, 1.0f, 8.0f, 4.0f);
        this.leftarm.func_78793_a(4.0f, 15.0f, 0.0f);
        this.leftarm.field_78809_i = true;
        (this.rightleg = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-2.0f, 0.0f, -5.0f, 4.0f, 1.0f, 8.0f);
        this.rightleg.func_78793_a(-2.0f, 23.0f, 0.0f);
        this.rightleg.func_78787_b(64, 32);
        (this.leftleg = new ModelRenderer((Model)this, 0, 16)).func_228300_a_(-2.0f, 0.0f, -5.0f, 4.0f, 1.0f, 8.0f);
        this.leftleg.func_78793_a(2.0f, 23.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-3.5f, -4.0f, -3.5f, 7.0f, 5.0f, 7.0f);
        this.head.func_78793_a(0.0f, 13.0f, 0.0f);
        (this.beak = new ModelRenderer((Model)this, 0, 13)).func_228300_a_(-1.0f, 0.0f, -1.0f, 2.0f, 1.0f, 2.0f);
        this.beak.func_78793_a(0.0f, -1.0f, -4.0f);
        this.head.func_78792_a(this.beak);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.rightleg, (Object)this.leftleg, (Object)this.rightarm, (Object)this.leftarm);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.field_217114_e) {
            final float f = 2.0f;
            stack.func_227860_a_();
            stack.func_227862_a_(1.0f / f, 1.0f / f, 1.0f / f);
            stack.func_227861_a_(0.0, (double)(1.5f * scale), 0.0);
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
            stack.func_227860_a_();
            stack.func_227862_a_(1.0f / f, 1.0f / f, 1.0f / f);
            stack.func_227861_a_(0.0, (double)(1.5f * scale), 0.0);
            this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            stack.func_227865_b_();
        }
        else {
            this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
            this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale));
        }
    }
    
    public void setRotationAngles(final PenguinEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.rightleg.field_78795_f = MathHelper.func_76134_b(limbSwing) * 0.7f * limbSwingAmount;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(limbSwing + 3.1415927f) * 0.7f * limbSwingAmount;
        this.rightarm.field_78808_h = ageInTicks;
        this.leftarm.field_78808_h = -ageInTicks;
    }
}
