// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.biome.Biome;

public class TFBiomeMushrooms extends TFBiomeBase
{
    public TFBiomeMushrooms(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().setTreesPerChunk(8);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setBigMushroomsPerChunk(2);
        this.getTFBiomeDecorator().alternateCanopyChance = 0.2f;
    }
}
