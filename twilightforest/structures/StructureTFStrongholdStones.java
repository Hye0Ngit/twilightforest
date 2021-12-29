// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFStrongholdStones extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float f = random.nextFloat();
            if (f < 0.2f) {
                this.field_151562_a = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.CRACKED);
            }
            else if (f < 0.5f) {
                this.field_151562_a = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.MOSSY);
            }
            else if (f < 0.55f) {
                this.field_151562_a = Blocks.field_150418_aU.func_176223_P().func_177226_a((IProperty)BlockSilverfish.field_176378_a, (Comparable)BlockSilverfish.EnumType.STONEBRICK);
            }
            else {
                this.field_151562_a = Blocks.field_150417_aV.func_176223_P();
            }
        }
    }
}
