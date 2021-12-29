// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerRoofPointyComponent extends TowerRoofComponent
{
    public TowerRoofPointyComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRP, nbt);
    }
    
    public TowerRoofPointyComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public TowerRoofPointyComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(piece, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = this.size;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.field_196627_bs.func_176223_P();
        final BlockState birchPlanks = Blocks.field_196666_p.func_176223_P();
        for (int y = 0; y <= this.height; ++y) {
            final int slopeChange = this.slopeChangeForSize();
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            final int mid = min + (max - min) / 2;
            for (int x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    if ((x == min && (z == min || z == max)) || (x == max && (z == min || z == max))) {
                        this.func_175811_a(world, birchSlab, x, y + 1, z, sbb);
                    }
                    if ((((x == min || x == max) && z == mid && x % 2 == 0) || ((z == min || z == max) && x == mid && z % 2 == 0)) && mid != min + 1) {
                        this.func_175811_a(world, birchSlab, x, y + 1, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    public int slopeChangeForSize() {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
