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
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.CicadaModel;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.projectile.CicadaShotEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class CicadaShotRenderer extends EntityRenderer<CicadaShotEntity>
{
    private static final ResourceLocation textureLoc;
    private final CicadaModel cicadaModel;
    
    public CicadaShotRenderer(final EntityRendererManager manager) {
        super(manager);
        this.cicadaModel = new CicadaModel();
        this.field_76989_e = 0.25f;
    }
    
    public void render(final CicadaShotEntity entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        stack.func_227860_a_();
        stack.func_227861_a_(0.0, 0.5, 0.0);
        stack.func_227862_a_(-1.0f, -1.0f, -1.0f);
        stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(MathHelper.func_219799_g(partialTicks, entity.field_70126_B, entity.field_70177_z) - 180.0f));
        stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(MathHelper.func_219799_g(partialTicks, entity.field_70127_C, entity.field_70125_A)));
        final IVertexBuilder builder = buffer.getBuffer(this.cicadaModel.func_228282_a_(CicadaShotRenderer.textureLoc));
        this.cicadaModel.func_225598_a_(stack, builder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
    }
    
    public ResourceLocation getEntityTexture(final CicadaShotEntity entity) {
        return CicadaShotRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cicada-model.png");
    }
}
