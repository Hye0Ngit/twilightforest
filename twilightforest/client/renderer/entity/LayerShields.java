// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.math.MathHelper;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.entity.boss.EntityTFLich;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerShields implements LayerRenderer<EntityLivingBase>
{
    private int getShieldCount(final EntityLivingBase entity) {
        EntityTFLich lich = null;
        if (entity instanceof EntityTFLich) {
            lich = (EntityTFLich)entity;
        }
        IShieldCapability cap = null;
        if (entity.hasCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null)) {
            cap = (IShieldCapability)entity.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
        }
        return (lich != null) ? lich.getShieldStrength() : ((cap != null) ? cap.shieldsLeft() : 0);
    }
    
    private void renderShields(final float scale, final EntityLivingBase entity, final float partialTicks) {
        final float rotateAngleY = (entity.field_70173_aa + partialTicks) / 5.0f;
        final float rotateAngleX = MathHelper.func_76126_a((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        final float rotateAngleZ = MathHelper.func_76134_b((entity.field_70173_aa + partialTicks) / 5.0f) / 4.0f;
        final ItemStack shieldStack = new ItemStack(TFItems.experiment_115, 1, 3);
        final IBakedModel model = Minecraft.func_71410_x().func_175599_af().func_184393_a(shieldStack, entity.field_70170_p, entity);
        final float prevX = OpenGlHelper.lastBrightnessX;
        final float prevY = OpenGlHelper.lastBrightnessY;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0f, 240.0f);
        GL11.glMaterial(1032, 5632, RenderHelper.func_74521_a(1.0f, 1.0f, 1.0f, 1.0f));
        Minecraft.func_71410_x().func_110434_K().func_110577_a(TextureMap.field_110575_b);
        for (int count = this.getShieldCount(entity), c = 0; c < count; ++c) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179114_b(rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            GlStateManager.func_179114_b(rotateAngleY * 57.295776f + c * (360.0f / count), 0.0f, 1.0f, 0.0f);
            GlStateManager.func_179114_b(rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            GlStateManager.func_179152_a(scale, -scale, scale);
            GlStateManager.func_179109_b(0.0f, 0.0f, 1.0f);
            Minecraft.func_71410_x().func_175599_af().func_180454_a(shieldStack, ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.NONE, false));
            GlStateManager.func_179121_F();
        }
        GL11.glMaterial(1032, 5632, RenderHelper.func_74521_a(0.0f, 0.0f, 0.0f, 1.0f));
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, prevX, prevY);
    }
    
    public void func_177141_a(@Nonnull final EntityLivingBase living, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        if (this.getShieldCount(living) > 0) {
            GlStateManager.func_179147_l();
            GlStateManager.func_179112_b(770, 771);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            this.renderShields(scale * 13.0f, living, partialTicks);
        }
    }
    
    public boolean func_177142_b() {
        return false;
    }
}
