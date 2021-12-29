// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.state.Property;
import net.minecraft.state.properties.SlabType;
import net.minecraft.block.SlabBlock;
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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerRoofGableForwardsComponent extends TowerRoofComponent
{
    public TowerRoofGableForwardsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRGF, nbt);
    }
    
    public TowerRoofGableForwardsComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(LichTowerPieces.TFLTRGF, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.field_196627_bs.func_176223_P();
        final BlockState birchPlanks = Blocks.field_196666_p.func_176223_P();
        final int slopeChange = this.slopeChangeForSize();
        for (int y = 0; y <= this.height; ++y) {
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
            for (int x = 0; x <= this.size - 2; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (z == min || z == max) {
                        this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    }
                    else if (x < this.size - 2) {
                        this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        final int top = this.size + 1 - slopeChange;
        final int zMid = this.size / 2;
        this.func_175811_a(world, (BlockState)birchSlab.func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)SlabType.TOP), this.size - 1, top - 1, zMid, sbb);
        this.func_175811_a(world, birchSlab, 0, top, zMid, sbb);
        this.func_175811_a(world, birchSlab, this.size - 3, top, zMid, sbb);
        this.func_175811_a(world, birchPlanks, this.size - 2, top, zMid, sbb);
        this.func_175811_a(world, birchPlanks, this.size - 1, top, zMid, sbb);
        this.func_175811_a(world, birchPlanks, this.size - 1, top + 1, zMid, sbb);
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
