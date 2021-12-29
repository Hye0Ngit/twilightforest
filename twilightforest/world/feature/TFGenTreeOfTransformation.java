// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MagicWoodVariant;
import twilightforest.block.BlockTFMagicLog;
import twilightforest.block.TFBlocks;

public class TFGenTreeOfTransformation extends TFGenCanopyTree
{
    public TFGenTreeOfTransformation() {
        this(false);
    }
    
    public TFGenTreeOfTransformation(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.magic_log.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.TRANS);
        this.branchState = this.treeState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.magic_leaves.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.TRANS).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.minHeight = 11;
        this.chanceAddFirstFive = Integer.MAX_VALUE;
        this.chanceAddSecondFive = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        if (super.func_180709_b(world, random, pos)) {
            this.func_175903_a(world, pos.func_177981_b(3), TFBlocks.magic_log_core.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.TRANS));
            return true;
        }
        return false;
    }
}
