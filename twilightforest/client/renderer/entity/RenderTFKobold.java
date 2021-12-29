// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFKobold;

public class RenderTFKobold extends RenderTFBiped<EntityTFKobold>
{
    public RenderTFKobold(final RenderManager manager, final ModelBiped modelBiped, final float shadowSize, final String textureName) {
        super(manager, modelBiped, shadowSize, textureName);
        this.func_177094_a((LayerRenderer)new LayerHeldItem((RenderLivingBase)this));
    }
    
    protected void func_82422_c() {
        GlStateManager.func_179109_b(0.0f, 0.01875f, 0.0f);
    }
}
