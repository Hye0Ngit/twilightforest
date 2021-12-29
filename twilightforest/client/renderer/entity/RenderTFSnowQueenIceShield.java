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
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.boss.EntityTFSnowQueenIceShield;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFSnowQueenIceShield extends Render<EntityTFSnowQueenIceShield>
{
    public RenderTFSnowQueenIceShield(final RenderManager manager) {
        super(manager);
    }
    
    public void doRender(final EntityTFSnowQueenIceShield entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
        final IBlockState iblockstate = Blocks.field_150403_cj.func_176223_P();
        if (iblockstate.func_185901_i() == EnumBlockRenderType.MODEL) {
            final World world = entity.field_70170_p;
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
                final BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
                blockrendererdispatcher.func_175019_b().func_187493_a((IBlockAccess)world, blockrendererdispatcher.func_184389_a(iblockstate), iblockstate, blockpos, bufferbuilder, false, MathHelper.func_180186_a((Vec3i)BlockPos.field_177992_a));
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
    
    protected ResourceLocation getEntityTexture(final EntityTFSnowQueenIceShield entity) {
        return TextureMap.field_110575_b;
    }
}
