// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.boss.EntityTFFallingIce;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFFallingIce extends Render<EntityTFFallingIce>
{
    public RenderTFFallingIce(final RenderManager renderManagerIn) {
        super(renderManagerIn);
        this.field_76989_e = 0.5f;
    }
    
    public void doRender(final EntityTFFallingIce entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
        if (entity.func_175131_l() != null) {
            final IBlockState iblockstate = entity.func_175131_l();
            if (iblockstate.func_185901_i() == EnumBlockRenderType.MODEL) {
                final World world = entity.func_145807_e();
                if (iblockstate != world.func_180495_p(new BlockPos((Entity)entity)) && iblockstate.func_185901_i() != EnumBlockRenderType.INVISIBLE) {
                    this.func_110776_a(TextureMap.field_110575_b);
                    GlStateManager.func_179094_E();
                    GlStateManager.func_179140_f();
                    final Tessellator tessellator = Tessellator.func_178181_a();
                    final BufferBuilder bufferbuilder = tessellator.func_178180_c();
                    if (this.field_188301_f) {
                        GlStateManager.func_179142_g();
                        GlStateManager.func_187431_e(this.func_188298_c((Entity)entity));
                    }
                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_176600_a);
                    final BlockPos blockpos = new BlockPos(entity.field_70165_t, entity.func_174813_aQ().field_72337_e, entity.field_70161_v);
                    GlStateManager.func_179109_b((float)(x - blockpos.func_177958_n() - 0.5), (float)(y - blockpos.func_177956_o()), (float)(z - blockpos.func_177952_p() - 0.5));
                    GlStateManager.func_179152_a(3.0f, 3.0f, 3.0f);
                    final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                    blockrendererdispatcher.func_175019_b().func_187493_a((IBlockAccess)world, blockrendererdispatcher.func_184389_a(iblockstate), iblockstate, blockpos, bufferbuilder, false, MathHelper.func_180186_a((Vec3i)entity.func_184531_j()));
                    tessellator.func_78381_a();
                    if (this.field_188301_f) {
                        GlStateManager.func_187417_n();
                        GlStateManager.func_179119_h();
                    }
                    GlStateManager.func_179145_e();
                    GlStateManager.func_179121_F();
                    super.func_76986_a((Entity)entity, x, y, z, entityYaw, partialTicks);
                }
            }
        }
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFFallingIce entity) {
        return TextureMap.field_110575_b;
    }
}
