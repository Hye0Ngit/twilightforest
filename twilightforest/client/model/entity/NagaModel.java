// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import twilightforest.entity.boss.NagaSegmentEntity;
import twilightforest.entity.boss.NagaEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.Entity;

@OnlyIn(Dist.CLIENT)
public class NagaModel<T extends Entity> extends SegmentedModel<T>
{
    public ModelRenderer head;
    public ModelRenderer tongue;
    public ModelRenderer body;
    private T entity;
    
    public NagaModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.tongue = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 10.0f, -16.0f);
        this.tongue.func_78784_a(84, 0).func_228302_a_(-6.0f, 0.0f, -12.0f, 12.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.tongue, 0.43633232f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 8.0f, 0.0f);
        this.head.func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.tongue);
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 8.0f, 0.0f);
        this.body.func_228302_a_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        if (this.entity instanceof NagaEntity) {
            this.head.func_228309_a_(stack, builder, light, overlay, red, green, blue, alpha * 2.0f);
        }
        else if (this.entity instanceof NagaSegmentEntity) {
            this.body.func_228309_a_(stack, builder, light, overlay, red, green, blue, alpha * 2.0f);
        }
        else {
            this.head.func_228309_a_(stack, builder, light, overlay, red, green, blue, alpha * 2.0f);
        }
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body);
    }
    
    public void func_225597_a_(final T entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
