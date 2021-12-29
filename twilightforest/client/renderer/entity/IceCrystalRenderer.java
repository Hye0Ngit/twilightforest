// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.IceCrystalModel;
import twilightforest.entity.monster.IceCrystal;
import net.minecraft.client.renderer.entity.MobRenderer;

public class IceCrystalRenderer extends MobRenderer<IceCrystal, IceCrystalModel>
{
    private static final ResourceLocation textureLoc;
    
    public IceCrystalRenderer(final EntityRendererProvider.Context manager) {
        super(manager, (EntityModel)new IceCrystalModel(manager.m_174023_(TFModelLayers.ICE_CRYSTAL)), 0.25f);
    }
    
    protected void scale(final IceCrystal entity, final PoseStack stack, final float partialTicks) {
        final float bounce = entity.f_19797_ + partialTicks;
        stack.m_85837_(0.0, (double)(Mth.m_14031_(bounce * 0.2f) * 0.15f), 0.0);
    }
    
    public ResourceLocation getTextureLocation(final IceCrystal entity) {
        return IceCrystalRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("icecrystal.png");
    }
}
