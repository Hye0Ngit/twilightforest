// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.entity.boss.ThrownWepEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class ThrownWepRenderer extends EntityRenderer<ThrownWepEntity>
{
    public ThrownWepRenderer(final EntityRendererManager manager) {
        super(manager);
    }
    
    public void render(final ThrownWepEntity entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        stack.func_227860_a_();
        final float spin = (entity.field_70173_aa + partialTicks) * -10.0f + 90.0f;
        stack.func_227862_a_(1.25f, 1.25f, 1.25f);
        this.renderDroppedItem(stack, buffer, light, entity.getItem(), yaw, spin);
        stack.func_227865_b_();
    }
    
    private void renderDroppedItem(final MatrixStack matrix, final IRenderTypeBuffer buffer, final int light, final ItemStack stack, final float rotation, final float spin) {
        matrix.func_227860_a_();
        final float f9 = 0.5f;
        final float f10 = 0.25f;
        matrix.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(rotation + 270.0f));
        matrix.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(spin));
        final float f11 = 0.0625f;
        final float f12 = 0.021875f;
        matrix.func_227861_a_((double)(-f9), (double)(-f10), (double)(-(f11 + f12)));
        matrix.func_227861_a_(0.0, 0.0, (double)(f11 + f12));
        Minecraft.func_71410_x().func_175599_af().func_229110_a_(stack, ItemCameraTransforms.TransformType.GROUND, light, OverlayTexture.field_229196_a_, matrix, buffer);
        matrix.func_227865_b_();
    }
    
    public ResourceLocation getEntityTexture(final ThrownWepEntity entity) {
        return AtlasTexture.field_110575_b;
    }
}
