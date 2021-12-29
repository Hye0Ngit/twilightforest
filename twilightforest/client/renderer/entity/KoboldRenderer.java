// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.util.HandSide;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.KoboldModel;
import twilightforest.entity.KoboldEntity;

public class KoboldRenderer extends TFBipedRenderer<KoboldEntity, KoboldModel>
{
    public KoboldRenderer(final EntityRendererManager manager, final KoboldModel modelBiped, final float shadowSize, final String textureName) {
        super(manager, modelBiped, shadowSize, textureName);
        this.field_177097_h.removeIf(r -> r instanceof net.minecraft.client.renderer.entity.layers.HeldItemLayer);
        this.func_177094_a((LayerRenderer)new HeldItemLayer((IEntityRenderer<KoboldEntity, KoboldModel>)this));
    }
    
    private static class HeldItemLayer extends LayerRenderer<KoboldEntity, KoboldModel>
    {
        public HeldItemLayer(final IEntityRenderer<KoboldEntity, KoboldModel> renderer) {
            super((IEntityRenderer)renderer);
        }
        
        public void render(final MatrixStack ms, final IRenderTypeBuffer buffers, final int light, final KoboldEntity living, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            final boolean flag = living.func_184591_cq() == HandSide.RIGHT;
            final ItemStack itemstack = flag ? living.func_184592_cb() : living.func_184614_ca();
            final ItemStack itemstack2 = flag ? living.func_184614_ca() : living.func_184592_cb();
            if (!itemstack.func_190926_b() || !itemstack2.func_190926_b()) {
                ms.func_227860_a_();
                if (((KoboldModel)this.func_215332_c()).field_217114_e) {
                    final float f = 0.5f;
                    ms.func_227861_a_(0.0, 0.75, 0.0);
                    ms.func_227862_a_(0.5f, 0.5f, 0.5f);
                }
                ms.func_227861_a_(0.0, 0.0, 0.25);
                this.renderItem((LivingEntity)living, itemstack2, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HandSide.RIGHT, ms, buffers, light);
                this.renderItem((LivingEntity)living, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HandSide.LEFT, ms, buffers, light);
                ms.func_227865_b_();
            }
        }
        
        private void renderItem(final LivingEntity entity, final ItemStack stack, final ItemCameraTransforms.TransformType transform, final HandSide handSide, final MatrixStack ms, final IRenderTypeBuffer buffers, final int light) {
            if (!stack.func_190926_b()) {
                ms.func_227860_a_();
                ((IHasArm)this.func_215332_c()).func_225599_a_(handSide, ms);
                ms.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(-90.0f));
                ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f));
                final boolean flag = handSide == HandSide.LEFT;
                ms.func_227861_a_((double)((flag ? -1 : 1) / 16.0f), 0.125, -0.625);
                Minecraft.func_71410_x().func_175597_ag().func_228397_a_(entity, stack, transform, flag, ms, buffers, light);
                ms.func_227865_b_();
            }
        }
    }
}
