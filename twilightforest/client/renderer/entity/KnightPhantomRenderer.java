// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.KnightPhantomModel;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

public class KnightPhantomRenderer extends HumanoidMobRenderer<KnightPhantom, KnightPhantomModel>
{
    private static final ResourceLocation PHANTOM_TEXTURE;
    
    public KnightPhantomRenderer(final EntityRendererProvider.Context manager, final KnightPhantomModel model, final float shadowSize) {
        super(manager, (HumanoidModel)model, shadowSize);
        this.m_115326_((RenderLayer)new ItemInHandLayer((RenderLayerParent)this));
        this.m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, (HumanoidModel)new KnightPhantomModel(manager.m_174023_(ModelLayers.f_171164_)), (HumanoidModel)new KnightPhantomModel(manager.m_174023_(ModelLayers.f_171165_))));
    }
    
    public ResourceLocation getTextureLocation(final KnightPhantom entity) {
        return KnightPhantomRenderer.PHANTOM_TEXTURE;
    }
    
    protected void scale(final KnightPhantom entity, final PoseStack stack, final float partialTicks) {
        final float scale = entity.isChargingAtPlayer() ? 1.8f : 1.2f;
        stack.m_85841_(scale, scale, scale);
    }
    
    static {
        PHANTOM_TEXTURE = TwilightForestMod.getModelTexture("phantomskeleton.png");
    }
}
