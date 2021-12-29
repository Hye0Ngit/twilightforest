// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.entity.ModelTFSnowGuardian;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFSnowGuardian;

public class RenderTFSnowGuardian extends RenderTFBiped<EntityTFSnowGuardian>
{
    public RenderTFSnowGuardian(final RenderManager manager) {
        super(manager, new ModelTFSnowGuardian(), 0.25f, "textures/entity/zombie/zombie.png");
        this.func_177094_a((LayerRenderer)new LayerBipedArmor((RenderLivingBase)this));
    }
    
    protected void preRenderCallback(final EntityTFSnowGuardian entity, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        GlStateManager.func_179109_b(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
    }
}
