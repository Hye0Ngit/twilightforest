// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleBellFoundation21Component extends FinalCastleFoundation13Component
{
    public FinalCastleBellFoundation21Component(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCBeF21, nbt);
    }
    
    public FinalCastleBellFoundation21Component(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower) {
        super(FinalCastlePieces.TFFCBeF21, feature, rand, i, sideTower);
        this.field_74887_e = new MutableBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e, sideTower.func_74874_b().field_78892_f + 2);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int mid = 16;
        final int low = 32;
        final int size = this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a;
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -mid, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -mid, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -low, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -low, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -low, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -low, 0, rotation, sbb);
            for (int x = 6; x < size - 3; x += 4) {
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -1, 1, rotation, sbb);
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -mid, 0, rotation, sbb);
            }
        }
        return true;
    }
}
