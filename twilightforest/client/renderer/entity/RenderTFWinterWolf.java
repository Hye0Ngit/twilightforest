// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderWolf;

public class RenderTFWinterWolf extends RenderWolf
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFWinterWolf(final RenderManager manager) {
        super(manager);
        this.field_76989_e = 1.0f;
    }
    
    protected void preRenderCallback(final EntityWolf entity, final float partialTicks) {
        final float wolfScale = 1.9f;
        GlStateManager.func_179152_a(wolfScale, wolfScale, wolfScale);
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        return -1;
    }
    
    protected ResourceLocation func_110775_a(final EntityWolf entity) {
        return RenderTFWinterWolf.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("winterwolf.png");
    }
}
