// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.Arrays;
import net.minecraft.client.renderer.model.Model;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import twilightforest.entity.IceMobEntity;

public class UnstableIceCoreModel<T extends IceMobEntity> extends BipedModel<T>
{
    public ModelRenderer[] spikes;
    private final ImmutableList<ModelRenderer> parts;
    protected boolean alive;
    
    public UnstableIceCoreModel() {
        super((Function)RenderType::func_228644_e_, 0.0f, 0.0f, 32, 32);
        this.spikes = new ModelRenderer[16];
        final float par1 = 0.0f;
        final float par2 = 0.0f;
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f, par1);
        this.field_78116_c.func_78793_a(0.0f, 0.0f + par2, 0.0f);
        this.field_178720_f = new ModelRenderer((Model)this, 0, 0);
        this.field_78115_e = new ModelRenderer((Model)this, 0, 0);
        this.field_178723_h = new ModelRenderer((Model)this, 0, 0);
        this.field_178724_i = new ModelRenderer((Model)this, 0, 0);
        this.field_178721_j = new ModelRenderer((Model)this, 0, 0);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 0);
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i] = new ModelRenderer((Model)this, 0, 16);
            final int spikeLength = (i % 2 == 0) ? 6 : 8;
            this.spikes[i].func_228301_a_(-1.0f, 6.0f, -1.0f, 2.0f, (float)spikeLength, 2.0f, par1);
            this.spikes[i].func_78793_a(0.0f, 4.0f + par2, 0.0f);
            final ModelRenderer cube = new ModelRenderer((Model)this, 8, 16);
            cube.func_228300_a_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
            cube.func_78793_a(0.0f, 8.0f, 0.0f);
            cube.field_78808_h = 0.7853982f;
            this.spikes[i].func_78792_a(cube);
        }
        final ImmutableList.Builder<ModelRenderer> builder = (ImmutableList.Builder<ModelRenderer>)ImmutableList.builder();
        builder.addAll((Iterable)Arrays.asList(this.spikes));
        this.parts = (ImmutableList<ModelRenderer>)builder.build();
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)this.parts;
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        this.func_225602_a_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, alpha));
        this.func_225600_b_().forEach(renderer -> renderer.func_228309_a_(stack, builder, light, overlay, red, green, blue, this.alive ? 0.6f : alpha));
    }
    
    public void setLivingAnimations(final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.alive = entity.func_70089_S();
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].field_78796_g = (entity.field_70173_aa + partialTicks) / 5.0f;
            this.spikes[i].field_78795_f = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            this.spikes[i].field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            final ModelRenderer modelRenderer = this.spikes[i];
            modelRenderer.field_78795_f += i * 5;
            final ModelRenderer modelRenderer2 = this.spikes[i];
            modelRenderer2.field_78796_g += i * 2.5f;
            final ModelRenderer modelRenderer3 = this.spikes[i];
            modelRenderer3.field_78808_h += i * 3;
            this.spikes[i].field_78800_c = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / i) * 3.0f;
            this.spikes[i].field_78797_d = 5.0f + MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / i) * 3.0f;
            this.spikes[i].field_78798_e = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / i) * 3.0f;
            ((ModelRenderer)this.spikes[i].field_78805_m.get(0)).field_78797_d = 10.0f + MathHelper.func_76126_a((i + entity.field_70173_aa + partialTicks) / i) * 3.0f;
        }
    }
}
