// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.loot.TFTreasure;
import net.minecraft.util.Direction;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeRoomVaultComponent extends MazeRoomComponent
{
    public MazeRoomVaultComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMRV, nbt);
    }
    
    public MazeRoomVaultComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRV, feature, i, rand, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 0, 1, 0, 15, 4, 15, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 0, 2, 0, 15, 3, 15, ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_74878_a(world, sbb, 6, 2, 6, 9, 3, 9);
        this.func_175804_a(world, sbb, 6, 2, 5, 9, 2, 5, Blocks.field_196663_cq.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 6, 2, 10, 9, 2, 10, Blocks.field_196663_cq.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 2, 6, 5, 2, 9, Blocks.field_196663_cq.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 10, 2, 6, 10, 2, 9, Blocks.field_196663_cq.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 6, 4, 5, 9, 4, 5, Blocks.field_150354_m.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 6, 4, 10, 9, 4, 10, Blocks.field_150354_m.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 4, 6, 5, 4, 9, Blocks.field_150354_m.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 10, 4, 6, 10, 4, 9, Blocks.field_150354_m.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 6, 0, 5, 9, 0, 5, Blocks.field_150335_W.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 6, 0, 10, 9, 0, 10, Blocks.field_150335_W.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 0, 6, 5, 0, 9, Blocks.field_150335_W.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.func_175804_a(world, sbb, 10, 0, 6, 10, 0, 9, Blocks.field_150335_W.func_176223_P(), MazeRoomVaultComponent.AIR, false);
        this.setDoubleLootChest(world, 7, 2, 6, 8, 2, 6, Direction.SOUTH, TFTreasure.labyrinth_vault, sbb, false);
        this.setDoubleLootChest(world, 8, 2, 9, 7, 2, 9, Direction.NORTH, TFTreasure.labyrinth_vault, sbb, false);
        this.setDoubleLootChest(world, 6, 2, 8, 6, 2, 7, Direction.EAST, TFTreasure.labyrinth_vault, sbb, false);
        this.setDoubleLootChest(world, 9, 2, 7, 9, 2, 8, Direction.WEST, TFTreasure.labyrinth_vault, sbb, false);
        return true;
    }
}
