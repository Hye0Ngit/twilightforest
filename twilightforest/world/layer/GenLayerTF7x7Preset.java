// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import twilightforest.biomes.TFBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTF7x7Preset extends GenLayer
{
    char[][] preset;
    
    public GenLayerTF7x7Preset(final long seed) {
        super(seed);
        this.preset = new char[9][9];
        this.initPresets();
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] dest = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                final int sx = x + dx + 4;
                final int sz = z + dz + 4;
                if (sx >= 0 && sx < 8 && sz >= 0 && sz < 8) {
                    dest[dx + dz * width] = Biome.func_185362_a(this.getBiomeFor(this.preset[sx][sz]));
                }
                else {
                    dest[dx + dz * width] = Biome.func_185362_a(Biomes.field_76771_b);
                }
            }
        }
        return dest;
    }
    
    private void initPresets() {
        final char[][] map = { { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'H', 'H', 'H', 'H', 'D', 'D', 'D', 'P' }, { 'P', 'H', 'H', 'H', 'H', 'D', 'D', 'D', 'P' }, { 'P', 'F', 'f', 'F', 'm', 'M', 'D', 'D', 'P' }, { 'P', 'F', 'F', 'F', 'C', 'm', 'D', 'D', 'P' }, { 'P', 'F', 'f', 'f', 'F', 'E', 'O', 'O', 'P' }, { 'P', 'S', 'S', 'S', 'L', 'L', 'O', 'G', 'P' }, { 'P', 'Y', 'S', 'S', 'L', 'L', 'O', 'G', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' } };
        for (int x = 0; x < map.length; ++x) {
            for (int z = 0; z < map[x].length; ++z) {
                this.preset[x][z] = map[z][x];
            }
        }
    }
    
    protected final Biome getBiomeFor(final char c) {
        switch (c) {
            default: {
                return Biomes.field_76771_b;
            }
            case 'F': {
                return TFBiomes.twilightForest;
            }
            case 'f': {
                return TFBiomes.denseTwilightForest;
            }
            case 'E': {
                return TFBiomes.enchantedForest;
            }
            case 'm': {
                return TFBiomes.mushrooms;
            }
            case 'M': {
                return TFBiomes.deepMushrooms;
            }
            case 'C': {
                return TFBiomes.clearing;
            }
            case 'S': {
                return TFBiomes.tfSwamp;
            }
            case 'Y': {
                return TFBiomes.fireSwamp;
            }
            case 'D': {
                return TFBiomes.darkForest;
            }
            case 'L': {
                return TFBiomes.tfLake;
            }
            case 'O': {
                return TFBiomes.snowy_forest;
            }
            case 'G': {
                return TFBiomes.glacier;
            }
            case 'H': {
                return TFBiomes.highlands;
            }
        }
    }
}
