// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.BoarLegacyModel;
import twilightforest.entity.passive.Boar;
import net.minecraft.client.renderer.entity.MobRenderer;

public class LegacyBoarRenderer extends MobRenderer<Boar, BoarLegacyModel<Boar>>
{
    private static final ResourceLocation textureLoc;
    
    public LegacyBoarRenderer(final EntityRendererProvider.Context manager, final BoarLegacyModel<Boar> model) {
        super(manager, (EntityModel)model, 0.7f);
    }
    
    public ResourceLocation getTextureLocation(final Boar entity) {
        return LegacyBoarRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("wildboar.png");
    }
}
