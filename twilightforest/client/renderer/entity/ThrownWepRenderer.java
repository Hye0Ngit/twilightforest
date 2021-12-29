// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.Minecraft;
import com.mojang.math.Vector3f;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.entity.projectile.ThrownWep;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class ThrownWepRenderer extends EntityRenderer<ThrownWep>
{
    public ThrownWepRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
    }
    
    public void render(final ThrownWep entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        stack.m_85836_();
        final float spin = (entity.f_19797_ + partialTicks) * -10.0f + 90.0f;
        stack.m_85841_(1.25f, 1.25f, 1.25f);
        this.renderDroppedItem(stack, buffer, light, entity.getItem(), yaw, spin);
        stack.m_85849_();
    }
    
    private void renderDroppedItem(final PoseStack matrix, final MultiBufferSource buffer, final int light, final ItemStack stack, final float rotation, final float spin) {
        matrix.m_85836_();
        final float f9 = 0.5f;
        final float f10 = 0.25f;
        matrix.m_85845_(Vector3f.f_122225_.m_122240_(rotation + 270.0f));
        matrix.m_85845_(Vector3f.f_122227_.m_122240_(spin));
        final float f11 = 0.0625f;
        final float f12 = 0.021875f;
        matrix.m_85837_((double)(-f9), (double)(-f10), (double)(-(f11 + f12)));
        matrix.m_85837_(0.0, 0.0, (double)(f11 + f12));
        Minecraft.m_91087_().m_91291_().m_174269_(stack, ItemTransforms.TransformType.GROUND, light, OverlayTexture.f_118083_, matrix, buffer, 0);
        matrix.m_85849_();
    }
    
    public ResourceLocation getTextureLocation(final ThrownWep entity) {
        return TextureAtlas.f_118259_;
    }
}
