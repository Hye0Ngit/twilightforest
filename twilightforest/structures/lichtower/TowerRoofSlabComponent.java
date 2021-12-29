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

public class TowerRoofSlabComponent extends TowerRoofComponent
{
    public TowerRoofSlabComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRS, nbt);
    }
    
    public TowerRoofSlabComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public TowerRoofSlabComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(piece, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return this.makePyramidCap(world, Blocks.field_196627_bs.func_176223_P(), Blocks.field_196666_p.func_176223_P(), sbb);
    }
    
    protected boolean makePyramidCap(final ISeedReader world, final BlockState slabType, final BlockState woodType, final MutableBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.func_175811_a(world, slabType, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, woodType, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final ISeedReader world, final BlockState slabType, final BlockState woodType, final MutableBoundingBox sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.func_175811_a(world, slabType, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, woodType, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
