// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.block.Rotation;
import twilightforest.world.registration.TFFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class NagaCourtyardHedgeLineComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeLineComponent(final ServerLevel level, final CompoundTag nbt) {
        super(level, NagaCourtyardPieces.TFNCLn, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_line"), new ResourceLocation("twilightforest", "courtyard/hedge_line_big"));
    }
    
    public NagaCourtyardHedgeLineComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCLn, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_line"), new ResourceLocation("twilightforest", "courtyard/hedge_line_big"));
    }
}
