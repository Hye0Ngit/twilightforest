// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.block.Rotation;
import twilightforest.world.registration.TFFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class NagaCourtyardHedgeCapPillarComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeCapPillarComponent(final ServerLevel level, final CompoundTag nbt) {
        super(level, NagaCourtyardPieces.TFNCCpP, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_end_pillar"), new ResourceLocation("twilightforest", "courtyard/hedge_end_pillar_big"));
    }
    
    public NagaCourtyardHedgeCapPillarComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCCpP, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_end_pillar"), new ResourceLocation("twilightforest", "courtyard/hedge_end_pillar_big"));
    }
}
