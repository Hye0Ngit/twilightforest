// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.loot.TFTreasure;
import twilightforest.structures.TFStructureComponentOld;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeDeadEndTrappedChestComponent extends MazeDeadEndComponent
{
    public MazeDeadEndTrappedChestComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMDETrC, nbt);
    }
    
    public MazeDeadEndTrappedChestComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDETrC, feature, i, x, y, z, rotation);
        this.func_186164_a(rotation);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175811_a(world, Blocks.field_196662_n.func_176223_P(), 2, 1, 4, sbb);
        this.func_175811_a(world, Blocks.field_196662_n.func_176223_P(), 3, 1, 4, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(Blocks.field_150476_ad.func_176223_P(), Direction.NORTH, false), 2, 1, 3, sbb);
        this.func_175811_a(world, TFStructureComponentOld.getStairState(Blocks.field_150476_ad.func_176223_P(), Direction.NORTH, false), 3, 1, 3, sbb);
        this.setDoubleLootChest(world, 2, 2, 4, 3, 2, 4, Direction.SOUTH, TFTreasure.labyrinth_deadend, sbb, true);
        this.func_175804_a(world, sbb, 1, 1, 0, 4, 3, 1, ((Block)TFBlocks.maze_stone_chiseled.get()).func_176223_P(), MazeDeadEndTrappedChestComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, 4, 0, 4, 4, 1, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeDeadEndTrappedChestComponent.AIR, false);
        this.func_175804_a(world, sbb, 2, 1, 0, 3, 3, 1, Blocks.field_150411_aY.func_176223_P(), MazeDeadEndTrappedChestComponent.AIR, false);
        final BlockState tnt = Blocks.field_150335_W.func_176223_P();
        this.func_175811_a(world, tnt, 2, 0, 3, sbb);
        this.func_175811_a(world, tnt, 3, 0, 3, sbb);
        this.func_175811_a(world, tnt, 2, 0, 4, sbb);
        this.func_175811_a(world, tnt, 3, 0, 4, sbb);
        return true;
    }
}
