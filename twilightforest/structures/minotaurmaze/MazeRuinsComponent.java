// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class MazeRuinsComponent extends TFStructureComponentOld
{
    public MazeRuinsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMRuins, nbt);
    }
    
    public MazeRuinsComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRuins, feature, i);
        this.func_186164_a(Direction.SOUTH);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y - 2, z, 0, 0, 0, 0, 0, 0, Direction.SOUTH);
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(structurecomponent, (List)list, random);
        final MinotaurMazeComponent maze = new MinotaurMazeComponent(this.getFeatureType(), 1, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 14, this.field_74887_e.field_78896_c, 1);
        list.add(maze);
        maze.func_74861_a(this, list, random);
        final MazeEntranceShaftComponent mazeEnter = new MazeEntranceShaftComponent(this.getFeatureType(), 2, random, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1);
        list.add(mazeEnter);
        mazeEnter.func_74861_a(this, list, random);
        final MazeMoundComponent mazeAbove = new MazeMoundComponent(this.getFeatureType(), 2, random, this.field_74887_e.field_78897_a - 14, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 14);
        list.add(mazeAbove);
        mazeAbove.func_74861_a(this, list, random);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return true;
    }
}
