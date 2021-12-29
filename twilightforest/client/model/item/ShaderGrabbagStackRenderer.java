// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.IBakedModel;
import twilightforest.client.shader.ShaderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import blusunrize.immersiveengineering.client.ClientUtils;
import twilightforest.compat.ie.ItemTFShaderGrabbag;
import net.minecraft.client.renderer.Tessellator;
import twilightforest.client.TFClientEvents;
import twilightforest.TFConfig;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ShaderGrabbagStackRenderer extends TileEntitySpecialRenderer<DummyTile>
{
    private ItemStack stack;
    private ItemCameraTransforms.TransformType transform;
    private final ResourceLocation bg;
    private final ModelResourceLocation backModelLocation;
    private final ModelResourceLocation caseModelLocation;
    private final ModelResourceLocation itemModelLocation;
    
    public ShaderGrabbagStackRenderer(final ModelResourceLocation itemModelLocation) {
        this.stack = ItemStack.field_190927_a;
        this.transform = ItemCameraTransforms.TransformType.NONE;
        this.bg = new ResourceLocation("twilightforest", "textures/items/star_burst_mask.png");
        this.backModelLocation = new ModelResourceLocation("twilightforest:trophy_minor", "inventory");
        this.caseModelLocation = new ModelResourceLocation("twilightforest:shader", "inventory");
        this.itemModelLocation = itemModelLocation;
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onModelBake(final ModelBakeEvent event) {
        event.getModelRegistry().func_82595_a((Object)this.itemModelLocation, (Object)new BakedModel());
    }
    
    public void render(final DummyTile te, final double x, final double y, final double z, final float partialTicks, final int destroyStage, final float alpha) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179129_p();
        final IBakedModel modelCase = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(this.caseModelLocation);
        if (this.transform == ItemCameraTransforms.TransformType.GUI) {
            final IBakedModel modelBack = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(this.backModelLocation);
            GlStateManager.func_179140_f();
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(0.5f, 0.5f, -1.5f);
            Minecraft.func_71410_x().func_175599_af().func_180454_a(this.stack, ForgeHooksClient.handleCameraTransforms(modelBack, this.transform, false));
            GlStateManager.func_179121_F();
            GlStateManager.func_179145_e();
            GlStateManager.func_179140_f();
            GlStateManager.func_179109_b(0.5f, 0.5f, 0.0f);
            GlStateManager.func_179114_b(TFConfig.rotateTrophyHeadsGui ? TFClientEvents.rotationTicker : 0.0f, 0.125f, 1.0f, 0.125f);
        }
        GlStateManager.func_179094_E();
        if (this.transform != ItemCameraTransforms.TransformType.GUI) {
            GlStateManager.func_179109_b(0.5f, 0.5f, 0.5f);
        }
        else {
            GlStateManager.func_179152_a(0.9f, 0.9f, 0.9f);
        }
        Minecraft.func_71410_x().func_175599_af().func_180454_a(this.stack, ForgeHooksClient.handleCameraTransforms(modelCase, this.transform, false));
        GlStateManager.func_179121_F();
        if (this.transform == ItemCameraTransforms.TransformType.GUI) {
            GlStateManager.func_179145_e();
            GlStateManager.func_179121_F();
            GlStateManager.func_179094_E();
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(0.5f, 0.5f, -1.0f);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder buffer = tessellator.func_178180_c();
            Minecraft.func_71410_x().func_110434_K().func_110577_a(this.bg);
            final int c = ClientUtils.getFormattingColour(ItemTFShaderGrabbag.shader_bag.func_77613_e(this.stack).field_77937_e);
            final float r = (c >> 16 & 0xFF) / 255.0f;
            final float g = (c >> 8 & 0xFF) / 255.0f;
            final float b = (c & 0xFF) / 255.0f;
            buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
            buffer.func_181662_b(x - 1.0, y + 1.0, 0.0).func_187315_a(0.0, 1.0).func_181666_a(r, g, b, 1.0f).func_181675_d();
            buffer.func_181662_b(x + 1.0, y + 1.0, 0.0).func_187315_a(1.0, 1.0).func_181666_a(r, g, b, 1.0f).func_181675_d();
            buffer.func_181662_b(x + 1.0, y - 1.0, 0.0).func_187315_a(1.0, 0.0).func_181666_a(r, g, b, 1.0f).func_181675_d();
            buffer.func_181662_b(x - 1.0, y - 1.0, 0.0).func_187315_a(0.0, 0.0).func_181666_a(r, g, b, 1.0f).func_181675_d();
            ShaderManager.useShader(ShaderManager.starburstShader, ShaderManager.Uniforms.TIME);
            GlStateManager.func_187421_b(3553, 10240, 9729);
            tessellator.func_78381_a();
            GlStateManager.func_187421_b(3553, 10240, 9728);
            ShaderManager.releaseShader();
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179121_F();
        }
        GlStateManager.func_179089_o();
        GlStateManager.func_179121_F();
    }
    
    public static class DummyTile extends TileEntity
    {
    }
    
    private class BakedModel extends BuiltInItemModel
    {
        BakedModel() {
            super("minecraft:blocks/iron_block");
        }
        
        @Override
        protected void setItemStack(final ItemStack stack) {
            ShaderGrabbagStackRenderer.this.stack = stack;
        }
        
        @Override
        protected void setTransform(final ItemCameraTransforms.TransformType transform) {
            ShaderGrabbagStackRenderer.this.transform = transform;
        }
    }
}
