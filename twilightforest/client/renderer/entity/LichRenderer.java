// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.LichModel;
import twilightforest.entity.boss.Lich;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

public class LichRenderer extends HumanoidMobRenderer<Lich, LichModel>
{
    private static final ResourceLocation LICH_TEXTURE;
    
    public LichRenderer(final EntityRendererProvider.Context manager, final LichModel modelbiped, final float shadowSize) {
        super(manager, (HumanoidModel)modelbiped, shadowSize);
        this.m_115326_((RenderLayer)new ShieldLayer<Object, Object>((net.minecraft.client.renderer.entity.RenderLayerParent<?, ?>)this));
    }
    
    public ResourceLocation getTextureLocation(final Lich entity) {
        return LichRenderer.LICH_TEXTURE;
    }
    
    static {
        LICH_TEXTURE = TwilightForestMod.getModelTexture("twilightlich64.png");
    }
}
