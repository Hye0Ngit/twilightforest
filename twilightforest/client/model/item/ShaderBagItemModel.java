// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import java.util.Collections;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.platform.GlStateManager;
import twilightforest.client.shader.ShaderManager;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import blusunrize.immersiveengineering.client.ClientUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.util.Mth;
import twilightforest.client.TFClientEvents;
import twilightforest.TFConfig;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.renderer.texture.OverlayTexture;
import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import java.util.Random;
import net.minecraft.core.Direction;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.TwilightForestMod;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.resources.model.BakedModel;

public class ShaderBagItemModel implements BakedModel
{
    protected final BakedModel delegate;
    protected final ItemStack item;
    private final ResourceLocation bg;
    ModelResourceLocation backModelLocation;
    
    public ShaderBagItemModel(final BakedModel delegate, final ItemStack item) {
        this.bg = TwilightForestMod.prefix("textures/items/star_burst_mask.png");
        this.backModelLocation = new ModelResourceLocation("twilightforest:trophy_minor", "inventory");
        this.delegate = delegate;
        this.item = item;
    }
    
    public List<BakedQuad> m_6840_(@Nullable final BlockState pState, @Nullable final Direction pSide, final Random pRand) {
        return this.delegate.m_6840_(pState, pSide, pRand);
    }
    
    public boolean m_7541_() {
        return this.delegate.m_7541_();
    }
    
    public boolean m_7539_() {
        return this.delegate.m_7539_();
    }
    
    public boolean m_7547_() {
        return this.delegate.m_7547_();
    }
    
    public boolean m_7521_() {
        return this.delegate.m_7521_();
    }
    
    public TextureAtlasSprite m_6160_() {
        return this.delegate.m_6160_();
    }
    
    public ItemOverrides m_7343_() {
        return this.delegate.m_7343_();
    }
    
    public BakedModel handlePerspective(final ItemTransforms.TransformType transform, final PoseStack ms) {
        final BakedModel modelBack = Minecraft.m_91087_().m_91291_().m_115103_().m_109393_().m_119422_(this.backModelLocation);
        if (transform == ItemTransforms.TransformType.GUI) {
            Lighting.m_84930_();
            final MultiBufferSource.BufferSource bufferSource = Minecraft.m_91087_().m_91269_().m_110104_();
            ms.m_85836_();
            ms.m_85837_(0.0, 0.0, -1.5);
            Minecraft.m_91087_().m_91291_().m_115143_(this.item, ItemTransforms.TransformType.GUI, false, ms, (MultiBufferSource)bufferSource, 15728880, OverlayTexture.f_118083_, ForgeHooksClient.handleCameraTransforms(ms, modelBack, transform, false));
            ms.m_85849_();
            ms.m_85836_();
            ms.m_85837_(0.0, 0.0, 2.0);
            ms.m_85845_(Vector3f.f_122222_.m_122240_(((boolean)TFConfig.CLIENT_CONFIG.rotateTrophyHeadsGui.get()) ? Mth.m_14031_(TFClientEvents.rotationTicker * 0.125f) : 30.0f));
            ms.m_85845_(Vector3f.f_122224_.m_122240_(((boolean)TFConfig.CLIENT_CONFIG.rotateTrophyHeadsGui.get()) ? TFClientEvents.rotationTicker : 45.0f));
            ms.m_85845_(Vector3f.f_122226_.m_122240_(((boolean)TFConfig.CLIENT_CONFIG.rotateTrophyHeadsGui.get()) ? Mth.m_14031_(TFClientEvents.rotationTicker * 0.125f) : 0.0f));
            ms.m_85837_(0.0, -0.10000000149011612, 0.0);
            ms.m_85841_(1.25f, 1.25f, 1.25f);
            Minecraft.m_91087_().m_91291_().m_115143_(this.item, ItemTransforms.TransformType.GUI, false, ms, (MultiBufferSource)bufferSource, 15728880, OverlayTexture.f_118083_, ForgeHooksClient.handleCameraTransforms(ms, this.delegate, transform, false));
            ms.m_85849_();
            bufferSource.m_109911_();
            Lighting.m_84931_();
            ms.m_85836_();
            ms.m_85837_(0.5, 0.5, -1.0);
            final Tesselator tessellator = Tesselator.m_85913_();
            final BufferBuilder buffer = tessellator.m_85915_();
            RenderSystem.m_157456_(0, this.bg);
            final int c = ClientUtils.getDarkenedTextColour((int)this.item.m_41791_().f_43022_.m_126665_());
            final float r = (c >> 16 & 0xFF) / 255.0f;
            final float g = (c >> 8 & 0xFF) / 255.0f;
            final float b = (c & 0xFF) / 255.0f;
            buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
            buffer.m_5483_(-1.0, 1.0, 0.0).m_7421_(0.0f, 1.0f).m_85950_(r, g, b, 1.0f).m_5752_();
            buffer.m_5483_(1.0, 1.0, 0.0).m_7421_(1.0f, 1.0f).m_85950_(r, g, b, 1.0f).m_5752_();
            buffer.m_5483_(1.0, -1.0, 0.0).m_7421_(1.0f, 0.0f).m_85950_(r, g, b, 1.0f).m_5752_();
            buffer.m_5483_(-1.0, -1.0, 0.0).m_7421_(0.0f, 0.0f).m_85950_(r, g, b, 1.0f).m_5752_();
            ShaderManager.useShader(ShaderManager.starburstShader, ShaderManager.Uniforms.TIME);
            GlStateManager.m_84384_(3553, 10240, 9729);
            tessellator.m_85914_();
            GlStateManager.m_84384_(3553, 10240, 9728);
            ShaderManager.releaseShader();
            RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
            ms.m_85849_();
            return ForgeHooksClient.handlePerspective((BakedModel)new DummyModel(), transform, ms);
        }
        return ForgeHooksClient.handlePerspective(this.delegate, transform, ms);
    }
    
    public static class DummyModel implements BakedModel
    {
        public List<BakedQuad> m_6840_(@Nullable final BlockState pState, @Nullable final Direction pSide, final Random pRand) {
            return Collections.emptyList();
        }
        
        public boolean m_7541_() {
            return false;
        }
        
        public boolean m_7539_() {
            return false;
        }
        
        public boolean m_7547_() {
            return false;
        }
        
        public boolean m_7521_() {
            return false;
        }
        
        public TextureAtlasSprite m_6160_() {
            return null;
        }
        
        public ItemOverrides m_7343_() {
            return null;
        }
    }
}
