// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTF7x7Preset extends akn
{
    acp[][] preset;
    
    public GenLayerTF7x7Preset(final long par1) {
        super(par1);
        this.preset = new acp[9][9];
        this.initPresets();
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] dest = akl.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int sx = x + dx + 4;
                final int sz = z + dz + 4;
                if (sx >= 0 && sx < 8 && sz >= 0 && sz < 8) {
                    dest[dx + dz * width] = this.preset[sx][sz].N;
                }
                else {
                    dest[dx + dz * width] = acp.b.N;
                }
            }
        }
        return dest;
    }
    
    private void initPresets() {
        final char[][] map = { { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'H', 'H', 'H', 'H', 'D', 'D', 'D', 'P' }, { 'P', 'H', 'H', 'H', 'H', 'D', 'D', 'D', 'P' }, { 'P', 'F', 'f', 'F', 'm', 'M', 'D', 'D', 'P' }, { 'P', 'F', 'F', 'F', 'C', 'm', 'D', 'D', 'P' }, { 'P', 'F', 'f', 'f', 'F', 'E', 'O', 'O', 'P' }, { 'P', 'S', 'S', 'S', 'L', 'L', 'O', 'G', 'P' }, { 'P', 'Y', 'S', 'S', 'L', 'L', 'O', 'G', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' } };
        for (int x = 0; x < map.length; ++x) {
            for (int z = 0; z < map[x].length; ++z) {
                this.preset[x][z] = this.getBiomeFor(map[z][x]);
            }
        }
    }
    
    protected acp getBiomeFor(final char c) {
        switch (c) {
            default: {
                return acp.b;
            }
            case 'F': {
                return TFBiomeBase.twilightForest;
            }
            case 'f': {
                return TFBiomeBase.twilightForest2;
            }
            case 'E': {
                return TFBiomeBase.enchantedForest;
            }
            case 'm': {
                return TFBiomeBase.mushrooms;
            }
            case 'M': {
                return TFBiomeBase.deepMushrooms;
            }
            case 'C': {
                return TFBiomeBase.clearing;
            }
            case 'S': {
                return TFBiomeBase.swamp;
            }
            case 'Y': {
                return TFBiomeBase.fireSwamp;
            }
            case 'D': {
                return TFBiomeBase.darkForest;
            }
            case 'L': {
                return TFBiomeBase.tfLake;
            }
            case 'O': {
                return TFBiomeBase.snow;
            }
            case 'G': {
                return TFBiomeBase.glacier;
            }
            case 'H': {
                return TFBiomeBase.highlands;
            }
        }
    }
}
