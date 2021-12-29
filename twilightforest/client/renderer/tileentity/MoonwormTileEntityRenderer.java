// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.entity.BlockEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;
import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import twilightforest.client.model.entity.MoonwormModel;
import net.minecraft.resources.ResourceLocation;
import twilightforest.block.entity.MoonwormBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

public class MoonwormTileEntityRenderer implements BlockEntityRenderer<MoonwormBlockEntity>
{
    private static final ResourceLocation textureLoc;
    private final MoonwormModel moonwormModel;
    
    public MoonwormTileEntityRenderer(final BlockEntityRendererProvider.Context renderer) {
        this.moonwormModel = new MoonwormModel(renderer.m_173582_(TFModelLayers.MOONWORM));
    }
    
    public void render(@Nullable final MoonwormBlockEntity te, float partialTicks, final PoseStack ms, final MultiBufferSource buffer, final int light, final int overlay) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentRotation;
        if (te == null) {
            partialTicks = Minecraft.m_91087_().m_91296_();
        }
        ms.m_85836_();
        final Direction facing = (Direction)((te != null) ? te.m_58900_().m_61143_((Property)DirectionalBlock.f_52588_) : Direction.NORTH);
        ms.m_85837_(0.5, 0.5, 0.5);
        ms.m_85845_(facing.m_122406_());
        ms.m_85845_(Vector3f.f_122227_.m_122240_(180.0f));
        ms.m_85845_(Vector3f.f_122225_.m_122240_(180.0f));
        ms.m_85845_(Vector3f.f_122224_.m_122240_((float)yaw));
        final VertexConsumer builder = buffer.m_6299_(this.moonwormModel.m_103119_(MoonwormTileEntityRenderer.textureLoc));
        this.moonwormModel.setRotationAngles(te, partialTicks);
        this.moonwormModel.m_7695_(ms, builder, light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        ms.m_85849_();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("moonworm.png");
    }
}
