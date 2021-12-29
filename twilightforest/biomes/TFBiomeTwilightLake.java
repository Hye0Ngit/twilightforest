// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.Biome;

public class TFBiomeTwilightLake extends TFBiomeBase
{
    public TFBiomeTwilightLake(final Biome.BiomeProperties props) {
        super(props);
        this.field_76755_L.add(new Biome.SpawnListEntry((Class)EntitySquid.class, 10, 4, 4));
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.QUEST_ISLAND;
    }
}
