// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

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
            renderer.func_78570_q(block, x, y, z);
            if (renderer.field_83021_g > 0.0) {
                final double originalMaxZ = renderer.field_83022_l;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 7L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.field_83026_h = renderer.field_83021_g;
                renderer.field_83021_g -= 0.0625;
                renderer.field_83025_k += num0 / 16.0f;
                if (renderer.field_83022_l - (num2 + num3 + num4) / 16.0f > renderer.field_83025_k) {
                    renderer.field_83022_l = renderer.field_83025_k + num2 / 16.0f;
                    renderer.func_78570_q(block, x, y, z);
                    renderer.field_83022_l = originalMaxZ - num3 / 16.0f;
                    renderer.field_83025_k = renderer.field_83022_l - num4 / 16.0f;
                    renderer.func_78570_q(block, x, y, z);
                }
                else {
                    renderer.field_83022_l -= num3 / 16.0f;
                    renderer.func_78570_q(block, x, y, z);
                }
                renderer.func_83018_a(block);
            }
            if (renderer.field_83026_h < 1.0) {
                final double originalMaxZ = renderer.field_83022_l;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 17L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.field_83021_g = renderer.field_83026_h;
                renderer.field_83026_h += 0.0625;
                renderer.field_83025_k += num0 / 16.0f;
                if (renderer.field_83022_l - (num2 + num3 + num4) / 16.0f > renderer.field_83025_k) {
                    renderer.field_83022_l = renderer.field_83025_k + num2 / 16.0f;
                    renderer.func_78570_q(block, x, y, z);
                    renderer.field_83022_l = originalMaxZ - num3 / 16.0f;
                    renderer.field_83025_k = renderer.field_83022_l - num4 / 16.0f;
                    renderer.func_78570_q(block, x, y, z);
                }
                else {
                    renderer.field_83022_l -= num3 / 16.0f;
                    renderer.func_78570_q(block, x, y, z);
                }
                renderer.func_83018_a(block);
            }
            if (renderer.field_83025_k > 0.0) {
                final double originalMaxX = renderer.field_83026_h;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 23L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.field_83022_l = renderer.field_83025_k;
                renderer.field_83025_k -= 0.0625;
                renderer.field_83021_g += num0 / 16.0f;
                renderer.field_83026_h = renderer.field_83021_g + num2 / 16.0f;
                renderer.func_78570_q(block, x, y, z);
                renderer.field_83026_h = originalMaxX - num3 / 16.0f;
                renderer.field_83021_g = renderer.field_83026_h - num4 / 16.0f;
                renderer.func_78570_q(block, x, y, z);
                renderer.func_83018_a(block);
            }
            if (renderer.field_83022_l < 1.0) {
                final double originalMaxX = renderer.field_83026_h;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 11L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.field_83025_k = renderer.field_83022_l;
                renderer.field_83022_l += 0.0625;
                renderer.field_83021_g += num0 / 16.0f;
                renderer.field_83026_h = renderer.field_83021_g + num2 / 16.0f;
                renderer.func_78570_q(block, x, y, z);
                renderer.field_83026_h = originalMaxX - num3 / 16.0f;
                renderer.field_83021_g = renderer.field_83026_h - num4 / 16.0f;
                renderer.func_78570_q(block, x, y, z);
                renderer.func_83018_a(block);
            }
        }
        else if (meta == 5) {
            renderer.field_83027_i = renderer.field_83024_j;
            renderer.func_78570_q(block, x, y, z);
            renderer.field_83027_i = 0.0;
            renderer.field_83024_j -= 0.009999999776482582;
            renderer.field_83021_g += 0.0625;
            renderer.field_83025_k += 0.0625;
            renderer.field_83026_h -= 0.0625;
            renderer.field_83022_l -= 0.0625;
            renderer.func_78570_q(block, x, y, z);
        }
        else if (meta == 4) {
            renderer.func_78595_a();
            renderer.func_83020_a(0.25, 0.375, 0.25, 0.8125, 0.375, 0.8125);
            renderer.func_78570_q(block, x, y, z);
            renderer.field_78664_d = BlockTFPlant.mayappleSide;
            renderer.func_83020_a(0.5, 0.0, 0.5, 0.5625, 0.37437498569488525, 0.5625);
            renderer.func_78570_q(block, x, y, z);
            renderer.func_78595_a();
        }
        else if (meta == 14) {
            renderer.func_78614_n(block, x, y, z);
        }
        else {
            renderer.func_78620_l(block, x, y, z);
        }
        return true;
    }
    
    public boolean shouldRender3DInInventory() {
        return false;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
