// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.KnightPhantomModel;
import twilightforest.entity.boss.KnightPhantomEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;

public class KnightPhantomRenderer extends BipedRenderer<KnightPhantomEntity, KnightPhantomModel>
{
    private static final ResourceLocation PHANTOM_TEXTURE;
    
    public KnightPhantomRenderer(final EntityRendererManager manager, final KnightPhantomModel model, final float shadowSize) {
        super(manager, (BipedModel)model, shadowSize);
        this.func_177094_a((LayerRenderer)new HeldItemLayer((IEntityRenderer)this));
        this.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)this, (BipedModel)new KnightPhantomModel(), (BipedModel)new KnightPhantomModel()));
    }
    
    public ResourceLocation getEntityTexture(final KnightPhantomEntity entity) {
        return KnightPhantomRenderer.PHANTOM_TEXTURE;
    }
    
    protected void preRenderCallback(final KnightPhantomEntity entity, final MatrixStack stack, final float partialTicks) {
        final float scale = entity.isChargingAtPlayer() ? 1.8f : 1.2f;
        stack.func_227862_a_(scale, scale, scale);
    }
    
    static {
        PHANTOM_TEXTURE = TwilightForestMod.getModelTexture("phantomskeleton.png");
    }
}
