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

public class ComponentTFMazeCorridorIronFence extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorIronFence() {
    }
    
    public ComponentTFMazeCorridorIronFence(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 1, 4, 2, 4, 4, 3, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeCorridorIronFence.AIR, false);
        this.func_175804_a(world, sbb, 1, 1, 2, 4, 3, 3, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.CHISELED), ComponentTFMazeCorridorIronFence.AIR, false);
        this.func_175804_a(world, sbb, 2, 1, 2, 3, 3, 3, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        return true;
    }
}
