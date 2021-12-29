// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.IceCrystalEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;

public class IceCrystalModel extends EntityModel<IceCrystalEntity>
{
    private final ModelRenderer[] spikes;
    private boolean alive;
    
    public IceCrystalModel() {
        super((Function)RenderType::func_228644_e_);
        this.spikes = new ModelRenderer[16];
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        final float par1 = 0.0f;
        final float par2 = 0.0f;
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i] = new ModelRenderer((Model)this, 0, 16);
            final int spikeLength = (i % 2 == 0) ? 6 : 8;
            this.spikes[i].func_228301_a_(-1.0f, -1.0f, -1.0f, 2.0f, (float)spikeLength, 2.0f, par1);
            this.spikes[i].func_78793_a(0.0f, 0.0f + par2, 0.0f);
            final ModelRenderer cube = new ModelRenderer((Model)this, 8, 16);
            cube.func_228300_a_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
            cube.func_78793_a(0.0f, (float)spikeLength, 0.0f);
            cube.field_78808_h = 0.7853982f;
            this.spikes[i].func_78792_a(cube);
        }
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        for (final ModelRenderer spike : this.spikes) {
            spike.func_228309_a_(stack, builder, light, overlay, red, green, blue, this.alive ? 0.6f : alpha);
        }
    }
    
    public void setRotationAngles(final IceCrystalEntity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void setLivingAnimations(final IceCrystalEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.alive = entity.func_70089_S();
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].field_78795_f = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            this.spikes[i].field_78796_g = (entity.field_70173_aa + partialTicks) / 5.0f;
            this.spikes[i].field_78808_h = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
            final ModelRenderer modelRenderer = this.spikes[i];
            modelRenderer.field_78795_f += (float)(i * 0.39269908169872414);
            if (i % 4 == 0) {
                final ModelRenderer modelRenderer2 = this.spikes[i];
                ++modelRenderer2.field_78796_g;
            }
            else if (i % 4 == 2) {
                final ModelRenderer modelRenderer3 = this.spikes[i];
                --modelRenderer3.field_78796_g;
            }
        }
    }
}
