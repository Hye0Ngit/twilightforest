// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

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

public class TowerRoofFenceComponent extends TowerRoofComponent
{
    public TowerRoofFenceComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRF, nbt);
    }
    
    public TowerRoofFenceComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(LichTowerPieces.TFLTRF, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = 0;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int y = this.height + 1;
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
