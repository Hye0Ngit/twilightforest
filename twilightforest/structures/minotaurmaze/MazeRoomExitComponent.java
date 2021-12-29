// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

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

public class MazeRoomExitComponent extends MazeRoomComponent
{
    public MazeRoomExitComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMRE, nbt);
    }
    
    public MazeRoomExitComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRE, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.func_175804_a(world, sbb, 5, -5, 5, 10, 0, 10, ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P(), MazeRoomExitComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 1, 5, 10, 1, 10, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeRoomExitComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 2, 5, 10, 3, 10, Blocks.field_150411_aY.func_176223_P(), MazeRoomExitComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 4, 5, 10, 4, 10, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeRoomExitComponent.AIR, false);
        this.func_74878_a(world, sbb, 6, -5, 6, 9, 4, 9);
        return true;
    }
}
