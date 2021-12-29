// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.loot.TFTreasure;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFMazeRoomVault extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomVault() {
    }
    
    public ComponentTFMazeRoomVault(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 0, 1, 0, 15, 4, 15, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 0, 2, 0, 15, 3, 15, TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK), ComponentTFMazeRoomVault.AIR, false);
        this.func_74878_a(world, sbb, 6, 2, 6, 9, 3, 9);
        this.func_175804_a(world, sbb, 6, 2, 5, 9, 2, 5, Blocks.field_150452_aw.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 6, 2, 10, 9, 2, 10, Blocks.field_150452_aw.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 5, 2, 6, 5, 2, 9, Blocks.field_150452_aw.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 10, 2, 6, 10, 2, 9, Blocks.field_150452_aw.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 6, 4, 5, 9, 4, 5, Blocks.field_150354_m.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 6, 4, 10, 9, 4, 10, Blocks.field_150354_m.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 5, 4, 6, 5, 4, 9, Blocks.field_150354_m.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 10, 4, 6, 10, 4, 9, Blocks.field_150354_m.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 6, 0, 5, 9, 0, 5, Blocks.field_150335_W.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 6, 0, 10, 9, 0, 10, Blocks.field_150335_W.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 5, 0, 6, 5, 0, 9, Blocks.field_150335_W.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175804_a(world, sbb, 10, 0, 6, 10, 0, 9, Blocks.field_150335_W.func_176223_P(), ComponentTFMazeRoomVault.AIR, false);
        this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), 7, 2, 6, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 8, 2, 6, TFTreasure.labyrinth_vault, sbb);
        this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), 8, 2, 9, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 7, 2, 9, TFTreasure.labyrinth_vault, sbb);
        this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), 6, 2, 7, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 6, 2, 8, TFTreasure.labyrinth_vault, sbb);
        this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), 9, 2, 8, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 9, 2, 7, TFTreasure.labyrinth_vault, sbb);
        return true;
    }
}
