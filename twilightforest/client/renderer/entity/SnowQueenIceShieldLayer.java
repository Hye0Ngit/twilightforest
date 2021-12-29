// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import java.util.Iterator;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.client.renderer.texture.OverlayTexture;
import java.util.Random;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.entity.boss.SnowQueenIceShield;

public class SnowQueenIceShieldLayer<T extends SnowQueenIceShield> extends EntityRenderer<T>
{
    public SnowQueenIceShieldLayer(final EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }
    
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final PoseStack matrixStackIn, final MultiBufferSource bufferIn, final int packedLightIn) {
        final BlockState blockstate = Blocks.f_50354_.m_49966_();
        if (blockstate.m_60799_() == RenderShape.MODEL) {
            final Level world = entityIn.f_19853_;
            if (blockstate.m_60799_() != RenderShape.INVISIBLE) {
                matrixStackIn.m_85836_();
                final BlockPos blockpos = new BlockPos(entityIn.m_20185_(), entityIn.m_142469_().f_82292_, entityIn.m_20189_());
                matrixStackIn.m_85837_(-0.5, 0.0, -0.5);
                final BlockRenderDispatcher blockrendererdispatcher = Minecraft.m_91087_().m_91289_();
                for (final RenderType type : RenderType.m_110506_()) {
                    if (ItemBlockRenderTypes.canRenderInLayer(blockstate, type)) {
                        ForgeHooksClient.setRenderLayer(type);
                        blockrendererdispatcher.m_110937_().m_111047_((BlockAndTintGetter)world, blockrendererdispatcher.m_110910_(blockstate), blockstate, blockpos, matrixStackIn, bufferIn.m_6299_(type), false, new Random(), blockstate.m_60726_(new BlockPos(entityIn.m_20182_())), OverlayTexture.f_118083_);
                    }
                }
                ForgeHooksClient.setRenderLayer((RenderType)null);
                matrixStackIn.m_85849_();
                super.m_7392_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
            }
        }
    }
    
    public ResourceLocation getTextureLocation(final T entity) {
        return TextureAtlas.f_118259_;
    }
}
