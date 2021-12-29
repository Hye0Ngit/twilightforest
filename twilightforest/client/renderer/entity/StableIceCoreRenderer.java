// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.StableIceCoreModel;
import twilightforest.entity.monster.StableIceCore;

public class StableIceCoreRenderer extends TFGenericMobRenderer<StableIceCore, StableIceCoreModel>
{
    public StableIceCoreRenderer(final EntityRendererProvider.Context manager, final StableIceCoreModel model) {
        super(manager, (EntityModel)model, 0.4f, "iceshooter.png");
    }
    
    protected void scale(final StableIceCore entity, final PoseStack stack, final float partialTicks) {
        final float bounce = entity.f_19797_ + partialTicks;
        stack.m_85837_(0.0, (double)(Mth.m_14031_(bounce * 0.2f) * 0.15f), 0.0);
    }
}
