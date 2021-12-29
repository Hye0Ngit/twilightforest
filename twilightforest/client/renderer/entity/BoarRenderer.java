// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.BoarModel;
import twilightforest.entity.passive.BoarEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class BoarRenderer extends MobRenderer<BoarEntity, BoarModel<BoarEntity>>
{
    private static final ResourceLocation textureLoc;
    
    public BoarRenderer(final EntityRendererManager manager, final BoarModel<BoarEntity> model) {
        super(manager, (EntityModel)new BoarModel(), 0.7f);
    }
    
    public ResourceLocation getEntityTexture(final BoarEntity entity) {
        return BoarRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("wildboar.png");
    }
}
