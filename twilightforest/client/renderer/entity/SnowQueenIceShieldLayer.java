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
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.entity.boss.SnowQueenIceShieldEntity;

public class SnowQueenIceShieldLayer<T extends SnowQueenIceShieldEntity> extends EntityRenderer<T>
{
    public SnowQueenIceShieldLayer(final EntityRendererManager renderManager) {
        super(renderManager);
    }
    
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        final BlockState blockstate = Blocks.field_150403_cj.func_176223_P();
        if (blockstate.func_185901_i() == BlockRenderType.MODEL) {
            final World world = entityIn.field_70170_p;
            if (blockstate.func_185901_i() != BlockRenderType.INVISIBLE) {
                matrixStackIn.func_227860_a_();
                final BlockPos blockpos = new BlockPos(entityIn.func_226277_ct_(), entityIn.func_174813_aQ().field_72337_e, entityIn.func_226281_cx_());
                matrixStackIn.func_227861_a_(-0.5, 0.0, -0.5);
                final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                for (final RenderType type : RenderType.func_228661_n_()) {
                    if (RenderTypeLookup.canRenderInLayer(blockstate, type)) {
                        ForgeHooksClient.setRenderLayer(type);
                        blockrendererdispatcher.func_175019_b().func_228802_a_((IBlockDisplayReader)world, blockrendererdispatcher.func_184389_a(blockstate), blockstate, blockpos, matrixStackIn, bufferIn.getBuffer(type), false, new Random(), blockstate.func_209533_a(new BlockPos(entityIn.func_213303_ch())), OverlayTexture.field_229196_a_);
                    }
                }
                ForgeHooksClient.setRenderLayer((RenderType)null);
                matrixStackIn.func_227865_b_();
                super.func_225623_a_((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
            }
        }
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return AtlasTexture.field_110575_b;
    }
}
