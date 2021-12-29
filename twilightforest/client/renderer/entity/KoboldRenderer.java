// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;
import com.mojang.math.Vector3f;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.client.model.entity.KoboldModel;
import twilightforest.entity.monster.Kobold;

public class KoboldRenderer extends TFBipedRenderer<Kobold, KoboldModel>
{
    public KoboldRenderer(final EntityRendererProvider.Context manager, final KoboldModel modelBiped, final float shadowSize, final String textureName) {
        super(manager, modelBiped, shadowSize, textureName);
        this.f_115291_.removeIf(r -> r instanceof ItemInHandLayer);
        this.m_115326_((RenderLayer)new HeldItemLayer((RenderLayerParent<Kobold, KoboldModel>)this));
    }
    
    private static class HeldItemLayer extends RenderLayer<Kobold, KoboldModel>
    {
        public HeldItemLayer(final RenderLayerParent<Kobold, KoboldModel> renderer) {
            super((RenderLayerParent)renderer);
        }
        
        public void render(final PoseStack ms, final MultiBufferSource buffers, final int light, final Kobold living, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            final boolean flag = living.m_5737_() == HumanoidArm.RIGHT;
            final ItemStack itemstack = flag ? living.m_21206_() : living.m_21205_();
            final ItemStack itemstack2 = flag ? living.m_21205_() : living.m_21206_();
            if (!itemstack.m_41619_() || !itemstack2.m_41619_()) {
                ms.m_85836_();
                if (((KoboldModel)this.m_117386_()).f_102610_) {
                    ms.m_85837_(0.0, 0.75, 0.0);
                    ms.m_85841_(0.5f, 0.5f, 0.5f);
                }
                this.renderItem((LivingEntity)living, itemstack2, ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT, ms, buffers, light);
                this.renderItem((LivingEntity)living, itemstack, ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT, ms, buffers, light);
                ms.m_85849_();
            }
        }
        
        private void renderItem(final LivingEntity entity, final ItemStack stack, final ItemTransforms.TransformType transform, final HumanoidArm handSide, final PoseStack ms, final MultiBufferSource buffers, final int light) {
            if (!stack.m_41619_()) {
                ms.m_85836_();
                ((KoboldModel)this.m_117386_()).m_6002_(handSide, ms);
                ms.m_85845_(Vector3f.f_122223_.m_122240_(-90.0f));
                ms.m_85845_(Vector3f.f_122225_.m_122240_(180.0f));
                final boolean flag = handSide == HumanoidArm.LEFT;
                ms.m_85837_(0.05, 0.125, -0.35);
                Minecraft.m_91087_().m_91292_().m_109322_(entity, stack, transform, flag, ms, buffers, light);
                ms.m_85849_();
            }
        }
    }
}
