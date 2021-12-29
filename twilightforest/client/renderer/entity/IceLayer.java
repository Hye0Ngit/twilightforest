// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import com.mojang.math.Vector3f;
import twilightforest.potions.FrostedEffect;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import java.util.Random;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;

public class IceLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M>
{
    private final Random random;
    
    public IceLayer(final RenderLayerParent<T, M> renderer) {
        super((RenderLayerParent)renderer);
        this.random = new Random();
    }
    
    public void render(final PoseStack stack, final MultiBufferSource buffer, final int light, final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        if (entity.m_21051_(Attributes.f_22279_).m_22111_(FrostedEffect.MODIFIER_UUID) == null) {
            return;
        }
        this.random.setSeed(entity.m_142049_() * entity.m_142049_() * 3121 + entity.m_142049_() * 45238971);
        for (int numCubes = (int)(entity.m_20206_() / 0.4f), i = 0; i < numCubes; ++i) {
            stack.m_85836_();
            final float dx = (float)(this.random.nextGaussian() * 0.20000000298023224 * entity.m_20205_());
            final float dy = (float)(this.random.nextGaussian() * 0.20000000298023224 * entity.m_20206_()) + entity.m_20206_() / 2.0f;
            final float dz = (float)(this.random.nextGaussian() * 0.20000000298023224 * entity.m_20205_());
            stack.m_85837_((double)dx, (double)dy, (double)dz);
            stack.m_85841_(0.5f, 0.5f, 0.5f);
            stack.m_85845_(Vector3f.f_122223_.m_122240_(this.random.nextFloat() * 360.0f));
            stack.m_85845_(Vector3f.f_122225_.m_122240_(this.random.nextFloat() * 360.0f));
            stack.m_85845_(Vector3f.f_122227_.m_122240_(this.random.nextFloat() * 360.0f));
            stack.m_85837_(-0.5, -0.5, -0.5);
            Minecraft.m_91087_().m_91289_().renderSingleBlock(Blocks.f_50126_.m_49966_(), stack, buffer, light, OverlayTexture.f_118083_, (IModelData)EmptyModelData.INSTANCE);
            stack.m_85849_();
        }
    }
}
