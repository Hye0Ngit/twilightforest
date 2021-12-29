// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
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

public class ComponentTFMazeUpperEntrance extends StructureTFComponentOld
{
    public ComponentTFMazeUpperEntrance() {
    }
    
    public ComponentTFMazeUpperEntrance(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i);
        this.func_186164_a(EnumFacing.field_176754_o[rand.nextInt(4)]);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random random) {
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_189914_a(world, sbb, rand, 0.7f, 0, 5, 0, 15, 5, 15, TFBlocks.maze_stone.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, true, 0);
        this.func_175804_a(world, sbb, 0, 0, 0, 15, 0, 15, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.MOSAIC), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_175804_a(world, sbb, 0, 1, 0, 15, 1, 15, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeUpperEntrance.AIR, true);
        this.func_175804_a(world, sbb, 0, 2, 0, 15, 3, 15, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK), ComponentTFMazeUpperEntrance.AIR, true);
        this.func_175804_a(world, sbb, 0, 4, 0, 15, 4, 15, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeUpperEntrance.AIR, true);
        this.func_189914_a(world, sbb, rand, 0.2f, 0, 0, 0, 15, 5, 15, Blocks.field_150351_n.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, true, 0);
        this.func_175804_a(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_74878_a(world, sbb, 7, 1, 0, 8, 3, 0);
        this.func_175804_a(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_74878_a(world, sbb, 7, 1, 15, 8, 3, 15);
        this.func_175804_a(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_74878_a(world, sbb, 0, 1, 7, 0, 3, 8);
        this.func_175804_a(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_74878_a(world, sbb, 15, 1, 7, 15, 3, 8);
        this.func_74878_a(world, sbb, 1, 1, 1, 14, 4, 14);
        this.func_175804_a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_175804_a(world, sbb, 5, 4, 5, 10, 4, 10, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeUpperEntrance.AIR, false);
        this.func_189914_a(world, sbb, rand, 0.7f, 5, 2, 5, 10, 3, 10, Blocks.field_150411_aY.func_176223_P(), ComponentTFMazeUpperEntrance.AIR, false, 0);
        this.func_74878_a(world, sbb, 6, 0, 6, 9, 4, 9);
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
                    final BlockPos topPos = world.func_175672_r(pos);
                    yTotal += Math.max(topPos.func_177956_o(), world.field_73011_w.func_76557_i());
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
