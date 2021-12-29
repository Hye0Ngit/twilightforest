// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.util.math.vector.Vector3f;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import twilightforest.entity.TFPartEntity;

public abstract class TFPartRenderer<T extends TFPartEntity<?>, M extends SegmentedModel<T>> extends EntityRenderer<T>
{
    protected final M entityModel;
    
    public TFPartRenderer(final EntityRendererManager renderManager, final M model) {
        super(renderManager);
        this.entityModel = model;
    }
    
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int light) {
        final int packedLightIn = this.field_76990_c.func_229085_a_(entityIn.getParent(), partialTicks);
        super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.func_227860_a_();
        final float f = MathHelper.func_219805_h(partialTicks, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
        final float f2 = MathHelper.func_219799_g(partialTicks, entityIn.field_70127_C, entityIn.field_70125_A);
        final float f3 = this.handleRotationFloat(entityIn, partialTicks);
        this.applyRotations(entityIn, matrixStackIn, f3, f, partialTicks);
        matrixStackIn.func_227862_a_(-1.0f, -1.0f, 1.0f);
        matrixStackIn.func_227861_a_(0.0, -1.5010000467300415, 0.0);
        final float f4 = 0.0f;
        final float f5 = 0.0f;
        this.entityModel.func_212843_a_((Entity)entityIn, f5, f4, partialTicks);
        this.entityModel.func_225597_a_((Entity)entityIn, f5, f4, f3, f, f2);
        final Minecraft minecraft = Minecraft.func_71410_x();
        final boolean flag = this.isVisible(entityIn);
        final boolean flag2 = !flag && !entityIn.func_98034_c((PlayerEntity)minecraft.field_71439_g);
        final boolean flag3 = minecraft.func_238206_b_((Entity)entityIn);
        final RenderType rendertype = this.getRenderType(entityIn, flag, flag2, flag3);
        if (rendertype != null) {
            final IVertexBuilder ivertexbuilder = bufferIn.getBuffer(rendertype);
            final int i = this.getPackedOverlay(entityIn, this.getOverlayProgress(entityIn, partialTicks));
            this.entityModel.func_225598_a_(matrixStackIn, ivertexbuilder, packedLightIn, i, 1.0f, 1.0f, 1.0f, flag2 ? 0.15f : 1.0f);
        }
        matrixStackIn.func_227865_b_();
    }
    
    protected float getOverlayProgress(final T livingEntityIn, final float partialTicks) {
        return 0.0f;
    }
    
    public int getPackedOverlay(final T livingEntityIn, final float uIn) {
        if (livingEntityIn.getParent() instanceof LivingEntity) {
            return OverlayTexture.func_229201_a_(OverlayTexture.func_229199_a_(uIn), OverlayTexture.func_229202_a_(((LivingEntity)livingEntityIn.getParent()).field_70737_aN > 0 || ((LivingEntity)livingEntityIn.getParent()).field_70725_aQ > 0));
        }
        return OverlayTexture.field_229196_a_;
    }
    
    @Nullable
    protected RenderType getRenderType(final T p_230496_1_, final boolean p_230496_2_, final boolean p_230496_3_, final boolean p_230496_4_) {
        final ResourceLocation resourcelocation = this.func_110775_a((Entity)p_230496_1_);
        if (p_230496_3_) {
            return RenderType.func_239268_f_(resourcelocation);
        }
        if (p_230496_2_) {
            return this.entityModel.func_228282_a_(resourcelocation);
        }
        return p_230496_4_ ? RenderType.func_228654_j_(resourcelocation) : null;
    }
    
    protected float handleRotationFloat(final T livingBase, final float partialTicks) {
        return livingBase.field_70173_aa + partialTicks;
    }
    
    protected void applyRotations(final T entityLiving, final MatrixStack matrixStackIn, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        if (entityLiving.deathTime > 0) {
            float f = (entityLiving.deathTime + partialTicks - 1.0f) / 20.0f * 1.6f;
            f = MathHelper.func_76129_c(f);
            if (f > 1.0f) {
                f = 1.0f;
            }
            matrixStackIn.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(f * this.getDeathMaxRotation(entityLiving)));
        }
    }
    
    protected float getDeathMaxRotation(final T entityLivingBaseIn) {
        return 90.0f;
    }
    
    protected boolean isVisible(final T livingEntityIn) {
        return !livingEntityIn.func_82150_aj();
    }
}
