// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeDeadEndFountain extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndFountain() {
    }
    
    public ComponentTFMazeDeadEndFountain(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_175804_a(world, sbb, 1, 1, 4, 4, 4, 4, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK), ComponentTFMazeDeadEndFountain.AIR, false);
        this.func_175811_a(world, Blocks.field_150358_i.func_176223_P(), 2, 3, 4, sbb);
        this.func_175811_a(world, Blocks.field_150358_i.func_176223_P(), 3, 3, 4, sbb);
        this.func_175811_a(world, ComponentTFMazeDeadEndFountain.AIR, 2, 0, 3, sbb);
        this.func_175811_a(world, ComponentTFMazeDeadEndFountain.AIR, 3, 0, 3, sbb);
        return true;
    }
}
