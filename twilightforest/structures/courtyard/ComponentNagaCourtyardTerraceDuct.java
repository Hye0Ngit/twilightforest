// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;

public class ComponentNagaCourtyardTerraceDuct extends ComponentNagaCourtyardTerraceAbstract
{
    public ComponentNagaCourtyardTerraceDuct() {
        super(new ResourceLocation("twilightforest", "courtyard/terrace_duct"));
    }
    
    public ComponentNagaCourtyardTerraceDuct(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/terrace_duct"));
    }
}
