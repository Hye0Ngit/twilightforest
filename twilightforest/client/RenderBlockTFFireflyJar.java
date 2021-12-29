// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import twilightforest.block.BlockTFFireflyJar;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFFireflyJar implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFFireflyJar(final int blockComplexRenderID) {
        this.renderID = blockComplexRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        renderInvJar(renderer, block, metadata);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        return renderJar(renderer, world, x, y, z, block);
    }
    
    public boolean shouldRender3DInInventory() {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
    
    public static boolean renderJar(final RenderBlocks renderblocks, final IBlockAccess world, final int x, final int y, final int z, final Block block) {
        renderblocks.func_78595_a();
        renderblocks.func_83020_a(0.1875, 0.0, 0.1875, 0.8125, 0.875, 0.8125);
        renderblocks.func_78570_q(block, x, y, z);
        renderblocks.field_78664_d = BlockTFFireflyJar.jarCork;
        renderblocks.func_83020_a(0.25, 0.75, 0.25, 0.75, 1.0, 0.75);
        renderblocks.func_78570_q(block, x, y, z);
        renderblocks.func_78595_a();
        block.func_71919_f();
        return true;
    }
    
    public static void renderInvJar(final RenderBlocks renderblocks, final Block par1Block, final int meta) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        renderblocks.func_83020_a(0.1875, 0.0, 0.1875, 0.8125, 0.875, 0.8125);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, -1.0f, 0.0f);
        renderblocks.func_78613_a(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarTop);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 1.0f, 0.0f);
        renderblocks.func_78617_b(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarTop);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, -1.0f);
        renderblocks.func_78605_f(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, 1.0f);
        renderblocks.func_78573_e(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(-1.0f, 0.0f, 0.0f);
        renderblocks.func_78611_c(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(1.0f, 0.0f, 0.0f);
        renderblocks.func_78622_d(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarSide);
        tessellator.func_78381_a();
        renderblocks.func_83020_a(0.25, 0.75, 0.25, 0.75, 1.0, 0.75);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, -1.0f, 0.0f);
        renderblocks.func_78613_a(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 1.0f, 0.0f);
        renderblocks.func_78617_b(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, -1.0f);
        renderblocks.func_78605_f(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0f, 0.0f, 1.0f);
        renderblocks.func_78573_e(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(-1.0f, 0.0f, 0.0f);
        renderblocks.func_78611_c(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78375_b(1.0f, 0.0f, 0.0f);
        renderblocks.func_78622_d(par1Block, 0.0, 0.0, 0.0, BlockTFFireflyJar.jarCork);
        tessellator.func_78381_a();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.func_71919_f();
    }
}
