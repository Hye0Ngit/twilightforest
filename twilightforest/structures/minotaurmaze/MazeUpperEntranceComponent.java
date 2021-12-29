// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class MazeUpperEntranceComponent extends TFStructureComponentOld
{
    public MazeUpperEntranceComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMUE, nbt);
    }
    
    public MazeUpperEntranceComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMUE, feature, i);
        this.func_186164_a(Direction.Plane.HORIZONTAL.func_179518_a(rand));
        this.field_74887_e = new MutableBoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_189914_a(world, sbb, rand, 0.7f, 0, 5, 0, 15, 5, 15, ((Block)TFBlocks.maze_stone.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, true, false);
        this.func_175804_a(world, sbb, 0, 0, 0, 15, 0, 15, ((Block)TFBlocks.maze_stone_mosaic.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_175804_a(world, sbb, 0, 1, 0, 15, 1, 15, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, true);
        this.func_175804_a(world, sbb, 0, 2, 0, 15, 3, 15, ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, true);
        this.func_175804_a(world, sbb, 0, 4, 0, 15, 4, 15, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, true);
        this.func_189914_a(world, sbb, rand, 0.2f, 0, 0, 0, 15, 5, 15, Blocks.field_150351_n.func_176223_P(), MazeUpperEntranceComponent.AIR, true, false);
        this.func_175804_a(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.field_180407_aO.func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_74878_a(world, sbb, 7, 1, 0, 8, 3, 0);
        this.func_175804_a(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.field_180407_aO.func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_74878_a(world, sbb, 7, 1, 15, 8, 3, 15);
        this.func_175804_a(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.field_180407_aO.func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_74878_a(world, sbb, 0, 1, 7, 0, 3, 8);
        this.func_175804_a(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.field_180407_aO.func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_74878_a(world, sbb, 15, 1, 7, 15, 3, 8);
        this.func_74878_a(world, sbb, 1, 1, 1, 14, 4, 14);
        this.func_175804_a(world, sbb, 5, 1, 5, 10, 1, 10, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_175804_a(world, sbb, 5, 4, 5, 10, 4, 10, ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P(), MazeUpperEntranceComponent.AIR, false);
        this.func_189914_a(world, sbb, rand, 0.7f, 5, 2, 5, 10, 3, 10, Blocks.field_150411_aY.func_176223_P(), MazeUpperEntranceComponent.AIR, false, false);
        this.func_74878_a(world, sbb, 6, 0, 6, 9, 4, 9);
        return true;
    }
    
    @Override
    protected int getAverageGroundLevel(final ISeedReader world, final ChunkGenerator generator, final MutableBoundingBox boundingBox) {
        int yTotal = 0;
        int count = 0;
        for (int z = this.field_74887_e.field_78896_c; z <= this.field_74887_e.field_78892_f; ++z) {
            for (int x = this.field_74887_e.field_78897_a; x <= this.field_74887_e.field_78893_d; ++x) {
                final BlockPos pos = new BlockPos(x, 64, z);
                if (boundingBox.func_175898_b((Vector3i)pos)) {
                    final BlockPos topPos = world.func_205770_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos);
                    yTotal += Math.max(topPos.func_177956_o(), generator.func_205470_d());
                    ++count;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        return yTotal / count;
    }
}
