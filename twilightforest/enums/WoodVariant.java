// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.block.BlockPlanks;
import twilightforest.util.IMapColorSupplier;
import net.minecraft.util.IStringSerializable;

public enum WoodVariant implements IStringSerializable, IMapColorSupplier
{
    OAK(BlockPlanks.EnumType.OAK), 
    CANOPY(BlockPlanks.EnumType.SPRUCE), 
    MANGROVE(BlockPlanks.EnumType.JUNGLE), 
    DARK(BlockPlanks.EnumType.ACACIA);
    
    private final BlockPlanks.EnumType plankType;
    
    private WoodVariant(final BlockPlanks.EnumType plankType) {
        this.plankType = plankType;
    }
    
    public BlockPlanks.EnumType supplyPlankColor() {
        return this.plankType;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
