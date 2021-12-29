// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.UnderBrickVariant;
import twilightforest.block.BlockTFUnderBrick;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureTFDecoratorStronghold extends StructureTFDecorator
{
    public StructureTFDecoratorStronghold() {
        this.blockState = TFBlocks.underbrick.func_176223_P();
        this.accentState = TFBlocks.underbrick.func_176223_P().func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.CRACKED);
        this.fenceState = Blocks.field_150463_bK.func_176223_P();
        this.stairState = Blocks.field_150390_bg.func_176223_P();
        this.pillarState = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.MOSSY);
        this.platformState = Blocks.field_150333_U.func_176223_P().func_177226_a((IProperty)BlockStoneSlab.field_176556_M, (Comparable)BlockStoneSlab.EnumType.SMOOTHBRICK).func_177226_a((IProperty)BlockStoneSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP);
        this.randomBlocks = new StructureTFKnightStones();
    }
}
