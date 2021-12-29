// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import java.util.Iterator;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.client.renderer.texture.OverlayTexture;
import java.util.Random;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockRenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.entity.SlideBlockEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class SlideBlockRenderer extends EntityRenderer<SlideBlockEntity>
{
    public SlideBlockRenderer(final EntityRendererManager manager) {
        super(manager);
        this.field_76989_e = 0.0f;
    }
    
    public void render(final SlideBlockEntity entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        if (entity.getBlockState() != null) {
            final BlockState blockstate = entity.getBlockState();
            if (blockstate.func_185901_i() == BlockRenderType.MODEL) {
                final World world = entity.field_70170_p;
                if (blockstate != world.func_180495_p(entity.func_233580_cy_()) && blockstate.func_185901_i() != BlockRenderType.INVISIBLE) {
                    stack.func_227860_a_();
                    final BlockPos blockpos = new BlockPos(entity.func_226277_ct_(), entity.func_174813_aQ().field_72337_e, entity.func_226281_cx_());
                    if (blockstate.func_235904_r_().contains(RotatedPillarBlock.field_176298_M)) {
                        final Direction.Axis axis = (Direction.Axis)blockstate.func_177229_b((Property)RotatedPillarBlock.field_176298_M);
                        final float angle = (entity.field_70173_aa + partialTicks) * 60.0f;
                        stack.func_227861_a_(0.0, 0.5, 0.0);
                        if (axis == Direction.Axis.Y) {
                            stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(angle));
                        }
                        else if (axis == Direction.Axis.X) {
                            stack.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(angle));
                        }
                        else if (axis == Direction.Axis.Z) {
                            stack.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(angle));
                        }
                        stack.func_227861_a_(-0.5, -0.5, -0.5);
                    }
                    final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                    for (final RenderType type : RenderType.func_228661_n_()) {
                        if (RenderTypeLookup.canRenderInLayer(blockstate, type)) {
                            ForgeHooksClient.setRenderLayer(type);
                            blockrendererdispatcher.func_175019_b().func_228802_a_((IBlockDisplayReader)world, blockrendererdispatcher.func_184389_a(blockstate), blockstate, blockpos, stack, buffer.getBuffer(type), false, new Random(), blockstate.func_209533_a(blockpos), OverlayTexture.field_229196_a_);
                        }
                    }
                    ForgeHooksClient.setRenderLayer((RenderType)null);
                    stack.func_227865_b_();
                    super.func_225623_a_((Entity)entity, yaw, partialTicks, stack, buffer, light);
                }
            }
        }
    }
    
    public ResourceLocation getEntityTexture(final SlideBlockEntity entity) {
        return AtlasTexture.field_110575_b;
    }
}
