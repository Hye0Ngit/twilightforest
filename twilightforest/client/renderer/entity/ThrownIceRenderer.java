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
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.entity.projectile.IceBomb;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class ThrownIceRenderer extends EntityRenderer<IceBomb>
{
    public ThrownIceRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.5f;
    }
    
    public void render(final IceBomb entity, final float yaw, final float partialTicks, final PoseStack ms, final MultiBufferSource buffers, final int light) {
        final BlockState blockstate = entity.getBlockState();
        if (blockstate.m_60799_() == RenderShape.MODEL) {
            final Level world = entity.m_20193_();
            if (blockstate != world.m_8055_(entity.m_142538_()) && blockstate.m_60799_() != RenderShape.INVISIBLE) {
                ms.m_85836_();
                final BlockPos blockpos = new BlockPos(entity.m_20185_(), entity.m_142469_().f_82292_, entity.m_20189_());
                ms.m_85837_(-0.5, 0.0, -0.5);
                final BlockRenderDispatcher blockrendererdispatcher = Minecraft.m_91087_().m_91289_();
                for (final RenderType type : RenderType.m_110506_()) {
                    if (ItemBlockRenderTypes.canRenderInLayer(blockstate, type)) {
                        ForgeHooksClient.setRenderLayer(type);
                        blockrendererdispatcher.m_110937_().m_111047_((BlockAndTintGetter)world, blockrendererdispatcher.m_110910_(blockstate), blockstate, blockpos, ms, buffers.m_6299_(type), false, new Random(), blockstate.m_60726_(BlockPos.f_121853_), OverlayTexture.f_118083_);
                    }
                }
                ForgeHooksClient.setRenderLayer((RenderType)null);
                ms.m_85849_();
                super.m_7392_((Entity)entity, yaw, partialTicks, ms, buffers, light);
            }
        }
    }
    
    public ResourceLocation getTextureLocation(final IceBomb entity) {
        return TextureAtlas.f_118259_;
    }
}
