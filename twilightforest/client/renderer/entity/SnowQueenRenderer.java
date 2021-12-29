// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.SnowQueenModel;
import twilightforest.entity.boss.SnowQueenEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;

public class SnowQueenRenderer extends BipedRenderer<SnowQueenEntity, SnowQueenModel>
{
    private static final ResourceLocation textureLoc;
    
    public SnowQueenRenderer(final EntityRendererManager manager, final SnowQueenModel model) {
        super(manager, (BipedModel)model, 0.625f);
    }
    
    public ResourceLocation getEntityTexture(final SnowQueenEntity entity) {
        return SnowQueenRenderer.textureLoc;
    }
    
    protected void preRenderCallback(final SnowQueenEntity queen, final MatrixStack stack, final float partialTicks) {
        final float scale = 1.2f;
        stack.func_227862_a_(scale, scale, scale);
    }
    
    public void render(final SnowQueenEntity queen, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        super.func_225623_a_((MobEntity)queen, yaw, partialTicks, stack, buffer, light);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("snowqueen.png");
    }
}
