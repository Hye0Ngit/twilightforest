// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.SheepWoolLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.client.renderer.entity.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.SheepRenderer;

public class BighornRenderer extends SheepRenderer
{
    private static final ResourceLocation textureLoc;
    
    public BighornRenderer(final EntityRendererManager manager, final SheepModel<? extends SheepEntity> baseModel, final EntityModel<?> coatModel, final float shadowSize) {
        super(manager);
        this.field_76989_e = shadowSize;
        this.field_77045_g = (EntityModel)baseModel;
        this.func_177094_a((LayerRenderer)new SheepWoolLayer((IEntityRenderer)this));
    }
    
    public ResourceLocation func_110775_a(final SheepEntity ent) {
        return BighornRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("bighorn.png");
    }
}
