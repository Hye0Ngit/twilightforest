// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.entity.boss.Naga;
import twilightforest.client.model.entity.legacy.NagaLegacyModel;

public class LegacyNagaRenderer<M extends NagaLegacyModel<Naga>> extends MobRenderer<Naga, M>
{
    private static final ResourceLocation textureLoc;
    
    public LegacyNagaRenderer(final EntityRendererProvider.Context manager, final M modelbase, final float shadowSize) {
        super(manager, (EntityModel)modelbase, shadowSize);
        this.m_115326_((RenderLayer)new NagaEyelidsLayer<Object, Object>((net.minecraft.client.renderer.entity.RenderLayerParent<?, ?>)this));
    }
    
    public void render(final Naga entity, final float entityYaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        super.m_7392_((Mob)entity, entityYaw, partialTicks, stack, buffer, light);
        if (!Minecraft.m_91087_().m_91104_() && entity.isDazed()) {
            final Vec3 pos = new Vec3(entity.m_20185_(), entity.m_20186_() + 3.15, entity.m_20189_()).m_82549_(new Vec3(1.5, 0.0, 0.0).m_82524_((float)Math.toRadians(entity.m_21187_().nextInt(360))));
            Minecraft.m_91087_().f_91073_.m_7106_((ParticleOptions)ParticleTypes.f_123797_, pos.f_82479_, pos.f_82480_, pos.f_82481_, 0.0, 0.0, 0.0);
        }
    }
    
    protected void scale(final Naga entity, final PoseStack stack, final float p_225620_3_) {
        super.m_7546_((LivingEntity)entity, stack, p_225620_3_);
        stack.m_85837_(0.0, 1.75, 0.0);
        stack.m_85841_(2.0f, 2.0f, 2.0f);
    }
    
    public ResourceLocation getTextureLocation(final Naga entity) {
        return LegacyNagaRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("nagahead.png");
    }
    
    public static class NagaEyelidsLayer<T extends Naga, M extends NagaLegacyModel<T>> extends RenderLayer<T, M>
    {
        private static final ResourceLocation textureLocDazed;
        
        public NagaEyelidsLayer(final RenderLayerParent<T, M> renderer) {
            super((RenderLayerParent)renderer);
        }
        
        public void render(final PoseStack stack, final MultiBufferSource buffer, final int i, final T entitylivingbaseIn, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            if (entitylivingbaseIn.isDazed()) {
                final VertexConsumer vertex = buffer.m_6299_(RenderType.m_110458_(NagaEyelidsLayer.textureLocDazed));
                ((NagaLegacyModel)this.m_117386_()).m_7695_(stack, vertex, i, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
        
        static {
            textureLocDazed = TwilightForestMod.getModelTexture("nagahead_dazed.png");
        }
    }
}
