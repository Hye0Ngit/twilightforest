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
import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.entity.SlideBlock;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class SlideBlockRenderer extends EntityRenderer<SlideBlock>
{
    public SlideBlockRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.f_114477_ = 0.0f;
    }
    
    public void render(final SlideBlock entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        if (entity.getBlockState() != null) {
            final BlockState blockstate = entity.getBlockState();
            if (blockstate.m_60799_() == RenderShape.MODEL) {
                final Level world = entity.f_19853_;
                if (blockstate != world.m_8055_(entity.m_142538_()) && blockstate.m_60799_() != RenderShape.INVISIBLE) {
                    stack.m_85836_();
                    final BlockPos blockpos = new BlockPos(entity.m_20185_(), entity.m_142469_().f_82292_, entity.m_20189_());
                    if (blockstate.m_61147_().contains(RotatedPillarBlock.f_55923_)) {
                        final Direction.Axis axis = (Direction.Axis)blockstate.m_61143_((Property)RotatedPillarBlock.f_55923_);
                        final float angle = (entity.f_19797_ + partialTicks) * 60.0f;
                        stack.m_85837_(0.0, 0.5, 0.0);
                        if (axis == Direction.Axis.Y) {
                            stack.m_85845_(Vector3f.f_122225_.m_122240_(angle));
                        }
                        else if (axis == Direction.Axis.X) {
                            stack.m_85845_(Vector3f.f_122223_.m_122240_(angle));
                        }
                        else if (axis == Direction.Axis.Z) {
                            stack.m_85845_(Vector3f.f_122227_.m_122240_(angle));
                        }
                        stack.m_85837_(-0.5, -0.5, -0.5);
                    }
                    final BlockRenderDispatcher blockrendererdispatcher = Minecraft.m_91087_().m_91289_();
                    for (final RenderType type : RenderType.m_110506_()) {
                        if (ItemBlockRenderTypes.canRenderInLayer(blockstate, type)) {
                            ForgeHooksClient.setRenderLayer(type);
                            blockrendererdispatcher.m_110937_().m_111047_((BlockAndTintGetter)world, blockrendererdispatcher.m_110910_(blockstate), blockstate, blockpos, stack, buffer.m_6299_(type), false, new Random(), blockstate.m_60726_(blockpos), OverlayTexture.f_118083_);
                        }
                    }
                    ForgeHooksClient.setRenderLayer((RenderType)null);
                    stack.m_85849_();
                    super.m_7392_((Entity)entity, yaw, partialTicks, stack, buffer, light);
                }
            }
        }
    }
    
    public ResourceLocation getTextureLocation(final SlideBlock entity) {
        return TextureAtlas.f_118259_;
    }
}
