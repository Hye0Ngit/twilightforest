// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import twilightforest.client.model.TFModelLayers;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.SlimeBeetleModel;
import twilightforest.entity.monster.SlimeBeetle;
import net.minecraft.client.renderer.entity.MobRenderer;

public class SlimeBeetleRenderer extends MobRenderer<SlimeBeetle, SlimeBeetleModel>
{
    private static final ResourceLocation textureLoc;
    
    public SlimeBeetleRenderer(final EntityRendererProvider.Context manager, final SlimeBeetleModel model, final float shadowSize) {
        super(manager, (EntityModel)model, shadowSize);
        this.m_115326_((RenderLayer)new LayerInner((RenderLayerParent<SlimeBeetle, SlimeBeetleModel>)this, manager));
    }
    
    public void render(final SlimeBeetle entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int packedLightIn) {
        if (((SlimeBeetleModel)this.f_115290_).f_102609_) {
            matrixStackIn.m_85837_(0.0, -0.5, 0.0);
        }
        super.m_7392_((Mob)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    public ResourceLocation getTextureLocation(final SlimeBeetle entity) {
        return SlimeBeetleRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("slimebeetle.png");
    }
    
    static class LayerInner extends RenderLayer<SlimeBeetle, SlimeBeetleModel>
    {
        private final SlimeBeetleModel innerModel;
        
        public LayerInner(final RenderLayerParent<SlimeBeetle, SlimeBeetleModel> renderer, final EntityRendererProvider.Context manager) {
            super((RenderLayerParent)renderer);
            this.innerModel = new SlimeBeetleModel(manager.m_174023_(TFModelLayers.SLIME_BEETLE_TAIL));
        }
        
        public void render(final PoseStack ms, final MultiBufferSource buffers, final int light, final SlimeBeetle entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            if (!entity.m_20145_()) {
                this.innerModel.m_102624_(this.m_117386_());
                this.innerModel.m_6839_((Entity)entity, limbSwing, limbSwingAmount, partialTicks);
                this.innerModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                final VertexConsumer buffer = buffers.m_6299_(RenderType.m_110473_(this.m_117347_((Entity)entity)));
                this.innerModel.renderTail(ms, buffer, light, LivingEntityRenderer.m_115338_((LivingEntity)entity, 0.0f), 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }
}
