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

public class TowerRoofSlabForwardsComponent extends TowerRoofSlabComponent
{
    public TowerRoofSlabForwardsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRSF, nbt);
    }
    
    public TowerRoofSlabForwardsComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(LichTowerPieces.TFLTRSF, feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState birchSlab = Blocks.field_196627_bs.func_176223_P();
        final BlockState birchDoubleSlab = (BlockState)Blocks.field_196627_bs.func_176223_P().func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)SlabType.DOUBLE);
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max - 1; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max - 1 || z == min || z == max) {
                        this.func_175811_a(world, birchSlab, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, birchDoubleSlab, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
