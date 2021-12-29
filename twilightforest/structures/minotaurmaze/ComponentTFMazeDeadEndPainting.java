// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockTorch;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeDeadEndPainting extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndPainting() {
    }
    
    public ComponentTFMazeDeadEndPainting(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P().func_177226_a((IProperty)BlockTorch.field_176596_a, (Comparable)EnumFacing.WEST), 1, 3, 3, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P().func_177226_a((IProperty)BlockTorch.field_176596_a, (Comparable)EnumFacing.EAST), 4, 3, 3, sbb);
        return true;
    }
}
