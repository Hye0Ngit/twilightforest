// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import net.minecraft.client.renderer.RenderStateShard;
import twilightforest.TwilightForestMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.world.level.block.entity.BlockEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.core.Direction;
import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.FireflyModel;
import twilightforest.block.entity.FireflyBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

public class FireflyTileEntityRenderer implements BlockEntityRenderer<FireflyBlockEntity>
{
    private final FireflyModel fireflyModel;
    private static final ResourceLocation textureLoc;
    
    public FireflyTileEntityRenderer(final BlockEntityRendererProvider.Context renderer) {
        this.fireflyModel = new FireflyModel(renderer.m_173582_(TFModelLayers.FIREFLY));
    }
    
    public void render(@Nullable final FireflyBlockEntity te, final float partialTicks, final PoseStack ms, final MultiBufferSource buffer, final int light, final int overlay) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentYaw;
        final float glow = (te != null) ? te.glowIntensity : BugModelAnimationHelper.glowIntensity;
        ms.m_85836_();
        final Direction facing = (Direction)((te != null) ? te.m_58900_().m_61143_((Property)DirectionalBlock.f_52588_) : Direction.NORTH);
        ms.m_85837_(0.5, 0.5, 0.5);
        ms.m_85845_(facing.m_122406_());
        ms.m_85845_(Vector3f.f_122227_.m_122240_(180.0f));
        ms.m_85845_(Vector3f.f_122225_.m_122240_(180.0f));
        ms.m_85845_(Vector3f.f_122224_.m_122240_((float)yaw));
        ms.m_85836_();
        final VertexConsumer builder = buffer.m_6299_(RenderType.m_110452_(FireflyTileEntityRenderer.textureLoc));
        this.fireflyModel.m_7695_(ms, builder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        ms.m_85849_();
        ms.m_85849_();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("firefly-tiny.png");
        final RenderStateShard.TransparencyStateShard transparencyStateShard = new RenderStateShard.TransparencyStateShard("twilightforest:firefly_glow", () -> {
            RenderSystem.m_69478_();
            RenderSystem.m_69405_(770, 1);
        }, () -> {
            RenderSystem.m_69461_();
            RenderSystem.m_69453_();
        });
    }
}
