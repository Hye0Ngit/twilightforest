// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.state.Property;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import twilightforest.structures.TFStructureDecorator;

public class MushroomTowerDecorator extends TFStructureDecorator
{
    public MushroomTowerDecorator() {
        this.blockState = (BlockState)((BlockState)Blocks.field_196706_do.func_176223_P().func_206870_a((Property)HugeMushroomBlock.field_196465_z, (Comparable)false)).func_206870_a((Property)HugeMushroomBlock.field_196460_A, (Comparable)false);
        this.accentState = Blocks.field_150419_aX.func_176223_P();
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = Blocks.field_150485_bF.func_176223_P();
        this.pillarState = (BlockState)((BlockState)Blocks.field_196706_do.func_176223_P().func_206870_a((Property)HugeMushroomBlock.field_196465_z, (Comparable)false)).func_206870_a((Property)HugeMushroomBlock.field_196460_A, (Comparable)false);
        this.floorState = Blocks.field_196662_n.func_176223_P();
    }
}
