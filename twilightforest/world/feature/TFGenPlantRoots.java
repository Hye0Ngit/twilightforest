// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFPlant;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenPlantRoots extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random random, BlockPos pos) {
        final int copyX = pos.func_177958_n();
        final int copyZ = pos.func_177952_p();
        while (pos.func_177956_o() > 5) {
            if (world.func_175623_d(pos) && BlockTFPlant.canPlaceRootAt(world, pos) && random.nextInt(6) > 0) {
                world.func_180501_a(pos, TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.ROOT_STRAND), 18);
            }
            else {
                pos = new BlockPos(copyX + random.nextInt(4) - random.nextInt(4), pos.func_177956_o(), copyZ + random.nextInt(4) - random.nextInt(4));
            }
            pos = pos.func_177977_b();
        }
        return true;
    }
}
