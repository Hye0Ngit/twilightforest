// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import twilightforest.block.BlockTFSlider;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import twilightforest.entity.EntityTFSlideBlock;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFSlideBlock extends Render
{
    private final RenderBlocks renderBlocks;
    
    public RenderTFSlideBlock() {
        this.renderBlocks = new RenderBlocks();
    }
    
    public void func_76986_a(final Entity entity, final double x, final double y, final double z, final float p_76986_8_, final float time) {
        final EntityTFSlideBlock sliderEntity = (EntityTFSlideBlock)entity;
        final World world = entity.field_70170_p;
        final Block block = sliderEntity.getBlock();
        final int meta = sliderEntity.getMeta();
        final int bx = MathHelper.func_76128_c(entity.field_70165_t);
        final int by = MathHelper.func_76128_c(entity.field_70163_u);
        final int bz = MathHelper.func_76128_c(entity.field_70161_v);
        if (block != null && block != world.func_147439_a(bx, by, bz)) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x, (float)y + 0.5f, (float)z);
            if ((meta & 0xC) == 0x0) {
                GL11.glRotatef((entity.field_70173_aa + time) * 60.0f, 0.0f, 1.0f, 0.0f);
            }
            else if ((meta & 0xC) == 0x4) {
                GL11.glRotatef((entity.field_70173_aa + time) * 60.0f, 1.0f, 0.0f, 0.0f);
            }
            else if ((meta & 0xC) == 0x8) {
                GL11.glRotatef((entity.field_70173_aa + time) * 60.0f, 0.0f, 0.0f, 1.0f);
            }
            this.func_110777_b(entity);
            GL11.glDisable(2896);
            ((BlockTFSlider)block).setBlockBoundsBasedOnMeta(meta);
            this.renderBlocks.func_147775_a(block);
            this.renderBlocks.func_147749_a(block, world, bx, by, bz, meta);
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }
    
    protected ResourceLocation func_110775_a(final Entity p_110775_1_) {
        return TextureMap.field_110575_b;
    }
}
