// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import com.mojang.math.Vector3f;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.MinoshroomLegacyModel;
import twilightforest.entity.boss.Minoshroom;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

public class LegacyMinoshroomRenderer extends HumanoidMobRenderer<Minoshroom, MinoshroomLegacyModel>
{
    private static final ResourceLocation textureLoc;
    
    public LegacyMinoshroomRenderer(final EntityRendererProvider.Context manager, final MinoshroomLegacyModel model, final float shadowSize) {
        super(manager, (HumanoidModel)model, shadowSize);
        this.m_115326_((RenderLayer)new LayerMinoshroomMushroom((RenderLayerParent<Minoshroom, MinoshroomLegacyModel>)this));
    }
    
    public ResourceLocation getTextureLocation(final Minoshroom entity) {
        return LegacyMinoshroomRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("minoshroomtaur.png");
    }
    
    static class LayerMinoshroomMushroom extends RenderLayer<Minoshroom, MinoshroomLegacyModel>
    {
        public LayerMinoshroomMushroom(final RenderLayerParent<Minoshroom, MinoshroomLegacyModel> renderer) {
            super((RenderLayerParent)renderer);
        }
        
        public void render(final PoseStack ms, final MultiBufferSource buffers, final int light, final Minoshroom entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch) {
            if (!entity.m_6162_() && !entity.m_20145_()) {
                final BlockRenderDispatcher blockrendererdispatcher = Minecraft.m_91087_().m_91289_();
                final BlockState blockstate = Blocks.f_50073_.m_49966_();
                final int i = LivingEntityRenderer.m_115338_((LivingEntity)entity, 0.0f);
                ms.m_85836_();
                ms.m_85837_(0.20000000298023224, -0.3499999940395355, 0.5);
                ms.m_85845_(Vector3f.f_122225_.m_122240_(-48.0f));
                ms.m_85841_(-1.0f, -1.0f, 1.0f);
                ms.m_85837_(-0.5, -0.5, -0.5);
                blockrendererdispatcher.m_110912_(blockstate, ms, buffers, light, i);
                ms.m_85849_();
                ms.m_85836_();
                ms.m_85837_(0.20000000298023224, -0.3499999940395355, 0.5);
                ms.m_85845_(Vector3f.f_122225_.m_122240_(42.0f));
                ms.m_85837_(0.10000000149011612, 0.0, -0.6000000238418579);
                ms.m_85845_(Vector3f.f_122225_.m_122240_(-48.0f));
                ms.m_85841_(-1.0f, -1.0f, 1.0f);
                ms.m_85837_(-0.5, -0.5, -0.5);
                blockrendererdispatcher.m_110912_(blockstate, ms, buffers, light, i);
                ms.m_85849_();
                ms.m_85836_();
                ((MinoshroomLegacyModel)this.m_117386_()).f_102808_.m_104299_(ms);
                ms.m_85837_(0.0, -0.9, 0.05);
                ms.m_85845_(Vector3f.f_122225_.m_122240_(-78.0f));
                ms.m_85841_(-1.0f, -1.0f, 1.0f);
                ms.m_85837_(-0.5, -0.5, -0.5);
                blockrendererdispatcher.m_110912_(blockstate, ms, buffers, light, i);
                ms.m_85849_();
            }
        }
    }
}
