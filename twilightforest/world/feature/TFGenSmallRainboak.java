// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.LeavesVariant;
import twilightforest.block.BlockTFLeaves;
import twilightforest.block.TFBlocks;

public class TFGenSmallRainboak extends TFGenSmallTwilightOak
{
    public TFGenSmallRainboak() {
        this(false);
    }
    
    public TFGenSmallRainboak(final boolean notify) {
        super(notify, 4, TFBlocks.twilight_log.func_176223_P(), TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockTFLeaves.VARIANT, (Comparable)LeavesVariant.RAINBOAK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
    }
}
