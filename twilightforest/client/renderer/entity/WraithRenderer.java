// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.WraithModel;
import twilightforest.entity.WraithEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;

public class WraithRenderer extends BipedRenderer<WraithEntity, WraithModel>
{
    private static final ResourceLocation textureWraith;
    
    public WraithRenderer(final EntityRendererManager manager, final WraithModel modelbiped, final float shadowSize) {
        super(manager, (BipedModel)modelbiped, shadowSize);
    }
    
    @Nullable
    protected RenderType func_230496_a_(final WraithEntity entity, final boolean p_230496_2_, final boolean p_230496_3_, final boolean p_230496_4_) {
        return RenderType.func_228644_e_(this.getEntityTexture(entity));
    }
    
    public ResourceLocation getEntityTexture(final WraithEntity wraith) {
        return WraithRenderer.textureWraith;
    }
    
    static {
        textureWraith = TwilightForestMod.getModelTexture("ghost.png");
    }
}
