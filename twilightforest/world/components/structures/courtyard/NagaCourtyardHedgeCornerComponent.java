// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.block.Rotation;
import twilightforest.world.registration.TFFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class NagaCourtyardHedgeCornerComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeCornerComponent(final ServerLevel level, final CompoundTag nbt) {
        super(level, NagaCourtyardPieces.TFNCCr, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_corner"), new ResourceLocation("twilightforest", "courtyard/hedge_corner_big"));
    }
    
    public NagaCourtyardHedgeCornerComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCCr, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_corner"), new ResourceLocation("twilightforest", "courtyard/hedge_corner_big"));
    }
}
