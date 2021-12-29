// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.IIcon;
import twilightforest.block.TFBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFThorns implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFThorns(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        renderInvBlock(renderer, block, metadata);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        final int l = block.func_149720_d(world, x, y, z);
        final float f = (l >> 16 & 0xFF) / 255.0f;
        final float f2 = (l >> 8 & 0xFF) / 255.0f;
        final float f3 = (l & 0xFF) / 255.0f;
        final int metadata = world.func_72805_g(x, y, z);
        final int type = metadata & 0xC;
        switch (type) {
            default: {
                return this.renderCactusLikeY(block, x, y, z, f, f2, f3, metadata, world, renderer);
            }
            case 4: {
                return this.renderCactusLikeX(block, x, y, z, f, f2, f3, metadata, world, renderer);
            }
            case 8: {
                return this.renderCactusLikeZ(block, x, y, z, f, f2, f3, metadata, world, renderer);
            }
        }
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public boolean renderCactusLikeX(final Block block, final int x, final int y, final int z, final float red, final float green, final float blue, final int metadata, final IBlockAccess world, final RenderBlocks renderer) {
        this.setUVRotationX(renderer);
        final Tessellator tessellator = Tessellator.field_78398_a;
        final float middle = 0.5f;
        final float full = 1.0f;
        final float f5 = 0.8f;
        final float f6 = 0.6f;
        final float bRed = middle * red;
        final float tRed = full * red;
        final float zRed = f5 * red;
        final float xRed = f6 * red;
        final float bGreen = middle * green;
        final float tGreen = full * green;
        final float zGreen = f5 * green;
        final float xGreen = f6 * green;
        final float bBlue = middle * blue;
        final float tBlue = full * blue;
        final float zBlue = f5 * blue;
        final float xBlue = f6 * blue;
        final float onePixel = 0.1875f;
        final int blockBrightness = block.func_149677_c(renderer.field_147845_a, x, y, z);
        if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x - 1, y, z, 4)) {
            tessellator.func_78380_c((renderer.field_147859_h > 0.0) ? blockBrightness : block.func_149677_c(renderer.field_147845_a, x - 1, y, z));
            tessellator.func_78386_a(bRed, bGreen, bBlue);
            renderer.func_147798_e(block, (double)x, (double)y, (double)z, renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 4));
        }
        if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x + 1, y, z, 5)) {
            tessellator.func_78380_c((renderer.field_147861_i < 1.0) ? blockBrightness : block.func_149677_c(renderer.field_147845_a, x + 1, y, z));
            tessellator.func_78386_a(tRed, tGreen, tBlue);
            renderer.func_147764_f(block, (double)x, (double)y, (double)z, renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 5));
        }
        this.drawXSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, onePixel, blockBrightness);
        this.resetUVRotation(renderer);
        if (this.canConnectTo(world, x, y, z + 1)) {
            this.setUVRotationZ(renderer);
            renderer.func_147782_a(0.0, 0.0, (double)(1.0f - onePixel), 1.0, 1.0, 1.0);
            this.drawZSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x, y, z - 1)) {
            this.setUVRotationZ(renderer);
            renderer.func_147782_a(0.0, 0.0, 0.0, 1.0, 1.0, (double)onePixel);
            this.drawZSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x, y + 1, z)) {
            this.resetUVRotation(renderer);
            renderer.func_147782_a(0.0, (double)(1.0f - onePixel), 0.0, 1.0, 1.0, 1.0);
            this.drawYSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
        }
        if (this.canConnectTo(world, x, y - 1, z)) {
            this.resetUVRotation(renderer);
            renderer.func_147782_a(0.0, 0.0, 0.0, 1.0, (double)onePixel, 1.0);
            this.drawYSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
        }
        return true;
    }
    
    public boolean renderCactusLikeY(final Block block, final int x, final int y, final int z, final float red, final float green, final float blue, final int metadata, final IBlockAccess world, final RenderBlocks renderer) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        final float middle = 0.5f;
        final float full = 1.0f;
        final float f5 = 0.8f;
        final float f6 = 0.6f;
        final float bRed = middle * red;
        final float tRed = full * red;
        final float zRed = f5 * red;
        final float xRed = f6 * red;
        final float bGreen = middle * green;
        final float tGreen = full * green;
        final float zGreen = f5 * green;
        final float xGreen = f6 * green;
        final float bBlue = middle * blue;
        final float tBlue = full * blue;
        final float zBlue = f5 * blue;
        final float xBlue = f6 * blue;
        final float onePixel = 0.1875f;
        final int blockBrightness = block.func_149677_c(world, x, y, z);
        if (renderer.field_147837_f || block.func_149646_a(world, x, y - 1, z, 0)) {
            tessellator.func_78380_c((renderer.field_147855_j > 0.0) ? blockBrightness : block.func_149677_c(world, x, y - 1, z));
            tessellator.func_78386_a(bRed, bGreen, bBlue);
            renderer.func_147768_a(block, (double)x, (double)y, (double)z, renderer.func_147793_a(block, world, x, y, z, 0));
        }
        if (renderer.field_147837_f || block.func_149646_a(world, x, y + 1, z, 1)) {
            tessellator.func_78380_c((renderer.field_147857_k < 1.0) ? blockBrightness : block.func_149677_c(world, x, y + 1, z));
            tessellator.func_78386_a(tRed, tGreen, tBlue);
            renderer.func_147806_b(block, (double)x, (double)y, (double)z, renderer.func_147793_a(block, world, x, y, z, 1));
        }
        this.drawYSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, onePixel, blockBrightness);
        if (this.canConnectTo(world, x + 1, y, z)) {
            this.setUVRotationX(renderer);
            renderer.func_147782_a((double)(1.0f - onePixel), 0.0, 0.0, 1.0, 1.0, 1.0);
            this.drawXSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x - 1, y, z)) {
            this.setUVRotationX(renderer);
            renderer.func_147782_a(0.0, 0.0, 0.0, (double)onePixel, 1.0, 1.0);
            this.drawXSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x, y, z + 1)) {
            this.setUVRotationZ(renderer);
            renderer.func_147782_a(0.0, 0.0, (double)(1.0f - onePixel), 1.0, 1.0, 1.0);
            this.drawZSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x, y, z - 1)) {
            this.setUVRotationZ(renderer);
            renderer.func_147782_a(0.0, 0.0, 0.0, 1.0, 1.0, (double)onePixel);
            this.drawZSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        return true;
    }
    
    public boolean renderCactusLikeZ(final Block block, final int x, final int y, final int z, final float red, final float green, final float blue, final int metadata, final IBlockAccess world, final RenderBlocks renderer) {
        this.setUVRotationZ(renderer);
        final Tessellator tessellator = Tessellator.field_78398_a;
        final float middle = 0.5f;
        final float full = 1.0f;
        final float f5 = 0.8f;
        final float f6 = 0.6f;
        final float bRed = middle * red;
        final float tRed = full * red;
        final float zRed = f5 * red;
        final float xRed = f6 * red;
        final float bGreen = middle * green;
        final float tGreen = full * green;
        final float zGreen = f5 * green;
        final float xGreen = f6 * green;
        final float bBlue = middle * blue;
        final float tBlue = full * blue;
        final float zBlue = f5 * blue;
        final float xBlue = f6 * blue;
        final float onePixel = 0.1875f;
        final int blockBrightness = block.func_149677_c(renderer.field_147845_a, x, y, z);
        if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x, y, z - 1, 0)) {
            tessellator.func_78380_c((renderer.field_147851_l > 0.0) ? blockBrightness : block.func_149677_c(renderer.field_147845_a, x, y, z - 1));
            tessellator.func_78386_a(bRed, bGreen, bBlue);
            renderer.func_147761_c(block, (double)x, (double)y, (double)z, renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 2));
        }
        if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x, y, z + 1, 1)) {
            tessellator.func_78380_c((renderer.field_147853_m < 1.0) ? blockBrightness : block.func_149677_c(renderer.field_147845_a, x, y, z + 1));
            tessellator.func_78386_a(tRed, tGreen, tBlue);
            renderer.func_147734_d(block, (double)x, (double)y, (double)z, renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 3));
        }
        this.drawZSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, onePixel, blockBrightness);
        this.resetUVRotation(renderer);
        if (this.canConnectTo(world, x + 1, y, z)) {
            this.setUVRotationX(renderer);
            renderer.func_147782_a((double)(1.0f - onePixel), 0.0, 0.0, 1.0, 1.0, 1.0);
            this.drawXSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x - 1, y, z)) {
            this.setUVRotationX(renderer);
            renderer.func_147782_a(0.0, 0.0, 0.0, (double)onePixel, 1.0, 1.0);
            this.drawXSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
            this.resetUVRotation(renderer);
        }
        if (this.canConnectTo(world, x, y + 1, z)) {
            this.resetUVRotation(renderer);
            renderer.func_147782_a(0.0, (double)(1.0f - onePixel), 0.0, 1.0, 1.0, 1.0);
            this.drawYSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
        }
        if (this.canConnectTo(world, x, y - 1, z)) {
            this.resetUVRotation(renderer);
            renderer.func_147782_a(0.0, 0.0, 0.0, 1.0, (double)onePixel, 1.0);
            this.drawYSides(block, x, y, z, renderer, metadata, zRed, xRed, zGreen, xGreen, zBlue, xBlue, 0.18900001f, blockBrightness);
        }
        return true;
    }
    
    private void drawXSides(final Block block, final int x, final int y, final int z, final RenderBlocks renderer, final int metadata, final float zRed, final float xRed, final float zGreen, final float xGreen, final float zBlue, final float xBlue, final float onePixel, final int l) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(l);
        tessellator.func_78386_a(zRed, zGreen, zBlue);
        tessellator.func_78372_c(0.0f, 0.0f, onePixel);
        renderer.func_147761_c(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, 0.0f, -onePixel);
        tessellator.func_78372_c(0.0f, 0.0f, -onePixel);
        renderer.func_147734_d(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, 0.0f, onePixel);
        tessellator.func_78386_a(xRed, xGreen, xBlue);
        tessellator.func_78372_c(0.0f, onePixel, 0.0f);
        renderer.func_147768_a(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, -onePixel, 0.0f);
        tessellator.func_78372_c(0.0f, -onePixel, 0.0f);
        renderer.func_147806_b(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, onePixel, 0.0f);
    }
    
    private void drawYSides(final Block block, final int x, final int y, final int z, final RenderBlocks renderer, final int metadata, final float zRed, final float xRed, final float zGreen, final float xGreen, final float zBlue, final float xBlue, final float onePixel, final int blockBrightness) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(blockBrightness);
        tessellator.func_78386_a(zRed, zGreen, zBlue);
        tessellator.func_78372_c(0.0f, 0.0f, onePixel);
        renderer.func_147761_c(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, 0.0f, -onePixel);
        tessellator.func_78372_c(0.0f, 0.0f, -onePixel);
        renderer.func_147734_d(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, 0.0f, onePixel);
        tessellator.func_78386_a(xRed, xGreen, xBlue);
        tessellator.func_78372_c(onePixel, 0.0f, 0.0f);
        renderer.func_147798_e(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(-onePixel, 0.0f, 0.0f);
        tessellator.func_78372_c(-onePixel, 0.0f, 0.0f);
        renderer.func_147764_f(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(onePixel, 0.0f, 0.0f);
    }
    
    private void drawZSides(final Block block, final int x, final int y, final int z, final RenderBlocks renderer, final int metadata, final float zRed, final float xRed, final float zGreen, final float xGreen, final float zBlue, final float xBlue, final float onePixel, final int blockBrightness) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(blockBrightness);
        tessellator.func_78386_a(xRed, xGreen, xBlue);
        tessellator.func_78372_c(onePixel, 0.0f, 0.0f);
        renderer.func_147798_e(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(-onePixel, 0.0f, 0.0f);
        tessellator.func_78372_c(-onePixel, 0.0f, 0.0f);
        renderer.func_147764_f(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(onePixel, 0.0f, 0.0f);
        tessellator.func_78386_a(zRed, zGreen, zBlue);
        tessellator.func_78372_c(0.0f, onePixel, 0.0f);
        renderer.func_147768_a(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, -onePixel, 0.0f);
        tessellator.func_78372_c(0.0f, -onePixel, 0.0f);
        renderer.func_147806_b(block, (double)x, (double)y, (double)z, this.getSideIcon(block, metadata));
        tessellator.func_78372_c(0.0f, onePixel, 0.0f);
    }
    
    private boolean canConnectTo(final IBlockAccess world, final int x, final int y, final int z) {
        final Block block = world.func_147439_a(x, y, z);
        return block == TFBlocks.thorns || block == TFBlocks.burntThorns || block == TFBlocks.thornRose;
    }
    
    private void setUVRotationX(final RenderBlocks renderer) {
        renderer.field_147875_q = 1;
        renderer.field_147873_r = 1;
        renderer.field_147867_u = 1;
        renderer.field_147865_v = 1;
    }
    
    private void setUVRotationZ(final RenderBlocks renderer) {
        renderer.field_147871_s = 1;
        renderer.field_147869_t = 1;
    }
    
    private void resetUVRotation(final RenderBlocks renderer) {
        renderer.field_147867_u = 0;
        renderer.field_147865_v = 0;
        renderer.field_147875_q = 0;
        renderer.field_147873_r = 0;
        renderer.field_147869_t = 0;
        renderer.field_147871_s = 0;
    }
    
    private IIcon getSideIcon(final Block block, final int metadata) {
        return block.func_149691_a(2, metadata & 0x3);
    }
    
    public static void renderInvBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderInvBlock(renderblocks, par1Block, meta, tessellator);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.func_149683_g();
    }
    
    protected static void renderInvBlock(final RenderBlocks renderblocks, final Block par1Block, final int meta, final Tessellator tessellator) {
        final float onePixel = 0.1875f;
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, -1.0f, 0.0f);
        renderblocks.func_147768_a(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(0, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 1.0f, 0.0f);
        renderblocks.func_147806_b(par1Block, 0.0, 0.0, 0.0, par1Block.func_149691_a(1, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, -1.0f);
        renderblocks.func_147764_f(par1Block, (double)(-onePixel), 0.0, 0.0, par1Block.func_149691_a(2, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, 1.0f);
        renderblocks.func_147798_e(par1Block, (double)onePixel, 0.0, 0.0, par1Block.func_149691_a(3, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(-1.0f, 0.0f, 0.0f);
        renderblocks.func_147761_c(par1Block, 0.0, 0.0, (double)onePixel, par1Block.func_149691_a(4, meta));
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(1.0f, 0.0f, 0.0f);
        renderblocks.func_147734_d(par1Block, 0.0, 0.0, (double)(-onePixel), par1Block.func_149691_a(5, meta));
        tessellator.func_78381_a();
    }
}
