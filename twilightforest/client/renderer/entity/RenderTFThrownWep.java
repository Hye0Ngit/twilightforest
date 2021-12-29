// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.boss.EntityTFThrownWep;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFThrownWep extends Render<EntityTFThrownWep>
{
    public RenderTFThrownWep(final RenderManager manager) {
        super(manager);
    }
    
    public void doRender(final EntityTFThrownWep entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        final float spin = (entity.field_70173_aa + partialTicks) * -10.0f + 90.0f;
        GlStateManager.func_179109_b((float)x, (float)y, (float)z);
        GlStateManager.func_179091_B();
        GlStateManager.func_179152_a(1.25f, 1.25f, 1.25f);
        this.renderDroppedItem(entity.getItem(), yaw, spin);
        GlStateManager.func_179101_C();
        GlStateManager.func_179121_F();
    }
    
    private void renderDroppedItem(final ItemStack stack, final float rotation, final float spin) {
        GlStateManager.func_179094_E();
        final float f9 = 0.5f;
        final float f10 = 0.25f;
        GlStateManager.func_179114_b(rotation + 270.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(spin, 0.0f, 0.0f, 1.0f);
        final float f11 = 0.0625f;
        final float f12 = 0.021875f;
        GlStateManager.func_179109_b(-f9, -f10, -(f11 + f12));
        GlStateManager.func_179109_b(0.0f, 0.0f, f11 + f12);
        Minecraft.func_71410_x().func_175599_af().func_181564_a(stack, ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFThrownWep entity) {
        return TextureMap.field_110575_b;
    }
}
