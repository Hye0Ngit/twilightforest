// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class NagaCourtyardWallCornerComponent extends NagaCourtyardWallAbstractComponent
{
    public NagaCourtyardWallCornerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(manager, NagaCourtyardPieces.TFNCWC, nbt, new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner"), new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_decayed"));
    }
    
    public NagaCourtyardWallCornerComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCWC, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner"), new ResourceLocation("twilightforest", "courtyard/courtyard_wall_corner_decayed"));
    }
}
