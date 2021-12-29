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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.TinyBirdEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;

@OnlyIn(Dist.CLIENT)
public class TinyBirdModel extends AgeableModel<TinyBirdEntity>
{
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightFoot;
    public ModelRenderer leftFoot;
    public ModelRenderer rightWing;
    public ModelRenderer leftWing;
    public ModelRenderer tail;
    
    public TinyBirdModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 20.0f, 0.0f);
        this.body.func_78784_a(12, 0).func_228302_a_(-1.5f, 0.0f, 0.0f, 3.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.leftFoot = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.0f, 23.0f, 2.0f);
        this.leftFoot.func_78784_a(0, 11).func_228302_a_(-0.5f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 1.0f, 3.0f);
        this.tail.func_78784_a(1, 6).func_228302_a_(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.tail, 0.43633232f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 21.0f, 0.0f);
        this.head.func_228302_a_(-1.5f, -2.0f, -2.0f, 3.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(9, 0).func_228302_a_(-0.5f, 0.0f, -3.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(0, 6).func_228302_a_(-1.5f, -5.0f, 1.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        (this.rightWing = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, 0.0f, 1.0f);
        this.rightWing.func_78784_a(24, 0).func_228302_a_(-0.5f, 0.0f, -1.0f, 1.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.leftWing = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, 0.0f, 1.0f);
        this.leftWing.func_78784_a(24, 5).func_228302_a_(-0.5f, 0.0f, -1.0f, 1.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        (this.rightFoot = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.0f, 23.0f, 2.0f);
        this.rightFoot.func_78784_a(0, 9).func_228302_a_(-0.5f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.tail);
        this.body.func_78792_a(this.rightWing);
        this.body.func_78792_a(this.leftWing);
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.rightFoot, (Object)this.leftFoot);
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
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
    
    public void setRotationAngles(final TinyBirdEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.rightFoot.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftFoot.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightWing.field_78808_h = ageInTicks;
        this.leftWing.field_78808_h = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightFoot.field_78797_d = 23.0f;
            this.leftFoot.field_78797_d = 23.0f;
        }
        else {
            this.rightFoot.field_78797_d = 22.5f;
            this.leftFoot.field_78797_d = 22.5f;
        }
    }
}
