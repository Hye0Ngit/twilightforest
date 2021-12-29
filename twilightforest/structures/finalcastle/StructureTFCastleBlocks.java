// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleBlock;
import twilightforest.block.TFBlocks;
import twilightforest.enums.CastleBrickVariant;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFCastleBlocks extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float randFloat = random.nextFloat();
            CastleBrickVariant variant = null;
            if (randFloat < 0.1f) {
                variant = CastleBrickVariant.WORN;
            }
            else if (randFloat < 0.2f) {
                variant = CastleBrickVariant.CRACKED;
            }
            else {
                variant = CastleBrickVariant.NORMAL;
            }
            this.field_151562_a = TFBlocks.castle_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)variant);
        }
    }
}
