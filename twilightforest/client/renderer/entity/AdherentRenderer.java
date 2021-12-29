// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.AdherentModel;
import twilightforest.entity.monster.Adherent;

public class AdherentRenderer extends TFBipedRenderer<Adherent, AdherentModel>
{
    public AdherentRenderer(final EntityRendererProvider.Context manager) {
        super(manager, new AdherentModel(manager.m_174023_(TFModelLayers.ADHERENT)), 0.625f, "adherent.png");
    }
    
    protected void scale(final Adherent e, final PoseStack ms, final float partialTicks) {
        final float bounce = e.f_19797_ + partialTicks;
        ms.m_85837_(0.0, (double)(-0.125f - Mth.m_14031_(bounce * 0.133f) * 0.1f), 0.0);
    }
}
