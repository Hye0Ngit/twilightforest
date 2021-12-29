// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import twilightforest.loot.TFTreasure;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeDeadEndChest extends ComponentTFMazeDeadEnd
{
    public ComponentTFMazeDeadEndChest() {
    }
    
    public ComponentTFMazeDeadEndChest(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175811_a(world, Blocks.field_150344_f.func_176223_P(), 2, 1, 4, sbb);
        this.func_175811_a(world, Blocks.field_150344_f.func_176223_P(), 3, 1, 4, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(Blocks.field_150476_ad.func_176223_P(), EnumFacing.NORTH, this.field_186169_c, false), 2, 1, 3, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(Blocks.field_150476_ad.func_176223_P(), EnumFacing.NORTH, this.field_186169_c, false), 3, 1, 3, sbb);
        this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), 2, 2, 4, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 4, TFTreasure.labyrinth_deadend, sbb);
        this.func_175804_a(world, sbb, 1, 1, 0, 4, 3, 1, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.CHISELED), ComponentTFMazeDeadEndChest.AIR, false);
        this.func_175804_a(world, sbb, 1, 4, 0, 4, 4, 1, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeDeadEndChest.AIR, false);
        this.func_175804_a(world, sbb, 2, 1, 0, 3, 3, 1, Blocks.field_150411_aY.func_176223_P(), ComponentTFMazeDeadEndChest.AIR, false);
        return true;
    }
}
