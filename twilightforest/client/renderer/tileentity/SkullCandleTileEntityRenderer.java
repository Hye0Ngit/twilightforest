// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import net.minecraft.Util;
import com.google.common.collect.Maps;
import java.util.HashMap;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.world.entity.player.Player;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.RenderType;
import twilightforest.block.AbstractLightableBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.Minecraft;
import twilightforest.block.AbstractSkullCandleBlock;
import twilightforest.block.SkullCandleBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import twilightforest.block.WallSkullCandleBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayers;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.world.level.block.SkullBlock;
import java.util.Map;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import twilightforest.block.entity.SkullCandleBlockEntity;

public class SkullCandleTileEntityRenderer<T extends SkullCandleBlockEntity> implements BlockEntityRenderer<T>
{
    private final Map<SkullBlock.Type, SkullModelBase> modelByType;
    public static final Map<SkullBlock.Type, ResourceLocation> SKIN_BY_TYPE;
    
    public static Map<SkullBlock.Type, SkullModelBase> createSkullRenderers(final EntityModelSet p_173662_) {
        final ImmutableMap.Builder<SkullBlock.Type, SkullModelBase> var1 = (ImmutableMap.Builder<SkullBlock.Type, SkullModelBase>)ImmutableMap.builder();
        var1.put((Object)SkullBlock.Types.SKELETON, (Object)new SkullModel(p_173662_.m_171103_(ModelLayers.f_171240_)));
        var1.put((Object)SkullBlock.Types.WITHER_SKELETON, (Object)new SkullModel(p_173662_.m_171103_(ModelLayers.f_171219_)));
        var1.put((Object)SkullBlock.Types.PLAYER, (Object)new SkullModel(p_173662_.m_171103_(ModelLayers.f_171163_)));
        var1.put((Object)SkullBlock.Types.ZOMBIE, (Object)new SkullModel(p_173662_.m_171103_(ModelLayers.f_171224_)));
        var1.put((Object)SkullBlock.Types.CREEPER, (Object)new SkullModel(p_173662_.m_171103_(ModelLayers.f_171130_)));
        return (Map<SkullBlock.Type, SkullModelBase>)var1.build();
    }
    
    public SkullCandleTileEntityRenderer(final BlockEntityRendererProvider.Context renderer) {
        this.modelByType = createSkullRenderers(renderer.m_173585_());
    }
    
    public void render(final SkullCandleBlockEntity tile, final float ticks, final PoseStack ms, final MultiBufferSource buffer, final int light, final int overlay) {
        final BlockState state = tile.m_58900_();
        final boolean flag = state.m_60734_() instanceof WallSkullCandleBlock;
        final Direction dir = flag ? ((Direction)state.m_61143_((Property)WallSkullCandleBlock.FACING)) : null;
        final float offset = 22.5f * (float)(flag ? ((2 + dir.m_122416_()) * 4) : state.m_61143_((Property)SkullCandleBlock.ROTATION));
        final SkullBlock.Type type = ((AbstractSkullCandleBlock)state.m_60734_()).getType();
        final SkullModelBase base = this.modelByType.get(type);
        final RenderType render = getRenderType(type, tile.m_59779_());
        renderSkull(dir, offset, 0.0f, ms, buffer, light, base, render);
        if (dir != null) {
            ms.m_85837_((double)(-(float)dir.m_122429_() * 0.25f), 0.0, (double)(-(float)dir.m_122431_() * 0.25f));
        }
        ms.m_85837_(0.0, flag ? 0.75 : 0.44999998807907104, 0.0);
        if (tile.candleAmount <= 0) {
            tile.candleAmount = 1;
        }
        Minecraft.m_91087_().m_91289_().m_110912_((BlockState)((BlockState)AbstractSkullCandleBlock.candleColorToCandle(AbstractSkullCandleBlock.CandleColors.colorFromInt(tile.candleColor).m_7912_()).m_49966_().m_61124_((Property)CandleBlock.f_152790_, (Comparable)tile.candleAmount)).m_61124_((Property)CandleBlock.f_152791_, (Comparable)(state.m_61143_((Property)AbstractSkullCandleBlock.LIGHTING) == AbstractLightableBlock.Lighting.NORMAL)), ms, buffer, light, overlay);
    }
    
    public static void renderSkull(@Nullable final Direction dir, final float ticks, final float animTime, final PoseStack ms, final MultiBufferSource buffer, final int light, final SkullModelBase base, final RenderType render) {
        ms.m_85836_();
        if (dir == null) {
            ms.m_85837_(0.5, 0.0, 0.5);
        }
        else {
            ms.m_85837_((double)(0.5f - dir.m_122429_() * 0.25f), 0.25, (double)(0.5f - dir.m_122431_() * 0.25f));
        }
        ms.m_85841_(-1.0f, -1.0f, 1.0f);
        final VertexConsumer consumer = buffer.m_6299_(render);
        base.m_142698_(animTime, ticks, 0.0f);
        base.m_7695_(ms, consumer, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        ms.m_85849_();
    }
    
    public static RenderType getRenderType(final SkullBlock.Type pSkullType, @Nullable final GameProfile pGameProfile) {
        final ResourceLocation resourcelocation = SkullCandleTileEntityRenderer.SKIN_BY_TYPE.get(pSkullType);
        if (pSkullType == SkullBlock.Types.PLAYER && pGameProfile != null) {
            final Minecraft minecraft = Minecraft.m_91087_();
            final Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.m_91109_().m_118815_(pGameProfile);
            return map.containsKey(MinecraftProfileTexture.Type.SKIN) ? RenderType.m_110473_(minecraft.m_91109_().m_118825_((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN)) : RenderType.m_110458_(DefaultPlayerSkin.m_118627_(Player.m_36198_(pGameProfile)));
        }
        return RenderType.m_110464_(resourcelocation);
    }
    
    static {
        SKIN_BY_TYPE = (Map)Util.m_137469_((Object)Maps.newHashMap(), p_112552_ -> {
            p_112552_.put(SkullBlock.Types.SKELETON, new ResourceLocation("textures/entity/skeleton/skeleton.png"));
            p_112552_.put(SkullBlock.Types.WITHER_SKELETON, new ResourceLocation("textures/entity/skeleton/wither_skeleton.png"));
            p_112552_.put(SkullBlock.Types.ZOMBIE, new ResourceLocation("textures/entity/zombie/zombie.png"));
            p_112552_.put(SkullBlock.Types.CREEPER, new ResourceLocation("textures/entity/creeper/creeper.png"));
            p_112552_.put(SkullBlock.Types.PLAYER, DefaultPlayerSkin.m_118626_());
        });
    }
}
