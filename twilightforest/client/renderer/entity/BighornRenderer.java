// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.SheepRenderer;

public class BighornRenderer extends SheepRenderer
{
    private static final ResourceLocation textureLoc;
    
    public BighornRenderer(final EntityRendererProvider.Context manager, final SheepModel<? extends Sheep> baseModel, final EntityModel<?> coatModel, final float shadowSize) {
        super(manager);
        this.f_114477_ = shadowSize;
        this.f_115290_ = (EntityModel)baseModel;
        this.m_115326_((RenderLayer)new SheepFurLayer((RenderLayerParent)this, manager.m_174027_()));
    }
    
    public ResourceLocation m_5478_(final Sheep ent) {
        return BighornRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("bighorn.png");
    }
}
