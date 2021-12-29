// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.world.biome.Biome;

public class TFBiomeDeepMushrooms extends TFBiomeBase
{
    public TFBiomeDeepMushrooms(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(12);
        this.getTFBiomeDecorator().setBigMushroomsPerChunk(8);
        this.getTFBiomeDecorator().myceliumPerChunk = 3;
        this.getTFBiomeDecorator().alternateCanopyChance = 0.9f;
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.MUSHROOM_TOWER;
    }
}
