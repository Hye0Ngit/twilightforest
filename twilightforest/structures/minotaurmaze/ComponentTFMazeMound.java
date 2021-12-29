// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFMazeMound extends StructureTFComponentOld
{
    public static final int DIAMETER = 35;
    private int averageGroundLevel;
    private ComponentTFMazeUpperEntrance mazeAbove;
    
    public ComponentTFMazeMound() {
        this.averageGroundLevel = -1;
    }
    
    public ComponentTFMazeMound(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i);
        this.averageGroundLevel = -1;
        this.func_186164_a(EnumFacing.field_176754_o[rand.nextInt(4)]);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 35, y + 8, z + 35);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(structurecomponent, (List)list, random);
        list.add(this.mazeAbove = new ComponentTFMazeUpperEntrance(this.getFeatureType(), 3, random, this.field_74887_e.field_78897_a + 10, this.field_74887_e.field_78895_b + 0, this.field_74887_e.field_78896_c + 10));
        this.mazeAbove.func_74861_a(this, list, random);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            final int offset = this.averageGroundLevel - this.field_74887_e.field_78894_e + 8 - 1;
            this.field_74887_e.func_78886_a(0, offset, 0);
            if (this.mazeAbove != null) {
                this.mazeAbove.func_74874_b().func_78886_a(0, offset, 0);
            }
        }
        for (int x = 0; x < 35; ++x) {
            for (int z = 0; z < 35; ++z) {
                final int cx = x - 17;
                final int cz = z - 17;
                final int dist = (int)Math.sqrt(cx * cx + cz * cz);
                final int hheight = (int)(Math.cos(dist / 35.0 * 3.141592653589793) * 11.0);
                if ((cx > 2 || cx < -1 || cz > 2 || cz < -1) && (((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) || hheight > 6)) {
                    this.func_175811_a(world, Blocks.field_150349_c.func_176223_P(), x, hheight, z, sbb);
                    if ((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) {
                        this.func_175811_a(world, Blocks.field_150346_d.func_176223_P(), x, hheight - 1, z, sbb);
                    }
                    else if (hheight > 6) {
                        this.func_175804_a(world, sbb, x, 6, z, x, hheight - 1, z, Blocks.field_150346_d.func_176223_P(), ComponentTFMazeMound.AIR, false);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    protected int getAverageGroundLevel(final World world, final StructureBoundingBox boundingBox) {
        int totalHeight = 0;
        int totalMeasures = 0;
        for (int z = this.field_74887_e.field_78896_c; z <= this.field_74887_e.field_78892_f; ++z) {
            for (int x = this.field_74887_e.field_78897_a; x <= this.field_74887_e.field_78893_d; ++x) {
                final BlockPos pos = new BlockPos(x, 64, z);
                if (boundingBox.func_175898_b((Vec3i)pos)) {
                    final BlockPos topPos = world.func_175672_r(pos);
                    totalHeight += Math.max(topPos.func_177956_o(), world.field_73011_w.func_76557_i());
                    ++totalMeasures;
                }
            }
        }
        if (totalMeasures == 0) {
            return -1;
        }
        return totalHeight / totalMeasures;
    }
}
