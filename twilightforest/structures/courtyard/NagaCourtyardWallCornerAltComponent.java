// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class NagaCourtyardWallCornerAltComponent extends NagaCourtyardWallAbstractComponent
{
    public NagaCourtyardWallCornerAltComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(manager, NagaCourtyardPieces.TFNCWA, nbt, new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner"), new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner_decayed"));
    }
    
    public NagaCourtyardWallCornerAltComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCWA, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner"), new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_inner_decayed"));
    }
}
