// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;

public class ComponentNagaCourtyardHedgePadder extends ComponentNagaCourtyardHedgeAbstract
{
    public ComponentNagaCourtyardHedgePadder() {
        super(new ResourceLocation("twilightforest", "courtyard/hedge_between"), new ResourceLocation("twilightforest", "courtyard/hedge_between_big"));
    }
    
    public ComponentNagaCourtyardHedgePadder(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_between"), new ResourceLocation("twilightforest", "courtyard/hedge_between_big"));
    }
}
