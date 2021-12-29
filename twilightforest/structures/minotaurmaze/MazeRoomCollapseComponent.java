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
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeRoomCollapseComponent extends MazeRoomComponent
{
    public MazeRoomCollapseComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMRC, nbt);
    }
    
    public MazeRoomCollapseComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRC, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                int gravel = rand.nextInt(dist);
                final int root = rand.nextInt(dist);
                if (gravel > 0) {
                    ++gravel;
                    this.func_175804_a(world, sbb, x, 1, z, x, gravel, z, Blocks.field_150351_n.func_176223_P(), MazeRoomCollapseComponent.AIR, false);
                    this.func_74878_a(world, sbb, x, gravel, z, x, gravel + 5, z);
                }
                else if (root > 0) {
                    this.func_175804_a(world, sbb, x, 5, z, x, 5 + root, z, Blocks.field_150346_d.func_176223_P(), MazeRoomCollapseComponent.AIR, true);
                    this.func_175804_a(world, sbb, x, 5 - rand.nextInt(5), z, x, 5, z, ((Block)TFBlocks.root_strand.get()).func_176223_P(), MazeRoomCollapseComponent.AIR, false);
                }
                else if (rand.nextInt(dist + 1) > 0) {
                    this.func_74878_a(world, sbb, x, 5, z, x, 5, z);
                }
            }
        }
        return true;
    }
}
