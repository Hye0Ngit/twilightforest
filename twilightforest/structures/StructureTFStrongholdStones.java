// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;

public class StructureTFStrongholdStones extends StructurePieceBlockSelector
{
    public void func_75062_a(final Random par1Random, final int par2, final int par3, final int par4, final boolean par5) {
        if (!par5) {
            this.field_75066_a = 0;
            this.field_75065_b = 0;
        }
        else {
            this.field_75066_a = Block.field_72007_bm.field_71990_ca;
            final float var6 = par1Random.nextFloat();
            if (var6 < 0.2f) {
                this.field_75065_b = 2;
            }
            else if (var6 < 0.5f) {
                this.field_75065_b = 1;
            }
            else if (var6 < 0.55f) {
                this.field_75066_a = Block.field_72006_bl.field_71990_ca;
                this.field_75065_b = 2;
            }
            else {
                this.field_75065_b = 0;
            }
        }
    }
}
