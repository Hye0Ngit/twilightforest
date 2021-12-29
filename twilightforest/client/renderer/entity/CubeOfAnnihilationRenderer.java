// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.client.model.entity.CubeOfAnnihilationModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.CubeOfAnnihilationEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class CubeOfAnnihilationRenderer extends EntityRenderer<CubeOfAnnihilationEntity>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    
    public CubeOfAnnihilationRenderer(final EntityRendererManager manager) {
        super(manager);
        this.model = (Model)new CubeOfAnnihilationModel();
    }
    
    public void render(final CubeOfAnnihilationEntity entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        super.func_225623_a_((Entity)entity, yaw, partialTicks, stack, buffer, light);
        stack.func_227860_a_();
        stack.func_227862_a_(-1.0f, -1.0f, 1.0f);
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(MathHelper.func_76142_g((entity.field_70173_aa + partialTicks) * 11.0f)));
        stack.func_227861_a_(0.0, -0.5, 0.0);
        this.model.func_225598_a_(stack, buffer.getBuffer(this.model.func_228282_a_(CubeOfAnnihilationRenderer.textureLoc)), light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
    }
    
    public ResourceLocation getEntityTexture(final CubeOfAnnihilationEntity entity) {
        return CubeOfAnnihilationRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cubeofannihilation.png");
    }
}
