// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.block.Rotation;
import twilightforest.world.registration.TFFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class NagaCourtyardHedgeIntersectionComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeIntersectionComponent(final ServerLevel level, final CompoundTag nbt) {
        super(level, NagaCourtyardPieces.TFNCIs, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_intersection"), new ResourceLocation("twilightforest", "courtyard/hedge_intersection_big"));
    }
    
    public NagaCourtyardHedgeIntersectionComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCIs, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_intersection"), new ResourceLocation("twilightforest", "courtyard/hedge_intersection_big"));
    }
}
