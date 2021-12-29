// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.WraithModel;
import twilightforest.entity.monster.Wraith;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

public class WraithRenderer extends HumanoidMobRenderer<Wraith, WraithModel>
{
    private static final ResourceLocation textureWraith;
    
    public WraithRenderer(final EntityRendererProvider.Context manager, final WraithModel modelbiped, final float shadowSize) {
        super(manager, (HumanoidModel)modelbiped, shadowSize);
    }
    
    @Nullable
    protected RenderType getRenderType(final Wraith entity, final boolean p_230496_2_, final boolean p_230496_3_, final boolean p_230496_4_) {
        return RenderType.m_110473_(this.getTextureLocation(entity));
    }
    
    public ResourceLocation getTextureLocation(final Wraith wraith) {
        return WraithRenderer.textureWraith;
    }
    
    static {
        textureWraith = TwilightForestMod.getModelTexture("ghost.png");
    }
}
