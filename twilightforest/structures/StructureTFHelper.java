// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class StructureTFHelper
{
    public static final IBlockState stoneSlab;
    public static final IBlockState stoneSlabTop;
    public static final IBlockState stoneSlabDouble;
    public static final IBlockState birchSlab;
    public static final IBlockState birchSlabTop;
    public static final IBlockState birchPlanks;
    
    private static IBlockState getSlabType(final Block type, final BlockSlab.EnumBlockHalf side) {
        return type.func_176223_P().func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)side);
    }
    
    public static IBlockState getSlab(final Block type) {
        return getSlabType(type, BlockSlab.EnumBlockHalf.BOTTOM);
    }
    
    public static IBlockState getSlabTop(final Block type) {
        return getSlabType(type, BlockSlab.EnumBlockHalf.TOP);
    }
    
    public static IBlockState randomPlant(final int i) {
        if (i < 4) {
            return randomSapling(i);
        }
        return randomMushroom(i - 4);
    }
    
    public static IBlockState randomSapling(final int i) {
        return Blocks.field_150345_g.func_176223_P().func_177226_a((IProperty)BlockSapling.field_176480_a, (Comparable)BlockPlanks.EnumType.values()[i]);
    }
    
    public static IBlockState randomMushroom(final int i) {
        if (i == 0) {
            return Blocks.field_150337_Q.func_176223_P();
        }
        return Blocks.field_150338_P.func_176223_P();
    }
    
    static {
        stoneSlab = getSlab((Block)Blocks.field_150333_U);
        stoneSlabTop = getSlabTop((Block)Blocks.field_150333_U);
        stoneSlabDouble = Blocks.field_150334_T.func_176223_P();
        birchSlab = getSlab((Block)Blocks.field_150376_bx).func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        birchSlabTop = getSlabTop((Block)Blocks.field_150376_bx).func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        birchPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
    }
}
