// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.SlimeRenderer;

public class MazeSlimeRenderer extends SlimeRenderer
{
    private static final ResourceLocation textureLoc;
    
    public MazeSlimeRenderer(final EntityRendererManager manager, final float shadowSize) {
        super(manager);
        this.field_76989_e = shadowSize;
    }
    
    public void func_225623_a_(final SlimeEntity entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        if (((SlimeModel)this.field_77045_g).field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, 0.25, 0.0);
        }
        super.func_225623_a_(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    public ResourceLocation func_110775_a(final SlimeEntity entity) {
        return MazeSlimeRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("mazeslime.png");
    }
}
