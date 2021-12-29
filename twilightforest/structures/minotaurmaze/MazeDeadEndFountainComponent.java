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
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeDeadEndFountainComponent extends MazeDeadEndComponent
{
    public MazeDeadEndFountainComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(MinotaurMazePieces.TFMMDEF, nbt);
    }
    
    public MazeDeadEndFountainComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public MazeDeadEndFountainComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(type, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.func_175804_a(world, sbb, 1, 1, 4, 4, 4, 4, ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P(), MazeDeadEndFountainComponent.AIR, false);
        this.func_175811_a(world, Blocks.field_150355_j.func_176223_P(), 2, 3, 4, sbb);
        this.func_175811_a(world, Blocks.field_150355_j.func_176223_P(), 3, 3, 4, sbb);
        this.func_175811_a(world, MazeDeadEndFountainComponent.AIR, 2, 0, 3, sbb);
        this.func_175811_a(world, MazeDeadEndFountainComponent.AIR, 3, 0, 3, sbb);
        return true;
    }
}
