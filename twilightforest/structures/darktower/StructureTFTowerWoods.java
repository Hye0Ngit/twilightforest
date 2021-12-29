// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerWoodVariant;
import twilightforest.block.BlockTFTowerWood;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFTowerWoods extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float randFloat = random.nextFloat();
            if (randFloat < 0.1f) {
                this.field_151562_a = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.CRACKED);
            }
            else if (randFloat < 0.2f) {
                this.field_151562_a = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.MOSSY);
            }
            else if (randFloat < 0.225f) {
                this.field_151562_a = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.INFESTED);
            }
            else {
                this.field_151562_a = TFBlocks.tower_wood.func_176223_P();
            }
        }
    }
}
