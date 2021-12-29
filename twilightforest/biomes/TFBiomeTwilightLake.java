// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.passive.EntitySquid;

public class TFBiomeTwilightLake extends TFBiomeBase
{
    public TFBiomeTwilightLake(final int i) {
        super(i);
        this.field_76750_F = 0.66f;
        this.field_76751_G = 1.0f;
        this.field_76755_L.add(new BiomeGenBase.SpawnListEntry((Class)EntitySquid.class, 10, 4, 4));
    }
}
