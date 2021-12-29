// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import twilightforest.entity.boss.NagaEntity;
import twilightforest.client.model.entity.NagaModel;

public class NagaRenderer<M extends NagaModel<NagaEntity>> extends MobRenderer<NagaEntity, M>
{
    private static final ResourceLocation textureLoc;
    private static final ResourceLocation textureLocDazed;
    private static final ResourceLocation textureLocCharging;
    
    public NagaRenderer(final EntityRendererManager manager, final M modelbase, final float shadowSize) {
        super(manager, (EntityModel)modelbase, shadowSize);
    }
    
    public void render(final NagaEntity entity, final float entityYaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        super.func_225623_a_((MobEntity)entity, entityYaw, partialTicks, stack, buffer, light);
        if (!Minecraft.func_71410_x().func_147113_T() && entity.isDazed()) {
            final Vector3d pos = new Vector3d(entity.func_226277_ct_(), entity.func_226278_cu_() + 3.15, entity.func_226281_cx_()).func_178787_e(new Vector3d(1.5, 0.0, 0.0).func_178785_b((float)Math.toRadians(entity.func_70681_au().nextInt(360))));
            Minecraft.func_71410_x().field_71441_e.func_195594_a((IParticleData)ParticleTypes.field_197614_g, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, 0.0, 0.0, 0.0);
        }
    }
    
    public ResourceLocation getEntityTexture(final NagaEntity entity) {
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
