// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.StableIceCoreModel;
import twilightforest.entity.StableIceCoreEntity;

public class StableIceCoreRenderer extends TFBipedRenderer<StableIceCoreEntity, StableIceCoreModel>
{
    public StableIceCoreRenderer(final EntityRendererManager manager, final StableIceCoreModel model) {
        super(manager, model, 0.4f, "iceshooter.png");
    }
    
    protected void preRenderCallback(final StableIceCoreEntity entity, final MatrixStack stack, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        stack.func_227861_a_(0.0, (double)(MathHelper.func_76126_a(bounce * 0.2f) * 0.15f), 0.0);
    }
}
