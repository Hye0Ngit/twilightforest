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

public class ComponentTFMazeRoomFountain extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomFountain() {
    }
    
    public ComponentTFMazeRoomFountain(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.func_175804_a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeRoomFountain.AIR, false);
        this.func_175804_a(world, sbb, 6, 1, 6, 9, 1, 9, Blocks.field_150355_j.func_176223_P(), ComponentTFMazeRoomFountain.AIR, false);
        return true;
    }
}
