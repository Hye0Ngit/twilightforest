// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import twilightforest.entity.monster.GiantMiner;

public class TFGiantRenderer<T extends GiantMiner> extends HumanoidMobRenderer<T, PlayerModel<T>>
{
    private final PlayerModel<T> normalModel;
    private final PlayerModel<T> slimModel;
    
    public TFGiantRenderer(final EntityRendererProvider.Context manager) {
        super(manager, (HumanoidModel)new PlayerModel(manager.m_174023_(ModelLayers.f_171162_), false), 1.8f);
        this.normalModel = (PlayerModel<T>)this.m_7200_();
        this.slimModel = (PlayerModel<T>)new PlayerModel(manager.m_174023_(ModelLayers.f_171166_), true);
        this.m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(manager.m_174023_(ModelLayers.f_171164_)), new HumanoidModel(manager.m_174023_(ModelLayers.f_171165_))));
    }
    
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int packedLightIn) {
        if (((PlayerModel)this.f_115290_).f_102609_) {
            matrixStackIn.m_85837_(0.0, -2.5, 0.0);
        }
        super.m_7392_((Mob)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    public ResourceLocation getTextureLocation(final GiantMiner entity) {
        final Minecraft mc = Minecraft.m_91087_();
        boolean slim = false;
        ResourceLocation texture = DefaultPlayerSkin.m_118626_();
        if (mc.m_91288_() instanceof final AbstractClientPlayer client) {
            texture = client.m_108560_();
            slim = client.m_108564_().equals("slim");
        }
        this.f_115290_ = (EntityModel)(slim ? this.slimModel : this.normalModel);
        return texture;
    }
    
    public void scale(final T entitylivingbaseIn, final PoseStack stack, final float partialTickTime) {
        final float scale = 4.0f;
        stack.m_85841_(scale, scale, scale);
    }
}
