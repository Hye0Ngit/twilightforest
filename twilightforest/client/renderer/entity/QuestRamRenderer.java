// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.QuestRamModel;
import twilightforest.entity.passive.QuestRamEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class QuestRamRenderer extends MobRenderer<QuestRamEntity, QuestRamModel>
{
    private static final ResourceLocation textureLoc;
    private static final ResourceLocation textureLocLines;
    
    public QuestRamRenderer(final EntityRendererManager manager, final QuestRamModel model) {
        super(manager, (EntityModel)model, 1.0f);
        this.func_177094_a((LayerRenderer)new LayerGlowingLines((IEntityRenderer<QuestRamEntity, QuestRamModel>)this));
    }
    
    public ResourceLocation getEntityTexture(final QuestRamEntity entity) {
        return QuestRamRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("questram.png");
        textureLocLines = TwilightForestMod.getModelTexture("questram_lines.png");
    }
    
    class LayerGlowingLines extends LayerRenderer<QuestRamEntity, QuestRamModel>
    {
        public LayerGlowingLines(final IEntityRenderer<QuestRamEntity, QuestRamModel> renderer) {
            super((IEntityRenderer)renderer);
        }
        
        public void render(final MatrixStack stack, final IRenderTypeBuffer buffer, final int i, final QuestRamEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            final IVertexBuilder builder = buffer.getBuffer(RenderType.func_228644_e_(QuestRamRenderer.textureLocLines));
            stack.func_227862_a_(1.025f, 1.025f, 1.025f);
            ((QuestRamModel)QuestRamRenderer.this.func_217764_d()).func_225598_a_(stack, builder, 15728880, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
