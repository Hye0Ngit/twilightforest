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
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.entity.boss.IceBombEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class ThrownIceRenderer extends EntityRenderer<IceBombEntity>
{
    public ThrownIceRenderer(final EntityRendererManager manager) {
        super(manager);
        this.field_76989_e = 0.5f;
    }
    
    public void render(final IceBombEntity entity, final float yaw, final float partialTicks, final MatrixStack ms, final IRenderTypeBuffer buffers, final int light) {
        final BlockState blockstate = entity.getBlockState();
        if (blockstate.func_185901_i() == BlockRenderType.MODEL) {
            final World world = entity.func_130014_f_();
            if (blockstate != world.func_180495_p(entity.func_233580_cy_()) && blockstate.func_185901_i() != BlockRenderType.INVISIBLE) {
                ms.func_227860_a_();
                final BlockPos blockpos = new BlockPos(entity.func_226277_ct_(), entity.func_174813_aQ().field_72337_e, entity.func_226281_cx_());
                ms.func_227861_a_(-0.5, 0.0, -0.5);
                final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                for (final RenderType type : RenderType.func_228661_n_()) {
                    if (RenderTypeLookup.canRenderInLayer(blockstate, type)) {
                        ForgeHooksClient.setRenderLayer(type);
                        blockrendererdispatcher.func_175019_b().func_228802_a_((IBlockDisplayReader)world, blockrendererdispatcher.func_184389_a(blockstate), blockstate, blockpos, ms, buffers.getBuffer(type), false, new Random(), blockstate.func_209533_a(BlockPos.field_177992_a), OverlayTexture.field_229196_a_);
                    }
                }
                ForgeHooksClient.setRenderLayer((RenderType)null);
                ms.func_227865_b_();
                super.func_225623_a_((Entity)entity, yaw, partialTicks, ms, buffers, light);
            }
        }
    }
    
    public ResourceLocation getEntityTexture(final IceBombEntity entity) {
        return AtlasTexture.field_110575_b;
    }
}
