// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.AdherentModel;
import twilightforest.entity.AdherentEntity;

public class AdherentRenderer extends TFBipedRenderer<AdherentEntity, AdherentModel>
{
    public AdherentRenderer(final EntityRendererManager manager) {
        super(manager, new AdherentModel(), new AdherentModel(), new AdherentModel(), 0.625f, "adherent.png");
    }
    
    protected void preRenderCallback(final AdherentEntity e, final MatrixStack ms, final float partialTicks) {
        final float bounce = e.field_70173_aa + partialTicks;
        ms.func_227861_a_(0.0, (double)(-0.125f - MathHelper.func_76126_a(bounce * 0.133f) * 0.1f), 0.0);
    }
}
