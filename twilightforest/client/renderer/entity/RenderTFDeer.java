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
import twilightforest.entity.passive.EntityTFDeer;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFDeer extends RenderLiving<EntityTFDeer>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFDeer(final RenderManager manager, final ModelBase model, final float shadowSize) {
        super(manager, model, shadowSize);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFDeer entity) {
        return RenderTFDeer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("wilddeer.png");
    }
}
