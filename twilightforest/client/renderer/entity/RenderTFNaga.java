// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFNaga;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFNaga extends RenderLiving<EntityTFNaga>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFNaga(final RenderManager manager, final ModelBase modelbase, final float shadowSize) {
        super(manager, modelbase, shadowSize);
        this.func_177094_a((LayerRenderer)new NagaEyelidsLayer(this));
    }
    
    public void doRender(final EntityTFNaga entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
        super.func_76986_a((EntityLiving)entity, x, y, z, entityYaw, partialTicks);
        if (!Minecraft.func_71410_x().func_147113_T() && entity.isDazed()) {
            final Vec3d pos = new Vec3d(entity.field_70165_t, entity.field_70163_u + 3.15, entity.field_70161_v).func_178787_e(new Vec3d(1.5, 0.0, 0.0).func_178785_b((float)Math.toRadians(entity.func_70681_au().nextInt(360))));
            Minecraft.func_71410_x().field_71441_e.func_175688_a(EnumParticleTypes.CRIT, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFNaga entity) {
        return RenderTFNaga.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("nagahead.png");
    }
}
