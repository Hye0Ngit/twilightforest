// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import net.minecraft.block.BlockState;
import twilightforest.util.RotationUtil;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
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

public class FinalCastleRoof48CrenellatedComponent extends TFStructureComponentOld
{
    public FinalCastleRoof48CrenellatedComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCRo48Cr, nbt);
    }
    
    public FinalCastleRoof48CrenellatedComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld keep) {
        super(FinalCastlePieces.TFFCRo48Cr, feature, i);
        final int height = 5;
        this.func_186164_a(keep.func_186165_e());
        this.field_74887_e = new MutableBoundingBox(keep.func_74874_b().field_78897_a - 2, keep.func_74874_b().field_78894_e - 1, keep.func_74874_b().field_78896_c - 2, keep.func_74874_b().field_78893_d + 2, keep.func_74874_b().field_78894_e + height - 1, keep.func_74874_b().field_78892_f + 2);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState castleMagic = ((Block)TFBlocks.castle_rune_brick_purple.get()).func_176223_P();
        this.func_175804_a(world, sbb, 2, 2, 2, 50, 2, 50, castleMagic, castleMagic, false);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 3, 1, 1, 45, 3, 1, this.deco.blockState, rotation);
            for (int i = 10; i < 41; i += 5) {
                this.fillBlocksRotated(world, sbb, i, 1, 0, i + 2, 5, 2, this.deco.blockState, rotation);
                this.setBlockStateRotated(world, this.deco.blockState, i + 1, 0, 1, rotation, sbb);
            }
        }
        return true;
    }
}
