// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerWingComponent;

public class IceTowerStairsComponent extends TowerWingComponent
{
    public IceTowerStairsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(IceTowerPieces.TFITSt, nbt);
    }
    
    public IceTowerStairsComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int size, final int height, final Direction direction) {
        super(IceTowerPieces.TFITSt, feature, index, x, y, z, size, height, direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 1; x < this.size; ++x) {
            this.placeStairs(world, sbb, x, 1 - x, 5);
            for (int z = 0; z <= x; ++z) {
                if (z > 0 && z <= this.size / 2) {
                    this.placeStairs(world, sbb, x, 1 - x, 5 - z);
                    this.placeStairs(world, sbb, x, 1 - x, 5 + z);
                }
                if (x <= this.size / 2) {
                    this.placeStairs(world, sbb, z, 1 - x, 5 - x);
                    this.placeStairs(world, sbb, z, 1 - x, 5 + x);
                }
            }
        }
        this.func_175811_a(world, this.deco.blockState, 0, 0, 5, sbb);
        return true;
    }
    
    private void placeStairs(final ISeedReader world, final MutableBoundingBox sbb, final int x, final int y, final int z) {
        if (this.func_175807_a((IBlockReader)world, x, y, z, sbb).func_185904_a().func_76222_j()) {
            this.func_175811_a(world, this.deco.blockState, x, y, z, sbb);
            this.func_175811_a(world, this.deco.blockState, x, y - 1, z, sbb);
        }
    }
}
