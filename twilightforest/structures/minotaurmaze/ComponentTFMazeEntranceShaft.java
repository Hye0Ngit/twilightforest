// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFMazeEntranceShaft extends StructureTFComponentOld
{
    private int averageGroundLevel;
    
    public ComponentTFMazeEntranceShaft() {
        this.averageGroundLevel = -1;
    }
    
    public ComponentTFMazeEntranceShaft(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i);
        this.averageGroundLevel = -1;
        this.func_186164_a(EnumFacing.field_176754_o[rand.nextInt(4)]);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 6 - 1, y + 14, z + 6 - 1);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random random) {
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.field_74887_e.field_78894_e = this.averageGroundLevel;
            this.field_74887_e.field_78895_b = 21;
        }
        this.func_175804_a(world, sbb, 0, 0, 0, 5, this.field_74887_e.func_78882_c(), 5, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK), ComponentTFMazeEntranceShaft.AIR, true);
        this.func_74878_a(world, sbb, 1, 0, 1, 4, this.field_74887_e.func_78882_c(), 4);
        return true;
    }
    
    @Override
    protected int getAverageGroundLevel(final World world, final StructureBoundingBox boundingBox) {
        int yTotal = 0;
        int count = 0;
        for (int z = this.field_74887_e.field_78896_c; z <= this.field_74887_e.field_78892_f; ++z) {
            for (int x = this.field_74887_e.field_78897_a; x <= this.field_74887_e.field_78893_d; ++x) {
                final BlockPos pos = new BlockPos(x, 64, z);
                if (boundingBox.func_175898_b((Vec3i)pos)) {
                    final BlockPos topBlock = world.func_175672_r(pos);
                    yTotal += Math.max(topBlock.func_177956_o(), world.field_73011_w.func_76557_i());
                    ++count;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        return yTotal / count;
    }
}
