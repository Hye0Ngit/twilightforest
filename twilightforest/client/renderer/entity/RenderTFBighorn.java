// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSheep;

public class RenderTFBighorn extends RenderSheep
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFBighorn(final RenderManager manager, final ModelBase baseModel, final ModelBase coatModel, final float shadowSize) {
        super(manager);
        this.field_76989_e = shadowSize;
        this.field_77045_g = baseModel;
        this.func_177094_a((LayerRenderer)new LayerSheepWool((RenderSheep)this));
    }
    
    protected ResourceLocation func_110775_a(final EntitySheep ent) {
        return RenderTFBighorn.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("bighorn.png");
    }
}
