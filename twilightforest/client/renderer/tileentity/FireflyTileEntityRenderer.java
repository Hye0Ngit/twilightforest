// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.RenderState;
import twilightforest.TwilightForestMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.tileentity.TileEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.state.Property;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.util.Direction;
import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.FireflyModel;
import twilightforest.tileentity.FireflyTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class FireflyTileEntityRenderer extends TileEntityRenderer<FireflyTileEntity>
{
    private final FireflyModel fireflyModel;
    private static final ResourceLocation textureLoc;
    private static final RenderType GLOW_LAYER;
    
    public FireflyTileEntityRenderer(final TileEntityRendererDispatcher dispatch) {
        super(dispatch);
        this.fireflyModel = new FireflyModel();
    }
    
    public void render(@Nullable final FireflyTileEntity te, final float partialTicks, final MatrixStack ms, final IRenderTypeBuffer buffer, final int light, final int overlay) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentYaw;
        final float glow = (te != null) ? te.glowIntensity : BugModelAnimationHelper.glowIntensity;
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
        ms.func_227860_a_();
        ms.func_227862_a_(1.0f, -1.0f, -1.0f);
        IVertexBuilder builder = buffer.getBuffer(RenderType.func_228638_b_(FireflyTileEntityRenderer.textureLoc));
        this.fireflyModel.func_225598_a_(ms, builder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        builder = buffer.getBuffer(FireflyTileEntityRenderer.GLOW_LAYER);
        this.fireflyModel.glow.func_228309_a_(ms, builder, 15728880, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, glow);
        ms.func_227865_b_();
        ms.func_227865_b_();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("firefly-tiny.png");
        final RenderState.TransparencyState transparencyState = new RenderState.TransparencyState("twilightforest:firefly_glow", () -> {
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 1);
            return;
        }, () -> {
            RenderSystem.disableBlend();
            RenderSystem.defaultBlendFunc();
            return;
        });
        final RenderState.AlphaState noAlphaTest = new RenderState.AlphaState(0.0f);
        final RenderState.DiffuseLightingState enableDiffuse = new RenderState.DiffuseLightingState(true);
        final RenderState.CullState disableCull = new RenderState.CullState(false);
        final RenderState.LightmapState enableLightmap = new RenderState.LightmapState(true);
        final RenderType.State rendertype$state = RenderType.State.func_228694_a_().func_228724_a_(new RenderState.TextureState(FireflyTileEntityRenderer.textureLoc, false, false)).func_228726_a_(transparencyState).func_228716_a_(enableDiffuse).func_228713_a_(noAlphaTest).func_228714_a_(disableCull).func_228719_a_(enableLightmap).func_228728_a_(false);
        GLOW_LAYER = (RenderType)RenderType.func_228633_a_("twilightforest:firefly_glow", DefaultVertexFormats.field_227852_q_, 7, 256, true, true, rendertype$state);
    }
}
