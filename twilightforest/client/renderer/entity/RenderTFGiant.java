// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFGiantMiner;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFGiant extends RenderBiped<EntityTFGiantMiner>
{
    private boolean typeCache;
    
    public RenderTFGiant(final RenderManager manager) {
        super(manager, (ModelBiped)new ModelPlayer(0.0f, false), 1.8f);
        this.typeCache = false;
        this.func_177094_a((LayerRenderer)new LayerBipedArmor((RenderLivingBase)this));
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFGiantMiner entity) {
        final Minecraft mc = Minecraft.func_71410_x();
        boolean type = false;
        ResourceLocation texture = DefaultPlayerSkin.func_177335_a();
        if (mc.func_175606_aa() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer client = (AbstractClientPlayer)mc.func_175606_aa();
            texture = client.func_110306_p();
            type = client.func_175154_l().equals("slim");
        }
        if (type != this.typeCache) {
            this.typeCache = type;
            this.field_77045_g = (ModelBase)new ModelPlayer(0.0f, type);
        }
        return texture;
    }
    
    protected void preRenderCallback(final EntityTFGiantMiner entity, final float partialTicks) {
        final float scale = 4.0f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
}
