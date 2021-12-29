// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.state.IBlockState;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import twilightforest.loot.TFTreasure;
import twilightforest.util.TFEntityNames;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFMazeRoomSpawnerChests extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomSpawnerChests() {
    }
    
    public ComponentTFMazeRoomSpawnerChests(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.placePillarEnclosure(world, sbb, 3, 3);
        this.placePillarEnclosure(world, sbb, 10, 3);
        this.placePillarEnclosure(world, sbb, 3, 10);
        this.placePillarEnclosure(world, sbb, 10, 10);
        this.setSpawner(world, 4, 2, 4, sbb, TFEntityNames.MINOTAUR);
        this.placeTreasureAtCurrentPosition(world, rand, 4, 2, 11, TFTreasure.labyrinth_room, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 11, 2, 4, TFTreasure.labyrinth_room, sbb);
        this.func_175811_a(world, Blocks.field_150452_aw.func_176223_P(), 11, 1, 11, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 10, 0, 11, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 11, 0, 10, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 11, 0, 12, sbb);
        this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 12, 0, 11, sbb);
        return true;
    }
    
    private void placePillarEnclosure(final World world, final StructureBoundingBox sbb, final int dx, final int dz) {
        for (int y = 1; y < 5; ++y) {
            final IBlockState chiselledMazeBlock = TFBlocks.maze_stone.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.CHISELED);
            this.func_175811_a(world, chiselledMazeBlock, dx + 0, y, dz + 0, sbb);
            this.func_175811_a(world, chiselledMazeBlock, dx + 2, y, dz + 0, sbb);
            this.func_175811_a(world, chiselledMazeBlock, dx + 0, y, dz + 2, sbb);
            this.func_175811_a(world, chiselledMazeBlock, dx + 2, y, dz + 2, sbb);
        }
        this.func_175811_a(world, Blocks.field_150344_f.func_176223_P(), dx + 1, 1, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150344_f.func_176223_P(), dx + 1, 4, dz + 1, sbb);
        final IBlockState defaultState = Blocks.field_150476_ad.func_176223_P();
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.NORTH, this.field_186169_c, false), dx + 1, 1, dz + 0, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.WEST, this.field_186169_c, false), dx + 0, 1, dz + 1, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.EAST, this.field_186169_c, false), dx + 2, 1, dz + 1, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.SOUTH, this.field_186169_c, false), dx + 1, 1, dz + 2, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.NORTH, this.field_186169_c, true), dx + 1, 4, dz + 0, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.WEST, this.field_186169_c, true), dx + 0, 4, dz + 1, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.EAST, this.field_186169_c, true), dx + 2, 4, dz + 1, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(defaultState, EnumFacing.SOUTH, this.field_186169_c, true), dx + 1, 4, dz + 2, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 2, dz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 0, 2, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 2, 2, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 2, dz + 2, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 3, dz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 0, 3, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 2, 3, dz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx + 1, 3, dz + 2, sbb);
    }
}
