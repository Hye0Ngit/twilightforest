// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import twilightforest.block.BlockTFPlant;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFPlants implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFPlants(final int blockRenderID) {
        this.renderID = blockRenderID;
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 3) {
            this.renderMossPatch(x, y, z, block, renderer);
        }
        else if (meta == 5) {
            this.renderCloverPatch(x, y, z, block, renderer);
        }
        else if (meta == 4) {
            this.renderMayapple(x, y, z, block, renderer);
        }
        else if (meta == 14) {
            renderer.func_147796_n(block, x, y, z);
        }
        else {
            renderer.func_147746_l(block, x, y, z);
        }
        return true;
    }
    
    private void renderMayapple(final int x, final int y, final int z, final Block block, final RenderBlocks renderer) {
        renderer.func_147771_a();
        renderer.func_147782_a(0.25, 0.375, 0.25, 0.8125, 0.375, 0.8125);
        renderer.func_147784_q(block, x, y, z);
        renderer.field_147840_d = BlockTFPlant.mayappleSide;
        renderer.func_147782_a(0.5, 0.0, 0.5, 0.5625, 0.37437498569488525, 0.5625);
        renderer.func_147784_q(block, x, y, z);
        renderer.func_147771_a();
    }
    
    private void renderCloverPatch(final int x, final int y, final int z, final Block block, final RenderBlocks renderer) {
        renderer.field_147855_j = renderer.field_147857_k;
        renderer.func_147784_q(block, x, y, z);
        renderer.field_147855_j = 0.0;
        renderer.field_147857_k -= 0.009999999776482582;
        renderer.field_147859_h += 0.0625;
        renderer.field_147851_l += 0.0625;
        renderer.field_147861_i -= 0.0625;
        renderer.field_147853_m -= 0.0625;
        renderer.func_147784_q(block, x, y, z);
    }
    
    private void renderMossPatch(final int x, final int y, final int z, final Block block, final RenderBlocks renderer) {
        renderer.func_147784_q(block, x, y, z);
        if (renderer.field_147859_h > 0.0) {
            final double originalMaxZ = renderer.field_147853_m;
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 7L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            renderer.field_147861_i = renderer.field_147859_h;
            renderer.field_147859_h -= 0.0625;
            renderer.field_147851_l += num0 / 16.0f;
            if (renderer.field_147853_m - (num2 + num3 + num4) / 16.0f > renderer.field_147851_l) {
                renderer.field_147853_m = renderer.field_147851_l + num2 / 16.0f;
                renderer.func_147784_q(block, x, y, z);
                renderer.field_147853_m = originalMaxZ - num3 / 16.0f;
                renderer.field_147851_l = renderer.field_147853_m - num4 / 16.0f;
                renderer.func_147784_q(block, x, y, z);
            }
            else {
                renderer.field_147853_m -= num3 / 16.0f;
                renderer.func_147784_q(block, x, y, z);
            }
            renderer.func_147775_a(block);
        }
        if (renderer.field_147861_i < 1.0) {
            final double originalMaxZ = renderer.field_147853_m;
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 17L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            renderer.field_147859_h = renderer.field_147861_i;
            renderer.field_147861_i += 0.0625;
            renderer.field_147851_l += num0 / 16.0f;
            if (renderer.field_147853_m - (num2 + num3 + num4) / 16.0f > renderer.field_147851_l) {
                renderer.field_147853_m = renderer.field_147851_l + num2 / 16.0f;
                renderer.func_147784_q(block, x, y, z);
                renderer.field_147853_m = originalMaxZ - num3 / 16.0f;
                renderer.field_147851_l = renderer.field_147853_m - num4 / 16.0f;
                renderer.func_147784_q(block, x, y, z);
            }
            else {
                renderer.field_147853_m -= num3 / 16.0f;
                renderer.func_147784_q(block, x, y, z);
            }
            renderer.func_147775_a(block);
        }
        if (renderer.field_147851_l > 0.0) {
            final double originalMaxX = renderer.field_147861_i;
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 23L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            renderer.field_147853_m = renderer.field_147851_l;
            renderer.field_147851_l -= 0.0625;
            renderer.field_147859_h += num0 / 16.0f;
            renderer.field_147861_i = renderer.field_147859_h + num2 / 16.0f;
            renderer.func_147784_q(block, x, y, z);
            renderer.field_147861_i = originalMaxX - num3 / 16.0f;
            renderer.field_147859_h = renderer.field_147861_i - num4 / 16.0f;
            renderer.func_147784_q(block, x, y, z);
            renderer.func_147775_a(block);
        }
        if (renderer.field_147853_m < 1.0) {
            final double originalMaxX = renderer.field_147861_i;
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 11L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            renderer.field_147851_l = renderer.field_147853_m;
            renderer.field_147853_m += 0.0625;
            renderer.field_147859_h += num0 / 16.0f;
            renderer.field_147861_i = renderer.field_147859_h + num2 / 16.0f;
            renderer.func_147784_q(block, x, y, z);
            renderer.field_147861_i = originalMaxX - num3 / 16.0f;
            renderer.field_147859_h = renderer.field_147861_i - num4 / 16.0f;
            renderer.func_147784_q(block, x, y, z);
            renderer.func_147775_a(block);
        }
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return false;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
