// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.LichModel;
import twilightforest.entity.boss.LichEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;

public class LichRenderer extends BipedRenderer<LichEntity, LichModel>
{
    private static final ResourceLocation LICH_TEXTURE;
    
    public LichRenderer(final EntityRendererManager manager, final LichModel modelbiped, final float shadowSize) {
        super(manager, (BipedModel)modelbiped, shadowSize);
        this.func_177094_a((LayerRenderer)new ShieldLayer<Object, Object>((net.minecraft.client.renderer.entity.IEntityRenderer<?, ?>)this));
    }
    
    public ResourceLocation getEntityTexture(final LichEntity entity) {
        return LichRenderer.LICH_TEXTURE;
    }
    
    static {
        LICH_TEXTURE = TwilightForestMod.getModelTexture("twilightlich64.png");
    }
}
