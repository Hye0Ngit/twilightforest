// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.QuestRamModel;
import twilightforest.entity.passive.QuestRam;
import net.minecraft.client.renderer.entity.MobRenderer;

public class QuestRamRenderer extends MobRenderer<QuestRam, QuestRamModel>
{
    private static final ResourceLocation textureLoc;
    private static final ResourceLocation textureLocLines;
    
    public QuestRamRenderer(final EntityRendererProvider.Context manager, final QuestRamModel model) {
        super(manager, (EntityModel)model, 1.0f);
        this.m_115326_((RenderLayer)new LayerGlowingLines((RenderLayerParent<QuestRam, QuestRamModel>)this));
    }
    
    public ResourceLocation getTextureLocation(final QuestRam entity) {
        return QuestRamRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("questram.png");
        textureLocLines = TwilightForestMod.getModelTexture("questram_lines.png");
    }
    
    class LayerGlowingLines extends RenderLayer<QuestRam, QuestRamModel>
    {
        public LayerGlowingLines(final RenderLayerParent<QuestRam, QuestRamModel> renderer) {
            super((RenderLayerParent)renderer);
        }
        
        public void render(final PoseStack stack, final MultiBufferSource buffer, final int i, final QuestRam entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            final VertexConsumer builder = buffer.m_6299_(RenderType.m_110473_(QuestRamRenderer.textureLocLines));
            stack.m_85841_(1.025f, 1.025f, 1.025f);
            ((QuestRamModel)QuestRamRenderer.this.m_7200_()).m_7695_(stack, builder, 15728880, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
