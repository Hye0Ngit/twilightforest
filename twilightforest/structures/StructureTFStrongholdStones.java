// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFStrongholdStones extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random par1Random, final int par2, final int par3, final int par4, final boolean par5) {
        if (!par5) {
            this.field_151562_a = Blocks.field_150350_a;
            this.field_75065_b = 0;
        }
        else {
            this.field_151562_a = Blocks.field_150417_aV;
            final float var6 = par1Random.nextFloat();
            if (var6 < 0.2f) {
                this.field_75065_b = 2;
            }
            else if (var6 < 0.5f) {
                this.field_75065_b = 1;
            }
            else if (var6 < 0.55f) {
                this.field_151562_a = Blocks.field_150418_aU;
                this.field_75065_b = 2;
            }
            else {
                this.field_75065_b = 0;
            }
        }
    }
}
