// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.blocks;

import twilightforest.block.BlockTFPlant;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTFPlants implements ISimpleBlockRenderingHandler
{
    final int renderID;
    
    public RenderBlockTFPlants(final int blockRenderID) {
        this.renderID = blockRenderID;
    }
    
    public void renderInventoryBlock(final aqw block, final int metadata, final int modelID, final bfo renderer) {
    }
    
    public boolean renderWorldBlock(final ace world, final int x, final int y, final int z, final aqw block, final int modelId, final bfo renderer) {
        final int meta = world.h(x, y, z);
        if (meta == 3) {
            renderer.p(block, x, y, z);
            if (renderer.g > 0.0) {
                final double originalMaxZ = renderer.l;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 7L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.h = renderer.g;
                renderer.g -= 0.0625;
                renderer.k += num0 / 16.0f;
                if (renderer.l - (num2 + num3 + num4) / 16.0f > renderer.k) {
                    renderer.l = renderer.k + num2 / 16.0f;
                    renderer.p(block, x, y, z);
                    renderer.l = originalMaxZ - num3 / 16.0f;
                    renderer.k = renderer.l - num4 / 16.0f;
                    renderer.p(block, x, y, z);
                }
                else {
                    renderer.l -= num3 / 16.0f;
                    renderer.p(block, x, y, z);
                }
                renderer.a(block);
            }
            if (renderer.h < 1.0) {
                final double originalMaxZ = renderer.l;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 17L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.g = renderer.h;
                renderer.h += 0.0625;
                renderer.k += num0 / 16.0f;
                if (renderer.l - (num2 + num3 + num4) / 16.0f > renderer.k) {
                    renderer.l = renderer.k + num2 / 16.0f;
                    renderer.p(block, x, y, z);
                    renderer.l = originalMaxZ - num3 / 16.0f;
                    renderer.k = renderer.l - num4 / 16.0f;
                    renderer.p(block, x, y, z);
                }
                else {
                    renderer.l -= num3 / 16.0f;
                    renderer.p(block, x, y, z);
                }
                renderer.a(block);
            }
            if (renderer.k > 0.0) {
                final double originalMaxX = renderer.h;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 23L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.l = renderer.k;
                renderer.k -= 0.0625;
                renderer.g += num0 / 16.0f;
                renderer.h = renderer.g + num2 / 16.0f;
                renderer.p(block, x, y, z);
                renderer.h = originalMaxX - num3 / 16.0f;
                renderer.g = renderer.h - num4 / 16.0f;
                renderer.p(block, x, y, z);
                renderer.a(block);
            }
            if (renderer.l < 1.0) {
                final double originalMaxX = renderer.h;
                long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
                seed = seed * seed * 42317861L + seed * 11L;
                final int num0 = (int)(seed >> 12 & 0x3L) + 1;
                final int num2 = (int)(seed >> 15 & 0x3L) + 1;
                final int num3 = (int)(seed >> 18 & 0x3L) + 1;
                final int num4 = (int)(seed >> 21 & 0x3L) + 1;
                renderer.k = renderer.l;
                renderer.l += 0.0625;
                renderer.g += num0 / 16.0f;
                renderer.h = renderer.g + num2 / 16.0f;
                renderer.p(block, x, y, z);
                renderer.h = originalMaxX - num3 / 16.0f;
                renderer.g = renderer.h - num4 / 16.0f;
                renderer.p(block, x, y, z);
                renderer.a(block);
            }
        }
        else if (meta == 5) {
            renderer.i = renderer.j;
            renderer.p(block, x, y, z);
            renderer.i = 0.0;
            renderer.j -= 0.009999999776482582;
            renderer.g += 0.0625;
            renderer.k += 0.0625;
            renderer.h -= 0.0625;
            renderer.l -= 0.0625;
            renderer.p(block, x, y, z);
        }
        else if (meta == 4) {
            renderer.a();
            renderer.a(0.25, 0.375, 0.25, 0.8125, 0.375, 0.8125);
            renderer.p(block, x, y, z);
            renderer.d = BlockTFPlant.mayappleSide;
            renderer.a(0.5, 0.0, 0.5, 0.5625, 0.37437498569488525, 0.5625);
            renderer.p(block, x, y, z);
            renderer.a();
        }
        else if (meta == 14) {
            renderer.m(block, x, y, z);
        }
        else {
            renderer.k(block, x, y, z);
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
