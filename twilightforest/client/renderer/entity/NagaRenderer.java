// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

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
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.entity.boss.Naga;
import twilightforest.client.model.entity.NagaModel;

public class NagaRenderer<M extends NagaModel<Naga>> extends MobRenderer<Naga, M>
{
    private static final ResourceLocation textureLoc;
    private static final ResourceLocation textureLocDazed;
    private static final ResourceLocation textureLocCharging;
    
    public NagaRenderer(final EntityRendererProvider.Context manager, final M modelbase, final float shadowSize) {
        super(manager, (EntityModel)modelbase, shadowSize);
    }
    
    public void render(final Naga entity, final float entityYaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        super.m_7392_((Mob)entity, entityYaw, partialTicks, stack, buffer, light);
        if (!Minecraft.m_91087_().m_91104_() && entity.isDazed()) {
            final Vec3 pos = new Vec3(entity.m_20185_(), entity.m_20186_() + 3.15, entity.m_20189_()).m_82549_(new Vec3(1.5, 0.0, 0.0).m_82524_((float)Math.toRadians(entity.m_21187_().nextInt(360))));
            Minecraft.m_91087_().f_91073_.m_7106_((ParticleOptions)ParticleTypes.f_123797_, pos.f_82479_, pos.f_82480_, pos.f_82481_, 0.0, 0.0, 0.0);
        }
    }
    
    public ResourceLocation getTextureLocation(final Naga entity) {
        if (entity.isDazed()) {
            return NagaRenderer.textureLocDazed;
        }
        if (entity.isCharging()) {
            return NagaRenderer.textureLocCharging;
        }
        return NagaRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("nagahead.png");
        textureLocDazed = TwilightForestMod.getModelTexture("nagahead_dazed.png");
        textureLocCharging = TwilightForestMod.getModelTexture("nagahead_charge.png");
    }
}
