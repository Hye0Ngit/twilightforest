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
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleFoundation48Component extends TFStructureComponentOld
{
    public FinalCastleFoundation48Component(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCToF48, nbt);
    }
    
    public FinalCastleFoundation48Component(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower) {
        super(FinalCastlePieces.TFFCToF48, feature, i);
        this.func_186164_a(sideTower.func_186165_e());
        this.field_74887_e = new MutableBoundingBox(sideTower.func_74874_b().field_78897_a, sideTower.func_74874_b().field_78895_b, sideTower.func_74874_b().field_78896_c, sideTower.func_74874_b().field_78893_d, sideTower.func_74874_b().field_78895_b - 1, sideTower.func_74874_b().field_78892_f);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 4; x < 45; ++x) {
            for (int z = 4; z < 45; ++z) {
                this.func_175808_b(world, this.deco.blockState, x, -1, z, sbb);
            }
        }
        final int mid = 16;
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 3, -2, 3, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 2, -2, 1, 46, -1, 1, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 2, -4, 2, 45, -1, 2, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 4, -6, 3, 44, -1, 3, this.deco.blockState, rotation);
            for (int i = 9; i < 45; i += 6) {
                this.makePiling(world, sbb, mid, rotation, i);
            }
            this.makePiling(world, sbb, mid, rotation, 4);
            this.makePiling(world, sbb, mid, rotation, 44);
        }
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 21, -2, 0, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 21, -4, 1, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 21, -6, 2, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 27, -2, 0, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 27, -4, 1, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 27, -6, 2, Rotation.CLOCKWISE_90, sbb);
        return true;
    }
    
    private void makePiling(final ISeedReader world, final MutableBoundingBox sbb, final int mid, final Rotation rotation, final int i) {
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, i, -7, 3, rotation, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, i, -mid, 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, i, -1, 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, i, -3, 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, i, -5, 2, rotation, sbb);
    }
}
