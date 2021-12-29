// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class NagaCourtyardHedgeIntersectionComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeIntersectionComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(manager, NagaCourtyardPieces.TFNCIs, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_intersection"), new ResourceLocation("twilightforest", "courtyard/hedge_intersection_big"));
    }
    
    public NagaCourtyardHedgeIntersectionComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCIs, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_intersection"), new ResourceLocation("twilightforest", "courtyard/hedge_intersection_big"));
    }
}
