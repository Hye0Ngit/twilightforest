// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.client.model.EntityModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.SlimeModel;
import twilightforest.entity.monster.MazeSlime;
import net.minecraft.client.renderer.entity.MobRenderer;

public class MazeSlimeRenderer extends MobRenderer<MazeSlime, SlimeModel<MazeSlime>>
{
    private static final ResourceLocation textureLoc;
    
    public MazeSlimeRenderer(final EntityRendererProvider.Context manager, final float shadowSize) {
        super(manager, (EntityModel)new SlimeModel(manager.m_174023_(TFModelLayers.MAZE_SLIME)), shadowSize);
        this.m_115326_((RenderLayer)new SlimeOuterLayer((RenderLayerParent)this, manager.m_174027_()));
    }
    
    public void render(final MazeSlime entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int packedLightIn) {
        this.f_114477_ = 0.25f * entityIn.m_33632_();
        if (((SlimeModel)this.f_115290_).f_102609_) {
            matrixStackIn.m_85837_(0.0, 0.25, 0.0);
        }
        super.m_7392_((Mob)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    protected void scale(final MazeSlime p_115983_, final PoseStack p_115984_, final float p_115985_) {
        p_115984_.m_85841_(0.999f, 0.999f, 0.999f);
        p_115984_.m_85837_(0.0, 0.0010000000474974513, 0.0);
        final float var5 = (float)p_115983_.m_33632_();
        final float var6 = Mth.m_14179_(p_115985_, p_115983_.f_33585_, p_115983_.f_33584_) / (var5 * 0.5f + 1.0f);
        final float var7 = 1.0f / (var6 + 1.0f);
        p_115984_.m_85841_(var7 * var5, 1.0f / var7 * var5, var7 * var5);
    }
    
    public ResourceLocation getTextureLocation(final MazeSlime entity) {
        return MazeSlimeRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("mazeslime.png");
    }
}
