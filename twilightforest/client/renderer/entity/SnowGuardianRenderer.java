// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.NoopModel;
import twilightforest.entity.monster.SnowGuardian;

public class SnowGuardianRenderer extends TFBipedRenderer<SnowGuardian, NoopModel<SnowGuardian>>
{
    public SnowGuardianRenderer(final EntityRendererProvider.Context manager, final NoopModel<SnowGuardian> model) {
        super(manager, model, new NoopModel<SnowGuardian>(manager.m_174023_(TFModelLayers.NOOP)), new NoopModel<SnowGuardian>(manager.m_174023_(TFModelLayers.NOOP)), 0.25f, "textures/entity/zombie/zombie.png");
        this.m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(manager.m_174023_(ModelLayers.f_171164_)), new HumanoidModel(manager.m_174023_(ModelLayers.f_171165_))));
    }
    
    protected void scale(final SnowGuardian entity, final PoseStack stack, final float partialTicks) {
        final float bounce = entity.f_19797_ + partialTicks;
        stack.m_85837_(0.0, (double)(Mth.m_14031_(bounce * 0.2f) * 0.15f), 0.0);
    }
}
