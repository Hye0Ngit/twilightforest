// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Blocks;
import net.minecraft.state.Property;
import net.minecraft.block.SlabBlock;
import net.minecraft.state.properties.SlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class TFStructureHelper
{
    public static final BlockState stoneSlab;
    public static final BlockState stoneSlabTop;
    public static final BlockState stoneSlabDouble;
    public static final BlockState birchSlab;
    public static final BlockState birchSlabTop;
    public static final BlockState birchPlanks;
    
    private static BlockState getSlabType(final Block type, final SlabType side) {
        return (BlockState)type.func_176223_P().func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)side);
    }
    
    public static BlockState getSlab(final Block type) {
        return getSlabType(type, SlabType.BOTTOM);
    }
    
    public static BlockState getSlabTop(final Block type) {
        return getSlabType(type, SlabType.TOP);
    }
    
    public static BlockState randomPlant(final int i) {
        if (i < 4) {
            return randomSapling(i);
        }
        return randomMushroom(i - 4);
    }
    
    public static BlockState randomSapling(final int i) {
        switch (i) {
            default: {
                return Blocks.field_196674_t.func_176223_P();
            }
            case 1: {
                return Blocks.field_196675_u.func_176223_P();
            }
            case 2: {
                return Blocks.field_196676_v.func_176223_P();
            }
            case 3: {
                return Blocks.field_196678_w.func_176223_P();
            }
        }
    }
    
    public static BlockState randomMushroom(final int i) {
        if (i == 0) {
            return Blocks.field_150337_Q.func_176223_P();
        }
        return Blocks.field_150338_P.func_176223_P();
    }
    
    static {
        stoneSlab = getSlab(Blocks.field_222401_hJ);
        stoneSlabTop = getSlabTop(Blocks.field_222401_hJ);
        stoneSlabDouble = (BlockState)Blocks.field_222401_hJ.func_176223_P().func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)SlabType.DOUBLE);
        birchSlab = getSlab(Blocks.field_196627_bs);
        birchSlabTop = getSlabTop(Blocks.field_196627_bs);
        birchPlanks = Blocks.field_196666_p.func_176223_P();
    }
}
