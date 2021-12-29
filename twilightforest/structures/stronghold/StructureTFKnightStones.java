// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.UnderBrickVariant;
import twilightforest.block.BlockTFUnderBrick;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFKnightStones extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean edge) {
        if (!edge) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float f = random.nextFloat();
            if (f < 0.2f) {
                this.field_151562_a = TFBlocks.underbrick.func_176223_P().func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.CRACKED);
            }
            else if (f < 0.5f) {
                this.field_151562_a = TFBlocks.underbrick.func_176223_P().func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.MOSSY);
            }
            else {
                this.field_151562_a = TFBlocks.underbrick.func_176223_P().func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.NORMAL);
            }
        }
    }
}
