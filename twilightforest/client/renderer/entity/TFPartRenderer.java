// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import com.mojang.math.Vector3f;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.model.ListModel;
import twilightforest.entity.TFPart;

public abstract class TFPartRenderer<T extends TFPart<?>, M extends ListModel<T>> extends EntityRenderer<T>
{
    protected final M entityModel;
    
    public TFPartRenderer(final EntityRendererProvider.Context renderManager, final M model) {
        super(renderManager);
        this.entityModel = model;
    }
    
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int light) {
        final int packedLightIn = this.f_114476_.m_114394_(entityIn.getParent(), partialTicks);
        super.m_7392_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.m_85836_();
        final float f = Mth.m_14189_(partialTicks, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
        final float f2 = Mth.m_14179_(partialTicks, entityIn.f_19860_, entityIn.m_146909_());
        final float f3 = this.handleRotationFloat(entityIn, partialTicks);
        this.applyRotations(entityIn, matrixStackIn, f3, f, partialTicks);
        matrixStackIn.m_85841_(-1.0f, -1.0f, 1.0f);
        matrixStackIn.m_85837_(0.0, -1.5010000467300415, 0.0);
        final float f4 = 0.0f;
        final float f5 = 0.0f;
        this.entityModel.m_6839_((Entity)entityIn, f5, f4, partialTicks);
        this.entityModel.m_6973_((Entity)entityIn, f5, f4, f3, f, f2);
        final Minecraft minecraft = Minecraft.m_91087_();
        final boolean flag = this.isVisible(entityIn);
        final boolean flag2 = !flag && !entityIn.m_20177_((Player)minecraft.f_91074_);
        final boolean flag3 = minecraft.m_91314_((Entity)entityIn);
        final RenderType rendertype = this.getRenderType(entityIn, flag, flag2, flag3);
        if (rendertype != null) {
            final VertexConsumer ivertexbuilder = bufferIn.m_6299_(rendertype);
            final int i = this.getPackedOverlay(entityIn, this.getOverlayProgress(entityIn, partialTicks));
            this.entityModel.m_7695_(matrixStackIn, ivertexbuilder, packedLightIn, i, 1.0f, 1.0f, 1.0f, flag2 ? 0.15f : 1.0f);
        }
        matrixStackIn.m_85849_();
    }
    
    protected float getOverlayProgress(final T livingEntityIn, final float partialTicks) {
        return 0.0f;
    }
    
    public int getPackedOverlay(final T livingEntityIn, final float uIn) {
        if (livingEntityIn.getParent() instanceof final LivingEntity livingEntity) {
            return OverlayTexture.m_118093_(OverlayTexture.m_118088_(uIn), OverlayTexture.m_118096_(livingEntity.f_20916_ > 0 || ((LivingEntity)livingEntityIn.getParent()).f_20919_ > 0));
        }
        return OverlayTexture.f_118083_;
    }
    
    @Nullable
    protected RenderType getRenderType(final T p_230496_1_, final boolean p_230496_2_, final boolean p_230496_3_, final boolean p_230496_4_) {
        final ResourceLocation resourcelocation = this.m_5478_((Entity)p_230496_1_);
        if (p_230496_3_) {
            return RenderType.m_110467_(resourcelocation);
        }
        if (p_230496_2_) {
            return this.entityModel.m_103119_(resourcelocation);
        }
        return p_230496_4_ ? RenderType.m_110491_(resourcelocation) : null;
    }
    
    protected float handleRotationFloat(final T livingBase, final float partialTicks) {
        return livingBase.f_19797_ + partialTicks;
    }
    
    protected void applyRotations(final T entityLiving, final PoseStack matrixStackIn, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        if (entityLiving.deathTime > 0) {
            float f = (entityLiving.deathTime + partialTicks - 1.0f) / 20.0f * 1.6f;
            f = Mth.m_14116_(f);
            if (f > 1.0f) {
                f = 1.0f;
            }
            matrixStackIn.m_85845_(Vector3f.f_122227_.m_122240_(f * this.getDeathMaxRotation(entityLiving)));
        }
    }
    
    protected float getDeathMaxRotation(final T entityLivingBaseIn) {
        return 90.0f;
    }
    
    protected boolean isVisible(final T livingEntityIn) {
        return !livingEntityIn.m_20145_();
    }
}
