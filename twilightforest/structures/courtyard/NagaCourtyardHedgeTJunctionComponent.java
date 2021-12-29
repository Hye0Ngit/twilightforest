// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class NagaCourtyardHedgeTJunctionComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeTJunctionComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(manager, NagaCourtyardPieces.TFNCT, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_t"), new ResourceLocation("twilightforest", "courtyard/hedge_t_big"));
    }
    
    public NagaCourtyardHedgeTJunctionComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCT, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_t"), new ResourceLocation("twilightforest", "courtyard/hedge_t_big"));
    }
}
