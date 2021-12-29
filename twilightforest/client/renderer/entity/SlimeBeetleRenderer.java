// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.RenderType;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.SlimeBeetleModel;
import twilightforest.entity.SlimeBeetleEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class SlimeBeetleRenderer extends MobRenderer<SlimeBeetleEntity, SlimeBeetleModel>
{
    private static final ResourceLocation textureLoc;
    
    public SlimeBeetleRenderer(final EntityRendererManager manager, final SlimeBeetleModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerInner((IEntityRenderer<SlimeBeetleEntity, SlimeBeetleModel>)this));
    }
    
    public void render(final SlimeBeetleEntity entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        if (((SlimeBeetleModel)this.field_77045_g).field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, -0.5, 0.0);
        }
        super.func_225623_a_((MobEntity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    public ResourceLocation getEntityTexture(final SlimeBeetleEntity entity) {
        return SlimeBeetleRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("slimebeetle.png");
    }
    
    static class LayerInner extends LayerRenderer<SlimeBeetleEntity, SlimeBeetleModel>
    {
        private final SlimeBeetleModel innerModel;
        
        public LayerInner(final IEntityRenderer<SlimeBeetleEntity, SlimeBeetleModel> renderer) {
            super((IEntityRenderer)renderer);
            this.innerModel = new SlimeBeetleModel(true);
        }
        
        public void render(final MatrixStack ms, final IRenderTypeBuffer buffers, final int light, final SlimeBeetleEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            if (!entity.func_82150_aj()) {
                this.innerModel.func_217111_a(this.func_215332_c());
                this.innerModel.func_212843_a_((Entity)entity, limbSwing, limbSwingAmount, partialTicks);
                this.innerModel.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                final IVertexBuilder buffer = buffers.getBuffer(RenderType.func_228644_e_(this.func_229139_a_((Entity)entity)));
                this.innerModel.func_225598_a_(ms, buffer, light, LivingRenderer.func_229117_c_((LivingEntity)entity, 0.0f), 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }
}
