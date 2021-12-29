// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.entity.BlockEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
import twilightforest.client.model.entity.CicadaModel;
import twilightforest.block.entity.CicadaBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

public class CicadaTileEntityRenderer implements BlockEntityRenderer<CicadaBlockEntity>
{
    private final CicadaModel cicadaModel;
    private static final ResourceLocation textureLoc;
    
    public CicadaTileEntityRenderer(final BlockEntityRendererProvider.Context renderer) {
        this.cicadaModel = new CicadaModel(renderer.m_173582_(TFModelLayers.CICADA));
    }
    
    public void render(@Nullable final CicadaBlockEntity te, final float partialTicks, final PoseStack ms, final MultiBufferSource buffers, final int light, final int overlay) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentYaw;
        ms.m_85836_();
        final Direction facing = (Direction)((te != null) ? te.m_58900_().m_61143_((Property)DirectionalBlock.f_52588_) : Direction.NORTH);
        ms.m_85837_(0.5, 0.5, 0.5);
        ms.m_85845_(facing.m_122406_());
        ms.m_85845_(Vector3f.f_122227_.m_122240_(180.0f));
        ms.m_85845_(Vector3f.f_122225_.m_122240_(180.0f));
        ms.m_85845_(Vector3f.f_122224_.m_122240_((float)yaw));
        final VertexConsumer vertex = buffers.m_6299_(this.cicadaModel.m_103119_(CicadaTileEntityRenderer.textureLoc));
        this.cicadaModel.m_7695_(ms, vertex, light, overlay, 1.0f, 1.0f, 1.0f, 1.0f);
        ms.m_85849_();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cicada-model.png");
    }
}
