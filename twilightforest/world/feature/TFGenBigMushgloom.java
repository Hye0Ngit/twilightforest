// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import twilightforest.block.BlockTFHugeGloomBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenBigMushgloom extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final int height = 3 + rand.nextInt(2) + rand.nextInt(2);
        if (!TFGenerator.isAreaSuitable(world, rand, pos.func_177982_a(-1, 0, -1), 3, height, 3)) {
            return false;
        }
        final Block blockUnder = world.func_180495_p(pos.func_177977_b()).func_177230_c();
        if (blockUnder != Blocks.field_150346_d && blockUnder != Blocks.field_150349_c && blockUnder != Blocks.field_150391_bh) {
            return false;
        }
        for (int dy = 0; dy < height - 2; ++dy) {
            this.func_175903_a(world, pos.func_177981_b(dy), TFBlocks.huge_mushgloom.func_176223_P().func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM));
        }
        this.makeMushroomCap(world, pos.func_177981_b(height - 2));
        if (rand.nextBoolean()) {
            this.makeMushroomCap(world, pos.func_177981_b(height - 1));
        }
        return true;
    }
    
    private void makeMushroomCap(final World world, final BlockPos pos) {
        final IBlockState defState = TFBlocks.huge_mushgloom.func_176223_P();
        this.func_175903_a(world, pos.func_177982_a(-1, 0, -1), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_WEST));
        this.func_175903_a(world, pos.func_177982_a(0, 0, -1), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH));
        this.func_175903_a(world, pos.func_177982_a(1, 0, -1), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_EAST));
        this.func_175903_a(world, pos.func_177982_a(-1, 0, 0), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.WEST));
        this.func_175903_a(world, pos, defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER));
        this.func_175903_a(world, pos.func_177982_a(1, 0, 0), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.EAST));
        this.func_175903_a(world, pos.func_177982_a(-1, 0, 1), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_WEST));
        this.func_175903_a(world, pos.func_177982_a(0, 0, 1), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH));
        this.func_175903_a(world, pos.func_177982_a(1, 0, 1), defState.func_177226_a((IProperty)BlockTFHugeGloomBlock.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_EAST));
    }
}
