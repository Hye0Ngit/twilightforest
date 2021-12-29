// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.SwarmSpiderEntity;
import net.minecraft.client.renderer.entity.SpiderRenderer;

public class SwarmSpiderRenderer extends SpiderRenderer<SwarmSpiderEntity>
{
    private static final ResourceLocation textureLoc;
    
    public SwarmSpiderRenderer(final EntityRendererManager manager) {
        super(manager);
    }
    
    public ResourceLocation getEntityTexture(final SwarmSpiderEntity entity) {
        return SwarmSpiderRenderer.textureLoc;
    }
    
    public void render(final SwarmSpiderEntity entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        if (((SpiderModel)this.field_77045_g).field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, 0.15000000596046448, 0.0);
        }
        super.func_225623_a_((MobEntity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    protected void preRenderCallback(final SwarmSpiderEntity entity, final MatrixStack stack, final float partialTicks) {
        final float scale = 0.5f;
        stack.func_227862_a_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("swarmspider.png");
    }
}
