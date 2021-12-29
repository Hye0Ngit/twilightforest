// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.block.BlockWoodSlab;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureDecoratorIceTower extends StructureTFDecorator
{
    public StructureDecoratorIceTower() {
        this.blockState = TFBlocks.aurora_block.func_176223_P();
        this.accentState = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = Blocks.field_150487_bG.func_176223_P();
        this.pillarState = TFBlocks.aurora_pillar.func_176223_P().func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Y);
        this.platformState = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.BIRCH);
        this.floorState = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        this.randomBlocks = new StructureTFAuroraBricks();
    }
}
