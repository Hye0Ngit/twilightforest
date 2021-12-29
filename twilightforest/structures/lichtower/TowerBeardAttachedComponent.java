// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import twilightforest.structures.TFStructureComponentOld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerBeardAttachedComponent extends TowerBeardComponent
{
    public TowerBeardAttachedComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTBA, nbt);
    }
    
    public TowerBeardAttachedComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(LichTowerPieces.TFLTBA, feature, i, wing);
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78895_b - this.height - 1, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78895_b - 1, wing.func_74874_b().field_78892_f);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return this.makeAttachedBeard(world, rand, sbb);
    }
    
    private boolean makeAttachedBeard(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y + 1;
            final int max = this.size - y;
            this.func_74882_a(world, sbb, 0, this.height - y, min, max, this.height - y, max, false, rand, TFStructureComponentOld.getStrongholdStones());
        }
        return true;
    }
}
