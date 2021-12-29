// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.client.model.entity.CubeOfAnnihilationModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.entity.RovingCubeEntity;

public class RovingCubeRenderer<T extends RovingCubeEntity> extends EntityRenderer<T>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    
    public RovingCubeRenderer(final EntityRendererManager manager) {
        super(manager);
        this.model = (Model)new CubeOfAnnihilationModel();
    }
    
    public void render(final T entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        stack.func_227860_a_();
        final IVertexBuilder builder = buffer.getBuffer(this.model.func_228282_a_(RovingCubeRenderer.textureLoc));
        stack.func_227862_a_(2.0f, 2.0f, 2.0f);
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(MathHelper.func_76142_g(entity.field_70173_aa + partialTicks) * 11.0f));
        stack.func_227861_a_(0.0, 0.75, 0.0);
        this.model.func_225598_a_(stack, builder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return RovingCubeRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cubeofannihilation.png");
    }
}
