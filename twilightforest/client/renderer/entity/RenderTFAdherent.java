// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFAdherent;

public class RenderTFAdherent extends RenderTFBiped<EntityTFAdherent>
{
    public RenderTFAdherent(final RenderManager manager, final ModelBiped modelBiped, final float shadowSize, final String textureName) {
        super(manager, modelBiped, shadowSize, textureName);
    }
    
    public void doRender(final EntityTFAdherent entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        super.func_76986_a((EntityLiving)entity, x, y, z, yaw, partialTicks);
    }
}
