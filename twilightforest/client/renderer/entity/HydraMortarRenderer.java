// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.HydraMortarModel;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.HydraMortarHead;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class HydraMortarRenderer extends EntityRenderer<HydraMortarHead>
{
    private static final ResourceLocation textureLoc;
    private final HydraMortarModel mortarModel;
    
    public HydraMortarRenderer(final EntityRendererManager manager) {
        super(manager);
        this.mortarModel = new HydraMortarModel();
        this.field_76989_e = 0.5f;
    }
    
    public void render(final HydraMortarHead mortar, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffers, final int light) {
        stack.func_227860_a_();
        if (mortar.fuse - partialTicks + 1.0f < 10.0f) {
            float f = 1.0f - (mortar.fuse - partialTicks + 1.0f) / 10.0f;
            f = MathHelper.func_76131_a(f, 0.0f, 1.0f);
            f *= f;
            f *= f;
            final float f2 = 1.0f + f * 0.3f;
            stack.func_227862_a_(f2, f2, f2);
        }
        final float alpha = (1.0f - (mortar.fuse - partialTicks + 1.0f) / 100.0f) * 0.8f;
        IVertexBuilder builder = buffers.getBuffer(this.mortarModel.func_228282_a_(HydraMortarRenderer.textureLoc));
        this.mortarModel.func_225598_a_(stack, builder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 0.075f);
        if (mortar.fuse / 5 % 2 == 0) {
            builder = buffers.getBuffer(RenderType.func_228644_e_(HydraMortarRenderer.textureLoc));
            this.mortarModel.func_225598_a_(stack, builder, light, OverlayTexture.func_229201_a_(OverlayTexture.func_229199_a_(1.0f), 10), 1.0f, 1.0f, 1.0f, alpha);
        }
        stack.func_227865_b_();
    }
    
    public ResourceLocation getEntityTexture(final HydraMortarHead entity) {
        return HydraMortarRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydramortar.png");
    }
}
