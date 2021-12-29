// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.Blocks;
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

public class MazeMoundComponent extends TFStructureComponentOld
{
    public static final int DIAMETER = 35;
    private int averageGroundLevel;
    private MazeUpperEntranceComponent mazeAbove;
    
    public MazeMoundComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMMound, nbt);
        this.averageGroundLevel = -1;
    }
    
    public MazeMoundComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMMound, feature, i);
        this.averageGroundLevel = -1;
        this.func_186164_a(Direction.Plane.HORIZONTAL.func_179518_a(rand));
        this.field_74887_e = new MutableBoundingBox(x, y, z, x + 35, y + 8, z + 35);
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(structurecomponent, (List)list, random);
        list.add(this.mazeAbove = new MazeUpperEntranceComponent(this.getFeatureType(), 3, random, this.field_74887_e.field_78897_a + 10, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 10));
        this.mazeAbove.func_74861_a(this, list, random);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, generator, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            final int offset = this.averageGroundLevel - this.field_74887_e.field_78894_e + 8 - 1;
            this.field_74887_e.func_78886_a(0, offset, 0);
            if (this.mazeAbove != null) {
                this.mazeAbove.func_74874_b().func_78886_a(0, offset, 0);
            }
        }
        for (int x = 0; x < 35; ++x) {
            for (int z = 0; z < 35; ++z) {
                final int cx = x - 17;
                final int cz = z - 17;
                final int dist = (int)Math.sqrt(cx * cx + cz * cz);
                final int hheight = (int)(Math.cos(dist / 35.0 * 3.141592653589793) * 11.0);
                if ((cx > 2 || cx < -1 || cz > 2 || cz < -1) && (((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) || hheight > 6)) {
                    this.func_175811_a(world, Blocks.field_196658_i.func_176223_P(), x, hheight, z, sbb);
                    if ((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) {
                        this.func_175811_a(world, Blocks.field_150346_d.func_176223_P(), x, hheight - 1, z, sbb);
                    }
                    else if (hheight > 6) {
                        this.func_175804_a(world, sbb, x, 6, z, x, hheight - 1, z, Blocks.field_150346_d.func_176223_P(), MazeMoundComponent.AIR, false);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    protected int getAverageGroundLevel(final ISeedReader world, final ChunkGenerator generator, final MutableBoundingBox boundingBox) {
        int totalHeight = 0;
        int totalMeasures = 0;
        for (int z = this.field_74887_e.field_78896_c; z <= this.field_74887_e.field_78892_f; ++z) {
            for (int x = this.field_74887_e.field_78897_a; x <= this.field_74887_e.field_78893_d; ++x) {
                final BlockPos pos = new BlockPos(x, 64, z);
                if (boundingBox.func_175898_b((Vector3i)pos)) {
                    final BlockPos topPos = world.func_205770_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos);
                    totalHeight += Math.max(topPos.func_177956_o(), generator.func_205470_d());
                    ++totalMeasures;
                }
            }
        }
        if (totalMeasures == 0) {
            return -1;
        }
        return totalHeight / totalMeasures;
    }
}
