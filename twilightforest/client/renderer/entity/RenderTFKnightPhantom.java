// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.entity.ModelTFKnightPhantom2;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFKnightPhantom extends RenderBiped<EntityTFKnightPhantom>
{
    private static final ResourceLocation PHANTOM_TEXTURE;
    
    public RenderTFKnightPhantom(final RenderManager manager, final ModelTFKnightPhantom2 model, final float shadowSize) {
        super(manager, (ModelBiped)model, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerHeldItem((RenderLivingBase)this));
        this.func_177094_a((LayerRenderer)new LayerBipedArmor((RenderLivingBase)this));
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFKnightPhantom entity) {
        return RenderTFKnightPhantom.PHANTOM_TEXTURE;
    }
    
    protected void preRenderCallback(final EntityTFKnightPhantom entity, final float partialTicks) {
        final float scale = entity.isChargingAtPlayer() ? 1.8f : 1.2f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
    
    static {
        PHANTOM_TEXTURE = TwilightForestMod.getModelTexture("phantomskeleton.png");
    }
}
