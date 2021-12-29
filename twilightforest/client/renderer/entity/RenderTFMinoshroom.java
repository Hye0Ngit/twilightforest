// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFMinoshroom;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFMinoshroom extends RenderBiped<EntityTFMinoshroom>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFMinoshroom(final RenderManager manager, final ModelBiped model, final float shadowSize) {
        super(manager, model, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerMinoshroomMushroom());
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFMinoshroom entity) {
        return RenderTFMinoshroom.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("minoshroomtaur.png");
    }
    
    class LayerMinoshroomMushroom implements LayerRenderer<EntityTFMinoshroom>
    {
        public void doRenderLayer(final EntityTFMinoshroom minoshroom, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
            if (!minoshroom.func_70631_g_() && !minoshroom.func_82150_aj()) {
                final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                RenderTFMinoshroom.this.func_110776_a(TextureMap.field_110575_b);
                GlStateManager.func_179089_o();
                GlStateManager.func_187407_a(GlStateManager.CullFace.FRONT);
                GlStateManager.func_179094_E();
                GlStateManager.func_179152_a(1.0f, -1.0f, 1.0f);
                GlStateManager.func_179109_b(0.2f, 0.35f, 0.5f);
                GlStateManager.func_179114_b(42.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.func_179094_E();
                GlStateManager.func_179109_b(-0.5f, -0.5f, 0.5f);
                blockrendererdispatcher.func_175016_a(Blocks.field_150337_Q.func_176223_P(), 1.0f);
                GlStateManager.func_179121_F();
                GlStateManager.func_179094_E();
                GlStateManager.func_179109_b(0.1f, 0.0f, -0.6f);
                GlStateManager.func_179114_b(42.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.func_179109_b(-0.5f, -0.5f, 0.5f);
                blockrendererdispatcher.func_175016_a(Blocks.field_150337_Q.func_176223_P(), 1.0f);
                GlStateManager.func_179121_F();
                GlStateManager.func_179121_F();
                GlStateManager.func_179094_E();
                ((ModelBiped)RenderTFMinoshroom.this.func_177087_b()).field_78116_c.func_78794_c(0.0625f);
                GlStateManager.func_179152_a(1.0f, -1.0f, 1.0f);
                GlStateManager.func_179109_b(0.0f, 1.0f, 0.0f);
                GlStateManager.func_179114_b(12.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.func_179109_b(-0.5f, -0.5f, 0.5f);
                blockrendererdispatcher.func_175016_a(Blocks.field_150337_Q.func_176223_P(), 1.0f);
                GlStateManager.func_179121_F();
                GlStateManager.func_187407_a(GlStateManager.CullFace.BACK);
                GlStateManager.func_179129_p();
            }
        }
        
        public boolean func_177142_b() {
            return false;
        }
    }
}
