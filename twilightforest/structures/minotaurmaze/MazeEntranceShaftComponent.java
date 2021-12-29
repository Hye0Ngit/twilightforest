// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.util.math.vector.Vector3i;
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

public class MazeEntranceShaftComponent extends TFStructureComponentOld
{
    private int averageGroundLevel;
    
    public MazeEntranceShaftComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMES, nbt);
        this.averageGroundLevel = -1;
    }
    
    public MazeEntranceShaftComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMES, feature, i);
        this.averageGroundLevel = -1;
        this.func_186164_a(Direction.Plane.HORIZONTAL.func_179518_a(rand));
        this.field_74887_e = new MutableBoundingBox(x, y, z, x + 6 - 1, y + 14, z + 6 - 1);
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, generator, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.field_74887_e.field_78894_e = this.averageGroundLevel;
            this.field_74887_e.field_78895_b = 21;
        }
        this.func_175804_a(world, sbb, 0, 0, 0, 5, this.field_74887_e.func_78882_c(), 5, ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P(), MazeEntranceShaftComponent.AIR, true);
        this.func_74878_a(world, sbb, 1, 0, 1, 4, this.field_74887_e.func_78882_c(), 4);
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
                    final BlockPos topBlock = world.func_205770_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos);
                    yTotal += Math.max(topBlock.func_177956_o(), generator.func_205470_d());
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
