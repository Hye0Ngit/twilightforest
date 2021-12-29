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
import net.minecraft.world.World;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFMazeRoomExit extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomExit() {
    }
    
    public ComponentTFMazeRoomExit(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_175804_a(world, sbb, 5, -5, 5, 10, 0, 10, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK), ComponentTFMazeRoomExit.AIR, false);
        this.func_175804_a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeRoomExit.AIR, false);
        this.func_175804_a(world, sbb, 5, 2, 5, 10, 3, 10, Blocks.field_150411_aY.func_176223_P(), ComponentTFMazeRoomExit.AIR, false);
        this.func_175804_a(world, sbb, 5, 4, 5, 10, 4, 10, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeRoomExit.AIR, false);
        this.func_74878_a(world, sbb, 6, -5, 6, 9, 4, 9);
        return true;
    }
}
