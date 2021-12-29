// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class StrongholdStones extends StructurePiece.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float f = random.nextFloat();
            if (f < 0.2f) {
                this.field_151562_a = Blocks.field_196700_dk.func_176223_P();
            }
            else if (f < 0.5f) {
                this.field_151562_a = Blocks.field_196698_dj.func_176223_P();
            }
            else if (f < 0.55f) {
                this.field_151562_a = Blocks.field_196688_de.func_176223_P();
            }
            else {
                this.field_151562_a = Blocks.field_196696_di.func_176223_P();
            }
        }
    }
}
