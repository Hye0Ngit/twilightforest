// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFLich;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFLich extends RenderBiped<EntityTFLich>
{
    private static final ResourceLocation LICH_TEXTURE;
    
    public RenderTFLich(final RenderManager manager, final ModelBiped modelbiped, final float shadowSize) {
        super(manager, modelbiped, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerShields());
    }
    
    protected ResourceLocation getEntityTexture(@Nonnull final EntityTFLich entity) {
        return RenderTFLich.LICH_TEXTURE;
    }
    
    static {
        LICH_TEXTURE = TwilightForestMod.getModelTexture("twilightlich64.png");
    }
}
