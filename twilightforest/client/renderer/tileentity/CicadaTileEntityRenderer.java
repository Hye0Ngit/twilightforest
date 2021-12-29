// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.state.Property;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.util.Direction;
import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.CicadaModel;
import twilightforest.tileentity.CicadaTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class CicadaTileEntityRenderer extends TileEntityRenderer<CicadaTileEntity>
{
    private final CicadaModel cicadaModel;
    private static final ResourceLocation textureLoc;
    
    public CicadaTileEntityRenderer(final TileEntityRendererDispatcher dispatch) {
        super(dispatch);
        this.cicadaModel = new CicadaModel();
    }
    
    public void render(@Nullable final CicadaTileEntity te, final float partialTicks, final MatrixStack ms, final IRenderTypeBuffer buffers, final int light, final int overlay) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentYaw;
        ms.func_227860_a_();
        final Direction facing = (Direction)((te != null) ? te.func_195044_w().func_177229_b((Property)DirectionalBlock.field_176387_N) : Direction.NORTH);
        float rotX = 90.0f;
        float rotZ = 0.0f;
        if (facing == Direction.SOUTH) {
            rotZ = 0.0f;
        }
        else if (facing == Direction.NORTH) {
            rotZ = 180.0f;
        }
        else if (facing == Direction.EAST) {
            rotZ = -90.0f;
        }
        else if (facing == Direction.WEST) {
            rotZ = 90.0f;
        }
        else if (facing == Direction.UP) {
            rotX = 0.0f;
        }
        else if (facing == Direction.DOWN) {
            rotX = 180.0f;
        }
        ms.func_227861_a_(0.5, 0.5, 0.5);
        ms.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(rotX));
        ms.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(rotZ));
        ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_((float)yaw));
        ms.func_227862_a_(-1.0f, -1.0f, -1.0f);
        final IVertexBuilder vertex = buffers.getBuffer(this.cicadaModel.func_228282_a_(CicadaTileEntityRenderer.textureLoc));
        this.cicadaModel.func_225598_a_(ms, vertex, light, overlay, 1.0f, 1.0f, 1.0f, 1.0f);
        ms.func_227865_b_();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cicada-model.png");
    }
}
