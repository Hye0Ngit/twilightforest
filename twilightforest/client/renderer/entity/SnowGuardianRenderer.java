// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.NoopModel;
import twilightforest.entity.SnowGuardianEntity;

public class SnowGuardianRenderer extends TFBipedRenderer<SnowGuardianEntity, NoopModel<SnowGuardianEntity>>
{
    public SnowGuardianRenderer(final EntityRendererManager manager, final NoopModel<SnowGuardianEntity> model) {
        super(manager, model, new NoopModel<SnowGuardianEntity>(), new NoopModel<SnowGuardianEntity>(), 0.25f, "textures/entity/zombie/zombie.png");
        this.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)this, new BipedModel(0.5f), new BipedModel(1.0f)));
    }
    
    protected void preRenderCallback(final SnowGuardianEntity entity, final MatrixStack stack, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        stack.func_227861_a_(0.0, (double)(MathHelper.func_76126_a(bounce * 0.2f) * 0.15f), 0.0);
    }
}
