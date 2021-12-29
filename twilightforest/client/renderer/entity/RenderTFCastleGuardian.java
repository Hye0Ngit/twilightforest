// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import javax.annotation.Nonnull;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.finalcastle.EntityTFCastleGuardian;
import net.minecraft.client.renderer.entity.RenderLivingBase;

public class RenderTFCastleGuardian extends RenderLivingBase<EntityTFCastleGuardian>
{
    private final ResourceLocation textureLoc;
    
    public RenderTFCastleGuardian(final RenderManager manager, final ModelBase model, final float shadowSize, final String textureName) {
        super(manager, model, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    protected ResourceLocation getEntityTexture(@Nonnull final EntityTFCastleGuardian entity) {
        return this.textureLoc;
    }
}
