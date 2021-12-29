// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.entity.ModelTFQuestRam;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.passive.EntityTFQuestRam;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFQuestRam extends RenderLiving<EntityTFQuestRam>
{
    private static final ResourceLocation textureLoc;
    private static final ResourceLocation textureLocLines;
    
    public RenderTFQuestRam(final RenderManager manager) {
        super(manager, (ModelBase)new ModelTFQuestRam(), 1.0f);
        this.func_177094_a((LayerRenderer)new LayerGlowingLines());
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFQuestRam entity) {
        return RenderTFQuestRam.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("questram.png");
        textureLocLines = TwilightForestMod.getModelTexture("questram_lines.png");
    }
    
    class LayerGlowingLines implements LayerRenderer<EntityTFQuestRam>
    {
        public void doRenderLayer(final EntityTFQuestRam entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
            RenderTFQuestRam.this.func_110776_a(RenderTFQuestRam.textureLocLines);
            final float var4 = 1.0f;
            GlStateManager.func_179147_l();
            GlStateManager.func_179118_c();
            GlStateManager.func_179112_b(770, 1);
            GlStateManager.func_179152_a(1.025f, 1.025f, 1.025f);
            final char var5 = '\uf0f0';
            final int var6 = var5 % 65536;
            final int var7 = var5 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, var6 / 1.0f, var7 / 1.0f);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, var4);
            RenderTFQuestRam.this.func_177087_b().func_78088_a((Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.func_179112_b(770, 771);
        }
        
        public boolean func_177142_b() {
            return false;
        }
    }
}
