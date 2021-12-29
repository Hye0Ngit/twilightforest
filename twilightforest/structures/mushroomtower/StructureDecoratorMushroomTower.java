// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.init.Blocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureDecoratorMushroomTower extends StructureTFDecorator
{
    public StructureDecoratorMushroomTower() {
        this.blockState = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM);
        this.accentState = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_OUTSIDE);
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = Blocks.field_150485_bF.func_176223_P();
        this.pillarState = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM);
        this.floorState = Blocks.field_150344_f.func_176223_P();
    }
}
