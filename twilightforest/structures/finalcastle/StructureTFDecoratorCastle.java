// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.enums.CastlePillarVariant;
import twilightforest.block.BlockTFCastlePillar;
import twilightforest.enums.CastleBrickVariant;
import twilightforest.block.BlockTFCastleBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockQuartz;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureTFDecoratorCastle extends StructureTFDecorator
{
    public StructureTFDecoratorCastle() {
        this.blockState = TFBlocks.castle_brick.func_176223_P();
        this.accentState = Blocks.field_150371_ca.func_176223_P().func_177226_a((IProperty)BlockQuartz.field_176335_a, (Comparable)BlockQuartz.EnumType.CHISELED);
        this.roofState = TFBlocks.castle_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.ROOF);
        this.pillarState = TFBlocks.castle_pillar.func_176223_P().func_177226_a((IProperty)BlockTFCastlePillar.VARIANT, (Comparable)CastlePillarVariant.BOLD);
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = TFBlocks.castle_stairs_brick.func_176223_P();
        this.randomBlocks = new StructureTFCastleBlocks();
    }
}
