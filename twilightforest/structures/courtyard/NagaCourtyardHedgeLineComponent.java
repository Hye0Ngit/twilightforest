// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class NagaCourtyardHedgeLineComponent extends NagaCourtyardHedgeAbstractComponent
{
    public NagaCourtyardHedgeLineComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(manager, NagaCourtyardPieces.TFNCLn, nbt, new ResourceLocation("twilightforest", "courtyard/hedge_line"), new ResourceLocation("twilightforest", "courtyard/hedge_line_big"));
    }
    
    public NagaCourtyardHedgeLineComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Rotation rotation) {
        super(NagaCourtyardPieces.TFNCLn, feature, i, x, y, z, rotation, new ResourceLocation("twilightforest", "courtyard/hedge_line"), new ResourceLocation("twilightforest", "courtyard/hedge_line_big"));
    }
}
