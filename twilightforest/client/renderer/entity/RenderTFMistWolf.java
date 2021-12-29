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

public class RenderTFMistWolf extends RenderWolf
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFMistWolf(final RenderManager manager) {
        super(manager);
        this.field_76989_e = 1.0f;
    }
    
    protected void preRenderCallback(final EntityWolf entity, final float partialTicks) {
        final float wolfScale = 1.9f;
        GlStateManager.func_179152_a(wolfScale, wolfScale, wolfScale);
        GlStateManager.func_179147_l();
        GlStateManager.func_179118_c();
        GlStateManager.func_179112_b(770, 771);
        float misty = entity.func_70013_c() * 3.0f + 0.25f;
        misty = Math.min(1.0f, misty);
        final float smoky = entity.func_70013_c() * 2.0f + 0.6f;
        GlStateManager.func_179131_c(misty, misty, misty, smoky);
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        return -1;
    }
    
    protected ResourceLocation func_110775_a(final EntityWolf entity) {
        return RenderTFMistWolf.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("mistwolf.png");
    }
}
