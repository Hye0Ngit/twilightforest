// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;

public interface IMapColorSupplier
{
    default MapColor supplyMapColor() {
        return this.supplyPlankColor().func_181070_c();
    }
    
    BlockPlanks.EnumType supplyPlankColor();
}
