// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.MinoshroomModel;
import twilightforest.entity.boss.MinoshroomEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;

public class MinoshroomRenderer extends BipedRenderer<MinoshroomEntity, MinoshroomModel>
{
    private static final ResourceLocation textureLoc;
    
    public MinoshroomRenderer(final EntityRendererManager manager, final MinoshroomModel model, final float shadowSize) {
        super(manager, (BipedModel)model, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerMinoshroomMushroom((IEntityRenderer<MinoshroomEntity, MinoshroomModel>)this));
    }
    
    public ResourceLocation getEntityTexture(final MinoshroomEntity entity) {
        return MinoshroomRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("minoshroomtaur.png");
    }
    
    static class LayerMinoshroomMushroom extends LayerRenderer<MinoshroomEntity, MinoshroomModel>
    {
        public LayerMinoshroomMushroom(final IEntityRenderer<MinoshroomEntity, MinoshroomModel> renderer) {
            super((IEntityRenderer)renderer);
        }
        
        public void render(final MatrixStack ms, final IRenderTypeBuffer buffers, final int light, final MinoshroomEntity entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            if (!entity.func_70631_g_() && !entity.func_82150_aj()) {
                final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                final BlockState blockstate = Blocks.field_150337_Q.func_176223_P();
                final int i = LivingRenderer.func_229117_c_((LivingEntity)entity, 0.0f);
                ms.func_227860_a_();
                ms.func_227861_a_(0.20000000298023224, -0.3499999940395355, 0.5);
                ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-48.0f));
                ms.func_227862_a_(-1.0f, -1.0f, 1.0f);
                ms.func_227861_a_(-0.5, -0.5, -0.5);
                blockrendererdispatcher.func_228791_a_(blockstate, ms, buffers, light, i);
                ms.func_227865_b_();
                ms.func_227860_a_();
                ms.func_227861_a_(0.20000000298023224, -0.3499999940395355, 0.5);
                ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(42.0f));
                ms.func_227861_a_(0.10000000149011612, 0.0, -0.6000000238418579);
                ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-48.0f));
                ms.func_227862_a_(-1.0f, -1.0f, 1.0f);
                ms.func_227861_a_(-0.5, -0.5, -0.5);
                blockrendererdispatcher.func_228791_a_(blockstate, ms, buffers, light, i);
                ms.func_227865_b_();
                ms.func_227860_a_();
                ((MinoshroomModel)this.func_215332_c()).field_78116_c.func_228307_a_(ms);
                ms.func_227861_a_(0.0, -1.1, 0.05);
                ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-78.0f));
                ms.func_227862_a_(-1.0f, -1.0f, 1.0f);
                ms.func_227861_a_(-0.5, -0.5, -0.5);
                blockrendererdispatcher.func_228791_a_(blockstate, ms, buffers, light, i);
                ms.func_227865_b_();
            }
        }
    }
}
