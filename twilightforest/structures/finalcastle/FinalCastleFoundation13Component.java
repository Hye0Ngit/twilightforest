// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.block.TFBlocks;
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
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.block.BlockState;
import java.util.function.Predicate;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleFoundation13Component extends TFStructureComponentOld
{
    protected int groundLevel;
    protected static final Predicate<BlockState> isDeadrock;
    
    public FinalCastleFoundation13Component(final TemplateManager manager, final CompoundNBT nbt) {
        this(FinalCastlePieces.TFFCToF13, nbt);
    }
    
    public FinalCastleFoundation13Component(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.groundLevel = -1;
    }
    
    public FinalCastleFoundation13Component(final IStructurePieceType type, final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower) {
        super(type, feature, i);
        this.groundLevel = -1;
        this.func_186164_a(sideTower.func_186165_e());
        this.field_74887_e = new MutableBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78895_b - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78895_b, sideTower.func_74874_b().field_78892_f + 2);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.groundLevel < 0) {
            this.groundLevel = this.findGroundLevel(world, sbb, 150, FinalCastleFoundation13Component.isDeadrock);
            if (this.groundLevel < 0) {
                return true;
            }
        }
        final int height = this.field_74887_e.field_78894_e - this.groundLevel;
        final int mid = height / 2;
        final int size = this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a;
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -mid, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -mid, 2, rotation, sbb);
            for (int x = 6; x < size - 3; x += 4) {
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -1, 1, rotation, sbb);
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -mid, 0, rotation, sbb);
            }
        }
        return true;
    }
    
    static {
        isDeadrock = (state -> state.func_177230_c() == TFBlocks.deadrock.get());
    }
}
