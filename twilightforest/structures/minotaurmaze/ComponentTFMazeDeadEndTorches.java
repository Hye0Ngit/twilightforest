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

public class ComponentTFMazeDeadEndTorches extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndTorches() {
    }
    
    public ComponentTFMazeDeadEndTorches(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_175804_a(world, sbb, 2, 1, 4, 3, 4, 4, Blocks.field_150478_aa.func_176223_P().func_177226_a((IProperty)BlockTorch.field_176596_a, (Comparable)EnumFacing.SOUTH), ComponentTFMazeDeadEndTorches.AIR, false);
        this.func_175804_a(world, sbb, 1, 1, 1, 1, 4, 4, Blocks.field_150478_aa.func_176223_P().func_177226_a((IProperty)BlockTorch.field_176596_a, (Comparable)EnumFacing.WEST), ComponentTFMazeDeadEndTorches.AIR, false);
        this.func_175804_a(world, sbb, 4, 1, 1, 4, 4, 4, Blocks.field_150478_aa.func_176223_P().func_177226_a((IProperty)BlockTorch.field_176596_a, (Comparable)EnumFacing.EAST), ComponentTFMazeDeadEndTorches.AIR, false);
        return true;
    }
}
