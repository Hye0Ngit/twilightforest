// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.entity.ModelTFApocalypseCube;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFHarbingerCube;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFHarbingerCube extends RenderLiving<EntityTFHarbingerCube>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFHarbingerCube(final RenderManager manager) {
        super(manager, (ModelBase)new ModelTFApocalypseCube(), 1.0f);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFHarbingerCube entity) {
        return RenderTFHarbingerCube.textureLoc;
    }
    
    protected void preRenderCallback(final EntityTFHarbingerCube entity, final float partialTicks) {
        final float scale = 1.0f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("apocalypse2.png");
    }
}
