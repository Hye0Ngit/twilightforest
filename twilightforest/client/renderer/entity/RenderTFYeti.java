// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;

public class RenderTFYeti extends RenderTFBiped<EntityLiving>
{
    public RenderTFYeti(final RenderManager manager, final ModelBiped modelBiped, final float shadowSize, final String textureName) {
        super(manager, modelBiped, shadowSize, textureName);
    }
    
    protected void preRenderCallback(final EntityLiving living, final float partialTicks) {
        final float scale = 1.0f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
}
