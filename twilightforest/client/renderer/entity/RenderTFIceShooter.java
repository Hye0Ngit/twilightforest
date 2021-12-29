// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.entity.ModelTFIceShooter;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFIceShooter;

public class RenderTFIceShooter extends RenderTFBiped<EntityTFIceShooter>
{
    public RenderTFIceShooter(final RenderManager manager) {
        super(manager, new ModelTFIceShooter(), 0.4f, "iceshooter.png");
    }
    
    protected void preRenderCallback(final EntityTFIceShooter entity, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        GlStateManager.func_179109_b(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
    }
}
