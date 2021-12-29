// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.biome.Biome;

public class TFBiomeStream extends TFBiomeBase
{
    public TFBiomeStream(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(2);
        this.field_76762_K.clear();
    }
}
