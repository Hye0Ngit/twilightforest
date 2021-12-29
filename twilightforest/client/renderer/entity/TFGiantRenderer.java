// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.BipedRenderer;
import twilightforest.entity.GiantMinerEntity;

public class TFGiantRenderer<T extends GiantMinerEntity> extends BipedRenderer<T, PlayerModel<T>>
{
    private final PlayerModel<T> normalModel;
    private final PlayerModel<T> slimModel;
    
    public TFGiantRenderer(final EntityRendererManager manager) {
        super(manager, (BipedModel)new PlayerModel(0.0f, false), 1.8f);
        this.normalModel = (PlayerModel<T>)this.func_217764_d();
        this.slimModel = (PlayerModel<T>)new PlayerModel(0.0f, true);
        this.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)this, new BipedModel(0.5f), new BipedModel(0.5f)));
    }
    
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        if (((PlayerModel)this.field_77045_g).field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, -2.5, 0.0);
        }
        super.func_225623_a_((MobEntity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    public ResourceLocation getEntityTexture(final GiantMinerEntity entity) {
        final Minecraft mc = Minecraft.func_71410_x();
        boolean slim = false;
        ResourceLocation texture = DefaultPlayerSkin.func_177335_a();
        if (mc.func_175606_aa() instanceof AbstractClientPlayerEntity) {
            final AbstractClientPlayerEntity client = (AbstractClientPlayerEntity)mc.func_175606_aa();
            texture = client.func_110306_p();
            slim = client.func_175154_l().equals("slim");
        }
        this.field_77045_g = (EntityModel)(slim ? this.slimModel : this.normalModel);
        return texture;
    }
    
    public void preRenderCallback(final T entitylivingbaseIn, final MatrixStack stack, final float partialTickTime) {
        final float scale = 4.0f;
        stack.func_227862_a_(scale, scale, scale);
    }
}
