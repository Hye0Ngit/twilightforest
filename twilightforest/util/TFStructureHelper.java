// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@Deprecated
public class TFStructureHelper
{
    public static final BlockState stoneSlab;
    public static final BlockState stoneSlabTop;
    public static final BlockState stoneSlabDouble;
    public static final BlockState birchSlab;
    public static final BlockState birchSlabTop;
    public static final BlockState birchPlanks;
    
    private static BlockState getSlabType(final Block type, final SlabType side) {
        return (BlockState)type.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)side);
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
        return switch (i) {
            case 1 -> Blocks.f_50747_.m_49966_();
            case 2 -> Blocks.f_50748_.m_49966_();
            case 3 -> Blocks.f_50749_.m_49966_();
            default -> Blocks.f_50746_.m_49966_();
        };
    }
    
    public static BlockState randomMushroom(final int i) {
        if (i == 0) {
            return Blocks.f_50073_.m_49966_();
        }
        return Blocks.f_50072_.m_49966_();
    }
    
    static {
        stoneSlab = getSlab(Blocks.f_50405_);
        stoneSlabTop = getSlabTop(Blocks.f_50405_);
        stoneSlabDouble = (BlockState)Blocks.f_50405_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.DOUBLE);
        birchSlab = getSlab(Blocks.f_50400_);
        birchSlabTop = getSlabTop(Blocks.f_50400_);
        birchPlanks = Blocks.f_50742_.m_49966_();
    }
}
