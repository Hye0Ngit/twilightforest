// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFHydra;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFHydra extends RenderLiving<EntityTFHydra>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFHydra(final RenderManager manager, final ModelBase modelbase, final float shadowSize) {
        super(manager, modelbase, shadowSize);
    }
    
    protected float getDeathMaxRotation(final EntityTFHydra entity) {
        return 0.0f;
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFHydra entity) {
        return RenderTFHydra.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
