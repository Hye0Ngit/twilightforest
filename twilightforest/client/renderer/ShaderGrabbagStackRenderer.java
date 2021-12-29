// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.IItemProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.ResourceLocation;
import com.mojang.blaze3d.systems.RenderSystem;
import twilightforest.client.shader.ShaderManager;
import net.minecraft.client.renderer.Tessellator;
import twilightforest.client.TFClientEvents;
import twilightforest.TFConfig;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import twilightforest.TwilightForestMod;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class ShaderGrabbagStackRenderer extends TileEntityRenderer<DummyTile>
{
    public static ItemStack stack;
    private final ItemCameraTransforms.TransformType transform;
    
    public ShaderGrabbagStackRenderer(final TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        this.transform = ItemCameraTransforms.TransformType.NONE;
    }
    
    public void render(final DummyTile tileEntityIn, final float partialTicks, final MatrixStack ms, final IRenderTypeBuffer buffers, final int light, final int overlay) {
        ms.func_227860_a_();
        GlStateManager.func_227605_A_();
        final ModelResourceLocation silver_back = new ModelResourceLocation(TwilightForestMod.prefix("trophy_minor"), "inventory");
        final ModelResourceLocation shaderCase = new ModelResourceLocation(TwilightForestMod.prefix("shader"), "inventory");
        final ResourceLocation bg = TwilightForestMod.prefix("textures/items/star_burst_mask.png");
        final IBakedModel modelBack = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(silver_back);
        final IBakedModel modelCase = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(shaderCase);
        if (this.transform == ItemCameraTransforms.TransformType.GUI) {
            ms.func_227860_a_();
            ms.func_227861_a_(0.5, 0.5, -1.5);
            Minecraft.func_71410_x().func_175599_af().func_229111_a_(ShaderGrabbagStackRenderer.stack, ItemCameraTransforms.TransformType.GUI, false, ms, buffers, light, overlay, ForgeHooksClient.handleCameraTransforms(ms, modelBack, this.transform, false));
            ms.func_227865_b_();
            ms.func_227861_a_(0.5, 0.5, 0.0);
            ms.func_227863_a_(Vector3f.field_229181_d_.func_229193_c_(((boolean)TFConfig.CLIENT_CONFIG.rotateTrophyHeadsGui.get()) ? TFClientEvents.rotationTicker : 0.0f));
            ms.func_227860_a_();
            ms.func_227861_a_(0.5, 0.5, 0.5);
            Minecraft.func_71410_x().func_175599_af().func_229111_a_(ShaderGrabbagStackRenderer.stack, this.transform, false, ms, buffers, light, overlay, ForgeHooksClient.handleCameraTransforms(ms, modelCase, this.transform, false));
            ms.func_227865_b_();
            ms.func_227865_b_();
            ms.func_227860_a_();
            ms.func_227860_a_();
            ms.func_227861_a_(0.5, 0.5, -1.0);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder buffer = tessellator.func_178180_c();
            Minecraft.func_71410_x().func_110434_K().func_110577_a(bg);
            final int c = ShaderGrabbagStackRenderer.stack.func_77953_t().field_77937_e.func_211163_e();
            final float r = (c >> 16 & 0xFF) / 255.0f;
            final float g = (c >> 8 & 0xFF) / 255.0f;
            final float b = (c & 0xFF) / 255.0f;
            buffer.func_225582_a_(-1.0, 1.0, 0.0).func_225583_a_(0.0f, 1.0f).func_227885_a_(r, g, b, 1.0f).func_181675_d();
            buffer.func_225582_a_(1.0, 1.0, 0.0).func_225583_a_(1.0f, 1.0f).func_227885_a_(r, g, b, 1.0f).func_181675_d();
            buffer.func_225582_a_(1.0, -1.0, 0.0).func_225583_a_(1.0f, 0.0f).func_227885_a_(r, g, b, 1.0f).func_181675_d();
            buffer.func_225582_a_(-1.0, -1.0, 0.0).func_225583_a_(0.0f, 0.0f).func_227885_a_(r, g, b, 1.0f).func_181675_d();
            ShaderManager.useShader(ShaderManager.starburstShader, ShaderManager.Uniforms.TIME);
            GlStateManager.func_227692_c_(3553, 10240, 9729);
            tessellator.func_78381_a();
            GlStateManager.func_227692_c_(3553, 10240, 9728);
            ShaderManager.releaseShader();
            RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
            ms.func_227865_b_();
        }
        else {
            Minecraft.func_71410_x().func_175599_af().func_229111_a_(ShaderGrabbagStackRenderer.stack, this.transform, false, ms, buffers, light, overlay, ForgeHooksClient.handleCameraTransforms(ms, modelCase, this.transform, false));
        }
        GlStateManager.func_227771_z_();
        ms.func_227865_b_();
    }
    
    static {
        ShaderGrabbagStackRenderer.stack = new ItemStack((IItemProvider)ForgeRegistries.ITEMS.getValue(TwilightForestMod.prefix("shader_bag_twilight")));
    }
    
    public static class DummyTile extends TileEntity
    {
        public DummyTile(final TileEntityType<?> tileEntityTypeIn) {
            super((TileEntityType)tileEntityTypeIn);
        }
    }
}
