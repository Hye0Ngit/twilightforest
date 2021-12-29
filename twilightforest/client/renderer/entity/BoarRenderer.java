// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.BoarModel;
import twilightforest.entity.passive.Boar;
import net.minecraft.client.renderer.entity.MobRenderer;

public class BoarRenderer extends MobRenderer<Boar, BoarModel<Boar>>
{
    private static final ResourceLocation textureLoc;
    
    public BoarRenderer(final EntityRendererProvider.Context manager, final BoarModel<Boar> model) {
        super(manager, (EntityModel)model, 0.7f);
    }
    
    public ResourceLocation getTextureLocation(final Boar entity) {
        return BoarRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("wildboar.png");
    }
}
