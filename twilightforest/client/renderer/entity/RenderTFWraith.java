// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFWraith;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFWraith extends RenderBiped<EntityTFWraith>
{
    private static final ResourceLocation textureWraith;
    private static final ResourceLocation textureCrown;
    
    public RenderTFWraith(final RenderManager manager, final ModelBiped modelbiped, final float shadowSize) {
        super(manager, modelbiped, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerWraith());
    }
    
    protected ResourceLocation getEntityTexture(@Nonnull final EntityTFWraith wraith) {
        return RenderTFWraith.textureCrown;
    }
    
    static {
        textureWraith = TwilightForestMod.getModelTexture("ghost.png");
        textureCrown = TwilightForestMod.getModelTexture("ghost-crown.png");
    }
    
    class LayerWraith implements LayerRenderer<EntityTFWraith>
    {
        public void doRenderLayer(@Nonnull final EntityTFWraith wraith, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
            RenderTFWraith.this.func_110776_a(RenderTFWraith.textureWraith);
            GlStateManager.func_187408_a(GlStateManager.Profile.TRANSPARENT_MODEL);
            RenderTFWraith.this.field_77045_g.func_78088_a((Entity)wraith, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.func_187440_b(GlStateManager.Profile.TRANSPARENT_MODEL);
        }
        
        public boolean func_177142_b() {
            return false;
        }
    }
}
