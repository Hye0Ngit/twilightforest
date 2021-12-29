// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.finalcastle.CastleGuardianModel;
import twilightforest.entity.finalcastle.CastleGuardianEntity;
import net.minecraft.client.renderer.entity.LivingRenderer;

public class CastleGuardianRenderer extends LivingRenderer<CastleGuardianEntity, CastleGuardianModel>
{
    private final ResourceLocation textureLoc;
    
    public CastleGuardianRenderer(final EntityRendererManager manager, final CastleGuardianModel model, final float shadowSize, final String textureName) {
        super(manager, (EntityModel)model, shadowSize);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new ResourceLocation(textureName);
        }
        else {
            this.textureLoc = TwilightForestMod.getModelTexture(textureName);
        }
    }
    
    public ResourceLocation getEntityTexture(final CastleGuardianEntity entity) {
        return this.textureLoc;
    }
}
