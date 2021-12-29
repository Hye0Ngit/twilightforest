// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
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

public class FinalCastleEntranceStairsComponent extends TFStructureComponentOld
{
    public FinalCastleEntranceStairsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCEnSt, nbt);
    }
    
    public FinalCastleEntranceStairsComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCEnSt, feature, index);
        this.func_186164_a(direction);
        this.field_74887_e = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -1, -5, 12, 0, 12, direction);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int size = 13, x = 1; x < size; ++x) {
            this.placeStairs(world, sbb, x, 1 - x, 5, Direction.EAST);
            for (int z = 0; z <= x; ++z) {
                if (z > 0 && z <= size / 2) {
                    this.placeStairs(world, sbb, x, 1 - x, 5 - z, Direction.EAST);
                    this.placeStairs(world, sbb, x, 1 - x, 5 + z, Direction.EAST);
                }
                if (x <= size / 2) {
                    this.placeStairs(world, sbb, z, 1 - x, 5 - x, Direction.NORTH);
                    this.placeStairs(world, sbb, z, 1 - x, 5 + x, Direction.SOUTH);
                }
            }
        }
        this.func_175808_b(world, this.deco.blockState, 0, 0, 5, sbb);
        return true;
    }
    
    private void placeStairs(final ISeedReader world, final MutableBoundingBox sbb, final int x, final int y, final int z, final Direction facing) {
        if (this.func_175807_a((IBlockReader)world, x, y, z, sbb).func_185904_a().func_76222_j()) {
            this.func_175811_a(world, (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)facing), x, y, z, sbb);
            this.func_175808_b(world, this.deco.blockState, x, y - 1, z, sbb);
        }
    }
}
