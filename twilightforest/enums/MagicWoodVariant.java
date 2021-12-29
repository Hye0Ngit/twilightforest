// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.block.BlockPlanks;
import twilightforest.util.IMapColorSupplier;
import net.minecraft.util.IStringSerializable;

public enum MagicWoodVariant implements IStringSerializable, IMapColorSupplier
{
    TIME(BlockPlanks.EnumType.JUNGLE), 
    TRANS(BlockPlanks.EnumType.OAK), 
    MINE(BlockPlanks.EnumType.BIRCH), 
    SORT(BlockPlanks.EnumType.SPRUCE);
    
    private final BlockPlanks.EnumType plankType;
    
    private MagicWoodVariant(final BlockPlanks.EnumType plankType) {
        this.plankType = plankType;
    }
    
    public BlockPlanks.EnumType supplyPlankColor() {
        return this.plankType;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
