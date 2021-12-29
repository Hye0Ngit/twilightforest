// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenFallenSmallLog extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final boolean goingX = rand.nextBoolean();
        final int length = rand.nextInt(4) + 3;
        if (goingX) {
            if (!TFGenerator.isAreaSuitable(world, rand, pos, length, 3, 2)) {
                return false;
            }
        }
        else if (!TFGenerator.isAreaSuitable(world, rand, pos, 3, length, 2)) {
            return false;
        }
        IBlockState logState = null;
        switch (rand.nextInt(7)) {
            default: {
                logState = TFBlocks.twilight_log.func_176223_P();
                break;
            }
            case 1: {
                logState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.CANOPY);
                break;
            }
            case 2: {
                logState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.MANGROVE);
                break;
            }
            case 3: {
                logState = Blocks.field_150364_r.func_176223_P();
                break;
            }
            case 4: {
                logState = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.SPRUCE);
                break;
            }
            case 5: {
                logState = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.BIRCH);
                break;
            }
            case 6: {
                logState = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.JUNGLE);
                break;
            }
        }
        IBlockState branchState = logState;
        if (goingX) {
            logState = logState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
            branchState = logState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
            for (int lx = 0; lx < length; ++lx) {
                this.func_175903_a(world, pos.func_177982_a(lx, 0, 1), logState);
                if (rand.nextInt(3) > 0) {
                    this.func_175903_a(world, pos.func_177982_a(lx, 1, 1), TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MOSSPATCH));
                }
            }
        }
        else {
            logState = logState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
            branchState = logState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
            for (int lz = 0; lz < length; ++lz) {
                this.func_175903_a(world, pos.func_177982_a(1, 0, lz), logState);
                if (rand.nextInt(3) > 0) {
                    this.func_175903_a(world, pos.func_177982_a(1, 1, lz), TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MOSSPATCH));
                }
            }
        }
        if (rand.nextInt(3) > 0) {
            if (goingX) {
                final int bx = rand.nextInt(length);
                final int bz = rand.nextBoolean() ? 2 : 0;
                this.func_175903_a(world, pos.func_177982_a(bx, 0, bz), branchState);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(bx, 1, bz), TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MOSSPATCH));
                }
            }
            else {
                final int bx = rand.nextBoolean() ? 2 : 0;
                final int bz = rand.nextInt(length);
                this.func_175903_a(world, pos.func_177982_a(bx, 0, bz), branchState);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(bx, 1, bz), TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MOSSPATCH));
                }
            }
        }
        return true;
    }
}
