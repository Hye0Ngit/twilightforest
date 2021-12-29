// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;

public class ComponentNagaCourtyardWallCornerAlt extends ComponentNagaCourtyardWallAbstract
{
    public ComponentNagaCourtyardWallCornerAlt() {
        super(new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner"), new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner_decayed"));
    }
    
    public ComponentNagaCourtyardWallCornerAlt(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner"), new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner_decayed"));
    }
}
