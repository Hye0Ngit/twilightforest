// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
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
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeDeadEndRootsComponent extends MazeDeadEndComponent
{
    public MazeDeadEndRootsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(MinotaurMazePieces.TFMMDER, nbt);
    }
    
    public MazeDeadEndRootsComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public MazeDeadEndRootsComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(type, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(z + 2) > 0) {
                    final int length = rand.nextInt(6);
                    this.func_175811_a(world, Blocks.field_150346_d.func_176223_P(), x, 6, z, sbb);
                    for (int y = 6 - length; y < 6; ++y) {
                        this.func_175811_a(world, ((Block)TFBlocks.root_strand.get()).func_176223_P(), x, y, z, sbb);
                    }
                    if (rand.nextInt(z + 1) > 1) {
                        this.func_175811_a(world, Blocks.field_150351_n.func_176223_P(), x, 1, z, sbb);
                        if (rand.nextInt(z + 1) > 1) {
                            this.func_175811_a(world, Blocks.field_150351_n.func_176223_P(), x, 2, z, sbb);
                        }
                    }
                }
            }
        }
        return true;
    }
}
