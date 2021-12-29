// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerWoodVariant;
import twilightforest.block.BlockTFTowerWood;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureDecoratorDarkTower extends StructureTFDecorator
{
    public StructureDecoratorDarkTower() {
        this.blockState = TFBlocks.tower_wood.func_176223_P();
        this.accentState = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.ENCASED);
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = Blocks.field_150485_bF.func_176223_P();
        this.pillarState = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.ENCASED);
        this.platformState = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.ENCASED);
        this.randomBlocks = new StructureTFTowerWoods();
    }
}
